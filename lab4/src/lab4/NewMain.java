package lab4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NewMain {

	public static void main(String[] args) throws IOException 
   {	// TODO Auto-generated method stub
		
		List<List<String>> records = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("data.csv"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[]values = line.split(",");
		        records.add(Arrays.asList(values));
		    }
		
		    String[] array2 = new String[8000];
		    System.out.println(records.size());     
	    int index=0;
	        for (int i = 0; i < records.size(); ++i) {
	            for (int j = 0; j < 9; ++j) {
	                
	                array2[index++] = records.get(i).get(j);
	            }

	        }
        ScatterChartSample.main(array2);
    }
}}
