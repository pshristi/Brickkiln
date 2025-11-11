package management.ui.forms;
import management.database.DatabaseConnector;
import management.ui.sections.ProductionDetails;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
	

public class AddProduction {
	
		JFrame frame;
		private JPanel panel;
		private JTextField t1,t2,t3;
		private JLabel l1,l2,l3,l4;
		private JButton b1,b2;
		
		AddProduction()
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
			
	        l1=new JLabel("Add Production Record");
	        l1.setBounds(60,20,400,40);
	        l1.setFont(new Font("Georgia",Font.BOLD,26));
	    	panel.add(l1);
	    	
	    	l2=new JLabel("Product Type :");
	        l2.setBounds(80,80,120,20);
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
	    	
	    	b1=new JButton("Add");
	    	b1.setFont(new Font("Georgia",Font.BOLD,14));
	    	b1.setBackground(Color.GRAY);
	    	b1.setBounds(180,200,100,30);
	    	
	    	panel.add(b1);
	    	b1.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e)
	    		{
	    			String product=t1.getText();
	    			String dob=t2.getText();
	    			int quantity=Integer.parseInt(t3.getText());
	    			int i=save(product, dob, quantity);
	    			if(i>0){
	    				JOptionPane.showMessageDialog(null,"Production added successfully!" );
	    				ProductionDetails.main(new String[]{});
	    				frame.dispose();
	    				
	    			}
	    			else
	    			{
	    				JOptionPane.showMessageDialog(null,"Sorry, unable to save!");
	    				t1.setText("");
	    				t2.setText("");
	    				t3.setText("");
	    			}	
	    		}

				private int save(String product, String dob, int quantity) {
					int status=0;
					try {
					Connection con=DatabaseConnector.getConnection();
					PreparedStatement ps=con.prepareStatement("insert into production(product,dob,quantity) values (?,?,?)");
					ps.setString(1, product);
					ps.setString(2, dob);
					ps.setInt(3, quantity);
					status=ps.executeUpdate();
					PreparedStatement p1=con.prepareStatement("select quantity from finalproduction where product=?");
					p1.setString(1, product);
					ResultSet r=p1.executeQuery();
					r.first();
					int q=r.getInt(1)+quantity;
					PreparedStatement p2=con.prepareStatement("update finalproduction set quantity=? where product=?");
					p2.setInt(1,q);
					p2.setString(2, product);
					status=p2.executeUpdate();
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
	    	b2.setBounds(320,240,80,30);
	    	
	    	panel.add(b2);
	    	b2.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e)
	    		{
	    				ProductionDetails.main(new String[]{});
	    				frame.dispose();
	    		}		
	    	});
	    }
		public static void main(String[] args) {
			AddProduction ol=new AddProduction();
			ol.frame.setVisible(true);

		}
}
