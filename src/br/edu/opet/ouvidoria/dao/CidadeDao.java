package br.edu.opet.ouvidoria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.opet.ouvidoria.jdbc.Conexao;
import br.edu.opet.ouvidoria.model.Cidade;
import br.edu.opet.ouvidoria.util.ExceptionUtil;

public class CidadeDao
{

    private String comandoCreate   = "INSERT INTO CIDADE "
                    + "(CODIGO, DESCRICAO, PAIS, ESTADO)"
                    + "VALUES (CIDADE_SEQ.NEXTVAL, ?, ?, ?)";

        private String comandoRecovery = "SELECT CODIGO, DESCRICAO, PAIS, ESTADO "
                    + "FROM CIDADE "
                    + "WHERE CODIGO = ?";

        private String comandoUpdate   = "UPDATE CIDADE "
                    + "SET DESCRICAO = ?,"
                    + "PAIS = ?,"
                    + "ESTADO = ? "
                    + "WHERE CODIGO = ?";

        private String comandoDelete   = "DELETE FROM CIDADE "
                    + "WHERE CODIGO = ?";

        private String comandoSearch   = "SELECT CODIGO, DESCRICAO, PAIS, ESTADO "
                    + "FROM CIDADE ";
        
        private String comandoSearchByEstado   = "SELECT CODIGO, DESCRICAO, PAIS, ESTADO "
                + "FROM CIDADE "
        		+ "WHERE UPPER(ESTADO) LIKE UPPER(?)";

        public Cidade create(Cidade pCidade)
        {
        try
        {
            // Obter a conex�o
            Connection tConexao = Conexao.getConexao();

            // Criar o comando
            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoCreate, new String[] { "CODIGO" });

            // Preencher o comando
            int i = 1;

            tComandoJdbc.setString(i++, pCidade.getDescricao());
            tComandoJdbc.setString(i++, pCidade.getPais());
            tComandoJdbc.setString(i++, pCidade.getEstado());

            // Executar o comando
            int tQtd = tComandoJdbc.executeUpdate();

            // Processar o resultado
            if (tQtd == 1)
            {
                // Copiando o parametro
                Cidade tCidade = pCidade;

                // Recuperando o c�digo gerado pelo banco de dados
                ResultSet tRsChave = tComandoJdbc.getGeneratedKeys();
                tRsChave.next();

                // Assinalar a chave prim�ria gerada no objeto
                pCidade.setCodigo(tRsChave.getInt(1));

                // Liberar os recursos
                tRsChave.close();
                tComandoJdbc.close();

                // Retornando o objeto inserCodigoo
                return tCidade;
            }
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na cria��o do Cidade");
        }

        // Retorna null indicando algum erro de processamento
        return null;
        }

        public Cidade recovery(int pCodigo)
        {
        try
        {
            // Obter a conex�o
            Connection tConexao = Conexao.getConexao();

            // Criar o comando
            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoRecovery);

            // Preencher o comando
            int i = 1;
            tComandoJdbc.setInt(i++, pCodigo);

            // Executar o comando
            ResultSet tResultSet = tComandoJdbc.executeQuery();

            // Processar o resultado
            if (tResultSet.next())
            {
                // Criando o objeto
                Cidade tCidade = recuperarCidade(tResultSet);

                // Liberar os recursos
                tResultSet.close();
                tComandoJdbc.close();

                // Retornando o objeto inserir Codigo
                return tCidade;
            }
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na cria��o do Cidade");
        }

        // Retorna null indicando algum erro de processamento
        return null;
        }

        public Cidade update(Cidade pCidade)
        {
        try
        {
            // Obter a conex�o
            Connection tConexao = Conexao.getConexao();

            // Criar o comando
            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoUpdate);

            // Preencher o comando
            int i = 1;
            tComandoJdbc.setString(i++, pCidade.getDescricao());
            tComandoJdbc.setString(i++, pCidade.getPais());
            tComandoJdbc.setString(i++, pCidade.getEstado());
            tComandoJdbc.setInt(i++, pCidade.getCodigo());

            // Executar o comando
            int tQtd = tComandoJdbc.executeUpdate();

            // Processar o resultado
            if (tQtd == 1)
            {
                // Copiando o parametro
                Cidade tCidade = pCidade;

                // Liberar os recursos
                tComandoJdbc.close();

                // Retornando o objeto inserCodigo
                return tCidade;
            }
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na cria��o do Cidade");
        }

        // Retorna null indicando algum erro de processamento
        return null;
        }

        public boolean delete(int pCodigo)
        {
        try
        {
            // Obter a conex�o
            Connection tConexao = Conexao.getConexao();

            // Criar o comando
            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoDelete);

            // Preencher o comando
            int i = 1;
            tComandoJdbc.setInt(i++, pCodigo);

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
            ExceptionUtil.mostrarErro(tExcept, "Problemas na remo��o do Cidade");
        }

        // Retorna falso indicando algum erro de processamento
        return false;
        }

        public List<Cidade> search()
        {
        List<Cidade> tLista = new ArrayList<>();

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
                Cidade tCidade = recuperarCidade(tResultSet);

                // Adicionar o o bjeto na lista
                tLista.add(tCidade);
            }

            // Liberar os recursos
            tResultSet.close();
            tComandoJdbc.close();
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na cria��o do Cidade");
        }

        // Retornando a lista de objetos
        return tLista;
        }
        
        public List<Cidade> searchByEstado(String pEstado)
        {
            // Acertando o crit�rio de pesquisa
            String tEstado = "%" + pEstado + "%";

            List<Cidade> tLista = new ArrayList<>();

            try
            {
                // Obter a conex�o
                Connection tConexao = Conexao.getConexao();

                // Criar o comando
                PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoSearchByEstado);

                // Preencher o comando
                int i = 1;
                tComandoJdbc.setString(i++, tEstado);

                // Executar o comando
                ResultSet tResultSet = tComandoJdbc.executeQuery();

                // Processar o resultado
                while (tResultSet.next())
                {
                    Cidade tCidade = recuperarCidade(tResultSet);

                    // Adicionar o o bjeto na lista
                    tLista.add(tCidade);
                }

                // Liberar os recursos
                tResultSet.close();
                tComandoJdbc.close();
            }
            catch (SQLException tExcept)
            {
                ExceptionUtil.mostrarErro(tExcept, "Problemas na pesquisa dos m�dicos por estado");
            }

            // Retornando a lista de objetos
            return tLista;
        }

         private Cidade recuperarCidade(ResultSet tResultSet) throws SQLException
        {
            Cidade tCidade = new Cidade();

        // Recuperando os dados do resultSet

        tCidade.setCodigo(tResultSet.getInt("Codigo"));
        tCidade.setDescricao(tResultSet.getString("Descricao"));
        tCidade.setPais(tResultSet.getString("Pais"));
        tCidade.setEstado(tResultSet.getString("Estado"));

        return tCidade;
            }
}
