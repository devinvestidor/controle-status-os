package br.com.altasoft.controle.status.os.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import br.com.altasoft.controle.status.os.exception.ConexaoException;

public class ConnectionManager {

	private static final String STR_DRIVER = "org.firebirdsql.jdbc.FBDriver";
	private static final String DATABASE = "C:/Altasoft/dados/alta_compact.fdb";
	private static final String IP = "localhost";
	private static final String STR_CON = "jdbc:firebirdsql:" + IP + "/3050:" + DATABASE;
	private static final String USER = "SYSDBA";
	private static final String PASSWORD = "masterkey";

	public static void closeAll(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeAll(Connection conn, Statement stmt) {
		try {
			if (conn != null) {
				closeAll(conn);
			}
			if (stmt != null) {
				stmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeAll(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (conn != null || stmt != null) {
				closeAll(conn, stmt);
			}
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConexao() throws ConexaoException {
		Connection conn = null;
		try {
			Class.forName(STR_DRIVER);
			Properties props = new Properties();
			props.put("user", USER);
			props.put("password", PASSWORD);
			props.put("charset", "UTF8");
			props.put("lc_ctype", "ISO8859_1");
			conn = DriverManager.getConnection(STR_CON, props);
			System.out.println("[ConnectionManager]: Obtendo conexao");
			return conn;
		} catch (ClassNotFoundException e) {
			String errorMsg = "Driver nao encontrado";
			throw new ConexaoException(errorMsg, e);
		} catch (SQLException e) {
			String errorMsg = "Erro ao obter a conexao";
			throw new ConexaoException(errorMsg, e);
		}
	}
}
