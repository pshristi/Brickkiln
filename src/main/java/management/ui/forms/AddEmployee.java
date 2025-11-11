package management.ui.forms;
import management.dao.EmployeeList;
import management.ui.sections.EmployeesDetails;
import management.ui.views.Department;
	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;

public class AddEmployee {

		JFrame frame;
		private JPanel panel;
		private JTextField t1,t2,t3;
		private JLabel l1,l2,l3,l4;
		private JButton b1,b2;
		
		AddEmployee()
		{
			setcomponents();
		}
	    public void setcomponents()
	    {
	    	frame=new JFrame("BRICKKILN PLUS ");
	    	frame.setBounds(100,100,500,350);
			Image icon=Toolkit.getDefaultToolkit().getImage("money.png");
			frame.setIconImage(icon);
			frame.setLayout(null);
			frame.getContentPane().setBackground(Color.black);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			panel=new JPanel();
			panel.setBounds(10,10,465,290);
			frame.add(panel); 
			panel.setLayout(null);
			
	        l1=new JLabel("Add Employee Section");
	        l1.setBounds(80,20,400,40);
	        l1.setFont(new Font("Georgia",Font.BOLD,26));
	    	panel.add(l1);
	    	
	    	l2=new JLabel("Name :");
	        l2.setBounds(50,80,100,20);
	        l2.setFont(new Font("Georgia",Font.BOLD,14));
	    	panel.add(l2);
	    	
	    	l3=new JLabel("Department No :");
	        l3.setBounds(50,120,120,20);
	        l3.setFont(new Font("Georgia",Font.BOLD,14));
	    	panel.add(l3);
	    	
	    	l4=new JLabel("Contact No :");
	        l4.setBounds(50,160,100,20);
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
	    			String name=t1.getText();
	    			int dno=Integer.parseInt(t2.getText());
	    			int contact=Integer.parseInt(t3.getText());
	    			int i=EmployeeList.save(name,dno, contact);
	    			if(i>0){
	    				JOptionPane.showMessageDialog(null,"Employee added successfully!" );
	    				EmployeesDetails.main(new String[]{});
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
	    	});
	    	
	    	b2=new JButton("Back");
	    	b2.setFont(new Font("Georgia",Font.BOLD,14));
	    	b2.setBackground(Color.GRAY);
	    	b2.setBounds(320,230,80,30);
	    	
	    	panel.add(b2);
	    	b2.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e)
	    		{
	    				EmployeesDetails.main(new String[]{});
	    				frame.dispose();
	    		}		
	    	});
	    }
		public static void main(String[] args) {
			AddEmployee ol=new AddEmployee();
			ol.frame.setVisible(true);

		}
}
