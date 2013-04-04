package org.modino.nbaCommunityWeb.view.user;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.modino.nbaCommuniityWeb.params.ParamsBean;
import org.modino.nbaCommunity.domain.pojo.League;
import org.modino.nbaCommunity.domain.pojo.User;

@RequestScoped
@ManagedBean
public class DashboardBean {
	private String user;
	private User userObject;
//	private IUserManager userManager;
//	private ILeagueManager leagueManager;
	private List<League> leagues;
	private Map<String, User> users;
	private int page;
	
	public DashboardBean() throws IOException {
//		this.user = getUser();
		ParamsBean pb = getPrettyfacesParams();
		this.page = pb.getPage();
		if (this.page == 0){
			this.page = 1;
		}
	
//		userManager = new UserManagerImpl();
//		leagueManager = new LeagueManagerImpl();
		
		//get current user
//		this.userObject = userManager.getUserByUsername(this.user);
		
		//get all the user leagues		
//		this.leagues = this.leagueManager.findUserLeagues(this.user);
	
	}


	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}

	public Map<String, User> getUsers() {
		return users;
	}


	public void setUsers(Map<String, User> users) {
		this.users = users;
	}

	public List<League> getLeagues() {
		return leagues;
	}


	public void setLeagues(List<League> leagues) {
		this.leagues = leagues;
	}


	public User getUserObject() {
		return userObject;
	}


	public void setUserObject(User userObject) {
		this.userObject = userObject;
	}

//	public String getUser() {
//		return user;
//	}

	public void setUser(String user) {
		this.user = user;
	}

	//TODO: Clean up this class
	//method 1 for getting the user from the session
	public String getUser() {
//		return SecurityContextHolder.getContext().getAuthentication().getName();
		return user;
	}
	
	private ParamsBean getPrettyfacesParams() {
		FacesContext context = FacesContext.getCurrentInstance();
		ParamsBean pb = (ParamsBean) context.getApplication().evaluateExpressionGet(context, "#{paramsBean}", ParamsBean.class);
		return pb;
	}	
	

}
