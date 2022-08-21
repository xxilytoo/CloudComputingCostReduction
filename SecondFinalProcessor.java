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

public class SecondFinalProcessor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="C:\\Users\\kenha\\eclipse-workspace\\CS Summer 2022 Project\\src\\newvmtable2.csv";
		String path2 = "C:\\Users\\kenha\\eclipse-workspace\\CS Summer 2022 Project\\src\\subscriptions.csv";
		int wastedcnt = 0;
		String usID =  "test2.csv";
		 String line = "";
		 String line2 = "";
		try {
			 FileWriter fw = new FileWriter(usID,true);
			 BufferedWriter bw = new BufferedWriter(fw);
			 PrintWriter pw = new PrintWriter(bw);
			 BufferedReader br = new BufferedReader(new FileReader(path));
			 BufferedReader lr = new BufferedReader(new FileReader(path2));
			 out.println("Processing data");
			 ArrayList<String> subusers = new ArrayList<String>();
			 ArrayList<Integer> vmcount = new ArrayList<Integer>();
			while((line2 = lr.readLine()) != null) {
				String[] values2 = line2.split(",");
				subusers.add(values2[0]);
				
				vmcount.add(Integer.parseInt(values2[2]));
			}
			 //double comp = 1076.9113447295607;
			 ArrayList<ArrayList<String>> storage = new ArrayList<ArrayList<String>>();
			 ArrayList<String> userlist = new ArrayList<String>();
			 double totalsaved = 0;
			 boolean str = false; 
			 boolean go = false;
			while ((line = br.readLine()) != null ) {
				str = true;
				go = true;
				 String[] values = line.split(",");
				 ArrayList<String> temp = new ArrayList<String>();
					 for(int i = 0; i < values.length; i++) {
						 temp.add(values[i]);
					 }
					 double comp2 = Double.parseDouble(temp.get(11));
					 double p95 = Double.parseDouble(temp.get(6));
					 String user = temp.get(1);
					 //cpu comparison usage
					 //if(comp2 > 25 && p95 < 75)
					 
					 //vm cnt comparison 
					 int vmctcmp = 0;
					 for(int q = 0; q < subusers.size(); q++) {
						 if(temp.get(1).equals(subusers.get(q))) {
							  vmctcmp = vmcount.get(q);
						 }
					 }
					 if(vmctcmp >= 25 && p95 < 75 && comp2 > 75	){
							wastedcnt = wastedcnt +1;
							for(int p = 0; p < userlist.size(); p++) {
								if(user.equals(userlist.get(p))) {
									str = false;
								}
							}
							if(str) {
								userlist.add(user);
							}
							//p95 less than 25
							if(p95 < 25) {
								if(temp.get(8).equals(">24") && temp.get(9).equals(">64")) {
									temp.add(Integer.toString(8));
									temp.add(Integer.toString(8));
									double svedcostphr = (.0006*24) + (0.024*64) -4.44089e-16;
									double savedcost = Double.parseDouble(temp.get(10))-(svedcostphr*Double.parseDouble(temp.get(3)));
									temp.add(Double.toString(savedcost));
									totalsaved = savedcost + totalsaved;
								}
								
								else {
									int tempcore = Integer.parseInt(temp.get(8));
									if(tempcore == 24) {
										tempcore = 4;
									}
								
									else {
										tempcore = 2;
									}
									temp.add(Integer.toString(tempcore));
									int tempmem = Integer.parseInt(temp.get(9));
									if(tempmem == 64) {
										tempmem = 4;
									}
									else {
										tempmem = 2;
									}
									temp.add(Integer.toString(tempmem));
									double svedcostphr = (.0006*tempcore) + (0.024*tempmem) -4.44089e-16;
									double savedcost = Double.parseDouble(temp.get(10))-(svedcostphr*Double.parseDouble(temp.get(3)));
									temp.add(Double.toString(savedcost));
									totalsaved = savedcost + totalsaved;
							}
							}
							//p95 less than 50
							else if(p95 < 50) {
								if(temp.get(8).equals(">24") && temp.get(9).equals(">64")) {
									temp.add(Integer.toString(12));
									temp.add(Integer.toString(32));
									double svedcostphr = (.0006*12) + (0.024*32) -4.44089e-16;
									double savedcost = Double.parseDouble(temp.get(10))-(svedcostphr*Double.parseDouble(temp.get(3)));
									temp.add(Double.toString(savedcost));
									totalsaved = savedcost + totalsaved;
								}
								
								else {
									int tempcore = Integer.parseInt(temp.get(8));
									if(tempcore == 24) {
										tempcore = 8;
									}
									else if(tempcore == 12) {
										tempcore = 4;
									}
									else if(tempcore == 8) {
										tempcore = 2;
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
										tempmem = 8;
									}
									else if(tempmem == 32) {
										tempmem = 4;
									}
									else if(tempmem == 8) {
										tempmem = 2;
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
									totalsaved = savedcost + totalsaved;
							}
							}
							//p95 less than 75
							else {
							if(temp.get(8).equals(">24") && temp.get(9).equals(">64")) {
								temp.add(Integer.toString(24));
								temp.add(Integer.toString(64));
								double svedcostphr = (.0006*24) + (0.024*64) -4.44089e-16;
								double savedcost = Double.parseDouble(temp.get(10))-(svedcostphr*Double.parseDouble(temp.get(3)));
								temp.add(Double.toString(savedcost));
								totalsaved = savedcost + totalsaved;
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
								totalsaved = savedcost + totalsaved;
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
				 
				 
							
							
						
					
					 }
				 	
				 	
				 	out.println("wasted machines " + wastedcnt);
				 	out.println("users affected " + userlist.size());
				 	out.println("total cost saved " + totalsaved);
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

