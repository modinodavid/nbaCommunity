package org.modino.nbaCommunity.domain.pojo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
	@Id @NotNull @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idNbaTeam")
	private int id;
	
	@NotNull
	private String name;
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] logo;
//	private String urlTeam;	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy ="nbaTeam")
	private List<NBAPlayer> nbaPlayers;
	
	public NBATeam() {
		super();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<NBAPlayer> getNbaPlayers() {
		return nbaPlayers;
	}

	public void setNbaPlayers(List<NBAPlayer> nbaPlayers) {
		this.nbaPlayers = nbaPlayers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + Arrays.hashCode(logo);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((nbaPlayers == null) ? 0 : nbaPlayers.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NBATeam other = (NBATeam) obj;
		if (id != other.id)
			return false;
		if (!Arrays.equals(logo, other.logo))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nbaPlayers == null) {
			if (other.nbaPlayers != null)
				return false;
		} else if (!nbaPlayers.equals(other.nbaPlayers))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NBATeam [id=" + id + ", name=" + name + ", logo="
				+ Arrays.toString(logo) + ", nbaPlayers=" + nbaPlayers + "]";
	}
	
	
	
}
