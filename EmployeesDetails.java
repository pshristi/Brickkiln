package management;
	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;

public class EmployeesDetails {

			JFrame frame;
			private JPanel panel;
			private JLabel l1;
			private JButton b1,b6,b7,b8,b9,b10;
			
			EmployeesDetails()
			{
				setcomponents();
			}
		    public void setcomponents()
		    {
		    	frame=new JFrame("BRICKKILN PLUS");
		    	frame.setBounds(100,100,500, 400);
				Image icon=Toolkit.getDefaultToolkit().getImage("money.png");
				frame.setIconImage(icon);
				frame.setLayout(null);
				frame.getContentPane().setBackground(Color.black);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				panel=new JPanel();
				panel.setBounds(10,10,465,340);
				frame.add(panel); 
				panel.setLayout(null);
				
		        l1=new JLabel("Employees Section");
		        l1.setBounds(100,20,300,40);
		        l1.setFont(new Font("Georgia",Font.BOLD,26));
		    	panel.add(l1);
		    	
		    	b1=new JButton("Department Details");
		    	b1.setFont(new Font("Georgia",Font.BOLD,16));
		    	b1.setBackground(Color.GRAY);
		    	b1.setBounds(120,80,220,30);
		    	panel.add(b1);
		    	b1.addActionListener(new ActionListener() {
		    		public void actionPerformed(ActionEvent e)
		    		{
		    			Department.main(new String[] {});
		    			frame.dispose();
		    		}
		    	});
		    	
		    	
		    	b6=new JButton("Add Employee");
		    	b6.setFont(new Font("Georgia",Font.BOLD,16));
		    	b6.setBackground(Color.GRAY);
		    	b6.setBounds(120,120,220,30);
		    	panel.add(b6);
		    	b6.addActionListener(new ActionListener() {
		    		public void actionPerformed(ActionEvent e)
		    		{
		    			AddEmployee.main(new String[] {});
		    			frame.dispose();
		    		}
		    	});
		    	
		    	b7=new JButton("Add Employee record");
		    	b7.setFont(new Font("Georgia",Font.BOLD,16));
		    	b7.setBackground(Color.GRAY);
		    	b7.setBounds(120,160,220,30);
		    	panel.add(b7);
		    	b7.addActionListener(new ActionListener() {
		    		public void actionPerformed(ActionEvent e)
		    		{
		    			AddEmployeeRecord.main(new String[] {});
		    			frame.dispose();
		    		}
		    	});
		    	
		    	b9=new JButton("View Employee record");
		    	b9.setFont(new Font("Georgia",Font.BOLD,16));
		    	b9.setBackground(Color.GRAY);
		    	b9.setBounds(120,200,220,30);
		    	panel.add(b9);
		    	b9.addActionListener(new ActionListener() {
		    		public void actionPerformed(ActionEvent e)
		    		{
		    			ViewEmployeeRecord.main(new String[] {});
		    			frame.dispose();
		    		}
		    	});
		    	
		    	b8=new JButton("Delete Employee");
		    	b8.setFont(new Font("Georgia",Font.BOLD,16));
		    	b8.setBackground(Color.GRAY);
		    	b8.setBounds(120,240,220,30);
		    	panel.add(b8);
		    	b8.addActionListener(new ActionListener() {
		    		public void actionPerformed(ActionEvent e)
		    		{
		    			DeleteEmployee.main(new String[] {});
		    			frame.dispose();
		    		}
		    	});
		    	
		    	b10=new JButton("Back");
		    	b10.setFont(new Font("Georgia",Font.BOLD,14));
		    	b10.setBackground(Color.GRAY);
		    	b10.setBounds(300,280,80,30);
		    	panel.add(b10);
		    	b10.addActionListener(new ActionListener() {
		    		public void actionPerformed(ActionEvent e)
		    		{
		    				WorkDetails.main(new String[]{});
		    				frame.dispose();
		    		}		
		    	});
		    	
		    }
		    
			public static void main(String[] args) {
				EmployeesDetails ol=new EmployeesDetails();
				ol.frame.setVisible(true);

			}
}
