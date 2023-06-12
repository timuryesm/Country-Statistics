package indivana;

import java.util.ArrayList;

import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;

public class analysisth5 { ArrayList<TimeSeriesCollection> timeSeriesList;

float cum = (float)0.0;
int totalyear=0;




public analysisth5( ArrayList<dataseris> series) {

    
      
    timeSeriesList = new ArrayList<>();    
    
   
    
    totalyear=series.get(0).year.size();
    System.out.print("5.•Government expenditure on education (as % of GDP) for the selected years. The rest percentage would be expenditures for all other purposes\n");
    System.out.println("Year\t"+"CO2\t\t"+"Engy\t\t"+"P.M2.5");
    for(int i=0;i<totalyear;i++) {
    	for(int j=0;j<series.size();j++) {
    
    System.out.println(series.get(0).year.get(i)+"\t"+series.get(0).getValues().get(i));
    
    }}}}