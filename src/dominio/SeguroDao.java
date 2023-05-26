package dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SeguroDao {
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "segurosgroup";
	
	public int agregarSeguro(Seguro seguro)
	{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	
		int filas=0;
		Connection cn = null;
		try
		{
			cn = DriverManager.getConnection(host+dbName, user,pass);
			Statement st = cn.createStatement();
			String query = "Insert into seguros(descripcion, idTipo, costoContratacion, costoAsegurado) values ('"+seguro.getDescripcion() 
							+"','"+seguro.getIdTipo() + "','"+seguro.getCostoContratacion() + "','"+seguro.getCostoAsegurado() +"')";
			
			filas=st.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return filas;
	}

}
