import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;





class Fdemo extends JFrame implements ActionListener
{
	CardLayout card;
	HomeDemo home;
    LoginDemo login;
	AdminDemo admin;
	UserDemo user;
	AdminPanel panel;
	ManageCourses manage;
	EditCourse course;
	UserLogin userlogin;
	UserRegistration registration;
	Verification verify;
	UserPanel up;
	UserDetails details;
	Container cn=getContentPane();
	UserTest test;
	AddCourses AddC;
	Result result;
	AllResults AllR;
	Users u;
//	UserDetails1 details1;
	UsersResult ur;
	AdminResults AdminRes;
	EditDetails editD;
	 public static String globle=new String("");
	 static int x=0;
	static int q=0;
     int SNo=0;
	 int s=0;//validation
	static String QID="";
	static String COption="";
	 static String ans="";
	 static String QIDP="";
	static String COptionP="";
	 static String ansP="";
	static int attemptedQuestion=0;
	static int remaningQuestion=0;
	static String name="";
			// JTable table;
			// DefaultTableModel model;
Fdemo()
{
	setTitle("ONLINE EXAMINATION SYSTEM");
	card=new CardLayout();
	setLayout(card);
	


	// Object[][] data={{"a","1","2","3","4","5","6"}};
		// String[] columnNames={"Test" ,"TotalQuestion", " AttemptedQuestion ", "CorrectQ", "WrongQ", " MarksObtained "," TotalMarks"};				
	// model=new DefaultTableModel(data,columnNames);;
				// table=new JTable(model);
  // table.setLayout(new GridLayout(3,1));

	//model=new DefaultTableModel(data,columnNames);
	



	home=new HomeDemo();
	add("home",home);
	
	login=new LoginDemo();
	add("login",login);
	
	admin=new AdminDemo();
	add("admin",admin);
	
	user=new UserDemo();
	add("user",user);
	
	panel=new AdminPanel();
	add("panel",panel);
	
	manage=new ManageCourses();
	add("manage",manage);
	
	course=new EditCourse();
	add("course",course);
	
	userlogin=new UserLogin();
     add("userlogin",userlogin);
	
	registration=new UserRegistration();
	add("registration",registration);
	
	verify=new Verification();
	add("verify",verify);
	
	up=new UserPanel();
	add("up",up);
	
	details=new UserDetails();
	add("details",details);
	
	// details1=new UserDetails1();
	// add("details1",details1);
	
	test=new UserTest();
	add("test",test);
	
	AddC=new AddCourses();
	add("AddC",AddC);
	
	result=new Result();
	add("result",result);
	
	AllR=new AllResults();
	add("AllR",AllR);
	
	u=new Users();
	add("u",u);
	
	ur=new UsersResult();
	add("ur",ur);
	
	AdminRes=new AdminResults();
	add("AdminRes",AdminRes);
	
	editD=new EditDetails();
	add("editD",editD);
	
	home.b2.addActionListener(this);

	login.b1.addActionListener(this);
	login.b2.addActionListener(this);
	login.b3.addActionListener(this); 
	
	admin.b1.addActionListener(this);
	admin.b2.addActionListener(this);
	
	user.b1.addActionListener(this);
	user.b2.addActionListener(this);
	user.b3.addActionListener(this);
	
	panel.b1.addActionListener(this);
	panel.b2.addActionListener(this);
	panel.b3.addActionListener(this);
	panel.b4.addActionListener(this);
	panel.b5.addActionListener(this);
	panel.b6.addActionListener(this);
	
	manage.b1.addActionListener(this);
	manage.b2.addActionListener(this);
	manage.b4.addActionListener(this);
	manage.b5.addActionListener(this);
	

	course.insert.b.addActionListener(this);
	course.view.b.addActionListener(this);
	
	
	registration.b1.addActionListener(this);
	registration.b3.addActionListener(this);
	
	
	verify.b1.addActionListener(this);
	verify.b2.addActionListener(this);
	verify.b3.addActionListener(this);
	verify.b4.addActionListener(this);
	
	
	up.b1.addActionListener(this);
	up.b2.addActionListener(this);
	up.b3.addActionListener(this);
	up.b4.addActionListener(this);
	
	details.b3.addActionListener(this);
	
   AddC.b3.addActionListener(this);
   AddC.b4.addActionListener(this);
	
test.b1.addActionListener(this);	
test.b2.addActionListener(this);	
test.b4.addActionListener(this);

result.b1.addActionListener(this);	
AllR.b1.addActionListener(this);

//u.b1.addActionListener(this);
u.b2.addActionListener(this);

ur.b1.addActionListener(this);
ur.b2.addActionListener(this);

AdminRes.b1.addActionListener(this);

//details1.b1.addActionListener(this);
editD.b1.addActionListener(this);
editD.b3.addActionListener(this);
}


public void nextQuestion(String s)
	{
		      x+=1;
			 q+=1; 
			  try
			{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///online","root","root");
			Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=st.executeQuery("select * from "+s+" ");
			
			rs.absolute(x);
			    QID=""+rs.getString(1);
				
			    test.t1.setText(rs.getString(2));
				test.l1.setText(rs.getString(3));
				test.l2.setText(rs.getString(4));
				test.l3.setText(rs.getString(5));
				test.l4.setText(rs.getString(6));
				
				COption=""+rs.getString(7);
				card.show(cn,"test");
              rs=st.executeQuery("select * from test where QID='"+QID+"' ");
             if(rs.next())
			 {
				 QIDP=rs.getString(1);
				 ansP=rs.getString(2);
				 COptionP=rs.getString(3);
			
				  System.out.println("if1.....");
			  if(ansP.equals("Option A"))
			  {
				  System.out.println("A1");
			 test.rb1.setSelected(true);
		      } 
			 
			else if(ansP.equals("Option B"))
			  {
				  System.out.println("B1");
			 test.rb2.setSelected(true);

		      } 
			 
			 else if(ansP.equals("Option C"))
			  {
				  System.out.println("c1");
			  test.rb3.setSelected(true);

		      } 
			 
			 else if(ansP.equals("Option D"))
			  {
             System.out.println("d1");
			 test.rb4.setSelected(true);
		      } 
			
		   }
		   else
			  test.bg.clearSelection(); 
				
			String ques=up.c1.getSelectedItem();	
			
			
			
			rs=st.executeQuery("select count(*) from test");
			rs.next();
			int count=rs.getInt(1);
		//	attemptedQuestion=count;
			rs=st.executeQuery("select count(*) from "+ques+"");
			rs.next();
			int count1=rs.getInt(1);
			//System.out.println(count1);
			remaningQuestion=count1-count;
			
			
			// rs=st.executeQuery("select count(*) from "+ques+"");
			// rs.next();	
			// remaningQuestion=rs.getInt(1);
			 test.l6.setText("Q Remaining : "+remaningQuestion);
			con.close();
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			} 
	}
	


public void actionPerformed(ActionEvent e)
{
		String ques=up.c1.getSelectedItem();
		ans="";
	 if(e.getSource()==test.b2)
		   {
			  
           
			 if(test.rb1.isSelected())
			  {
			 ans="Option A";
		      } 
			 
			else if(test.rb2.isSelected())
			  {
			 ans="Option B";
		      } 
			 
			 else if(test.rb3.isSelected())
			  {
			 ans="Option C";
		      } 
			 
			 else if(test.rb4.isSelected())
			  {
			 ans="Option D";
		      } 
			 if(ans!="")
			 {
			try
			{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///online","root","root");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from test where QID='"+QID+"'");
			if(rs.next())
			{
			st.executeUpdate("update test set ans='"+ans+"' , COption='"+COption+"' where QID='"+QID+"'");	
	
		}
			else if(ans!="")
			{
			st.executeUpdate("insert into  test values ('"+QID+"','"+ans+"','"+COption+"')");
		
			}
			
		rs=st.executeQuery("select count(*) from test");
			rs.next();
			System.out.println("r1");
			int count=rs.getInt(1);
			attemptedQuestion=count;
			rs=st.executeQuery("select count(*) from "+ques+"");
			rs.next();
			System.out.println("r2");
			int count1=rs.getInt(1);
			//System.out.println(count1);
			remaningQuestion=count1-count;
			System.out.println("r3");
			rs.absolute(x);
			con.close();
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
			
			
			 }
			 
		   	
			// rs=st.executeQuery("select count(*) from test");
			// rs.next();
			// System.out.println("r1");
			// int count=rs.getInt(1);
			// attemptedQuestion=count;
			// rs=st.executeQuery("select count(*) from "+ques+"");
			// rs.next();
			// System.out.println("r2");
			// int count1=rs.getInt(1);
			// //System.out.println(count1);
			// remaningQuestion=count1-count;
			// System.out.println("r3");
			

			  
			nextQuestion(ques);
			test.lq.setText("Q."+x);
			//**
			// if(test.rb1.isSelected()||test.rb2.isSelected()||test.rb3.isSelected()||test.rb4.isSelected())
			// {
				// attemptedQuestion++;
			// }
			
			
			
			 test.l5.setText("Q Attempted : "+attemptedQuestion);
			 test.l6.setText("Q Remaining : "+remaningQuestion);
		


			//test.bg.clearSelection();
			//**
			
			
			
			//if(checkAnswer()){}
		   }
		  else  if(e.getSource()==test.b1)
		   {
			  x-=1;
			   q-=1;
			 QIDP="";  
				
			// if(test.rb1.isSelected()||test.rb2.isSelected()||test.rb3.isSelected()||test.rb4.isSelected())
			// {
				// attemptedQuestion++;
			// }
			 // test.l5.setText("Q Attempted"+attemptedQuestion);
			  try
			{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///online","root","root");
			Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=st.executeQuery("select * from "+ques+" ");
			rs.absolute(x);
				 QID=""+rs.getString(1);
			    test.t1.setText(rs.getString(2));
				test.l1.setText(rs.getString(3));
				test.l2.setText(rs.getString(4));
				test.l3.setText(rs.getString(5));
				test.l4.setText(rs.getString(6));	
				COption=""+rs.getString(7);
			rs=st.executeQuery("select * from test where QID='"+QID+"' ");
             if(rs.next())
			 {
				 QIDP=rs.getString(1);
				 ansP=rs.getString(2);
				 COptionP=rs.getString(3);
			 }				 
			con.close();
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
			test.bg.clearSelection();
			
			test.lq.setText("Q."+x);
			
			System.out.println(QID);
			System.out.println(QIDP);
			System.out.println(ansP);
			System.out.println(COptionP);
				//String ques=up.c1.getSelectedItem();
	 if(QIDP!="")
		   {
				  System.out.println("if.....");
			  if(ansP.equals("Option A"))
			  {
				  System.out.println("A");
			 test.rb1.setSelected(true);
		      } 
			 
			else if(ansP.equals("Option B"))
			  {
				  System.out.println("B");
			 test.rb2.setSelected(true);

		      } 
			 
			 else if(ansP.equals("Option C"))
			  {
				  System.out.println("c");
			  test.rb3.setSelected(true);

		      } 
			 
			 else if(ansP.equals("Option D"))
			  {
             System.out.println("d");
			 test.rb4.setSelected(true);
		      } 
		   }
		
		   
		
		   }
	if(e.getSource()==up.b4)
	{
		test.t1.setText("");
		test.l1.setText("");
		test.l2.setText("");
		test.l3.setText("");
		test.l4.setText("");
		
		card.show(cn,"test");
		test.l.setText(ques.toUpperCase()+"  Test");
	    nextQuestion(ques);
		test.lq.setText("Q."+x);
	    test.l5.setText("Q Attempted : "+attemptedQuestion);
	   // test.l6.setText("Q Remaining: "+remaningQuestion);
	}
	

	if(e.getSource()==test.b4)
	{
			try
			{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///online","root","root");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select  count(*) from "+ques+"");
			rs.next();
			int total=rs.getInt(1);
			
			result.t1.setText(""+ques);
			result.t2.setText(""+total);
			rs=st.executeQuery("select count(*) from test");
			rs.next();
			int count=rs.getInt(1);
			result.t3.setText(""+count);
			
			rs=st.executeQuery("select count(*) from test where ans=COption");
			rs.next();
			int correct=rs.getInt(1);
			result.t4.setText(""+correct);
			 
			 int wrong=count-correct;
			result.t5.setText(""+wrong);
			
             int marksO=correct*5;				 
			float f1=marksO;
			result.t6.setText(""+marksO);
			
             int marksT=total*5;
            float f2=marksT;			 
			result.t7.setText(""+marksT);
			
			float f=f1/f2*100;
			String res="";
			if(f>=40.0f)
				res="PASS";
			else
			res="FAIL";
			String time="00";
			st.executeUpdate("insert into AllResult ( UserName,Test,TotalQuestion,AttemptedQuestion, CorrectQ, WrongQ, MarksObtained,TotalMarks, Result, Percentage,TimeTaken) values ('"+name+"','"+ques+"','"+total+"','"+count+"','"+correct+"','"+wrong+"','"+marksO+"','"+marksT+"','"+res+"','"+f+"','"+time+"')");
			//rs.absolute(x);
      JOptionPane.showMessageDialog(null,"Test Submit Successfuly","TestSubmit",JOptionPane.ERROR_MESSAGE);     
	  card.show(cn,"result");
			con.close();
			}
			catch(Exception e1)
			{
				System.out.println(e1);
		
			}
		
	}
	
	
	if(e.getSource()==result.b1)
	{
		x=0;
		q=0;
		ans="";
		COption="";
		QID="";
		
		attemptedQuestion=0;
			try
			{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///online","root","root");
			Statement st=con.createStatement();
			st.executeUpdate("delete from test");
			//rs.absolute(x);
			con.close();
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
	       card.show(cn,"up");
	}
	
	if(e.getSource()==up.b2)
	{
	//	String s=user.tx1.getText();
		//AllR.l1.setText(""+s);
	//	f.setBackground(Color.black);
	SNo=0;
		try
			{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///online","root","root");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from AllResult where UserName='"+name+"'");
			//rs.absolute(x);
		 // Object[][] data={{},{},{}};
		// String[] columnNames={"Test" ,"TotalQuestion", " AttemptedQuestion ", "CorrectQ", "WrongQ", " MarksObtained "," TotalMarks"};
			////model=new DefaultTableModel(data,columnNames);
		//	table=new JTable(model);
			AllR.myR.model.setRowCount(0);
			while(rs.next())
			{
				SNo++;
				System.out.println("a");
    // int rollno=Integer.parseInt(t1.getText().toString());
	// String name=t2.getText().toString();
	// int age=Integer.parseInt(t3.getText().toString());
	
	Object[] newRow={""+SNo,""+rs.getString(3),""+rs.getString(4),""+rs.getString(5),""+rs.getString(6),""+rs.getString(7),""+rs.getString(8),""+rs.getString(9),""+rs.getString(10),""+rs.getString(11),""+rs.getString(12)};
	AllR.myR.model.addRow(newRow);
				
			}
			validate();

			con.close();
		card.show(cn,"AllR");
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
		
	}
	
		
	if(e.getSource()==AllR.b1)
	{
		card.show(cn,"up");
		
	}
	
	
	if(e.getSource()==manage.b1)
	{
	String s=manage.l1.getSelectedItem();
	try
	 { 
	 	Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql:///online","root","root");
        Statement st=con.createStatement();
	 //  st.executeUpdate("delete from course where Cname="+s+" ");
       
	   String s1="drop table "+s+"";
	   st.executeUpdate(s1);
	   
	   s1="delete from course where Cname='"+s+"'";
	   st.executeUpdate(s1);
	   JOptionPane.showMessageDialog(null,"successful delete","DELETE",JOptionPane.ERROR_MESSAGE);
	   manage.l1.remove(""+s);
	   up.c1.remove(""+s);
	 }
	
	 catch(Exception e1)
	 {
		 System.out.println(e1);
	 }
		
	}
	
	
	if(e.getSource()==home.b2)
	card.show(cn,"login");
       
	 if(e.getSource()==login.b1)
	card.show(cn,"admin");

    if(e.getSource()==login.b2)
	card.show(cn,"user");

    if(e.getSource()==login.b3)
	card.show(cn,"home");

    if(e.getSource()==admin.b2)
	card.show(cn,"login");

    if(e.getSource()==user.b2)
	card.show(cn,"login");

    if(e.getSource()==panel.b5)
    card.show(cn,"verify");

  
    if(e.getSource()==panel.b4)
	{
    card.show(cn,"u");
	
		  SNo=0;
	  try
			{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///online","root","root");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from registration");
			//rs.absolute(x);
		 // Object[][] data={{},{},{}};
		// String[] columnNames={"Test" ,"TotalQuestion", " AttemptedQuestion ", "CorrectQ", "WrongQ", " MarksObtained "," TotalMarks"};
			////model=new DefaultTableModel(data,columnNames);
		//	table=new JTable(model);
			u.UDetails.model.setRowCount(0);
			while(rs.next())
			{
				SNo++;
				System.out.println("a");
    // int rollno=Integer.parseInt(t1.getText().toString());
	// String name=t2.getText().toString();
	// int age=Integer.parseInt(t3.getText().toString());
	
	Object[] newRow={""+SNo,""+rs.getString(1),""+rs.getString(3),""+rs.getString(4),""+rs.getString(5),""+rs.getString(6),""+rs.getString(7),""+rs.getString(8),""+rs.getString(9)+rs.getString(10)+rs.getString(11),""+rs.getString(12),""+rs.getString(13)};
//u.UDetails.model.setRowCount(0);
			u.UDetails.model.addRow(newRow);
			}
			validate();
			con.close();
 card.show(cn,"u");
		//card.show(cn,"AllR");
 // card.show(cn,"AdminRes");
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}

	}
  
    if(e.getSource()==panel.b2)
    card.show(cn,"ur");

    if(e.getSource()==AdminRes.b1)
    card.show(cn,"ur");

     if(e.getSource()==ur.b2)
		 card.show(cn,"panel");
	 if(e.getSource()==editD.b3)
		 card.show(cn,"up");
	 
  if(e.getSource()==ur.b1)
  {
	  SNo=0;
	  String s=ur.c2.getSelectedItem();
	  AdminRes.l1.setText(""+s);
	  try
			{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///online","root","root");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from AllResult where UserName='"+s+"'");
			//rs.absolute(x);
		 // Object[][] data={{},{},{}};
		// String[] columnNames={"Test" ,"TotalQuestion", " AttemptedQuestion ", "CorrectQ", "WrongQ", " MarksObtained "," TotalMarks"};
			////model=new DefaultTableModel(data,columnNames);
		//	table=new JTable(model);
			AdminRes.myR1.model.setRowCount(0);
			while(rs.next())
			{
				SNo++;
				System.out.println("a");
    // int rollno=Integer.parseInt(t1.getText().toString());
	// String name=t2.getText().toString();
	// int age=Integer.parseInt(t3.getText().toString());
	
	Object[] newRow={""+SNo,""+rs.getString(3),""+rs.getString(4),""+rs.getString(5),""+rs.getString(6),""+rs.getString(7),""+rs.getString(8),""+rs.getString(9),""+rs.getString(10),""+rs.getString(11),""+rs.getString(12)};
	AdminRes.myR1.model.addRow(newRow);
				
			}
			validate();

			con.close();
		//card.show(cn,"AllR");
  card.show(cn,"AdminRes");
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
		
	  
	  
	  
  
  }
  
  if(e.getSource()==up.b1)
  {
	 
	  
	  try
	 {
	
     	Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql:///online","root","root");
        Statement st=con.createStatement();
        String s="select * from registration where username='"+name+"' ";
        ResultSet rs=st.executeQuery(s);
        if(rs.next())
		{
		//card.show(cn,"details");
		 card.show(cn,"editD");
		
		 
	    editD.tx1.setText(rs.getString(1));//username
	     editD.tx2.setText(rs.getString(2));//password
	     editD.tx3.setText(rs.getString(3));//name
	     editD.tx4.setText(rs.getString(4));//2
	     editD.tx5.setText(rs.getString(5));//3
	     editD.tx6.setText(rs.getString(6));//mobile no.
	     
		 editD.g.setText(rs.getString(7));//mobile no.
		 
		
		  editD.tx7.setText(rs.getString(8));//E-MAI
		  
		 
		  editD.c1.setText(rs.getString(9));
		  editD.c2.setText(rs.getString(10));
		  editD.c3.setText(rs.getString(11));
		 
	      // editD.c1.setSelectedItem(rs.getString(9));//D.O.B
	      // editD.c2.setSelectedItem(rs.getString(10));//1
	      // editD.c3.setSelectedItem(rs.getString(11));//2
		 
		 editD.tx8.setText(rs.getString(12));//college
		    editD.t1.setText(rs.getString(13));//address
		
		}
	 }
	 catch(Exception e4)
	 {
		 System.out.println(e4);
	 }

	  
  }
  
  if(e.getSource()==editD.b1)
  {
	   try
	 { 
	  String  s1=editD.tx1.getText();//username
	     
		 String s2=editD.tx2.getText();//password
	   
		 String s3=editD.tx3.getText();//name
	     String s4=editD.tx4.getText();//2
	     String s5=editD.tx5.getText();//3
	     
		  String s6=editD.tx6.getText();//mobile no.
		 
		 String s7=editD.g.getText();
		 // if(registration.rb1.isSelected())
			 
		 // {
			 // s7=registration.rb1.getLabel();
		 // } 
		 
		 // if(registration.rb2.isSelected())
		 // {
			 // s7=registration.rb2.getLabel();
		 // }
	      
		 // if(registration.b3.isSelected())
		 // {
			 // s7=registration.rb3.getLabel();
		 // }
	     
	     String s8=editD.tx7.getText();//E-MAIL
		 
	     String s9=editD.c1.getText();//D.O.B
	     String s10=editD.c2.getText();//1
	     String s11=editD.c3.getText();//2
		 
		 String s12=editD.tx8.getText();//college
		 String s13=editD.t1.getText();//address
		 
		  Class.forName("com.mysql.cj.jdbc.Driver");
          Connection con=DriverManager.getConnection("jdbc:mysql:///online","root","root");
          Statement st=con.createStatement();
          String s="update  registration set  password='"+s2+"', name1='"+s3+"', name2='"+s4+"',name3='"+s5+"', mobile='"+s6+"', gender='"+s7+"',email='"+s8+"', date='"+s9+"',month='"+s10+"', year='"+s11+"',college='"+s12+"', address='"+s13+"' where  username='"+s1+"'";
          st.executeUpdate(s);
       
          
      //  String q="insert into verify values('"+s1+"')";
		//st.executeUpdate(q);
		  //verify.c2.add("abhi");
			//verify.c2.add(s1);  
			
			JOptionPane.showMessageDialog(null,"Update Successfuly","My Title",JOptionPane.INFORMATION_MESSAGE);
			
			
			card.show(cn,"up");
		    // editD.tx1.setText("");
			// editD.tx2.setText("");
			// editD.tx3.setText("");
			// editD.tx4.setText("");
			// editD.tx5.setText("");
			// editD.tx6.setText("");
		    // editD.tx7.setText("");
		// editD.tx8.setText("");
			// editD.t1.setText("");
			// editD.g.setText("");
			// editD.c1.setText("");
			// editD.c2.setText("");
			// editD.c3.setText("");
			
	 }	 
	 catch(Exception e12)
	 {
		 System.out.println(e12);
	 }
  }
  
  
  
    if(e.getSource()==panel.b1)
	{
    card.show(cn,"manage");
	
	 // try
	 // { 
	 	// Class.forName("com.mysql.cj.jdbc.Driver");
        // Connection con=DriverManager.getConnection("jdbc:mysql:///online","root","root");
        // Statement st=con.createStatement();
       // String s1="select * from course";
	   // //String s1="create table "+s+" (QID varchar(20),QStatement varchar(10000),A varchar(50),B varchar(50),C varchar(50),D varchar(50))";
	   // ResultSet rs=st.executeQuery(s1);
	   // while(rs.next())
		   // manage.l1.add(rs.getString(1));
	   
	 // }
	
	 // catch(Exception e1)
	 // {
		 // System.out.println(e1);
	 // }
	
	
	}

   if(e.getSource()==manage.b4)
	   card.show(cn,"panel");
   
     if(e.getSource()==manage.b5)
	   card.show(cn,"AddC");
   
   if(e.getSource()==panel.b3)
   {
	   JOptionPane.showMessageDialog(null,"successful logout","LOGOUT",JOptionPane.ERROR_MESSAGE);
	   card.show(cn,"admin");
   }
   if(e.getSource()==manage.b2)
   {
	    globle=manage.l1.getSelectedItem();
		
		
		course.update.c1.removeAll();
		course.view.c1.removeAll();
		course.remove.c1.removeAll();
		  
	   course.remove.t1.setText("");
		course.remove.o1.setText("");
		course.remove.o2.setText("");
		course.remove.o3.setText("");
		course.remove.o4.setText("");
		course.remove.tx2.setText("");
		
	course.view.t1.setText("");
	//view.tx1.setText("");
	course.view.o1.setText("");
	course.view.o2.setText("");
	course.view.o3.setText("");
	course.view.o4.setText("");
	course.view.l1.setText("");
	
	course.update.t1.setText("");
	course.update.tx2.setText("");
	course.update.o1.setText("");
	course.update.o2.setText("");
	course.update.o3.setText("");
	course.update.o4.setText("");
	
	
	   card.show(cn,"course");
	   
	try
	 { 
      // String g=""+Fdemo.globle;
	 	Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql:///online","root","root");
        Statement st=con.createStatement();
       
	   String s1="select QID from "+globle+"";
	   ResultSet rs=st.executeQuery(s1);
	   
	   while(rs.next())
	   {
		  course.view.c1.add(rs.getString(1));	 
		   course.remove.c1.add(rs.getString(1));	 
		   course.update.c1.add(rs.getString(1));	 
		  // view.c1.add(rs.getString(1));	 
		}
	 }
	
	 catch(Exception e1)
	 {
		 System.out.println(e1);
	 }

	   
   }
   
	if(e.getSource()==course.insert.b)
		card.show(cn,"manage");
	   
	if(e.getSource()==course.view.b)
		card.show(cn,"manage");
	
	if(e.getSource()==user.b3)
		card.show(cn,"registration");
	
	if(e.getSource()==registration.b3)
		card.show(cn,"user");
	
	if(e.getSource()==up.b3)
	{
		 JOptionPane.showMessageDialog(null,"successful logout","LOGOUT",JOptionPane.ERROR_MESSAGE);
		card.show(cn,"user");
	}
	if(e.getSource()==details.b3)
		card.show(cn,"verify");
	
	
	
	if(e.getSource()==AddC.b4)
		card.show(cn,"manage");
	
	if(e.getSource()==AddC.b3)
	{
		String s=AddC.tx1.getText();
		
		
	    if(s.equals(""))
		{
		JOptionPane.showMessageDialog(null,"please fill course name");
		}
		else{
		manage.l1.add(s);
		up.c1.add(s);
	
	try
	 { 
	 	Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql:///online","root","root");
        Statement st=con.createStatement();
       
	   String s1="create table "+s+" (QID varchar(20),QStatement varchar(10000),A varchar(50),B varchar(50),C varchar(50),D varchar(50),COption varchar(30))";
	   st.executeUpdate(s1);
	 }
	
	 catch(Exception e1)
	 {
		 System.out.println(e1);
	 }
	
	
	try
	 { 
	 	Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql:///online","root","root");
        Statement st=con.createStatement();
       String s1="insert into course values('"+s+"')";
	   //String s1="create table "+s+" (QID varchar(20),QStatement varchar(10000),A varchar(50),B varchar(50),C varchar(50),D varchar(50))";
	   st.executeUpdate(s1);
	   
	    JOptionPane.showMessageDialog(AddC.b3,"Course Add Successfuly","AddCourse",JOptionPane.ERROR_MESSAGE);
	 }
	
	 catch(Exception e1)
	 {
		 System.out.println(e1);
	 }
	
		AddC.tx1.setText("");
		card.show(cn,"manage");
		}
	}
		
	
    if(e.getSource()==panel.b6)
	{
		
		String p=JOptionPane.showInputDialog(null,"Change password","MY TYTLE",JOptionPane.INFORMATION_MESSAGE);
		
				
	try
	 { 
	 	Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql:///online","root","root");
        Statement st=con.createStatement();
       
	   String s1="update adminlogin set password='"+p+"'";
	   st.executeUpdate(s1);
	   
	 }
	
	 catch(Exception e1)
	 {
		 System.out.println(e1);
	 }
	   

	}
	
	if(e.getSource()==admin.b1)
	  {
     try
	 { 
	     String s1=admin.tx1.getText();
	     String s2=admin.tx2.getText();
		 
		Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql:///online","root","root");
        Statement st=con.createStatement();
        String s="select * from AdminLogin where name='"+s1+"'and password='"+s2+"'";
        ResultSet rs=st.executeQuery(s);
        if(rs.next())
		{
			card.show(cn,"panel");
		}			
		else
		{
			JOptionPane.showMessageDialog(null,"Invalid UserName and Password","My Title",JOptionPane.ERROR_MESSAGE);
		}
		admin.tx1.setText("");
	    admin.tx2.setText("");
		 
	 }	 
	 catch(Exception e1)
	 {
		 System.out.println(e);
	 }
	  }
	  
	  
	  
	  if(e.getSource()==verify.b1)
	 {

		String s1=verify.c2.getSelectedItem();		 
	 try
	 {
	
     	Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql:///online","root","root");
        Statement st=con.createStatement();
        String s="select * from registration where username='"+s1+"' ";
        ResultSet rs=st.executeQuery(s);
        if(rs.next())
		{
		card.show(cn,"details");
		
		
		 
	     details.tx1.setText(rs.getString(1));//username
	     details.tx2.setText(rs.getString(2));//password
	     details.tx3.setText(rs.getString(3));//name
	     details.tx4.setText(rs.getString(4));//2
	     details.tx5.setText(rs.getString(5));//3
	     details.tx6.setText(rs.getString(6));//mobile no.
	     
		 details.g.setText(rs.getString(7));//mobile no.
		 
		
		  details.tx7.setText(rs.getString(8));//E-MAI
		  details.d.setText(rs.getString(9)+" "+rs.getString(10)+" "+rs.getString(11));//E-MAI
	      // details.c1.setSelectedItem(rs.getString(9));//D.O.B
	      // details.c2.setSelectedItem(rs.getString(10));//1
	      // details.c3.setSelectedItem(rs.getString(11));//2
		 
		  details.tx8.setText(rs.getString(12));//college
		    details.t1.setText(rs.getString(13));//address
		
		}
	 }
	 catch(Exception e4)
	 {
		 System.out.println(e4);
	 }

	 }
	 
	 if(e.getSource()==verify.b2)
	 {
		 
			String s1=verify.c2.getSelectedItem();	
           verify.c2.remove(s1);			
	 try
	 {
	
     	Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql:///online","root","root");
        Statement st=con.createStatement();
        String s="delete from verify where username='"+s1+"' ";
       st.executeUpdate(s);
	   s="delete from registration where username='"+s1+"' ";
       st.executeUpdate(s);
	    	    JOptionPane.showMessageDialog(null,"User Delete Successfuly","UserDelete",JOptionPane.ERROR_MESSAGE);     
	 }
	 catch(Exception e4)
	 {
		 System.out.println(e4);
	 }
 
	 } 
	   
	 
	 
	 
	 
	 
	  
	 if(e.getSource()==verify.b3)
	 {
		 String s1=verify.c2.getSelectedItem();
	try
	 { 
	 	Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql:///online","root","root");
        Statement st=con.createStatement();
       
	   String s="delete from verify where username='"+s1+"'";
	   st.executeUpdate(s);
	   verify.c2.remove(s1);
	   JOptionPane.showMessageDialog(null,"User verify Successfuly","UserVerify",JOptionPane.ERROR_MESSAGE);     

	 }
	 catch(Exception e1)
	 {
		 System.out.println(e1);
	 }
	   		 
	 } 
	 
	 
	 if(e.getSource()==verify.b4||e.getSource()==u.b2)
	 {
		 card.show(cn,"panel"); 
	 }
	 
	
	
	if(e.getSource()==user.b1)
	  {
  try
	 { 
	     String s1=user.tx1.getText();
	     String s2=user.tx2.getText();
		 name=s1;
		Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql:///online","root","root");
        Statement st=con.createStatement();
        String s="select * from registration where username='"+s1+"'and password='"+s2+"'";
        ResultSet rs=st.executeQuery(s);
        
		String s11=new String(""+verify.c2.getSelectedItem());
		String s12=new String(""+s1);
	    if(s11.equals(s12))
		{
					JOptionPane.showMessageDialog(null,"plese verfiy by admin","My Title",JOptionPane.ERROR_MESSAGE);
		} 
		else
		{
	   
	   if(rs.next())
		{
			card.show(cn,"up");
			
			
			// try
	 // { 
      // // String g=""+Fdemo.globle;
	 	// Class.forName("com.mysql.cj.jdbc.Driver");
        // Connection con1=DriverManager.getConnection("jdbc:mysql:///online","root","root");
        // Statement st1=con1.createStatement();
       
	   // String ss1="select * from course";
	   // ResultSet rs1=st1.executeQuery(ss1);
	   
	   // while(rs1.next())
	   // {
		  		  // up.c1.add(rs1.getString(1));  
	 
		// }
	 // }
	
	 // catch(Exception e1)
	 // {
		 // System.out.println(e1);
	 // }
	
			
			
			
		}			
		else
		{
			JOptionPane.showMessageDialog(null,"Invalid UserName and Password","My Title",JOptionPane.ERROR_MESSAGE);
		}
		AllR.l1.setText(""+s1);
		user.tx1.setText("");
	    user.tx2.setText("");
		}
	     
	 }	 
	 catch(Exception e1)
	 {
		 System.out.println(e);
	 }

	  }
	  


          if(e.getSource()==registration.b1)
	{
		
		 s=0;
		 try
	 { 
	  String  s1=registration.tx1.getText();//username
	     
		 String s2=registration.tx2.getText();//password
	   
		 String s3=registration.tx3.getText();//name
	     String s4=registration.tx4.getText();//2
	     String s5=registration.tx5.getText();//3
	     
		  String s6=registration.tx6.getText();//mobile no.
		 
		 String s7="";//gender
		 if(registration.rb1.isSelected())
			 
		 {
			 s7=registration.rb1.getLabel();
		 } 
		 
		 if(registration.rb2.isSelected())
		 {
			 s7=registration.rb2.getLabel();
		 }
	      
		 if(registration.b3.isSelected())
		 {
			 s7=registration.rb3.getLabel();
		 }
	     
	     String s8=registration.tx7.getText();//E-MAIL
		 
	     String s9=registration.c1.getSelectedItem();//D.O.B
	     String s10=registration.c2.getSelectedItem();//1
	     String s11=registration.c3.getSelectedItem();//2
		 
		 String s12=registration.tx8.getText();//college
		 String s13=registration.t1.getText();//address
		 
		
		
		
		
		
		
		
		
		// public void actionPerformed(ActionEvent e)
 // {
	    String username1=registration.tx1.getText();
        String username =registration.tx7.getText();
        String password = registration.tx2.getText();

        // Validate username
       // String usernamePattern = "^[a-zA-Z0-9._-]+@gmail.com$";
	   
	   //e-mail
        String usernamePattern =   "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		Pattern p=Pattern.compile(usernamePattern);
		
		//password
		
        String passwordPattern ="^(?=.*[0-9])"+ "(?=.*[a-z])(?=.*[A-Z])"+ "(?=.*[@#$%^&+=])"+ "(?=\\S+$).{8,20}$";
		Pattern p2=Pattern.compile(passwordPattern);
		//user name
        String passwordPattern1 ="^(?=.*[0-9])"+ "(?=.*[a-z])(?=.*[A-Z])"+ "(?=.*[@#$%^&+=])"+ "(?=\\S+$).{8,20}$";
		Pattern p1=Pattern.compile(passwordPattern1);
		
		//mobile no.
        String mobile = "^(?=.[0-9]).{10,10}$";
       
       if (!p1.matcher(username1).matches())
		   {
            JOptionPane.showMessageDialog(null, "UserName must have at least 8 characters including at least one letter, one symbol (@#$%^&+=), one digit, and one of the numbers 0,1, 2, to 9.");
           s++;
		   //return; // Exit the action listener if validation fails
        
		   }
      if (!p2.matcher(password).matches())
		   {
            JOptionPane.showMessageDialog(null, "Password must have at least 8 characters including at least one letter, one symbol (@#$%^&+=), one digit, and one of the numbers 0,1, 2, to 9.");
            //return; // Exit the action listener if validation fails
        s++;
		   }
		
		 if(s3.equals(""))
		 {
            JOptionPane.showMessageDialog(null, "name is Mandotory");
		 s++;
		 }
        if(!s6.matches(mobile))
		{
            JOptionPane.showMessageDialog(null, "Mobile No. must contain 10 digites");
		s++;
		}
		if(s7.equals(""))
		{
            JOptionPane.showMessageDialog(null, "Pelese select Gender");
		  s++;
		}
	    if (!p.matcher(username).matches())
			{
            JOptionPane.showMessageDialog(null, "E-mail must be in the format of 6-20 characters + @ + gmail.com.");
          //  return; // Exit the action listener if validation fails
		  s++;
       
	   }
	if(s12.equals(""))
	{
            JOptionPane.showMessageDialog(null, "Pelese enter college name");
	s++;
	}
	   
	if(s13.equals(""))
	{
            JOptionPane.showMessageDialog(null, "Pelese enter address");
	s++;
	}
        // Validate password
        // Code to login with validated username and password
        // ...
   // }

		if(s==0)
		{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
          Connection con=DriverManager.getConnection("jdbc:mysql:///online","root","root");
          Statement st=con.createStatement();
          String s="insert into registration values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"','"+s9+"','"+s10+"','"+s11+"','"+s12+"','"+s13+"')";
          st.executeUpdate(s);
       
          
        String q="insert into verify values('"+s1+"')";
		st.executeUpdate(q);
		  //verify.c2.add("abhi");
			verify.c2.add(s1);  
			ur.c2.add(s1);
			
			JOptionPane.showMessageDialog(null,"Registration Successfuly","My Title",JOptionPane.INFORMATION_MESSAGE);
			
			
		    registration.tx1.setText("");
			registration.tx2.setText("");
			registration.tx3.setText("");
			registration.tx4.setText("");
			registration.tx5.setText("");
			registration.tx6.setText("");
		    registration.tx7.setText("");
			registration.tx8.setText("");
			registration.t1.setText("");
		}	
	 }	 
	 catch(Exception e12)
	 {
		 System.out.println(e12);
	 }
	
	}
	

}
}	

class online
{
	public static void main(String args[])
	{
		Fdemo f=new Fdemo();
		f.setVisible(true);
		f.setBounds(0,5,1920,1000);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
 	}
}