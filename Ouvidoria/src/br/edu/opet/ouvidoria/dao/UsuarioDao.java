package br.edu.opet.ouvidoria.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.opet.ouvidoria.jdbc.Conexao;
import br.edu.opet.ouvidoria.model.Usuario;
import br.edu.opet.ouvidoria.util.ExceptionUtil;

public class UsuarioDao
{
	private String comandoCreate   = "INSERT INTO USUARIO "
            + "(CPF, NOME, DATA_NASCIMENTO, ENDERECO, EMAIL, TELEFONE, SEXO)"
            + "VALUES (?, ?, ?, ?, ?, ?, ?)";
private String comandoRecovery = "SELECT CPF, NOME, DATA_NASCIMENTO, ENDERECO, EMAIL, TELEFONE, SEXO "
            + "FROM USUARIO "
            + "WHERE CPF = ?";
private String comandoUpdate   = "UPDATE USUARIO "
            + "SET NOME = ?, "
            + "DATA_NASCIMENTO = ?, "
            + "ENDERECO = ?,"
            + "EMAIL = ?,"
            + "TELEFONE = ?,"
            + "SEXO = ? "
            + "WHERE CPF = ? ";
private String comandoDelete   = "DELETE FROM USUARIO "
            + "WHERE CPF = ?";
private String comandoSearch   = "SELECT CPF, NOME, DATA_NASCIMENTO, ENDERECO, EMAIL, TELEFONE, SEXO "
            + "FROM USUARIO";

public Usuario create(Usuario pUsuario)
{
try
{
    // Obter a conexão
    Connection tConexao = Conexao.getConexao();

    // Criar o comando
    PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoCreate);

    // Preencher o comando
    int i = 1;
    tComandoJdbc.setLong(i++, pUsuario.getCpf());
    tComandoJdbc.setString(i++, pUsuario.getNome());
    tComandoJdbc.setDate(i++, Date.valueOf(pUsuario.getDataNascimento()));
    tComandoJdbc.setString(i++, pUsuario.getEndereco());
    tComandoJdbc.setString(i++, pUsuario.getEmail());
    tComandoJdbc.setLong(i++, pUsuario.getTelefone());
    tComandoJdbc.setString(i++, pUsuario.getSexo());

    // Executar o comando
    int tQtd = tComandoJdbc.executeUpdate();

    // Processar o resultado
    if (tQtd == 1)
    {
        // Copiando o parametro
        Usuario tUsuario = pUsuario;

        // Liberar os recursos
        tComandoJdbc.close();

        // Retornando o objeto inserido
        return tUsuario;
    }
}
catch (SQLException tExcept)
{
    ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do USUARIO");
}

// Retorna null indicando algum erro de processamento
return null;
}


public Usuario recoveryByCpf(long pCpf)
{
try
{
    // Obter a conexão
    Connection tConexao = Conexao.getConexao();

    // Criar o comando
    PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoRecovery);

    // Preencher o comando
    int i = 1;
    tComandoJdbc.setLong(i++, pCpf);

    // Executar o comando
    ResultSet tResultSet = tComandoJdbc.executeQuery();

    // Processar o resultado
    if (tResultSet.next())
    {
        // Criando o objeto
    	Usuario tUsuario = recuperarUsuario(tResultSet);

        // Liberar os recursos
        tResultSet.close();
        tComandoJdbc.close();

        // Retornando o objeto inserido
        return tUsuario;
    }
}
catch (SQLException tExcept)
{
    ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do USUARIO");
}

// Retorna null indicando algum erro de processamento
return null;
}

public Usuario update(Usuario pUsuario)
{
try
{
    // Obter a conexão
    Connection tConexao = Conexao.getConexao();

    // Criar o comando
    PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoUpdate);

    // Preencher o comando
    int i = 1;
    tComandoJdbc.setString(i++, pUsuario.getNome());
    tComandoJdbc.setDate(i++, Date.valueOf(pUsuario.getDataNascimento()));
    tComandoJdbc.setString(i++, pUsuario.getEndereco());
    tComandoJdbc.setString(i++, pUsuario.getEmail());
    tComandoJdbc.setLong(i++, pUsuario.getTelefone());
    tComandoJdbc.setString(i++, pUsuario.getSexo());
    tComandoJdbc.setLong(i++, pUsuario.getCpf());


    // Executar o comando
    int tQtd = tComandoJdbc.executeUpdate();

    // Processar o resultado
    if (tQtd == 1)
    {
        // Copiando o parametro
    	Usuario tUsuario = pUsuario;

        // Liberar os recursos
        tComandoJdbc.close();

        // Retornando o objeto inserido
        return tUsuario;
    }
}
catch (SQLException tExcept)
{
    ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do USUARIO");
}

// Retorna null indicando algum erro de processamento
return null;
}

public boolean delete(long pCpf)
{
try
{
    // Obter a conexão
    Connection tConexao = Conexao.getConexao();

    // Criar o comando
    PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoDelete);

    // Preencher o comando
    int i = 1;
    tComandoJdbc.setLong(i++, pCpf);

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
    ExceptionUtil.mostrarErro(tExcept, "Problemas na remoção do USUARIO");
}

// Retorna falso indicando algum erro de processamento
return false;
}

public List<Usuario> search()
{
List<Usuario> tLista = new ArrayList<>();

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
    	Usuario tUsuario = recuperarUsuario(tResultSet);

        // Adicionar o o bjeto na lista
        tLista.add(tUsuario);
    }

    // Liberar os recursos
    tResultSet.close();
    tComandoJdbc.close();
}
catch (SQLException tExcept)
{
    ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do USUARIO");
}

// Retornando a lista de objetos
return tLista;
}

private Usuario recuperarUsuario(ResultSet tResultSet) throws SQLException
{
	Usuario tUsuario = new Usuario();

// Recuperando os dados do resultSet
tUsuario.setCpf(tResultSet.getLong("CPF"));
tUsuario.setNome(tResultSet.getString("NOME"));
tUsuario.setDataNascimento(tResultSet.getDate("DATA_NASCIMENTO").toLocalDate());
tUsuario.setEndereco(tResultSet.getString("ENDERECO"));
tUsuario.setEmail(tResultSet.getString("EMAIL"));
tUsuario.setTelefone(tResultSet.getLong("TELEFONE"));
tUsuario.setSexo(tResultSet.getString("SEXO"));

return tUsuario;
}

}


