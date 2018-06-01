package management;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class WorkDetails {
	
		JFrame frame;
		private JPanel panel;
		private JLabel l1;
		private JButton b1,b2,b3,b4,b5;
		
		WorkDetails()
		{
			setcomponents();
		}
	    public void setcomponents()
	    {
	    	frame=new JFrame("BRICKKILN PLUS");
	    	frame.setBounds(100,100,500, 350);
			Image icon=Toolkit.getDefaultToolkit().getImage("money.png");
			frame.setIconImage(icon);
			frame.setLayout(null);
			frame.getContentPane().setBackground(Color.black);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			panel=new JPanel();
			panel.setBounds(10,10,465,290);
			frame.add(panel); 
			panel.setLayout(null);
			
	        l1=new JLabel("Work Section");
	        l1.setBounds(150,20,300,40);
	        l1.setFont(new Font("Georgia",Font.BOLD,26));
	    	panel.add(l1);
	    	
	    	b1=new JButton("Employees Details");
	    	b1.setFont(new Font("Georgia",Font.BOLD,14));
	    	b1.setBackground(Color.GRAY);
	    	b1.setBounds(100,80,250,30);
	    	panel.add(b1);
	    	b1.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e)
	    		{
	    			EmployeesDetails.main(new String[] {});
	    			frame.dispose();
	    		}
	    	});
	    	
	    	b2=new JButton("Sales Details");
	    	b2.setFont(new Font("Georgia",Font.BOLD,14));
	    	b2.setBackground(Color.GRAY);
	    	b2.setBounds(100,120,250,30);
	    	panel.add(b2);
	    	b2.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e)
	    		{
	    			SalesDetails.main(new String[] {});
	    			frame.dispose();
	    		}
	    	});
	    	
	    	b3=new JButton("Expenditure Details");
	    	b3.setFont(new Font("Georgia",Font.BOLD,14));
	    	b3.setBackground(Color.GRAY);
	    	b3.setBounds(100,160,250,30);
	    	panel.add(b3);
	    	b3.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e)
	    		{
	    			ExpenditureDetails.main(new String[] {});
	    			frame.dispose();
	    		}
	    	});
	    	
	    	b4=new JButton("Production Details");
	    	b4.setFont(new Font("Georgia",Font.BOLD,14));
	    	b4.setBackground(Color.GRAY);
	    	b4.setBounds(100,200,250,30);
	    	panel.add(b4);
	    	b4.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e)
	    		{
	    			ProductionDetails.main(new String[] {});
	    			frame.dispose();
	    		}
	    	});
	    	
	    	b5=new JButton("Back");
	    	b5.setFont(new Font("Georgia",Font.BOLD,14));
	    	b5.setBackground(Color.GRAY);
	    	b5.setBounds(300,240,80,30);
	    	panel.add(b5);
	    	b5.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e)
	    		{
	    			if(OwnerLogin.pass==1) 
	    				OwnerSection.main(new String[]{});		
	    			else 
	    				ManagerSection.main(new String[] {});
	    			frame.dispose();
	    		}
	    	});
	    	
	    }
	    
		public static void main(String[] args) {
			WorkDetails ol=new WorkDetails();
			ol.frame.setVisible(true);

		}

}
