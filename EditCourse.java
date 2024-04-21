import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class EditCourse extends JPanel implements ActionListener
{
	JTabbedPane tb1;
	InsertDemo insert;
	ViewDemo view;
	UpdateDemo update;
	RemoveDemo remove;
	Font f;
	
	ImageIcon img,img1;
	ImageIcon icon1,icon2,icon3,icon4;
	Image  on,on1;
	//Fdemo f=new Fdemo();
	EditCourse()
	{
	
    setLayout(null);
	 
	  f=new Font("",5,25);
     
	   img=new ImageIcon("user.JPEG");
	on=img.getImage();	 
	
  img1=new ImageIcon("insert.PNG");
	on1=img.getImage();	  

  

	 tb1=new JTabbedPane();
	 tb1.setFont(f);
	 tb1.setBounds(100,50,1200,850);
    
	 icon1 = new ImageIcon("insert4.png");
	 icon2 = new ImageIcon("search.jfif");
	 icon3 = new ImageIcon("update1.jfif");
	 icon4 = new ImageIcon("delete1.jfif");
	 
	 insert=new InsertDemo();
	 view=new ViewDemo();
	 update=new UpdateDemo();
	 remove=new RemoveDemo();
	 

	 tb1.addTab("insert",icon1,insert); 
	 tb1.addTab("view",icon2,view);
	 tb1.addTab("update",icon3,update);
	 tb1.addTab("remove",icon4,remove);
	// tb1.setTabComponentAt(0,on1);
	 add(tb1);
	// insert.g=s;
	insert.b1.addActionListener(this);
	remove.b1.addActionListener(this);
  
	}
	// static void show()
	// {
		// g=Fdemo.globle;
	// }
	 public void paintComponent(Graphics g)
    {
	super.paintComponent(g);
	g.drawImage(on,0,0,2000,1000,this);
	g.drawImage(on1,100,50,200,100,this);
	
    }	
  
	public void actionPerformed(ActionEvent e)
	{
			
	  if(e.getSource()==insert.b1)
	  {
    String g=Fdemo.globle;
	 System.out.println(g);
     try
	 { 
	 //String g=online.globle;
	     String s1=insert.tx1.getText();
	     String s2=insert.t1.getText();
	     String s3=insert.o1.getText();
	     String s4=insert.o2.getText();
	     String s5=insert.o3.getText();
	     String s6=insert.o4.getText();
	     String s7=insert.c2.getSelectedItem();
		
		if(s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")||s5.equals("")||s6.equals(""))
		{
		JOptionPane.showMessageDialog(null,"All Fields are Mandotory");
		}
		else
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql:///online","root","root");
        Statement st=con.createStatement();
        String s="insert into "+g+" values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"')";
        st.executeUpdate(s);
       
			JOptionPane.showMessageDialog(null,"Data Insert Successfuly","My Title",JOptionPane.INFORMATION_MESSAGE);
			
			view.c1.add(s1);
			update.c1.add(s1);
			remove.c1.add(s1);
			
			insert.tx1.setText("");
			insert.t1.setText("");
			insert.o1.setText("");
			insert.o2.setText("");
			insert.o3.setText("");
			insert.o4.setText("");
		 
		} 
	 }	 
	 catch(Exception e1)
	 {
		 System.out.println(e1);
	 }
	 
   }
	  
	 if(e.getSource()==remove.b1)
	{
 	
    String g=Fdemo.globle;
	try
	 { 
	 	Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql:///online","root","root");
        Statement st=con.createStatement();
	 String s1=remove.c1.getSelectedItem();
	
	 String s22="delete from "+g+" where QID='"+s1+"' ";
       st.executeUpdate(s22); 
	   
	          	JOptionPane.showMessageDialog(null,"Data Remove Successfuly","My Title",JOptionPane.INFORMATION_MESSAGE);
	   
	    remove.t1.setText("");
		remove.o1.setText("");
		remove.o2.setText("");
		remove.o3.setText("");
		remove.o4.setText("");
		remove.tx2.setText("");
		
		
		
	
	view.t1.setText("");
	//view.tx1.setText("");
	view.o1.setText("");
	view.o2.setText("");
	view.o3.setText("");
	view.o4.setText("");
	view.l1.setText("");
	
	update.t1.setText("");
	update.tx2.setText("");
	update.o1.setText("");
	update.o2.setText("");
	update.o3.setText("");
	update.o4.setText("");
	

	view.c1.remove(s1);
	update.c1.remove(s1);
	remove.c1.remove(s1);
	 }	 
	 catch(Exception e1)
	 {
		 System.out.println(e1);
	 }
	
	}
	
  }
	
	
}
class InsertDemo extends JPanel implements ActionListener
{
	
	JTextArea t1;
	JTextField tx1,o1,o2,o3,o4;
	Choice c1,c2;
	//String g;
	JButton b,b1;
	ImageIcon img;
	Image  on;
InsertDemo()
{
	 setLayout(null); 
	Font f=new Font("",5,25);
	
	 img=new ImageIcon("user.JPEG");
	on=img.getImage();	  
	 
	  tx1=new JTextField();
	 tx1.setBounds(300,70,150,40);
	 tx1.setFont(f);
	 add(tx1);
	  
	  o1=new JTextField();
	 o1.setBounds(300,390,300,30);
	  o1.setFont(f);
	 add(o1);
	  
	  o2=new JTextField();
	 o2.setBounds(300,440,300,30);
	 o2.setFont(f);
	 add(o2);
	  
	  o3=new JTextField();
	 o3.setBounds(300,490,300,30);
	 o3.setFont(f);
	 add(o3);
	  
	  o4=new JTextField();
	 o4.setBounds(300,540,300,30);
	 o4.setFont(f);
	 add(o4);
 
	  // c1=new Choice();
	 // c1.setBounds(300,100,150,50);
	 // c1.setBackground(Color.black);
	 // c1.setForeground(Color.white);
	 // c1.setFont(f);
	 // add(c1);
	 
	 c2=new Choice();
	 c2.setBounds(302,600,200,40);
	 c2.add("Option A");
	 c2.add("Option B");
	 c2.add("Option C");
	 c2.add("Option D");
	 
	 c2.setBackground(Color.black);
	 c2.setForeground(Color.white);
	 c2.setFont(f);
	 add(c2);
	 
	  t1=new JTextArea();
	 t1.setBounds(300,150,900,200);
	// t1.setBackground(Color.black);
	 //t1.setForeground(new Color(115,251,253));
	 t1.setFont(f);
	 add(t1);
	
     b=new JButton("BACK");
	 b.setFont(f);
	 b.setBounds(70,700,130,50);
	b.setForeground(new Color(115,251,253));
	b.setBackground(Color.black);
	 add(b);
	 
	 b1=new JButton("SAVE");
	 b1.setFont(f);
	 b1.setBounds(800,500,150,50);
	b1.setForeground(new Color(115,251,253));
	b1.setBackground(Color.black);
	 add(b1);
	 
	// b1.addActionListener(this);
	 
}
public void actionPerformed(ActionEvent e)
{
	
}
 public void paintComponent(Graphics g)
    {
		Font f1=new Font("",5,30);
        g.setFont(f1);	
    Color bg=new Color(115,251,253);
	g.setColor(bg);
	super.paintComponent(g);
	g.drawImage(on,0,0,2000,1000,this);
   
  
		
//	super.paintComponent(g);
	g.drawString("Question ID :",100,100);
	g.drawString("Question  ",100,170);
	g.drawString("Statement :",100,200);
	g.drawString("Option A :",100,415);
	g.drawString("Option B :",100,465);
	g.drawString("Option C :",100,515);
	g.drawString("Option D :",100,565);
	g.drawString("Correct Option :",90,630);

    }	
}


















class ViewDemo extends JPanel implements ActionListener
{
	
	JTextArea t1;
	JTextField tx1,o1,o2,o3,o4;
	Choice  c1 ,c2;

	Font f,f1;
	JButton b,b2;
	JLabel l1;
	
	ImageIcon img;
	Image  on;
ViewDemo()
{
	 setLayout(null); 
	 f=new Font("",5,25);
	 f1=new Font("",5,10);
	 
	  img=new ImageIcon("user.JPEG");
	on=img.getImage();	  

	 
	  // tx1=new JTextField();
	 // tx1.setBounds(300,70,150,40);
	 // tx1.setFont(f);
	 // add(tx1);
	  
	  o1=new JTextField();
	 o1.setBounds(300,390,300,30);
	  o1.setFont(f);
	 add(o1);
	  
	  o2=new JTextField();
	 o2.setBounds(300,440,300,30);
	 o2.setFont(f);
	 add(o2);
	  
	  o3=new JTextField();
	 o3.setBounds(300,490,300,30);
	 o3.setFont(f);
	 add(o3);
	  
	  o4=new JTextField();
	 o4.setBounds(300,540,300,30);
	 o4.setFont(f);
	 add(o4);
	 
	 l1=new JLabel();
	 l1.setBounds(300,605,300,30);
	 l1.setBackground(Color.black);
	 l1.setForeground(Color.white);
	 l1.setFont(f);
	 add(l1);
	 
	
	  c1=new Choice();
	 c1.setBounds(300,70,150,50);
	 c1.setBackground(Color.black);
	 c1.setForeground(Color.white);
	 c1.setFont(f);
	add(c1);
	 
	
	 
	  t1=new JTextArea();
	 t1.setBounds(300,150,900,200);
	// t1.setBackground(Color.black);
	 //t1.setForeground(Color.white);
	 t1.setFont(f);
	 add(t1);
	
     b=new JButton("BACK");
	 b.setFont(f);
	 b.setBounds(70,700,130,50);
	b.setForeground(new Color(115,251,253));
	b.setBackground(Color.black);

	 add(b);
	 
	 
	 
	 b2=new JButton("SEARCH");
	 b2.setFont(f1);
	 b2.setBounds(480,70,80,30);
	b2.setForeground(new Color(115,251,253));
	b2.setBackground(Color.black);

	 add(b2);
	 

	 b2.addActionListener(this);
	

	// try
	 // { 
       // String g=""+Fdemo.globle;
	 	// Class.forName("com.mysql.cj.jdbc.Driver");
        // Connection con=DriverManager.getConnection("jdbc:mysql:///online","root","root");
        // Statement st=con.createStatement();
       
	   // String s1="select QID from "+g+"";
	   // ResultSet rs=st.executeQuery(s1);
	   
	   // while(rs.next())
	   // {
		  		  // c1.add(rs.getString(1));  
	 
		// }
	 // }
	
	 // catch(Exception e1)
	 // {
		 // System.out.println(e1);
	 // }
	   
}
public void actionPerformed(ActionEvent e)
{
     	String ss=c1.getSelectedItem();
		String g=""+Fdemo.globle;
		try
	 { 
	 	Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql:///online","root","root");
        Statement st=con.createStatement();
      
	   String s11="Select * from "+g+" where QID='"+ss+"'";
	   ResultSet rs1=st.executeQuery(s11);
	 
		while(rs1.next())
		{
		t1.setText(rs1.getString(2));
		o1.setText(rs1.getString(3));
		o2.setText(rs1.getString(4));
		o3.setText(rs1.getString(5));
		o4.setText(rs1.getString(6));
		l1.setText(rs1.getString(7));
		}
	 con.close();
	 
	  
	 }	 
	 catch(Exception e1)
	 {
		 System.out.println(e1);
	 }

}
 public void paintComponent(Graphics g)
    {
		Font f1=new Font("",5,30);
        g.setFont(f1);	
 Color bg=new Color(115,251,253);
	g.setColor(bg);		
	super.paintComponent(g);
	g.drawImage(on,0,0,2000,1000,this);
	g.drawString("Question ID :",100,100);
	g.drawString("Question  ",100,170);
	g.drawString("Statement :",100,200);
	g.drawString("Option A :",100,415);
	g.drawString("Option B :",100,465);
	g.drawString("Option C :",100,515);
	g.drawString("Option D :",100,565);
	g.drawString("Correct Option :",90,630);
    }	
}











class UpdateDemo extends JPanel implements ActionListener
{
	
	JTextArea t1;
	JTextField tx1,tx2,o1,o2,o3,o4;
	Choice c1,c2;
	JButton b,b1,b2;
	ImageIcon img;
	Image  on;
UpdateDemo()
{
	 setLayout(null); 
	Font f=new Font("",5,25);
	Font f1=new Font("",5,10);
	 
	  img=new ImageIcon("user.JPEG");
	on=img.getImage();
	  // tx1=new JTextField();
	 // tx1.setBounds(300,70,150,40);
	 // tx1.setFont(f);
	 // add(tx1);
	  
	  tx2=new JTextField();
	 tx2.setBounds(300,600,150,40);
	 tx2.setFont(f);
	 add(tx2);
	  
	  o1=new JTextField();
	 o1.setBounds(300,390,300,30);
	  o1.setFont(f);
	 add(o1);
	  
	  o2=new JTextField();
	 o2.setBounds(300,440,300,30);
	 o2.setFont(f);
	 add(o2);
	  
	  o3=new JTextField();
	 o3.setBounds(300,490,300,30);
	 o3.setFont(f);
	 add(o3);
	  
	  o4=new JTextField();
	 o4.setBounds(300,540,300,30);
	 o4.setFont(f);
	 add(o4);
 
	  c1=new Choice();
	 c1.setBounds(300,70,150,50);
	 c1.setBackground(Color.black);
	 c1.setForeground(Color.white);
	 c1.setFont(f);
	 add(c1);
	 
	 // c2=new Choice();
	 // c2.setBounds(302,600,200,40);
	 // c2.add("Option A");
	 // c2.add("Option B");
	 // c2.add("Option C");
	 // c2.add("Option D");
	 // c2.setBackground(Color.black);
	 // c2.setForeground(Color.white);
	 // c2.setFont(f);
	 // add(c2);
	 
	  t1=new JTextArea();
	 t1.setBounds(300,150,900,200);
	// t1.setBackground(Color.black);
	// t1.setForeground(Color.white);
	 t1.setFont(f);
	 add(t1);
	
     b=new JButton("BACK");
	 b.setFont(f);
	 b.setBounds(70,700,130,50);
	b.setForeground(new Color(115,251,253));
	b.setBackground(Color.black);

	 add(b);
	 
	 b1=new JButton("UPDATE");
	 b1.setFont(f);
	 b1.setBounds(800,500,150,50);
	b1.setForeground(new Color(115,251,253));
	b1.setBackground(Color.black);

	 add(b1);
	 
	 
     b2=new JButton("SEARCH");
	 b2.setFont(f1);
	 b2.setBounds(480,70,80,30);
	b2.setForeground(new Color(115,251,253));
	b2.setBackground(Color.black);

	 add(b2);
	 
	 b1.addActionListener(this);
	 b2.addActionListener(this);
	
	 
	 	 
	// try
	 // { 
	 	// Class.forName("com.mysql.cj.jdbc.Driver");
        // Connection con=DriverManager.getConnection("jdbc:mysql:///online","root","root");
        // Statement st=con.createStatement();
       
	   // String s1="select * from apptitute ";
	   // ResultSet rs=st.executeQuery(s1);
	   
	   // while(rs.next())
	   // {
		  		  // c1.add(rs.getString(1));  
	 
		// }
	 // }
	
	 // catch(Exception e1)
	 // {
		 // System.out.println(e1);
	 // }
	   
}
public void actionPerformed(ActionEvent e)
{
	if(e.getSource()==b2)
	{
		String g=""+Fdemo.globle;
 	String ss=c1.getSelectedItem();
		try
	 { 
	 	Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql:///online","root","root");
        Statement st=con.createStatement();
      
	   String s11="Select * from "+g+" where QID='"+ss+"'";
	   ResultSet rs1=st.executeQuery(s11);
	 
		while(rs1.next())
		{
		t1.setText(rs1.getString(2));
		o1.setText(rs1.getString(3));
		o2.setText(rs1.getString(4));
		o3.setText(rs1.getString(5));
		o4.setText(rs1.getString(6));
		tx2.setText(rs1.getString(7));
		}
	 con.close();
	  
	 }	 
	 catch(Exception e1)
	 {
		 System.out.println(e1);
	 }
	
	}
	 
	 
	 
	 
	 if(e.getSource()==b1)
	{
		String g=""+Fdemo.globle;
 	String ss=c1.getSelectedItem();
		try
	 { 
	 	Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql:///online","root","root");
        Statement st=con.createStatement();
	 String s1=c1.getSelectedItem();
	 String s2=t1.getText();
	 String s3=o1.getText();
	 String s4=o2.getText();
	 String s5=o3.getText();
	 String s6=o4.getText();
	 String s7=tx2.getText();
	 
	 if(s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")||s5.equals("")||s6.equals("")||s7.equals(""))
		{
		JOptionPane.showMessageDialog(null,"All Fields are Mandotory");
		}
	 
	 else
	 {
	   String s22="update "+g+" set QStatement='"+s2+"'  , A='"+s3+"'  , B='"+s4+"'   ,  C='"+s5+"'   , D='"+s6+"' ,   COption='"+s7+"' where QID='"+s1+"' ";
       st.executeUpdate(s22); 
	
       	JOptionPane.showMessageDialog(null,"Data Update Successfuly","My Title",JOptionPane.INFORMATION_MESSAGE);
		
		t1.setText("");
		o1.setText("");
		o2.setText("");
		o3.setText("");
		o4.setText("");
		tx2.setText("");
	 }	
	}	 
	 catch(Exception e1)
	 {
		 System.out.println(e1);
	 }
	
	}
	

}
 public void paintComponent(Graphics g)
    {
		Font f1=new Font("",5,30);
        g.setFont(f1);
 Color bg=new Color(115,251,253);
	g.setColor(bg);		
	super.paintComponent(g);
		g.drawImage(on,0,0,2000,1000,this);
	g.drawString("Question ID :",100,100);
	g.drawString("Question  ",100,170);
	g.drawString("Statement :",100,200);
	g.drawString("Option A :",100,415);
	g.drawString("Option B :",100,465);
	g.drawString("Option C :",100,515);
	g.drawString("Option D :",100,565);
	g.drawString("Correct Option :",90,630);

    }	
}













class RemoveDemo extends JPanel implements ActionListener
{
	
	JTextArea t1;
	JTextField tx1,tx2,o1,o2,o3,o4;
	Choice c1,c2;
	JButton b,b1,b2;
	ImageIcon img;
	Image  on;
RemoveDemo()
{
	 setLayout(null); 
	Font f=new Font("",5,25);
	Font f1=new Font("",5,10);
	 
	     
    img=new ImageIcon("user.JPEG");
	on=img.getImage();	  

	 
	  // tx1=new JTextField();
	 // tx1.setBounds(300,70,150,40);
	 // tx1.setFont(f);
	 // add(tx1);
	  
	  tx2=new JTextField();
	 tx2.setBounds(300,600,150,40);
	 tx2.setFont(f);
	 add(tx2);
	  
	  o1=new JTextField();
	 o1.setBounds(300,390,300,30);
	  o1.setFont(f);
	 add(o1);
	  
	  o2=new JTextField();
	 o2.setBounds(300,440,300,30);
	 o2.setFont(f);
	 add(o2);
	  
	  o3=new JTextField();
	 o3.setBounds(300,490,300,30);
	 o3.setFont(f);
	 add(o3);
	  
	  o4=new JTextField();
	 o4.setBounds(300,540,300,30);
	 o4.setFont(f);
	 add(o4);
 
	  c1=new Choice();
	 c1.setBounds(300,70,150,50);
	 c1.setBackground(Color.black);
	 c1.setForeground(Color.white);
	 c1.setFont(f);
	 add(c1);
	 
	 // c2=new Choice();
	 // c2.setBounds(302,600,200,40);
	 // c2.add("Option A");
	 // c2.add("Option B");
	 // c2.add("Option C");
	 // c2.add("Option D");
	 // c2.setBackground(Color.black);
	 // c2.setForeground(Color.white);
	 // c2.setFont(f);
	 // add(c2);
	 
	  t1=new JTextArea();
	 t1.setBounds(300,150,900,200);
	// t1.setBackground(Color.black);
	 //t1.setForeground(Color.white);
	 t1.setFont(f);
	 add(t1);
	
     b=new JButton("BACK");
	 b.setFont(f);
	 b.setBounds(70,700,130,50);
	b.setForeground(new Color(115,251,253));
	b.setBackground(Color.black);

	 add(b);
	 
	 b1=new JButton("REMOVE");
	 b1.setFont(f);
	 b1.setBounds(800,500,150,50);
	b1.setForeground(new Color(115,251,253));
	b1.setBackground(Color.black);

	 add(b1);
	 
	 
     b2=new JButton("SEARCH");
	 b2.setFont(f1);
	 b2.setBounds(480,70,80,30);
	b2.setForeground(new Color(115,251,253));
	b2.setBackground(Color.black);

	 add(b2);
	 
	
	 b2.addActionListener(this);
	
	 
	 	 
	// try
	 // { 
	 	// Class.forName("com.mysql.cj.jdbc.Driver");
        // Connection con=DriverManager.getConnection("jdbc:mysql:///online","root","root");
        // Statement st=con.createStatement();
       
	   // String s1="select * from apptitute ";
	   // ResultSet rs=st.executeQuery(s1);
	   
	   // while(rs.next())
	   // {
		  		  // c1.add(rs.getString(1));  
	 
		// }
	 // }
	
	 // catch(Exception e1)
	 // {
		 // System.out.println(e1);
	 // }
	   
}
public void actionPerformed(ActionEvent e)
{
	if(e.getSource()==b2)
	{
 	String ss=c1.getSelectedItem();
	String g=""+Fdemo.globle;
		try
	 { 
	 	Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql:///online","root","root");
        Statement st=con.createStatement();
      
	   String s11="Select * from "+g+" where QID='"+ss+"'";
	   ResultSet rs1=st.executeQuery(s11);
	 
		while(rs1.next())
		{
		t1.setText(rs1.getString(2));
		o1.setText(rs1.getString(3));
		o2.setText(rs1.getString(4));
		o3.setText(rs1.getString(5));
		o4.setText(rs1.getString(6));
		tx2.setText(rs1.getString(7));
		}
	 con.close();
	  
	 }	 
	 catch(Exception e1)
	 {
		 System.out.println(e1);
	 }
	
	}
	 
	 
	 
	
}
 public void paintComponent(Graphics g)
    {
		Font f1=new Font("",5,30);
        g.setFont(f1);
 Color bg=new Color(115,251,253);
	g.setColor(bg);		
	super.paintComponent(g);
		g.drawImage(on,0,0,2000,1000,this);
	g.drawString("Question ID :",100,100);
	g.drawString("Question  ",100,170);
	g.drawString("Statement :",100,200);
	g.drawString("Option A :",100,415);
	g.drawString("Option B :",100,465);
	g.drawString("Option C :",100,515);
	g.drawString("Option D :",100,565);
	g.drawString("Correct Option :",90,630);

    }	
}
