package indivana;

import java.util.ArrayList;
import java.util.Vector;

import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;

public class analysisth1 {
	 
    Vector<String> viewDropdownList;
    
   
    String[] analysisNames;
  

  
    public analysisth1(ArrayList<dataseris> series) {
    	analysisNames = new String[]{
                "CO2 emissions (metric tons per capita) ",
                "Energy use (kg of oil equivalent per capita) ",
                "PM2.5 air pollution, mean annual exposure (micrograms per cubic meter) ",
        };
       
      
       
        ArrayList<TimeSeriesCollection> xySeriesList = new ArrayList<>();
        

       

       
        for (int i = 0; i < series.size(); i++) {

           
            TimeSeriesCollection xySeriesCollection = new TimeSeriesCollection();           
            TimeSeries xyseries = new TimeSeries(analysisNames[i]);
            for (int j = 0; j < series.get(i).getdata().size(); j++) {

                xyseries.add(new Year(series.get(i).xDelimitation.get(j)),series.get(i).getdata().get(j));
               

          

         
            xySeriesCollection.addSeries(xyseries);
            xySeriesList.add(xySeriesCollection);
            



      
	
	
            }}}
}

