package org.modino.nbaCommunity.bll.impl;

import java.util.List;

import org.modino.nbaCommunity.bll.IUserManager;
import org.modino.nbaCommunity.dao.IUserDao;
import org.modino.nbaCommunity.domain.pojo.Player;
import org.modino.nbaCommunity.domain.pojo.Team;
import org.modino.nbaCommunity.domain.pojo.User;

public class UserManagerImpl implements IUserManager {

	private IUserDao userDao;
	
	public void createTeam(Team team) {
		userDao.createTeam(team);
	}

	public void inviteFriend(User user) {
		userDao.inviteFriend(user);
	}

	public void betForPlayers(List<Player> players) {
		userDao.betForPlayers(players);
	}

	public void tradePlayers(List<Player> players) {
		userDao.tradePlayers(players);
	}

	public void register(User user) {
		userDao.register(user);
	}
	

}
