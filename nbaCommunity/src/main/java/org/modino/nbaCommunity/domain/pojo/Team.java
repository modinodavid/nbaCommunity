package org.modino.nbaCommunity.domain.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.Column;
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

@Named("team")
@SessionScoped
@Entity
@Table(name="users")
@DynamicInsert(false)
//Solo las columnas modificadas serán actualizadas en tiempo de ejecucion
@DynamicUpdate(true)

public class Team extends NBATeam implements Serializable {

	private static final long serialVersionUID = 7120245471043503643L;
	
	private static final Logger logger = LoggerFactory.getLogger(Team.class);
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="salary")
	private double currentSalary;
	
	private int maxPlayers; //12 jugadores
	
	@Transient
	private List<Player> players;
	
	public Team() {
		super();
		this.players = new ArrayList<Player>();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public void addPlayer(Player player){
		if(this.players == null){
			this.players = new ArrayList<Player>();
		}
		this.players.add(player);
		logger.info("One player has added to your team");
	}
	
	public void removePlayer(Player player){
		if(this.players != null){
			this.players.remove(player);
			logger.info("The player has removed from your team");
		}
		else{
			logger.info("Unable to remove the player from your team");
		}
	}
}
