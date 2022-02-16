package dal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

	/**
	 * Read file line by line with UTF-8 Charset.
	 * 
	 * @param filePath Path of file.
	 * @return List contains all lines in file.
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static List<String> readLineByLine(String filePath) {
		List<String> stringList = new ArrayList<String>();
		String curentLine = null;
		try (BufferedReader br = new BufferedReader(new FileReader(filePath, StandardCharsets.UTF_8))) {
			while ((curentLine = br.readLine()) != null) {
				stringList.add(curentLine);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stringList;
	}
}
