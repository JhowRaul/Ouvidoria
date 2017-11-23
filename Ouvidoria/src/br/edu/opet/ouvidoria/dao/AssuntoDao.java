package br.edu.opet.ouvidoria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.opet.ouvidoria.jdbc.Conexao;
import br.edu.opet.ouvidoria.model.Assunto;
import br.edu.opet.ouvidoria.util.ExceptionUtil;

public class AssuntoDao {
	private String comandoCreate   = "INSERT INTO ASSUNTO "
            + "(ID, ASSUNTO)"
            + "VALUES (ASSUNTO_SEQ.NEXTVAL,?)";
private String comandoRecovery = "SELECT ID, ASSUNTO "
            + "FROM ASSUNTO "
            + "WHERE ID = ? ";
private String comandoUpdate   = "UPDATE ASSUNTO "
            + "SET ASSUNTO = ? "
            + "WHERE ID = ?";
private String comandoDelete   = "DELETE FROM ASSUNTO "
            + "WHERE ID = ?";
private String comandoSearch   = "SELECT ID, ASSUNTO "
            + "FROM ASSUNTO";

public Assunto create(Assunto pAssunto)
{
try
{
    // Obter a conexão
    Connection tConexao = Conexao.getConexao();

    // Criar o comando
    PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoCreate, new String[] { "ID" });

    // Preencher o comando
    int i = 1;
    tComandoJdbc.setString(i++, pAssunto.getAssunto());

    // Executar o comando
    int tQtd = tComandoJdbc.executeUpdate();

    // Processar o resultado
    if (tQtd == 1)
    {
        // Copiando o parametro
        Assunto tAssunto = pAssunto;

        // Recuperando o código gerado pelo banco de dados
        ResultSet tRsChave = tComandoJdbc.getGeneratedKeys();
        tRsChave.next();

        // Assinalar a chave primária gerada no objeto
        pAssunto.setId(tRsChave.getInt(1));

        // Liberar os recursos
        tRsChave.close();
        tComandoJdbc.close();

        // Retornando o objeto inserido
        return tAssunto;
    }
}
catch (SQLException tExcept)
{
    ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Assunto");
}

// Retorna null indicando algum erro de processamento
return null;
}

public Assunto recovery(int pId)
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
        Assunto tAssunto = recuperarAssunto(tResultSet);

        // Liberar os recursos
        tResultSet.close();
        tComandoJdbc.close();

        // Retornando o objeto inserido
        return tAssunto;
    }
}
catch (SQLException tExcept)
{
    ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Assunto");
}

// Retorna null indicando algum erro de processamento
return null;
}

public Assunto update(Assunto pAssunto)
{
try
{
    // Obter a conexão
    Connection tConexao = Conexao.getConexao();

    // Criar o comando
    PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoUpdate);

    // Preencher o comando
    int i = 1;
    tComandoJdbc.setString(i++, pAssunto.getAssunto());
    tComandoJdbc.setInt(i++, pAssunto.getId());

    // Executar o comando
    int tQtd = tComandoJdbc.executeUpdate();

    // Processar o resultado
    if (tQtd == 1)
    {
        // Copiando o parametro
        Assunto tAssunto = pAssunto;

        // Liberar os recursos
        tComandoJdbc.close();

        // Retornando o objeto inserido
        return tAssunto;
    }
}
catch (SQLException tExcept)
{
    ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Assunto");
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
    ExceptionUtil.mostrarErro(tExcept, "Problemas na remoção do Assunto");
}

// Retorna falso indicando algum erro de processamento
return false;
}

public List<Assunto> search()
{
List<Assunto> tLista = new ArrayList<>();

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
        Assunto tAssunto = recuperarAssunto(tResultSet);

        // Adicionar o o bjeto na lista
        tLista.add(tAssunto);
    }

    // Liberar os recursos
    tResultSet.close();
    tComandoJdbc.close();
}
catch (SQLException tExcept)
{
    ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Assunto");
}

// Retornando a lista de objetos
return tLista;
}

private Assunto recuperarAssunto(ResultSet tResultSet) throws SQLException
{
Assunto tAssunto = new Assunto();

// Recuperando os dados do resultSet
tAssunto.setId(tResultSet.getInt("ID"));
tAssunto.setAssunto(tResultSet.getString("ASSUNTO"));
return tAssunto;
	}

}


