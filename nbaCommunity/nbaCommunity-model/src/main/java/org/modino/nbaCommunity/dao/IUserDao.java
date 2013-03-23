package org.modino.nbaCommunity.dao;

import java.util.List;

import org.modino.nbaCommunity.domain.pojo.Player;
import org.modino.nbaCommunity.domain.pojo.Team;
import org.modino.nbaCommunity.domain.pojo.User;

public interface IUserDao {
	
	void createTeam(Team team);
	void inviteFriend(User user);
	void betForPlayers(List<Player> players);
	void tradePlayers(List<Player> playes);
	void register(User user);

}
