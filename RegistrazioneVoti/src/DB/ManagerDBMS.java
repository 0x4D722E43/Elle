/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author davidedelbuono
 */
public class ManagerDBMS {
    private Connection connection;

	/**
	 * Apre la connessione con il database, bisogna invocare sempre questo metodo se si vuole connettere con il db
	 */
	public void openDb(){
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_universita?user=root&password= ");
		} catch (Exception E) {
			System.err.println("Non trovo il driver da caricare.");
			E.printStackTrace();
		}
	}

	/**
	 * @return la connessione col DBMS
	 */
	public Connection getConnessione(){
		return connection;
	}

	/**
	 * Chiude la connessione con il Database
	 */
	public void close(){
		try {
			connection.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	/**
	 * Esegue una query generica
	 *
	 * @param la query da elaborare
	 * @return il risultato della query
	 * @throws SQLException
	 */
	public ResultSet eseguiQuerySQL(String query) {
		Statement state2 = null;
		try {
			state2 = connection.createStatement();
			state2.executeQuery(query);
			return state2.executeQuery(query);

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Ritorna tutti i valori della colonna desiderata
	 *
	 * @param query per ottenere tutte le tuple della tabella
	 * @param posizione dell'attributo all'interno della tabella. NOTA: l'index parte da 1 e non da 0
	 * @return la lista devi valori contenuti in quell'attributo
	 */
	public List<String> listaValoriPerAttributo(String sql, int indexColonna){
		List<String> chiave = new ArrayList<String>();
		ResultSet set;
		try {
			set = eseguiQuerySQL(sql);
			while (set.next()) {
				chiave.add(set.getString(indexColonna));
			}
			set.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return chiave;
	}

	/**
	 * Esprime il concetto di esistenza di un valore all'interno della tabella
	 * @param tabella in esame dove si vuole cercare il valore
	 * @param posizione dell'attributo nella tabella
	 * @param il valore da verificare
	 * @return true se {@value daVerificare} esiste nella tabella, false se non � presente
	 *
	 */
	public boolean checkEsistenza(String table, int index, String daVerificare){
		List<String> chiave = listaValoriPerAttributo("select * from "+table, index);
		if (chiave.contains(daVerificare)) {
			return true;
		}
		return false;
	}

	/**
	 * Calcola il numero di tuple di una tabella
	 * @param table
	 * @return
	 */
	public int numeroTuple(String table){
		ResultSet ris = eseguiQuerySQL("select count(id) as id from "+table);
		int n = 0;
		try {
			ris.first();
			n = ris.getInt("id");
			ris.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return n;
	}

	/**
	 * Restituisce il numero di tuple quando si vuole effettuare una selezione fra le tuple
	 * @param query
	 * @return il numero tuple
	 */
	public int numeroTupleDaQuery(String query){
		ResultSet ris = eseguiQuerySQL(query);
		int n = 0;
		try {
			ris.first();
			n = ris.getInt("id");
			ris.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return n;
	}

	/**
	 * Ritorna tutte le tuple di una tabella
	 * @param table
	 * @return
	 */
	public ResultSet getAllRow(String table){
		ResultSet set = eseguiQuerySQL("select * from "+table);
		return set;
	}


	/**
	 * Restituisci l'id di una tupla dato una:
	 * @param tabella
	 * @param attributo della tabella
	 * @param valore per la query
	 * @return l'id della tupla di riferimento
	 */
	public int getId(String table, String attributo, String value){
		int id = 0;
		String sql = "select id from "+table+" where "+attributo+" = \""+value +"\"";
		ResultSet set = eseguiQuerySQL(sql);
		try {
			while (set.next()) {
				id = set.getInt("id");
			}
			set.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	/**
	 * Esegue una riga SQL
	 * @param statment SQL da eseguire
	 */
	public boolean eseguiSQL(String sql){
		Statement state2;
		boolean risposta = false;
		try {
			state2 = getConnessione().createStatement();
			risposta = state2.execute(sql);
			state2.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return risposta;
	}
}
