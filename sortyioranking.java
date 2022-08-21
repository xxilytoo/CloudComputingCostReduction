import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class sortyioranking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="C:\\Users\\kenha\\eclipse-workspace\\CS Summer 2022 Project\\src\\newvmtable2.csv";
		 String line = "";
		try {
			 FileWriter fw = new FileWriter("sortyioranking2.csv",true);
			 BufferedWriter bw = new BufferedWriter(fw);
			 PrintWriter pw = new PrintWriter(bw);
			 FileWriter gw = new FileWriter("sortyioranking1.csv",true);
			 BufferedWriter cw = new BufferedWriter(gw);
			 PrintWriter hw = new PrintWriter(cw);
			 BufferedReader br = new BufferedReader(new FileReader(path));
			 out.println("Processing data");
			 List<List<String>> csvLines = new ArrayList<>();
			 String cvsSplitBy = ",";
			while ((line = br.readLine()) != null ) {
				csvLines.add(Arrays.asList(line.split(cvsSplitBy)));
				 }
			for(int b = 0; b < csvLines.size(); b++) {
				List<String> print = new ArrayList<String>();
				print = csvLines.get(b);
				for(int c = 0; c < print.size(); c++) {
					if(c == print.size()-1) {
						hw.print(print.get(c));
					}
					else {
						hw.print(print.get(c)+ ",");
					}
				}
				hw.println();
			}
			csvLines.sort(new Comparator<List<String>>() {
	            @Override
	            public int compare(List<String> o1, List<String> o2) {
	            	
	                return o2.get(11).compareTo(o1.get(11));
	            }
	        });
			for(int j = 0; j < csvLines.size(); j++) {
				List<String> print = new ArrayList<String>();
				print = csvLines.get(j);
				for(int k = 0; k < print.size(); k++) {
					if(k == print.size()-1) {
						pw.print(print.get(k));
					}
					else {
						pw.print(print.get(k)+ ",");
					}
				}
				pw.println();
			}
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
