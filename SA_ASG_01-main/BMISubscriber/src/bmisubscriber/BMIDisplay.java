package bmisubscriber;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import bmipublisher.BMIRange;
import bmipublisher.calculateBMI;


@SuppressWarnings("serial")
public class BMIDisplay extends JFrame{
	
	private JPanel panel;
	private JLabel label;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				BMIDisplay display = new BMIDisplay();
				display.setVisible(true);
			}
		});
	}

	public BMIDisplay() throws HeadlessException {
		
		setResizable(false);
		setTitle("BMI Calculator");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(180, 150, 650, 500);
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setBackground(Color.lightGray);
		panel.setLayout(null);
		panel.setVisible(true);
		
		label = new JLabel("BMI Calculator");
		label.setFont(new Font("Algerian", Font.BOLD, 30));
		label.setBounds(180, 40, 400, 50);
		label.setForeground(Color.darkGray);
		panel.add(label);
		
		JLabel inH = new JLabel("Enter Your Height (cm) :");
		inH.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		inH.setBounds(90, 110, 400, 50);
		panel.add(inH);
		
		JTextField height = new JTextField();
		height.setHorizontalAlignment(SwingConstants.CENTER);
		height.setBackground(Color.white);
		height.setBounds(270, 114, 200, 40);

		panel.add(height);
		
		JLabel inW = new JLabel("Enter Your Weight (kg):");
		inW.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		inW.setBounds(90, 180, 400, 50);
		panel.add(inW);
		
		JTextField weight = new JTextField();
		weight.setHorizontalAlignment(SwingConstants.CENTER);
		weight.setBackground(Color.white);
		weight.setBounds(270, 184, 200, 40);
		panel.add(weight);
		
		JButton cal = new JButton("Calculate");
		cal.setFont(new Font("Arial Nova", Font.PLAIN, 20));
		cal.setBackground(Color.white);
		cal.setBorder(new LineBorder(Color.blue));
		cal.setBounds(120, 260, 150, 40);
		panel.add(cal);
		
		JButton clear = new JButton("Clear");
		clear.setFont(new Font("Arial Nova", Font.PLAIN, 20));
		clear.setBackground(Color.white);
		clear.setBorder(new LineBorder(Color.red));
		clear.setBounds(440, 260, 150, 40);
		panel.add(clear);
		
		JLabel out = new JLabel("BMI Value :");
		out.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		out.setBounds(94, 330, 400, 50);
		panel.add(out);
		
		JTextField bmi = new JTextField();
		bmi.setHorizontalAlignment(SwingConstants.CENTER);
		bmi.setBackground(Color.white);
		bmi.setBounds(270, 334, 200, 40);
		bmi.setEditable(isDisplayable());
		panel.add(bmi);
		
		JLabel ch = new JLabel();
		ch.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		ch.setBounds(90, 380, 400, 50);
		panel.add(ch);
		
		JLabel rtype = new JLabel();
		rtype.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		rtype.setBounds(250, 410, 400, 50);
		rtype.setForeground(Color.red);
		panel.add(rtype);
		
		cal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String H = height.getText();
				String W = weight.getText();
				
				if(H.isEmpty() || W.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Input Field is Empty", "Empty Field Alert", JOptionPane.OK_OPTION);
					
				}else {
					try {
						double valH = Double.parseDouble(H);
						double valW = Double.parseDouble(W);
						BMIRange range = new calculateBMI();
						String output =  String.valueOf(range.CalBMI(valH, valW));
						bmi.setText(output);
						
						String cat = range.checkCatogary(range.CalBMI(valH, valW));
						String typeR = range.checkNormalWeight(valH);
						
						ch.setText("You are " + cat);
						rtype.setText("Weight Should be " + typeR);
						
						
					} catch (NumberFormatException e2){
						e2.printStackTrace();
						JOptionPane.showMessageDialog(null, "Please Enter Numbers", "Empty Field Alert", JOptionPane.OK_OPTION);
						
					}
				}
				
			}
		});
		
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				height.setText("");
				weight.setText("");
				bmi.setText("");
				ch.setText("");
			}
		});
	}
	
	

}
