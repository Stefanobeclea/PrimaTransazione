package it.prova.test;

import it.prova.connection.MyConnection;
import java.sql.*;

public class TestTransazioni {
	public static void main(String[] args) {
		
		//eseguo la transazione facendo un insert into
		try(Connection c = MyConnection.getConnection();) {
			c.setAutoCommit(false);
			Statement statement = c.createStatement();
			statement.executeUpdate("insert into regista(nome, cognome) Values('Francesco','Totti')");
			c.commit();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
