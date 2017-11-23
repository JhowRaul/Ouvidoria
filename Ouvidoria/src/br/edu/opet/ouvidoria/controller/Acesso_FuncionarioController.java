package br.edu.opet.ouvidoria.controller;

import br.edu.opet.ouvidoria.dao.Acesso_FuncionarioDao;
import br.edu.opet.ouvidoria.dao.CidadeDao;
import br.edu.opet.ouvidoria.dao.MensagemDao;
import br.edu.opet.ouvidoria.dto.Acesso_FuncionarioDto;
import br.edu.opet.ouvidoria.model.Acesso_Funcionario;
import br.edu.opet.ouvidoria.model.Cidade;

public class Acesso_FuncionarioController
{

         public Acesso_FuncionarioDto cadastrarAcesso_Funcionario(Acesso_Funcionario pAcesso_Funcionario)
         {
             // Verificar as informa��es
             if (pAcesso_Funcionario == null)
             {
                 return new Acesso_FuncionarioDto(false, "Tentativa de inclus�o de Acesso_Funcionario nulo");
             }                    

             // Criando o objeto de persist�ncia
             CidadeDao tDaoCidade = new CidadeDao();
             Acesso_FuncionarioDao tDao = new Acesso_FuncionarioDao();
             
             // Validando se os identificadores existem na base de dados
             Cidade tCidade = tDaoCidade.recovery(pAcesso_Funcionario.getCodigo());
             if (tCidade == null)
             {
                 return new Acesso_FuncionarioDto(false, "N�o existe cidade com o codigo informado");
             }

             // Verificando se o Acesso_Funcionario j� existe
             Acesso_Funcionario tAcesso_Funcionario = tDao.recovery(pAcesso_Funcionario.getLogin());
             if (tAcesso_Funcionario != null)
             {
                 return new Acesso_FuncionarioDto(false, "J� existe Acesso_Funcionario com o Login informado");
             }

             // Incluindo o Acesso_Funcionario
             tAcesso_Funcionario = tDao.create(pAcesso_Funcionario);
             if (tAcesso_Funcionario == null)
             {
                 return new Acesso_FuncionarioDto(false, "Erro no processo de inclus�o");
             }

             // Retornando o indicativo de sucesso
             return new Acesso_FuncionarioDto(true, "Acesso_Funcionario inclu�do com sucesso", tAcesso_Funcionario);
         }

         public Acesso_FuncionarioDto recuperarAcesso_Funcionario(int pId)
         {
             // Verificar as informa��es
             if (pId <= 0)
             {
                 return new Acesso_FuncionarioDto(false, "Identificador do Acesso_Funcionario inv�lido");
             }

             // Criando o objeto de persist�ncia
             Acesso_FuncionarioDao tDao = new Acesso_FuncionarioDao();

             // Recuperando o Acesso_Funcionario
             Acesso_Funcionario tAcesso_Funcionario = tDao.recovery(pId);
             if (tAcesso_Funcionario == null)
             {
                 return new Acesso_FuncionarioDto(false, "N�o existe Acesso_Funcionario com o identificador informado");
             }

             // Retornando o indicativo de sucesso
             return new Acesso_FuncionarioDto(true, "Acesso_Funcionario recuperado com sucesso", tAcesso_Funcionario);
         }

         public Acesso_FuncionarioDto atualizarAcesso_Funcionario(Acesso_Funcionario pAcesso_Funcionario)
         {
             // Verificar as informa��es
             if (pAcesso_Funcionario == null)
             {
                 return new Acesso_FuncionarioDto(false, "Tentativa de atualiza��o de Acesso_Funcionario nulo");
             }

             // Criando o objeto de persist�ncia
             Acesso_FuncionarioDao tDao = new Acesso_FuncionarioDao();

             // Recuperando o Acesso_Funcionario
             Acesso_Funcionario tAcesso_Funcionario = tDao.recovery(pAcesso_Funcionario.getLogin());
             if (tAcesso_Funcionario == null)
             {
                 return new Acesso_FuncionarioDto(false, "N�o existe Acesso_Funcionario com o identificador informado");
             }

             if (pAcesso_Funcionario.getLogin() != tAcesso_Funcionario.getLogin())
             {
                 // Verificando se existe um Acesso_Funcionario com o novo Login
                 tAcesso_Funcionario = tDao.recovery(pAcesso_Funcionario.getLogin());
                 if (tAcesso_Funcionario != null)
                 {
                     return new Acesso_FuncionarioDto(false, "J� existe Acesso_Funcionario com o Login informado");
                 }
             }

             // Atualizando o Acesso_Funcionario
             tAcesso_Funcionario = tDao.update(pAcesso_Funcionario);
             if (tAcesso_Funcionario == null)
             {
                 return new Acesso_FuncionarioDto(false, "N�o existe Acesso_Funcionario com o identificador informado");
             }

             // Retornando o indicativo de sucesso
             return new Acesso_FuncionarioDto(true, "Acesso_Funcionario alterado com sucesso", tAcesso_Funcionario);
         }

         public Acesso_FuncionarioDto removeAcesso_Funcionario(int pId)
         {
             // Verificar as informa��es
             if (pId <= 0)
             {
                 return new Acesso_FuncionarioDto(false, "Identificador do Acesso_Funcionario inv�lido");
             }

             // Criando o objeto de persist�ncia
             MensagemDao tDaoConsulta = new MensagemDao();

             // Verificando se o Acesso_Funcionario j� existe
             int tQtde = tDaoConsulta.countByAcesso_Funcionario(pId);
             if (tQtde != 0)
             {
                 return new Acesso_FuncionarioDto(false, "Acesso_Funcionario tem no sistema. Remo��o pro�bida");
             }

             // Criando o objeto de persist�ncia
             Acesso_FuncionarioDao tDao = new Acesso_FuncionarioDao();

             // Incluindo o Acesso_Funcionario
             if (tDao.delete(pId))
             {
                 // Retornando o indicativo de sucesso
                 return new Acesso_FuncionarioDto(true, "Acesso_Funcionario removido com sucesso");
             }

             // Retornando o indicativo de erro
             return new Acesso_FuncionarioDto(false, "Erro no processo de remo��o");
         }
 }


