package indivana;

import java.util.ArrayList;

import org.jfree.data.time.TimeSeriesCollection;

public class analysisth2 {
	String[] analysisNames;
    String[] seriesName;
    
    ArrayList<TimeSeriesCollection> timeSeriesList;
   
    float cum = (float)0.0;
    int totalyear=0;
    
    

    
    public analysisth2( ArrayList<dataseris> series) {

        
          
        timeSeriesList = new ArrayList<>();    
        
       
        
        totalyear=series.get(0).year.size();
        System.out.print("2.annual percentage change of •	PM2.5 air pollution, mean annual exposure (as micrograms per cubic meter) •	Forest area (as % of land area)\r\n");
        System.out.println("Year\t"+"PM2.5\t\t"+"Forest area\t\t"+" ");
        for(int i=0;i<totalyear;i++) {
        	for(int j=1;j<series.size();j++) {
        
        System.out.println(series.get(0).year.get(i)+"\t"+series.get(0).getValues().get(i)+"\t"+series.get(j).getValues().get(i)+"\t");
        
        }}
       
     
        
        
       
       
     
       




    }
 
   
    }