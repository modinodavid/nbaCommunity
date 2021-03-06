package org.modino.nbaCommunity.bll;

import org.modino.nbaCommunity.domain.pojo.League;
import org.modino.nbaCommunity.domain.pojo.NBAPlayer;
import org.modino.nbaCommunity.domain.pojo.NBATeam;


public interface IAdministratorManager {
	
	void addNBAPlayer(NBAPlayer player);
	void deleteNBAPlayer(NBAPlayer player);
	void updateNBAPlayer(NBAPlayer player);
	void addNBATeam(NBATeam team);
	void deleteNBATeam(NBATeam team);
	void updateNBATeam(NBATeam team);
	void createLeague(League league);

}
