package tprog.web;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import webservice.WrapperVerServicio;

public class VerServicio extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
		webservice.PublicadorService service = new webservice.PublicadorService();
		webservice.Publicador proxy = service.getPublicadorPort();
		String idServicio = request.getParameter("idServicio");
		String idProveedor = request.getParameter("idProveedor");
		WrapperVerServicio wrapper = proxy.verServicio(idServicio, idProveedor);
		request.setAttribute("idProveedor", idProveedor);
		request.setAttribute("infoServicio", wrapper.getDtServicio());
		Set<String> categorias = new HashSet<>(wrapper.getCategorias());
		System.out.println("Web App");
		System.out.println("Ciudad origen : " + wrapper.getDtServicio().getOrigen().getCiudad());
		System.out.println("Pais origen : " + wrapper.getDtServicio().getOrigen().getPais());
		request.setAttribute("categorias", categorias);
        if (session.getAttribute("tipo_usuario") == TipoUsuario.CLIENTE){
            request.getRequestDispatcher("/pages/verServicio.jsp").forward(request, response);
        } else{
            request.getRequestDispatcher("/pages/proveedor/verServicioProveedor.jsp").forward(request, response);
        }
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
