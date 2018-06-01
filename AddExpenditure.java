package management;
	import java.awt.*;
	import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.*;

public class AddExpenditure {
	
		JFrame frame;
		private JPanel panel;
		private JTextField t1,t2,t3,t4,t5;
		private JLabel l1,l2,l3,l4,l5,l6;
		private JButton b1,b2;
		
		AddExpenditure()
		{
			setcomponents();
		}
	    public void setcomponents()
	    {
	    	frame=new JFrame("BRICKKILN PLUS ");
	    	frame.setBounds(100,100,500, 450);
			Image icon=Toolkit.getDefaultToolkit().getImage("money.png");
			frame.setIconImage(icon);
			frame.setLayout(null);
			frame.getContentPane().setBackground(Color.black);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			panel=new JPanel();
			panel.setBounds(10,10,465,390);
			frame.add(panel); 
			panel.setLayout(null);
			
	        l1=new JLabel("Add Expenditure");
	        l1.setBounds(100,20,400,40);
	        l1.setFont(new Font("Georgia",Font.BOLD,26));
	    	panel.add(l1);
	    	
	    	l2=new JLabel("Particular :");
	        l2.setBounds(80,80,100,20);
	        l2.setFont(new Font("Georgia",Font.BOLD,14));
	    	panel.add(l2);
	    	
	    	l3=new JLabel("Date :");
	        l3.setBounds(80,120,120,20);
	        l3.setFont(new Font("Georgia",Font.BOLD,14));
	    	panel.add(l3);
	    	
	    	l4=new JLabel("Quantity :");
	        l4.setBounds(80,160,100,20);
	        l4.setFont(new Font("Georgia",Font.BOLD,14));
	    	panel.add(l4);
	    	
	    	l5=new JLabel("Rate :");
	        l5.setBounds(80,200,100,20);
	        l5.setFont(new Font("Georgia",Font.BOLD,14));
	    	panel.add(l5);
	    	
	    	l6=new JLabel("Cost :");
	        l6.setBounds(80,240,100,20);
	        l6.setFont(new Font("Georgia",Font.BOLD,14));
	    	panel.add(l6);
	    	
	    	t1=new JTextField();
	        t1.setBounds(200,80,150,20);
	        t1.setFont(new Font("Georgia",Font.BOLD,14));
	    	panel.add(t1);
	    	
	    	t2=new JTextField();
	        t2.setBounds(200,120,150,20);
	        t2.setFont(new Font("Georgia",Font.BOLD,14));
	    	panel.add(t2);
	    	
	    	t3=new JTextField();
	        t3.setBounds(200,160,150,20);
	        t3.setFont(new Font("Georgia",Font.BOLD,14));
	    	panel.add(t3);
	    	
	    	t4=new JTextField();
	        t4.setBounds(200,200,150,20);
	        t4.setFont(new Font("Georgia",Font.BOLD,14));
	    	panel.add(t4);
	    	
	    	t5=new JTextField();
	        t5.setBounds(200,240,150,20);
	        t5.setFont(new Font("Georgia",Font.BOLD,14));
	    	panel.add(t5);
	    	
	    	b1=new JButton("Add");
	    	b1.setFont(new Font("Georgia",Font.BOLD,14));
	    	b1.setBackground(Color.GRAY);
	    	b1.setBounds(180,280,100,30);
	    	
	    	panel.add(b1);
	    	b1.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e)
	    		{
	    			String particular=t1.getText();
	    			String dob=t2.getText();
	    			String quantity=t3.getText();
	    			int rate=Integer.parseInt(t4.getText());
	    			int cost=Integer.parseInt(t5.getText());
	    			int i=save(particular, dob, quantity, rate, cost);
	    			if(i>0){
	    				JOptionPane.showMessageDialog(null,"Expenditure added successfully!" );
	    				ExpenditureDetails.main(new String[]{});
	    				frame.dispose();
	    				
	    			}
	    			else
	    			{
	    				JOptionPane.showMessageDialog(null,"Sorry, unable to save!");
	    				t1.setText("");
	    				t2.setText("");
	    				t3.setText("");
	    				t4.setText("");
	    				t5.setText("");
	    			}	
	    		}

				private int save(String particular, String dob, String quantity, int rate, int cost) {
					int status=0;
					try {
					Connection con=DatabaseConnector.getConnection();
					PreparedStatement ps=con.prepareStatement("insert into expenditure(particular,dob,quantity,rate,cost) values (?,?,?,?,?)");
					ps.setString(1, particular);
					ps.setString(2, dob);
					ps.setString(3, quantity);
					ps.setInt(4, rate);
					ps.setInt(5, cost);
					status=ps.executeUpdate();
					con.close();
					}catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
					return status;
				}
	    	});
	    	
	    	b2=new JButton("Back");
	    	b2.setFont(new Font("Georgia",Font.BOLD,14));
	    	b2.setBackground(Color.GRAY);
	    	b2.setBounds(320,320,80,30);
	    	
	    	panel.add(b2);
	    	b2.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e)
	    		{
	    				ExpenditureDetails.main(new String[]{});
	    				frame.dispose();
	    		}		
	    	});
	    }
		public static void main(String[] args) {
			AddExpenditure ol=new AddExpenditure();
			ol.frame.setVisible(true);

		}
}
