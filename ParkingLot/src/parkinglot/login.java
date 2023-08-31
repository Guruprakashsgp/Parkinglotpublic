package parkinglot;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.Dimension;

public class login extends JFrame {

	private JPanel contentPane;
	String login=new String();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setExtendedState(MAXIMIZED_BOTH);
		setSize(new Dimension(1268, 721));
		setBackground(new Color(240, 240, 240));
		setForeground(new Color(255, 128, 128));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1270, 620);
		contentPane = new JPanel();
		contentPane.setSize(new Dimension(1270, 899));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ButtonGroup buttonGroup=new ButtonGroup();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(221, 221, 221));
		panel.setBounds(136, 89, 936, 391);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JRadioButton CustomerR = new JRadioButton("Customer");
		CustomerR.setBounds(207, 155, 176, 23);
		panel.add(CustomerR);
		CustomerR.setForeground(new Color(0, 0, 0));
		CustomerR.setBackground(new Color(221, 221, 221));
		CustomerR.setFont(new Font("Tahoma", Font.PLAIN, 18));
		buttonGroup.add(CustomerR);
		
		JRadioButton OwnerR = new JRadioButton("Owner");
		OwnerR.setBounds(631, 155, 176, 23);
		panel.add(OwnerR);
		OwnerR.setForeground(new Color(0, 0, 0));
		OwnerR.setBackground(new Color(221, 221, 221));
		OwnerR.setFont(new Font("Tahoma", Font.PLAIN, 18));
		buttonGroup.add(OwnerR);
		
		
		JButton Submit = new JButton("Submit");
		Submit.setBounds(397, 249, 134, 40);
		panel.add(Submit);
		Submit.setBackground(new Color(255, 255, 255));
		Submit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblNewLabel = new JLabel("Login AS");
		lblNewLabel.setBounds(372, 51, 199, 40);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\guruprakash.s\\Pictures\\vehicle.jpg"));
		lblNewLabel_1.setBounds(0, 0, 1303, 700);
		contentPane.add(lblNewLabel_1);
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(CustomerR.isSelected())
				{
					dispose();
					Customerframe c1=new Customerframe();
					c1.setVisible(true);
				}
				else {
					dispose();
					OwnerFrame o1=new OwnerFrame();
					o1.setVisible(true);
				}
				
			}
		});
	}
}
