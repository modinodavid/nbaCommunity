package org.modino.nbaCommunity.dao;

import java.util.List;

import org.modino.nbaCommunity.domain.pojo.Player;
import org.modino.nbaCommunity.domain.pojo.Team;
import org.modino.nbaCommunity.domain.pojo.User;

public interface IUserManager {
	
	public void createTeam(Team team);
	public void inviteFriend(User user);
	public void betForPlayers(List<Player> players);
	public void tradePlayers(List<Player> playes);

}
