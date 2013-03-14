package org.modino.nbaCommunity.domain.pojo;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Named("player")
@SessionScoped
@Entity
@Table(name="player")
@DynamicInsert(false)
//Solo las columnas modificadas serán actualizadas en tiempo de ejecucion
@DynamicUpdate(true)
public class Player extends NBAPlayer implements Serializable{
	
	private static final long serialVersionUID = 7896864865958680111L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	// Puntuación de la temporada
	private float scoring;
	
	// Promedio de puntos en la temporada
	private float averageScoring;
	
	public Player() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getScoring() {
		return scoring;
	}

	public void setScoring(float scoring) {
		this.scoring = scoring;
	}

	public float getAverageScoring() {
		return averageScoring;
	}

	public void setAverageScoring(float averageScoring) {
		this.averageScoring = averageScoring;
	}
	
}
