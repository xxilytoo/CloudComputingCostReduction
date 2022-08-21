import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FinalProcessor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		out.println("What user would you like to analyze");
		String path="C:\\Users\\kenha\\eclipse-workspace\\CS Summer 2022 Project\\src\\newvmtable2.csv";
		String ID = input.next();
		int wastedcnt = 0;
		String usID =  "data.csv";
		 String line = "";
		try {
			 FileWriter fw = new FileWriter(usID,true);
			 BufferedWriter bw = new BufferedWriter(fw);
			 PrintWriter pw = new PrintWriter(bw);
			 BufferedReader br = new BufferedReader(new FileReader(path));
			 out.println("Processing data");
			 int cnt = 0;
			 double comp = 1076.9113447295607;
			 ArrayList<ArrayList<String>> storage = new ArrayList<ArrayList<String>>();
			 
			while ((line = br.readLine()) != null ) {
				 String[] values = line.split(",");
				 if(values[1].equals(ID)) {
					 ArrayList<String> store = new ArrayList<String>();
					 for(int i = 0; i < values.length; i++) {
						 store.add(values[i]);
					 }
					 storage.add(store);
					 cnt = cnt+1;
				 }
				 
				 
				 }
				 
				 for(int j = 0; j < storage.size(); j++) {
					 /*if(cnt < 100) {
						 out.println("User has less than 100 vm operated");
						 break;
					 }*/
					 ArrayList<String> temp = new ArrayList<String>();
					 temp = storage.get(j);
					 double comp2 = Double.parseDouble(temp.get(11));
					 
					 double p95 = Double.parseDouble(temp.get(6));
					 
					 if(comp2>comp && p95 > 75) {
							wastedcnt = wastedcnt +1;
							if(temp.get(8).equals(">24") && temp.get(9).equals(">64")) {
								temp.add(Integer.toString(24));
								temp.add(Integer.toString(64));
								double svedcostphr = (.0006*24) + (0.024*64) -4.44089e-16;
								double savedcost = Double.parseDouble(temp.get(10))-(svedcostphr*Double.parseDouble(temp.get(3)));
								temp.add(Double.toString(savedcost));
							}
							else {
								int tempcore = Integer.parseInt(temp.get(8));
								if(tempcore == 24) {
									tempcore = 12;
								}
								else if(tempcore == 12) {
									tempcore = 8;
								}
								else if(tempcore == 8) {
									tempcore = 4;
								}
								else if(tempcore == 4) {
									tempcore = 2;
								}
								else {
									tempcore = 2;
								}
								temp.add(Integer.toString(tempcore));
								int tempmem = Integer.parseInt(temp.get(9));
								if(tempmem == 64) {
									tempmem = 32;
								}
								else if(tempmem == 32) {
									tempmem = 8;
								}
								else if(tempmem == 8) {
									tempmem = 4;
								}
								else if(tempmem == 4) {
									tempmem = 2;
								}
								else {
									tempmem = 2;
								}
								temp.add(Integer.toString(tempmem));
								double svedcostphr = (.0006*tempcore) + (0.024*tempmem) -4.44089e-16;
								double savedcost = Double.parseDouble(temp.get(10))-(svedcostphr*Double.parseDouble(temp.get(3)));
								temp.add(Double.toString(savedcost));
							}
					 }
							for(int b = 0; b < temp.size(); b++) {
								
								if(b == temp.size()-1) {
									pw.print(temp.get(b));
								}
								else {
								pw.print(temp.get(b)+",");
								}
							}
						 pw.println();
					 
							
							
						
					
					 }
				 	out.println("machines " + cnt);
				 	
				 	out.println("wasted machines " + wastedcnt);
				 	pw.flush();
					 pw.close();
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
