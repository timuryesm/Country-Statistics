package indivana;

import java.util.ArrayList;

import org.jfree.data.time.TimeSeriesCollection;

public class analysisth4 {
	 String[] analysisNames;
	    String[] seriesName;
	    
	    ArrayList<TimeSeriesCollection> timeSeriesList;
	   
	    float cum = (float)0.0;
	    int totalyear=0;
	    
	    

	    
	    public analysisth4( ArrayList<dataseris> series) {

	        
	    	System.out.print("4.Forest area (as % of land area) ");     
	        timeSeriesList = new ArrayList<>();    
	        
	       
	        
	        totalyear=series.get(0).year.size();
	        for(int i=0;i<totalyear;i++) {
	        	for(int j=1;j<series.size();j++) {
	        
	        System.out.println(series.get(0).year.get(i)+"\t"+series.get(0).getValues().get(i) / series.get(j).getValues().get(i));
	        
	        }}
	       
	     
	        
	        
	       
	       
	     
	       




	    }
	 
	   
	    }