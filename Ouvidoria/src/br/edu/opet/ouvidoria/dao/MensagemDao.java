package br.edu.opet.ouvidoria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.edu.opet.ouvidoria.jdbc.Conexao;
import br.edu.opet.ouvidoria.model.Mensagem;
import br.edu.opet.ouvidoria.util.ExceptionUtil;

public class MensagemDao
{

    private String comandoCreate                    = "INSERT INTO MENSAGEM "
                    + "(ID, ID_PROTOCOLO, ID_ASSUNTO, ID_SETOR, CPF, NOME, LOGIN, DATA_MENSAGEM, STATUS, CONTEUDO) "
                    + "VALUES (MENSAGEM_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?,?,?,?)";
    private String comandoRecovery                  = "SELECT ID, ID_PROTOCOLO, ID_ASSUNTO, ID_SETOR, CPF,LOGIN, NOME, DATA_MENSAGEM, STATUS, CONTEUDO "
                    + "FROM MENSAGEM "
                    + "WHERE ID = ? ";
    private String comandoUpdate                    = "UPDATE MENSAGEM "
                    + "SET ID_PROTOCOLO = ?, "
                    + "ID_ASSUNTO = ?,"
                    + "ID_SETOR = ?,"
                    + "CPF = ?,"
                    + "LOGIN = ?,"
                    + "NOME = ?,"
                    + "DATA_MENSAGEM = ?,"
                    + "STATUS = ?, "
                    + "CONTEUDO = ? "
                    + "WHERE ID = ? ";
    private String comandoDelete                    = "DELETE FROM MENSAGEM "
                    + "WHERE ID = ?";
    private String comandoSearch                    = "SELECT ID, ID_PROTOCOLO, ID_ASSUNTO, ID_SETOR, CPF, LOGIN, NOME, DATA_MENSAGEM, STATUS, CONTEUDO "
                    + "FROM MENSAGEM";
    private String comandoSearchByUsuario           = "SELECT ID, ID_PROTOCOLO, ID_ASSUNTO, ID_SETOR, CPF,LOGIN,NOME, DATA_MENSAGEM, STATUS, CONTEUDO "
                    + "FROM MENSAGEM "
                    + "WHERE CPF = ? ";
    private String comandoSearchByData_Mensagem     = "SELECT ID, ID_PROTOCOLO, ID_ASSUNTO, ID_SETOR, CPF,LOGIN,NOME, DATA_MENSAGEM, STATUS, CONTEUDO "
                    + "FROM MENSAGEM "
                    + "WHERE TRUNC(DATA_MENSAGEM) = ?";
    private String comandoCountByAssunto            = "SELECT COUNT(ID_ASSUNTO) "
                    + "FROM ASSUNTO "
                    + "WHERE ID_ASSUNTO = ?";
    private String comandoCountByResposta           = "SELECT COUNT(ID_RESPOSTA) "
                    + "FROM RESPOSTA "
                    + "WHERE ID_RESPOSTA = ?";
    private String comandoCountByCidade             = "SELECT COUNT(CODIGO) "
                    + "FROM MENSAGEM "
                    + "WHERE CODIGO = ?";
    private String comandoCountByMensagem           = "SELECT COUNT(ID_MENSAGEM) "
                    + "FROM MENSAGEM "
                    + "WHERE ID_MENSAGEM = ?";
    private String comandoCountByUsuario            = "SELECT COUNT(CPF) "
                    + "FROM USUARIO "
                    + "WHERE CPF = ?";
    private String comandoCountBySetor              = "SELECT COUNT(ID_SETOR) "
                    + "FROM SETOR "
                    + "WHERE ID_SETOR = ?";
    private String comandoCountByProtocolo          = "SELECT COUNT(ID_PROTOCOLO) "
                    + "FROM PROTOCOLO "
                    + "WHERE ID_PTOTOCOLO = ?";
    private String comandoCountByAcesso_Funcionario = "SELECT COUNT(LOGIN) "
                    + "FROM MENSAGEM "
                    + "WHERE LOGIN = ?";

    public Mensagem create(Mensagem pMensagem)
    {
        try
        {
            // Obter a conex�o
            Connection tConexao = Conexao.getConexao();

            // Criar o comando
            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoCreate, new String[] { "ID" });

            // Preencher o comando
//ID, ID_PROTOCOLO, ID_ASSUNTO, ID_SETOR, CPF, NOME, LOGIN, DATA_MENSAGEM, STATUS, CONTEUDO
            int i = 1;
            tComandoJdbc.setInt(i++, pMensagem.getId_Protocolo());
            tComandoJdbc.setInt(i++, pMensagem.getId_Assunto());
            tComandoJdbc.setInt(i++, pMensagem.getId_Setor());
            tComandoJdbc.setLong(i++, pMensagem.getCpf());
            tComandoJdbc.setString(i++, pMensagem.getNome());
            tComandoJdbc.setInt(i++, pMensagem.getLogin());
            tComandoJdbc.setTimestamp(i++, new Timestamp(pMensagem.getData_Mensagem().getTime()));
            tComandoJdbc.setString(i++, pMensagem.getStatus());
            tComandoJdbc.setString(i++, pMensagem.getConteudo());

            // Executar o comando
            int tQtd = tComandoJdbc.executeUpdate();

            // Processar o resultado
            if (tQtd == 1)
            {
                // Copiando o parametro
                Mensagem tMensagem = pMensagem;

                // Recuperando o c�digo gerado pelo banco de dados
                ResultSet tRsChave = tComandoJdbc.getGeneratedKeys();
                tRsChave.next();

                // Assinalar a chave prim�ria gerada no objeto
                pMensagem.setId(tRsChave.getInt(1));

                // Liberar os recursos
                tRsChave.close();
                tComandoJdbc.close();

                // Retornando o objeto inserido
                return tMensagem;
            }
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na cria��o do Acesso Funcion�rio");
        }

        // Retorna null indicando algum erro de processamento
        return null;
    }

    public Mensagem recovery(int pId)
    {
        try
        {
            // Obter a conex�o
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
                Mensagem tMensagem = recuperarMensagem(tResultSet);

                // Liberar os recursos
                tResultSet.close();
                tComandoJdbc.close();

                // Retornando o objeto inserido
                return tMensagem;
            }
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na cria��o do Mensagem");
        }

        // Retorna null indicando algum erro de processamento
        return null;
    }

    public Mensagem update(Mensagem pMensagem)
    {
        try
        {
            // Obter a conex�o
            Connection tConexao = Conexao.getConexao();

            // Criar o comando
            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoUpdate);

            // Preencher o comando
            int i = 1;

            tComandoJdbc.setInt(i++, pMensagem.getId_Protocolo());
            tComandoJdbc.setInt(i++, pMensagem.getId_Assunto());
            tComandoJdbc.setInt(i++, pMensagem.getId_Setor());
            tComandoJdbc.setLong(i++, pMensagem.getCpf());
            tComandoJdbc.setInt(i++, pMensagem.getLogin());
            tComandoJdbc.setString(i++, pMensagem.getNome());
            tComandoJdbc.setTimestamp(i++, new Timestamp(pMensagem.getData_Mensagem().getTime()));
            tComandoJdbc.setString(i++, pMensagem.getStatus());
            tComandoJdbc.setString(i++, pMensagem.getConteudo());
            tComandoJdbc.setInt(i++, pMensagem.getId());

            // Executar o comando
            int tQtd = tComandoJdbc.executeUpdate();

            // Processar o resultado
            if (tQtd == 1)
            {
                // Copiando o parametro
                Mensagem tMensagem = pMensagem;

                // Liberar os recursos
                tComandoJdbc.close();

                // Retornando o objeto inserido
                return tMensagem;
            }
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na cria��o do Acesso Funcion�rio");
        }

        // Retorna null indicando algum erro de processamento
        return null;
    }

    public boolean delete(int pId)
    {
        try
        {
            // Obter a conex�o
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
            ExceptionUtil.mostrarErro(tExcept, "Problemas na remo��o do Mensagem");
        }

        // Retorna falso indicando algum erro de processamento
        return false;
    }

    public List<Mensagem> search()
    {
        List<Mensagem> tLista = new ArrayList<>();

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
                Mensagem tMensagem = recuperarMensagem(tResultSet);

                // Adicionar o o bjeto na lista
                tLista.add(tMensagem);
            }

            // Liberar os recursos
            tResultSet.close();
            tComandoJdbc.close();
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na cria��o do Mensagem");
        }

        // Retornando a lista de objetos
        return tLista;
    }

    public List<Mensagem> searchByUsuario(long pCpf)
    {
        List<Mensagem> tLista = new ArrayList<>();
        Long tUsuario = pCpf;

        try
        {
            // Obter a conex�o
            Connection tConexao = Conexao.getConexao();

            // Criar o comando
            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoSearchByUsuario);

            // Preencher o comando
            int i = 1;
            tComandoJdbc.setLong(i++, tUsuario);

            // Executar o comando
            ResultSet tResultSet = tComandoJdbc.executeQuery();

            // Processar o resultado
            while (tResultSet.next())
            {
                Mensagem tMensagem = recuperarMensagem(tResultSet);

                // Adicionar o o bjeto na lista
                tLista.add(tMensagem);
            }

            // Liberar os recursos
            tResultSet.close();
            tComandoJdbc.close();
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas encontrar usuario");
        }

        // Retornando a lista de objetos
        return tLista;
    }

    public List<Mensagem> searchByData_Mensagem(Date pData_Mensagem)
    {

        List<Mensagem> tLista = new ArrayList<>();

        try
        {

            // Obter a conex�o
            Connection tConexao = Conexao.getConexao();

            // Criar o comando
            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoSearchByData_Mensagem);

            // Preencher o comando
            int i = 1;
            tComandoJdbc.setDate(i++, new java.sql.Date(pData_Mensagem.getTime()));

            // Executar o comando
            ResultSet tResultSet = tComandoJdbc.executeQuery();

            // Processar o resultado
            while (tResultSet.next())
            {
                Mensagem tMensagem = recuperarMensagem(tResultSet);

                // Adicionar o o bjeto na lista
                tLista.add(tMensagem);
            }

            // Liberar os recursos
            tResultSet.close();
            tComandoJdbc.close();
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na pesquisa das consultas");
        }

        // Retornando a lista de objetos
        return tLista;
    }

    public int countByAssunto(int pIdAssunto)
    {
        int tQtde = 0;

        try
        {
            // Obter a conex�o
            Connection tConexao = Conexao.getConexao();

            // Criar o comando
            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoCountByAssunto);

            // Preencher o comando
            int i = 1;
            tComandoJdbc.setInt(i++, pIdAssunto);

            // Executar o comando
            ResultSet tResultSet = tComandoJdbc.executeQuery();

            // Processar o resultado
            tResultSet.next();
            tQtde = tResultSet.getInt(1);

            // Liberar os recursos
            tResultSet.close();
            tComandoJdbc.close();

        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na contagem das Assunto");
        }

        // Retornando a lista de objetos
        return tQtde;
    }

    public int countByResposta(int pIdResposta)
    {
        int tQtde = 0;

        try
        {
            // Obter a conex�o
            Connection tConexao = Conexao.getConexao();

            // Criar o comando
            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoCountByResposta);

            // Preencher o comando
            int i = 1;
            tComandoJdbc.setInt(i++, pIdResposta);

            // Executar o comando
            ResultSet tResultSet = tComandoJdbc.executeQuery();

            // Processar o resultado
            tResultSet.next();
            tQtde = tResultSet.getInt(1);

            // Liberar os recursos
            tResultSet.close();
            tComandoJdbc.close();

        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na contagem das Respostas");
        }

        // Retornando a lista de objetos
        return tQtde;
    }

    public int countByCidade(int pCodigo)
    {
        int tQtde = 0;

        try
        {
            // Obter a conex�o
            Connection tConexao = Conexao.getConexao();

            // Criar o comando
            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoCountByCidade);

            // Preencher o comando
            int i = 1;
            tComandoJdbc.setInt(i++, pCodigo);

            // Executar o comando
            ResultSet tResultSet = tComandoJdbc.executeQuery();

            // Processar o resultado
            tResultSet.next();
            tQtde = tResultSet.getInt(1);

            // Liberar os recursos
            tResultSet.close();
            tComandoJdbc.close();

        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na contagem das Cidades");
        }

        // Retornando a lista de objetos
        return tQtde;
    }

    public int countByMensagem(int pIdMensagem)
    {
        int tQtde = 0;

        try
        {
            // Obter a conex�o
            Connection tConexao = Conexao.getConexao();

            // Criar o comando
            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoCountByMensagem);

            // Preencher o comando
            int i = 1;
            tComandoJdbc.setInt(i++, pIdMensagem);

            // Executar o comando
            ResultSet tResultSet = tComandoJdbc.executeQuery();

            // Processar o resultado
            tResultSet.next();
            tQtde = tResultSet.getInt(1);

            // Liberar os recursos
            tResultSet.close();
            tComandoJdbc.close();

        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na contagem das Mensagens");
        }

        // Retornando a lista de objetos
        return tQtde;
    }

    public Long countByUsuario(long pCpf)
    {
        long tQtde = 0;

        try
        {
            // Obter a conex�o
            Connection tConexao = Conexao.getConexao();

            // Criar o comando
            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoCountByUsuario);

            // Preencher o comando
            int i = 1;
            tComandoJdbc.setLong(i++, pCpf);

            // Executar o comando
            ResultSet tResultSet = tComandoJdbc.executeQuery();

            // Processar o resultado
            tResultSet.next();
            tQtde = tResultSet.getLong(1);

            // Liberar os recursos
            tResultSet.close();
            tComandoJdbc.close();

        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na contagem do Usuario");
        }

        // Retornando a lista de objetos
        return tQtde;
    }

    public int countBySetor(int pIdSetor)
    {
        int tQtde = 0;

        try
        {
            // Obter a conex�o
            Connection tConexao = Conexao.getConexao();

            // Criar o comando
            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoCountBySetor);

            // Preencher o comando
            int i = 1;
            tComandoJdbc.setInt(i++, pIdSetor);

            // Executar o comando
            ResultSet tResultSet = tComandoJdbc.executeQuery();

            // Processar o resultado
            tResultSet.next();
            tQtde = tResultSet.getInt(1);

            // Liberar os recursos
            tResultSet.close();
            tComandoJdbc.close();

        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na contagem do Setor");
        }

        // Retornando a lista de objetos
        return tQtde;
    }

    public int countByProtocolo(int pIdProtocolo)
    {
        int tQtde = 0;

        try
        {
            // Obter a conex�o
            Connection tConexao = Conexao.getConexao();

            // Criar o comando
            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoCountByProtocolo);

            // Preencher o comando
            int i = 1;
            tComandoJdbc.setInt(i++, pIdProtocolo);

            // Executar o comando
            ResultSet tResultSet = tComandoJdbc.executeQuery();

            // Processar o resultado
            tResultSet.next();
            tQtde = tResultSet.getInt(1);

            // Liberar os recursos
            tResultSet.close();
            tComandoJdbc.close();

        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na contagem do Protocolo");
        }

        // Retornando a lista de objetos
        return tQtde;
    }

    public int countByAcesso_Funcionario(int pLogin)
    {
        int tQtde = 0;

        try
        {
            // Obter a conex�o
            Connection tConexao = Conexao.getConexao();

            // Criar o comando
            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoCountByAcesso_Funcionario);

            // Preencher o comando
            int i = 1;
            tComandoJdbc.setInt(i++, pLogin);

            // Executar o comando
            ResultSet tResultSet = tComandoJdbc.executeQuery();

            // Processar o resultado
            tResultSet.next();
            tQtde = tResultSet.getInt(1);

            // Liberar os recursos
            tResultSet.close();
            tComandoJdbc.close();

        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na contagem Login");
        }

        // Retornando a lista de objetos
        return tQtde;
    }

    private Mensagem recuperarMensagem(ResultSet tResultSet) throws SQLException
    {
        Mensagem tMensagem = new Mensagem();

        // Recuperando os dados do resultSet

        tMensagem.setId(tResultSet.getInt("ID"));
        tMensagem.setId_Protocolo(tResultSet.getInt("ID_PROTOCOLO"));
        tMensagem.setId_Assunto(tResultSet.getInt("ID_ASSUNTO"));
        tMensagem.setId_Setor(tResultSet.getInt("ID_SETOR"));
        tMensagem.setCpf(tResultSet.getLong("CPF"));
        tMensagem.setLogin(tResultSet.getInt("LOGIN"));
        tMensagem.setNome(tResultSet.getString("NOME"));
        tMensagem.setData_Mensagem(new java.util.Date(tResultSet.getTimestamp("DATA_MENSAGEM").getTime()));
        tMensagem.setStatus(tResultSet.getString("STATUS"));
        tMensagem.setConteudo(tResultSet.getString("CONTEUDO"));

        return tMensagem;
    }

}
