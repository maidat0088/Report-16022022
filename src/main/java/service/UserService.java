package service;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import common.Constant;
import dal.ReadFile;
import model.User;

public class UserService {

	ObjectMapper objectMapper = Constant.objectMapper;

	String filePath = "input.txt";

	/**
	 * Get all users objects.
	 */
	public List<User> getUserList() {
		List<User> userList = new ArrayList<User>();

		List<String> allLines = ReadFile.readLineByLine(filePath);

		allLines.stream().forEach(line -> {
			String formatLine = removeApostrophes(line);
			User user;
			try {
				user = objectMapper.readValue(formatLine, User.class);
				userList.add(user);
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		});

		return userList;
	}

	/**
	 * Remove the apostrophes in line.
	 * 
	 * @param line contains apostrophes.
	 * @return line removed apostrophes.
	 */
	private String removeApostrophes(String line) {
		return line.replace("'", "");
	}

}
