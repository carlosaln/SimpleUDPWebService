package sandbox;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

public class FileStuff {
	public static void main(String[] args) throws Exception {
		File myFile = new File("test.txt");
		BufferedReader br = new BufferedReader(new FileReader(myFile));
		
		br.close();
	}
}
