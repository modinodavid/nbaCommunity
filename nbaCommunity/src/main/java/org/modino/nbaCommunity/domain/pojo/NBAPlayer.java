package org.modino.nbaCommunity.domain.pojo;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Named("nbaPlayer")
@SessionScoped
@Entity
@Table(name="nbaPlayer")
@DynamicInsert(false)
//Solo las columnas modificadas serán actualizadas en tiempo de ejecucion
@DynamicUpdate(true)
public class NBAPlayer implements Serializable{

	private static final long serialVersionUID = 4323437114868615675L;
	//@GeneratedValue(strategy=GenerationType.IDENTITY) -> indica las claves principales para la entidad y crea una columna en la BD para ella
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String fullName;
	
	private String position;
	
	private float salary;
	
	// Mostrar el equipo nba al que pertenece
	@Transient
	private NBATeam nbaTeam;
	
	public NBAPlayer() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public NBATeam getNbaTeam() {
		return nbaTeam;
	}

	public void setNbaTeam(NBATeam nbaTeam) {
		this.nbaTeam = nbaTeam;
	}
	
}
