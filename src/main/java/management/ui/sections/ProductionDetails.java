package management.ui.sections;
	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
	
public class ProductionDetails {

			JFrame frame;
			private JPanel panel;
			private JLabel l1;
			private JButton b1,b2,b3,b4,b5,b6,b7,b8;
			
			ProductionDetails()
			{
				setcomponents();
			}
		    public void setcomponents()
		    {
		    	frame=new JFrame("BRICKKILN PLUS");
		    	frame.setBounds(100,100,500, 480);
				Image icon=Toolkit.getDefaultToolkit().getImage("money.png");
				frame.setIconImage(icon);
				frame.setLayout(null);
				frame.getContentPane().setBackground(Color.black);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				panel=new JPanel();
				panel.setBounds(10,10,465,420);
				frame.add(panel); 
				panel.setLayout(null);
				
		        l1=new JLabel("Production Section");
		        l1.setBounds(100,20,300,40);
		        l1.setFont(new Font("Georgia",Font.BOLD,26));
		    	panel.add(l1);
		    	
		    	b1=new JButton("Add Production Record");
		    	b1.setFont(new Font("Georgia",Font.BOLD,14));
		    	b1.setBackground(Color.GRAY);
		    	b1.setBounds(100,80,250,30);
		    	panel.add(b1);
		    	b1.addActionListener(new ActionListener() {
		    		public void actionPerformed(ActionEvent e)
		    		{
		    			AddProduction.main(new String[] {});
		    			frame.dispose();
		    		}
		    	});
		    	
		    	b2=new JButton("View Production Records");
		    	b2.setFont(new Font("Georgia",Font.BOLD,14));
		    	b2.setBackground(Color.GRAY);
		    	b2.setBounds(100,120,250,30);
		    	panel.add(b2);
		    	b2.addActionListener(new ActionListener() {
		    		public void actionPerformed(ActionEvent e)
		    		{
		    			ViewProduction.main(new String[] {});
		    			frame.dispose();
		    		}
		    	});
		    	
		    	b3=new JButton("Total Production List");
		    	b3.setFont(new Font("Georgia",Font.BOLD,14));
		    	b3.setBackground(Color.GRAY);
		    	b3.setBounds(100,160,250,30);
		    	panel.add(b3);
		    	b3.addActionListener(new ActionListener() {
		    		public void actionPerformed(ActionEvent e)
		    		{
		    			ViewTotalProduction.main(new String[] {});
		    			frame.dispose();
		    		}
		    	});
		    	
		    	b4=new JButton("Add Product");
		    	b4.setFont(new Font("Georgia",Font.BOLD,14));
		    	b4.setBackground(Color.GRAY);
		    	b4.setBounds(100,200,250,30);
		    	panel.add(b4);
		    	b4.addActionListener(new ActionListener() {
		    		public void actionPerformed(ActionEvent e)
		    		{
		    			AddProduct.main(new String[] {});
		    			frame.dispose();
		    		}
		    	});
		    	
		    	b8=new JButton("View Product List");
		    	b8.setFont(new Font("Georgia",Font.BOLD,14));
		    	b8.setBackground(Color.GRAY);
		    	b8.setBounds(100,240,250,30);
		    	panel.add(b8);
		    	b8.addActionListener(new ActionListener() {
		    		public void actionPerformed(ActionEvent e)
		    		{
		    			ViewProductList.main(new String[] {});
		    			frame.dispose();
		    		}
		    	});
		    	
		    	b6=new JButton("Modify Product Rate");
		    	b6.setFont(new Font("Georgia",Font.BOLD,14));
		    	b6.setBackground(Color.GRAY);
		    	b6.setBounds(100,280,250,30);
		    	panel.add(b6);
		    	b6.addActionListener(new ActionListener() {
		    		public void actionPerformed(ActionEvent e)
		    		{
		    			ModifyProduct.main(new String[] {});
		    			frame.dispose();
		    		}
		    	});
		    	
		    	b7=new JButton("Delete Product");
		    	b7.setFont(new Font("Georgia",Font.BOLD,14));
		    	b7.setBackground(Color.GRAY);
		    	b7.setBounds(100,320,250,30);
		    	panel.add(b7);
		    	b7.addActionListener(new ActionListener() {
		    		public void actionPerformed(ActionEvent e)
		    		{
		    			DeleteProduct.main(new String[] {});
		    			frame.dispose();
		    		}
		    	});
		    	
		    	b5=new JButton("Back");
		    	b5.setFont(new Font("Georgia",Font.BOLD,14));
		    	b5.setBackground(Color.GRAY);
		    	b5.setBounds(350,360,80,30);
		    	panel.add(b5);
		    	b5.addActionListener(new ActionListener() {
		    		public void actionPerformed(ActionEvent e)
		    		{
		    		    WorkDetails.main(new String[] {});
		    			frame.dispose();
		    		}
		    	});
		    	
		    }
		    
			public static void main(String[] args) {
				ProductionDetails ol=new ProductionDetails();
				ol.frame.setVisible(true);

			}
}
