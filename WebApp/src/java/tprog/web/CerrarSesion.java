package tprog.web;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CerrarSesion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession objSesion = request.getSession();
        EstadoSesion nuevoEstado = EstadoSesion.NO_LOGIN; // ahora da siempre login incorrecto dado que no estan cargados los datos
        objSesion.setAttribute("idCtrlReservas", null);
        objSesion.setAttribute("reservaTemporal", null);
//		objSesion.setAttribute("lineasReserva", null);
        //objSesion.invalidate(); // creo q sirve para cuando se esta creando el carrito q se cierra sesion y borras todo
        objSesion.setAttribute("usuario_logueado", null);

        objSesion.setAttribute("estado_sesion", nuevoEstado);
        if (objSesion.getAttribute("tipo_usuario") == TipoUsuario.CLIENTE) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Home");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Proveedores");
            dispatcher.forward(request, response);
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
