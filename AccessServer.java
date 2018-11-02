import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class AccessServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			LocateRegistry.createRegistry(1094);
			AccessDB accessObject = new  AccessDB();
			Naming.rebind("AccessObject", accessObject);
			System.out.println("Access registered");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
