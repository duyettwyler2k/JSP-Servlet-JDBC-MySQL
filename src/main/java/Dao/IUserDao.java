package Dao;

import model.user;

import java.util.List;

public interface IUserDao {
    public List<user> selectAllUsers();
    public void insertUser(user user);
    public boolean updateUser(user user);
    public boolean deleteUser(int id);
}
