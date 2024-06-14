package br.com.servlet.usuarioB;

import br.com.flamingo.bean.Usuario;
import br.com.flamingo.dao.UsuarioDAO;

public class UsuarioB {
	
	private UsuarioA dao = null;

	public Usuario login(Usuario u) {
		dao = new UsuarioA();
		return dao.select(u);
	}
	
	public int cadastrar(Usuario u) {
		if (u.getNome() == null || u.getNome().isEmpty()) {return -1;}
		
		if (u.getNomeUser() == null || u.getNomeUser().isEmpty()) {return -2;}
		 
		if (u.getPassUser() == null || u.getPassUser().isEmpty()) {return -3;}
		
		if (u.getUrlAvatar() == null || u.getUrlAvatar().isEmpty()) {return -4;}

		if (buscarUsuarioPeloUsername(u.getNomeUser()) != null) {return 0;}

		dao = new UsuarioA();
		return dao.insert(u);
	}	
	
	public Usuario buscarUsuarioPeloUsername(String username) {
		if (username == null) { return null; }
		dao = new UsuarioA();
		return dao.selectByUsername(username);
	}
}
