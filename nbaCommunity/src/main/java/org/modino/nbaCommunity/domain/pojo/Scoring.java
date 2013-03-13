package org.modino.nbaCommunity.domain.pojo;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("scoring")
@SessionScoped
public class Scoring implements Serializable{
	
	private static final long serialVersionUID = 7894652533150093463L;
	// El tipo puede ser 'Por defecto' o 'Personalizado'
	private String type;
	private int assists;
	private int offensiveRebouns;
	private int defensiveRebouns;
	private int blocks;
	private int steals;
	private int freeThrows;
	private int freeThrowMakes;
	private int twoPointShots;
	private int twoPointMakes;
	private int threePointShots;
	private int threePointMakes;
	private int turnovers;
	private int personalFoul;
	private int technicalFoul;
	private int teamWin;
	private int teamLose;
	
	public Scoring() {
		super();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAssists() {
		return assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public int getOffensiveRebouns() {
		return offensiveRebouns;
	}

	public void setOffensiveRebouns(int offensiveRebouns) {
		this.offensiveRebouns = offensiveRebouns;
	}

	public int getDefensiveRebouns() {
		return defensiveRebouns;
	}

	public void setDefensiveRebouns(int defensiveRebouns) {
		this.defensiveRebouns = defensiveRebouns;
	}

	public int getBlocks() {
		return blocks;
	}

	public void setBlocks(int blocks) {
		this.blocks = blocks;
	}

	public int getSteals() {
		return steals;
	}

	public void setSteals(int steals) {
		this.steals = steals;
	}

	public int getFreeThrows() {
		return freeThrows;
	}

	public void setFreeThrows(int freeThrows) {
		this.freeThrows = freeThrows;
	}

	public int getFreeThrowMakes() {
		return freeThrowMakes;
	}

	public void setFreeThrowMakes(int freeThrowMakes) {
		this.freeThrowMakes = freeThrowMakes;
	}

	public int getTwoPointShots() {
		return twoPointShots;
	}

	public void setTwoPointShots(int twoPointShots) {
		this.twoPointShots = twoPointShots;
	}

	public int getTwoPointMakes() {
		return twoPointMakes;
	}

	public void setTwoPointMakes(int twoPointMakes) {
		this.twoPointMakes = twoPointMakes;
	}

	public int getThreePointShots() {
		return threePointShots;
	}

	public void setThreePointShots(int threePointShots) {
		this.threePointShots = threePointShots;
	}

	public int getThreePointMakes() {
		return threePointMakes;
	}

	public void setThreePointMakes(int threePointMakes) {
		this.threePointMakes = threePointMakes;
	}

	public int getTurnovers() {
		return turnovers;
	}

	public void setTurnovers(int turnovers) {
		this.turnovers = turnovers;
	}

	public int getPersonalFoul() {
		return personalFoul;
	}

	public void setPersonalFoul(int personalFoul) {
		this.personalFoul = personalFoul;
	}

	public int getTechnicalFoul() {
		return technicalFoul;
	}

	public void setTechnicalFoul(int technicalFoul) {
		this.technicalFoul = technicalFoul;
	}

	public int getTeamWin() {
		return teamWin;
	}

	public void setTeamWin(int teamWin) {
		this.teamWin = teamWin;
	}

	public int getTeamLose() {
		return teamLose;
	}

	public void setTeamLose(int teamLose) {
		this.teamLose = teamLose;
	}
	
	
	
}
