package parkinglot;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ExixtingCustomer extends JFrame {
	private JTextField MonthlyStartDate;
	private JTextField MorningShiftDate;
	private JTextField AfterNoonShiftDate;
	private JTextField NightShiftDate;
	public JLabel NametobeShown ;
	public JPanel monthlytypepanel;
	public JLabel Monthlytypelable;
	public JComboBox Monthlytypedropdown;
	public JLabel TotalAmttopay;
	public JComboBox Shiftmonthlytypedropdown;
	public JRadioButton MonthlyBookR;
	public JPanel shiftmonthlytypepannel;
	public JRadioButton MonthlyMyplanR;
	public JCheckBox MonthlypayConfirmationCheck;
	public JLabel MonthlyPlanNameLable;
	public JLabel MonthlyplanStartDateLable;
	public JLabel MonthlyPlanEndDateLable;
	public JLabel MonthlyslotAllotedLable;
	public JLabel TotalDailyAmtLable;
	public JCheckBox DailypayConfirmation;
	public JLabel Slotalloteddatelable;
	public JLabel Bookeddatelable;
	boolean temp=true;
	Adddays adddays=new Adddays();
	monthly wholeMonthly=new monthly();
	monthly newslotMonthly=new monthly();
	daily newslotdaily=new daily();
	private JTextField Dailystartdateentered;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExixtingCustomer frame = new ExixtingCustomer();
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
	public ExixtingCustomer() {
		//setSize(new Dimension(1270, 700));
		//setResizable(false);
		setExtendedState(MAXIMIZED_BOTH);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 11, 1196, 65);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(437, 11, 274, 43);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(10, 75, 128, 503);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JTabbedPane MaintabbedPane = new JTabbedPane(JTabbedPane.TOP);
		MaintabbedPane.setBounds(129, 44, 1077, 534);
		getContentPane().add(MaintabbedPane);
		
		JPanel WelcomeDesk = new JPanel();
		WelcomeDesk.setBackground(new Color(128, 128, 128));
		MaintabbedPane.addTab("New tab", null, WelcomeDesk, null);
		WelcomeDesk.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(267, 131, 513, 190);
		WelcomeDesk.add(panel_4);
		panel_4.setLayout(null);
		
		NametobeShown = new JLabel("..");
		NametobeShown.setFont(new Font("Tahoma", Font.BOLD, 25));
		NametobeShown.setHorizontalAlignment(SwingConstants.CENTER);
		NametobeShown.setBounds(10, 49, 493, 94);
		panel_4.add(NametobeShown);
		
		JPanel Monthlypanel = new JPanel();
		MaintabbedPane.addTab("New tab", null, Monthlypanel, null);
		Monthlypanel.setLayout(null);
		
		JTabbedPane FirstTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		FirstTabbedPane.setBounds(0, 0, 1084, 515);
		Monthlypanel.add(FirstTabbedPane);
		
		JPanel ChooseInMonthly = new JPanel();
		ChooseInMonthly.setBackground(new Color(235, 234, 233));
		FirstTabbedPane.addTab("New tab", null, ChooseInMonthly, null);
		ChooseInMonthly.setLayout(null);
		
		ButtonGroup monthlybg=new ButtonGroup();
		monthlybg.add(MonthlyBookR);
		
		
		JButton Monthlysubmit = new JButton("Next");
		Monthlysubmit.setFont(new Font("Tahoma", Font.BOLD, 14));
		Monthlysubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((Monthlytypedropdown.getSelectedItem().toString()).equals("NORMAL MONTHLY"))
				{
					Monthlytypelable.setText((Monthlytypedropdown.getSelectedItem()).toString());
					TotalAmttopay.setText("₹465");
				}
				
				if((Shiftmonthlytypedropdown.getSelectedItem().toString()).equals("MORNING MONTHLY"))
				{
					Monthlytypelable.setText((Shiftmonthlytypedropdown.getSelectedItem()).toString());
					TotalAmttopay.setText("₹155");
				}
				
				if((Shiftmonthlytypedropdown.getSelectedItem().toString()).equals("AFTERNOON MONTHLY"))
				{
					Monthlytypelable.setText((Shiftmonthlytypedropdown.getSelectedItem()).toString());
					TotalAmttopay.setText("₹155");
				}
				
				if((Shiftmonthlytypedropdown.getSelectedItem().toString()).equals("NIGHT MONTHLY"))
				{
					Monthlytypelable.setText((Shiftmonthlytypedropdown.getSelectedItem()).toString());
					TotalAmttopay.setText("₹310");
				}
				
				if(MonthlyBookR.isSelected())
				{
					FirstTabbedPane.setSelectedIndex(1);
				}
				else {
					FirstTabbedPane.setSelectedIndex(2);
				}
				
			}
		});
		Monthlysubmit.setBounds(841, 360, 151, 61);
		ChooseInMonthly.add(Monthlysubmit);
		
		JLabel lblNewLabel_1 = new JLabel("Choose the Required Service");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(294, 45, 437, 39);
		ChooseInMonthly.add(lblNewLabel_1);
		
		monthlytypepanel = new JPanel();
		monthlytypepanel.setBounds(332, 271, 364, 61);
		ChooseInMonthly.add(monthlytypepanel);
		monthlytypepanel.setLayout(null);
		monthlytypepanel.setVisible(false);
		
		JLabel lblNewLabel_17 = new JLabel("Monthly Type :-");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_17.setBounds(10, 11, 124, 39);
		monthlytypepanel.add(lblNewLabel_17);
		
		String monthlytypear[]= {" ","NORMAL MONTHLY","SHIFTED MONTHLY"};
		Monthlytypedropdown = new JComboBox(monthlytypear);
		Monthlytypedropdown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((Monthlytypedropdown.getSelectedItem().toString()).equals("SHIFTED MONTHLY"))
				{
					shiftmonthlytypepannel.setVisible(true);
				}
			}
		});
		Monthlytypedropdown.setBounds(196, 21, 158, 22);
		monthlytypepanel.add(Monthlytypedropdown);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(332, 117, 364, 131);
		ChooseInMonthly.add(panel_5);
		panel_5.setLayout(null);
		
		MonthlyBookR = new JRadioButton("Book Monthly");
		MonthlyBookR.setBounds(97, 28, 147, 34);
		panel_5.add(MonthlyBookR);
		MonthlyBookR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				monthlytypepanel.setVisible(true);
			}
		});
		MonthlyBookR.setFont(new Font("Tahoma", Font.BOLD, 14));
		monthlybg.add(MonthlyBookR);
		
		MonthlyMyplanR = new JRadioButton("My Monthly Plan");
		MonthlyMyplanR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				monthlytypepanel.setVisible(false);
			}
		});
		MonthlyMyplanR.setBounds(97, 80, 147, 23);
		panel_5.add(MonthlyMyplanR);
		MonthlyMyplanR.setFont(new Font("Tahoma", Font.BOLD, 14));
		monthlybg.add(MonthlyMyplanR);
		
		shiftmonthlytypepannel = new JPanel();
		shiftmonthlytypepannel.setBounds(332, 360, 364, 61);
		ChooseInMonthly.add(shiftmonthlytypepannel);
		shiftmonthlytypepannel.setLayout(null);
		shiftmonthlytypepannel.setVisible(false);
		
		JLabel slable = new JLabel("Shifted Monthly Type :-");
		slable.setFont(new Font("Tahoma", Font.BOLD, 14));
		slable.setBounds(10, 11, 177, 39);
		shiftmonthlytypepannel.add(slable);
		
		String[] shiftmonthlytypearr= {"","MORNING MONTHLY","AFTERNOON MONTHLY","NIGHT MONTHLY"};
		Shiftmonthlytypedropdown = new JComboBox(shiftmonthlytypearr);
		Shiftmonthlytypedropdown.setBounds(197, 21, 157, 22);
		shiftmonthlytypepannel.add(Shiftmonthlytypedropdown);
		
		JPanel BookNowMonthly = new JPanel();
		BookNowMonthly.setBackground(new Color(235, 234, 233));
		FirstTabbedPane.addTab("New tab", null, BookNowMonthly, null);
		BookNowMonthly.setLayout(null);
		
		JLabel FromDate = new JLabel("From Date(yyyy-MM-dd)");
		FromDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		FromDate.setBounds(315, 134, 171, 24);
		BookNowMonthly.add(FromDate);
		
		MonthlyStartDate = new JTextField();
		MonthlyStartDate.setHorizontalAlignment(SwingConstants.CENTER);
		MonthlyStartDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		MonthlyStartDate.setBounds(517, 135, 186, 22);
		BookNowMonthly.add(MonthlyStartDate);
		MonthlyStartDate.setColumns(10);
		
		JLabel Lable = new JLabel("Total Amount to Pay :-");
		Lable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Lable.setBounds(315, 171, 206, 32);
		BookNowMonthly.add(Lable);
		
		TotalAmttopay = new JLabel("..");
		TotalAmttopay.setHorizontalAlignment(SwingConstants.CENTER);
		TotalAmttopay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TotalAmttopay.setBounds(517, 176, 186, 22);
		BookNowMonthly.add(TotalAmttopay);
		
		JPanel Normalpanel1 = new JPanel();
		Normalpanel1.setBounds(315, 236, 378, 99);
		BookNowMonthly.add(Normalpanel1);
		Normalpanel1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Do you want to pay?");
		lblNewLabel_2.setBounds(0, 11, 139, 19);
		Normalpanel1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		MonthlypayConfirmationCheck = new JCheckBox("Pay");
		MonthlypayConfirmationCheck.setFont(new Font("Tahoma", Font.PLAIN, 14));
		MonthlypayConfirmationCheck.setBounds(198, 9, 99, 23);
		Normalpanel1.add(MonthlypayConfirmationCheck);
		
		JButton SubmitMonthlypay = new JButton("Submit");
		SubmitMonthlypay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					if(MonthlypayConfirmationCheck.isSelected()==false)
					{
						JOptionPane.showMessageDialog(null, "Please Complete the payment to further proceed ( ^ ! ^ )");
						FirstTabbedPane.setSelectedIndex(1);
						
					}
					else 
					{
						
						if((newslotMonthly.monthlyslot(MonthlyPlanEndDateLable.getText()))>10){
							JOptionPane.showMessageDialog(null, "Sorry the monthly slots are completely booked ( ^!^ )");
							FirstTabbedPane.setSelectedIndex(1);
						}
						else {
							MonthlyPlanNameLable.setText(Monthlytypelable.getText());
							MonthlyplanStartDateLable.setText(MonthlyStartDate.getText());
							MonthlyPlanEndDateLable.setText(adddays.datecheckformonth(MonthlyStartDate.getText()));
							MonthlyslotAllotedLable.setText(String.valueOf((newslotMonthly.monthlyslot(MonthlyPlanEndDateLable.getText()))));
							FirstTabbedPane.setSelectedIndex(2);
						}
						
					}
				
			}
		});
		SubmitMonthlypay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		SubmitMonthlypay.setBounds(446, 365, 146, 47);
		BookNowMonthly.add(SubmitMonthlypay);
		
		JLabel lblNewLabel_18 = new JLabel("Monthly Type :-");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_18.setBounds(315, 89, 182, 24);
		BookNowMonthly.add(lblNewLabel_18);
		
		Monthlytypelable = new JLabel(".");
		Monthlytypelable.setHorizontalAlignment(SwingConstants.CENTER);
		Monthlytypelable.setBounds(507, 91, 186, 24);
		BookNowMonthly.add(Monthlytypelable);
		
		JLabel lblNewLabel_19 = new JLabel("Payment Details");
		lblNewLabel_19.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_19.setBounds(343, 22, 328, 56);
		BookNowMonthly.add(lblNewLabel_19);
		
		JPanel MyBookingDofMonthly = new JPanel();
		FirstTabbedPane.addTab("New tab", null, MyBookingDofMonthly, null);
		MyBookingDofMonthly.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Details About Your Bookings");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(280, 27, 395, 47);
		MyBookingDofMonthly.add(lblNewLabel_3);
		
		JLabel lblNewLabel_20 = new JLabel("Plan Name :-");
		lblNewLabel_20.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_20.setBounds(271, 108, 177, 34);
		MyBookingDofMonthly.add(lblNewLabel_20);
		
		JLabel Plandate = new JLabel("Plan Start Date :-");
		Plandate.setFont(new Font("Tahoma", Font.BOLD, 14));
		Plandate.setBounds(271, 171, 177, 34);
		MyBookingDofMonthly.add(Plandate);
		
		JLabel lblPlanEndDate = new JLabel("Plan End Date :-");
		lblPlanEndDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPlanEndDate.setBounds(271, 231, 177, 34);
		MyBookingDofMonthly.add(lblPlanEndDate);
		
		JLabel lblSlotAlloted = new JLabel("Slot Alloted :-");
		lblSlotAlloted.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSlotAlloted.setBounds(271, 290, 177, 34);
		MyBookingDofMonthly.add(lblSlotAlloted);
		
		JLabel lblPaymentStatus = new JLabel("Payment Status :-");
		lblPaymentStatus.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPaymentStatus.setBounds(271, 347, 177, 34);
		MyBookingDofMonthly.add(lblPaymentStatus);
		
		MonthlyPlanNameLable = new JLabel(".");
		MonthlyPlanNameLable.setBounds(533, 110, 142, 34);
		MyBookingDofMonthly.add(MonthlyPlanNameLable);
		
		MonthlyplanStartDateLable = new JLabel(".");
		MonthlyplanStartDateLable.setBounds(533, 173, 142, 34);
		MyBookingDofMonthly.add(MonthlyplanStartDateLable);
		
		MonthlyPlanEndDateLable = new JLabel(".");
		MonthlyPlanEndDateLable.setBounds(533, 233, 142, 34);
		MyBookingDofMonthly.add(MonthlyPlanEndDateLable);
		
		MonthlyslotAllotedLable = new JLabel(".");
		MonthlyslotAllotedLable.setBounds(533, 292, 142, 34);
		MyBookingDofMonthly.add(MonthlyslotAllotedLable);
		
		JLabel lblSuccessfull = new JLabel("Successfull ( ^ _ ^ )");
		lblSuccessfull.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSuccessfull.setBounds(533, 347, 142, 34);
		MyBookingDofMonthly.add(lblSuccessfull);
		
		JPanel MonthlyBookingDorNpanel = new JPanel();
		FirstTabbedPane.addTab("New tab", null, MonthlyBookingDorNpanel, null);
		MonthlyBookingDorNpanel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Status of Your Booking");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(172, 130, 196, 57);
		MonthlyBookingDorNpanel.add(lblNewLabel_4);
		
		JLabel MonthlyBookingDorN = new JLabel("..");
		MonthlyBookingDorN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		MonthlyBookingDorN.setHorizontalAlignment(SwingConstants.CENTER);
		MonthlyBookingDorN.setBounds(487, 130, 276, 57);
		MonthlyBookingDorNpanel.add(MonthlyBookingDorN);
		
		JPanel Dailypanel = new JPanel();
		MaintabbedPane.addTab("New tab", null, Dailypanel, null);
		Dailypanel.setLayout(null);
		
		JTabbedPane SecondTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		SecondTabbedPane.setBounds(0, -33, 1084, 563);
		Dailypanel.add(SecondTabbedPane);
		
		JPanel ChooseInDaily = new JPanel();
		SecondTabbedPane.addTab("New tab", null, ChooseInDaily, null);
		ChooseInDaily.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Choose The Required Service");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(295, 123, 379, 40);
		ChooseInDaily.add(lblNewLabel_5);
		
		JRadioButton BookTodayR = new JRadioButton("Book Today");
		BookTodayR.setFont(new Font("Tahoma", Font.PLAIN, 14));
		BookTodayR.setBounds(419, 212, 111, 23);
		ChooseInDaily.add(BookTodayR);
		
		JRadioButton MyPlanDailyR = new JRadioButton("My Plan");
		MyPlanDailyR.setFont(new Font("Tahoma", Font.PLAIN, 14));
		MyPlanDailyR.setBounds(419, 265, 149, 23);
		ChooseInDaily.add(MyPlanDailyR);
		
		ButtonGroup dailybg=new ButtonGroup();
		dailybg.add(BookTodayR);
		dailybg.add(MyPlanDailyR);
		
		JButton DailySubmit = new JButton("Next");
		DailySubmit.setFont(new Font("Tahoma", Font.BOLD, 14));
		DailySubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TotalDailyAmtLable.setText("₹15");
				if(BookTodayR.isSelected())
				{
					SecondTabbedPane.setSelectedIndex(1);
				}
				else {
					SecondTabbedPane.setSelectedIndex(2);
				}
			}
		});
		DailySubmit.setBounds(414, 350, 154, 40);
		ChooseInDaily.add(DailySubmit);
		
		JPanel BookNowDaily = new JPanel();
		SecondTabbedPane.addTab("New tab", null, BookNowDaily, null);
		BookNowDaily.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Enter The Following Details");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(390, 47, 266, 37);
		BookNowDaily.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Book Date(yyyy-MM-dd) :-");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(324, 127, 185, 25);
		BookNowDaily.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Total Amount to pay");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(305, 192, 169, 25);
		BookNowDaily.add(lblNewLabel_8);
		
		TotalDailyAmtLable = new JLabel("..");
		TotalDailyAmtLable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TotalDailyAmtLable.setHorizontalAlignment(SwingConstants.CENTER);
		TotalDailyAmtLable.setBounds(519, 192, 189, 25);
		BookNowDaily.add(TotalDailyAmtLable);
		
		JPanel Normalpanel1_1 = new JPanel();
		Normalpanel1_1.setBounds(318, 241, 390, 99);
		BookNowDaily.add(Normalpanel1_1);
		Normalpanel1_1.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("Do you want to pay?");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(10, 13, 139, 19);
		Normalpanel1_1.add(lblNewLabel_2_1);
		
		DailypayConfirmation = new JCheckBox("Pay");
		DailypayConfirmation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		DailypayConfirmation.setBounds(196, 11, 99, 23);
		Normalpanel1_1.add(DailypayConfirmation);
		
		JButton SubmitDailyPay = new JButton("Submit");
		SubmitDailyPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(DailypayConfirmation.isSelected()==false)
				{
					JOptionPane.showMessageDialog(null, "Please Complete the payment to further proceed ( ^ ! ^ )");
					SecondTabbedPane.setSelectedIndex(2);
					
				}
				else {
					if((newslotdaily.daily(Dailystartdateentered.getText()))>10){
						JOptionPane.showMessageDialog(null, "Sorry the monthly slots are completely booked ( ^!^ )");
						SecondTabbedPane.setSelectedIndex(2);
					}
					else {
						Slotalloteddatelable.setText(String.valueOf(newslotdaily.daily(Dailystartdateentered.getText())));
						
						SecondTabbedPane.setSelectedIndex(3);				
						}
	
				}
				
			}
		});
		SubmitDailyPay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		SubmitDailyPay.setBounds(443, 380, 148, 37);
		BookNowDaily.add(SubmitDailyPay);
		
		Dailystartdateentered = new JTextField();
		Dailystartdateentered.setHorizontalAlignment(SwingConstants.CENTER);
		Dailystartdateentered.setBounds(519, 129, 189, 25);
		BookNowDaily.add(Dailystartdateentered);
		Dailystartdateentered.setColumns(10);
		
		JPanel MyBookingDofDaily = new JPanel();
		SecondTabbedPane.addTab("New tab", null, MyBookingDofDaily, null);
		MyBookingDofDaily.setLayout(null);
		
		JLabel lblNewLabel_3_1 = new JLabel("Details About Your Bookings");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_3_1.setBounds(321, 43, 395, 47);
		MyBookingDofDaily.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_9 = new JLabel("Booked Date :-");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(214, 126, 246, 40);
		MyBookingDofDaily.add(lblNewLabel_9);
		
		Bookeddatelable = new JLabel(".");
		Bookeddatelable.setFont(new Font("Tahoma", Font.BOLD, 14));
		Bookeddatelable.setHorizontalAlignment(SwingConstants.CENTER);
		Bookeddatelable.setBounds(523, 128, 288, 40);
		MyBookingDofDaily.add(Bookeddatelable);
		
		JLabel lblNewLabel_22 = new JLabel("Slot Alotted :-");
		lblNewLabel_22.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_22.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_22.setBounds(207, 202, 252, 40);
		MyBookingDofDaily.add(lblNewLabel_22);
		
		Slotalloteddatelable = new JLabel("..");
		Slotalloteddatelable.setHorizontalAlignment(SwingConstants.CENTER);
		Slotalloteddatelable.setFont(new Font("Tahoma", Font.BOLD, 14));
		Slotalloteddatelable.setBounds(543, 202, 268, 40);
		MyBookingDofDaily.add(Slotalloteddatelable);
		
		JLabel lblNewLabel_23 = new JLabel("Payment Status :-");
		lblNewLabel_23.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_23.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_23.setBounds(239, 284, 221, 40);
		MyBookingDofDaily.add(lblNewLabel_23);
		
		JLabel lblNewLabel_24 = new JLabel("Successful ( ^ _ ^ )");
		lblNewLabel_24.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_24.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_24.setBounds(543, 284, 268, 47);
		MyBookingDofDaily.add(lblNewLabel_24);
		
		JPanel DailyBookingDorNpanel = new JPanel();
		SecondTabbedPane.addTab("New tab", null, DailyBookingDorNpanel, null);
		DailyBookingDorNpanel.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("..");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setBounds(518, 148, 285, 40);
		DailyBookingDorNpanel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setBounds(138, 148, 296, 40);
		DailyBookingDorNpanel.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Status Of Your Booking");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setBounds(148, 148, 247, 43);
		DailyBookingDorNpanel.add(lblNewLabel_12);
		
		JPanel Shiftpanel = new JPanel();
		MaintabbedPane.addTab("New tab", null, Shiftpanel, null);
		Shiftpanel.setLayout(null);
		
		JTabbedPane ThirdTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		ThirdTabbedPane.setBounds(0, -30, 1069, 550);
		Shiftpanel.add(ThirdTabbedPane);
		
		JPanel ShiftPanel = new JPanel();
		ThirdTabbedPane.addTab("New tab", null, ShiftPanel, null);
		ShiftPanel.setLayout(null);
		
		JLabel lblNewLabel_13 = new JLabel("Choose the Required Service");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setBounds(273, 54, 377, 29);
		ShiftPanel.add(lblNewLabel_13);
		
		JRadioButton BookShiftR = new JRadioButton("Book Shift");
		BookShiftR.setFont(new Font("Tahoma", Font.PLAIN, 14));
		BookShiftR.setBounds(381, 114, 176, 35);
		ShiftPanel.add(BookShiftR);
		
		JRadioButton MyShiftR = new JRadioButton("My Shift Allotment");
		MyShiftR.setFont(new Font("Tahoma", Font.PLAIN, 14));
		MyShiftR.setBounds(383, 169, 174, 35);
		ShiftPanel.add(MyShiftR);
		
		ButtonGroup shiftbg=new ButtonGroup();
		shiftbg.add(BookShiftR);
		shiftbg.add(MyShiftR);
		
		JButton ShiftSubmit = new JButton("Submit");
		ShiftSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(BookShiftR.isSelected())
				{
					ThirdTabbedPane.setSelectedIndex(1);
				}
				else {
					ThirdTabbedPane.setSelectedIndex(2);
				}
			}
		});
		ShiftSubmit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ShiftSubmit.setBounds(394, 242, 148, 41);
		ShiftPanel.add(ShiftSubmit);
		
		JPanel ShiftTypePanel = new JPanel();
		ThirdTabbedPane.addTab("New tab", null, ShiftTypePanel, null);
		ShiftTypePanel.setLayout(null);
		
		JTabbedPane ShiftTypeTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		ShiftTypeTabbedPane.setBounds(0, -26, 1081, 548);
		ShiftTypePanel.add(ShiftTypeTabbedPane);
		
		JPanel ShiftChoosingPanel = new JPanel();
		ShiftTypeTabbedPane.addTab("New tab", null, ShiftChoosingPanel, null);
		ShiftChoosingPanel.setLayout(null);
		
		JLabel lblNewLabel_14 = new JLabel("Choose The Shift to be Booked");
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_14.setBounds(333, 41, 301, 51);
		ShiftChoosingPanel.add(lblNewLabel_14);
		
		JRadioButton MOrningShiftR = new JRadioButton("Morning Shift (6.00 AM - 12.00 PM)");
		MOrningShiftR.setFont(new Font("Tahoma", Font.PLAIN, 14));
		MOrningShiftR.setBounds(411, 118, 271, 23);
		ShiftChoosingPanel.add(MOrningShiftR);
		
		JRadioButton AfternoonShiftR = new JRadioButton("Afternoon Shift (12.01 PM - 5.59 PM)");
		AfternoonShiftR.setFont(new Font("Tahoma", Font.PLAIN, 14));
		AfternoonShiftR.setBounds(411, 163, 279, 23);
		ShiftChoosingPanel.add(AfternoonShiftR);
		
		JRadioButton NightShiftR = new JRadioButton("Night Shift (6.00 PM - 5.59 AM)");
		NightShiftR.setFont(new Font("Tahoma", Font.PLAIN, 14));
		NightShiftR.setBounds(411, 204, 279, 23);
		ShiftChoosingPanel.add(NightShiftR);
		
		ButtonGroup shifttypebg=new ButtonGroup();
		shifttypebg.add(MOrningShiftR);
		shifttypebg.add(AfternoonShiftR);
		shifttypebg.add(NightShiftR);
		
		JButton WhichShiftButton = new JButton("Submit");
		WhichShiftButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(MOrningShiftR.isSelected())
				{
					ShiftTypeTabbedPane.setSelectedIndex(1);
				}
				else if (AfternoonShiftR.isSelected())
				{
					ShiftTypeTabbedPane.setSelectedIndex(2);
				}
				else {
					ShiftTypeTabbedPane.setSelectedIndex(3);
				}
			}
		});
		WhichShiftButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		WhichShiftButton.setBounds(408, 263, 142, 42);
		ShiftChoosingPanel.add(WhichShiftButton);
		
		JPanel MorningShiftPAnel = new JPanel();
		ShiftTypeTabbedPane.addTab("New tab", null, MorningShiftPAnel, null);
		MorningShiftPAnel.setLayout(null);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBounds(240, 51, 534, 310);
		MorningShiftPAnel.add(panel_10);
		panel_10.setLayout(null);
		
		JLabel lblNewLabel_15 = new JLabel("Enter Date(YYYY-mm-DD)");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_15.setBounds(25, 32, 192, 37);
		panel_10.add(lblNewLabel_15);
		
		MorningShiftDate = new JTextField();
		MorningShiftDate.setBounds(254, 36, 252, 33);
		panel_10.add(MorningShiftDate);
		MorningShiftDate.setColumns(10);
		
		JLabel lblNewLabel_16 = new JLabel("Total Amount To Pay");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_16.setBounds(25, 98, 192, 25);
		panel_10.add(lblNewLabel_16);
		
		JLabel MorningShiftTotalPay = new JLabel("..");
		MorningShiftTotalPay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		MorningShiftTotalPay.setBounds(256, 98, 244, 25);
		panel_10.add(MorningShiftTotalPay);
		
		JPanel Normalpanel1_1_1 = new JPanel();
		Normalpanel1_1_1.setLayout(null);
		Normalpanel1_1_1.setBounds(10, 134, 482, 99);
		panel_10.add(Normalpanel1_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Do you want to pay?");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1.setBounds(20, 15, 139, 19);
		Normalpanel1_1_1.add(lblNewLabel_2_1_1);
		
		JCheckBox MorningShiftPayConfirmation = new JCheckBox("Pay");
		MorningShiftPayConfirmation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		MorningShiftPayConfirmation.setBounds(240, 13, 99, 23);
		Normalpanel1_1_1.add(MorningShiftPayConfirmation);
		
		JButton MorningShiftSubmit = new JButton("Submit");
		MorningShiftSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThirdTabbedPane.setSelectedIndex(3);
			}
		});
		MorningShiftSubmit.setBounds(188, 250, 152, 49);
		panel_10.add(MorningShiftSubmit);
		
		JPanel AfterNoonShiftPanel = new JPanel();
		ShiftTypeTabbedPane.addTab("New tab", null, AfterNoonShiftPanel, null);
		AfterNoonShiftPanel.setLayout(null);
		
		JPanel panel_10_1 = new JPanel();
		panel_10_1.setLayout(null);
		panel_10_1.setBounds(240, 52, 534, 310);
		AfterNoonShiftPanel.add(panel_10_1);
		
		JLabel lblNewLabel_15_1 = new JLabel("Enter Date(YYYY-mm-DD)");
		lblNewLabel_15_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_15_1.setBounds(25, 32, 192, 37);
		panel_10_1.add(lblNewLabel_15_1);
		
		AfterNoonShiftDate = new JTextField();
		AfterNoonShiftDate.setColumns(10);
		AfterNoonShiftDate.setBounds(254, 36, 252, 33);
		panel_10_1.add(AfterNoonShiftDate);
		
		
		JLabel lblNewLabel_16_1 = new JLabel("Total Amount To Pay");
		lblNewLabel_16_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_16_1.setBounds(25, 98, 192, 25);
		panel_10_1.add(lblNewLabel_16_1);
		
		JLabel AfternoonShiftTotalPAy = new JLabel("..");
		AfternoonShiftTotalPAy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		AfternoonShiftTotalPAy.setBounds(256, 98, 244, 25);
		panel_10_1.add(AfternoonShiftTotalPAy);
		
		JPanel Normalpanel1_1_1_1 = new JPanel();
		Normalpanel1_1_1_1.setLayout(null);
		Normalpanel1_1_1_1.setBounds(10, 134, 482, 99);
		panel_10_1.add(Normalpanel1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Do you want to pay?");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1_1.setBounds(20, 15, 139, 19);
		Normalpanel1_1_1_1.add(lblNewLabel_2_1_1_1);
		
		JCheckBox AfterNoonShiftPayConfirmation = new JCheckBox("Pay");
		AfterNoonShiftPayConfirmation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		AfterNoonShiftPayConfirmation.setBounds(240, 13, 99, 23);
		Normalpanel1_1_1_1.add(AfterNoonShiftPayConfirmation);
		
		JButton AfterNoonShiftSubmit = new JButton("Submit");
		AfterNoonShiftSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThirdTabbedPane.setSelectedIndex(3);
			}
		});
		AfterNoonShiftSubmit.setBounds(188, 250, 152, 49);
		panel_10_1.add(AfterNoonShiftSubmit);
		
		JPanel NightShiftPAnel = new JPanel();
		ShiftTypeTabbedPane.addTab("New tab", null, NightShiftPAnel, null);
		NightShiftPAnel.setLayout(null);
		
		JPanel panel_10_2 = new JPanel();
		panel_10_2.setLayout(null);
		panel_10_2.setBounds(239, 51, 534, 310);
		NightShiftPAnel.add(panel_10_2);
		
		JLabel lblNewLabel_15_2 = new JLabel("Enter Date(YYYY-mm-DD)");
		lblNewLabel_15_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_15_2.setBounds(25, 32, 192, 37);
		panel_10_2.add(lblNewLabel_15_2);
		
		NightShiftDate = new JTextField();
		NightShiftDate.setColumns(10);
		NightShiftDate.setBounds(254, 36, 252, 33);
		panel_10_2.add(NightShiftDate);
		
		JLabel lblNewLabel_16_2 = new JLabel("Total Amount To Pay");
		lblNewLabel_16_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_16_2.setBounds(25, 98, 192, 25);
		panel_10_2.add(lblNewLabel_16_2);
		
		JLabel NightShiftTotalPay = new JLabel("..");
		NightShiftTotalPay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		NightShiftTotalPay.setBounds(256, 98, 244, 25);
		panel_10_2.add(NightShiftTotalPay);
		
		JPanel Normalpanel1_1_1_2 = new JPanel();
		Normalpanel1_1_1_2.setLayout(null);
		Normalpanel1_1_1_2.setBounds(10, 134, 482, 99);
		panel_10_2.add(Normalpanel1_1_1_2);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("Do you want to pay?");
		lblNewLabel_2_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1_2.setBounds(20, 15, 139, 19);
		Normalpanel1_1_1_2.add(lblNewLabel_2_1_1_2);
		
		JCheckBox NightShiftPayConfirmation = new JCheckBox("Pay");
		NightShiftPayConfirmation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		NightShiftPayConfirmation.setBounds(240, 13, 99, 23);
		Normalpanel1_1_1_2.add(NightShiftPayConfirmation);
		
		JButton NightShiftSubmit = new JButton("Submit");
		NightShiftSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThirdTabbedPane.setSelectedIndex(3);
			}
		});
		NightShiftSubmit.setBounds(188, 250, 152, 49);
		panel_10_2.add(NightShiftSubmit);
		
		JPanel MyBookingsDofShift = new JPanel();
		ThirdTabbedPane.addTab("New tab", null, MyBookingsDofShift, null);
		MyBookingsDofShift.setLayout(null);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Details About Your Bookings");
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3_1_1.setBounds(296, 158, 395, 47);
		MyBookingsDofShift.add(lblNewLabel_3_1_1);
		
		JPanel MyShiftBookingDorNpanel = new JPanel();
		ThirdTabbedPane.addTab("New tab", null, MyShiftBookingDorNpanel, null);
		MyShiftBookingDorNpanel.setLayout(null);
		
		JLabel ShiftBookingStatus = new JLabel("..");
		ShiftBookingStatus.setHorizontalAlignment(SwingConstants.CENTER);
		ShiftBookingStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ShiftBookingStatus.setBounds(507, 150, 296, 40);
		MyShiftBookingDorNpanel.add(ShiftBookingStatus);
		
		JLabel Shiftstatus = new JLabel("Status Of Your Booking");
		Shiftstatus.setHorizontalAlignment(SwingConstants.CENTER);
		Shiftstatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Shiftstatus.setBounds(187, 150, 296, 40);
		MyShiftBookingDorNpanel.add(Shiftstatus);
		
		JPanel Waitlistedpanel = new JPanel();
		MaintabbedPane.addTab("New tab", null, Waitlistedpanel, null);
		
		JButton MonthlysubB = new JButton("Monthly ");
		MonthlysubB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MaintabbedPane.setSelectedIndex(1);
			}
		});
		MonthlysubB.setFont(new Font("Tahoma", Font.PLAIN, 11));
		MonthlysubB.setBounds(10, 11, 108, 103);
		panel_1.add(MonthlysubB);
		
		JButton DailysubB = new JButton("Book Date");
		DailysubB.setFont(new Font("Tahoma", Font.PLAIN, 11));
		DailysubB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MaintabbedPane.setSelectedIndex(2);
			}
		});
		DailysubB.setBounds(10, 135, 108, 107);
		panel_1.add(DailysubB);
		
		JButton ShiftbookB = new JButton("Book Shift");
		ShiftbookB.setFont(new Font("Tahoma", Font.PLAIN, 11));
		ShiftbookB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MaintabbedPane.setSelectedIndex(3);
			}
		});
		ShiftbookB.setBounds(10, 256, 108, 103);
		panel_1.add(ShiftbookB);
		
		JButton WaitListB = new JButton("Wait Listed");
		WaitListB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MaintabbedPane.setSelectedIndex(4);
			}
		});
		WaitListB.setBounds(10, 377, 108, 103);
		panel_1.add(WaitListB);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0));
		panel_2.setBounds(10, 558, 1236, 105);
		getContentPane().add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 0, 0));
		panel_3.setBounds(1180, 11, 66, 559);
		getContentPane().add(panel_3);
		
	}
}
