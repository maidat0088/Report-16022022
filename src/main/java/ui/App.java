package ui;

import java.util.List;

import model.User;
import service.UserService;

public class App {

	public static void main(String[] args) {

		UserService userService = new UserService();

		List<User> userList = userService.getUserList();

		userList.stream().forEach(user -> System.out.println(user));
	}
}
