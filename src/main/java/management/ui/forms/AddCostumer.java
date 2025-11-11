package management.ui.forms;
import management.database.DatabaseConnector;
import management.ui.sections.SalesDetails;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.*;

public class AddCostumer {

		JFrame frame;
		private JPanel panel;
		private JTextField t1,t2;
		private JLabel l1,l2,l3;
		private JButton b1,b2;
		
		AddCostumer()
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
			
	        l1=new JLabel("Add Customer Section");
	        l1.setBounds(80,20,400,40);
	        l1.setFont(new Font("Georgia",Font.BOLD,26));
	    	panel.add(l1);
	    	
	    	l2=new JLabel("Name :");
	        l2.setBounds(50,80,100,20);
	        l2.setFont(new Font("Georgia",Font.BOLD,14));
	    	panel.add(l2);
	    	
	    	l3=new JLabel("Contact No :");
	        l3.setBounds(50,120,120,20);
	        l3.setFont(new Font("Georgia",Font.BOLD,14));
	    	panel.add(l3);
	    	
	    	t1=new JTextField();
	        t1.setBounds(200,80,150,20);
	        t1.setFont(new Font("Georgia",Font.BOLD,14));
	    	panel.add(t1);
	    	
	    	t2=new JTextField();
	        t2.setBounds(200,120,150,20);
	        t2.setFont(new Font("Georgia",Font.BOLD,14));
	    	panel.add(t2);
	    	
	    	   	
	    	b1=new JButton("Add");
	    	b1.setFont(new Font("Georgia",Font.BOLD,14));
	    	b1.setBackground(Color.GRAY);
	    	b1.setBounds(180,160,100,30);
	    	
	    	panel.add(b1);
	    	b1.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e)
	    		{
	    			String name=t1.getText();
	    			int contact=Integer.parseInt(t2.getText());
	    			int i=save(name, contact);
	    			if(i>0){
	    				JOptionPane.showMessageDialog(null,"Customer added successfully!" );
	    				SalesDetails.main(new String[]{});
	    				frame.dispose();
	    				
	    			}
	    			else
	    			{
	    				JOptionPane.showMessageDialog(null,"Sorry, unable to save!");
	    				t1.setText("");
	    				t2.setText("");
	    			}	
	    		}

				private int save(String name, int contact) {
					int status=0;
					try {
					Connection con=DatabaseConnector.getConnection();
					PreparedStatement ps=con.prepareStatement("insert into costumer(name,contactno) values (?,?)");
					ps.setString(1, name);
					ps.setInt(2, contact);
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
	    	b2.setBounds(320,200,80,30);
	    	
	    	panel.add(b2);
	    	b2.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e)
	    		{
	    				SalesDetails.main(new String[]{});
	    				frame.dispose();
	    		}		
	    	});
	    }
		public static void main(String[] args) {
			AddCostumer ol=new AddCostumer();
			ol.frame.setVisible(true);
			ol.frame.setResizable(true);

		}
}
