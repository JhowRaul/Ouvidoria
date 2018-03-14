package br.edu.opet.ouvidoria.controller;

import br.edu.opet.ouvidoria.dao.ProtocoloDao;
import br.edu.opet.ouvidoria.dao.MensagemDao;
import br.edu.opet.ouvidoria.dto.ProtocoloDto;
import br.edu.opet.ouvidoria.model.Protocolo;

public class ProtocoloController {
	public ProtocoloDto cadastrarProtocolo(Protocolo pProtocolo)
    {	
	// Verificar as informa��es
	        if (pProtocolo == null)
	        {
	            return new ProtocoloDto(false, "Tentativa de inclus�o de Protocolo nulo");
	        }

	        // Criando o objeto de persist�ncia
	        ProtocoloDao tDao = new ProtocoloDao();

	        // Verificando se o Protocolo j� existe
	        Protocolo tProtocolo = tDao.recovery(pProtocolo.getId());
	        if (tProtocolo != null)
	        {
	            return new ProtocoloDto(false, "J� existe Protocolo com o C�digo informado");
	        }

	        // Incluindo o Protocolo
	        tProtocolo = tDao.create(pProtocolo);
	        if (tProtocolo == null)
	        {
	            return new ProtocoloDto(false, "Erro no processo de inclus�o");
	        }

	        // Retornando o indicativo de sucesso
	        return new ProtocoloDto(true, "Protocolo inclu�do com sucesso", tProtocolo);
	    }

	    public ProtocoloDto recuperarProtocolo(int pId)
	    {
	        // Verificar as informa��es
	        if (pId <=0)
	        {
	            return new ProtocoloDto(false, "Identificador do Protocolo inv�lido");
	        }

	        // Criando o objeto de persist�ncia
	        ProtocoloDao tDao = new ProtocoloDao();

	        // Recuperando o Protocolo
	        Protocolo tProtocolo = tDao.recovery(pId);
	        if (tProtocolo == null)
	        {
	            return new ProtocoloDto(false, "N�o existe Protocolo com o identificador informado");
	        }

	        // Retornando o indicativo de sucesso
	        return new ProtocoloDto(true, "Protocolo recuperado com sucesso", tProtocolo);
	    }

	    public ProtocoloDto atualizarProtocolo(Protocolo pProtocolo)
	    {
	        // Verificar as informa��es
	        if (pProtocolo == null)
	        {
	            return new ProtocoloDto(false, "Tentativa de atualiza��o de Protocolo nulo");
	        }

	        // Criando o objeto de persist�ncia
	        ProtocoloDao tDao = new ProtocoloDao();

	        // Verificando se existe um Protocolo com o novo CPF
	        Protocolo tProtocolo = tDao.recovery(pProtocolo.getId());
	        if (tProtocolo != null)
	        {
	            return new ProtocoloDto(false, "J� existe Protocolo com o Id informado");
	        }

	        // Atualizando o Protocolo
	        tProtocolo = tDao.update(pProtocolo);
	        if (tProtocolo == null)
	        {
	            return new ProtocoloDto(false, "N�o existe Protocolo com o identificador informado");
	        }

	        // Retornando o indicativo de sucesso
	        return new ProtocoloDto(true, "Protocolo alterado com sucesso", tProtocolo);
	    }

	    public ProtocoloDto removeProtocolo(int pId)
	    {
	        // Verificar as informa��es
	        if (pId <=0)
	        {
	            return new ProtocoloDto(false, "Identificador do Protocolo inv�lido");
	        }

	        // Criando o objeto de persist�ncia
	        MensagemDao tDaoMensagem = new MensagemDao();

	        // Verificando se a Protocolo j� existe
	        int tQtde = tDaoMensagem.countByProtocolo(pId);
	        if (tQtde != 0)
	        {
	            return new ProtocoloDto(false, "Protocolo j� tem mensagem no sistema. Remo��o pro�bida");
	        }

	        // Criando o objeto de persist�ncia
	        ProtocoloDao tDao = new ProtocoloDao();

	        // Incluindo o Protocolo
	        if (tDao.delete(pId))
	        {
	            // Retornando o indicativo de sucesso
	            return new ProtocoloDto(true, "Protocolo removida com sucesso");
	        }

	        // Retornando o indicativo de erro
	        return new ProtocoloDto(false, "Erro no processo de remo��o");
	    }
	}