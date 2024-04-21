import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class AdminDemo extends JPanel 
{
	ImageIcon img1,img2;
	Image on,on1;
	JTextField tx1;
	JPasswordField tx2;
	JButton b1,b2,b3;
	JLabel l;
AdminDemo()
{
	Font f=new Font("",5,25);
	Font f2=new Font("Arial Black",5,35);
    setLayout(null); 
	
	 l=new JLabel("ADMIN LOGIN");
		l.setFont(f2);
		l.setForeground(new Color(115,251,253));
     	l.setBackground(Color.black);
		l.setBounds(700,80,300,40);
		add(l);
		
	
    tx1=new JTextField();
	tx1.setBounds(700,420,250,50);
	//tx1.setBackground(Color.cyan);
	tx1.setFont(f);
    add(tx1);	
	
	tx2=new JPasswordField();
	tx2.setBounds(700,480,250,50);
	//tx2.setBackground(Color.cyan);
	tx2.setFont(f);
    add(tx2);
	
//	img3=new ImageIcon("back.JPG");
	//on2=img3.getImage();

	b1=new JButton("LOGIN");
	b1.setBounds(750,540,150,40);
	b1.setForeground(new Color(115,251,253));
	b1.setBackground(Color.black);
	b1.setFont(f);
	add(b1);
	
	b2=new JButton("BACK");
	b2.setBounds(20,800,150,40);
    b2.setForeground(new Color(115,251,253));

	b2.setBackground(Color.black);
	b2.setFont(f);
	add(b2);
	
	img1=new ImageIcon("admin1.PNG");
	on=img1.getImage();

    img2=new ImageIcon("user.JPEG");
	on1=img2.getImage();
   
  
}

	 public void paintComponent(Graphics g)
    {
	super.paintComponent(g);
	g.drawImage(on1,0,0,2000,1000,this);
	g.drawImage(on,700,150,250,250,this);
	//g.drawImage(on2,20,800,200,50,this);
    }	
  

}