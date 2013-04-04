package org.modino.nbaCommunityWeb.bll;

import java.util.List;
import org.modino.nbaCommunity.domain.pojo.League;

public interface ILeagueManager {
	List<League> findUserLeagues(String username);
}
