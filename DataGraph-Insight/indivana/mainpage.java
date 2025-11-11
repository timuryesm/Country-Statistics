package indivana;



import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.Vector;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class mainpage extends JFrame{
	
	private static final long serialVersionUID = 1L;  
	  country country;
	  
	  

	  

	public static void main(String[] args) {
		
		loginpage form = new loginpage();  
        form.setSize(300,100);  
        form.setVisible(true); 
		
		Vector<String> years = new Vector<String>();
		JLabel from = new JLabel("From");
        JLabel to = new JLabel("To");
        JLabel country = new JLabel("Country");
        
        String countrycode[]={"CAN","US","UK"}; 
        String charts[]={"Barchart","linechart","Scatter Chart","report"}; 
        String analysisname[]= {        		     		
        		"1.CO2 emissions VS Energy use & PM2.5 air pollution" ,
        		"2.PM2.5 air pollution VS Forest area ",
        		"3.CO2 emissions VS GDP and Ratio",
        		"4.Forest area ",
        		"5.Government expenditure on education ",
        		"6.health expenditure VS Hospital beds and Ratio",
        		"7.Problems in accessing health care VS Mortality rate",
        		"8.Government expenditure VS Current health expenditure"
        };
        String analysis_code[][]= {	{"EN.ATM.CO2E.PC","EG.USE.PCAP.KG.OE"},
									{"EN.ATM.PM25.MC.M3","AG.LND.FRST.ZS"},
									{"EN.ATM.CO2E.PC","EN.ATM.PM25.MC.M3"},
									{"AG.LND.FRST.ZS"},
									{"SE.XPD.TOTL.GD.ZS"},
									{"SH.XPD.CHEX.PC.CD","SH.MED.BEDS.ZS"},
									{"SH.ACS.MONY.Q1.ZS","SP.DYN.IMRT.IN"},
									{"SE.XPD.TOTL.GD.ZS","SH.XPD.CHEX.GD.ZS"}
				
        								};

        
        
        for (int i = 2021; i >= 2010; i--) {
            years.add("" + i);
}
        
        JComboBox<String> country_cb = new JComboBox<String>(countrycode);        
        JFrame jFrame = new JFrame();
        
        JComboBox<String> startdate_dropbox = new JComboBox<>(years);
        startdate_dropbox.setBounds(80, 50, 140, 20);   
        
        JComboBox<String> enddate_dropbox = new JComboBox<>(years);
        enddate_dropbox.setBounds(80, 50, 140, 20);
        
        JComboBox<String> analyis_namecb = new JComboBox<>(analysisname);
        analyis_namecb.setBounds(80, 50, 140, 20);
        
        JComboBox<String> charts_cb = new JComboBox<>(charts);
        charts_cb.setBounds(80, 50, 140, 20);
        
        JButton run_button = new JButton("Run");
        run_button.setBounds(100, 100, 90, 20);
        
        JButton plus = new JButton("+");
        plus.setBounds(100, 100, 90, 20);
        JButton minus = new JButton("-");
        minus.setBounds(100, 100, 90, 20);
        
        JPanel top = new JPanel();
        JPanel center = new JPanel();
        JPanel bottam = new JPanel();
        
		
		
        
        
        
		top.add(from);
        top.add(startdate_dropbox);  
        top.add(to);
        top.add(enddate_dropbox);
        top.add(country);
        top.add(country_cb);
        
       center.setLayout(new GridLayout(2,0));
        
        bottam.setLayout(new FlowLayout());
        bottam.add(analyis_namecb);
        bottam.add(charts_cb);
        bottam.add(plus);
        bottam.add(minus);
        bottam.add(run_button);
        
       
        
        
    
        


      
        jFrame.add(top);        
        jFrame.add(center);        
        jFrame.add(bottam);
        
       jFrame.setLayout(new GridLayout(3,0));
        
        
      

        
        
        


      
      	
     
       
        run_button.addActionListener(new ActionListener() {



        	public void actionPerformed(ActionEvent e) {
        	String fromdate = startdate_dropbox.getItemAt(startdate_dropbox.getSelectedIndex());
        	String enddate =  enddate_dropbox.getItemAt(enddate_dropbox.getSelectedIndex());
        	String acountry =  country_cb.getItemAt(country_cb.getSelectedIndex());
        	int analyis_index = analyis_namecb.getSelectedIndex();
        	System.out.print(analyis_index);
        	
        	if (analyis_index==0) {
    			Getdata gd0=new Getdata(analysis_code[analyis_index],acountry, fromdate, enddate); 	        		
              	analysisth3 an0=new analysisth3(gd0.series);
              	analysism azm0=new analysism(an0.legendname, an0.xyser);
                   	plus.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {                		
                		int chart_num=charts_cb.getSelectedIndex();	
                		if(chart_num==0) {azm0.barchart(center);}
                		if(chart_num==1) {azm0.linechart(center);}
                		if(chart_num==2) {azm0.sch(center);}
                		if(chart_num==3) {azm0.textreport(an0.report3,center);}       		
                	
                		
                	}
                	
        	  });
              	
             
              	
    			
    		} 	if (analyis_index==1) {
    			Getdata gd1=new Getdata(analysis_code[analyis_index],acountry, fromdate, enddate); 	        		
              	analysisth3 an1=new analysisth3(gd1.series);
              	analysism azm1=new analysism(an1.legendname, an1.xyser);
                   	plus.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {                		
                		int chart_num=charts_cb.getSelectedIndex();	
                		if(chart_num==0) {azm1.barchart(center);}
                		if(chart_num==1) {azm1.linechart(center);}
                		if(chart_num==2) {azm1.sch(center);}
                		if(chart_num==3) {azm1.textreport(an1.report3,center);}       		
                	
                		
                	}
                	
        	  });
              	
             
              	
    			
    		}if (analyis_index==2) {
    			Getdata gd2=new Getdata(analysis_code[analyis_index],acountry, fromdate, enddate); 	        		
              	analysisth3 an2=new analysisth3(gd2.series);
              	analysism azm2=new analysism(an2.legendname, an2.xyser);
                   	plus.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {                		
                		int chart_num=charts_cb.getSelectedIndex();	
                		if(chart_num==0) {azm2.barchart(center);}
                		if(chart_num==1) {azm2.linechart(center);}
                		if(chart_num==2) {azm2.sch(center);}
                		if(chart_num==3) {azm2.textreport(an2.report3,center);}       		
                	
                		
                	}
                	
        	  });
              	
             
              	
    			
    		}if (analyis_index==3) {
        		Getdata gd3=new Getdata(analysis_code[analyis_index],acountry, fromdate, enddate); 	        		
              	analysisth4 an3=new analysisth4(gd3.series);
              	analysism azm3=new analysism(an3.legedname, an3.xySeriesList);
              	
              	plus.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {                		
                		int chart_num=charts_cb.getSelectedIndex();	
                		if(chart_num==0) {azm3.barchart(center);}
                		if(chart_num==1) {azm3.linechart(center);}
                		if(chart_num==2) {azm3.sch(center);}
                		if(chart_num==3) {azm3.textreport(an3.report4,center);}       		
                	
                		
                	}
                	
        	  });
              	
              	
              		
              	}
    		if (analyis_index==4) {
        		Getdata gd4=new Getdata(analysis_code[analyis_index],acountry, fromdate, enddate); 	        		
              	analysisth5 an4=new analysisth5(gd4.series);
              	analysism azm4=new analysism(an4.legedname, an4.xySeriesList);
              	
              	plus.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {                		
                		int chart_num=charts_cb.getSelectedIndex();	
                		if(chart_num==0) {azm4.barchart(center);}
                		if(chart_num==1) {azm4.linechart(center);}
                		if(chart_num==2) {azm4.sch(center);}
                		if(chart_num==3) {azm4.textreport(an4.report5,center);}       		
                	
                		
                	}
                	
        	  });
              	
              	
              		
              	}if (analyis_index==5) {
            		Getdata gd5=new Getdata(analysis_code[analyis_index],acountry, fromdate, enddate); 	        		
                  	analysisth6 an5=new analysisth6(gd5.series);
                  	analysism azm5=new analysism(an5.legendname, an5.xyser);
                  	
                  	plus.addActionListener(new ActionListener() {
                    	public void actionPerformed(ActionEvent e) {                		
                    		int chart_num=charts_cb.getSelectedIndex();	
                    		if(chart_num==0) {azm5.barchart(center);}
                    		if(chart_num==1) {azm5.linechart(center);}
                    		if(chart_num==2) {azm5.sch(center);}
                    		if(chart_num==3) {azm5.textreport(an5.report6,center);}       		
                    	
                    		
                    	}
                    	
            	  });
                  	
                  	
                  		
                  	}if (analyis_index==6) {
                		Getdata gd6=new Getdata(analysis_code[analyis_index],acountry, fromdate, enddate); 	        		
                      	analysisth7 an6=new analysisth7(gd6.series);
                      	analysism azm6=new analysism(an6.legendname, an6.xyser);
                      	
                      	plus.addActionListener(new ActionListener() {
                        	public void actionPerformed(ActionEvent e) {                		
                        		int chart_num=charts_cb.getSelectedIndex();	
                        		if(chart_num==0) {azm6.barchart(center);}
                        		if(chart_num==1) {azm6.linechart(center);}
                        		if(chart_num==2) {azm6.sch(center);}
                        		if(chart_num==3) {azm6.textreport(an6.report7,center);}       		
                        	
                        		
                        	}
                        	
                	  });
                      	
                      	
                      		
                      	}if (analyis_index==7) {
                    		Getdata gd7=new Getdata(analysis_code[analyis_index],acountry, fromdate, enddate); 	        		
                          	analysisth8 an7=new analysisth8(gd7.series);
                          	analysism azm7=new analysism(an7.legendname, an7.xyser);
                          	
                          	plus.addActionListener(new ActionListener() {
                            	public void actionPerformed(ActionEvent e) {                		
                            		int chart_num=charts_cb.getSelectedIndex();	
                            		if(chart_num==0) {azm7.barchart(center);}
                            		if(chart_num==1) {azm7.linechart(center);}
                            		if(chart_num==2) {azm7.sch(center);}
                            		if(chart_num==3) {azm7.textreport(an7.report8,center);}       		
                            	
                            		
                            	}
                            	
                    	  });
                          	
                          	
                          		
                          	}
        		
        	       	
        	
        	}
        	
        	
        	

        	});
		
		
		
		
        
        
		System.out.println("EECS 3311 project 1 ");			
			
		  
        jFrame.pack();
        jFrame.setSize(900, 600);
        jFrame.setVisible(true);					
		 
	        	
		
	
			
		
		
		
		
		
		System.out.println("Analysis  Completed");


}


		

	}

