package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Seguro;
import dominio.SeguroDao;
import dominio.TipoSeguroDao;

/**
 * Servlet implementation class servletSeguro
 */
@WebServlet("/servletSeguro")
public class servletSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletSeguro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int filas=0;
		
		if(request.getParameter("btnAceptar")!=null)
		{
			Seguro seg  =  new Seguro();
			SeguroDao sdao = new SeguroDao();
			TipoSeguroDao tsdao = new TipoSeguroDao();
			
			if(!(request.getParameter("txtDescripcion").isEmpty()) && 
			(request.getParameter("txtCostoContratacion").matches("^[0-9]+([,][0-9]+)?$")) &&
			(request.getParameter("txtCostoMax").matches("^[0-9]+([,][0-9]+)?$"))) {
				
				seg.setDescripcion(request.getParameter("txtDescripcion"));		
				
				String descTipo = request.getParameter("tipoSeguro");
				int idTipo = tsdao.obtenerIdTipo(descTipo);
				seg.setTipo(idTipo);
				
				seg.setCosto(Double.parseDouble(request.getParameter("txtCostoContratacion")));
				seg.setCostoMax(Double.parseDouble(request.getParameter("txtCostoMax")));
				
				filas = sdao.agregarSeguro(seg);				
			}
			else {
				filas = 2;
			}
			
			//REQUESTDISPATCHER
			
			request.setAttribute("cantFilas", filas);
			RequestDispatcher rd = request.getRequestDispatcher("/AgregarSeguro.jsp");   
	        rd.forward(request, response);    			
		}		
		
		if(request.getParameter("btnFiltrar") != null)
		{
			
			String filtro = request.getParameter("tipoSeguro"); 
			
			SeguroDao dao = new SeguroDao();
			ArrayList<Seguro> listaFiltrada = dao.listarSegurosFiltrado(filtro);
			
			request.setAttribute("listaSegurosFiltrada", listaFiltrada);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ListarSeguro.jsp");
			rd.forward(request, response);
			
		}
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		doGet(request, response);
	}

}
