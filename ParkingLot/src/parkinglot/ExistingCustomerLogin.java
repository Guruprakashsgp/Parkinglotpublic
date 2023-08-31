package parkinglot;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ExistingCustomerLogin extends JFrame {

	private JPanel contentPane;
	private JTextField ExistinguserName;
	private JTextField ExistinguserVehicleNo;
	private JTextField ExistingUserUserName;
	private JTextField ExistingUserPassword;
	static String nameoftheexistingCustomer="";
	static boolean temp=true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExistingCustomerLogin frame = new ExistingCustomerLogin();
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
	public ExistingCustomerLogin() {
		setExtendedState(MAXIMIZED_BOTH);
		//setSize(new Dimension(1270, 700));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1271, 699);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(192, 192, 192));
		contentPane.setSize(new Dimension(1270, 700));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(239, 100, 752, 482);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Your Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(99, 83, 221, 28);
		panel.add(lblNewLabel_1);
		
		ExistinguserName = new JTextField();
		ExistinguserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ExistinguserName.setBounds(386, 83, 249, 28);
		panel.add(ExistinguserName);
		ExistinguserName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Your Vehicle Number");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(99, 138, 222, 28);
		panel.add(lblNewLabel_2);
		
		ExistinguserVehicleNo = new JTextField();
		ExistinguserVehicleNo.setBounds(388, 142, 251, 28);
		panel.add(ExistinguserVehicleNo);
		ExistinguserVehicleNo.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("User Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(99, 191, 221, 28);
		panel.add(lblNewLabel_3);
		
		ExistingUserUserName = new JTextField();
		ExistingUserUserName.setBounds(389, 197, 247, 28);
		panel.add(ExistingUserUserName);
		ExistingUserUserName.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(99, 249, 221, 28);
		panel.add(lblNewLabel_4);
		
		ExistingUserPassword = new JTextField();
		ExistingUserPassword.setBounds(387, 252, 251, 28);
		panel.add(ExistingUserPassword);
		ExistingUserPassword.setColumns(10);
		
		JButton ExistingUserSubmit = new JButton("Submit");
		ExistingUserSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					Connection conn = DBconnection.connect();
					String query="select * from Customers where UserName=? and Password=?";
					try {
						PreparedStatement pS= conn.prepareStatement(query);
						pS.setString(1, ExistingUserUserName.getText());
						pS.setString(2, ExistingUserPassword.getText());
						ResultSet rSet=pS.executeQuery();
						while(temp==true)
						{
							if(rSet.next())
							{
								dispose();
								ExixtingCustomer exixt=new ExixtingCustomer();
								exixt.setVisible(true);	
								exixt.NametobeShown.setText("Welcome "+" "+rSet.getString(1));
								nameoftheexistingCustomer=rSet.getString(1);
								temp=false;
							}
							else {
								JOptionPane.showMessageDialog(null, "Customer Doesnot Exist ( ^ ! ^ )");
								break;			
							}
						}					
	//					while(rSet.next())
	//					{
	//						System.out.println(rSet);
	//					}
					//setname.get
						
						conn.close();
					}  catch (SQLException e1) {
						e1.printStackTrace();
					}
				
				}
			
		});
		ExistingUserSubmit.setFont(new Font("Tahoma", Font.BOLD, 14));
		ExistingUserSubmit.setBounds(310, 349, 143, 48);
		panel.add(ExistingUserSubmit);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(-239, -99, 1257, 662);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_5 = new JLabel("Existing User Login");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_5.setBounds(469, 49, 281, 42);
		contentPane.add(lblNewLabel_5);
	}
}
