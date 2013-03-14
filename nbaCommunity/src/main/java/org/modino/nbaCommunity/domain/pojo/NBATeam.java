package org.modino.nbaCommunity.domain.pojo;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Named("nbaTeam")
@SessionScoped
@Entity
@Table(name="nbaTeam")
@DynamicInsert(false)
//Solo las columnas modificadas serán actualizadas en tiempo de ejecucion
@DynamicUpdate(true)
public class NBATeam implements Serializable {
	
	private static final long serialVersionUID = -6707510730085926848L;

	//@GeneratedValue(strategy=GenerationType.IDENTITY) -> indica las claves principales para la entidad y crea una columna en la BD para ella
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
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

}
