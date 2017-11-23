package br.edu.opet.ouvidoria.controller;

import java.util.Date;
import java.util.List;

import br.edu.opet.ouvidoria.dao.MensagemDao;
import br.edu.opet.ouvidoria.dto.MensagemDto;
import br.edu.opet.ouvidoria.model.Mensagem;

public class MensagemController {

			public MensagemDto cadastrarMensagem(Mensagem pMensagem)
	    {
	        // Verificar as informa��es
	        if (pMensagem == null)
	        {
	            return new MensagemDto(false, "Tentativa de inclus�o de Mensagem nulo");
	        }

	        // Criando o objeto de persist�ncia
	        MensagemDao tDao = new MensagemDao();

	        // Verificando se o Mensagem j� existe
	        Mensagem tMensagem = tDao.recovery(pMensagem.getId());
	        if (tMensagem != null)
	        {
	            return new MensagemDto(false, "J� existe Mensagem com o ID informado");
	        }

	        // Incluindo o Mensagem
	        tMensagem = tDao.create(pMensagem);
	        if (tMensagem == null)
	        {
	            return new MensagemDto(false, "Erro no processo de inclus�o");
	        }

	        // Retornando o indicativo de sucesso
	        return new MensagemDto(true, "Mensagem inclu�do com sucesso", tMensagem);
	    }

	    public MensagemDto recuperarMensagem(int pId)
	    {
	        // Verificar as informa��es
	        if (pId <=0)
	        {
	            return new MensagemDto(false, "Identificador do Mensagem inv�lido");
	        }

	        // Criando o objeto de persist�ncia
	        MensagemDao tDao = new MensagemDao();

	        // Recuperando o Mensagem
	        Mensagem tMensagem = tDao.recovery(pId);
	        if (tMensagem == null)
	        {
	            return new MensagemDto(false, "N�o existe Mensagem com o identificador informado");
	        }

	        // Retornando o indicativo de sucesso
	        return new MensagemDto(true, "Mensagem recuperado com sucesso", tMensagem);
	    }

	    public MensagemDto atualizarMensagem(Mensagem pMensagem)
	    {
	        // Verificar as informa��es
	        if (pMensagem == null)
	        {
	            return new MensagemDto(false, "Tentativa de atualiza��o de Mensagem nulo");
	        }

	        // Criando o objeto de persist�ncia
	        MensagemDao tDao = new MensagemDao();

	        // Verificando se existe um Mensagem com o novo CPF
	        Mensagem tMensagem = tDao.recovery(pMensagem.getId());
	        if (tMensagem != null)
	        {
	            return new MensagemDto(false, "J� existe Mensagem com o ID informado");
	        }

	        // Atualizando o Mensagem
	        tMensagem = tDao.update(pMensagem);
	        if (tMensagem == null)
	        {
	            return new MensagemDto(false, "N�o existe Mensagem com o identificador informado");
	        }

	        // Retornando o indicativo de sucesso
	        return new MensagemDto(true, "Mensagem alterado com sucesso", tMensagem);
	    }

	    public MensagemDto removeMensagem(int pId)
	    {
	        // Verificar as informa��es
	        if (pId <=0)
	        {
	            return new MensagemDto(false, "Identificador do Mensagem inv�lido");
	        }

	        // Criando o objeto de persist�ncia
	        MensagemDao tDaoMensagem = new MensagemDao();

	        // Verificando se o Mensagem j� existe
	        int tQtde = tDaoMensagem.countByMensagem(pId);
	        if (tQtde != 0)
	        {
	            return new MensagemDto(false, "Mensagem j� tem mensagem no sistema. Remo��o pro�bida");
	        }

	        // Criando o objeto de persist�ncia
	        MensagemDao tDao = new MensagemDao();

	        // Incluindo o Mensagem
	        if (tDao.delete(pId))
	        {
	            // Retornando o indicativo de sucesso
	            return new MensagemDto(true, "Mensagem removido com sucesso");
	        }

	        // Retornando o indicativo de erro
	        return new MensagemDto(false, "Erro no processo de remo��o");
	    }

	        public MensagemDto pesquisarMensagemPorUsuario(long pCpf)
	        {
	            // Verificar as informa��es
	            if (pCpf <= 0)
	            {
	                return new MensagemDto(false, "Identificador do Usu�rio inv�lido");
	            }

	            // Criando os objetos DAO
	            MensagemDao tDaoMensagem = new MensagemDao();

	            List<Mensagem> tLista =tDaoMensagem.searchByUsuario(pCpf);

	            // Retornar a lista
	            return new MensagemDto(true, "Lista de Mensagems recuperada com sucesso", tLista);
	        }

	        public MensagemDto pesquisarMensagemPorData_Mensagem(Date pData_Mensagem)
	        {
	            // Verificar as informa��es
	            if (pData_Mensagem == null)
	            {
	                return new MensagemDto(false, "Data da Mensagem n�o pode ser nula");
	            }

	            // Criando os objetos DAO
	            MensagemDao tDaoMensagem = new MensagemDao();

	            List<Mensagem> tLista =tDaoMensagem.searchByData_Mensagem(pData_Mensagem);

	            // Retornar a lista
	            return new MensagemDto(true, "Lista de Mensagems recuperada com sucesso", tLista);

	    }
	}
