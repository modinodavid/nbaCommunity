package org.modino.nbaCommunity.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.modino.nbaCommunity.dao.IAdministratorManager;
import org.modino.nbaCommunity.dao.hibernate.HibernateUtil;
import org.modino.nbaCommunity.domain.pojo.League;
import org.modino.nbaCommunity.domain.pojo.NBAPlayer;
import org.modino.nbaCommunity.domain.pojo.NBATeam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdministratorManagerImpl extends UserManagerImpl implements IAdministratorManager {

	private static final Logger logger = LoggerFactory.getLogger(AdministratorManagerImpl.class);
	
	private Session session;
	
	public AdministratorManagerImpl() {
		super();
	}
		
	public void addNBAPlayer(NBAPlayer player) {
		if(player != null){
			session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.save(player);
			tx.commit();
			logger.info("A new NBA player has been added in to the table nbaPlayer in database");
		}
	}

	public void deleteNBAPlayer(NBAPlayer player) {
		if(player != null){
			session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.delete(player);
			tx.commit();
			logger.info("A NBA player has been removed from the table nbaPlayer in database");
		}

	}

	public void updateNBAPlayer(NBAPlayer player) {
		if(player != null){
			session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.update(player);
			tx.commit();
			logger.info("A NBA player has been updated in to the table nbaPlayer in database");
		}
	}

	public void createLeague(League league) {
		if(league != null){
			session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.save(league);
			tx.commit();
			logger.info("The league has been created in to the table league in database");
		}
	}

	public void addNBATeam(NBATeam team) {
		if(team != null){
			session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.save(team);
			tx.commit();
			logger.info("A NBA Team has been created in to the table nbaTeam in database");
		}
		
	}

	public void deleteNBATeam(NBATeam team) {
		if(team != null){
			session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.save(team);
			tx.commit();
			logger.info("A NBA Team has been removed from the table nbaTeam in database");
		}
		
	}

	public void updateNBATeam(NBATeam team) {
		if(team != null){
			session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.save(team);
			tx.commit();
			logger.info("A NBA Team has been updated in to the table nbaTeam in database");
		}
		
	}

}
