package org.modino.nbaCommunity.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.modino.nbaCommunity.dao.IUserDao;
import org.modino.nbaCommunity.dao.hibernate.HibernateUtil;
import org.modino.nbaCommunity.domain.pojo.Player;
import org.modino.nbaCommunity.domain.pojo.Team;
import org.modino.nbaCommunity.domain.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDaoImpl implements IUserDao {

	private static final Logger logger = LoggerFactory.getLogger(AdministratorDaoImpl.class);
	private Session session;
	
	public void createTeam(Team team) {
		if(team != null){
			session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.save(team);
			tx.commit();
			logger.info("NBA player has been added to the table team in database");
		}
	}

	public void inviteFriend(User user) {
		// TODO Auto-generated method stub

	}

	public void betForPlayers(List<Player> players) {
		// TODO Auto-generated method stub

	}

	public void tradePlayers(List<Player> playes) {
		// TODO Auto-generated method stub

	}

	public void register(User user) {
		// TODO Auto-generated method stub
		
	}
	

}
