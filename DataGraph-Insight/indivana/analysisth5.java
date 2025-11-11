package indivana;


import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;

import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class analysisth5  extends JFrame{
	String[] analysisNames ;
    String[] legedname;
    ArrayList<TimeSeriesCollection> xySeriesList;
    
    String report5;
   
    public analysisth5(ArrayList<dataseris> series) {       
    	legedname = new String[]{"Forest Area "};

        xySeriesList = new ArrayList<>();
     

        
     

       
        for (int i = 0; i < series.size(); i++) {
            TimeSeriesCollection xySeriesCollection = new TimeSeriesCollection();
            TimeSeries xyseries = new TimeSeries(legedname[i]);
          


            for (int j = 0; j < series.get(i).getdata().size(); j++) {

               
                xyseries.add(new Year(series.get(i).xDelimitation.get(j)),series.get(i).getdata().get(j));               
                report5 = legedname[i] +" yearl value " + series.get(i).xDelimitation.get(j) + "   "+ series.get(i).getdata().get(j)+"\n";
                
            }

            xySeriesCollection.addSeries(xyseries);           
            xySeriesList.add(xySeriesCollection);
           



        }

      
    }
}