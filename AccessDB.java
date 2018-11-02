
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;
import javax.sql.rowset.WebRowSet;

public class AccessDB extends UnicastRemoteObject implements AccessDBInterface {
	private Connection conn;
	private Statement stmt;
	public AccessDB() throws RemoteException{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-1I94MIJ;databaseName=QLTV;integratedSecurity=true");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public ResultSet GetTable(String tableName) throws RemoteException{
		ResultSet rs=null;
		try {
			stmt = conn.createStatement();
			String sql= "Select * from"+tableName;
			 rs= stmt.executeQuery(sql);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}
	public int ExecUpdateSQL(String sql)throws RemoteException{
		int n=0;
		try {
			stmt = conn.createStatement();
			n = stmt.executeUpdate(sql) ;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return n;
	}
}
