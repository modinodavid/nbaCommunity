package org.modino.nbaCommunity.dao.hibernate;

import java.sql.Types;
import org.hibernate.dialect.MySQL5Dialect;

/**
 * There is a problem with the new Hibernate way of getting the boolean values.
 * To fix this problem the normal MySQL5Dialect is extended and change the 
 * way Hibernate maps the boolean values from MySQL
 * 
 * @author MDISS Java team 2011-2012 University of Deusto
 *
 */
public class NBAMySQL5Dialect extends MySQL5Dialect{ 

	public NBAMySQL5Dialect() {
		super();
		registerColumnType( Types.BOOLEAN, "bit(1)" ); 
	} 
}