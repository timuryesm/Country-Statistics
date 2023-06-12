package indivana;

import java.util.ArrayList;

import org.jfree.data.time.TimeSeriesCollection;

public class analysisth6 {
    
    ArrayList<TimeSeriesCollection> timeSeriesList;
   
    float cum = (float)0.0;
    int totalyear=0;
    
    

    
    public analysisth6( ArrayList<dataseris> series) {

        
          
        timeSeriesList = new ArrayList<>();    
        
       
        
        totalyear=series.get(0).year.size();
        System.out.print("6.•	Current health expenditure (per 1,000 people)hospital beds (per 1,000 people)\n");
        System.out.println("Year\t"+"pations\t\t"+"bes\t\t"+"Avg");
        for(int i=0;i<totalyear;i++) {
        	for(int j=1;j<series.size();j++) {
        
        System.out.println(series.get(0).year.get(i)+"\t"+series.get(0).getValues().get(i)+"\t"+series.get(j).getValues().get(i)+"\t"+(series.get(0).getValues().get(i) / series.get(j).getValues().get(i)));
        
        }}}}
       
     