package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Cadastro;
import util.Conexao;

public class CadastroDB {
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;

	public CadastroDB() {
		connection = Conexao.getConnection();
	}

	public boolean inserir(Cadastro cadastro) throws SQLException {

		try {

			PreparedStatement stmt = this.connection
					.prepareStatement("INSERT INTO AGENDA (nome, telefone) values (?, ?)");

			stmt.setString(1, cadastro.getNome());

			stmt.execute();
			return true;

		} catch (SQLException e) {
			System.err.println(e.toString());
		} finally {

			connection.close();

		}
		return false;
	}
	
	public boolean alterar(Cadastro cadastro) throws SQLException {

		try {

			PreparedStatement stmt = this.connection
					.prepareStatement("UPDATE cadastro SET nome = ? WHERE id = ?");

			stmt.setString(1, cadastro.getNome());
            stmt.setInt(2, cadastro.getId());
            
			stmt.execute();
			return true;

		} catch (SQLException e) {
			System.err.println(e.toString());
		} finally {

			connection.close();

		}
		return false;
	}

	public List<Cadastro> getAll() {

		List<Cadastro> lstCadastro = new ArrayList<>();
		try {
			ps = this.connection.prepareStatement("SELECT id, nome FROM cadastro");
			rs = ps.executeQuery();

			while (rs.next()) {
				lstCadastro.add(new Cadastro(rs.getInt("id"), rs.getString("nome")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lstCadastro;
	}
	
	public boolean excluir(int id) throws SQLException {

		try {

			PreparedStatement stmt = this.connection
					.prepareStatement("DELETE FROM cadastro WHERE id =?");

			stmt.setInt(1, id);

			stmt.execute();
			return true;

		} catch (SQLException e) {
			System.err.println(e.toString());
		} finally {

			connection.close();

		}
		return false;
	}
}
