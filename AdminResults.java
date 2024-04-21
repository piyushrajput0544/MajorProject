import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
class AdminResults extends JPanel
{
	JTabbedPane tb1;
	MyResult1 myR1;
JButton b1;
JLabel l,l1;
//JTable table;
//DefaultTableModel model;
ImageIcon img,img2;
Image  on,on2;
AdminResults()
{
	
	Font f1=new Font("",5,25);
	Font f2=new Font("Arial Black",5,40);
	img=new ImageIcon("user.JPEG");
	on=img.getImage();
		
	 
	img2=new ImageIcon("result1.PNG");
	on2=img2.getImage();
	
	 setLayout(null); 
	 
	l1=new JLabel("USER NAME : ");
		l1.setFont(f2);
		l1.setForeground(new Color(115,251,253));
	    l1.setBackground(Color.black);
	l1.setBounds(700,10,600,100);
	add(l1); 
	l1=new JLabel("");
		l1.setFont(f2);
		l1.setForeground(Color.red);
	    l1.setBackground(Color.black);
	l1.setBounds(1000,10,300,100);
	add(l1);
	
	 tb1=new JTabbedPane();
	 tb1.setFont(f1);
	 tb1.setBounds(100,80,1400,800);
	
	
	 myR1=new MyResult1();
	 tb1.add("myR1",myR1); 
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
	
	
		b1=new JButton("EXIT");
		b1.setFont(f1);
		b1.setForeground(new Color(115,251,253));
	    b1.setBackground(Color.black);
		b1.setBounds(1650,700,100,50);
		add(b1);	
}
public void paintComponent(Graphics g)
    {
		
	 // Color bg=new Color(115,251,253);
	// g.setColor(bg);
	super.paintComponent(g);
	g.drawImage(on,0,0,2000,1000,this);
	g.drawImage(on2,1550,280,300,300,this);
	}



}
class MyResult1 extends JPanel
{
	JTable table;
    DefaultTableModel model;
	ImageIcon img1;
    Image  on1;
	MyResult1()
	{
		img1=new ImageIcon("user.JPEG");
	on1=img1.getImage();
		
		setLayout(new BorderLayout());
	Object[][] data={};
		String[] columnNames={"S.No","TestName" ,"TotalQuestion", " AttemptedQuestion ", "CorrectQ", "WrongQ", " MarksObtained "," TotalMarks"," Result"," Percentage"};				
	model=new DefaultTableModel(data,columnNames);	
					table=new JTable(model);
				//	table.setForeground(Color.yellow);
	             //   table.setBackground(Color.black);
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
	g.drawImage(on1,0,0,2000,1000,this);
//g.drawImage(on2,1350,280,300,300,this);
	}
}