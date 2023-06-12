package indivana;



import java.util.Scanner;

import org.jfree.data.category.DefaultCategoryDataset;

public class mainpage {
	
	

	public static void main(String[] args) {
		
		
		loginpage form = new loginpage();  
        form.setSize(300,100);  
        form.setVisible(true); 
		
	
		String accode[]= {"CAN","US","BRA","CHN","FRA"};
		
		System.out.println("EECS 3311 project 1 ");
		System.out.print("enter from year :");
		Scanner scan = new Scanner(System.in);
		String from_year=scan.nextLine();
		System.out.print("enter to year :");
		String to_year=scan.nextLine();
		System.out.print("Select Country code 0-5 :(\"CAN\",\"US\",\"BRA\",\"CHN\",\"FRA\")");
		int country=scan.nextInt();
		String ccode=accode[country];
		
		
		System.out.println("from "+from_year +" to year "+to_year);
		System.out.println(ccode);
		
		
		    System.out.println("1.The annual percentage change of  CO2 emissions(as metric tons per capits)Energy use(as kg of oil equivalent per capita)PM2.5 aire pollution, mean annual exposure(as micrograms per cubic meter)\n"
		    					+"2.Annual percentage change of PM2.5 air pollution, mean annual exposure(as micrograms per cubic meter) Forest area(as % of land area\n"
		    					+"3.the ratio CO2 emissions (as metric tons per capita)	GDP per capita (as current US$)\n"
		    					+"4.Forest area (as % of land area) for the selected years. The rest percentage would be land for all other uses"+"\n"
		    					+"5.Government expenditure on education (as % of GDP) for the selected years. The rest percentage would be expenditures for all other purposes\n"
		    					+"6.Current health expenditure (per 1,000 people).Hospital beds (per 1,000 people)\n" 
		    					+"7.Problems in accessing health care (getting money for treatment) (% of women): Q1 (lowest wealth)*Mortality rate, infant (per 1,000 live births)\n"
		    					+"8.Government expenditure on education, total (% of GDP)•	Current health expenditure (% of GDP). \n"
		    					
		    		);
		    
		    System.out.println("Select analysis 1-8");
		    
			int analysis=scan.nextInt();
			
			String anaytpe[][]= {{"EN.ATM.CO2E.PC","EG.USE.PCAP.KG.OE","EN.ATM.PM25.MC.M3"},
								{"EN.ATM.PM25.MC.M3","AG.LND.FRST.ZS"},
								{"EN.ATM.CO2E.PC","EN.ATM.PM25.MC.M3"},
								{"AG.LND.FRST.ZS"},
								{"SE.XPD.TOTL.GD.ZS"},
								{"SH.XPD.CHEX.PC.CD","SH.MED.BEDS.ZS"},
								{"SH.ACS.MONY.Q1.ZS","SP.DYN.IMRT.IN"},
								{"SE.XPD.TOTL.GD.ZS","SH.XPD.CHEX.GD.ZS"}
								
			};
			
		
			if(analysis==1) {
				
				Getdata gd=new Getdata(anaytpe[0],ccode, from_year, to_year);
				analysisth1 an1=new analysisth1(gd.series);
				System.out.println("Analysis 1 Completed");
			}
			if(analysis==2) {
				
				Getdata gd=new Getdata(anaytpe[1],ccode, from_year, to_year);
				analysisth2 an1=new analysisth2(gd.series);
				System.out.println("Analysis 2 Completed");
				
			}		
		
		
		if(analysis==3) {
			//String[] dataindi= {"EN.ATM.CO2E.PC","EN.ATM.PM25.MC.M3"};
			Getdata gd=new Getdata(anaytpe[2],ccode, from_year, to_year);
			analysisth3 an3=new analysisth3(gd.series);
			System.out.println("Analysis 3 Completed");
		}
		if(analysis==4) {
			//String[] dataindi= {"AG.LND.FRST.ZS"};
			Getdata gd=new Getdata(anaytpe[3], accode[country], from_year, to_year);
			analysisth4 an4=new analysisth4(gd.series);
			System.out.println("Analysis 4 Completed");
		}
		
		if(analysis==5) {
			//String[] dataindi= {"AG.LND.FRST.ZS"};
			Getdata gd=new Getdata(anaytpe[4], accode[country], from_year, to_year);
			analysisth5 an4=new analysisth5(gd.series);
			System.out.println("Analysis 5 Completed");
		}
		if(analysis==6) {
			//String[] dataindi= {"AG.LND.FRST.ZS"};
			Getdata gd=new Getdata(anaytpe[5], accode[country], from_year, to_year);
			analysisth6 an6=new analysisth6(gd.series);
			System.out.println("Analysis 6 Completed");
		}
		if(analysis==7) {
			//String[] dataindi= {"AG.LND.FRST.ZS"};
			Getdata gd=new Getdata(anaytpe[6], accode[country], from_year, to_year);
			analysisth6 an7=new analysisth6(gd.series);
			System.out.println("Analysis 7 Completed");
		}
		if(analysis==8) {
			//String[] dataindi= {"AG.LND.FRST.ZS"};
			Getdata gd=new Getdata(anaytpe[7], accode[country], from_year, to_year);
			analysisth8 an8=new analysisth8(gd.series);
			System.out.println("Analysis 8 Completed");
		}
		//
		
		
		
		
	
		
	
	

	}

}
