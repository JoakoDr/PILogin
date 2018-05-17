package LogiN;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import LogiN.Vista;

public class Model {
	private Vista miVista;
	private login miLogin;
	//private String bd;
	//private String login;
	//private String pwd;
	//private String url;
	private String driver;
	private String sqlTabla1;
	//private Connection conexion;
	private static String bd = "liga";
	private static String login = "root";
	private static String pwd = "root";
	public static String url = "jdbc:mysql://localhost/liga?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	Connection conexion;
	ResultSet rs;

	private DefaultTableModel miTabla;

	public Model() {
		try {
			bd = "mvcprog";
			login = "root";
			pwd = "";
		  url = "jdbc:mysql://localhost/mvcprog?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			sqlTabla1 = "Select * from mvcprog.alumno";
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(url, login, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		cargarTabla1();
	}

	private void cargarTabla1() {
		int numColumnas = getNumColumnas(sqlTabla1);
		int numFilas = getNumFilas(sqlTabla1);

		String[] cabecera = new String[numColumnas];

		Object[][] contenido = new Object[numFilas][numColumnas];
		PreparedStatement pstmt;
		try {
			pstmt = conexion.prepareStatement(sqlTabla1);
			ResultSet rset = pstmt.executeQuery();
			ResultSetMetaData rsmd = rset.getMetaData();
			for (int i = 0; i < numColumnas; i++) {
				cabecera[i] = rsmd.getColumnName(i + 1);
			}
			int fila = 0;
			while (rset.next()) {
				for (int col = 1; col <= numColumnas; col++) {
					contenido[fila][col - 1] = rset.getString(col);
				}
				fila++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		miTabla = new DefaultTableModel(contenido, cabecera);
	}
	public int  validar_ingreso()
	{
		String usuario = miLogin.textField.getText();
		String pass = miLogin.textField_1.getText();
		int resultado = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(url, "root", "");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (conexion != null) {
		try {
			//ResultSet rset = st.executeQuery(query);
			//conexion = miLogin.ds.getConnection();
		
			Statement st = conexion.createStatement();
			String query = "SELECT * FROM users WHERE USR='"+usuario+"'AND PWD='"+pass+"'";
			ResultSet rs = st.executeQuery(query);
			if(rs.next())
			{
				resultado=1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e, "Error de conexión", JOptionPane.ERROR_MESSAGE);
		}finally
		{
			try {
				conexion.close();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e, "Error de desconexión", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		 System.out.println (" - Conexión con MySQL establecida -");
		
	}
		return resultado;
	}
	private int getNumColumnas(String sql) {
		int num = 0;
		try {
			PreparedStatement pstmt = conexion.prepareStatement(sql);
			ResultSet rset = pstmt.executeQuery();
			ResultSetMetaData rsmd = rset.getMetaData();
			num = rsmd.getColumnCount();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	private int getNumFilas(String sql) {
		int numFilas = 0;
		try {
			PreparedStatement pstmt = conexion.prepareStatement(sql);
			ResultSet rset = pstmt.executeQuery();
			while (rset.next())
				numFilas++;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return numFilas;
	}

	public DefaultTableModel getTabla() {
		return miTabla;
	}

	public void setVista(Vista miVista2) {
		this.miVista = miVista2;
	}

}
