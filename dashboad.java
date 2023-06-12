package indivana;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.*;  
	  
	//create NewPage class to create a new page on which user will navigate  
	class dashboad extends JFrame  
	{  
	    ////constructor  
		//dashboad()  
	    //{  
	      //  setDefaultCloseOperation(javax.swing.  
	        //WindowConstants.DISPOSE_ON_CLOSE);  
	        //setTitle("Welcome");  
	        //setSize(1600, 800);  
	    //}
		       
		
		  private static final long serialVersionUID = 1L;  
		  
		  public dashboad(String title) {  
		    super(title);  
		    // Create dataset  
		    DefaultCategoryDataset dataset = createDataset();  
		    // Create chart  
		    JFreeChart chart = ChartFactory.createLineChart(  
		        "Site Traffic", // Chart title  
		        "Date", // X-Axis Label  
		        "Number of Visitor", // Y-Axis Label  
		        dataset  
		        );  
		  
		    ChartPanel panel = new ChartPanel(chart);  
		    setContentPane(panel);  
		  }  
		  
		  private DefaultCategoryDataset createDataset() {  
		  
		    String series1 = "Visitor";  
		    String series2 = "Unique Visitor";  
		  
		    DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
		  
		    
			dataset.addValue(200, series1, "");  
		    dataset.addValue(150, series1, "2016-12-20");  
		    dataset.addValue(100, series1, "2016-12-21");  
		    dataset.addValue(210, series1, "2016-12-22");  
		    dataset.addValue(240, series1, "2016-12-23");  
		    dataset.addValue(195, series1, "2016-12-24");  
		    dataset.addValue(245, series1, "2016-12-25");  
		  
		    dataset.addValue(150, series2, "2016-12-19");  
		    dataset.addValue(130, series2, "2016-12-20");  
		    dataset.addValue(95, series2, "2016-12-21");  
		    dataset.addValue(195, series2, "2016-12-22");  
		    dataset.addValue(200, series2, "2016-12-23");  
		    dataset.addValue(180, series2, "2016-12-24");  
		    dataset.addValue(230, series2, "2016-12-25");  
		  
		    return dataset;  
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
	}
		  
		  public static void main(String[] args) {  
			    SwingUtilities.invokeLater(() -> {  
			    	dashboad example = new dashboad("Line Chart Example");  
			      example.setAlwaysOnTop(true);  
			      example.pack();  
			      example.setSize(600, 400);  
			      example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
			      example.setVisible(true);  
			    });  
			    
			    
			    
			    String aCountry = "US";
				String urlString = String.format(
						"http://api.worldbank.org/v2/country/%s/indicator/SP.POP.TOTL?date=2000:2001&format=json", aCountry);
				System.out.println(urlString);
				int populationForYear = 0;
				int cummulativePopulation = 0;
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
						int sizeOfResults = jsonArray.get(1).getAsJsonArray().size();
						int year;
						for (int i = 0; i < sizeOfResults; i++) {
							year = jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("date").getAsInt();
							if (jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").isJsonNull())
								populationForYear = 0;
							else
								populationForYear = jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value")
										.getAsInt();

							System.out.println("Population for " + aCountry + " in " + year + " is " + populationForYear);
							cummulativePopulation = cummulativePopulation + populationForYear;
						}
						System.out.println(
								"The average population over the selected years is " + cummulativePopulation / sizeOfResults);
					}

				} catch (IOException e) {
					// TODO Auto-generated catch block e.printStackTrace();
				}

				return;
			}
			    
			    
			    
			    
			    
			  }  
	
	
	
	

	
	