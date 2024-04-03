package org.example.main.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.example.main.config.Config;
import org.example.main.model.Friend;
import org.example.main.model.Post;
import org.example.main.model.User;
import org.example.main.service.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// TODO: 27.06.2023
//  Здесь ты должен реализовать весь CRUD
//  (create -save,
//  read - findById || getAll,
//  update - update,
//  delete - delete) и дополнительные методы!!!
public class UserService implements Service<User> {

//    public User followYou(int friendId) {
//        return null;
//    }
//
//    public List<Friend> getAllFriends() {
//        return null;
//    }
//
//    public Post sendLike(int postId) {
//        return null;
//    }
//
//    public List<Post> getNewPosts() {
//        return null;
//    }
//
//    public Post getPopularPost() {
//        return null;
//    }

    @Override
    public void createTable() {
        String query = """
                CREATE TABLE IF NOT EXISTS users(
                id SERIAL PRIMARY KEY,
                name VARCHAR NOT NULL,
                last_name VARCHAR NOT NULL,
                email VARCHAR NOT NULL,
                age INT NOT NULL,
                address VARCHAR NOT NULL,
                friend_id INT NOT NULL
                );
                """;

        try (Connection connection = Config.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute(query);
            System.out.println("Table added");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void save(User user) {
        String query = """
                INSERT INTO users(name,last_name,email,age,address,friend_id)
                VALUES (?,?,?,?,?,?)
                """;
        try (Connection connection = Config.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLast_name());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setInt(4, user.getAge());
            preparedStatement.setString(5, user.getAddress());
            preparedStatement.setInt(6, user.getFriend_id());
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public User findById(int id) {
        String query = """
                SELECT * FROM users WHERE id = ?;
                """;
        User user = new User();
        try (Connection connection = Config.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setLast_name(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));
                user.setAge(resultSet.getInt("age"));
                user.setAddress(resultSet.getString("address"));
                user.setFriend_id(resultSet.getInt("friend_id"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    @Override
    public void update(int id, User user) {
        String query = """
                UPDATE users SET name = ?,last_name = ?,
                email = ?,age = ?,address = ?,friend_id = ? WHERE id = ?;
                """;
        try (Connection connection = Config.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLast_name());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setInt(4, user.getAge());
            preparedStatement.setString(5, user.getAddress());
            preparedStatement.setInt(6, user.getFriend_id());
            preparedStatement.setInt(7, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<User> getAll() {
        String query = "SELECT * FROM users";
        List<User> usersList = new ArrayList<>();
        try (Connection connection = Config.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setLast_name(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));
                user.setAge(resultSet.getInt("age"));
                user.setAddress(resultSet.getString("address"));
                user.setFriend_id(resultSet.getInt("friend_id"));
                usersList.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return usersList;
    }

    @Override
    public void deleteById(int id) {
String query ="DELETE FROM users WHERE  id = ?";
try(Connection connection = Config.getConnection()){
    PreparedStatement preparedStatement = connection.prepareStatement(query);
    preparedStatement.setInt(1,id);
    preparedStatement.execute();

}catch (SQLException e ){
    System.out.println(e.getMessage());
}
    }
}
