package indivana;

import java.util.ArrayList;

import org.jfree.data.time.TimeSeriesCollection;

public class analysisth8 {
    
    ArrayList<TimeSeriesCollection> timeSeriesList;
   
    float cum = (float)0.0;
    int totalyear=0;
    
    

    
    public analysisth8( ArrayList<dataseris> series) {

        
          
        timeSeriesList = new ArrayList<>();    
        
       
        
        totalyear=series.get(0).year.size();
        System.out.print("Government expenditure on education, total (% of GDP)•	Current health expenditure (% of GDP). \n");
        System.out.println("Year\t"+"GDP\t\t"+"GDP\t\t"+"Avg");
        for(int i=0;i<totalyear;i++) {
        	for(int j=1;j<series.size();j++) {
        
        System.out.println(series.get(0).year.get(i)+"\t"+series.get(0).getValues().get(i)+"\t"+series.get(j).getValues().get(i)+"\t"+(series.get(0).getValues().get(i) / series.get(j).getValues().get(i)));
        
        }}}}
       
     
