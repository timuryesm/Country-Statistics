package indivana;

import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.layout.CenterLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.util.ArrayList;


public class analysism extends JFrame {
	ArrayList<TimeSeriesCollection> xySeriesCollection;
	String[] seriesName;
    
    
    

    public analysism(String[] seriesName,ArrayList<TimeSeriesCollection> xySeriesCollection) {
            
        this.seriesName = seriesName;             
        this.xySeriesCollection = xySeriesCollection;
        
        
             
        
        
   /*/     
     JFrame jf=new JFrame("charts");    
         
     ChartPanel chartPanelxy = new ChartPanel(chart);  
    // ChartPanel chartPanelbar = new ChartPanel(barChart);
     
    // jf.add(chartPanelbar);
     jf.add(chartPanelxy); 
     jf.setVisible(true);
     
     
        

    }*/
    }

    public void barchart (JPanel west) {
    	
    	 XYPlot plot1 = new XYPlot();
         plot1.setDomainAxis(new DateAxis("Years"));
         for (int i = 0; i < xySeriesCollection.size(); i++) {
             XYBarRenderer renderer = new XYBarRenderer();
             plot1.setDataset(i, xySeriesCollection.get(i));
             plot1.setRenderer(i, renderer);
             plot1.mapDatasetToRangeAxis(i, i);
             plot1.setRangeAxis(i, new NumberAxis(seriesName[i]));
             plot1.getRangeAxis().setAutoRange(true);
             
         }
         JFreeChart barChart = new JFreeChart("", new Font("Serif", Font.BOLD, 18), plot1, true);
         ChartPanel cp=new ChartPanel(barChart);
         west.add(cp);
         
    	
    }
    
    public void linechart (JPanel west) {
    	
    	
    	 XYPlot plot = new XYPlot();
         plot.setOrientation(PlotOrientation.VERTICAL);
         plot.mapDatasetToDomainAxis(0, 0);
         plot.setDomainAxis(new DateAxis("Years"));
         plot.setRangeAxis(new NumberAxis(""));
        
         
         for (int i = 0; i < seriesName.length; i++) {
             XYItemRenderer itemrenderer = new XYLineAndShapeRenderer(true, false);
             itemrenderer.setDefaultToolTipGenerator(new StandardXYToolTipGenerator());
             plot.setDataset(i, xySeriesCollection.get(i));
             plot.setRenderer(i, itemrenderer);
             plot.mapDatasetToRangeAxis(i, i);
             plot.setRangeAxis(i, new NumberAxis(seriesName[i]));
             plot.getRangeAxis().setAutoRange(true);
             plot.getDomainAxis().setAutoRange(true);
         }
         JFreeChart chart = new JFreeChart("", JFreeChart.DEFAULT_TITLE_FONT, plot, true);
         ChartPanel cpl=new ChartPanel(chart);
         west.add(cpl);
    }
    
    
    
    
    
    public void sch (JPanel west) {
    	
    	
    	 XYPlot plot3 = new XYPlot();


         DateAxis domainAxis = new DateAxis("Years");
         plot3.setDomainAxis(domainAxis);
         plot3.setRangeAxis(new NumberAxis(""));

         for (int i = 0; i < seriesName.length; i++) {
             plot3.setDataset(i, xySeriesCollection.get(i));
             XYItemRenderer itemrenderer = new XYLineAndShapeRenderer(false, true);
             plot3.setRenderer(i, itemrenderer);
             plot3.setRangeAxis(i, new NumberAxis(seriesName[i]));
             plot3.mapDatasetToRangeAxis(i, i);
             plot3.getRangeAxis().setAutoRange(true);
             plot3.getDomainAxis().setAutoRange(true);
         }
        JFreeChart sch = new JFreeChart("", JFreeChart.DEFAULT_TITLE_FONT, plot3, true);
        ChartPanel cpl=new ChartPanel(sch);
        west.add(cpl);
   }
    
    
    
    public void textreport(String txt, JPanel west){
    	
    	 JTextArea text_report = new JTextArea();

    	 
    	 text_report.setLineWrap(true);
    	 text_report.setWrapStyleWord(true);
    	 text_report.setEditable(false);
    	 text_report.setText(txt);
    	 west.add(text_report);
    	 

         
         

     }
    	
    

}

