package br.com.altasoft.controle.status.os.exception;

public class ConexaoException extends Exception {

	private static final long serialVersionUID = 1L;

	public ConexaoException(String mensagem, Exception e) {
        super(mensagem, e);
    }

    public ConexaoException(String mensagem) {
        super(mensagem);
    }
}
