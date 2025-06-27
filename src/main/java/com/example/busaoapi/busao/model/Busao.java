package com.example.busaoapi.busao.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data // faz os getters e setters automaticamente
@Table(name = "busoes")
public class Busao {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, unique = true, nullable = false)
	private UUID id;
	
	@NotEmpty(message = "Informe um motorista.")
	@Column(name = "motorista", nullable = false)
	private String motorista;
	@Column(name = "latitude", nullable = false)
	private double latitude;
	@Column(name = "longitude", nullable = false)
	private double longitude;
	
	public Busao(String motorista, double latitude, double longitude) {
		this.motorista = motorista;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Busao() {}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public String getMotorista() {
		return motorista;
	}
	
	public void setMotorista(String motorista) {
		this.motorista = motorista;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
}
