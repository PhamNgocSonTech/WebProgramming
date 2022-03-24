package tutorial.simpleweb.conn;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;


public class SQLServerConnUtils_SQLJDBC {
		
		
		public static Connection getSQLServerConnUtils_SQLJDBC() throws ClassNotFoundException, SQLException {
			String hostName = "localhost";
			String sqlInstanceName = "SQLEXPRESS";
			String database = "QLSach";
			String userName = "sa";
			String password ="sa123";
			
			return getSQLServerConnection_SQLJDBC(hostName, sqlInstanceName, database, userName, password);
		}
		
		// Kết nối tới SQLServer, sử dụng thư viện SQLJDBC.
		private static Connection getSQLServerConnection_SQLJDBC(String hostName, //
				String sqlInstanceName, String database, String userName, String password)//
				throws ClassNotFoundException, SQLException {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// Cấu trúc URL Connection dành cho SQLServer
			// Ví dụ:
			// jdbc:sqlserver://ServerIp:1433/SQLEXPRESS;databaseName=simplehr
			String connectionURL = "jdbc:sqlserver://" + hostName + ":1433" //
					+ ";instance=" + sqlInstanceName + ";databaseName=" + database;

			Connection conn = DriverManager.getConnection(connectionURL, userName, password);
			return conn;
		}
}

