package br.edu.opet.ouvidoria.controller;

import br.edu.opet.ouvidoria.dao.SetorDao;
import br.edu.opet.ouvidoria.dao.MensagemDao;
import br.edu.opet.ouvidoria.dto.SetorDto;
import br.edu.opet.ouvidoria.model.Setor;

public class SetorController {
	
	public SetorDto cadastrarSetor(Setor pSetor)
    {	
	// Verificar as informações
	        if (pSetor == null)
	        {
	            return new SetorDto(false, "Tentativa de inclusão de Setor nulo");
	        }

	        // Criando o objeto de persistência
	        SetorDao tDao = new SetorDao();

	        // Verificando se o Setor já existe
	        Setor tSetor = tDao.recovery(pSetor.getId());
	        if (tSetor != null)
	        {
	            return new SetorDto(false, "Já existe Setor com o Código informado");
	        }

	        // Incluindo o Setor
	        tSetor = tDao.create(pSetor);
	        if (tSetor == null)
	        {
	            return new SetorDto(false, "Erro no processo de inclusão");
	        }

	        // Retornando o indicativo de sucesso
	        return new SetorDto(true, "Setor incluído com sucesso", tSetor);
	    }

	    public SetorDto recuperarSetor(int pId)
	    {
	        // Verificar as informações
	        if (pId <=0)
	        {
	            return new SetorDto(false, "Identificador do Setor inválido");
	        }

	        // Criando o objeto de persistência
	        SetorDao tDao = new SetorDao();

	        // Recuperando o Setor
	        Setor tSetor = tDao.recovery(pId);
	        if (tSetor == null)
	        {
	            return new SetorDto(false, "Não existe Setor com o identificador informado");
	        }

	        // Retornando o indicativo de sucesso
	        return new SetorDto(true, "Setor recuperado com sucesso", tSetor);
	    }

	    public SetorDto atualizarSetor(Setor pSetor)
	    {
	        // Verificar as informações
	        if (pSetor == null)
	        {
	            return new SetorDto(false, "Tentativa de atualização de Setor nulo");
	        }

	        // Criando o objeto de persistência
	        SetorDao tDao = new SetorDao();

	        // Verificando se existe um Setor com o novo ID
	        Setor tSetor = tDao.recovery(pSetor.getId());
	        if (tSetor != null)
	        {
	            return new SetorDto(false, "Já existe Setor com o Id informado");
	        }

	        // Atualizando o Setor
	        tSetor = tDao.update(pSetor);
	        if (tSetor == null)
	        {
	            return new SetorDto(false, "Não existe Setor com o identificador informado");
	        }

	        // Retornando o indicativo de sucesso
	        return new SetorDto(true, "Setor alterado com sucesso", tSetor);
	    }

	    public SetorDto removeSetor(int pId)
	    {
	        // Verificar as informações
	        if (pId <=0)
	        {
	            return new SetorDto(false, "Identificador do Setor inválido");
	        }

	        // Criando o objeto de persistência
	        MensagemDao tDaoMensagem = new MensagemDao();

	        // Verificando se a Setor já existe
	        int tQtde = tDaoMensagem.countBySetor(pId);
	        if (tQtde != 0)
	        {
	            return new SetorDto(false, "Setor já tem mensagem no sistema. Remoção proíbida");
	        }

	        // Criando o objeto de persistência
	        SetorDao tDao = new SetorDao();

	        // Incluindo o Setor
	        if (tDao.delete(pId))
	        {
	            // Retornando o indicativo de sucesso
	            return new SetorDto(true, "Setor removido com sucesso");
	        }

	        // Retornando o indicativo de erro
	        return new SetorDto(false, "Erro no processo de remoção");
	    }

}
