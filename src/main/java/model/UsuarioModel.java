package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import interfaces.IEntity;

@Entity
public class UsuarioModel implements IEntity{
	
	@Id
	private int id;
	@Column (length = 250, nullable = false)
	private String nome;
	
	public UsuarioModel() {

	}
	
	public UsuarioModel(int id, String nome) {
		
		this.id = id;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	
	
	public Object getPrimaryKey() {
		return getId();
	}

}
