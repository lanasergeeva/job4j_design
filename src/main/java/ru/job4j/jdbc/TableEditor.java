package ru.job4j.jdbc;


import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

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

    public void createTable(String tableName) throws Exception {
        ddl(String.format("create table %s (id serial primary key);", tableName));
    }

    public void dropTable(String tableName) throws Exception {
        ddl(String.format("drop table %s;", tableName));
    }

    public void addColumn(String tableName, String columnName, String type) throws Exception {
        ddl(String.format("alter table %s add %s %s;", tableName, columnName, type));
    }

    public void dropColumn(String tableName, String columnName) throws Exception {
        ddl(String.format("alter table %s drop column %s;", tableName, columnName));
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws Exception {
        ddl(String.format("alter table %s rename column %s  to %s;", tableName, columnName, newColumnName));
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
            System.out.println("ЗАКРЫЛИСЬ");
            connection.close();
        }
    }

    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    public Connection getConnection() {
        return connection;
    }

    public static void main(String[] args) throws Exception {
        Path fileProperties = Paths.get(
                String.format("src%1$smain%1$sresources%1$sapp.properties", File.separator)
        );
        Properties properties = new Properties();
        try (var fr = new FileReader(fileProperties.toFile())) {
            properties.load(fr);
        }
        try (TableEditor tblEditor = new TableEditor(properties)) {
            String tName = "newtable";
            String cName = "newcolumn";
            String rName = "rename";
            String type = "VARCHAR(255) NOT NULL";
            tblEditor.createTable(tName);
            System.out.println(getTableScheme(tblEditor.getConnection(), tName));
            tblEditor.dropTable("newtable");
            System.out.println("Create table");
            tblEditor.createTable(tName);
            System.out.println("Add column:");
            tblEditor.addColumn(tName, cName, type);
            System.out.println(getTableScheme(tblEditor.getConnection(), tName));
            System.out.println("Rename column:");
            tblEditor.renameColumn(tName, cName, rName);
            System.out.println(getTableScheme(tblEditor.getConnection(), tName));
            System.out.println("Drop column:");
            tblEditor.dropColumn(tName, rName);
            System.out.println(getTableScheme(tblEditor.getConnection(), tName));
            System.out.println("Drop table:");
            tblEditor.dropTable("newtable");
        }
    }
}
