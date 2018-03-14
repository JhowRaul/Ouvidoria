package br.edu.opet.ouvidoria.controller;

import br.edu.opet.ouvidoria.dao.ProtocoloDao;
import br.edu.opet.ouvidoria.dao.MensagemDao;
import br.edu.opet.ouvidoria.dto.ProtocoloDto;
import br.edu.opet.ouvidoria.model.Protocolo;

public class ProtocoloController {
	public ProtocoloDto cadastrarProtocolo(Protocolo pProtocolo)
    {	
	// Verificar as informações
	        if (pProtocolo == null)
	        {
	            return new ProtocoloDto(false, "Tentativa de inclusão de Protocolo nulo");
	        }

	        // Criando o objeto de persistência
	        ProtocoloDao tDao = new ProtocoloDao();

	        // Verificando se o Protocolo já existe
	        Protocolo tProtocolo = tDao.recovery(pProtocolo.getId());
	        if (tProtocolo != null)
	        {
	            return new ProtocoloDto(false, "Já existe Protocolo com o Código informado");
	        }

	        // Incluindo o Protocolo
	        tProtocolo = tDao.create(pProtocolo);
	        if (tProtocolo == null)
	        {
	            return new ProtocoloDto(false, "Erro no processo de inclusão");
	        }

	        // Retornando o indicativo de sucesso
	        return new ProtocoloDto(true, "Protocolo incluído com sucesso", tProtocolo);
	    }

	    public ProtocoloDto recuperarProtocolo(int pId)
	    {
	        // Verificar as informações
	        if (pId <=0)
	        {
	            return new ProtocoloDto(false, "Identificador do Protocolo inválido");
	        }

	        // Criando o objeto de persistência
	        ProtocoloDao tDao = new ProtocoloDao();

	        // Recuperando o Protocolo
	        Protocolo tProtocolo = tDao.recovery(pId);
	        if (tProtocolo == null)
	        {
	            return new ProtocoloDto(false, "Não existe Protocolo com o identificador informado");
	        }

	        // Retornando o indicativo de sucesso
	        return new ProtocoloDto(true, "Protocolo recuperado com sucesso", tProtocolo);
	    }

	    public ProtocoloDto atualizarProtocolo(Protocolo pProtocolo)
	    {
	        // Verificar as informações
	        if (pProtocolo == null)
	        {
	            return new ProtocoloDto(false, "Tentativa de atualização de Protocolo nulo");
	        }

	        // Criando o objeto de persistência
	        ProtocoloDao tDao = new ProtocoloDao();

	        // Verificando se existe um Protocolo com o novo CPF
	        Protocolo tProtocolo = tDao.recovery(pProtocolo.getId());
	        if (tProtocolo != null)
	        {
	            return new ProtocoloDto(false, "Já existe Protocolo com o Id informado");
	        }

	        // Atualizando o Protocolo
	        tProtocolo = tDao.update(pProtocolo);
	        if (tProtocolo == null)
	        {
	            return new ProtocoloDto(false, "Não existe Protocolo com o identificador informado");
	        }

	        // Retornando o indicativo de sucesso
	        return new ProtocoloDto(true, "Protocolo alterado com sucesso", tProtocolo);
	    }

	    public ProtocoloDto removeProtocolo(int pId)
	    {
	        // Verificar as informações
	        if (pId <=0)
	        {
	            return new ProtocoloDto(false, "Identificador do Protocolo inválido");
	        }

	        // Criando o objeto de persistência
	        MensagemDao tDaoMensagem = new MensagemDao();

	        // Verificando se a Protocolo já existe
	        int tQtde = tDaoMensagem.countByProtocolo(pId);
	        if (tQtde != 0)
	        {
	            return new ProtocoloDto(false, "Protocolo já tem mensagem no sistema. Remoção proíbida");
	        }

	        // Criando o objeto de persistência
	        ProtocoloDao tDao = new ProtocoloDao();

	        // Incluindo o Protocolo
	        if (tDao.delete(pId))
	        {
	            // Retornando o indicativo de sucesso
	            return new ProtocoloDto(true, "Protocolo removida com sucesso");
	        }

	        // Retornando o indicativo de erro
	        return new ProtocoloDto(false, "Erro no processo de remoção");
	    }
	}