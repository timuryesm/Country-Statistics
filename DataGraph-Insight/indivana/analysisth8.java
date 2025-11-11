package indivana;




import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;

import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class analysisth8  extends JFrame{

	private static final long serialVersionUID = 1L;
	String analysisNames;
    String[] legendname;
   
    String report8="report 3";
    
    ArrayList<TimeSeriesCollection> xyser;
    float cum = (float)0.0;

  
    public analysisth8( ArrayList<dataseris> series) {    	
        legendname = new String[]{"CO2","GDP","Ratio of CO2 to GDP"};
        analysisNames = "CO2,GDP,Ratio of CO2 to GDP";       
        xyser = new ArrayList<>();
      
       
        report8=report8+"\t"+analysisNames+"=======================\n";

        //  datasets
        for (int i  = 0; i < series.size()+1; i++) {
        	int x = 0;
            int y = 0;
            TimeSeriesCollection xycol = new TimeSeriesCollection();
            TimeSeries xyseries = new TimeSeries(legendname[i]);
            if (i == series.size()) {
                
                while (x < series.get(0).xDelimitation.size() && y < series.get(1).xDelimitation.size()) {
                    if (series.get(0).xDelimitation.get(x).equals(series.get(1).xDelimitation.get(y))) {
                        double val = series.get(0).getdata().get(x) / series.get(1).getdata().get(y);
                        xyseries.add(new Year(series.get(0).xDelimitation.get(x)), val);
                        //report3 = " yearl value " + series.get(0).xDelimitation.get(1) + "   "+ series.get(i).getdata().get(1)+"\n";
                       
                        x++;
                        y++;

                    } else if (series.get(0).xDelimitation.get(x) < series.get(1).xDelimitation.get(y)) {
                        y++;

                    } else {
                        x++;
                    }
                }
            } else {
                cum += series.get(i).cumavg;
                for (int j = 0; j < series.get(i).getdata().size(); j++) {
                    xyseries.add(new Year(series.get(i).xDelimitation.get(j)),series.get(i).getdata().get(j));
                    
                }
            }
            xycol.addSeries(xyseries);
            xyser.add(xycol);
           
        }
        
        
        //System.out.println(series.get(0).xDelimitation.get(2)+" "+series.get(1).xDelimitation.get(2)+" "+series.get(0).xDelimitation.get(2)+" ");
       
        System.out.print(legendname[1]);
        
    }
 
   
    }
