package indivana;

import java.util.ArrayList;

public class dataseris {
	ArrayList<Integer> year;
    String anaindi;
    String reportdadta ;
    float avg_cumu;
    
    String country;
    ArrayList<Float> values;
   
    public dataseris(String anaindi, ArrayList<Float> values, ArrayList<Integer> year, Float avg_cumu){
        this.anaindi = anaindi;
        this.values = values;
        this.avg_cumu = avg_cumu;
        this.year = year;
    }

    public ArrayList<Float> getValues() {
        return values;
    }
    public String toSeriesString() {
  	  return reportdadta;
  }
    public float getavg_cumu() {
        return avg_cumu;
    }
    
    public String getanaindi() {
        return anaindi;
    }

   

   
  
}
