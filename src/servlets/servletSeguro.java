package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Seguro;
import dominio.SeguroDao;
import dominio.TipoSeguroDao;

@WebServlet("/servletSeguro")
public class servletSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public servletSeguro() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		if(request.getParameter("btnAceptar")!=null)
		{
			Seguro seg  =  new Seguro();
			SeguroDao sdao = new SeguroDao();
			TipoSeguroDao tsdao = new TipoSeguroDao();
			
			seg.setDescripcion(request.getParameter("txtDescripcion"));		
			
			String descTipo = request.getParameter("tiposSeguro");
			int idTipo = tsdao.obtenerIdTipo(descTipo);
			seg.setIdTipo(idTipo);
			
			seg.setCostoContratacion(Double.parseDouble(request.getParameter("txtCosto")));
			seg.setCostoAsegurado(Double.parseDouble(request.getParameter("txtCostoMax")));
			
			int filas= sdao.agregarSeguro(seg);
			
			//REQUESTDISPATCHER
			
			request.setAttribute("cantFilas", filas);
			RequestDispatcher rd = request.getRequestDispatcher("/AgregarSeguro.jsp");   
	        rd.forward(request, response);    			
		}		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}
