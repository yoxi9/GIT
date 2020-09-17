package dao;

import java.util.List;

import entity.User;

public interface UserDao {
	int add(User user);
	List<User> getUser(User user);

}
