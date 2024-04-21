// import java.awt.*;
// import java.sql.*;
// import javax.swing.*;
// class Users extends JPanel
// {    
    // JLabel l,l1;
	// Choice c2;
	// JButton b1,b2;
		// ImageIcon img,img1;
	// Image  on,on1;
	
	
	// Users()
	// {
		// setLayout(null);
		// Font f=new Font("Arial Black",5,50);
		// Font f1=new Font("",5,25);
		// Font f2=new Font("Arial Black",5,25);
		
					
	// img=new ImageIcon("user.JPEG");
	// on=img.getImage();
	
     
      // img1=new ImageIcon("user4.PNG");
	// on1=img1.getImage();
			
		
		// l=new JLabel("USERS");
		// l.setFont(f);
		// l.setForeground(new Color(115,251,253));
		// l.setBounds(780,10,400,150);
		// add(l);
		
		
		
		
		
		
		// b2=new JButton("BACK");
		// b2.setFont(f1);
		// b2.setBounds(100,800,150,50);
		// b2.setForeground(new Color(115,251,253));
	    // b2.setBackground(Color.black);

		// add(b2);
		
		
		
	   

		
	// }
	
	 // public void paintComponent(Graphics g)
    // {
	// super.paintComponent(g);
	// g.drawImage(on,0,0,2000,1000,this);
	// g.drawImage(on1,760,150,250,250,this);
	// }
	
// }









import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
class Users extends JPanel
{
	JTabbedPane tb1;
	 UDetails  UDetails;
JButton b2;
JLabel l,l1;
//JTable table;
//DefaultTableModel model;
ImageIcon img,img2,icon1;
Image  on,on2;
Users()
{
	
	Font f1=new Font("",5,25);
	Font f2=new Font("Arial Black",5,40);
	img=new ImageIcon("user.JPEG");
	on=img.getImage();
		
	 
	// img2=new ImageIcon("result1.PNG");
	// on2=img2.getImage();
	
	 icon1 = new ImageIcon("update1.jfif");
	 setLayout(null); 
	 
	l1=new JLabel("USER'S DETAILS");
		l1.setFont(f2);
		l1.setForeground(new Color(115,251,253));
	    l1.setBackground(Color.black);
	l1.setBounds(700,10,600,100);
	add(l1); 
	l1=new JLabel("");
		l1.setFont(f2);
		l1.setForeground(Color.red);
	    l1.setBackground(Color.black);
	l1.setBounds(1000,10,100,100);
	add(l1);
	
	 tb1=new JTabbedPane();
	 tb1.setFont(f1);
	// tb1.setBackground(Color.red);
	 tb1.setBounds(0,80,1900,800);
	
	
	 UDetails=new UDetails();
	 tb1.addTab("UDetails",icon1,UDetails); 
	 add(tb1);
	// Object[][] data={};
		// String[] columnNames={"Test" ,"TotalQuestion", " AttemptedQuestion ", "CorrectQ", "WrongQ", " MarksObtained "," TotalMarks"};				
	// model=new DefaultTableModel(data,columnNames);
	// //model.setColumnIdentifiers(columnNames);
				// table=new JTable(model);
				// //table.setSize(3000,1500);
				// //table.setLocation();
				// //setLayout(new GridLayout(7,1));
	
	// // panel=new JPanel();
		// add(new JScrollPane(table));
		// //add(new JPanel());
		// //add(panel);
		
	 // // setLayout(new GridLayout(7,7));
    // // Font f=new Font("",5,35);
	// // setLayout(null); 
	
	
		b2=new JButton("EXIT");
		b2.setFont(f1);
		b2.setForeground(new Color(115,251,253));
	    b2.setBackground(Color.black);
		b2.setBounds(800,890,100,50);
		add(b2);	
 }
public void paintComponent(Graphics g)
    {
		
	 // Color bg=new Color(115,251,253);
	// g.setColor(bg);
	super.paintComponent(g);
	g.drawImage(on,0,0,2000,1000,this);
	//g.drawImage(on2,1550,280,300,300,this);
	}



}
class UDetails extends JPanel
{
	JTable table;
    DefaultTableModel model;
	ImageIcon img,img2;
    Image  on,on2;
	UDetails ()
	{
		img=new ImageIcon("user.JPEG");
	on=img.getImage();
		
		setLayout(new BorderLayout());
	Object[][] data={};
		String[] columnNames={"S.No","UserName" ,"Name","FirstN","LastN", " MobileNo.", " Gender", "Email", " D.O.B "," College"," Address"};				
	model=new DefaultTableModel(data,columnNames);	
					table=new JTable(model);
					//table.setForeground(Color.yellow);
	                //table.setBackground(Color.black);
					table.setRowHeight(30);
					table.setFont(new Font("",5,20));
					JTableHeader t=table.getTableHeader();
					t.setFont(new Font("",5,20));
			//		setLayout(new GridLayout(7,7));
					add(new JScrollPane(table));

	}
	public void paintComponent(Graphics g)
    {
		
	 // Color bg=new Color(115,251,253);
	// g.setColor(bg);
	super.paintComponent(g);
	g.drawImage(on,0,0,2000,1000,this);
//g.drawImage(on2,1350,280,300,300,this);
	}
}