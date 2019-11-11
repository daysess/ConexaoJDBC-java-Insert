package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Program {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement st = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			conn = DB.getConnection();
			st = conn.prepareStatement("INSERT INTO seller "
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+ "VALUES (?, ?, ?, ?, ?)");
			
			st.setString(1, "Mariana");
			st.setString(2, "mariana@gmail.com");
			st.setDate(3,  new java.sql.Date(sdf.parse("01/11/1980").getTime()));
			st.setDouble(4, 1000.0);
			st.setInt(5, 4);
			
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Done! Rows Affeced: "+ rowsAffected);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ParseException e) {
			e.printStackTrace();
		}finally {
			DB.closeStatement(st);
			DB.closeConnection();
			
		}
				
		
	}

}
