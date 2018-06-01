package management;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class EmployeeList {

	public static int save(String name, int dno, int contact) {
		int status=0;
		try {
		Connection con=DatabaseConnector.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into employee(name,dno,contactno) values (?,?,?)");
		ps.setString(1, name);
		ps.setInt(2, dno);
		ps.setInt(3, contact);
		status=ps.executeUpdate();
		con.close();
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return status;
	}

	public static int delete(int id) {
		int status=0;
		try{
			Connection con=DatabaseConnector.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from employeework where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			ps=con.prepareStatement("delete from employee where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

}
