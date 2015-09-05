/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.controladores;

import com.tprog.logica.clases.Cliente;
import com.tprog.logica.dt.DTLineaReserva;
import com.tprog.logica.dt.DTMinPromocion;
import com.tprog.logica.dt.DTMinReserva;
import com.tprog.logica.dt.DTMinServicio;
import com.tprog.logica.dt.DTReserva;
import com.tprog.logica.dt.EstadoReserva;
import com.tprog.logica.interfaces.ICtrlReservas;
import com.tprog.logica.manejadores.ManejadorProductos;
import com.tprog.logica.manejadores.ManejadorReservas;
import com.tprog.logica.manejadores.ManejadorUsuarios;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CtrlReservas implements ICtrlReservas {

    private String nickname;
    private String nicknameP;
    private DTMinPromocion dtP;
    private DTMinServicio dtS;
    private DTReserva dtR;
    private int idReserva;
    private Set<DTLineaReserva> lineasReserva;
    private float precioTotal;

    public CtrlReservas() {
        this.nickname = null;
        this.nicknameP = null;
        this.dtP = null;
        this.dtS = null;
        this.dtR = null;
        this.idReserva = -1;
        this.precioTotal = 0;
        this.lineasReserva = new HashSet();
    }

    @Override
    public void seleccionarCliente(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public void seleccionarProveedor(String nicknameP) {
        this.nicknameP = nicknameP;
    }

    @Override
    public Set<DTMinPromocion> listarPromociones() {
        ManejadorProductos mp = ManejadorProductos.getInstance();
        return mp.listarPromociones();
    }

    @Override
    public Set<DTMinServicio> listarServicios() {
        ManejadorProductos mp = ManejadorProductos.getInstance();
        return mp.listarServicios();
    }

    @Override
    public void seleccionarPromocion(DTMinPromocion dtP) {
        this.dtP = dtP;
    }

    @Override
    public void seleccionarServicio(DTMinServicio dtS) {
        this.dtS = dtS;
    }

    @Override
    public void seleccionarDTReserva(DTReserva dtR) {
        this.dtR = dtR;
    }

    @Override
    public void ingresarLineaReserva(int cant, Date fInicial, Date fFinal) {
        ManejadorProductos mp = ManejadorProductos.getInstance();
        if (dtS == null) {
            float precio = mp.getPrecioPromocion(dtP);
            DTLineaReserva dtLR = new DTLineaReserva(cant, fInicial, fFinal, null, dtP.getNicknameP(), precio);
            lineasReserva.add(dtLR);
            precioTotal += precio;
        } else {
            float precio = mp.getPrecioServicio(dtS);
            DTLineaReserva dtLR = new DTLineaReserva(cant, fInicial, fFinal, dtS.getIdServicio(), null, precio);
            lineasReserva.add(dtLR);
            precioTotal += (precio * cant);
        }
    }

    @Override
    public Set<DTMinServicio> listarServiciosProveedor() {
        ManejadorUsuarios mu = ManejadorUsuarios.getInstance();
        return mu.listarServiciosProveedor(nicknameP);
    }

    @Override
    public Set<DTMinPromocion> listarPromocionesProveedor() {
        ManejadorUsuarios mu = ManejadorUsuarios.getInstance();
        return mu.listarPromocionesProveedor(nicknameP);
    }

    @Override
    public DTReserva mostrarReservaTemporal() {
        Date fecha = new Date();
        EstadoReserva estado = EstadoReserva.Registrada;
        DTReserva dtR = new DTReserva(-1, fecha, estado, precioTotal, lineasReserva);
        return dtR;
    }

    @Override
    public void altaReserva() throws Exception {
        ManejadorUsuarios mu = ManejadorUsuarios.getInstance();
        Cliente cliente = mu.getCliente(nickname);
        ManejadorReservas mr = ManejadorReservas.getInstance();
        if (dtS != null) {
            mr.agregarReserva(cliente, dtR, dtS.getNicknameP());
        } else if (dtP != null) {
            mr.agregarReserva(cliente, dtR, dtP.getNicknameP());
        } else {
            throw new Exception("No se seleccionó ningún servicio o promoción");
        }

    }

    @Override
    public Set<DTMinReserva> listarReservas() {
        ManejadorReservas mr = ManejadorReservas.getInstance();
        return mr.listarReservas();
    }

    @Override
    public void seleccionarReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    @Override
    public DTReserva infoReserva() {
        ManejadorReservas mr = ManejadorReservas.getInstance();
        dtR = mr.infoReserva(idReserva);
        return dtR;
    }

    @Override
    public boolean cambiarEstadoReserva(EstadoReserva nuevoEstado) {
        ManejadorReservas mr = ManejadorReservas.getInstance();
        return mr.cambiarEstadoReserva(idReserva, nuevoEstado);
    }

    @Override
    public boolean eliminarReserva() {
        ManejadorReservas mr = ManejadorReservas.getInstance();
        return mr.eliminarReserva(idReserva);
    }

    @Override
    public EstadoReserva getEstadoReserva() {
        ManejadorReservas mr = ManejadorReservas.getInstance();
        return mr.getEstadoReserva(this.idReserva);
    }

    @Override
    public void liberarMemoriaControlador() {
        this.nickname = null;
        this.nicknameP = null;
        this.dtP = null;
        this.dtS = null;
        this.dtR = null;
        this.idReserva = -1;
        this.precioTotal = 0;
        this.lineasReserva = new HashSet();
    }

}
