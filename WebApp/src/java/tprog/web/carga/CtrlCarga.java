package tprog.web.carga;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import tprog.logica.clases.Ciudad;
import tprog.logica.clases.Pais;
import tprog.logica.dt.DTCliente;
import tprog.logica.dt.DTLineaReserva;
import tprog.logica.dt.DTMinPromocion;
import tprog.logica.dt.DTMinServicio;
import tprog.logica.dt.DTProveedor;
import tprog.logica.dt.DTReserva;
import tprog.logica.dt.DTServicio;
import tprog.logica.dt.DTUbicacion;
import tprog.logica.dt.EstadoReserva;
import tprog.logica.interfaces.Fabrica;
import tprog.logica.interfaces.ICtrlProductos;
import tprog.logica.manejadores.ManejadorProductos;
import tprog.logica.manejadores.ManejadorReservas;
import tprog.logica.manejadores.ManejadorUsuarios;

public class CtrlCarga extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (this.getServletConfig().getServletContext().getAttribute("datos_cargados") == null) {
			cargarDatos();
			this.getServletConfig().getServletContext().setAttribute("datos_cargados", true);
		}
		if (request.getSession().getAttribute("terminos") == null) {
			typeaheadInit(request);
		}

		request.setAttribute("categoriaSeleccionada", null);
		request.setAttribute("busqueda", null);
		request.setAttribute("precio", "0");
		request.getRequestDispatcher("Buscar").forward(request, response);
	}

	public void typeaheadInit(HttpServletRequest request) {
		// Obtengo todos los servicios del sistema
		Fabrica f = Fabrica.getInstance();
		ICtrlProductos ctrlProductos = f.getICtrlProductos();
		Set<DTMinServicio> serviciosTodos;
		try {
			serviciosTodos = ctrlProductos.listarServicios();
		} catch (Exception ex) {
			serviciosTodos = new HashSet();
		}

		// Obtengo todas las promociones del sistema
		Set<DTMinPromocion> promocionesTodas;
		try {
			promocionesTodas = ctrlProductos.listarPromociones();
		} catch (Exception ex) {
			promocionesTodas = new HashSet();
		}

		// TYPEAHEAD
		JSONArray termsArray = new JSONArray();
		if (!serviciosTodos.isEmpty()) {
			for (DTMinServicio dtMinS : serviciosTodos) {
				termsArray.add(dtMinS.getIdServicio());
			}
		}
		if (!promocionesTodas.isEmpty()) {
			for (DTMinPromocion dtMinP : promocionesTodas) {
				termsArray.add(dtMinP.getIdPromocion());
			}
		}
		request.getSession().setAttribute("terminos", termsArray);
	}

	public void cargarDatos() throws IOException {
		ManejadorUsuarios mu = ManejadorUsuarios.getInstance();
		try {
			//Alta de Clientes
			DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");

			DTCliente dtC;

			dtC = new DTCliente("oWood", "123", "Oliver", "Wood", "quidditch28@gmail.com",
					"imagenes/clientes/oWood.jpg", sourceFormat.parse("28/12/1988"), new HashSet<>());

			mu.altaCliente(dtC);
			dtC = new DTCliente("eWatson", "123", "Emma", "Watson", "e.watson@gmail.com",
					"imagenes/clientes/eWatson.jpg", sourceFormat.parse("15/04/1990"), new HashSet<>());
			mu.altaCliente(dtC);
			dtC = new DTCliente("BruceS", "123", "Bruce", "Sewell", "bruce.sewell@gmail.com",
					null, sourceFormat.parse("3/12/1978"), new HashSet<>());
			mu.altaCliente(dtC);
			dtC = new DTCliente("JeffW", "123", "Jeff", "Williams", "jeff.williams@gmail.com",
					null, sourceFormat.parse("27/11/1984"), new HashSet<>());
			mu.altaCliente(dtC);

			DTProveedor dtP = new DTProveedor("tCook", "123", "Tim", "Cook", "air.f@gmail.com",
					"imagenes/proveedores/tCook.jpg",
					sourceFormat.parse("1/11/1960"), "AirFrance", "http://www.airfrance.com/");
			mu.altaProveedor(dtP);
			dtP = new DTProveedor("moody", "123", "Alastor", "Moody", "eu.car@eucar.com",
					"imagenes/proveedores/moody.jpg",
					sourceFormat.parse("2/09/1965"), "EuropCar", "http://www.europcar.com.uy/");
			mu.altaProveedor(dtP);
			dtP = new DTProveedor("remus", "123", "Remus", "Lupin", "iberia@gmail.com",
					"imagenes/proveedores/remus.jpg",
					sourceFormat.parse("4/05/1970"), "Iberia", "http://www.iberia.com/uy/");
			mu.altaProveedor(dtP);
			dtP = new DTProveedor("adippet", "123", "Armando", "Dippet", "tam@outlook.com",
					"imagenes/proveedores/adippet.jpg",
					sourceFormat.parse("12/02/1967"), "Tam", "http://www.tam.com.br/");
			mu.altaProveedor(dtP);
			dtP = new DTProveedor("mHooch", "123", "Madam", "Hooch", "segHogar@gmail.com",
					"imagenes/proveedores/mHooch.jpg",
					sourceFormat.parse("5/08/1963"), "Segundo Hogar", "http://www.segundohogar.com/");
			mu.altaProveedor(dtP);
		} catch (ParseException ex) {
			Logger.getLogger(CtrlCarga.class.getName()).log(Level.SEVERE, null, ex);
		}
		ManejadorProductos mp = ManejadorProductos.getInstance();
		mp.altaCategoria("Vuelos", null);
		mp.altaCategoria("Empresas", "Vuelos");
		mp.altaCategoria("Iberia", "Empresas");
		mp.altaCategoria("American Airlines", "Empresas");
		mp.altaCategoria("Air France", "Empresas");
		mp.altaCategoria("TAM", "Empresas");
		mp.altaCategoria("Tipo vuelo", "Vuelos");
		mp.altaCategoria("LowCost", "Tipo vuelo");
		mp.altaCategoria("Standard", "Tipo vuelo");
		mp.altaCategoria("First Class", "Tipo vuelo");
		mp.altaCategoria("Alojamientos", null);
		mp.altaCategoria("Tipo alojamiento", "Alojamientos");
		mp.altaCategoria("Hotel", "Tipo alojamiento");
		mp.altaCategoria("Hostal", "Tipo alojamiento");
		mp.altaCategoria("Apartamento", "Tipo alojamiento");
		mp.altaCategoria("Casa", "Tipo alojamiento");
		mp.altaCategoria("Ubicación", "Alojamientos");
		mp.altaCategoria("Playa", "Ubicación");
		mp.altaCategoria("Rural", "Ubicación");
		mp.altaCategoria("Montaña", "Ubicación");
		mp.altaCategoria("Habitaciones", "Alojamientos");
		mp.altaCategoria("1 ambiente", "Habitaciones");
		mp.altaCategoria("1 dormitorio", "Habitaciones");
		mp.altaCategoria("2 dormitorios", "Habitaciones");
		mp.altaCategoria("Automóviles", null);
		mp.altaCategoria("Tarifa", "Automóviles");
		mp.altaCategoria("Mini", "Tarifa");
		mp.altaCategoria("Económico", "Tarifa");
		mp.altaCategoria("Standard", "Tarifa");
		mp.altaCategoria("Full", "Tarifa");
		mp.altaCategoria("Tipo vehículo", "Automóviles");
		mp.altaCategoria("Auto", "Tipo vehículo");
		mp.altaCategoria("Camioneta", "Tipo vehículo");
		mp.altaCategoria("Camión", "Tipo vehículo");
		mp.altaCategoria("Moto", "Tipo vehículo");
		mp.altaCategoria("Marca", "Automóviles");
		mp.altaCategoria("Chevrolet", "Marca");
		mp.altaCategoria("Peugeot", "Marca");
		mp.altaCategoria("Daihatsu", "Marca");
		mp.altaCategoria("Fiat", "Marca");
		mp.altaCategoria("Ford", "Marca");
		mp.altaCategoria("Cruceros", null);
		mp.altaCategoria("Mediterráneo", "Cruceros");
		mp.altaCategoria("Mar Negro", "Cruceros");
		mp.altaCategoria("Caribe", "Cruceros");
		mp.altaCategoria("Nilo", "Cruceros");
		mp.altaCategoria("Alaska", "Cruceros");
		Pais p = new Pais("Uruguay");
		p.agregarCiudad(new Ciudad("Montevideo"));
		mp.agregarPais(p);
		p = new Pais("Argentina");
		p.agregarCiudad(new Ciudad("Buenos Aires"));
		p.agregarCiudad(new Ciudad("Bariloche"));
		mp.agregarPais(p);
		p = new Pais("Colombia");
		p.agregarCiudad(new Ciudad("Bogotá"));
		mp.agregarPais(p);
		p = new Pais("EEUU");
		p.agregarCiudad(new Ciudad("Miami"));
		mp.agregarPais(p);
		p = new Pais("España");
		p.agregarCiudad(new Ciudad("Valencia"));
		p.agregarCiudad(new Ciudad("Madrid"));
		mp.agregarPais(p);
		p = new Pais("Francia");
		p.agregarCiudad(new Ciudad("París"));
		mp.agregarPais(p);
		p = new Pais("Alemania");
		p.agregarCiudad(new Ciudad("Berlín"));
		mp.agregarPais(p);
		p = new Pais("Suiza");
		p.agregarCiudad(new Ciudad("Ginebra"));
		mp.agregarPais(p);
		p = new Pais("Australia");
		p.agregarCiudad(new Ciudad("Sidney"));
		mp.agregarPais(p);
		p = new Pais("Brasil");
		p.agregarCiudad(new Ciudad("Florianópolis"));
		mp.agregarPais(p);
		p = new Pais("China");
		p.agregarCiudad(new Ciudad("Pekín"));
		p.agregarCiudad(new Ciudad("Cantón"));
		mp.agregarPais(p);
		Set<String> imgs = new HashSet<>();
		imgs.add("imagenes/IMG7.jpg");
		DTServicio dtS = new DTServicio("Euro-Vuelo-S", "remus", "Vuelo con excelente atención y comodidad",
				1100, imgs, new DTUbicacion("Montevideo", "Uruguay"),
				new DTUbicacion("Valencia", "España"));
		Set<String> cats = new HashSet<>();
		cats.add("Iberia");
		cats.add("Standard");
		mp.altaServicio(dtS, "remus", cats);
		imgs = new HashSet<>();
		imgs.add("imagenes/IMG7.jpg");
		dtS = new DTServicio("Euro-Vuelo-LC", "remus", "Vuelo con excelente "
				+ "atención y comodidad a un precio accesible.", 850, imgs,
				new DTUbicacion("Montevideo", "Uruguay"),
				new DTUbicacion("Valencia", "España"));
		cats = new HashSet<>();
		cats.add("Iberia");
		cats.add("LowCost");
		mp.altaServicio(dtS, "remus", cats);
		imgs = new HashSet<>();
		imgs.add("imagenes/IMG7.jpg");
		dtS = new DTServicio("Euro-Vuelo-FC", "remus", "Vuelo de primera clase. "
				+ "Excelente atención, comodidad y servicio.", 1300, imgs,
				new DTUbicacion("Montevideo", "Uruguay"),
				new DTUbicacion("Valencia", "España"));
		cats = new HashSet<>();
		cats.add("Iberia");
		cats.add("First Class");
		mp.altaServicio(dtS, "remus", cats);
		imgs = new HashSet<>();
		imgs.add("imagenes/IMG8.jpg");
		dtS = new DTServicio("Euro-Car-1", "moody", "Euro-Car. Autos de buena calidad "
				+ "y comodidad. Versión Económica", 300, imgs,
				new DTUbicacion("Madrid", "España"),
				new DTUbicacion("Valencia", "España"));
		cats = new HashSet<>();
		cats.add("Económico");
		cats.add("Auto");
		cats.add("Chevrolet");
		mp.altaServicio(dtS, "moody", cats);
		imgs = new HashSet<>();
		imgs.add("imagenes/IMG9.jpg");
		dtS = new DTServicio("Euro-Car-2", "moody", "Euro-Car. Autos de buena calidad"
				+ " y comodidad. Versión Standard.", 300, imgs,
				new DTUbicacion("Madrid", "España"),
				new DTUbicacion("Valencia", "España"));
		cats = new HashSet<>();
		cats.add("Común");
		cats.add("Auto");
		cats.add("Chevrolet");
		mp.altaServicio(dtS, "moody", cats);
		imgs = new HashSet<>();
		imgs.add("imagenes/IMG10.jpg");
		dtS = new DTServicio("Euro-Car-3", "moody", "Euro-Car. Autos de buena calidad "
				+ "y comodidad. Una camioneta para toda la familia.", 300, imgs,
				new DTUbicacion("Valencia", "España"), null);
		cats = new HashSet<>();
		cats.add("Full");
		cats.add("Camioneta");
		cats.add("Chevrolet");
		mp.altaServicio(dtS, "moody", cats);
		imgs = new HashSet<>();
		imgs.add("imagenes/IMG1.jpg");
		imgs.add("imagenes/IMG2.jpg");
		dtS = new DTServicio("Casa para p4 BsAs", "mHooch", "Esta hermosa casa, se "
				+ "encuentra ubicada en el corazón de Buenos Aires y ofrece una "
				+ "capacidad para cuatro personas. La propiedad cuenta con un "
				+ "dormitorio con dos camas simples, que pueden transformarse en "
				+ "una matrimonial y dos baños completos, que incluyen toallas.",
				80, imgs, new DTUbicacion("Buenos Aires", "Argentina"), null);
		cats = new HashSet<>();
		cats.add("Casa");
		cats.add("2 dormitorios");
		mp.altaServicio(dtS, "mHooch", cats);
		imgs = new HashSet<>();
		imgs.add("imagenes/IMG3.jpg");
		imgs.add("imagenes/IMG4.jpg");
		imgs.add("imagenes/IMG5.jpg");
		dtS = new DTServicio("Floripa G. House", "mHooch", "Estamos a sólo unos pasos "
				+ "de un supermercado, restaurantes, cajero automático, "
				+ "gasolinera, farmacia, gimnasio, etc. Lagoa da Conceição es 7"
				+ " km de nuestra casa de huéspedes y tarda sólo 10-15 minutos "
				+ "en el transporte público. Allí se encuentra una buena vida "
				+ "nocturna con bares y música en vivo.", 190, imgs,
				new DTUbicacion("Florianópolis", "Brasil"), null);
		cats = new HashSet<>();
		cats.add("Casa");
		cats.add("2 dormitorios");
		mp.altaServicio(dtS, "mHooch", cats);
		imgs = new HashSet<>();
		imgs.add("imagenes/IMG6.jpg");
		dtS = new DTServicio("Air-France-FC", "tCook", "¡Un vuelo de primera! "
				+ "Excelencia y experiencia en mejorar sus viajes.", 100, imgs,
				new DTUbicacion("París", "Francia"),
				new DTUbicacion("Berlín", "Alemania"));
		cats = new HashSet<>();
		cats.add("Air France");
		cats.add("First Class");
		mp.altaServicio(dtS, "tCook", cats);
		imgs = new HashSet<>();
		imgs.add("imagenes/IMG11.jpg");
		dtS = new DTServicio("TAM-FC", "adippet", "¡Un vuelo de primera! Excelencia y "
				+ "experiencia.", 150, imgs, new DTUbicacion("Florianópolis",
						"Brasil"), new DTUbicacion("Pekín", "China"));
		cats = new HashSet<>();
		cats.add("TAM");
		cats.add("First Class");
		mp.altaServicio(dtS, "adippet", cats);
		imgs = new HashSet<>();
		imgs.add("imagenes/IMG12.jpg");
		dtS = new DTServicio("Luxury south beach corner apartament", "mHooch",
				"Beautiful large 2 bedrooms 2 bathrooms apartment CORNER UNIT. "
				+ "Marble floor throughout, beautiful open kitchen, granite "
				+ "counter top, spacious dining room area and living room area."
				+ "Spectacular views of Miami from all windows and balcony.",
				300, imgs, new DTUbicacion("Miami", "EEUU"), null);
		cats = new HashSet<>();
		cats.add("Hotel");
		cats.add("Playa");
		cats.add("2 dormitorios");
		mp.altaServicio(dtS, "mHooch", cats);
		imgs = new HashSet<>();
		imgs.add("imagenes/IMG8.jpg");
		dtS = new DTServicio("Coche-Miami", "mHooch",
				"A useful car to travel around Miami", 360, imgs,
				new DTUbicacion("Miami", "EEUU"), null);
		cats = new HashSet<>();
		cats.add("Económico");
		cats.add("Auto");
		cats.add("Chevrolet");
		mp.altaServicio(dtS, "mHooch", cats);
		List<String> servs = new ArrayList<>();
		servs.add("Euro-Car-1");
		servs.add("Euro-Car-1");
		mp.altaPromocion("Euro-Cars-E-S", 30, "moody", servs);
		servs = new ArrayList<>();
		servs.add("Euro-Car-1");
		servs.add("Euro-Car-3");
		mp.altaPromocion("Euro-Cars-E-F", 30, "moody", servs);
		servs = new ArrayList<>();
		servs.add("Euro-Car-2");
		servs.add("Euro-Car-3");
		mp.altaPromocion("Euro-Cars-ES-F", 30, "moody", servs);
		servs = new ArrayList<>();
		servs.add("Euro-Vuelo-S");
		servs.add("Euro-Vuelo-LC");
		mp.altaPromocion("Euro-Vuelos-S-LC", 40, "remus", servs);
		servs = new ArrayList<>();
		servs.add("Euro-Vuelo-S");
		servs.add("Euro-Vuelo-FC");
		mp.altaPromocion("Euro-Vuelos-S-FC", 40, "remus", servs);
		servs = new ArrayList<>();
		servs.add("Euro-Vuelo-LC");
		servs.add("Euro-Vuelo-FC");
		mp.altaPromocion("Euro-Vuelos-LC-FC", 40, "remus", servs);
		servs = new ArrayList<>();
		servs.add("Casa para p4 BsAs");
		servs.add("Floripa G. House");
		mp.altaPromocion("Sudamerica-Casas", 50, "mHooch", servs);
		servs = new ArrayList<>();
		servs.add("Luxury south beach corner apartament");
		servs.add("Coche-Miami");
		mp.altaPromocion("Miami-Viaje", 30, "mHooch", servs);
		ManejadorReservas mr = ManejadorReservas.getInstance();
		try {
			//R1 S1
			Set<DTLineaReserva> lineas = new HashSet<>();
			lineas.add(new DTLineaReserva(1, new Date(2015, 1 - 1, 1),
					new Date(2015, 1 - 1, 1), "Euro-Vuelo-S", null, "remus", 1100));
			DTReserva dtR = new DTReserva(0, new Date(2015, 1 - 1, 1),
					EstadoReserva.Facturada, 1100, lineas);
			mr.agregarReserva(mu.getCliente("oWood"), dtR);
			//R2    S1 S2
			lineas = new HashSet<>();
			lineas.add(new DTLineaReserva(2, new Date(2015, 1 - 1, 1),
					new Date(2015, 1 - 1, 1), "Euro-Vuelo-S", null, "remus", 1100));
			lineas.add(new DTLineaReserva(1, new Date(2015, 1 - 1, 1),
					new Date(2015, 1 - 1, 1), "Euro-Vuelo-LC", null, "remus", 850));
			dtR = new DTReserva(0, new Date(2015, 1 - 1, 1),
					EstadoReserva.Cancelada, 3050, lineas);
			mr.agregarReserva(mu.getCliente("eWatson"), dtR);

			//R3    P7
			lineas = new HashSet<>();
			lineas.add(new DTLineaReserva(1, new Date(2015, 3 - 1, 5),
					new Date(2015, 4 - 1, 2), null, "Sudamerica-Casas", "mHooch", 135));
			dtR = new DTReserva(0, new Date(2015, 3 - 1, 5),
					EstadoReserva.Pagada, 135, lineas);
			mr.agregarReserva(mu.getCliente("BruceS"), dtR);
			//R4    S5 S6
			lineas = new HashSet<>();
			lineas.add(new DTLineaReserva(1, new Date(2015, 5 - 1, 8),
					new Date(2015, 5 - 1, 12), "Euro-Car-2", null, "moody", 300));
			lineas.add(new DTLineaReserva(1, new Date(2015, 5 - 1, 8),
					new Date(2015, 5 - 1, 12), "Euro-Car-3", null, "moody", 300));
			dtR = new DTReserva(0, new Date(2015, 5 - 1, 8),
					EstadoReserva.Pagada, 600, lineas);
			mr.agregarReserva(mu.getCliente("JeffW"), dtR);
			//R5    S9
			lineas = new HashSet<>();
			lineas.add(new DTLineaReserva(2, new Date(2015, 8 - 1, 7),
					new Date(2015, 8 - 1, 10), "Air-France-FC", null, "tCook", 100));
			dtR = new DTReserva(0, new Date(2015, 8 - 1, 7),
					EstadoReserva.Registrada, 200, lineas);
			mr.agregarReserva(mu.getCliente("oWood"), dtR);
			//R6    P8 S7
			lineas = new HashSet<>();
			lineas.add(new DTLineaReserva(1, new Date(2015, 8 - 1, 7),
					new Date(2015, 8 - 1, 14), null, "Miami-Viaje", "mHooch", 462));
			lineas.add(new DTLineaReserva(1, new Date(2015, 8 - 1, 14),
					new Date(2015, 8 - 1, 21), "Casa para p4 BsAs", null, "mHooch", 80));
			dtR = new DTReserva(0, new Date(2015, 8 - 1, 7),
					EstadoReserva.Registrada, 542, lineas);
			mr.agregarReserva(mu.getCliente("eWatson"), dtR);
			//R7    S2
			lineas = new HashSet<>();
			lineas.add(new DTLineaReserva(2, new Date(2015, 8 - 1, 7),
					new Date(2015, 8 - 1, 7), "Euro-Vuelo-LC", null, "remus", 850));
			dtR = new DTReserva(0, new Date(2015, 8 - 1, 7),
					EstadoReserva.Registrada, 1700, lineas);
			mr.agregarReserva(mu.getCliente("BruceS"), dtR);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}