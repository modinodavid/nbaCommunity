package org.modino.nbaCommunityWeb.bll.impl;

import java.util.List;

import org.modino.nbaCommunity.dao.ILeagueDao;
import org.modino.nbaCommunity.dao.impl.LeagueDaoImpl;
import org.modino.nbaCommunity.domain.pojo.League;
import org.modino.nbaCommunityWeb.bll.ILeagueManager;

public class LeagueManagerImpl implements ILeagueManager {

	private ILeagueDao leagueDao = new LeagueDaoImpl();
	@Override
	public List<League> findUserLeagues(String username) {
		return leagueDao.findUserLeagues(username);
	}

}
