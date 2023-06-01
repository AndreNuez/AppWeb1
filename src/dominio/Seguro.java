package dominio;

public class Seguro {
	
	private int ID;
	private String descripcion;
	private int tipo;
	private double costo;
	private double costoMax;
	
	public Seguro ()
	{
		
	}
	public Seguro(String descripcion, int tipo, double costo, double costoMax) {
	
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.costo = costo;
		this.costoMax = costoMax;
	}

	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public int getTipo() {
		return tipo;
	}


	public void setTipo(int tipo) {
		this.tipo = tipo;
	}


	public double getCosto() {
		return costo;
	}


	public void setCosto(double costo) {
		this.costo = costo;
	}


	public double getCostoMax() {
		return costoMax;
	}


	public void setCostoMax(double costoMax) {
		this.costoMax = costoMax;
	}
	
	public void setId(int id) {
		this.ID = id;
	}
	
	public int getId() {
		return this.ID;
	}
	
}
