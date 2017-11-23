package br.edu.opet.ouvidoria.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.opet.ouvidoria.jdbc.Conexao;
import br.edu.opet.ouvidoria.model.Resposta;
import br.edu.opet.ouvidoria.util.ExceptionUtil;

public class RespostaDao {
	 private String comandoCreate   = "INSERT INTO RESPOSTA "
             + "(ID, CONTEUDO, ID_PROTOCOLO, DATA)"
             + "VALUES (RESPOSTA_SEQ.NEXTVAL, ?, ?, ?)";
private String comandoRecovery = "SELECT ID, CONTEUDO, ID_PROTOCOLO, DATA "
             + "FROM RESPOSTA "
             + "WHERE ID = ? ";
private String comandoUpdate   = "UPDATE RESPOSTA "
             + "SET CONTEUDO = ?, "
             + "ID_PROTOCOLO = ?, "
             + "DATA = ? "
             + "WHERE ID = ? ";
private String comandoDelete   = "DELETE FROM RESPOSTA "
             + "WHERE ID = ? ";
private String comandoSearch   = "SELECT ID, CONTEUDO, ID_PROTOCOLO, DATA "
             + "FROM RESPOSTA ";

public Resposta create(Resposta pResposta)
{
 try
 {
     // Obter a conexão
     Connection tConexao = Conexao.getConexao();

     // Criar o comando
     PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoCreate, new String[] { "ID" });

     // Preencher o comando
     int i = 1;
     tComandoJdbc.setString(i++, pResposta.getConteudo());
     tComandoJdbc.setInt(i++, pResposta.getId_Protocolo());
     tComandoJdbc.setDate(i++, Date.valueOf(pResposta.getData()));

     // Executar o comando
     int tQtd = tComandoJdbc.executeUpdate();

     // Processar o resultado
     if (tQtd == 1)
     {
         // Copiando o parametro
         Resposta tResposta = pResposta;

         // Recuperando o código gerado pelo banco de dados
         ResultSet tRsChave = tComandoJdbc.getGeneratedKeys();
         tRsChave.next();

         // Assinalar a chave primária gerada no objeto
         pResposta.setId(tRsChave.getInt(1));

         // Liberar os recursos
         tRsChave.close();
         tComandoJdbc.close();

         // Retornando o objeto inserido
         return tResposta;
     }
 }
 catch (SQLException tExcept)
 {
     ExceptionUtil.mostrarErro(tExcept, "Problemas na criação da Resposta");
 }

 // Retorna null indicando algum erro de processamento
 return null;
}

public Resposta recovery(int pId)
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
         Resposta tResposta = recuperarResposta(tResultSet);

         // Liberar os recursos
         tResultSet.close();
         tComandoJdbc.close();

         // Retornando o objeto inserido
         return tResposta;
     }
 }
 catch (SQLException tExcept)
 {
     ExceptionUtil.mostrarErro(tExcept, "Problemas na criação da Resposta");
 }

 // Retorna null indicando algum erro de processamento
 return null;
}

public Resposta update(Resposta pResposta)
{
 try
 {
     // Obter a conexão
     Connection tConexao = Conexao.getConexao();

     // Criar o comando
     PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoUpdate);

     // Preencher o comando
     int i = 1;
     tComandoJdbc.setString(i++, pResposta.getConteudo());
     tComandoJdbc.setInt(i++, pResposta.getId_Protocolo());
     tComandoJdbc.setDate(i++, Date.valueOf(pResposta.getData()));
     tComandoJdbc.setInt(i++, pResposta.getId());

     // Executar o comando
     int tQtd = tComandoJdbc.executeUpdate();

     // Processar o resultado
     if (tQtd == 1)
     {
         // Copiando o parametro
         Resposta tResposta = pResposta;

         // Liberar os recursos
         tComandoJdbc.close();

         // Retornando o objeto inserido
         return tResposta;
     }
 }
 catch (SQLException tExcept)
 {
     ExceptionUtil.mostrarErro(tExcept, "Problemas na criação da Resposta");
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
     ExceptionUtil.mostrarErro(tExcept, "Problemas na remoção da Resposta");
 }

 // Retorna falso indicando algum erro de processamento
 return false;
}

public List<Resposta> search()
{
 List<Resposta> tLista = new ArrayList<>();

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
         Resposta tResposta = recuperarResposta(tResultSet);

         // Adicionar o o bjeto na lista
         tLista.add(tResposta);
     }

     // Liberar os recursos
     tResultSet.close();
     tComandoJdbc.close();
 }
 catch (SQLException tExcept)
 {
     ExceptionUtil.mostrarErro(tExcept, "Problemas na criação da Resposta");
 }

 // Retornando a lista de objetos
 return tLista;
}

private Resposta recuperarResposta(ResultSet tResultSet) throws SQLException
{
 Resposta tResposta = new Resposta();

 // Recuperando os dados do resultSet
 tResposta.setId(tResultSet.getInt("ID"));
 tResposta.setConteudo(tResultSet.getString("CONTEUDO"));
 tResposta.setId_Protocolo(tResultSet.getInt("ID_PROTOCOLO"));
 tResposta.setData(tResultSet.getDate("DATA").toLocalDate());
 return tResposta;
}
}
