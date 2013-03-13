package org.modino.nbaCommunity.dao;

import java.util.List;

import org.modino.nbaCommunity.domain.pojo.League;
import org.modino.nbaCommunity.domain.pojo.NBAPlayer;
import org.modino.nbaCommunity.domain.pojo.Player;
import org.modino.nbaCommunity.domain.pojo.Team;
import org.modino.nbaCommunity.domain.pojo.User;


public interface IAdministratorManager {
	
	void addNBAPlayer(NBAPlayer player);
	void deleteNBAPlayer(NBAPlayer player);
	void modifyNBAPlayer(NBAPlayer player);
	void createLeague(League league);
	void createTeam(Team team);
	void inviteFriend(User user);
	void betForPlayers(List<Player> players);
	void tradePlayers(List<Player> playes);

}
