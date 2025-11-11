package indivana;

import java.util.ArrayList;


public class dataseris {
   
    String indicator;
    ArrayList<Float> data;
    float cumavg;
    ArrayList<Integer> xDelimitation;
    String country;
  
    public dataseris(String indicator, ArrayList<Float> data, ArrayList<Integer> xDelimitation, Float cumavg){
        this.indicator = indicator;
        this.data = data;
        this.cumavg = cumavg;
        this.xDelimitation = xDelimitation;
    }

  
    public ArrayList<Float> getdata() {
        return data;
    }

   
    public String getIndicator() {
        return indicator;
    }

  
    public float getcumavg() {
        return cumavg;
    }

   
}
