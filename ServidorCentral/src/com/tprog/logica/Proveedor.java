/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import com.tprog.logica.dt.DTMinProveedor;
import com.tprog.logica.dt.DTProveedor;
import com.tprog.logica.dt.DTMinPromocion;
import java.util.Date;

/**
 *
 * @author gaston
 */
public class Proveedor extends Usuario {

	private String empresa;
	private String webEmpresa;

	Map<String, Promocion> promociones;
	Map<String, Servicio> servicios;

	public Proveedor(String nick, String nom, String ap, String email,
			String imagen, Date fecha, String empresa, String webEmpresa) {
		super(nick, nom, ap, email, imagen, fecha);
		this.empresa = empresa;
		this.webEmpresa = webEmpresa;
		this.promociones = new HashMap();
		this.servicios = new HashMap();
	}

	public DTMinProveedor crearDTMin() {
		DTMinProveedor nuevoDT = new DTMinProveedor(this.nickname, this.email, this.webEmpresa);
		return nuevoDT;
	}

	public DTProveedor crearDT() {
		DTProveedor nuevoDT = new DTProveedor(this.nickname, this.nombre, this.apellido,
				this.email, this.imagen, this.fechaNacimiento, this.empresa, this.webEmpresa);
		return nuevoDT;
	}

	public Set<String> getServicios() {
		Set<String> nuevoSet;
		if (!servicios.isEmpty()) {
                    nuevoSet = servicios.keySet();
                    return nuevoSet;
		} else {
                    return new HashSet();
                }
        }
        
	public Set<DTMinPromocion> listarPromociones() {
		Set<DTMinPromocion> nuevoSet = new HashSet();
		for (Iterator<Promocion> it = promociones.values().iterator(); it.hasNext();) {
			Promocion promo = it.next();
			DTMinPromocion temp = promo.crearDTMin();
			nuevoSet.add(temp);
		}
		return nuevoSet;
	}

	public void addServicio(Servicio s) {
		servicios.put(s.getIdServicio(), s);
	}

	public void addPromocion(Promocion p) {
		promociones.put(p.getIdPromocion(), p);
	}

	public void setEmpresa(String empresa){
		this.empresa = empresa;
	}

	public void setWebEmpresa(String webEmpresa){
		this.webEmpresa = webEmpresa;
	}
	
	public String getEmpresa(){
		return this.empresa;
	}
	
	public String getWebEmpresa(){
		return this.webEmpresa;
	}
}

