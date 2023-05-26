package dominio;

public class TipoSeguro {
	
	private int idTipo;
	private String Descripcion;
	
	public TipoSeguro() {
		
	}

	public TipoSeguro(int idTipo, String descripcion) {
		this.idTipo = idTipo;
		Descripcion = descripcion;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "TipoSeguro [idTipo=" + idTipo + ", Descripcion=" + Descripcion + "]";
	}
	
	
}
