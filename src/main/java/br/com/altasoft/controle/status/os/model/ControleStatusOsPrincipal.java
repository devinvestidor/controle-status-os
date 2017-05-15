package br.com.altasoft.controle.status.os.model;

import java.io.Serializable;

public class ControleStatusOsPrincipal implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer ordem;
	private String placa;
	private String renavam;
	private String descricao;
	private String tipoOrdem;
	private String pessoa;
	private String cidade;	
	
	public ControleStatusOsPrincipal(Integer ordem, String placa, String renavam, String descricao, String tipoOrdem,
			String pessoa, String cidade) {		
		this.ordem = ordem;
		this.placa = placa;
		this.renavam = renavam;
		this.descricao = descricao;
		this.tipoOrdem = tipoOrdem;
		this.pessoa = pessoa;
		this.cidade = cidade;
	}
	
	public ControleStatusOsPrincipal() {
		
	}
	
	
	public Integer getOrdem() {
		return ordem;
	}
	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getRenavam() {
		return renavam;
	}
	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTipoOrdem() {
		return tipoOrdem;
	}
	public void setTipoOrdem(String tipoOrdem) {
		this.tipoOrdem = tipoOrdem;
	}
	public String getPessoa() {
		return pessoa;
	}
	public void setPessoa(String pessoa) {
		this.pessoa = pessoa;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	
	

	
}
