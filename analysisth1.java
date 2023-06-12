package indivana;

import java.util.ArrayList;

import org.jfree.data.time.TimeSeriesCollection;

public class analysisth1 {
	
  
    
    ArrayList<TimeSeriesCollection> timeSeriesList;
   
    float cum = (float)0.0;
    int totalyear=0;
    
    

    
    public analysisth1( ArrayList<dataseris> series) {

        
          
        timeSeriesList = new ArrayList<>();    
        
       
        
        totalyear=series.get(0).year.size();
        System.out.print("1.annual percentage change of *CO2 emissions (as metric tons per capita) *Energy use (as kg of oil equivalent per capita) 2.5 air pollutionn\n");
        System.out.println("Year\t"+"CO2\t\t"+"Engy\t\t"+"P.M2.5");
        for(int i=0;i<totalyear;i++) {
        	for(int j=1;j<series.size();j++) {
        
        System.out.println(series.get(0).year.get(i)+"\t"+series.get(0).getValues().get(i)+"\t"+series.get(j).getValues().get(i)+"\t\t"+(series.get(0).getValues().get(i) / series.get(j).getValues().get(i)));
        
        }}
       
     
        
        
       
       
     
       




    }
 
   
    }

    