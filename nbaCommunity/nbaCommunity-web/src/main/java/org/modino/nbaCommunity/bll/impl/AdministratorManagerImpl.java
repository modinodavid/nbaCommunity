package org.modino.nbaCommunity.bll.impl;

import org.modino.nbaCommunity.bll.IAdministratorManager;
import org.modino.nbaCommunity.dao.IAdministratorDao;
import org.modino.nbaCommunity.domain.pojo.League;
import org.modino.nbaCommunity.domain.pojo.NBAPlayer;
import org.modino.nbaCommunity.domain.pojo.NBATeam;

public class AdministratorManagerImpl implements IAdministratorManager{

	private IAdministratorDao administratorDao;
	
	public void addNBAPlayer(NBAPlayer player) {
		administratorDao.addNBAPlayer(player);
	}

	public void deleteNBAPlayer(NBAPlayer player) {
		administratorDao.deleteNBAPlayer(player);
	}

	public void updateNBAPlayer(NBAPlayer player) {
		administratorDao.updateNBAPlayer(player);
	}

	public void addNBATeam(NBATeam team) {
		administratorDao.addNBATeam(team);
	}

	public void deleteNBATeam(NBATeam team) {
		administratorDao.deleteNBATeam(team);
	}

	public void updateNBATeam(NBATeam team) {
		administratorDao.updateNBATeam(team);
	}

	public void createLeague(League league) {
		administratorDao.createLeague(league);
	}

}
