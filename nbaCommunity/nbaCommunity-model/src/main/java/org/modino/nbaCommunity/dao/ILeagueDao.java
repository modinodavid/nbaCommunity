package org.modino.nbaCommunity.dao;

import java.util.List;

import org.modino.nbaCommunity.domain.pojo.League;

public interface ILeagueDao {
	List<League> findUserLeagues(String username);
}
