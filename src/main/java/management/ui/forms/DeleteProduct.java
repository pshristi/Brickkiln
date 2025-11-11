package management.ui.forms;
import management.database.DatabaseConnector;
import management.ui.sections.ProductionDetails;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class DeleteProduct {
			JFrame frame;
			private JPanel panel;
			private JTextField t1;
			private JLabel l1,l2;
			private JButton b1,b2;
			
			DeleteProduct()
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
				
		        l1=new JLabel("Delete Product Section");
		        l1.setBounds(80,20,400,40);
		        l1.setFont(new Font("Georgia",Font.BOLD,26));
		    	panel.add(l1);
		    	
		    	l2=new JLabel("Product Type :");
		        l2.setBounds(50,80,120,20);
		        l2.setFont(new Font("Georgia",Font.BOLD,14));
		    	panel.add(l2);
		    	
		    	t1=new JTextField();
		        t1.setBounds(200,80,150,20);
		        t1.setFont(new Font("Georgia",Font.BOLD,14));
		    	panel.add(t1);
		    	
		    	b1=new JButton("Delete");
		    	b1.setFont(new Font("Georgia",Font.BOLD,14));
		    	b1.setBackground(Color.GRAY);
		    	b1.setBounds(180,120,100,30);
		    	
		    	panel.add(b1);
		    	b1.addActionListener(new ActionListener() {
		    		public void actionPerformed(ActionEvent e)
		    		{
		    			String product=t1.getText();
		    			int i=delete(product);
		    			if(i>0){
		    				JOptionPane.showMessageDialog(null,"Product deleted successfully!" );
		    				ProductionDetails.main(new String[]{});
		    				frame.dispose();
		    				
		    			}
		    			else
		    			{
		    				JOptionPane.showMessageDialog(null,"Sorry, unable to save!");
		    				t1.setText("");
		    			}	
		    		}

					private int delete(String product) {
						int status=0;
						try{
							Connection con=DatabaseConnector.getConnection();
							PreparedStatement ps=con.prepareStatement("delete from production where product=?");
							ps.setString(1,product);
							status=ps.executeUpdate();
							ps=con.prepareStatement("delete from finalproduction where product=?");
							ps.setString(1,product);
							status=ps.executeUpdate();
							con.close();
						}catch(Exception e){System.out.println(e);}
						return status;
					}
		    	});
		    	
		    	b2=new JButton("Back");
		    	b2.setFont(new Font("Georgia",Font.BOLD,14));
		    	b2.setBackground(Color.GRAY);
		    	b2.setBounds(320,160,80,30);
		    	
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
				DeleteProduct ol=new DeleteProduct();
				ol.frame.setVisible(true);

			}	
}