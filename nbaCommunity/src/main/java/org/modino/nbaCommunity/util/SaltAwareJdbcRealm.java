package org.modino.nbaCommunity.util;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SaltedAuthenticationInfo;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.util.SimpleByteSource;
import org.modino.nbaCommunity.sql.db.SqlDBConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

@Component
public class SaltAwareJdbcRealm extends JdbcRealm {

	public static final RandomNumberGenerator RNG = new SecureRandomNumberGenerator();
	private static final Logger log = LoggerFactory.getLogger(SaltAwareJdbcRealm.class);

	@Override
	protected void onInit() {
		super.onInit();
		WebApplicationContext currentWebApplicationContext = ContextLoader.getCurrentWebApplicationContext();
		setDataSource((DataSource) currentWebApplicationContext.getBean("dataSource"));
		log.info("Datasource recuperado desde ContextLoader: " + dataSource);
	}

	@Override
	protected SaltedAuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {
		SimpleByteSource salt = null;
		SimpleAuthenticationInfo result;
		String stringSalt = null;
		ResultSet rs = null;
		
		UsernamePasswordToken credentials = (UsernamePasswordToken)token.getCredentials();
		String username = credentials.getUsername();
		char[] password = credentials.getPassword();
		
		log.info("username " + username);
		log.info("password " + password.toString());
		
		SqlDBConnection sqlDBConnection = SqlDBConnection.getInstance();
		try {
			sqlDBConnection.connect(Constantes.DRIVER_CLASSPATH, Constantes.URL_TEST);
			String sql = "SELECT u FROM user u where username = " + username;
			PreparedStatement preparedStatement = null;
			preparedStatement = sqlDBConnection.createPreparedStatement(sql);
			rs = preparedStatement.executeQuery();
			while(rs.next()){
				try {
					stringSalt = rs.getString("salt");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (ClassNotFoundException e1) {
			log.error("Error driver connection");
		} catch (SQLException e1) {
			log.error("Error database connection");
			e1.printStackTrace();
		}

		log.info("stringSalt " + stringSalt);

		try {
			salt = new SimpleByteSource(Base64.decode(stringSalt));
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
		result = new SimpleAuthenticationInfo(username, password, salt, getName());
		log.info("result " + result);

		return result;
	}

}
