package ui;

import java.util.List;

import dal.ReadFile;

public class App {
	public static void main(String[] args) {

		String filePath = "input.txt";

		List<String> allLines = ReadFile.readLineByLine(filePath);

		allLines.stream().forEach(line -> System.out.println(line));
	}
}
