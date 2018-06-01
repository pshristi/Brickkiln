package management;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class OwnerSection {

		JFrame frame;
		private JPanel panel;
		private JLabel l1;
		private JButton b1,b2,b3;
		
		OwnerSection()
		{
			setcomponents();
		}
	    public void setcomponents()
	    {
	    	frame=new JFrame("BRICKKILN PLUS ");
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
			
	        l1=new JLabel("Owner Section");
	        l1.setBounds(120,20,300,40);
	        l1.setFont(new Font("Georgia",Font.BOLD,26));
	    	panel.add(l1);
	    	
	    	b1=new JButton("Work Details");
	    	b1.setFont(new Font("Georgia",Font.BOLD,16));
	    	b1.setBackground(Color.GRAY);
	    	b1.setBounds(100,80,250,30);
	    	panel.add(b1);
	    	b1.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e)
	    		{
	    			WorkDetails.main(new String[] {});
	    			frame.dispose();
	    		}
	    	});
	    	
	    	b2=new JButton("Managers' Details");
	    	b2.setFont(new Font("Georgia",Font.BOLD,16));
	    	b2.setBackground(Color.GRAY);
	    	b2.setBounds(100,120,250,30);
	    	panel.add(b2);
	    	b2.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e)
	    		{
	    			ManagerDetails.main(new String[] {});
	    			frame.dispose();
	    		}
	    	});
	    	
	    	b3=new JButton("Log out");
	    	b3.setFont(new Font("Georgia",Font.BOLD,16));
	    	b3.setBackground(Color.GRAY);
	    	b3.setBounds(100,160,250,30);
	    	panel.add(b3);
	    	b3.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e)
	    		{
	    			Factory.main(new String[] {});
	    			frame.dispose();
	    		}
	    	});
	    	
	    }
	    
		public static void main(String[] args) {
			OwnerSection ol=new OwnerSection();
			ol.frame.setVisible(true);

		}

}
