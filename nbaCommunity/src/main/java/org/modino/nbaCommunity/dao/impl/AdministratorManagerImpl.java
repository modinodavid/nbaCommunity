package org.modino.nbaCommunity.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.modino.nbaCommunity.dao.IAdministratorManager;
import org.modino.nbaCommunity.dao.hibernate.HibernateUtil;
import org.modino.nbaCommunity.domain.pojo.League;
import org.modino.nbaCommunity.domain.pojo.NBAPlayer;
import org.modino.nbaCommunity.domain.pojo.Player;
import org.modino.nbaCommunity.domain.pojo.Team;
import org.modino.nbaCommunity.domain.pojo.User;

public class AdministratorManagerImpl implements IAdministratorManager {

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
		}
	}

	public void deleteNBAPlayer(NBAPlayer player) {
		if(player != null){
			session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.delete(player);
			tx.commit();
		}

	}

	public void modifyNBAPlayer(NBAPlayer player) {
		if(player != null){
			session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.update(player);
			tx.commit();
		}
	}

	public void createLeague(League league) {
		// TODO Auto-generated method stub

	}

	public void createTeam(Team team) {
		// TODO Auto-generated method stub

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

}
