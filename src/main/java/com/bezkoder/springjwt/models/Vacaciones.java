package com.bezkoder.springjwt.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "vacaciones")
public class Vacaciones {

	public Vacaciones() {
	}
	
	public Vacaciones(String fecha_ini, String fecha_fin, Integer numero_dias, Integer motivo_cambio,
			String estado_Adm, String estado_Resp, String estado, User user) {
		this.fecha_ini = fecha_ini;
		this.fecha_fin = fecha_fin;
		this.numero_dias = numero_dias;
		this.motivo_cambio = motivo_cambio;
		this.estado_Adm = estado_Adm;
		this.estado_Resp = estado_Resp;
		this.estado = estado;
		this.user = user;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
//	@Temporal(value = TemporalType.DATE)
	private String fecha_ini;
	
//	@Temporal(value = TemporalType.DATE)
	private String fecha_fin;
	
	private Integer numero_dias;
	private Integer motivo_cambio;
	private String estado_Adm;
	private String estado_Resp;
	private String estado;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_key_empleado", referencedColumnName = "id")
	//-------------------------------------PARA EVITAR EL ERROR "hibernateLazyInitializer" HEMOS HECHO ESTE APAÑO!!!!!!!!! --------------------
	//-----------------------------------PERO ES TAN SOLO UN APAÑO, HAY QUE INVESTIGAR COMO SOLUCIONARLO---------------------------------------
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private User user;
	
//	private Integer id_key_empleado;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFecha_ini() {
		return fecha_ini;
	}
	public void setFecha_ini(String fecha_ini) {
		this.fecha_ini = fecha_ini;
	}
	public String getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public Integer getNumero_dias() {
		return numero_dias;
	}
	public void setNumero_dias(Integer numero_dias) {
		this.numero_dias = numero_dias;
	}
	public Integer getMotivo_cambio() {
		return motivo_cambio;
	}
	public void setMotivo_cambio(Integer motivo_cambio) {
		this.motivo_cambio = motivo_cambio;
	}
	public String getEstado_Adm() {
		return estado_Adm;
	}
	public void setEstado_Adm(String estado_Adm) {
		this.estado_Adm = estado_Adm;
	}
	public String getEstado_Resp() {
		return estado_Resp;
	}
	public void setEstado_Resp(String estado_Resp) {
		this.estado_Resp = estado_Resp;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
//	public Integer getId_key_empleado() {
//		return id_key_empleado;
//	}
//	public void setId_key_empleado(Integer id_key_empleado) {
//		this.id_key_empleado = id_key_empleado;
//	}

}
