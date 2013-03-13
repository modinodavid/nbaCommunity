package org.modino.nbaCommunity.domain.pojo;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("player")
@SessionScoped
public class Player extends NBAPlayer implements Serializable{
	
	private static final long serialVersionUID = 7896864865958680111L;
	// Puntuación de la temporada
	private float scoring;
	
	public Player() {
		super();
	}

	public float getScoring() {
		return scoring;
	}

	public void setScoring(float scoring) {
		this.scoring = scoring;
	}
	
}
