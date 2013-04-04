package org.modino.nbaCommunityWeb.bll.impl;

import org.modino.nbaCommunity.dao.IAdministratorDao;
import org.modino.nbaCommunity.dao.impl.AdministratorDaoImpl;
import org.modino.nbaCommunity.domain.pojo.League;
import org.modino.nbaCommunity.domain.pojo.NBAPlayer;
import org.modino.nbaCommunity.domain.pojo.NBATeam;
import org.modino.nbaCommunityWeb.bll.IAdministratorManager;

public class AdministratorManagerImpl implements IAdministratorManager{

	private IAdministratorDao administratorDao = new AdministratorDaoImpl();
	
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
