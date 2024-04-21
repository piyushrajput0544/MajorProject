import java.awt.*;
import javax.swing.*;
class AddCourses extends JPanel
{
	JTextField tx1,tx2,tx3,tx4,tx5;
	JButton b3,b4;
	JLabel l;
	ImageIcon img,img1;
	Image  on,on1;
AddCourses()
{
	Font f=new Font("",5,25);
	Font f1=new Font("",5,25);
		Font f2=new Font("Arial Black",5,40);

	setLayout(null); 
	 
	 
	   img=new ImageIcon("user.JPEG");
	on=img.getImage();	  


      img1=new ImageIcon("add1.PNG");
	on1=img1.getImage();
	
	  l=new JLabel("ADD COURSE");
		l.setFont(f2);
		l.setForeground(new Color(120,251,253));
     	l.setBackground(Color.black);
		l.setBounds(730,80,500,40);
		add(l);

	
     tx1=new JTextField();
	 tx1.setFont(f1);
	  tx1.setBounds(740,450,300,50);
	 add(tx1);
	 
     // tx2=new JTextField();
	 // tx2.setFont(f1);
	  // tx2.setBounds(770,550,70,50);
	 // add(tx2);
	 
     // tx3=new JTextField();
	 // tx3.setFont(f1);
	  // tx3.setBounds(850,550,70,50);
	 // add(tx3);
	 
     // tx4=new JTextField();
	 // tx4.setFont(f1);
	  // tx4.setBounds(930,550,70,50);
	 // add(tx4);
	  
     // tx5=new JTextField();
	 // tx5.setFont(f1);
	  // tx5.setBounds(850,650,70,50);
	 // add(tx5);
	 
	 b3=new JButton("ADD");
	 b3.setFont(f1);
	 b3.setBounds(820,550,150,50);
	b3.setForeground(new Color(115,251,253));
	b3.setBackground(Color.black);

	 add(b3);

	 b4=new JButton("BACK");
	 b4.setFont(f1);
	 b4.setBounds(100,840,150,50);
	b4.setForeground(new Color(115,251,253));
	b4.setBackground(Color.black);

	 add(b4);
	 
	 // b5=new JButton("Add");
	 // b5.setFont(f1);
	 // b5.setBounds(1110,450,150,40);
	 // b5.setBackground(Color.gray);
	 // add(b5);
	
    //img1=new ImageIcon("managecourse1.PNG");
	//on1=img1.getImage();
	
}
 // public void paintComponent(Graphics g)
    // {
	// super.paintComponent(g);
	// g.drawImage(on1,800,200,200,200,this);
	
    // }	
  
 public void paintComponent(Graphics g)
    {
	super.paintComponent(g);
	g.drawImage(on,0,0,2000,1000,this);
	g.drawImage(on1,760,150,250,250,this);
	
	
    }	
  
}