package management.ui.forms;
import management.database.DatabaseConnector;
	import java.awt.*;
	import java.awt.event.*;
	import java.sql.*;
	import javax.swing.*;

public class AddSalesRecord {
	
			JFrame frame;
			private JPanel panel;
			private JTextField t1,t2,t3,t5,t6;
			private JLabel l1,l2,l3,l4,l6,l7;
			private JButton b1,b2;
			
			AddSalesRecord()
			{
				setcomponents();
			}
		    public void setcomponents()
		    {
		    	frame=new JFrame("BRICKKILN PLUS");
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
				
		        l1=new JLabel("Add Sales Record");
		        l1.setBounds(80,20,400,40);
		        l1.setFont(new Font("Georgia",Font.BOLD,26));
		    	panel.add(l1);
		    	
		    	l2=new JLabel("Enter Customer Id :");
		        l2.setBounds(50,80,200,20);
		        l2.setFont(new Font("Georgia",Font.BOLD,14));
		    	panel.add(l2);
		    	
		    	l3=new JLabel("Date of Work :");
		        l3.setBounds(50,120,120,20);
		        l3.setFont(new Font("Georgia",Font.BOLD,14));
		    	panel.add(l3);
		    	
		    	l4=new JLabel("Debit :");
		        l4.setBounds(50,240,100,20);
		        l4.setFont(new Font("Georgia",Font.BOLD,14));
		    	panel.add(l4);
		    			    	
		    	l6=new JLabel("Product :");
		        l6.setBounds(50,160,100,20);
		        l6.setFont(new Font("Georgia",Font.BOLD,14));
		    	panel.add(l6);
		    	
		    	l7=new JLabel("Quantity :");
		        l7.setBounds(50,200,100,20);
		        l7.setFont(new Font("Georgia",Font.BOLD,14));
		    	panel.add(l7);
		    	
		    	t1=new JTextField();
		        t1.setBounds(200,80,150,20);
		        t1.setFont(new Font("Georgia",Font.BOLD,14));
		    	panel.add(t1);
		    	
		    	t2=new JTextField();
		        t2.setBounds(200,120,150,20);
		        t2.setFont(new Font("Georgia",Font.BOLD,14));
		    	panel.add(t2);
		    	
		    	t3=new JTextField();
		        t3.setBounds(200,240,150,20);
		        t3.setFont(new Font("Georgia",Font.BOLD,14));
		    	panel.add(t3);
		    	
		    	t5=new JTextField();
		        t5.setBounds(200,160,150,20);
		        t5.setFont(new Font("Georgia",Font.BOLD,14));
		    	panel.add(t5);
		    	
		    	t6=new JTextField();
		        t6.setBounds(200,200,150,20);
		        t6.setFont(new Font("Georgia",Font.BOLD,14));
		    	panel.add(t6);
		    	
		    	b1=new JButton("Add");
		    	b1.setFont(new Font("Georgia",Font.BOLD,14));
		    	b1.setBackground(Color.GRAY);
		    	b1.setBounds(180,280,100,30);
		    	
		    	panel.add(b1);
		    	b1.addActionListener(new ActionListener() {
		    		public void actionPerformed(ActionEvent e)
		    		{
		    			int id=Integer.parseInt(t1.getText());
		    			String dow=t2.getText();
		    			int debit=Integer.parseInt(t3.getText());
		    			String product=t5.getText();
		    			int quantity=Integer.parseInt(t6.getText());
		    			int i=save(id, dow, product,quantity,debit);
		    			if(i>0){
		    				JOptionPane.showMessageDialog(null,"Record added successfully!" );
		    				AddCostumerRecord.main(new String[]{});
		    				frame.dispose();
		    				
		    			}
		    			else
		    			{
		    				JOptionPane.showMessageDialog(null,"Sorry, unable to save!");
		    				t1.setText("");
		    				t2.setText("");
		    				t3.setText("");
		    				t5.setText("");
		    				t6.setText("");
		    				
		    			}	
		    		}

					private int save(int id, String dow,String product,int quantity, int debit) {
						int status=0;
						try {
						Connection con=DatabaseConnector.getConnection();
						PreparedStatement ps=con.prepareStatement("select balance from costumer where id=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
						ps.setInt(1, id);
						ResultSet r=ps.executeQuery();
						r.first();
						PreparedStatement p1=con.prepareStatement("insert into costumerdata(id,dow,product,quantity,debit,balance) values (?,?,?,?,?,?)");
						int balance=r.getInt(1)+debit;
						p1.setInt(1, id);
						p1.setString(2, dow);
						p1.setString(3, product);
						p1.setInt(4, quantity);
						p1.setInt(5,debit );
						p1.setInt(6,balance);
						status=p1.executeUpdate();
						PreparedStatement p2=con.prepareStatement("update costumer set balance=? where id=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
						p2.setInt(1, balance);
						p2.setInt(2, id);
						status=p2.executeUpdate();
						ps=con.prepareStatement("select quantity from finalproduction where product=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
						ps.setString(1, product);
						r=ps.executeQuery();
						r.first();
						p2=con.prepareStatement("update finalproduction set quantity=? where product=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
						int q=r.getInt(1)-quantity;
						p2.setInt(1,q );
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
		    	b2.setBounds(320,320,80,30);
		    	
		    	panel.add(b2);
		    	b2.addActionListener(new ActionListener() {
		    		public void actionPerformed(ActionEvent e)
		    		{
		    				AddCostumerRecord.main(new String[]{});
		    				frame.dispose();
		    		}		
		    	});
		    }
			public static void main(String[] args) {
				AddSalesRecord ol=new AddSalesRecord();
				ol.frame.setVisible(true);

			}
}
