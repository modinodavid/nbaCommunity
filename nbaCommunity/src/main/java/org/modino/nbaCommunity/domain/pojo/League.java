package org.modino.nbaCommunity.domain.pojo;

import java.awt.Image;
import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("league")
@SessionScoped
public class League implements Serializable {

	private static final long serialVersionUID = 6871943066701739826L;
	// Campos basicos
	private String name;
	private Image logo;
	private String password;
	private int maxTeams;
	// Salario inicial para todos los equipos
	private double initialSalaryPerEachTeam;
	// Calificación o reparto de puntos
	private Scoring scoring;
	
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
		
	}
	
	public void deleteTeam(Team team){
		
	}
	
	public void modifyTeam(Team team){
		
	}
	
	
}
