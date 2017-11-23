package br.edu.opet.ouvidoria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.opet.ouvidoria.jdbc.Conexao;
import br.edu.opet.ouvidoria.model.Setor;
import br.edu.opet.ouvidoria.util.ExceptionUtil;

public class SetorDao {

	private String comandoCreate   = "INSERT INTO SETOR "
	            + "(ID, NOME)"
	            + "VALUES (SETOR_SEQ.NEXTVAL, ?)";
	private String comandoRecovery = "SELECT ID, NOME "
	            + "FROM SETOR "
	            + "WHERE ID = ?";
	private String comandoUpdate   = "UPDATE SETOR "
	            + "SET NOME = ? "
	            + "WHERE ID = ?";
	private String comandoDelete   = "DELETE FROM SETOR "
	            + "WHERE ID = ?";
	private String comandoSearch   = "SELECT ID, NOME "
	            + "FROM SETOR";

	public Setor create(Setor pSetor)
	{
	try
	{
	    // Obter a conexão
	    Connection tConexao = Conexao.getConexao();

	    // Criar o comando
	    PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoCreate, new String[] { "ID" });

	    // Preencher o comando
	    int i = 1;

	    tComandoJdbc.setString(i++, pSetor.getNome());

	    // Executar o comando
	    int tQtd = tComandoJdbc.executeUpdate();

	    // Processar o resultado
	    if (tQtd == 1)
	    {
	        // Copiando o parametro
	        Setor tSetor = pSetor;

	        // Recuperando o código gerado pelo banco de dados
	        ResultSet tRsChave = tComandoJdbc.getGeneratedKeys();
	        tRsChave.next();

	        // Assinalar a chave primária gerada no objeto
	        pSetor.setId(tRsChave.getInt(1));

	        // Liberar os recursos
	        tRsChave.close();
	        tComandoJdbc.close();

	        // Retornando o objeto inserido
	        return tSetor;
	    }
	}
	catch (SQLException tExcept)
	{
	    ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Setor");
	}

	// Retorna null indicando algum erro de processamento
	return null;
	}

	public Setor recovery(int pId)
	{
	try
	{
	    // Obter a conexão
	    Connection tConexao = Conexao.getConexao();

	    // Criar o comando
	    PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoRecovery);

	    // Preencher o comando
	    int i = 1;
	    tComandoJdbc.setInt(i++, pId);

	    // Executar o comando
	    ResultSet tResultSet = tComandoJdbc.executeQuery();

	    // Processar o resultado
	    if (tResultSet.next())
	    {
	        // Criando o objeto
	        Setor tSetor = recuperarSetor(tResultSet);

	        // Liberar os recursos
	        tResultSet.close();
	        tComandoJdbc.close();

	        // Retornando o objeto inserido
	        return tSetor;
	    }
	}
	catch (SQLException tExcept)
	{
	    ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Setor");
	}

	// Retorna null indicando algum erro de processamento
	return null;
	}

	public Setor update(Setor pSetor)
	{
	try
	{
	    // Obter a conexão
	    Connection tConexao = Conexao.getConexao();

	    // Criar o comando
	    PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoUpdate);

	    // Preencher o comando
	    int i = 1;
	    tComandoJdbc.setString(i++, pSetor.getNome());
	    tComandoJdbc.setInt(i++, pSetor.getId());

	    // Executar o comando
	    int tQtd = tComandoJdbc.executeUpdate();

	    // Processar o resultado
	    if (tQtd == 1)
	    {
	        // Copiando o parametro
	        Setor tSetor = pSetor;

	        // Liberar os recursos
	        tComandoJdbc.close();

	        // Retornando o objeto inserido
	        return tSetor;
	    }
	}
	catch (SQLException tExcept)
	{
	    ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Setor");
	}

	// Retorna null indicando algum erro de processamento
	return null;
	}

	public boolean delete(int pId)
	{
	try
	{
	    // Obter a conexão
	    Connection tConexao = Conexao.getConexao();

	    // Criar o comando
	    PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoDelete);

	    // Preencher o comando
	    int i = 1;
	    tComandoJdbc.setInt(i++, pId);

	    // Executar o comando
	    int tQtd = tComandoJdbc.executeUpdate();

	    // Processar o resultado
	    if (tQtd == 1)
	    {
	        // Liberar os recursos
	        tComandoJdbc.close();

	        // Retornando o indicativo de sucesso
	        return true;
	    }
	}
	catch (SQLException tExcept)
	{
	    ExceptionUtil.mostrarErro(tExcept, "Problemas na remoção do Setor");
	}

	// Retorna falso indicando algum erro de processamento
	return false;
	}

	public List<Setor> search()
	{
	List<Setor> tLista = new ArrayList<>();

	try
	{
	    // Obter a conexão
	    Connection tConexao = Conexao.getConexao();

	    // Criar o comando
	    PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoSearch);

	    // Executar o comando
	    ResultSet tResultSet = tComandoJdbc.executeQuery();

	    // Processar o resultado
	    while (tResultSet.next())
	    {
	        Setor tSetor = recuperarSetor(tResultSet);

	        // Adicionar o o bjeto na lista
	        tLista.add(tSetor);
	    }

	    // Liberar os recursos
	    tResultSet.close();
	    tComandoJdbc.close();
	}
	catch (SQLException tExcept)
	{
	    ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Setor");
	}

	// Retornando a lista de objetos
	return tLista;
	}

	private Setor recuperarSetor(ResultSet tResultSet) throws SQLException
	{
	Setor tSetor = new Setor();

	// Recuperando os dados do resultSet
	tSetor.setId(tResultSet.getInt("ID"));
	tSetor.setNome(tResultSet.getString("Nome"));
	return tSetor;
		}
	}
