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
import java.util.zip.GZIPInputStream;

import static java.lang.System.*;
public class processing {
 public static void main(String[] args) {
	 String path="C:\\Users\\kenha\\eclipse-workspace\\CS Summer 2022 Project\\src\\vmtable.csv";
	 String line = "";
	 try {
		 FileWriter fw = new FileWriter("newvmtable2.csv",true);
		 BufferedWriter bw = new BufferedWriter(fw);
		 PrintWriter pw = new PrintWriter(bw);
		 BufferedReader br = new BufferedReader(new FileReader(path));
		 out.println("Processing data");
		 while ((line = br.readLine()) != null ) {
			 
			 //line = br.readLine();
			 String[] values = line.split(","); 
			 double endtime = Integer.parseInt(values[4]);
			 double starttime = Integer.parseInt(values[3]);
			 double time = ((endtime - starttime)/3600);
			 
			 double corect = 0; 
			 if(values[9].equals(">24")) {
				 corect = 32;
			 }
			 else {
			 Integer.parseInt(values[9]);
			 }
			 double memory = 0;
			 if(values[10].equals(">64")) {
				 memory = 128;
			 }
			 else {
				 memory = Integer.parseInt(values[10]);
			 }
			 double costperhr = (.0006*corect) + (0.024*memory) -4.44089e-16;
			 double cost = time*costperhr;
			 String add = Double.toString(cost);
			 String[] newvalues = new String[values.length+1];
			 for(int j = 0; j < newvalues.length-2; j++) {
				 if(j == 3) {
					 newvalues[j] = Double.toString(time);
				 }
				 else if(j > 3) {
					 newvalues[j] = values[j+1];
				 }
				 else {
					 newvalues[j] = values[j];
				 }
			 }
			newvalues[newvalues.length-2] = Double.toString(cost);
			double urrate = Double.parseDouble(values[6]);
			newvalues[newvalues.length-1] = Double.toString((1- urrate/100)*cost);
			for(int i = 0; i < newvalues.length; i++) {
				if(i != newvalues.length-1) {
				pw.print(newvalues[i] + ",");
				}
				else {
					pw.print(newvalues[i]);
				}
			 
			 }
			pw.println();
			
			
		 }
		 pw.flush();
		 pw.close();
		 out.println("Processing Finished");
	 } catch (FileNotFoundException e) {
		 e.printStackTrace();
	 } catch (IOException e) {
		 e.printStackTrace();
	 }
	 
 	}
 
 
 public static String[] add_element(String myarray[], String ele, double hours) 
 { 
      

      String newArray[] = new String[myarray.length+1]; 
     //copy original array into new arr
     int k = 0;
     while(k < myarray.length-1) {
    	 
    	 if((k > 3 || k == 4) && k != 11) {
    		 
    		 if(k == 10) {
    		 newArray[10] = myarray[10];
    		 }
    		 else {
    		 newArray[k] = myarray[k+1];
    		 }
    	 }
    	 
    	 if(k==3) {
    		 newArray[k] = Double.toString(hours);
    	 }
    	 else {
    		 if(k==4) {
    			 newArray[k] = myarray[k+1];
    		 }
    		 else {
    		 newArray[k] = myarray[k];
    		 }
    	 }
    	 k = k+1;
     }
     //add element to the new array
     newArray[newArray.length-1] = ele; 

     return newArray; 
 } 
}
 

