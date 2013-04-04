package org.modino.nbaCommunity.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.modino.nbaCommunity.dao.ILeagueDao;
import org.modino.nbaCommunity.dao.hibernate.HibernateUtil;
import org.modino.nbaCommunity.domain.pojo.League;
import org.modino.nbaCommunity.domain.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LeagueDaoImpl implements ILeagueDao {

	private static final Logger logger = LoggerFactory.getLogger(LeagueDaoImpl.class);
	private Session session;
	
	@Override
	public List<League> findUserLeagues(String username) {
		List<League> userLeagues = null;
		session = HibernateUtil.getSession();
		Query q = session.createQuery("SELECT l FROM League l WHERE l.user.username = :username");
	    q.setParameter("username", username);
	    if(q.list().size() > 0) {
	    	userLeagues = q.list();
	    	logger.info("a user has been found with the same username");
	    }
	    session.close();
		return userLeagues;
	}

}
