package tprog.web;

import java.io.IOException;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.tuple.Triple;
import tprog.logica.dt.DTMinServicio;
import tprog.logica.dt.DTServicio;
import tprog.logica.interfaces.Fabrica;
import tprog.logica.interfaces.ICtrlProductos;
//import webServices.Publicador;
//import webServices.PublicadorService;

public class VerServicio extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idServicio = request.getParameter("idServicio");
		String idProveedor = request.getParameter("idProveedor");
        //uso el publicador
//        PublicadorService service =  new PublicadorService();
//        Publicador port = service.getPublicadorPort();
//        String[] ret = port.verServicio(idServicio, idProveedor);

		//hay que ver como pido las clases de la lógica cuando se saca el .jar
		Fabrica f = Fabrica.getInstance();
		ICtrlProductos ctrlProductos = f.getICtrlProductos();
		DTMinServicio dtMin = new DTMinServicio(idProveedor, idServicio);
		ctrlProductos.seleccionarServicio(dtMin);
		DTServicio dtFull = ctrlProductos.infoServicio();
		//necesito el nickname del proveedor
		request.setAttribute("idProveedor", dtMin.getNicknameP());
		//y el resto de la info del servicio
		request.setAttribute("infoServicio", dtFull);
		//busco categorias y las seteo como atributo a pasarle a la pagina jsp
		Set<String> categorias = ctrlProductos.listarCategoriasServicio();

//		webservice.PublicadorService service = new webservice.PublicadorService();
//		webservice.Publicador proxy = service.getPublicadorPort();
		request.setAttribute("idProveedor", proxy.verServicio_getNicknameP);
		request.setAttribute("infoServicio", proxy.verServicio_getInfoServicio);

		request.setAttribute("categorias", categorias);
		request.getRequestDispatcher("/pages/verServicio.jsp").forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
}
