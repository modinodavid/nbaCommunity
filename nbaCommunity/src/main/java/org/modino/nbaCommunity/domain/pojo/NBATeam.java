package org.modino.nbaCommunity.domain.pojo;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.Lob;

@Named("nbaTeam")
@SessionScoped
public class NBATeam implements Serializable {
	
	private static final long serialVersionUID = -6707510730085926848L;
	private String name;
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] logo;
//	private String urlTeam;	
	
	public NBATeam() {
		super();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public void addNBATeam(NBATeam team){
		
	}

	public void deleteNBATeam(NBATeam team){
		
	}
	
	public void modifyNBATeam(NBATeam team){
		
	}
}
