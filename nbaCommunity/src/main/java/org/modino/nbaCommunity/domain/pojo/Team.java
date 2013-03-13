package org.modino.nbaCommunity.domain.pojo;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("team")
@SessionScoped
public class Team extends NBATeam implements Serializable {

	private static final long serialVersionUID = 7120245471043503643L;
	private double currentSalary;
	private int maxPlayers; //12 jugadores
	private List<Player> players;
	
	public Team() {
		super();
	}

	public double getCurrentSalary() {
		return currentSalary;
	}

	public void setCurrentSalary(double currentSalary) {
		this.currentSalary = currentSalary;
	}

	public int getMaxPlayers() {
		return maxPlayers;
	}

	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	
}
