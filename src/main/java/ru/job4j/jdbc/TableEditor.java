package ru.job4j.jdbc;
import ru.job4j.io.Config;

import java.sql.*;
import java.util.Properties;

public class TableEditor implements AutoCloseable {
    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) throws Exception {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws Exception {
        Class.forName(properties.getProperty("driver_class"));
        String url = properties.getProperty("url");
        String login = properties.getProperty("username");
        String password = properties.getProperty("password");
        connection = DriverManager.getConnection(url, login, password);
    }

    public void ddl(String argument) throws Exception {
            try (Statement statement = connection.createStatement()) {
                statement.execute(argument);
            }
    }

    private static Connection getConnection() throws Exception {
        Config config = new Config("./src/main/resources/app.properties");
        config.load();
        Class.forName(config.value("driver_class"));
        String url = config.value("url");
        String login = config.value("username");
        String password = config.value("password");
        return DriverManager.getConnection(url, login, password);
    }

    public void createTable(String tableName) throws Exception {
        ddl(String.format("create table %s (id serial primary key);",  tableName));
    }

    public void dropTable(String tableName) throws Exception {
        ddl(String.format("drop table %s;",  tableName));
    }

    public void addColumn(String tableName, String columnName, String type) throws Exception {
        ddl(String.format("alter table %s add %s %s;",  tableName, columnName, type));
    }

    public void dropColumn(String tableName, String columnName) throws Exception {
        ddl(String.format("alter table %s drop column %s;",  tableName, columnName));
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws Exception {
        ddl(String.format("alter table %s rename column %s  to %s;",  tableName, columnName, newColumnName));
    }

    public String getScheme(String tableName) throws SQLException {
        StringBuilder scheme = new StringBuilder();
        DatabaseMetaData metaData = connection.getMetaData();
        try (ResultSet columns = metaData.getColumns(null, null, tableName, null)) {
            scheme.append(String.format("%-15s %-15s%n", "column", "type"));
            while (columns.next()) {
                scheme.append(String.format("%-15s %-15s%n",
                        columns.getString("COLUMN_NAME"),
                        columns.getString("TYPE_NAME")));
            }
        }
        return scheme.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}
