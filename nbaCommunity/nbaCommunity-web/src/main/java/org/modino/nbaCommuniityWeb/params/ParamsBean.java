package org.modino.nbaCommuniityWeb.params;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * ParamsBean is a bean with a unique target. The ParamsBean will be used to pass 
 * parameters from one bean to an other. This is managed with Prettyfaces. The data
 * of the URLs will be set in this bean and the other beans will access to this bean
 * to get that parameter
 * 
 *
 */

@RequestScoped
@ManagedBean
public class ParamsBean {
	
	private String userId;
	private int page;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	

}
