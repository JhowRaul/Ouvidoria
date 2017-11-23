package br.edu.opet.ouvidoria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.opet.ouvidoria.jdbc.Conexao;
import br.edu.opet.ouvidoria.model.Protocolo;
import br.edu.opet.ouvidoria.util.ExceptionUtil;

public class ProtocoloDao
{
    private String comandoCreate   = "INSERT INTO PROTOCOLO "
	                    + "(ID, NUMERO)"
	                    + "VALUES (PROTOCOLO_SEQ.NEXTVAL, ?)";
	    private String comandoRecovery = "SELECT ID, NUMERO "
	                    + "FROM PROTOCOLO "
	                    + "WHERE ID = ?";
	    private String comandoUpdate   = "UPDATE PROTOCOLO "
	                    + "SET NUMERO = ? "
	                    + "WHERE ID = ?";
	    private String comandoDelete   = "DELETE FROM PROTOCOLO "
	                    + "WHERE ID = ?";
	    private String comandoSearch   = "SELECT ID, NUMERO "
	                    + "FROM PROTOCOLO";

	    public Protocolo create(Protocolo pProtocolo)
	    {
	        try
	        {
	            // Obter a conexão
	            Connection tConexao = Conexao.getConexao();

	            // Criar o comando
	            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoCreate, new String[] { "ID" });

	            // Preencher o comando
	            int i = 1;
	            tComandoJdbc.setInt(i++, pProtocolo.getNumero());

	            // Executar o comando
	            int tQtd = tComandoJdbc.executeUpdate();

	            // Processar o resultado
	            if (tQtd == 1)
	            {
	                // Copiando o parametro
	                Protocolo tProtocolo = pProtocolo;

	                // Recuperando o código gerado pelo banco de dados
	                ResultSet tRsChave = tComandoJdbc.getGeneratedKeys();
	                tRsChave.next();

	                // Assinalar a chave primária gerada no objeto
	                pProtocolo.setId(tRsChave.getInt(1));

	                // Liberar os recursos
	                tRsChave.close();
	                tComandoJdbc.close();

	                // Retornando o objeto inserido
	                return tProtocolo;
	            }
	        }
	        catch (SQLException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Protocolo");
	        }

	        // Retorna null indicando algum erro de processamento
	        return null;
	    }


		public Protocolo recovery(int pId)
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
	                Protocolo tProtocolo = recuperarProtocolo(tResultSet);

	                // Liberar os recursos
	                tResultSet.close();
	                tComandoJdbc.close();

	                // Retornando o objeto inserido
	                return tProtocolo;
	            }
	        }
	        catch (SQLException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Protocolo");
	        }

	        // Retorna null indicando algum erro de processamento
	        return null;
	    }

	    public Protocolo update(Protocolo pProtocolo)
	    {
	        try
	        {
	            // Obter a conexão
	            Connection tConexao = Conexao.getConexao();

	            // Criar o comando
	            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoUpdate);

	            // Preencher o comando
	            int i = 1;
	            tComandoJdbc.setInt(i++, pProtocolo.getNumero());
	            tComandoJdbc.setInt(i++, pProtocolo.getId());

	            // Executar o comando
	            int tQtd = tComandoJdbc.executeUpdate();

	            // Processar o resultado
	            if (tQtd == 1)
	            {
	                // Copiando o parametro
	                Protocolo tProtocolo = pProtocolo;

	                // Liberar os recursos
	                tComandoJdbc.close();

	                // Retornando o objeto inserido
	                return tProtocolo;
	            }
	        }
	        catch (SQLException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Protocolo");
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
	            ExceptionUtil.mostrarErro(tExcept, "Problemas na remoção do Protocolo");
	        }

	        // Retorna falso indicando algum erro de processamento
	        return false;
	    }

	    public List<Protocolo> search()
	    {
	        List<Protocolo> tLista = new ArrayList<>();

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
	                Protocolo tProtocolo = recuperarProtocolo(tResultSet);

	                // Adicionar o o bjeto na lista
	                tLista.add(tProtocolo);
	            }

	            // Liberar os recursos
	            tResultSet.close();
	            tComandoJdbc.close();
	        }
	        catch (SQLException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Protocolo");
	        }

	        // Retornando a lista de objetos
	        return tLista;
	    }

	    private Protocolo recuperarProtocolo(ResultSet tResultSet) throws SQLException
	    {
	        Protocolo tProtocolo = new Protocolo();

	        // Recuperando os dados do resultSet
	        tProtocolo.setId(tResultSet.getInt("Id"));
	        tProtocolo.setNumero(tResultSet.getInt("Numero"));
	        return tProtocolo;
	    }

}
