package lab4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Main {

	
	public static void main(String[] args) throws IOException 
{
		// TODO Auto-generated method stub
		List<List<String>> records = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("data.csv"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[]values = line.split(",");
		        records.add(Arrays.asList(values));
		    }
		   
		    int sizeCSV = records.size();
		    Float[][] Array = new Float[sizeCSV][9];
		    Float[][] NegativeArray = new Float[sizeCSV][9];
		    Float[][] PositiveArray = new Float[sizeCSV][9];
		    int sizeNegative=0;
		    int sizePositive=0;
		    
		    for(int i=1;i<records.size();i++)
		    {
		    	for(int j=0;j<9;j++)
		    {
		    	String str1=records.get(i).get(j);
		    	Float i2 = Float.valueOf(str1);
		    	Array[i][j]=i2;
		     }
		    }
		    
		        for(int i=1;i<records.size();i++)
		        {
			    if (Array[i][8]==0)
			    {
			    	sizeNegative++;
			    	for(int j=0;j<9;j++) 
			    		NegativeArray[i][j]=Array[i][j];
			    		 
			    }
			    
			    else
			    	{
			    	sizePositive++;
			    	for(int j=0;j<9;j++) 
			    		PositiveArray[i][j]=Array[i][j];
			    	}
			    		
			    } 	
		    	
			    
			   
			    float maxArrayX = Array[1][1];
		        float minArrayX = Array[1][1];
		        float maxArrayY = Array[1][2];
		        float minArrayY = Array[1][2];
			
		        
		        for(int i = 1; i != Array.length; i ++){
		            if(Array[i][1] > maxArrayX){
		                maxArrayX = Array[i][1];
		            }
		            if(Array[i][1] < minArrayX){
		                minArrayX = Array[i][1];
		            }
		        }
			   
		        for(int i = 1; i != Array.length; i ++){
		            if(Array[i][2] > maxArrayY){
		                maxArrayY = Array[i][2];
		            }
		            if(Array[i][2] < minArrayY){
		                minArrayY = Array[i][2];
		            }
		        }
		        
		        
		        System.out.println(minArrayX);
			    System.out.println(maxArrayX);
			    System.out.println(minArrayY);
			    System.out.println(maxArrayY);
		        
			    System.out.println(NegativeArray[1][1]);
		}
	}
	
	}
