package Dao;

import model.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements IUserDao {
    public static final String INSERT_NEW_USER = "insert into users(name,email,country) values(?,?,?)";
    public static final String SELECT_ALL_USER = "select*from users";
    public static final String UPDATE_USER = "update users set name=?, email=?,country=? where id=?";
    public static final String DELETE_USER="delete from users where id=?";

    @Override
    public List<user> selectAllUsers() {
        List<user> users = new ArrayList<>();
        Connection connection = SQLConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                users.add(new user(id, name, email, country));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }

    @Override
    public void insertUser(user user) {
        Connection connection = SQLConnection.getConnection();
        int rowInserted = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_USER);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            rowInserted = preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean updateUser(user user) {
        Connection connection = SQLConnection.getConnection();
        int rowUpdate = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.setInt(4,user.getId());
            rowUpdate = preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return rowUpdate!=0;
    }

    @Override
    public boolean deleteUser(int id) {
        Connection connection=SQLConnection.getConnection();
        int rowDelete=0;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(DELETE_USER);
            preparedStatement.setInt(1,id);
            rowDelete=preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDelete!=0;
    }
}
