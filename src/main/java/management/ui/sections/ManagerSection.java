package management.ui.sections;

import management.ui.login.Factory;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ManagerSection {

	JFrame frame;
	private JPanel panel;
	private JLabel l1;
	private JButton b1,b2;
	
	ManagerSection()
	{
		setcomponents();
	}
    public void setcomponents()
    {
    	frame=new JFrame("BRICKKILN PLUS");
    	frame.setBounds(100,100,500, 250);
		Image icon=Toolkit.getDefaultToolkit().getImage("money.png");
		frame.setIconImage(icon);
		frame.setLayout(null);
		frame.getContentPane().setBackground(Color.black);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel=new JPanel();
		panel.setBounds(10,10,465,190);
		frame.add(panel); 
		panel.setLayout(null);
		
        l1=new JLabel("Manager Section");
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
    	
    	b2=new JButton("LogOut");
    	b2.setFont(new Font("Georgia",Font.BOLD,16));
    	b2.setBackground(Color.GRAY);
    	b2.setBounds(100,120,250,30);
    	panel.add(b2);
    	b2.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e)
    		{
    			Factory.main(new String[] {});
    			frame.dispose();
    		}
    	});
    }
    
	public static void main(String[] args) {
		ManagerSection ol=new ManagerSection();
		ol.frame.setVisible(true);

	}

}
