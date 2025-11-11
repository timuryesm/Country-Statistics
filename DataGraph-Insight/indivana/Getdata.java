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



public class Getdata { ArrayList<Float> values = new ArrayList<>();
ArrayList<dataseris> series = new ArrayList<>();
float cum_value = 0;
float cum_avg = 0;
String[] indicator= {"EN.ATM.CO2E.PC","EN.ATM.PM25.MC.M3"}; 
String yearStart;
String yearEnd;
String country_code="US";
public static void main(String[] args) {}
public Getdata(String[] indicator, String country_code, String yearStart, String yearEnd) {
    
    this.indicator = indicator;
    this.country_code = country_code;
    this.yearStart = yearStart;
    this.yearEnd = yearEnd;
    for (int j = 0; j < indicator.length; j++) {
        // Reinit if needed
        ArrayList<Float> values = new ArrayList<>();
        ArrayList<Integer> valid_years = new ArrayList<>();
        cum_avg = 0;
        String aCountry = "US";
		String urlString = String.format(
				"http://api.worldbank.org/v2/country/%s/indicator/"+indicator[j]+"?date="+yearStart+":"+yearEnd+"&format=json", aCountry);

    
        System.out.println(urlString);
        // Since the example code uses population , we generalize it for all types of indicators.
        float valueForYear = 0;

        float cumulativeValue = 0;

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
                    int sizeOfResults = jsonArray.get(1).getAsJsonArray().size();
                    int year = 0;
                    for (int i = 0; i < sizeOfResults; i++) {                
                    		year = jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("date").getAsInt();

                        if (jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").isJsonNull()) {                               
                            continue;
                        } else {
                            valid_years.add(year);
                            valueForYear = jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").getAsFloat();
                            System.out.println(indicator[j] + " value for " + year + " is " + valueForYear); 
                            values.add(valueForYear);
                            cumulativeValue += valueForYear;
                        }
                    }

                    System.out.println("The average population over the selected years is " + cumulativeValue / sizeOfResults);
                    cum_value = cumulativeValue;
                    cum_avg = cum_value / sizeOfResults;
                } else {                        
                }


                System.out.println("Data successfully parsed in var values");
                dataseris p = new dataseris(indicator[j], values, valid_years, cum_avg);

                
                series.add(p);
            }


        } catch (IOException e) {
            e.printStackTrace();

        }
    }

}
public ArrayList<Float> getValues() {
    return values;
}

public float getCum_avg() {
    return cum_avg;
}

public float getCum_value() {
    return cum_value;
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

