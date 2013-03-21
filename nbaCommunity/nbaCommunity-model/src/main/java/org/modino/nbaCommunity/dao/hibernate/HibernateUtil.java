package org.modino.nbaCommunity.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory = null;
	private static Session session = null;
	private static final Logger logger = LoggerFactory.getLogger(HibernateUtil.class);
	
	private static void openSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		// Create the session factory object to connect to the DataSource using JNDI defined in the file 'hibernate-cfg.xml'  
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		logger.info("Creating session factory");
	}

//	private static SessionFactory buildSessionFactory() {
//		 try {
//			 Configuration configuration = new Configuration();
//				configuration.configure();
//			 ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
////			 new SchemaExport(configuration).create(false, true);
//	            // Create the SessionFactory from hibernate.cfg.xml
////			 new SchemaExport(configuration).create(false, true);
//	            return new AnnotationConfiguration()
//	            		.configure()
//	                    .buildSessionFactory(serviceRegistry);
//	        } catch (Throwable ex) {
//	            System.err.println("Initial SessionFactory creation failed." + ex);
//	            throw new ExceptionInInitializerError(ex);
//	        }
//	}
	public static Session getSession() {
		if(sessionFactory == null) {
//			buildSessionFactory();
			openSessionFactory();
		}
		
		if(session == null || !session.isConnected()){
			logger.info("Openning hibernate session");
			session = sessionFactory.openSession();
		}
		else{
			logger.info("Reusing hibernate session");
		}
		return session;
	}
	
	public static void destroySessionFactory() {
		sessionFactory.close();
		session.close();
		session = null;
		sessionFactory = null;
	}
	
}