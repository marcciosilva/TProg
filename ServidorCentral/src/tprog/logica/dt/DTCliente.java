/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tprog.logica.dt;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class DTCliente extends DTUsuario {

    private Set<DTMinReserva> reservas;

    public DTCliente(String nickname, String password, String nombre, String apellido, String email,
            String imagen, Date fechaN, Set<DTMinReserva> reservas) {
        super(nickname, password, nombre, apellido, email, imagen, fechaN);
        this.reservas = reservas;
    }

    public DTCliente(DTUsuario dtU) {
        super(dtU.nickname, dtU.password, dtU.nombre, dtU.apellido, dtU.email, dtU.imagen, dtU.fechaNacimiento);
        this.reservas = new HashSet<>();
    }

    public Set<DTMinReserva> getReservas() {
        return reservas;
    }

    @Override
    public String toString() {
        String output = super.toString();
        int i = 1;
        for (DTMinReserva dt : reservas) {
            output = output.concat("\n");
            output = output.concat("Reserva " + Integer.toString(i) + "\n");
            output = output.concat(dt.toString());
            i++;
        }
        return output;
    }

    @Override
    public boolean equals(Object o) {
        DTCliente dt = (DTCliente) o;
        return this.reservas.equals(dt.reservas);
    }
}
