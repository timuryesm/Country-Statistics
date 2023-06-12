package indivana;



import java.awt.Font;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.XYDataset;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;



public class Getdata {
	int count=0;
	//String datanaliz[]= {"------------CO2 emissions (as metric tons per capita------------","------------GDP per capita (as current US$)------------","","",""};
	ArrayList<Float> values = new ArrayList<>();
    ArrayList<dataseris> series = new ArrayList<>();
    float c_value = 0;
    float cumulati_avg = 0;
    String[] indicator; 
    String yearStart;
    String yearEnd;
    String acountry;
    ArrayList<String> temp;
  
    public Getdata(String[] indicator, String acountry, String yearStart, String yearEnd) {
        
        this.indicator = indicator;
        this.acountry = acountry;
        this.yearStart = yearStart;
        this.yearEnd = yearEnd;
        for (int j = 0; j < indicator.length; j++) {
            
            ArrayList<Float> values = new ArrayList<>();
            ArrayList<Integer> valid_years = new ArrayList<>();
            cumulati_avg = 0;
            float year_value = 0;
            float camu_value = 0;
            
            String urlString = String.format(
    				"http://api.worldbank.org/v2/country/%s/indicator/"+indicator[j]+"?date="+yearStart+":"+yearEnd+"&format=json", acountry);            
            //System.out.println(datanaliz[count]);
            count++;
            
           
            

            try {

                URL url = new URL(urlString);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.connect();
                int responsecode = conn.getResponseCode();

                

                if (responsecode == 200) {
                    String inline = "";
                    Scanner sc = new Scanner(url.openStream());
                    while (sc.hasNext()) {
                        inline += sc.nextLine();
                    }

                    sc.close();
                   

                    JsonArray jsonArray = new JsonParser().parse(inline).getAsJsonArray();
                    int size = jsonArray.size();
                    if (size > 1 && !jsonArray.isJsonNull()) {
                        int res_val = jsonArray.get(1).getAsJsonArray().size();
                        int year = 0;
                        for (int i = 0; i < res_val; i++) {                
                        		year = jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("date").getAsInt();

                            if (jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").isJsonNull()) {                               
                                continue;
                            } else {
                                valid_years.add(year);
                                year_value = jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").getAsFloat();
                                System.out.println(indicator[j] + " value for " + year + " is " + year_value); 
                                values.add(year_value);
                                camu_value += year_value;
                                
                            }
                        }

                        System.out.println(" average  over the selected years is " + camu_value / res_val);
                        c_value = camu_value;
                        cumulati_avg = c_value / res_val;
                    } else {                        
                    }


                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    
                    dataseris set = new dataseris(indicator[j], values, valid_years, cumulati_avg);
                    

                    
                    series.add(set);
                  
                }
               
                


            } catch (IOException Exception) {
            	Exception.printStackTrace();

            }
        }
        
        
        
       //analysisth3 az=new analysisth3(series);

        

        

        
        
        
        
        }

	public ArrayList<Float> getValues() {
        return values;
    }

    public float getcumulati_avg() {
        return cumulati_avg;
    }

    public float getc_value() {
        return c_value;
    }

    public String getYearEnd() {
        return yearEnd;
    }

    public String getYearStart() {
        return yearStart;
    }

    public String[] getIndicator() {
        return indicator;
    }

  
    public ArrayList<dataseris> getSeries() {
        return series;
    }
    }
    

