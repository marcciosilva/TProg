/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tprog.web.proveedor;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tprog.web.Buscar;
import webservice.DtPromocion;
import webservice.DtServicio;
import webservice.WrapperVerServiciosProveedor;

/**
 *
 * @author marccio
 */
@WebServlet(name = "ServiciosProveedor", urlPatterns = {"/ServiciosProveedor"})
public class ServiciosProveedor extends HttpServlet {

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//establezco proxy con el web service
		webservice.PublicadorService servicio
				= new webservice.PublicadorService();
		webservice.Publicador proxy = servicio.getPublicadorPort();
		WrapperVerServiciosProveedor result
				= proxy.verServiciosProveedor((String) request.getSession().getAttribute("usuario_logueado"));
		//rearmo el map de servicios
		List<webservice.WrapperVerServiciosProveedor.Servicios.Entry> listServicios
				= result.getServicios().getEntry();
		Map<DtServicio, String> servicios = new HashMap<>();
		for (webservice.WrapperVerServiciosProveedor.Servicios.Entry entry : listServicios) {
			servicios.put(entry.getKey(), entry.getValue());
		}
		//asigno atributos de la request
		request.setAttribute("servicios", servicios);
		//redirijo request
		request.getRequestDispatcher("/pages/verServiciosProveedor.jsp").forward(request, response);
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
