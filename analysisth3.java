package indivana;






import java.lang.reflect.Array;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;


public class analysisth3 {
    String[] analysisNames;
    String[] seriesName;
    
    ArrayList<TimeSeriesCollection> timeSeriesList;
   
    float cum = (float)0.0;
    int totalyear=0;
    
    

    
    public analysisth3( ArrayList<dataseris> series) {

        
          
        timeSeriesList = new ArrayList<>();    
        
       
        
        totalyear=series.get(0).year.size();
        System.out.print("3.Displayed as a 1-series graphs, the ratio•	CO2 emissions (as metric tons per capita) •	GDP per capita (as current US$)\r\n");
        System.out.println("Year\t"+"CO2\t\t"+"GDP\t\t"+"ratio");
        for(int i=0;i<totalyear;i++) {
        	for(int j=1;j<series.size();j++) {
        
        System.out.println(series.get(0).year.get(i)+"\t"+series.get(0).getValues().get(i)+"\t"+series.get(j).getValues().get(i)+"\t"+(series.get(0).getValues().get(i) / series.get(j).getValues().get(i)));
        
        }}
       
     
        
        
       
       
     
       




    }
 
   
    }
    
