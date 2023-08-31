package parkinglot;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Customerframe extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customerframe frame = new Customerframe();
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
	public Customerframe() {
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1269, 620);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ButtonGroup b1=new ButtonGroup();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(234, 234, 234));
		panel.setBounds(427, 77, 413, 426);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer Login");
		lblNewLabel.setBounds(47, 22, 329, 55);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Login AS");
		lblNewLabel_1.setBounds(161, 88, 81, 31);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JRadioButton NewCustomerR = new JRadioButton("New Login");
		NewCustomerR.setBounds(93, 153, 214, 23);
		panel.add(NewCustomerR);
		NewCustomerR.setForeground(new Color(0, 0, 0));
		NewCustomerR.setFont(new Font("Tahoma", Font.BOLD, 15));
		NewCustomerR.setBackground(new Color(234, 234, 234));
		b1.add(NewCustomerR);
		
		JRadioButton ExistingCustomerR = new JRadioButton("Existing Customer Login");
		ExistingCustomerR.setBounds(89, 226, 218, 23);
		panel.add(ExistingCustomerR);
		ExistingCustomerR.setForeground(new Color(0, 0, 0));
		ExistingCustomerR.setFont(new Font("Tahoma", Font.BOLD, 15));
		ExistingCustomerR.setBackground(new Color(234, 234, 234));
		b1.add(ExistingCustomerR);
		
		JButton SubmitB1 = new JButton("Submit");
		SubmitB1.setBounds(140, 306, 129, 41);
		panel.add(SubmitB1);
		SubmitB1.setFont(new Font("Tahoma", Font.BOLD, 11));
		SubmitB1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(NewCustomerR.isSelected())
				{
					dispose();
					NewCustomer n1=new NewCustomer();
					n1.setVisible(true);
				}
				else {
					dispose();
					ExistingCustomerLogin e1= new ExistingCustomerLogin();
					e1.setVisible(true);
				}
			}
		});
		SubmitB1.setBackground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\guruprakash.s\\Pictures\\vehicle.jpg"));
		lblNewLabel_2.setBounds(0, 0, 1287, 655);
		contentPane.add(lblNewLabel_2);
	}
}
