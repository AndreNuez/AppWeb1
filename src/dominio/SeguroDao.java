package dominio;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SeguroDao {
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "SegurosGroup";
	
	public int agregarSeguro(Seguro seguro)
	{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int filas=0;
		Connection cn = null;
		try
		{
			cn = DriverManager.getConnection(host+dbName, user,pass);
			Statement st = cn.createStatement();
			String query = "Insert into seguros(descripcion,idTipo,costoContratacion,costoAsegurado) values ('"+seguro.getDescripcion()+"','"+seguro.getTipo()+"','"+seguro.getCosto()+"','"+seguro.getCostoMax()+"')";
			filas=st.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return filas;
	}
	
	public ArrayList<Seguro> listarSeguros(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection cn = null;
		ArrayList<Seguro> listaSeguros = new ArrayList<Seguro>();
		TipoSeguroDao tsdao = new TipoSeguroDao();
		
		try
		{
			cn = DriverManager.getConnection(host+dbName, user,pass);
			String query = "select s.idSeguro,s.descripcion, s.idTipo, ts.descripcion,s.costoContratacion,s.costoAsegurado from seguros s inner join tiposeguros ts on ts.idTipo = s.idTipo";
			
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query);
				
			while (rs.next()) {
				Seguro seguro = new Seguro();
				seguro.setId(rs.getInt("idSeguro"));
				seguro.setDescripcion(rs.getString("descripcion"));
				seguro.setTipo(rs.getInt("idTipo")); 
				seguro.setCosto(rs.getInt("costoContratacion"));
				seguro.setCostoMax(rs.getInt("costoAsegurado"));
				
				listaSeguros.add(seguro);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return listaSeguros;
	}
	
	public ArrayList<Seguro> listarSegurosFiltrado(String filtro){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<Seguro> listaSegurosFiltrada = new ArrayList<Seguro>();
		Connection cn = null;
			
		try
		{
			cn = DriverManager.getConnection(host+dbName, user,pass);
			
			PreparedStatement query = cn.prepareStatement("select s.idSeguro, s.descripcion, s.idTipo, ts.descripcion, s.costoContratacion, s.costoAsegurado from seguros s inner join tiposeguros ts on ts.idTipo = s.idTipo WHERE ts.descripcion = ?");
			query.setString(1, filtro);
			ResultSet rs = query.executeQuery();
				
			while (rs.next()) {
				Seguro seguro = new Seguro();
				seguro.setId(rs.getInt("idSeguro"));
				seguro.setDescripcion(rs.getString("descripcion"));
				seguro.setTipo(rs.getInt("idTipo"));
				seguro.setCosto(rs.getInt("costoContratacion"));
				seguro.setCostoMax(rs.getInt("costoAsegurado"));
				
				listaSegurosFiltrada.add(seguro);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return listaSegurosFiltrada;
	}
	

public int obtenerUltimoId () {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		int id = 0;
		Connection cn = null;
		
		try{
			cn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT MAX(idSeguro) FROM seguros");
			rs.next();
			id = rs.getInt(1);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return id+1;
	}
}
