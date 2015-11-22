/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tprog.web;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import webservice.DtMinServicio;
import webservice.WrapperVerPromocion;

/**
 *
 * @author marccio
 */
public class VerPromocion extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		Properties properties = new Properties();
		String ruta = System.getProperty("user.home") + "/.Help4Travel/config.properties";
		FileInputStream file = new FileInputStream(ruta);
		properties.load(file);
		file.close();
		URL wsdlLocation = new URL(properties.getProperty("publicador") + "?wsdl");
		webservice.PublicadorService service = new webservice.PublicadorService(wsdlLocation);
		webservice.Publicador proxy = service.getPublicadorPort();
		String idPromocion = request.getParameter("idPromocion");
		String idProveedor = request.getParameter("idProveedor");
		WrapperVerPromocion result = proxy.verPromocion(idPromocion, idProveedor);
		//paso los servicios
		Map<DtMinServicio, Integer> servicios = new HashMap<>();
		List<WrapperVerPromocion.Servicios.Entry> entries = result.getServicios().getEntry();
		for (WrapperVerPromocion.Servicios.Entry entry : entries) {
			servicios.put(entry.getKey(), entry.getValue());
		}
		request.setAttribute("servicios", servicios);
		//necesito el nickname del proveedor
		request.setAttribute("idProveedor", idProveedor);
		//y el resto de la info del servicio
		request.setAttribute("infoPromocion", result.getPromocion());
		if (session.getAttribute("tipo_usuario") == TipoUsuario.CLIENTE) {
			request.getRequestDispatcher("/pages/verPromocion.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/pages/proveedor/verPromocionProveedor.jsp").forward(request, response);
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

	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
