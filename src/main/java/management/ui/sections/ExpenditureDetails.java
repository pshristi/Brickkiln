package management.ui.sections;
	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;

public class ExpenditureDetails {

			JFrame frame;
			private JPanel panel;
			private JLabel l1;
			private JButton b1,b2,b5;
			
			ExpenditureDetails()
			{
				setcomponents();
			}
		    public void setcomponents()
		    {
		    	frame=new JFrame("BRICKKILN PLUS");
		    	frame.setBounds(100,100,500, 300);
				Image icon=Toolkit.getDefaultToolkit().getImage("money.png");
				frame.setIconImage(icon);
				frame.setLayout(null);
				frame.getContentPane().setBackground(Color.black);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				panel=new JPanel();
				panel.setBounds(10,10,465,240);
				frame.add(panel); 
				panel.setLayout(null);
				
		        l1=new JLabel("Expenditure Section");
		        l1.setBounds(80,20,300,40);
		        l1.setFont(new Font("Georgia",Font.BOLD,26));
		    	panel.add(l1);
		    	
		    	b1=new JButton("Add Expenditure Record");
		    	b1.setFont(new Font("Georgia",Font.BOLD,14));
		    	b1.setBackground(Color.GRAY);
		    	b1.setBounds(100,80,250,30);
		    	panel.add(b1);
		    	b1.addActionListener(new ActionListener() {
		    		public void actionPerformed(ActionEvent e)
		    		{
		    			AddExpenditure.main(new String[] {});
		    			frame.dispose();
		    		}
		    	});
		    	
		    	b2=new JButton("View Expenditure Records");
		    	b2.setFont(new Font("Georgia",Font.BOLD,14));
		    	b2.setBackground(Color.GRAY);
		    	b2.setBounds(100,120,250,30);
		    	panel.add(b2);
		    	b2.addActionListener(new ActionListener() {
		    		public void actionPerformed(ActionEvent e)
		    		{
		    			ViewExpenditure.main(new String[] {});
		    			frame.dispose();
		    		}
		    	});
		    	
		    	b5=new JButton("Back");
		    	b5.setFont(new Font("Georgia",Font.BOLD,14));
		    	b5.setBackground(Color.GRAY);
		    	b5.setBounds(320,160,80,30);
		    	panel.add(b5);
		    	b5.addActionListener(new ActionListener() {
		    		public void actionPerformed(ActionEvent e)
		    		{
		    		    WorkDetails.main(new String[] {});
		    			frame.dispose();
		    		}
		    	});
		    	
		    }
		    
			public static void main(String[] args) {
				ExpenditureDetails ol=new ExpenditureDetails();
				ol.frame.setVisible(true);

			}
}
