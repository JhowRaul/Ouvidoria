package br.edu.opet.ouvidoria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.opet.ouvidoria.jdbc.Conexao;
import br.edu.opet.ouvidoria.model.Acesso_Funcionario;
import br.edu.opet.ouvidoria.util.ExceptionUtil;

public class Acesso_FuncionarioDao
{
    private String comandoCreate   = "INSERT INTO ACESSO_FUNCIONARIO "
                    + "(LOGIN, SENHA, MATRICULA, NOME, CODIGO) "
                    + "VALUES (ACESSO_FUNCIONARIO_SEQ.NEXTVAL, ?, ?, ?, ?)";

    private String comandoRecovery = "SELECT LOGIN,SENHA, MATRICULA, NOME, CODIGO "
                    + "FROM ACESSO_FUNCIONARIO "
                    + "WHERE LOGIN = ?";
    private String comandoUpdate   = "UPDATE ACESSO_FUNCIONARIO "
                    + "SET SENHA = ?, "
                    + "MATRICULA = ?, "
                    + "NOME = ?, "
                    + "CODIGO = ? "
                    + "WHERE LOGIN = ? ";
    private String comandoDelete   = "DELETE FROM ACESSO_FUNCIONARIO "
                    + "WHERE LOGIN = ?";
    private String comandoSearch   = "SELECT LOGIN,SENHA, MATRICULA, NOME, CODIGO "
                    + "FROM ACESSO_FUNCIONARIO";

    public Acesso_Funcionario create(Acesso_Funcionario pAcesso_Funcionario)
    {
        try
        {
            // Obter a conex�o
            Connection tConexao = Conexao.getConexao();

            // Criar o comando
            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoCreate, new String[] { "LOGIN" });

            // Preencher o comando
            int i = 1;
            tComandoJdbc.setString(i++, pAcesso_Funcionario.getSenha());
            tComandoJdbc.setInt(i++, pAcesso_Funcionario.getMatricula());
            tComandoJdbc.setString(i++, pAcesso_Funcionario.getNome());
            tComandoJdbc.setInt(i++, pAcesso_Funcionario.getCodigo());

            // Executar o comando
            int tQtd = tComandoJdbc.executeUpdate();

            // Processar o resultado
            if (tQtd == 1)
            {
                // Copiando o parametro
                Acesso_Funcionario tAcesso_Funcionario = pAcesso_Funcionario;

                // Recuperando o c�digo gerado pelo banco de dados
                ResultSet tRsChave = tComandoJdbc.getGeneratedKeys();
                tRsChave.next();

                // Assinalar a chave prim�ria gerada no objeto
                pAcesso_Funcionario.setLogin(tRsChave.getInt(1));

                // Liberar os recursos
                tRsChave.close();
                tComandoJdbc.close();

                // Retornando o objeto inserido
                return tAcesso_Funcionario;
            }
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na cria��o do Acesso Funcion�rio");
        }

        // Retorna null indicando algum erro de processamento
        return null;
    }

    public Acesso_Funcionario recovery(int pLogin)
    {
        try
        {
            // Obter a conex�o
            Connection tConexao = Conexao.getConexao();

            // Criar o comando
            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoRecovery);

            // Preencher o comando
            int i = 1;
            tComandoJdbc.setInt(i++, pLogin);

            // Executar o comando
            ResultSet tResultSet = tComandoJdbc.executeQuery();

            // Processar o resultado
            if (tResultSet.next())
            {
                // Criando o objeto
                Acesso_Funcionario tAcesso_Funcionario = recuperarAcesso_Funcionario(tResultSet);

                // Liberar os recursos
                tResultSet.close();
                tComandoJdbc.close();

                // Retornando o objeto inserido
                return tAcesso_Funcionario;
            }
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na cria��o do Acesso Funcionario");
        }

        // Retorna null indicando algum erro de processamento
        return null;
    }

    public Acesso_Funcionario update(Acesso_Funcionario pAcesso_Funcionario)
    {
        try
        {
            // Obter a conex�o
            Connection tConexao = Conexao.getConexao();

            // Criar o comando
            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoUpdate);

            // Preencher o comando
            int i = 1;
            tComandoJdbc.setString(i++, pAcesso_Funcionario.getSenha());
            tComandoJdbc.setInt(i++, pAcesso_Funcionario.getMatricula());
            tComandoJdbc.setString(i++, pAcesso_Funcionario.getNome());
            tComandoJdbc.setInt(i++, pAcesso_Funcionario.getCodigo());
            tComandoJdbc.setInt(i++, pAcesso_Funcionario.getLogin());


            // Executar o comando
            int tQtd = tComandoJdbc.executeUpdate();

            // Processar o resultado
            if (tQtd == 1)
            {
                // Copiando o parametro
                Acesso_Funcionario tAcesso_Funcionario = pAcesso_Funcionario;

                // Liberar os recursos
                tComandoJdbc.close();

                // Retornando o objeto inserido
                return tAcesso_Funcionario;
            }
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na cria��o do Acesso Funcion�rio");
        }

        // Retorna null indicando algum erro de processamento
        return null;
    }

    public boolean delete(int pLogin)
    {
        try
        {
            // Obter a conex�o
            Connection tConexao = Conexao.getConexao();

            // Criar o comando
            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoDelete);

            // Preencher o comando
            int i = 1;
            tComandoJdbc.setInt(i++, pLogin);

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
            ExceptionUtil.mostrarErro(tExcept, "Problemas na remo��o do Acesso Funcionario");
        }

        // Retorna falso indicando algum erro de processamento
        return false;
    }

    public List<Acesso_Funcionario> search()
    {
        List<Acesso_Funcionario> tLista = new ArrayList<>();

        try
        {
            // Obter a conex�o
            Connection tConexao = Conexao.getConexao();

            // Criar o comando
            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoSearch);

            // Executar o comando
            ResultSet tResultSet = tComandoJdbc.executeQuery();

            // Processar o resultado
            while (tResultSet.next())
            {
                Acesso_Funcionario tAcesso_Funcionario = recuperarAcesso_Funcionario(tResultSet);

                // Adicionar o o bjeto na lista
                tLista.add(tAcesso_Funcionario);
            }

            // Liberar os recursos
            tResultSet.close();
            tComandoJdbc.close();
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na cria��o do Acesso Funcionario");
        }

        // Retornando a lista de objetos
        return tLista;
    }

    private Acesso_Funcionario recuperarAcesso_Funcionario(ResultSet tResultSet) throws SQLException
    {
        Acesso_Funcionario tAcesso_Funcionario = new Acesso_Funcionario();

        // Recuperando os dados do resultSet
        tAcesso_Funcionario.setLogin(tResultSet.getInt("LOGIN"));
        tAcesso_Funcionario.setSenha(tResultSet.getString("SENHA"));
        tAcesso_Funcionario.setMatricula(tResultSet.getInt("MATRICULA"));
        tAcesso_Funcionario.setNome(tResultSet.getString("NOME"));
        tAcesso_Funcionario.setCodigo(tResultSet.getInt("CODIGO"));
        return tAcesso_Funcionario;
    }
}
