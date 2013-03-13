package org.modino.nbaCommunity.domain.pojo;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("nbaPlayer")
@SessionScoped
public class NBAPlayer implements Serializable{

	private static final long serialVersionUID = 4323437114868615675L;
	private String fullName;
	private String position;
	private float salary;
	// Mostrar el equipo nba al que pertenece
	private NBATeam nbaTeam;
	
	public NBAPlayer() {
		super();
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
