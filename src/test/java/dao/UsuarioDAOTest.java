package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

import interfaces.IEntity;
import model.UsuarioModel;

public class UsuarioDAOTest {
	
	private UsuarioDAO usuarioDAO = new UsuarioDAO();	
	
	@Test
	public void testarInserir() {
		
		// arrange
		UsuarioModel usuario = new UsuarioModel();
		usuario.setId(1);
		usuario.setNome("João Gilberto");		
		
		// act
		
		usuarioDAO.add(usuario);
		
		IEntity usuario2 = usuarioDAO.listByObject(usuario);
		
		// assert
		
		assertNotNull(usuario);
		assertNotSame(usuario, usuario2);
		assertEquals(usuario, usuario2);
	}
	

}
