package javaGUI;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.DropMode;

public class hotel {

	private JFrame frame;
	private JTextField result;
	private String in;
	private boolean flag=false, dflag=false;
	private double num1=0, num2=0, ans=0, drink=0, pepsi=0, rice=0, pRice=0, burg=0, 
			pBurg=0, Coca=0, maaza=0, sprit=0, dew=0, pmeal=0, pdrink=0, pdeli=0, tax=0,
			total=0, pRoom=0, chow=0, pChow=0;
	private int op=0;
	private JTextField txtBurg;
	private JTextField txtFRice;
	private JTextField txtChow;
	private JTextField txtDrin;
	private JTextField txtEntCurr;
	private double USA=75.6295, Nepal=0.6249, Bangladesh=0.8909, SriLanka=0.4062;
	private JTextArea receiptArea;
	private JLabel lblclock;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hotel window = new hotel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void clock() {
		Thread clock = new Thread() {
			public void run() {
				try {
					while(true) {
						Calendar cal = new GregorianCalendar();
						int day = cal.get(Calendar.DAY_OF_MONTH);
						int month = cal.get(Calendar.MONTH);
						int year = cal.get(Calendar.YEAR);
						int msec= cal.get(Calendar.MILLISECOND);
						int sec = cal.get(Calendar.SECOND);
						int min = cal.get(Calendar.MINUTE);
						int hour = cal.get(Calendar.HOUR);
						
						lblclock.setText("Time : "+hour+":"+min+":"+sec+"\t	Date : "+year+"/"+month+"/"+day);
						sleep(1000);
					}
				}
				catch(Exception e) {
					
				}
			}
		};
		clock.start();
	}
	/**
	 * Create the application.
	 */
	public hotel() {
		initialize();
		clock();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 869, 233);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	    

		frame = new JFrame();
		frame.setBounds(0, 0, 1324, 805);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 10));
		panel.setBounds(10, 46, 421, 694);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 13, 397, 668);
		panel.add(tabbedPane);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Scientific Calculator", null, panel_3, null);
		panel_3.setLayout(null);
		
		result = new JTextField();
		result.setHorizontalAlignment(SwingConstants.RIGHT);
		result.setFont(new Font("Tahoma", Font.BOLD, 33));
		result.setColumns(10);
		result.setBounds(0, 13, 392, 60);
		panel_3.add(result);
		
		JButton bkButton = new JButton("<-");
		bkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				in=result.getText();
				if(in.length()>0) {
					if(in.charAt(in.length()-1) == '.')
						flag=false;					
					result.setText(in.substring(0, in.length()-1));
				}
				else
					JOptionPane.showMessageDialog(null, "Invalid Operation");
			}
		});
		bkButton.setFont(new Font("Tahoma", Font.BOLD, 27));
		bkButton.setBounds(10, 75, 70, 73);
		panel_3.add(bkButton);
		
		JButton button_1 = new JButton("C");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result.setText(null);
				op=0;
				flag=false;
				dflag=false;
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		button_1.setBounds(87, 74, 70, 73);
		panel_3.add(button_1);
		
		JButton button_2 = new JButton("%");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				flag=true;
				num2 = Double.parseDouble(result.getText());
				try {
				if(num1!=0 && num2!=0 && op!=0) {
					if(op==1)
						ans=num1+(num2*num1/100);
					if(op==2)
						ans=num1-(num2*num1/100);
					if(op==3)
						ans=(num1*num2)/100;
					if(op==4)
						ans=(num1/num2)*100;
				}
				result.setText(Double.toString(ans));
			}
				catch(Exception e) {}
			}
		});
		button_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		button_2.setBounds(164, 75, 70, 73);
		panel_3.add(button_2);
		
		JButton button_3 = new JButton("/");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				op=4;
				num1=Double.parseDouble(result.getText());
				flag=false;
				result.setText(null);
			}
		});
		button_3.setFont(new Font("Tahoma", Font.BOLD, 30));
		button_3.setBounds(241, 75, 70, 73);
		panel_3.add(button_3);
		
		JButton button_4 = new JButton("*");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				op=3;
				num1=Double.parseDouble(result.getText());
				flag=false;
				result.setText(null);
			}
		});
		button_4.setFont(new Font("Tahoma", Font.BOLD, 30));
		button_4.setBounds(241, 152, 70, 73);
		panel_3.add(button_4);
		
		JButton button_5 = new JButton("9");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				in=result.getText();
				result.setText(in+"9");
			}
		});
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		button_5.setBounds(163, 151, 70, 73);
		panel_3.add(button_5);
		
		JButton button_6 = new JButton("8");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				in=result.getText();
				result.setText(in+"8");
			}
		});
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		button_6.setBounds(86, 151, 70, 73);
		panel_3.add(button_6);
		
		JButton button_7 = new JButton("7");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				in=result.getText();
				result.setText(in+"7");
				
			}
		});
		button_7.setFont(new Font("Tahoma", Font.PLAIN, 25));
		button_7.setBounds(11, 153, 70, 73);
		panel_3.add(button_7);
		
		JButton button_8 = new JButton("4");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				in=result.getText();
				result.setText(in+"4");
			}
		});
		button_8.setFont(new Font("Tahoma", Font.PLAIN, 25));
		button_8.setBounds(10, 232, 70, 73);
		panel_3.add(button_8);
		
		JButton button_9 = new JButton("5");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				in=result.getText();
				result.setText(in+"5");
			}
		});
		button_9.setFont(new Font("Tahoma", Font.PLAIN, 25));
		button_9.setBounds(87, 231, 70, 73);
		panel_3.add(button_9);
		
		JButton button_10 = new JButton("6");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				in=result.getText();
				result.setText(in+"6");
			}
		});
		button_10.setFont(new Font("Tahoma", Font.PLAIN, 25));
		button_10.setBounds(163, 230, 70, 73);
		panel_3.add(button_10);
		
		JButton button_11 = new JButton("-");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				op=2;
				num1=Double.parseDouble(result.getText());
				flag=false;
				result.setText(null);
			}
		});
		button_11.setFont(new Font("Tahoma", Font.BOLD, 30));
		button_11.setBounds(241, 230, 70, 73);
		panel_3.add(button_11);
		
		JButton button_12 = new JButton("+");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				op=1;
				num1=Double.parseDouble(result.getText());
				flag=false;
				result.setText(null);
			}
		});
		button_12.setFont(new Font("Tahoma", Font.BOLD, 25));
		button_12.setBounds(241, 310, 70, 73);
		panel_3.add(button_12);
		
		JButton button_13 = new JButton("3");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				in=result.getText();
				result.setText(in+"3");
			}
		});
		button_13.setFont(new Font("Tahoma", Font.PLAIN, 25));
		button_13.setBounds(164, 310, 70, 73);
		panel_3.add(button_13);
		
		JButton button_14 = new JButton("2");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				in=result.getText();
				result.setText(in+"2");
			}
		});
		button_14.setFont(new Font("Tahoma", Font.PLAIN, 25));
		button_14.setBounds(86, 310, 70, 73);
		panel_3.add(button_14);
		
		JButton sqrtButton = new JButton("²√x");
		sqrtButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				in=result.getText();
				num1=Double.parseDouble(in);
				result.setText(Double.toString(Math.sqrt(num1)));
			}
		});
		sqrtButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		sqrtButton.setBounds(10, 552, 70, 73);
		panel_3.add(sqrtButton);
		
		JButton button_16 = new JButton("0");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				in=result.getText();
				result.setText(in+"0");
			}
		});
		button_16.setFont(new Font("Tahoma", Font.PLAIN, 25));
		button_16.setBounds(11, 390, 70, 73);
		panel_3.add(button_16);
		
		JButton button_17 = new JButton(".");
		button_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(flag==false) {
					in=result.getText();
					result.setText(in+".");
					flag=true;
				}
			else {
				JOptionPane.showMessageDialog(null, "Invalid Input");
				}
			}
		});
		button_17.setFont(new Font("Tahoma", Font.BOLD, 30));
		button_17.setBounds(86, 389, 70, 73);
		panel_3.add(button_17);
		
		JButton button_18 = new JButton("\u00B1");
		button_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				in = result.getText();
				double temp= Double.parseDouble(in);
				if(temp>0)
					result.setText("-"+in);
				else
					result.setText(Double.toString(temp*-1));
				flag=true;
			}
		});
		button_18.setFont(new Font("Tahoma", Font.BOLD, 30));
		button_18.setBounds(163, 388, 70, 73);
		panel_3.add(button_18);
		
		JButton button_19 = new JButton("=");
		button_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				num2=Double.parseDouble(result.getText());
				if(op==1)
					ans=num1+num2;
				if(op==2)
					ans=num1-num2;
				if(op==3)
					ans=(num1*num2);
				if(op==4)
					ans=(num1/num2);
				if(op==5)
					ans=Math.pow(num1, num2);
			result.setText(Double.toString(ans));
			}
		});
		button_19.setFont(new Font("Tahoma", Font.BOLD, 30));
		button_19.setBounds(241, 389, 70, 73);
		panel_3.add(button_19);
		
		JButton sqButton = new JButton("x\u00B2");
		sqButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				in=result.getText();
				num1=Double.parseDouble(in);
				result.setText(Double.toString(Math.pow(num1,  2)));
			}
		});
		sqButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		sqButton.setBounds(12, 470, 70, 73);
		panel_3.add(sqButton);
		
		JButton cbButton = new JButton("x\u00B3");
		cbButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				in=result.getText();
				num1=Double.parseDouble(in);
				result.setText(Double.toString(Math.pow(num1,  3)));
			}
		});
		cbButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		cbButton.setBounds(88, 468, 70, 73);
		panel_3.add(cbButton);
		
		JButton lnButton = new JButton("log");
		lnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				in=result.getText();
				num1=Double.parseDouble(in);
				result.setText(Double.toString(Math.sin(num1)));
			}
		});
		lnButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lnButton.setBounds(316, 75, 70, 73);
		panel_3.add(lnButton);
		
		JButton btnLog = new JButton("ln");
		btnLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				in=result.getText();
				num1=Double.parseDouble(in);
				result.setText(Double.toString(Math.log(num1)));
			}
		});
		btnLog.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLog.setBounds(318, 152, 70, 73);
		panel_3.add(btnLog);
		
		JButton btnTan = new JButton("tan");
		btnTan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				in=result.getText();
				num1=Double.parseDouble(in);
				result.setText(Double.toString(Math.tan(num1)));
			}
		});
		btnTan.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnTan.setBounds(317, 230, 70, 73);
		panel_3.add(btnTan);
		
		JButton btnCos = new JButton("cos");
		btnCos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				in=result.getText();
				num1=Double.parseDouble(in);
				result.setText(Double.toString(Math.cos(num1)));
			}
		});
		btnCos.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnCos.setBounds(317, 309, 70, 73);
		panel_3.add(btnCos);
		
		JButton btnSin = new JButton("sin");
		btnSin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				in=result.getText();
				num1=Double.parseDouble(in);
				result.setText(Double.toString(Math.sin(num1)));
			}
		});
		btnSin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnSin.setBounds(318, 388, 70, 73);
		panel_3.add(btnSin);
		
		JButton button_27 = new JButton("1");
		button_27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				in=result.getText();
				result.setText(in+"1");
			}
		});
		button_27.setFont(new Font("Tahoma", Font.PLAIN, 25));
		button_27.setBounds(8, 310, 70, 73);
		panel_3.add(button_27);
		
		JButton cbrtButton = new JButton("\u00B3\u221Ax ");
		cbrtButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				in=result.getText();
				num1=Double.parseDouble(in);
				result.setText(Double.toString(Math.cbrt(num1)));
			}
		});
		cbrtButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		cbrtButton.setBounds(87, 550, 70, 73);
		panel_3.add(cbrtButton);
		
		JButton xyButton = new JButton("^");
		xyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				in=result.getText();
				num1=Double.parseDouble(in);
				op=5;
				result.setText(null);
			}
		});
		xyButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		xyButton.setBounds(166, 468, 70, 73);
		panel_3.add(xyButton);
		
		JButton exButton = new JButton("e^x");
		exButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				in=result.getText();
				num1=Double.parseDouble(in);
				result.setText(Double.toString(Math.pow(2.718281828, num1)));
			}
		});
		exButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		exButton.setBounds(164, 550, 70, 73);
		panel_3.add(exButton);
		
		JButton txButton = new JButton("10^x");
		txButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				in=result.getText();
				num1=Double.parseDouble(in);
				result.setText(Double.toString(Math.pow(10, num1)));
			}
		});
		txButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txButton.setBounds(241, 551, 70, 73);
		panel_3.add(txButton);
		
		JButton oxButton = new JButton("1/x");
		oxButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				in=result.getText();
				num1=Double.parseDouble(in);
				result.setText(Double.toString(1/num1));
			}
		});
		oxButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		oxButton.setBounds(242, 469, 70, 73);
		panel_3.add(oxButton);
		
		JButton pButton = new JButton("pi");
		pButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				in=result.getText();
				result.setText(in+"3.141592654");
			}
		});
		pButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pButton.setBounds(317, 469, 70, 73);
		panel_3.add(pButton);
		
		JButton facButton = new JButton("x!");
		facButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				in=result.getText();
				int f=1;
				num1=Integer.parseInt(in);
				for(int i=1;i<=num1;i++)
					f=f*i;
				result.setText(Integer.toString(f));
			}
		});
		facButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		facButton.setBounds(316, 551, 70, 73);
		panel_3.add(facButton);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Receipt", null, panel_4, null);
		panel_4.setLayout(null);
		
		receiptArea = new JTextArea();
		//receiptArea.setHorizontalAlignment(SwingConstants.LEFT);
		receiptArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		receiptArea.setBounds(0, 0, 392, 638);
		panel_4.add(receiptArea);
		receiptArea.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.DARK_GRAY);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 10));
		panel_1.setBounds(438, 126, 850, 330);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Menu");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_1.setBounds(12, 13, 101, 37);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblQty = new JLabel("Qty.");
		lblQty.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblQty.setBounds(249, 13, 101, 37);
		panel_1.add(lblQty);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblPrice.setBounds(410, 13, 101, 37);
		panel_1.add(lblPrice);
		
		JLabel lblNewLabel_2 = new JLabel("Fried Rice");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(12, 52, 146, 37);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblBurger = new JLabel("Burger");
		lblBurger.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblBurger.setBounds(12, 80, 146, 37);
		panel_1.add(lblBurger);
		
		JLabel lblChowmin = new JLabel("Chowmin");
		lblChowmin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblChowmin.setBounds(12, 114, 146, 37);
		panel_1.add(lblChowmin);
		
		txtBurg = new JTextField();
		txtBurg.setHorizontalAlignment(SwingConstants.RIGHT);
		txtBurg.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtBurg.setColumns(10);
		txtBurg.setBounds(212, 88, 146, 30);
		panel_1.add(txtBurg);
		
		txtFRice = new JTextField();
		txtFRice.setHorizontalAlignment(SwingConstants.RIGHT);
		txtFRice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtFRice.setColumns(10);
		txtFRice.setBounds(212, 52, 146, 30);
		panel_1.add(txtFRice);
		
		txtChow = new JTextField();
		txtChow.setHorizontalAlignment(SwingConstants.RIGHT);
		txtChow.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtChow.setColumns(10);
		txtChow.setBounds(212, 122, 146, 30);
		panel_1.add(txtChow);
		
		JLabel lblNewLabel_3 = new JLabel("Rs.20.0");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(418, 52, 115, 30);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblRs = new JLabel("Rs.25.0");
		lblRs.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblRs.setBounds(418, 87, 115, 30);
		panel_1.add(lblRs);
		
		JLabel lblRs_1 = new JLabel("Rs.15.0");
		lblRs_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblRs_1.setBounds(418, 122, 115, 30);
		panel_1.add(lblRs_1);
		
		JComboBox btnChosDrin = new JComboBox();
		btnChosDrin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnChosDrin.setModel(new DefaultComboBoxModel(new String[] {"Choose A Drink", "Coca Cola", "Pepsi", "Maaza", "Sprit", "Dew"}));
		btnChosDrin.setBounds(12, 151, 172, 37);
		panel_1.add(btnChosDrin);
		
		txtDrin = new JTextField();
		txtDrin.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDrin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDrin.setColumns(10);
		txtDrin.setBounds(212, 157, 146, 30);
		panel_1.add(txtDrin);
		
		JLabel label = new JLabel("-");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label.setBounds(418, 157, 115, 30);
		panel_1.add(label);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(12, 201, 499, 2);
		panel_1.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setBounds(510, 13, 9, 304);
		panel_1.add(separator_4);
		
		JComboBox btnChosRoom = new JComboBox();
		btnChosRoom.setModel(new DefaultComboBoxModel(new String[] {"Choose a Room", "100", "200", "VIP"}));
		btnChosRoom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnChosRoom.setBounds(12, 209, 172, 37);
		panel_1.add(btnChosRoom);
		
		JCheckBox btnDelivery = new JCheckBox("Delivery");
		btnDelivery.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnDelivery.setBounds(12, 252, 129, 30);
		panel_1.add(btnDelivery);
		
		JCheckBox btnTax = new JCheckBox("TAX");
		btnTax.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnTax.setBounds(12, 280, 115, 37);
		panel_1.add(btnTax);
				
		JLabel lblCurrencyConverter = new JLabel("Currency Converter");
		lblCurrencyConverter.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrencyConverter.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblCurrencyConverter.setBounds(515, 13, 304, 37);
		panel_1.add(lblCurrencyConverter);
		
		JComboBox txtEntCountry = new JComboBox();
		txtEntCountry.setModel(new DefaultComboBoxModel(new String[] {"Selet a Country", "USA", "Nepal", "Bangladesh", "Sri Lanka"}));
		txtEntCountry.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtEntCountry.setBounds(560, 52, 209, 37);
		panel_1.add(txtEntCountry);
		
		txtEntCurr = new JTextField();
		txtEntCurr.setHorizontalAlignment(SwingConstants.RIGHT);
		txtEntCurr.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtEntCurr.setColumns(10);
		txtEntCurr.setBounds(560, 112, 209, 37);
		panel_1.add(txtEntCurr);
		
		JLabel txtCurrOp = new JLabel("");
		txtCurrOp.setHorizontalAlignment(SwingConstants.CENTER);
		txtCurrOp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtCurrOp.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		txtCurrOp.setBounds(562, 162, 207, 37);
		panel_1.add(txtCurrOp);
		
		JButton btnReset2 = new JButton("Reset");
		btnReset2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtEntCurr.setText(null);
				txtEntCountry.setSelectedIndex(0);
				txtCurrOp.setText(null);
			}
		});
		btnReset2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnReset2.setBounds(671, 231, 129, 30);
		panel_1.add(btnReset2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 10));
		panel_2.setBounds(438, 469, 850, 271);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel btnTotalCost = new JLabel("Total Cost Of Meal");
		btnTotalCost.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnTotalCost.setBounds(25, 23, 216, 37);
		panel_2.add(btnTotalCost);
		
		JLabel btnTotalCostOf = new JLabel("Total Cost Of Drink");
		btnTotalCostOf.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnTotalCostOf.setBounds(25, 73, 216, 37);
		panel_2.add(btnTotalCostOf);
		
		JLabel btnCostOfDelivery = new JLabel("Cost Of Delivery");
		btnCostOfDelivery.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnCostOfDelivery.setBounds(25, 125, 216, 37);
		panel_2.add(btnCostOfDelivery);
		
		JLabel btnCostOfRoom = new JLabel("Cost Of Room");
		btnCostOfRoom.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnCostOfRoom.setBounds(25, 177, 216, 37);
		panel_2.add(btnCostOfRoom);
		
		JLabel txtTotalCost = new JLabel("");
		txtTotalCost.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalCost.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtTotalCost.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		txtTotalCost.setBounds(269, 23, 207, 37);
		panel_2.add(txtTotalCost);
		
		JLabel txtTotalDrink = new JLabel("");
		txtTotalDrink.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalDrink.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtTotalDrink.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		txtTotalDrink.setBounds(269, 73, 207, 37);
		panel_2.add(txtTotalDrink);
		
		JLabel txtCdelivery = new JLabel("");
		txtCdelivery.setHorizontalAlignment(SwingConstants.CENTER);
		txtCdelivery.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtCdelivery.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		txtCdelivery.setBounds(269, 125, 207, 37);
		panel_2.add(txtCdelivery);
		
		JLabel txtCRoom = new JLabel("");
		txtCRoom.setHorizontalAlignment(SwingConstants.CENTER);
		txtCRoom.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtCRoom.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		txtCRoom.setBounds(269, 177, 207, 37);
		panel_2.add(txtCRoom);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setOrientation(SwingConstants.VERTICAL);
		separator_5.setBounds(484, 13, 9, 245);
		panel_2.add(separator_5);
		
		JLabel btnTax1 = new JLabel("Tax");
		btnTax1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnTax1.setBounds(495, 23, 126, 37);
		panel_2.add(btnTax1);
		
		JLabel btnSubTotal = new JLabel("Sub Total");
		btnSubTotal.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnSubTotal.setBounds(495, 73, 126, 37);
		panel_2.add(btnSubTotal);
		
		JLabel btnTotal = new JLabel("Total");
		btnTotal.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnTotal.setBounds(495, 125, 126, 37);
		panel_2.add(btnTotal);
		
		JLabel txtTax = new JLabel("");
		txtTax.setHorizontalAlignment(SwingConstants.CENTER);
		txtTax.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtTax.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		txtTax.setBounds(616, 23, 207, 37);
		panel_2.add(txtTax);
		
		JLabel txtSubTotal = new JLabel("");
		txtSubTotal.setHorizontalAlignment(SwingConstants.CENTER);
		txtSubTotal.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtSubTotal.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		txtSubTotal.setBounds(616, 73, 207, 37);
		panel_2.add(txtSubTotal);
		
		JLabel txtTotal = new JLabel("");
		txtTotal.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotal.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtTotal.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		txtTotal.setBounds(616, 125, 207, 37);
		panel_2.add(txtTotal);
		
		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_1.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		label_1.setBounds(491, 177, 332, 37);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("Clock");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_2.setBounds(490, 177, 332, 37);
		panel_2.add(label_2);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
				//********************Drink*************************
				
				drink = Double.parseDouble(txtDrin.getText());
				pepsi = 15.0*drink;
				Coca = 17.0*drink;
				maaza = 20.0*drink;
				sprit = 15.0*drink;
				dew =  15.0*drink;
				if(btnChosDrin.getSelectedItem().equals("Pepsi")) 
					txtTotalDrink.setText(String.format("%.3f", pepsi));
				if(btnChosDrin.getSelectedItem().equals("Maaza")) 
					txtTotalDrink.setText(String.format("%.3f", maaza));
				if(btnChosDrin.getSelectedItem().equals("Coca Cola")) 
					txtTotalDrink.setText(String.format("%.3f", Coca));
				if(btnChosDrin.getSelectedItem().equals("Sprit")) 
					txtTotalDrink.setText(String.format("%.3f", sprit));
				if(btnChosDrin.getSelectedItem().equals("Dew")) 
					txtTotalDrink.setText(String.format("%.3f", dew));
				if(btnChosDrin.getSelectedItem().equals("Choose a Drink")) 
					txtTotalDrink.setText(String.format("0.000"));
				
				//******************Meal*******************************
				
				rice = Double.parseDouble(txtFRice.getText());
				pRice = 20*rice;
				txtTotalCost.setText(String.format("%.3f", pRice));
				
				burg = Double.parseDouble(txtBurg.getText());
				pBurg = 25*burg;
				txtTotalCost.setText(String.format("%.3f", (pRice+pBurg)));
				
				chow = Double.parseDouble(txtChow.getText());
				pChow = 15*chow;
				txtTotalCost.setText(String.format("%.3f", (pRice+pBurg+pChow)));
				
				//********************Delivery***************************
			
				if(btnDelivery.isSelected()) 
					txtCdelivery.setText("75.000");
				else
					txtCdelivery.setText("0.000");
				
				//*************Room*******************
				
				pRoom=0;
				if(btnChosRoom.getSelectedItem().equals("100")) {
					pRoom=500;
					txtCRoom.setText(String.format("500.000"));}
				if(btnChosRoom.getSelectedItem().equals("200")) {
					pRoom=550;
					txtCRoom.setText(String.format("550.000"));}
				if(btnChosRoom.getSelectedItem().equals("VIP")) {
					pRoom=750;
					txtCRoom.setText(String.format("750.000"));}
				if(btnChosRoom.getSelectedItem().equals("Choose a Room")) {
					pRoom=0;
					txtCRoom.setText(String.format("0.000")); }
				
				
				//****************Tax***************
				
				pmeal = Double.parseDouble(txtTotalCost.getText());
				pdrink = Double.parseDouble(txtTotalDrink.getText());
				pdeli = Double.parseDouble(txtCdelivery.getText());
				tax = (pmeal+pdrink+pdeli+pRoom)*0.09;
				total = (pmeal+pdrink+pdeli);
				if(btnTax.isSelected())
					txtTax.setText(String.format("%.3f", tax*2));
				else
					txtTax.setText(String.format("%.3f", tax));
				
				//**************Total***********************
				tax=Double.parseDouble(txtTax.getText());
				txtSubTotal.setText(String.format("%.3f", pRoom+total));
				txtTotal.setText(String.format("%.3f", pRoom+total+tax));
				}
				catch(Exception e) {
					System.out.print(e);
				}
			}		
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSubmit.setBounds(221, 231, 129, 30);
		panel_1.add(btnSubmit);
		
		JLabel lblNewLabel = new JLabel("Hotel Management System");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblNewLabel.setBounds(438, 35, 850, 85);
		frame.getContentPane().add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1482, 33);
		frame.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 20));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("New");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 17));
		mnNewMenu.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Receipt");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double invoive1=Double.parseDouble(txtTotalCost.getText());
				double invoive2=Double.parseDouble(txtTotalDrink.getText());
				double invoive3=Double.parseDouble(txtCdelivery.getText());
				double invoive4=Double.parseDouble(txtCRoom.getText());
				double invoive5=Double.parseDouble(txtTax.getText());
				double invoive6=Double.parseDouble(txtTotal.getText());
				String s=receiptArea.getText()+"\nHotel Management System\n"
						+ "************************************************\n"
						+ "\nTotal Cost Of Meal\t: " + invoive1
						+ "\nTotal Cost of Drink\t: " + invoive2
						+ "\nTotal Cost of Room\t: " + invoive4
						+ "\nTotal Cost of Delivery\t: " + invoive3
						+ "\n\nTax\t: " + invoive5
						+ "\nTotal\t: " + invoive6;
				receiptArea.append(s);
			}
		});
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 17));
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Reset\r\n");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtFRice.setText(null);
				txtBurg.setText(null);
				txtChow.setText(null);
				txtDrin.setText(null);
				txtTotalCost.setText(null);
				txtTotalDrink.setText(null);
				txtCdelivery.setText(null);
				txtCRoom.setText(null);
				txtTax.setText(null);
				txtSubTotal.setText(null);
				txtTotal.setText(null);
				btnChosDrin.setSelectedIndex(0);
				btnChosRoom.setSelectedIndex(0);
				receiptArea.setText(null);
				txtEntCurr.setText(null);
				txtEntCountry.setSelectedIndex(0);
				txtCurrOp.setText(null);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.BOLD, 17));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Convert\r\n");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String dis="";
				double op=0;				
				if(txtEntCountry.getSelectedItem().equals("USA")) {
					op=USA;
					dis="USD ";}
				if(txtEntCountry.getSelectedItem().equals("Nepal")) {
					op=Nepal;
					dis="NPR ";}
				if(txtEntCountry.getSelectedItem().equals("Bangladesh")) {
					op=Bangladesh;
					dis="BDT "; }
				if(txtEntCountry.getSelectedItem().equals("Sri Lanka")) {
					op=SriLanka;
					dis="LKR ";}
				if(txtEntCurr.getText().length()==0)
					dis=dis+String.format("%.3f", (Double.parseDouble(txtTotal.getText())/op));
				else
					dis=dis+String.format("%.3f", (Double.parseDouble(txtEntCurr.getText())/op));
				txtCurrOp.setText(dis);
			}
		});
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.BOLD, 17));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Total");
		mntmNewMenuItem_3.setFont(new Font("Segoe UI", Font.BOLD, 17));
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JSeparator separator_2 = new JSeparator();
		mnNewMenu.add(separator_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Refresh");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFRice.setText(null);
				txtBurg.setText(null);
				txtChow.setText(null);
				txtDrin.setText(null);
				txtTotalCost.setText(null);
				txtTotalDrink.setText(null);
				txtCdelivery.setText(null);
				txtCRoom.setText(null);
				txtTax.setText(null);
				txtSubTotal.setText(null);
				txtTotal.setText(null);
				btnChosDrin.setSelectedIndex(0);
				btnChosRoom.setSelectedIndex(0);
				receiptArea.setText(null);
				txtEntCurr.setText(null);
				txtEntCountry.setSelectedIndex(0);
				txtCurrOp.setText(null);
			}
		});
		mntmNewMenuItem_4.setFont(new Font("Segoe UI", Font.BOLD, 17));
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JSeparator separator_1 = new JSeparator();
		mnNewMenu.add(separator_1);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Exit");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmNewMenuItem_5.setFont(new Font("Segoe UI", Font.BOLD, 17));
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_2 = new JMenu("Convert");
		mnNewMenu_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String dis="";
				double op=0;				
				if(txtEntCountry.getSelectedItem().equals("USA")) {
					op=USA;
					dis="USD ";}
				if(txtEntCountry.getSelectedItem().equals("Nepal")) {
					op=Nepal;
					dis="NPR ";}
				if(txtEntCountry.getSelectedItem().equals("Bangladesh")) {
					op=Bangladesh;
					dis="BDT "; }
				if(txtEntCountry.getSelectedItem().equals("Sri Lanka")) {
					op=SriLanka;
					dis="LKR ";}
				if(txtEntCurr.getText().length()==0)
					dis=dis+String.format("%.3f", (Double.parseDouble(txtTotal.getText())/op));
				else
					dis=dis+String.format("%.3f", (Double.parseDouble(txtEntCurr.getText())/op));
				txtCurrOp.setText(dis);
			}
		});
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu_3 = new JMenu("Total");
		mnNewMenu_3.setFont(new Font("Segoe UI", Font.BOLD, 20));
		menuBar.add(mnNewMenu_3);
		
		JMenu mnNewMenu_4 = new JMenu("Reset");
		mnNewMenu_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFRice.setText(null);
				txtBurg.setText(null);
				txtChow.setText(null);
				txtDrin.setText(null);
				txtTotalCost.setText(null);
				txtTotalDrink.setText(null);
				txtCdelivery.setText(null);
				txtCRoom.setText(null);
				txtTax.setText(null);
				txtSubTotal.setText(null);
				txtTotal.setText(null);
				btnChosDrin.setSelectedIndex(0);
				btnChosRoom.setSelectedIndex(0);
				receiptArea.setText(null);
				txtEntCurr.setText(null);
				txtEntCountry.setSelectedIndex(0);
				txtCurrOp.setText(null);
			}
		});
		mnNewMenu_4.setFont(new Font("Segoe UI", Font.BOLD, 20));
		menuBar.add(mnNewMenu_4);
		
		JMenu mnNewMenu_5 = new JMenu("Receipt");
		mnNewMenu_5.setFont(new Font("Segoe UI", Font.BOLD, 20));
		menuBar.add(mnNewMenu_5);
		
		JMenu mnNewMenu_6 = new JMenu("Exit");
		mnNewMenu_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu_6.setFont(new Font("Segoe UI", Font.BOLD, 20));
		menuBar.add(mnNewMenu_6);
		
		JButton btnConvert = new JButton("Convert");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dis="";
				double op=0;				
				if(txtEntCountry.getSelectedItem().equals("USA")) {
					op=USA;
					dis="USD ";}
				if(txtEntCountry.getSelectedItem().equals("Nepal")) {
					op=Nepal;
					dis="NPR ";}
				if(txtEntCountry.getSelectedItem().equals("Bangladesh")) {
					op=Bangladesh;
					dis="BDT "; }
				if(txtEntCountry.getSelectedItem().equals("Sri Lanka")) {
					op=SriLanka;
					dis="LKR ";}
				if(txtEntCurr.getText().length()==0)
					dis=dis+String.format("%.3f", (Double.parseDouble(txtTotal.getText())/op));
				else
					dis=dis+String.format("%.3f", (Double.parseDouble(txtEntCurr.getText())/op));
				txtCurrOp.setText(dis);
			}
		});
		btnConvert.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnConvert.setBounds(531, 231, 129, 30);
		panel_1.add(btnConvert);

		JButton btnReset1 = new JButton("Reset");
		btnReset1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtFRice.setText(null);
				txtBurg.setText(null);
				txtChow.setText(null);
				txtDrin.setText(null);
				txtTotalCost.setText(null);
				txtTotalDrink.setText(null);
				txtCdelivery.setText(null);
				txtCRoom.setText(null);
				txtTax.setText(null);
				txtSubTotal.setText(null);
				txtTotal.setText(null);
				btnChosDrin.setSelectedIndex(0);
				btnChosRoom.setSelectedIndex(0);
				receiptArea.setText(null);
				//btnDelivery;;
			}
		});
		btnReset1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnReset1.setBounds(361, 231, 129, 30);
		panel_1.add(btnReset1);
		
		lblclock = new JLabel("Clock");
		lblclock.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblclock.setBounds(0, 44, 782, 121);
		label_2.add(lblclock);
	}
}
