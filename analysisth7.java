package indivana;

import java.util.ArrayList;

import org.jfree.data.time.TimeSeriesCollection;

public class analysisth7 {
    
    ArrayList<TimeSeriesCollection> timeSeriesList;
   
    float cum = (float)0.0;
    int totalyear=0;
    
    

    
    public analysisth7( ArrayList<dataseris> series) {

        
          
        timeSeriesList = new ArrayList<>();    
        
       
        
        totalyear=series.get(0).year.size();
        System.out.print("7.Problems in accessing health care (getting money for treatment) (% of women): Q1 (lowest wealth)\n");
        System.out.println("Year\t"+"% women\t\t"+"low wealth\t\t");
        for(int i=0;i<totalyear;i++) {
        	for(int j=0;j<series.size();j++) {
        
        System.out.println(series.get(0).year.get(i)+"\t"+series.get(0).getValues().get(i)+"\t"+series.get(j).getValues().get(i)+"\t"+(series.get(0).getValues().get(i) / series.get(j).getValues().get(i)));
        
        }}}}
       
     
