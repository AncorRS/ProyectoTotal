package com.bezkoder.springjwt.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tabla_borrar")
public class TablaBorrar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer usuario;
	private Integer clave;
	private Integer numero_dias;
	
	public TablaBorrar() {
		super();
	}
	
	public TablaBorrar(Integer id, Integer usuario, Integer clave, Integer numero_dias) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.clave = clave;
		this.numero_dias = numero_dias;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	public Integer getClave() {
		return clave;
	}

	public void setClave(Integer clave) {
		this.clave = clave;
	}

	public Integer getNumero_dias() {
		return numero_dias;
	}

	public void setNumero_dias(Integer numero_dias) {
		this.numero_dias = numero_dias;
	}

}
