package org.modino.nbaCommunity.domain.pojo;

import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named("league")
@SessionScoped
@Entity
@Table(name="users")
@DynamicInsert(false)
//Solo las columnas modificadas serán actualizadas en tiempo de ejecucion
@DynamicUpdate(true)
public class League implements Serializable {

	private static final long serialVersionUID = 6871943066701739826L;
	private static final Logger logger = LoggerFactory.getLogger(League.class);
	
	// Campos basicos
	//@GeneratedValue(strategy=GenerationType.IDENTITY) -> indica las claves principales para la entidad y crea una columna en la BD para ella
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private Image logo;
	private String password;
	private int maxTeams;
	// Salario inicial para todos los equipos
	private double initialSalaryPerEachTeam;
	// Calificación o reparto de puntos
	@Embedded
	private Scoring scoring;
	
	@Transient
	private List<Team> teams;
	
	public League() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Image getLogo() {
		return logo;
	}

	public void setLogo(Image logo) {
		this.logo = logo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getMaxTeams() {
		return maxTeams;
	}

	public void setMaxTeams(int maxTeams) {
		this.maxTeams = maxTeams;
	}

	public double getInitialSalaryPerEachTeam() {
		return initialSalaryPerEachTeam;
	}

	public void setInitialSalaryPerEachTeam(double initialSalaryPerEachTeam) {
		this.initialSalaryPerEachTeam = initialSalaryPerEachTeam;
	}

	public Scoring getScoring() {
		return scoring;
	}

	public void setScoring(Scoring scoring) {
		this.scoring = scoring;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	
	public void addTeam(Team team){
		if(this.teams == null){
			this.teams = new ArrayList<Team>();
		}
		this.teams.add(team);
		logger.info("One team has added to your league");
	}
	
	public void removePlayer(Team team){
		if(this.teams != null){
			this.teams.remove(team);
			logger.info("The team has removed from your league");
		}
		else{
			logger.info("Unable to remove the team from your league");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		long temp;
		temp = Double.doubleToLongBits(initialSalaryPerEachTeam);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((logo == null) ? 0 : logo.hashCode());
		result = prime * result + maxTeams;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((scoring == null) ? 0 : scoring.hashCode());
		result = prime * result + ((teams == null) ? 0 : teams.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		League other = (League) obj;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(initialSalaryPerEachTeam) != Double
				.doubleToLongBits(other.initialSalaryPerEachTeam))
			return false;
		if (logo == null) {
			if (other.logo != null)
				return false;
		} else if (!logo.equals(other.logo))
			return false;
		if (maxTeams != other.maxTeams)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (scoring == null) {
			if (other.scoring != null)
				return false;
		} else if (!scoring.equals(other.scoring))
			return false;
		if (teams == null) {
			if (other.teams != null)
				return false;
		} else if (!teams.equals(other.teams))
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "League [name=" + name + ", maxTeams=" + maxTeams
				+ ", initialSalaryPerEachTeam=" + initialSalaryPerEachTeam
				+ ", scoring=" + scoring + ", teams=" + teams + "]";
	}
	
	
	
}
