package tprog.web;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import javax.imageio.ImageIO;
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
		URL wsdlLocation = new URL(getServletContext().getInitParameter("wsdl"));
		webservice.PublicadorService service = new webservice.PublicadorService(wsdlLocation);
		webservice.Publicador proxy = service.getPublicadorPort();
		String idServicio = request.getParameter("idServicio");
		String idProveedor = request.getParameter("idProveedor");
        boolean esCliente;
        if (session.getAttribute("tipo_usuario") == TipoUsuario.CLIENTE){
            esCliente = true;
        } else {
            esCliente = false;
        }
		WrapperVerServicio wrapper = proxy.verServicio(idServicio, idProveedor, esCliente);
		request.setAttribute("idProveedor", idProveedor);
		request.setAttribute("infoServicio", wrapper.getDtServicio());
		Set<String> categorias = new HashSet<>(wrapper.getCategorias());
		System.out.println("Web App");
		System.out.println("Ciudad origen : " + wrapper.getDtServicio().getOrigen().getCiudad());
		System.out.println("Pais origen : " + wrapper.getDtServicio().getOrigen().getPais());

		List<byte[]> imagenes = wrapper.getImagenes();
		if (imagenes != null) {
			List<String> rutasImagenes = new ArrayList<>();
			int i = 0;
			for (byte[] imagen : imagenes) {
				BufferedImage img = ImageIO.read(new ByteArrayInputStream(imagen));
				String rutaRelativaImagen = "imagenes/" + Integer.toString(i) + ".jpg";
				String rutaCompletaImagen = getServletContext().getRealPath("/") + "/" + rutaRelativaImagen;
				File outputFile = new File(rutaCompletaImagen);
				outputFile.getParentFile().mkdirs();
				ImageIO.write(img, "jpg", outputFile);
				rutasImagenes.add(rutaRelativaImagen);
				i++;
			}
			request.setAttribute("imagenes", rutasImagenes);
		}
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
