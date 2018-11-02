import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.awt.event.ActionEvent;

public class AccessClient extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JTextField txtPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccessClient frame = new AccessClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AccessClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUser = new JTextField();
		txtUser.setBounds(116, 42, 86, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		txtPass = new JTextField();
		txtPass.setBounds(116, 94, 86, 20);
		contentPane.add(txtPass);
		txtPass.setColumns(10);
		
		JButton btnAdd = new JButton("Them moi");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					System.out.println("Client connected");
					AccessDBInterface obj = (AccessDBInterface)Naming.lookup("rmi://localhost/AccessObject");
					
					int n = obj.ExecUpdateSQL("Insert into Account values('"+txtUser.getText()+"','"+txtPass.getText()+"')");
					System.out.println("Insert into Account values('"+txtUser.getText()+"','"+txtPass.getText()+"')");
					if(n>0) JOptionPane.showConfirmDialog(null, "Success");
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("error"+e.getMessage());
					e.printStackTrace();
				}
			}
		});
		btnAdd.setBounds(113, 152, 89, 23);
		contentPane.add(btnAdd);
	}
}
