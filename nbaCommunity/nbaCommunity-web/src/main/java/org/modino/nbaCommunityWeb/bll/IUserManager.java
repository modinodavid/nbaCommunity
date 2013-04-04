package org.modino.nbaCommunityWeb.bll;

import java.util.List;

import org.modino.nbaCommunity.domain.pojo.Player;
import org.modino.nbaCommunity.domain.pojo.Team;
import org.modino.nbaCommunity.domain.pojo.User;

public interface IUserManager {
	
	void createTeam(Team team);
	void inviteFriend(User user);
	void betForPlayers(List<Player> players);
	void tradePlayers(List<Player> playes);
	void register(User user);
	User getUserByUsername(String username);

}
