package quiz.application;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.*;

public class Signup extends JFrame implements ActionListener {

	JButton submit;
	JTextField tfname, tfmail;
	JPasswordField tfpass;

	Signup() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
		JLabel image = new JLabel(i1);
		image.setBounds(0, 0, 400, 500);
		add(image);

		JLabel heading = new JLabel("Sign-Up");
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

		JLabel mail = new JLabel("Mail");
		mail.setBounds(500, 250, 350, 30);
		mail.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
		mail.setForeground(new Color(30, 144, 254));
		add(mail);

		tfmail = new JTextField();
		tfmail.setBounds(650, 270, 200, 30);
		tfmail.setFont(new Font("Times New Roman", Font.BOLD, 20));
		add(tfmail);

		submit = new JButton("Submit");
		submit.setBounds(570, 400, 100, 50);
		submit.setBackground(new Color(30, 144, 254));
		submit.setForeground(Color.WHITE);
		submit.addActionListener(this);
		add(submit);

		setSize(1200, 500);
		setLocation(200, 150);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Signup();
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == submit) {
			String name = tfname.getText().toString();
			String mail = tfmail.getText().toString();
			PreparedStatement ps;
			char[] passwordChars = tfpass.getPassword();
			 String pass = new String(passwordChars);
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "root");
				ps = c.prepareStatement("insert into register values(?,?,?,?)");
				ps.setInt(1, 0);
				ps.setString(2, name);
				ps.setString(3, pass);
				ps.setString(4, mail);
				ps.execute();
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				
			}

			setVisible(false);
			new Signin();
		}
	}

}
