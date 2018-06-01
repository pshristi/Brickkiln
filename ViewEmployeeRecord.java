package management;
	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;

public class ViewEmployeeRecord {

		JFrame frame;
		private JPanel panel;
		private JTextField t;
		private JLabel l1,l2;
		private JButton b1,b2;
		static int id;
		
		ViewEmployeeRecord()
		{
			setcomponents();
		}
	    public void setcomponents()
	    {
	    	frame=new JFrame("BRICKKILN PLUS");
	    	frame.setBounds(100,100,500, 300);
			Image icon=Toolkit.getDefaultToolkit().getImaage("money.png");
			frame.setIconImage(icon);
			frame.setLayout(null);
			frame.getContentPane().setBackground(Color.black);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			panel=new JPanel();
			panel.setBounds(10,10,465,240);
			frame.add(panel); 
			panel.setLayout(null);
			
	        l1=new JLabel("View Employee Section");
	        l1.setBounds(80,20,400,40);
	        l1.setFont(new Font("Georgia",Font.BOLD,26));
	    	panel.add(l1);
	    	
	    	l2=new JLabel("Enter Id :");
	        l2.setBounds(50,80,100,20);
	        l2.setFont(new Font("Georgia",Font.BOLD,14));
	    	panel.add(l2);
	    	
	    	t=new JTextField();
	        t.setBounds(200,80,150,20);
	        t.setFont(new Font("Georgia",Font.BOLD,14));
	    	panel.add(t);
	    	
	    	b1=new JButton("View");
	    	b1.setFont(new Font("Georgia",Font.BOLD,14));
	    	b1.setBackground(Color.GRAY);
	    	b1.setBounds(180,120,100,30);
	    	
	    	panel.add(b1);
	    	b1.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e)
	    		{
	    			String sid=t.getText();
					if(sid==null||sid.trim().equals("")){
						JOptionPane.showMessageDialog(null,"Id can't be blank");
						t.setText("");
					}
					else{
					    id=Integer.parseInt(sid);
						ViewEmployee.main(new String[] {});
						frame.dispose();
					}
	    				
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
	    				EmployeesDetails.main(new String[]{});
	    				frame.dispose();
	    		}		
	    	});
	    }
		public static void main(String[] args) {
			ViewEmployeeRecord ol=new ViewEmployeeRecord();
			ol.frame.setVisible(true);

		}
}
