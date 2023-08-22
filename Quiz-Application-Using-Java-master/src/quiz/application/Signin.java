package quiz.application;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Signin extends JFrame implements ActionListener{
	 JButton rules;
	   JTextField tfname,tfmail;
	   JPasswordField tfpass;
	Signin(){
	getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
    JLabel image = new JLabel(i1);
    image.setBounds(0, 0, 400, 500);
    add(image);
    
    JLabel heading = new JLabel("Sign-In");
    heading.setBounds(750, 60, 300, 45);
    heading.setFont(new Font("Times New Roman", Font.BOLD, 50));
    heading.setForeground(new Color(30, 144, 254));
    add(heading);
   
    
    JLabel name = new JLabel("Name");
    name.setBounds(500, 150, 200, 30);
    name.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
    name.setForeground(new Color(30, 144, 254));
    add(name);
    
    
    tfname = new JTextField();
    tfname.setBounds(650, 150, 200, 30);

    tfname.setFont(new Font("Times New Roman", Font.BOLD, 20));
    add(tfname);
    
    JLabel pass = new JLabel("Password");
    pass.setBounds(500, 200, 200, 30);
    pass.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
    pass.setForeground(new Color(30, 144, 254));
    add(pass);
    
    tfpass = new JPasswordField(20);
    tfpass.setBounds(650, 200, 250, 30);
    tfpass.setFont(new Font("Times New Roman", Font.BOLD, 20));
    add(tfpass);
 
    
    rules = new JButton("Start");
   rules.setBounds(570, 400, 100, 50);
    rules.setBackground(new Color(30, 144, 254));
   rules.setForeground(Color.WHITE);
    rules.addActionListener(this);
    add(rules);
    
    setSize(1200, 500);
    setLocation(200, 150);
    setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
new Signin();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 if (e.getSource() == rules) {
			 PreparedStatement ps;
			 String name=tfname.getText().toString();
			 char[] passwordChars = tfpass.getPassword();
			 String pass = new String(passwordChars);
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "root");
					ps = c.prepareStatement("Select * from register where name=? and pass=?");
					ps.setString(1, name);
					ps.setString(2, pass);
					ResultSet rs=ps.executeQuery();
					//System.out.println(rs.next());
					if(rs.next()) {
						setVisible(false);
						new Rules();
					}else {
						  JOptionPane.showMessageDialog(null, "Password is Wrong , Try Again!!!");
					
					ps.close();
				} }catch (Exception ae) {
					ae.printStackTrace();
				} finally {
					
				}
	            
	            
	        } 
		
	}

}
