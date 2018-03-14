package br.edu.opet.ouvidoria.controller;

import br.edu.opet.ouvidoria.dao.SetorDao;
import br.edu.opet.ouvidoria.dao.MensagemDao;
import br.edu.opet.ouvidoria.dto.SetorDto;
import br.edu.opet.ouvidoria.model.Setor;

public class SetorController {
	
	public SetorDto cadastrarSetor(Setor pSetor)
    {	
	// Verificar as informa��es
	        if (pSetor == null)
	        {
	            return new SetorDto(false, "Tentativa de inclus�o de Setor nulo");
	        }

	        // Criando o objeto de persist�ncia
	        SetorDao tDao = new SetorDao();

	        // Verificando se o Setor j� existe
	        Setor tSetor = tDao.recovery(pSetor.getId());
	        if (tSetor != null)
	        {
	            return new SetorDto(false, "J� existe Setor com o C�digo informado");
	        }

	        // Incluindo o Setor
	        tSetor = tDao.create(pSetor);
	        if (tSetor == null)
	        {
	            return new SetorDto(false, "Erro no processo de inclus�o");
	        }

	        // Retornando o indicativo de sucesso
	        return new SetorDto(true, "Setor inclu�do com sucesso", tSetor);
	    }

	    public SetorDto recuperarSetor(int pId)
	    {
	        // Verificar as informa��es
	        if (pId <=0)
	        {
	            return new SetorDto(false, "Identificador do Setor inv�lido");
	        }

	        // Criando o objeto de persist�ncia
	        SetorDao tDao = new SetorDao();

	        // Recuperando o Setor
	        Setor tSetor = tDao.recovery(pId);
	        if (tSetor == null)
	        {
	            return new SetorDto(false, "N�o existe Setor com o identificador informado");
	        }

	        // Retornando o indicativo de sucesso
	        return new SetorDto(true, "Setor recuperado com sucesso", tSetor);
	    }

	    public SetorDto atualizarSetor(Setor pSetor)
	    {
	        // Verificar as informa��es
	        if (pSetor == null)
	        {
	            return new SetorDto(false, "Tentativa de atualiza��o de Setor nulo");
	        }

	        // Criando o objeto de persist�ncia
	        SetorDao tDao = new SetorDao();

	        // Verificando se existe um Setor com o novo ID
	        Setor tSetor = tDao.recovery(pSetor.getId());
	        if (tSetor != null)
	        {
	            return new SetorDto(false, "J� existe Setor com o Id informado");
	        }

	        // Atualizando o Setor
	        tSetor = tDao.update(pSetor);
	        if (tSetor == null)
	        {
	            return new SetorDto(false, "N�o existe Setor com o identificador informado");
	        }

	        // Retornando o indicativo de sucesso
	        return new SetorDto(true, "Setor alterado com sucesso", tSetor);
	    }

	    public SetorDto removeSetor(int pId)
	    {
	        // Verificar as informa��es
	        if (pId <=0)
	        {
	            return new SetorDto(false, "Identificador do Setor inv�lido");
	        }

	        // Criando o objeto de persist�ncia
	        MensagemDao tDaoMensagem = new MensagemDao();

	        // Verificando se a Setor j� existe
	        int tQtde = tDaoMensagem.countBySetor(pId);
	        if (tQtde != 0)
	        {
	            return new SetorDto(false, "Setor j� tem mensagem no sistema. Remo��o pro�bida");
	        }

	        // Criando o objeto de persist�ncia
	        SetorDao tDao = new SetorDao();

	        // Incluindo o Setor
	        if (tDao.delete(pId))
	        {
	            // Retornando o indicativo de sucesso
	            return new SetorDto(true, "Setor removido com sucesso");
	        }

	        // Retornando o indicativo de erro
	        return new SetorDto(false, "Erro no processo de remo��o");
	    }

}
