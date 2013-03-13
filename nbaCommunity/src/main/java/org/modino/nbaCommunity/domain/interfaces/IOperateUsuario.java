package org.modino.nbaCommunity.domain.interfaces;

import org.modino.nbaCommunity.domain.pojo.Team;
import org.modino.nbaCommunity.domain.pojo.User;

public interface IOperateUsuario {
	
	public void crearEquipo(Team eq);
	public void invitarAmigo(User user);
	

}
