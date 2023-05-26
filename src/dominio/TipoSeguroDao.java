package dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TipoSeguroDao {
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "segurosgroup";
	
	public ArrayList<TipoSeguro> obtenerTipoSeguro() {

			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			ArrayList<TipoSeguro> lista = new ArrayList<TipoSeguro>();
			Connection conn = null;
			
			try{
				conn = DriverManager.getConnection(host + dbName, user, pass);
				Statement st = conn.createStatement();
				
				ResultSet rs = st.executeQuery("Select idTipo,descripcion FROM tiposeguros");
				
				while(rs.next()){
					
					TipoSeguro seguroRs = new TipoSeguro();
					seguroRs.setIdTipo(rs.getInt("idTipo"));
					seguroRs.setDescripcion(rs.getString("descripcion"));
					
					lista.add(seguroRs);
				}
				conn.close();
			
			}catch(Exception e){
				e.printStackTrace();
			}
		
		return lista;
	}
	
	public int obtenerIdTipo (String desc) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		int id = 0;
		Connection cn = null;
		
		try{
			cn = DriverManager.getConnection(host + dbName, user, pass);
			String query = "SELECT * FROM tiposeguros WHERE descripcion = ?";
			
			PreparedStatement pst = cn.prepareStatement(query);
			
			pst.setString(2,desc);
			ResultSet rs = pst.executeQuery(query);
			rs.next();
			
			id = rs.getInt(1);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return id;
	}
	
	/*public TipoSeguro obtenerIdTipo (String desc) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			TipoSeguro ts = new TipoSeguro();
			Connection cn = null;
			
			try{
				cn = DriverManager.getConnection(host + dbName, user, pass);
				String query = "SELECT * FROM tiposeguros WHERE descripcion = ?";
				
				PreparedStatement pst = cn.prepareStatement(query);
				
				pst.setString(2, desc);
				ResultSet rs = pst.executeQuery(query);
				rs.next();
				
				ts.setIdTipo(rs.getInt(1)); 
				ts.setDescripcion(rs.getString(2));
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			return ts;
		}*/
	
}
