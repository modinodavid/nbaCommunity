package org.modino.nbaCommunity.domain.pojo;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Named("nbaPlayer")
@SessionScoped
@Entity
@Table(name="nbaPlayer")
@DynamicInsert(false)
//Solo las columnas modificadas serán actualizadas en tiempo de ejecucion
@DynamicUpdate(true)
public class NBAPlayer implements Serializable{

	private static final long serialVersionUID = 4323437114868615675L;
	//@GeneratedValue(strategy=GenerationType.IDENTITY) -> indica las claves principales para la entidad y crea una columna en la BD para ella
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idNbaPlayer")
	private int id;
	
	private String fullName;
	
	private String position;
	
	private float salary;
	
	// Mostrar el equipo nba al que pertenece
	@ManyToOne @JoinColumn(name="idNbaTeam")
	private NBATeam nbaTeam;
	
	@Transient
	private Player player;
	
	public NBAPlayer() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public NBATeam getNbaTeam() {
		return nbaTeam;
	}

	public void setNbaTeam(NBATeam nbaTeam) {
		this.nbaTeam = nbaTeam;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + id;
		result = prime * result + ((nbaTeam == null) ? 0 : nbaTeam.hashCode());
		result = prime * result + ((player == null) ? 0 : player.hashCode());
		result = prime * result
				+ ((position == null) ? 0 : position.hashCode());
		result = prime * result + Float.floatToIntBits(salary);
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
		NBAPlayer other = (NBAPlayer) obj;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (id != other.id)
			return false;
		if (nbaTeam == null) {
			if (other.nbaTeam != null)
				return false;
		} else if (!nbaTeam.equals(other.nbaTeam))
			return false;
		if (player == null) {
			if (other.player != null)
				return false;
		} else if (!player.equals(other.player))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (Float.floatToIntBits(salary) != Float.floatToIntBits(other.salary))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NBAPlayer [id=" + id + ", fullName=" + fullName + ", position="
				+ position + ", salary=" + salary + ", nbaTeam=" + nbaTeam
				+ ", player=" + player + "]";
	}
	
	
	
}
