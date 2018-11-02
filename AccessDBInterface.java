import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.ResultSet;

public interface AccessDBInterface extends Remote {
	public ResultSet GetTable(String tableName) throws RemoteException;
	public int ExecUpdateSQL(String sql)throws RemoteException;
}
