package management;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Factory {
		JFrame frame;
		private JPanel panel;
		private JLabel l;
		private JButton b1,b2;
		
		Factory()
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
			
	        l=new JLabel("Brickkiln Plus");
	        l.setBounds(100,20,400,40);
	        l.setFont(new Font("Georgia",Font.BOLD,26));
	    	panel.add(l);
	    	
	    	b1=new JButton("Owner Login");
	    	b2=new JButton("Manager Login");
	    	b1.setFont(new Font("Georgia",Font.BOLD,18));
	    	b1.setBackground(Color.GRAY);
	    	b2.setBackground(Color.GRAY);
	    	b2.setFont(new Font("Georgia",Font.BOLD,18));
	    	b1.setBounds(130,80,200,50);
	    	b2.setBounds(130,140,200,50);
	    	
	    	panel.add(b1);
	    	panel.add(b2);
	    	b1.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e)
	    		{
	    			OwnerLogin.main(new String[] {});
	    			frame.dispose();
	    		}
	    	});
	    	b2.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e)
	    		{
	    			ManagerLogin.main(new String[] {});
	    		    frame.dispose();
	    		}
	    	});
	    }
		public static void main(String[] args) {
			Factory min=new Factory();
			min.frame.setVisible(true);

		}
}
