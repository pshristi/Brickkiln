package management;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.sql.*;

	import javax.swing.*;


public class ViewExpenditure {
	
			JFrame frame;
			private JPanel panel;
			JButton b;
			
			ViewExpenditure()
			{
				setcomponents();
			}
		    public void setcomponents()
		    {
		    	frame=new JFrame("BRICKKILN PLUS");
		    	frame.setBounds(100,100,700, 500);
				Image icon=Toolkit.getDefaultToolkit().getImage("money.png");
				frame.setIconImage(icon);
				frame.setLayout(null);
				frame.getContentPane().setBackground(Color.black);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				panel=new JPanel();
				panel.setBounds(10,10,665,440);
				frame.add(panel); 
				panel.setLayout(null);
				
				JLabel l1=new JLabel("Expenditure Record");
		        l1.setBounds(230,20,400,40);
		        l1.setFont(new Font("Georgia",Font.BOLD,26));
		    	panel.add(l1);
		    	
		    	String data[][]=null;
		    	String column[]=null;
		    	try{
					Connection con=DatabaseConnector.getConnection();
					PreparedStatement ps=con.prepareStatement("select * from expenditure",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
					ResultSet rs=ps.executeQuery();
					
					ResultSetMetaData rsmd=rs.getMetaData();
					int cols=rsmd.getColumnCount();
					column=new String[cols];
					for(int i=1;i<=cols;i++){
						column[i-1]=rsmd.getColumnName(i);
					}
					
					rs.last();
					int rows=rs.getRow();
					rs.beforeFirst();

					data=new String[rows][cols];
					int count=0;
					while(rs.next()){
						for(int i=1;i<=cols;i++){
							data[count][i-1]=rs.getString(i);
						}
						count++;
					}
					con.close();
				}catch(Exception e){System.out.println(e);}
				
				JTable table = new JTable(data,column);
				JScrollPane sp=new JScrollPane(table);
				panel.add(sp);
				sp.setBounds(40, 100, 600, 300);
				
				b=new JButton("Back");
		    	b.setFont(new Font("Georgia",Font.BOLD,14));
		    	b.setBackground(Color.GRAY);
		    	b.setBounds(570,40,80,30);
		    	panel.add(b);
		    	b.addActionListener(new ActionListener() {
		    		public void actionPerformed(ActionEvent e)
		    		{
		    				ExpenditureDetails.main(new String[]{});
		    				frame.dispose();
		    		}		
		    	});
		    			
		    }
			public static void main(String[] args) {
				ViewExpenditure ol=new ViewExpenditure();
				ol.frame.setVisible(true);

			}
}
