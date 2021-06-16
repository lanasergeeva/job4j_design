package ru.job4j.jdbc.cities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrepareStatementDemo {
    private Connection connection;

    public PrepareStatementDemo() throws Exception {
        initConnection();
    }

    public void initConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/idea_db";
        String login = "postgres";
        String password = "lana90max";
        connection = DriverManager.getConnection(url, login, password);
    }

/*    public void insertWithouId(City city) {
        try (PreparedStatement statement =
                     connection.prepareStatement("insert into cities(name, population) values (?, ?)")) {
            statement.setString(1, city.getName());
            statement.setInt(2, city.getPopulation());
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    public boolean update(City city) {
        boolean result = false;
        try (PreparedStatement statement =
                     connection.prepareStatement("update cities set name = ?, population = ? where id = ?")) {
            statement.setString(1, city.getName());
            statement.setInt(2, city.getPopulation());
            statement.setInt(3, city.getId());
            result = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean delete(int id) {
        boolean result = false;
        try (PreparedStatement statement =
                     connection.prepareStatement("delete from cities where id = ?")) {
            statement.setInt(1, id);
            result = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<City> findAll(String tableName) {
        List<City> cities = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement((String.format("select * from %s", tableName)))) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    cities.add(new City(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getInt("population")
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cities;
    }

    public City insert(City city, String nameTab) {
        try (PreparedStatement statement =
                     connection.prepareStatement((String.format("insert into %s(name, population) values (?, ?)", nameTab)),
                             Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, city.getName());
            statement.setInt(2, city.getPopulation());
            statement.execute();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    city.setId(generatedKeys.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return city;
    }

    public void createTabCities(String...values) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "create table  %s (%s, %s, %s);",
                    values
            );
            statement.execute(sql);
        }
    }

    public void deleteTabCities(String tableName) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format("drop table %s;",  tableName
            );
            statement.execute(sql);
        }
    }

    public static void main(String[] args) throws Exception {
        City one = new City(44, "Kyev", 4500000);
        City two = new City(652, "Simferopol", 500000);
        City two3 = new City(2, "Kerch", 250000);
        PrepareStatementDemo pr = new PrepareStatementDemo();
        //pr.createTabCities("citiesBest", "id serial primary key", "name text", "population int");
       /* System.out.println(pr.insert(one, "citiesBest"));
        System.out.println(pr.insert(two, "citiesBest"));
        System.out.println(pr.insert(two3, "citiesBest"));*/
       /* City one = new City(44, "Kyev", 4500000);
        City two = new City(652, "Simferopol", 500000);
        System.out.println(pr.insert(two, "cities"));
        City two3 = new City(2, "Kerch", 250000);
        System.out.println(pr.update(two3));*/
        System.out.println(pr.findAll("citiesBest"));
    }
}

    /*public static void main(String[] args) throws Exception {
        String o = "uy";
        try (Connection connection = getConnection()) {
            try (Statement statement = connection.createStatement()) {
                String sql = String.format(
                        "create table  %s (%s, %s);",
                        o,
                        "id serial primary key",
                        "name text",
                        "population int"
                );
                statement.execute(sql);
                System.out.println(getTableScheme(connection, o));
            }
        }
    }*/
