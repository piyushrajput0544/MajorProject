import java.awt.*;
import java.sql.*;
import javax.swing.*;
class UsersResult extends JPanel
{    
    JLabel l,l1;
	Choice c2;
	JButton b1,b2;
		ImageIcon img,img1;
	Image  on,on1;
	
	
	UsersResult()
	{
		setLayout(null);
		Font f=new Font("Arial Black",5,30);
		Font f1=new Font("",5,25);
		Font f2=new Font("Arial Black",5,25);
		
					
	img=new ImageIcon("user.JPEG");
	on=img.getImage();
	
     
      img1=new ImageIcon("result1.PNG");
	on1=img1.getImage();
			
		
		l=new JLabel("USERS RESULTS");
		l.setFont(f);
		l.setForeground(new Color(115,251,253));
		l.setBounds(780,10,400,150);
		add(l);
		
		l1=new JLabel("Available Users");
		l1.setFont(f2);
		l1.setForeground(new Color(115,251,253));
		l1.setBounds(450,450,250,150);
		add(l1);
		
		
		
		c2=new Choice();
		c2.setFont(f1);
		c2.setBackground(Color.black);
		c2.setForeground(new Color(115,251,253));
		c2.setBounds(770,500,250,100);
		add(c2);
		
		b1=new JButton("SEARCH");
		b1.setFont(f1);
		b1.setBounds(1100,500,150,50);
		b1.setForeground(new Color(115,251,253));
	b1.setBackground(Color.black);

		add(b1);
		
		
		b2=new JButton("BACK");
		b2.setFont(f1);
		b2.setBounds(100,800,150,50);
		b2.setForeground(new Color(115,251,253));
	    b2.setBackground(Color.black);

		add(b2);
		
		
		
	try
	 { 
	 	Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql:///online","root","root");
        Statement st=con.createStatement();
       
	   String s1="select * from registration";
	   ResultSet rs=st.executeQuery(s1);
	   
	   while(rs.next())
	   {
	   c2.add(rs.getString(1));  
		}
	 }
	
	 catch(Exception e1)
	 {
		 System.out.println(e1);
	 }
	   

		
	}
	
	 public void paintComponent(Graphics g)
    {
	super.paintComponent(g);
	g.drawImage(on,0,0,2000,1000,this);
	g.drawImage(on1,760,150,250,250,this);
	}
	
}