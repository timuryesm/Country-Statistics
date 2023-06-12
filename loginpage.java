package indivana;



import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Exception;  
  

class loginpage extends JFrame implements ActionListener  
{  
 
    JButton lgin;  
    JPanel login_frame;  
    JLabel ulbl, plbl;  
    final JTextField  uname;
    final JPasswordField pword;  
    File login_file=new File("C://test.txt");
      
    
    loginpage()  
    {     
          
         
        ulbl = new JLabel();  
        ulbl.setText("UserID"); 
        plbl = new JLabel();  
        plbl.setText("Password");
        lgin = new JButton("Login");          
       
        uname = new JTextField();  
        pword = new JPasswordField();
        setTitle("EECS Project 1 Login"); 
          
        
      
          
   
        login_frame = new JPanel(new GridLayout(3, 1));  
        login_frame.add(ulbl);    
        login_frame.add(uname);   
        login_frame.add(plbl);   
        login_frame.add(pword);   
        login_frame.add(lgin);         
          
        
        add(login_frame, BorderLayout.CENTER);  
          
        
        lgin.addActionListener(this);     
        setTitle("EECS Prject 1 Login");         
    }  
      
   
    public void actionPerformed(ActionEvent ae)     //pass action listener as a parameter  
    {  
       
          
        try{
        	FileReader fr=new FileReader(login_file);
        	BufferedReader br=new BufferedReader(fr);
        	String line="",user="",pass="";

        	String username=uname.getText();
        	String password=pword.getText();
        	line=br.readLine();
        	while(line!=null)
        	{
        	String []h=line.split(",");
        	if(h[0].equals(username))
        	{
        	user=h[0];
        	pass=h[1];

        	}

        		line=br.readLine();

        	}
        			if(username.equals(user) && password.equals(pass))
        				{
        					JOptionPane.showMessageDialog(this, "well come to Project Check the Consol for more .....");
        					
        					//dashboad db=new dashboad();
        					//db.setSize(300,100);
        					//db.setVisible(true);
        					
        				}else{
        					JOptionPane.showMessageDialog(this, "wrong user ID/Password");
        				}
        		}
        		catch(IOException e2)
        	{
        	e2.printStackTrace();
        	}
    }  
}  






class LoginFormDemo  
{  
   
    public static void main(String arg[])  
    {  
        try  
        {  
       
        }  
        catch(Exception e)  
        {     
           
            JOptionPane.showMessageDialog(null, e.getMessage());  
        }  
    }  
} 