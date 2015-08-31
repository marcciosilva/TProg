/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.controladores;

import com.tprog.logica.interfaces.ICtrlProductos;
import com.tprog.logica.dt.*;
import com.tprog.logica.manejadores.*;
import java.util.*;
/**
 *
 * @author sofia
 */
public class CtrlProductos implements ICtrlProductos{
    private DTMinPromocion dtP;
    private DTMinServicio dtS;
    private String categoriaPadre;
    private String idCategoria;
    private String nicknameP;
    private Set<String> listaServicios;
    private Set<String> listaCategorias;
    private DTUbicacion origen;
    private DTUbicacion destino;
    
    public CtrlProductos(){
        this.dtP = null;
        this.dtS = null;
        this.categoriaPadre = "";
        this.idCategoria = "";
        this.nicknameP = "";
        this.listaServicios = new HashSet();
        this.listaCategorias = new HashSet();
        this.origen = null;
        this.destino = null;
    }
	
    @Override
    public Set<DTMinPromocion> listarPromociones(){
        ManejadorProductos mp = ManejadorProductos.getInstance();
        return mp.listarPromociones();
    }
    
    @Override
    public void seleccionarPromocion(DTMinPromocion dtP){
        this.dtP = dtP;
    }
    
    @Override
    public DTPromocion infoPromocion(){
        ManejadorProductos mp = ManejadorProductos.getInstance();
        return mp.infoPromocion(dtP);
    }
    
    @Override
    public void seleccionarServicio(DTMinServicio dtS){
        this.dtS = dtS;
    }
    
    @Override
    public DTServicio infoServicio(){
        ManejadorProductos mp = ManejadorProductos.getInstance();
        return mp.infoServicio(dtS);
    }
    
    @Override
    public Set<String> listarCategorias(){
        return null;
    }
    
    @Override
    public Set<DTMinServicio> listarServiciosCategoria(String idCategoria){
        ManejadorProductos mp = ManejadorProductos.getInstance();
        return mp.listarServiciosCategoria(idCategoria);
    }
    
    @Override
    public Set<DTMinServicio> listarServicios(){
        ManejadorProductos mp = ManejadorProductos.getInstance();
        return mp.listarServicios(); 
    }
    
    @Override
    public void cambiarPrecio(float nuevoPrecio){
        ManejadorProductos mp = ManejadorProductos.getInstance();
        mp.cambiarPrecio(dtS, nuevoPrecio);
    }
    
    @Override
    public void cambiarDescripcion(String descripcion){
        ManejadorProductos mp = ManejadorProductos.getInstance();
        mp.cambiarDescripcion(dtS, descripcion);
    }
    
    @Override
    public void agregarImagen(String idImagen){
        ManejadorProductos mp = ManejadorProductos.getInstance();
        mp.agregarImagen(dtS, idImagen);
    }
    
    @Override
    public void quitarImagen(String idImagen){
        ManejadorProductos mp = ManejadorProductos.getInstance();
        mp.quitarImagen(dtS, idImagen);
    }
    
    @Override
    public Set<DTUbicacion> listarCiudades(){
        ManejadorProductos mp = ManejadorProductos.getInstance();
        return mp.listarCiudades();
    }
    
    @Override
    public void cambiarOrigen(DTUbicacion dtU){
        ManejadorProductos mp = ManejadorProductos.getInstance();
        mp.cambiarOrigen(dtS, dtU);
    }
    
    @Override
    public void cambiarDestino (DTUbicacion dtU){
        ManejadorProductos mp = ManejadorProductos.getInstance();
        mp.cambiarDestino(dtS, dtU);
    }
    
    @Override
    public Set<String> listarCategoriasServicio(){
        return null;
    }
    
    @Override
    public boolean agregarCategoria(String idCategoria){
        ManejadorProductos mp = ManejadorProductos.getInstance();
        return mp.agregarCategoria(idCategoria);
    }
    
    @Override
    public boolean quitarCategoria (String idCategoria){
        ManejadorProductos mp = ManejadorProductos.getInstance();
        return mp.quitarCategoria(idCategoria);
    }
    
    @Override
    public boolean seleccionarCategoriaPadre (String padre){
        this.categoriaPadre = padre;
        ManejadorProductos mp = ManejadorProductos.getInstance();
        return mp.esCategoriaPadre(padre);
    }
    
    @Override
    public boolean idCategoriaDisponible(String idCategoria){
        this.idCategoria = idCategoria;
        ManejadorProductos mp = ManejadorProductos.getInstance();
        return mp.idCategoriaDisponible(idCategoria);
    }
    
    @Override
    public void altaCategoria(){
        ManejadorProductos mp = ManejadorProductos.getInstance();
        mp.altaCategoria(this.idCategoria, this.categoriaPadre);
    }
    
    @Override
    public Set<DTMinProveedor> listarProveedores(){
        ManejadorUsuarios mu = ManejadorUsuarios.getInstance();
        return mu.listarProveedores();
    }
    
    @Override
    public void seleccionarProveedor(String nick){
        this.nicknameP = nick;
    }
    
    @Override
    public boolean idServicioDisponible(String idServicio){
        this.dtS = new DTMinServicio(this.nicknameP, idServicio);
        ManejadorProductos mp = ManejadorProductos.getInstance();
        return mp.idServicioDisponible(idServicio, this.nicknameP);
    }
    
    @Override
    public void seleccionarOrigen(DTUbicacion dtU){
        this.origen = dtU;
    }
    
    @Override
    public void seleccionarDestino (DTUbicacion dtU){
        this.destino = dtU;
    }
    
    @Override
    public boolean seleccionarCategoriaSimple(String idCategoria){
        ManejadorProductos mp = ManejadorProductos.getInstance();
        boolean esValida = mp.esCategoriaSimple(idCategoria);
        if (esValida){
            this.listaCategorias.add(idCategoria);
        }
        return esValida;
    }
    
    @Override
    public void altaServicio(String descripcion, float precio, Set<String> imagenes){
        ManejadorProductos mp = ManejadorProductos.getInstance();
        DTServicio serv = new DTServicio(this.dtS.getIdServicio(), descripcion,
                precio, imagenes, this.origen, this.destino);
        mp.altaServicio(serv, this.nicknameP, this.listaCategorias);
    }
    
    @Override
    public Set<String> listarServiciosProveedor(){
        return null;
    }
    
    @Override
    public void agregarServicio(String idServicio){
        
    }
    
    @Override
    public boolean idPromocionDisponible(String idPromocion){
            this.dtP = new DTMinPromocion(this.nicknameP, idPromocion);
            ManejadorProductos mp = ManejadorProductos.getInstance();
            return mp.idPromocionDisponible(idPromocion, this.nicknameP);
    }
    
    @Override
    public void altaPromocion(float descuento){
            ManejadorProductos mp = ManejadorProductos.getInstance();
            mp.altaPromocion(this.dtP.getIdPromocion(), descuento, this.dtP.getNicknameP(), this.listaServicios);
    }
	
}
