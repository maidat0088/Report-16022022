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
		String currentLine = null;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filePath, StandardCharsets.UTF_8));
			while ((currentLine = br.readLine()) != null) {
				stringList.add(currentLine);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return stringList;
	}
}
