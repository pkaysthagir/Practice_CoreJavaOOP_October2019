package datareader;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadData {
	
	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader bf = null;
		String strFileName = "../Practice_CoreJavaOOP_October2019/src/datareader/Sample.txt";
		
		try {
			fr = new FileReader(strFileName);
			bf = new BufferedReader(fr);
			String data;
			while ((data = bf.readLine()) != null) {
				System.out.println(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("File was not found");
		}finally {
			try {
				bf.close();
				fr.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
