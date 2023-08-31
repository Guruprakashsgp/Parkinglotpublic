package parkinglot;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NewCustomer extends JFrame {
	private JTextField NameText;
	private JTextField PhnoText;
	private JTextField VehiclenoText;
	private JTextField UserNameText;
	private JPasswordField Password;
	private JPasswordField ConfirmPassword;
	public JLabel ifavailabe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewCustomer frame = new NewCustomer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NewCustomer() {
		setExtendedState(MAXIMIZED_BOTH);
		//setBounds(100, 100, 1270, 620);
		getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(125, 63, 1059, 505);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel VehicleTypePanel = new JPanel();
		VehicleTypePanel.setBounds(310, 144, 396, 112);
		panel_1.add(VehicleTypePanel);
		VehicleTypePanel.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("Vehice Type");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(10, 11, 156, 14);
		VehicleTypePanel.add(lblNewLabel_1_2);
		
		JRadioButton TwoWheelerR = new JRadioButton("Two Wheeler");
		TwoWheelerR.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TwoWheelerR.setBounds(172, 7, 218, 23);
		VehicleTypePanel.add(TwoWheelerR);
		
		JRadioButton Lightwt4whR = new JRadioButton("Light Weight 4 Wheeler");
		Lightwt4whR.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Lightwt4whR.setBounds(172, 45, 218, 23);
		VehicleTypePanel.add(Lightwt4whR);
		
		JRadioButton Heavywt4whR = new JRadioButton("Heavy weight 4 Wheeler");
		Heavywt4whR.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Heavywt4whR.setBounds(172, 82, 218, 23);
		VehicleTypePanel.add(Heavywt4whR);
		
		ButtonGroup bgg=new ButtonGroup();
		bgg.add(TwoWheelerR);
		bgg.add(Lightwt4whR);
		bgg.add(Heavywt4whR);
		
		
		
		JLabel Name = new JLabel("Name");
		Name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Name.setBounds(320, 60, 63, 14);
		panel_1.add(Name);
		
		PhnoText = new JTextField();
		PhnoText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		PhnoText.setBounds(495, 97, 193, 20);
		panel_1.add(PhnoText);
		PhnoText.setColumns(10);
		
		JLabel Phno = new JLabel("Phone Number");
		Phno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Phno.setBounds(320, 100, 140, 14);
		panel_1.add(Phno);
		
		NameText = new JTextField();
		NameText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		NameText.setBounds(495, 57, 193, 20);
		panel_1.add(NameText);
		NameText.setColumns(10);
		
		JLabel lblNewLabel_1_3 = new JLabel("Vehicle Number");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(320, 280, 140, 14);
		panel_1.add(lblNewLabel_1_3);
		
		VehiclenoText = new JTextField();
		VehiclenoText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		VehiclenoText.setBounds(495, 280, 193, 20);
		panel_1.add(VehiclenoText);
		VehiclenoText.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New Customer Login");
		lblNewLabel.setBounds(351, 11, 265, 23);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_2 = new JLabel("User Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(320, 318, 119, 30);
		panel_1.add(lblNewLabel_2);
		
		UserNameText = new JTextField();
		UserNameText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String userString = UserNameText.getText();
					if(!userString.equals(""))
					{
						if(userString.length()<7)
						{
							ifavailabe.setText("User Name should be more than 8 Characters");
						}
						else {
							ifavailabe.setVisible(true);
							ifavailabe.setText("Available");
							try {
								Connection conn = DBconnection.connect();
								Statement statement =  conn.createStatement();
//								String query="select * from Customers where UserName='"+userString+"'";
//								PreparedStatement pS= conn.prepareStatement(query);
//								pS.setString(1, UserNameText.getText());
								
								ResultSet rSet=statement.executeQuery("select * from customers where UserName = '"+userString+"' ");
								
								while(rSet.next())
								{
									ifavailabe.setVisible(true);
									ifavailabe.setText("Unavailable");
									
								}					
								
								conn.close();
							}  catch (SQLException e1) {
								e1.printStackTrace();
							}
						}
						
					}
					else {
						ifavailabe.setVisible(false);
					}
				
				
			}
		});
		UserNameText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Password.requestFocusInWindow();
			}
		});
		UserNameText.setBounds(495, 324, 193, 23);
		panel_1.add(UserNameText);
		UserNameText.setColumns(10);
		
		ifavailabe = new JLabel("");
		ifavailabe.setBounds(712, 328, 295, 20);
		panel_1.add(ifavailabe);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(320, 364, 119, 30);
		panel_1.add(lblNewLabel_3);
		
		Password = new JPasswordField();
		Password.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Password.setBounds(495, 369, 193, 20);
		panel_1.add(Password);
		
		JLabel lblNewLabel_4 = new JLabel("Confirm Password");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(320, 412, 119, 20);
		panel_1.add(lblNewLabel_4);
		
		ConfirmPassword = new JPasswordField();
		ConfirmPassword.setBounds(495, 414, 193, 20);
		panel_1.add(ConfirmPassword);
		
		JButton BackButton1 = new JButton("Back");
		BackButton1.setBounds(882, 11, 125, 41);
		panel_1.add(BackButton1);
		BackButton1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		BackButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Customerframe cus1=new Customerframe();
				cus1.setVisible(true);
				
			}
		});
		
		JButton SubmitNew = new JButton("Submit");
		SubmitNew.setFont(new Font("Tahoma", Font.PLAIN, 18));
		SubmitNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Password.getText().equals(ConfirmPassword.getText()))
					
				{
					Connection conn = DBconnection.connect();
					String query="insert into Customers values(?,?,?,?,?,?)";
					try {
						PreparedStatement pS= conn.prepareStatement(query);
						pS.setString(1,NameText.getText());
						{
							if(PhnoText.getText().length()==10)
								pS.setString(2, PhnoText.getText());
							else {
								JOptionPane.showMessageDialog(null, "Phone Number is Invalid");
							}
						}
						if(TwoWheelerR.isSelected())
						{
							pS.setString(3, TwoWheelerR.getLabel());
						}
						else if (Lightwt4whR.isSelected()) {
							pS.setString(3, Lightwt4whR.getLabel());	
						}
						else {
							pS.setString(3, Heavywt4whR.getLabel());
						}
						{
							if(VehiclenoText.getText().length()==10)
								pS.setString(4, VehiclenoText.getText());
							else {
								JOptionPane.showMessageDialog(null, "Vehicle Number is Invalid");
							}
						}
						pS.setString(5, UserNameText.getText());
						pS.setString(6, Password.getText());
						int rs = pS.executeUpdate();
						System.out.println("Rows updated: "+ rs);
						conn.close();
						
						
						JOptionPane.showMessageDialog(null, "User Registered Succesfully ( ^_^ )");
						dispose();
						Customerframe returnCust=new Customerframe()	;
						returnCust.setVisible(true);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Password doesnot Suit Confirm Password");
				}
			}
		});
		SubmitNew.setBounds(559, 579, 146, 51);
		getContentPane().add(SubmitNew);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\guruprakash.s\\Pictures\\vehicle.jpg"));
		lblNewLabel_1.setBounds(0, 0, 1286, 652);
		getContentPane().add(lblNewLabel_1);

	}
}
