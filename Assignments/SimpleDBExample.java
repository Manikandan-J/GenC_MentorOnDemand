
import java.sql.*;

public class SimpleDBExample {

	public static void main(String[] args) {

		Connection con = null;
//		Statement stmt = null;
		 PreparedStatement pstmt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abcd", "root", "root");
			System.out.println("Connected to database...");
			
			System.out.println("Creating statement...");
//			stmt = con.createStatement();
			
			pstmt = con.prepareStatement("SELECT * FROM simple");
		
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
			
				int id = 0;

				id = rs.getInt("id");

				String name = rs.getString("name");

				System.out.print("Row Number:" + rs.getRow());
				System.out.print("ID: " + id);
				System.out.println(", Name: " + name);
				
			}
			
			System.out.println("Done...");
			pstmt.close();
			con.close();
				
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

