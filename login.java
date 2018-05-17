package LogiN;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import LogiN.Model;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class login {

	public JFrame frame;
	public static JTextField textField;
	public static JTextField textField_1;
	 public DataSource ds = null;
	    public Context ctx = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws NamingException 
	 */
	public login()  {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws NamingException 
	 */
	public void initialize()  {
		
//		 try {
//			ctx = new InitialContext();
//			ds = (DataSource)ctx.lookup("jdbc:mysql://localhost/?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
//
//		} catch (NamingException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
	       
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textField = new JTextField("");
		textField.setColumns(10);
		
		textField_1 = new JTextField("");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("User :");
		
		JLabel lblPass = new JLabel("Pass :");
		
		JLabel lblFctaApp = new JLabel("FCTA App");
		Model funLogin = new Model();
		
		JButton btnNewButton = new JButton("Entrar o Log In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(funLogin.validar_ingreso()==1)
				{
					
					JOptionPane.showMessageDialog(null, "Bienvenido ha entrado", "Satisfactoriamente al sistema", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "No ha podido entrar", "No ha accedido satisfactoriamente al sistema", JOptionPane.ERROR_MESSAGE);
					
				}
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(38)
					.addComponent(lblFctaApp, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblPass, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED))
									.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
											.addComponent(textField, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
										.addGap(169)))
								.addGap(167)))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(65)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(23)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFctaApp, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addComponent(lblPass, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addComponent(btnNewButton)
					.addContainerGap(43, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
