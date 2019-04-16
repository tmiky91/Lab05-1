package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class AnagrammiDAO {
	
	public boolean isCorrect(String anagramma) {
		final String sql = "select nome from parola where nome=?";
		boolean result;

		

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, anagramma);

			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				result=true;

			}
			else {
				result=false;
			}
			conn.close();

			return result;

		} catch (SQLException e) {
			throw new RuntimeException("Errore Db");
		}
	}

}
