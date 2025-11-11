package management.ui.login;
import management.dao.ManagerList;
import management.ui.sections.ManagerSection;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ManagerLogin {

	JFrame frame;
	private JPanel panel;
	private JTextField t;
	private JPasswordField p;
	private JLabel l1,l2,l3;
	private JButton b1,b2;
	
	ManagerLogin()
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
		
        l1=new JLabel("Manager Login");
        l1.setBounds(150,20,300,40);
        l1.setFont(new Font("Georgia",Font.BOLD,26));
    	panel.add(l1);
    	
    	l2=new JLabel("Enter  Name :");
        l2.setBounds(50,80,200,20);
        l2.setFont(new Font("Georgia",Font.BOLD,14));
    	panel.add(l2);
    	
    	l3=new JLabel("Enter  Password :");
        l3.setBounds(50,120,200,20);
        l3.setFont(new Font("Georgia",Font.BOLD,14));
    	panel.add(l3);
    	
    	t=new JTextField();
        t.setBounds(200,80,150,20);
        t.setFont(new Font("Georgia",Font.BOLD,14));
    	panel.add(t);
    	
    	p=new JPasswordField();
        p.setBounds(200,120,150,20);
    	panel.add(p);
    	
    	b1=new JButton("Login");
    	b1.setFont(new Font("Georgia",Font.BOLD,14));
    	b1.setBackground(Color.GRAY);
    	b1.setBounds(180,160,100,30);
    	
    	
    	panel.add(b1);
    	b1.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e)
    		{
    			String name=t.getText();
    			String password=String.valueOf(p.getPassword());
    			if(ManagerList.validate(name,password))
    			{
    				OwnerLogin.pass=0;
    				ManagerSection.main(new String[] {});
    			    frame.dispose();
    			}
    			else
    			{
    				JOptionPane.showMessageDialog(null,"Wrong username or password!!");
    				t.setText("");
    				p.setText("");
    			}
    		}
    	});
    	
    	b2=new JButton("Back");
    	b2.setFont(new Font("Georgia",Font.BOLD,14));
    	b2.setBackground(Color.GRAY);
    	b2.setBounds(350,200,80,30);
    	panel.add(b2);
    	b2.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e)
    		{
    				Factory.main(new String[]{});
    				frame.dispose();
    		}		
    	});
    }
	public static void main(String[] args) {
		ManagerLogin ml=new ManagerLogin();
		ml.frame.setVisible(true);

	}

}
