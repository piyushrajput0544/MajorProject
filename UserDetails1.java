import java.awt.*;
import javax.swing.*;
class UserDetails1 extends JPanel                 //not added
{
		ImageIcon img,img1;
	Image  on,on1;
	
	JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9;
	JTextField tx1,tx2,tx3,tx4,tx5,tx6,tx7,tx8;
	JTextField g,d;
	JTextArea t1;		
	JButton b1,b2,b3;
	
	// ButtonGroup bg;
	// JRadioButton rb1,rb2,rb3;
	
	//Choice c1,c2,c3;
	
	String s[];
	UserDetails1()						
	{
		setLayout(null);
		Font f=new Font("Arial Black",5,25);
		Font f1=new Font("Arial Black",5,30);
		Font f2=new Font("",5,20);
		
				
	img=new ImageIcon("user.JPEG");
	on=img.getImage();
		
	
      img1=new ImageIcon("user4.PNG");
	on1=img1.getImage();
		
		l=new JLabel("USER DETAILS");
		l.setFont(f1);
		l.setBackground(new Color(120,90,40));
		l.setForeground(new Color(115,251,253));
		l.setBounds(600,-10,400,150);
		add(l);
		
		l1=new JLabel("USERNAME");
		l1.setFont(f);
		l1.setForeground(new Color(115,251,253));
		l1.setBounds(200,100,200,100);
		add(l1);
		
		tx1=new JTextField();
		tx1.setFont(f);
		tx1.setBounds(410,130,300,40);
		add(tx1);
		
		l2=new JLabel("PASSWORD");
		l2.setFont(f);
		l2.setForeground(new Color(115,251,253));
		l2.setBounds(770,100,200,100);
		add(l2);
		
		tx2=new JTextField();
		tx2.setFont(f);
		tx2.setBounds(980,130,300,40);
		add(tx2);
	
		
		l3=new JLabel("NAME");
		l3.setFont(f);
		l3.setForeground(new Color(115,251,253));
		l3.setBounds(200,160,200,100);
		add(l3);
		
			
		tx3=new JTextField();
		tx3.setFont(f);
		tx3.setBounds(410,190,150,40);
		add(tx3);
		
		tx4=new JTextField();
		tx4.setFont(f);
		tx4.setBounds(600,190,150,40);
		add(tx4);
		
		tx5=new JTextField();
		tx5.setFont(f);
		tx5.setBounds(790,190,150,40);
		add(tx5);
		
		
		
		l4=new JLabel("MOBILE NO.");
		l4.setFont(f);
		l4.setForeground(new Color(115,251,253));
		l4.setBounds(200,220,200,100);
		add(l4);
		
			
		tx6=new JTextField();
		tx6.setFont(f);
		tx6.setBounds(410,250,300,40);
		add(tx6);
		
		
		l5=new JLabel("GENDER");
		l5.setFont(f);
		l5.setForeground(new Color(115,251,253));
		l5.setBounds(200,280,200,100);
		add(l5);
		
		
		// bg=new ButtonGroup();
		
		// rb1=new JRadioButton("MALE");
		// rb1.setFont(f2);
		// rb1.setBounds(410,315,100,30);
		// bg.add(rb1);
		// add(rb1);
		
		// rb2=new JRadioButton("FEMALE");
		// rb2.setFont(f2);
		// rb2.setBounds(530,315,120,30);
		// bg.add(rb2);
		// add(rb2);
		
		// rb3=new JRadioButton("OTHER");
		// rb3.setFont(f2);
		// rb3.setBounds(670,315,100,30);
		// bg.add(rb3);
		// add(rb3);
		
		g=new JTextField();
		g.setFont(f2);
		g.setBounds(410,315,100,30);
		add(g);
			
		l6=new JLabel("E-MAIL ID");
		l6.setFont(f);
		l6.setForeground(new Color(115,251,253));
		l6.setBounds(200,340,200,100);
		add(l6);
		
		
		tx7=new JTextField();
		tx7.setFont(f);
		tx7.setBounds(410,370,400,40);
		add(tx7);
		
			
		l7=new JLabel("D.O.B");
		l7.setFont(f);
		l7.setForeground(new Color(115,251,253));
		l7.setBounds(200,400,200,100);
		add(l7);
		
		
		d=new JTextField();
		d.setBounds(410,430,300,50);
		d.setFont(f2);
		add(d);
		
		// c1=new Choice();
		// c1.setFont(f2);
		// c1.setBounds(410,430,100,35);
		// for(int i=1;i<=31;i++)
		// {
			// c1.add(""+i);
		// }
		// add(c1);
		
		// s=new String[]{"JANUARY","FEBRUARY","MARCH","APRIL","MAY","JUNE","JULY","AUGUST","SEPTEMBER","OCTOBER","NOVEMBER","DECEMBER"};
		// c2=new Choice();
		// c2.setFont(f2);
		// c2.setBounds(530,430,150,35);
		// for(int i=0;i<12;i++)
		// {
			// c2.add(""+s[i]);
		// }
		// add(c2);
		
		// c3=new Choice();
		// c3.setFont(f2);
		// c3.setBounds(700,430,100,35);
		// for(int i=1947;i<=2022;i++)
		// {
			// c3.add(""+i);
		// }
		// add(c3);
		
		
			
		l8=new JLabel("COLLEGE");
		l8.setFont(f);
		l8.setForeground(new Color(115,251,253));
		l8.setBounds(200,460,200,100);
		add(l8);
		
		tx8=new JTextField();
		tx8.setFont(f);
		tx8.setBounds(410,490,400,40);
		add(tx8);
		
		l9=new JLabel("ADDRESS");
		l9.setFont(f);
		l9.setForeground(new Color(115,251,253));
		l9.setBounds(200,540,200,100);
		add(l9);
		
				
		t1=new JTextArea();
		t1.setFont(f);
		t1.setBounds(410,550,420,80);
		add(t1);
		
        // b1=new JButton("SUBMIT");
		// b1.setFont(f2);
		// b1.setBounds(600,700,120,50);
		// add(b1);
		
        // b2=new JButton("RESET");
		// b2.setFont(f2);
		// b2.setBounds(780,700,120,50);
		// add(b2);
		
        b1=new JButton("BACK");
		b1.setFont(f2);
		b1.setForeground(new Color(115,251,253));
	    b1.setBackground(Color.black);
		b1.setBounds(100,800,120,50);
		add(b1);
		
		//b1.addActionListener(this);
 	}
	 public void paintComponent(Graphics g)
    {
	super.paintComponent(g);
	g.drawImage(on,0,0,2000,1000,this);
		g.drawImage(on1,950,280,300,300,this);
	
	}
	
}