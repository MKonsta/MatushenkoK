package ru.job4j.servlets.webarchitecturejsp.logic;

import org.apache.commons.dbcp2.BasicDataSource;
import ru.job4j.servlets.webarchitecturejsp.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBStore implements AutoCloseable, Store {
    private static final BasicDataSource SOURCE = new BasicDataSource();
    private static final DBStore INSTANCE = new DBStore();

    public DBStore() {
        SOURCE.setDriverClassName("org.postgresql.Driver");
        SOURCE.setUrl("jdbc:postgresql://localhost:5432/userstore");
        SOURCE.setUsername("postgres");
        SOURCE.setPassword("kozemir");
        SOURCE.setMinIdle(5);
        SOURCE.setMaxIdle(10);
        SOURCE.setMaxOpenPreparedStatements(100);
    }

    public static DBStore getInstance() {
        try (Connection connection = SOURCE.getConnection();
             Statement statement = connection.createStatement()){
            String sqlCreateTable = "create table if not exists users("
                    + " id serial primary key,"
                    + " name varchar(30) not null,"
                    + " login varchar(30) unique,"
                    + " password varchar(30) unique,"
                    + " email varchar(30) unique,"
                    + " createdate varchar(30)),"
                    + " role varchar(30));";
            statement.executeUpdate(sqlCreateTable);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return INSTANCE;
    }

    public boolean addUser(User user) {

        try (Connection connection = SOURCE.getConnection()){
            String sql = "insert into users (name, login, password, email, createdate, role) values(?, ?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getCreateDate());
            preparedStatement.setString(6, user.getRole());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateUser(int id, User user) {
        try (Connection connection = SOURCE.getConnection()) {
            String sql = "update users set name = ?, login = ?, password = ?, email = ?, createdate = ?, role = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getCreateDate());
            preparedStatement.setString(6, user.getRole());
            preparedStatement.setInt(7, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteUser(int id) {
        try (Connection connection = SOURCE.getConnection()) {
            String sql = "delete from users where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<User> findAll() {
        List<User> result = new ArrayList<>();
        try (Connection connection = SOURCE.getConnection()) {
            String sql = "select * from users;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String login = resultSet.getString(3);
                String password = resultSet.getString(4);
                String email = resultSet.getString(5);
                String createDate = resultSet.getString(6);
                String role = resultSet.getString(7);
                User user = new User(name, login, password, email, createDate, role);
                user.setId(id);
                result.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public User findById(int id) {
        User resultUser = null;
        try (Connection connection = SOURCE.getConnection()){
            String sql ="select * from users where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int userId = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String login = resultSet.getString(3);
                String password = resultSet.getString(4);
                String email = resultSet.getString(5);
                String date = resultSet.getString(6);
                String role = resultSet.getString(7);
                resultUser = new User(name, login, password, email, date, role);
                resultUser.setId(userId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultUser;
    }

    public static void main(String[] args) {
//        DBStore.getInstance().addUser(new User("Ivan", "vano", "www@ddd", "dddd"));
//        DBStore.getInstance().addUser(new User("Stepan", "step", "ggg@", "ggg"));
//        DBStore.getInstance().updateUser(2, new User("Stepan", "stepuha", "ggg@", "ggg"));
        System.out.println(DBStore.getInstance().deleteUser(2));
    }

    @Override
    public void close() throws Exception {
        SOURCE.close();
    }
}
