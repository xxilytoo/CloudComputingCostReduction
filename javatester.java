import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.zip.GZIPInputStream;
public class javatester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="C:\\Users\\kenha\\eclipse-workspace\\CS Summer 2022 Project\\src\\sortyioranking2.csv";
		 String line = "";
		try {
			 FileWriter fw = new FileWriter("selecteddata.txt",true);
			 BufferedWriter bw = new BufferedWriter(fw);
			 PrintWriter pw = new PrintWriter(bw);
			 BufferedReader br = new BufferedReader(new FileReader(path));
			 out.println("Processing data");
			 int cnt = 0;
			while ((line = br.readLine()) != null ) {
				 String[] values = line.split(",");
				 cnt = cnt +1;
				 if(cnt == 1000) {
					 out.println("The one thousadth ranked greatest waste is" + values[11]);
				 }
				 
				 }
			
			
			
			out.println(cnt);
			 out.println("finished processing");
	}
			catch (FileNotFoundException e) {
				 e.printStackTrace();
			 } 
			 catch (IOException e) {
				 e.printStackTrace();
			 }
	}

}
