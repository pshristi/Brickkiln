package management.ui.forms;
import management.dao.ManagerList;
import management.ui.sections.ManagerDetails;
	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;

public class AddManager {

		JFrame frame;
		private JPanel panel;
		private JTextField t1,t2,t3,t4,t5;
		private JPasswordField p;
		private JLabel l1,l2,l3,l4,l5,l6,l7;
		private JButton b1,b2;
		
		AddManager()
		{
			setcomponents();
		}
	    public void setcomponents()
	    {
	    	frame=new JFrame("BRICKKILN PLUS ");
	    	frame.setBounds(100,100,500, 500);
			Image icon=Toolkit.getDefaultToolkit().getImage("money.png");
			frame.setIconImage(icon);
			frame.setLayout(null);
			frame.getContentPane().setBackground(Color.black);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			panel=new JPanel();
			panel.setBounds(10,10,465,440);
			frame.add(panel); 
			panel.setLayout(null);
			
	        l1=new JLabel("Add Manager Section");
	        l1.setBounds(80,20,400,40);
	        l1.setFont(new Font("Georgia",Font.BOLD,26));
	    	panel.add(l1);
	    	
	    	l2=new JLabel("Name :");
	        l2.setBounds(50,80,100,20);
	        l2.setFont(new Font("Georgia",Font.BOLD,14));
	    	panel.add(l2);
	    	
	    	l3=new JLabel("Password :");
	        l3.setBounds(50,120,120,20);
	        l3.setFont(new Font("Georgia",Font.BOLD,14));
	    	panel.add(l3);
	    	
	    	l4=new JLabel("Email :");
	        l4.setBounds(50,160,100,20);
	        l4.setFont(new Font("Georgia",Font.BOLD,14));
	    	panel.add(l4);
	    	
	    	l5=new JLabel("Address :");
	        l5.setBounds(50,200,100,20);
	        l5.setFont(new Font("Georgia",Font.BOLD,14));
	    	panel.add(l5);
	    	
	    	l6=new JLabel("City :");
	        l6.setBounds(50,240,100,20);
	        l6.setFont(new Font("Georgia",Font.BOLD,14));
	    	panel.add(l6);
	    	
	    	l7=new JLabel("Contact No. :");
	        l7.setBounds(50,280,100,20);
	        l7.setFont(new Font("Georgia",Font.BOLD,14));
	    	panel.add(l7);
	    	
	    	t1=new JTextField();
	        t1.setBounds(200,80,150,20);
	        t1.setFont(new Font("Georgia",Font.BOLD,14));
	    	panel.add(t1);
	    	
	    	t2=new JTextField();
	        t2.setBounds(200,160,150,20);
	        t2.setFont(new Font("Georgia",Font.BOLD,14));
	    	panel.add(t2);
	    	
	    	t3=new JTextField();
	        t3.setBounds(200,200,150,20);
	        t3.setFont(new Font("Georgia",Font.BOLD,14));
	    	panel.add(t3);
	    	
	    	t4=new JTextField();
	        t4.setBounds(200,240,150,20);
	        t4.setFont(new Font("Georgia",Font.BOLD,14));
	    	panel.add(t4);
	    	
	    	t5=new JTextField();
	        t5.setBounds(200,280,150,20);
	        t5.setFont(new Font("Georgia",Font.BOLD,14));
	    	panel.add(t5);
	    	
	    	p=new JPasswordField();
	        p.setBounds(200,120,150,20);
	    	panel.add(p);
	    	
	    	b1=new JButton("Add");
	    	b1.setFont(new Font("Georgia",Font.BOLD,14));
	    	b1.setBackground(Color.GRAY);
	    	b1.setBounds(180,320,100,30);
	    	
	    	panel.add(b1);
	    	b1.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e)
	    		{
	    			String name=t1.getText();
	    			String password=String.valueOf(p.getPassword());
	    			String email=t2.getText();
	    			String address=t3.getText();
	    			String city=t4.getText();
	    			String contact=t5.getText();
	    			int i=ManagerList.save(name, password, email, address, city, contact);
	    			if(i>0){
	    				JOptionPane.showMessageDialog(null,"Manager added successfully!" );
	    				ManagerDetails.main(new String[]{});
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
	    				p.setText("");
	    			}	
	    		}
	    	});
	    	
	    	b2=new JButton("Back");
	    	b2.setFont(new Font("Georgia",Font.BOLD,14));
	    	b2.setBackground(Color.GRAY);
	    	b2.setBounds(320,360,80,30);
	    	
	    	panel.add(b2);
	    	b2.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e)
	    		{
	    				ManagerDetails.main(new String[]{});
	    				frame.dispose();
	    		}		
	    	});
	    }
		public static void main(String[] args) {
			AddManager ol=new AddManager();
			ol.frame.setVisible(true);

		}
}
