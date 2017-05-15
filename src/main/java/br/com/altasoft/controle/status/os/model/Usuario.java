package br.com.altasoft.controle.status.os.model;

import java.io.Serializable;

public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String cnpj;
	private String senha;
	private String nome;
	private Integer tipo;
	
	public Usuario(Long id, String cnpj, String senha, String nome, Integer tipo) {
		this.id = id;
		this.cnpj = cnpj;
		this.senha = senha;
		this.nome = nome;
		this.tipo = tipo;		
	}
	
	public Usuario() {
		
	}	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public boolean isUsuarioMaster() {		
		return getTipo() == 4 ? true: false;	
	}
	
}

