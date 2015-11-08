package tprog.web;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tprog.logica.interfaces.Fabrica;
import tprog.logica.interfaces.ICtrlUsuarios;
import webservice.DtLineaReserva;

public class IniciarSesion extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		webservice.PublicadorService service = new webservice.PublicadorService();
		webservice.Publicador proxy = service.getPublicadorPort();
		String id = request.getParameter("nickname"); //puede ser email o nickname
		String contrasena = request.getParameter("password");
		EstadoSesion nuevoEstado;
		Fabrica f = Fabrica.getInstance();
		ICtrlUsuarios cu = f.getICtrlUsuarios();
		// se checkean los datos de login
		if (session.getAttribute("tipo_usuario") == TipoUsuario.CLIENTE) {
			if (proxy.verificarLoginCliente(id, contrasena)) {
				Set<DtLineaReserva> lineasReserva = new HashSet<>();
				request.getSession().setAttribute("lineasReserva", lineasReserva);

//				ICtrlReservas cr = f.getICtrlReservas(); //se lo asocio por la duracion de la sesion
//				cr.liberarMemoriaControlador();
//				session.setAttribute("ctrlReservas", cr);
				nuevoEstado = EstadoSesion.OK_LOGIN;

				//en caso de que id sea un email
				id = proxy.obtenerIdCliente(id, contrasena);
				request.getSession().setAttribute("usuario_logueado", id);

				session.setAttribute("estado_sesion", nuevoEstado);
				session.setAttribute("cant_items", 0);
			} else {
				session.setAttribute("inicioIncorrecto", "Las credenciales que ingresó no corresponden a ningún cliente registrado en el sistema");
			}
		}

		if (session.getAttribute("tipo_usuario") == TipoUsuario.PROVEEDOR) {
			if (proxy.verificarLoginProveedor(id, contrasena)) {
				//el proveedor no hace reservas
//				ICtrlReservas cr = f.getICtrlReservas(); //se lo asocio por la duracion de la sesion
//				cr.liberarMemoriaControlador();
//				session.setAttribute("ctrlReservas", cr);
				nuevoEstado = EstadoSesion.OK_LOGIN;
				//en caso de que id sea un email
				id = proxy.obtenerIdProveedor(id, contrasena);
				request.getSession().setAttribute("usuario_logueado", id);
				session.setAttribute("estado_sesion", nuevoEstado);
				session.setAttribute("cant_items", 0);
			} else {
				session.setAttribute("inicioIncorrecto", "Las credenciales que ingresó no corresponden a ningún proveedor registrado en el sistema");
			}
		}
		// redirige a la página principal para que luego rediriga a la página
		// que corresponde
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Home");
		dispatcher.forward(request, response);
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
