/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.clases;

import java.util.Date;

public class Usuario {

	protected String nickname;
	protected String nombre;
	protected String apellido;
	protected String email;
	protected String imagen;
	protected Date fechaNacimiento;

	public Usuario(String nickname, String nombre, String apellido, String email,
			String imagen, Date fechaN) {
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.imagen = imagen;
		this.fechaNacimiento = fechaN;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getNickname() {
		return nickname;
	}

	public String getEmail() {
		return email;
	}

	public String getImagen() {
		return imagen;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public void setFechaNacimiento(Date fechaN) {
		this.fechaNacimiento = fechaN;
	}

}
