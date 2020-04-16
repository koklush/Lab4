package lab4;

import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;

 
public class ScatterChartSample extends Application {
	
	public static String parameters;
 
    @Override public void start(Stage stage)  {
    	
    	System.out.println("Application starts");
    	
    	Application.Parameters params = getParameters();
        List<String> unnamedParams = getParameters().getUnnamed();
        int count =0;
        for(String param: unnamedParams)
        {
            count++;   
        }
        
        System.out.println(count);
    	
        
    	String maxy =unnamedParams.get(10);
    	Float maxY = Float.valueOf(maxy);
    	String maxx =unnamedParams.get(9);
    	Float maxX = Float.valueOf(maxx);
           
       
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Negative series");
        for(int i = 9; i <count; i =i+9) 
        {
        	String str1=unnamedParams.get(i);
    		String str2=unnamedParams.get(i+1);
	    	Float i1 = Float.valueOf(str1);
	    	Float i2 = Float.valueOf(str2);
	    	
	    	if(maxX<i1)maxX=i1;
	    	if(maxY<i2)maxY=i2;
        	
        	String var =unnamedParams.get(i+8);
	    	Float var1 = Float.valueOf(var);
        	if (var1==0) 
        	{
        		series1.getData().add(new XYChart.Data(i1,i2));
        	}
        }
        
        System.out.println("max x");
        System.out.println(maxX);
        System.out.println("max y");
        System.out.println(maxY);
        
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Positive series");
        for(int i = 9; i <count; i=i +9) 
        {
        	String var =unnamedParams.get(i+8);
	    	Float var1 = Float.valueOf(var);
        	if (var1==1)
        	{
        		String str1=unnamedParams.get(i);
        		String str2=unnamedParams.get(i+1);
		    	Float i1 = Float.valueOf(str1);
		    	Float i2 = Float.valueOf(str2);
        		series2.getData().add(new XYChart.Data(i1,i2));
        	}
        	
        }
        
        stage.setTitle("Lab 4");
        final NumberAxis xAxis = new NumberAxis(0,maxX+2, 1);
        final NumberAxis yAxis = new NumberAxis(0,maxY+2, 1);      
        final ScatterChart<Number,Number> sc = new
            ScatterChart<Number,Number>(xAxis,yAxis);
        xAxis.setLabel("X label");                
        yAxis.setLabel("Y label");
        sc.setTitle("Scatter Chart");
        
        //RadioButton radioButton1 = new RadioButton("X");
        //RadioButton radioButton2 = new RadioButton("Y");
       
        sc.getData().addAll(series1, series2);
        Scene scene  = new Scene(sc, 500, 400);
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void init() throws Exception {
         
        System.out.println("Application inits");
        super.init();
    }
    
    @Override
    public void stop() throws Exception {
         
        System.out.println("Application stops");
        super.stop();
    }
    
    
    public static void main(String[] args) {
    	
    	 System.out.println("Application launching");
    	Application.launch(args);
    }
}