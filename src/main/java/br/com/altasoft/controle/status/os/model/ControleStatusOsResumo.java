package br.com.altasoft.controle.status.os.model;

import java.io.Serializable;

public class ControleStatusOsResumo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String descricao;
	private Integer total;
	
	public ControleStatusOsResumo(String descricao, Integer total){
		this.descricao = descricao;
		this.total = total;
	}
	
	public ControleStatusOsResumo(){
		
	}
	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	
	
	
}
