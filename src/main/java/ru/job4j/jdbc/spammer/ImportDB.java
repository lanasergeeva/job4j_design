package ru.job4j.jdbc.spammer;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ImportDB {
    private Properties cfg;
    private String dump;

    public ImportDB(Properties cfg, String dump) {
        this.cfg = cfg;
        this.dump = dump;
    }

    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new FileReader(dump))) {
            rd.lines().forEach(line -> {
                line = new StringBuilder(line).deleteCharAt(line.lastIndexOf(";")).toString();
                String[] array = line.split(";", 2);
                if (array[1].isEmpty()) {
                    throw new IllegalArgumentException();
                } else {
                    users.add(new User(array[0], array[1]));
                }
            });
        }
        return users;
    }

    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName(cfg.getProperty("jdbc.driver"));
        try (Connection cnt = DriverManager.getConnection(
                cfg.getProperty("jdbc.url"),
                cfg.getProperty("jdbc.username"),
                cfg.getProperty("jdbc.password")
        )) {
            for (User user : users) {
                try (PreparedStatement ps = cnt.prepareStatement("insert into users (name, email) values(?, ?)")) {
                    ps.setString(1, user.getName());
                    ps.setString(2, user.getEmail());
                    ps.execute();
                }
            }
        }
    }

    /**
     * У меня был уже готовый метод. Поэтому я сюда просто скопировала и добавила ресурсы.
     * @param values varags
     * @throws SQLException ошибка
     * @throws ClassNotFoundException ошибка
     */
    public void createTab(String... values) throws SQLException, ClassNotFoundException {
        Class.forName(cfg.getProperty("jdbc.driver"));
        try (Connection cnt = DriverManager.getConnection(
                cfg.getProperty("jdbc.url"),
                cfg.getProperty("jdbc.username"),
                cfg.getProperty("jdbc.password")
        )) {
            try (Statement statement = cnt.createStatement()) {
                String sql = String.format(
                        "create table  %s (%s, %s);",
                        values
                );
                statement.execute(sql);
            }
        }
    }

    private static class User {
        String name;
        String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }
    }


    public static void main(String[] args) throws Exception {
        Properties cfg = new Properties();
        try (FileInputStream in = new FileInputStream("./src/main/java/ru/job4j/jdbc/spammer/app.properties")) {
            cfg.load(in);
        }
        ImportDB db = new ImportDB(cfg, "./src/main/java/ru/job4j/jdbc/spammer/dump.txt");
        //db.createTab("users", "name varchar(50)", "email varchar(50)");
        db.save(db.load());
    }
}
