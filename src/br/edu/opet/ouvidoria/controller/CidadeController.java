package br.edu.opet.ouvidoria.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.opet.ouvidoria.dao.CidadeDao;
import br.edu.opet.ouvidoria.dao.MensagemDao;
import br.edu.opet.ouvidoria.dto.CidadeDto;
import br.edu.opet.ouvidoria.model.Cidade;


public class CidadeController 

{
	public CidadeDto cadastrarCidade(Cidade pCidade)
    {	
	// Verificar as informa��es
	        if (pCidade == null)
	        {
	            return new CidadeDto(false, "Tentativa de inclus�o de Cidade nulo");
	        }

	        // Criando o objeto de persist�ncia
	        CidadeDao tDao = new CidadeDao();

	        // Verificando se o Cidade j� existe
	        Cidade tCidade = tDao.recovery(pCidade.getCodigo());
	        if (tCidade != null)
	        {
	            return new CidadeDto(false, "J� existe Cidade com o C�digo informado");
	        }

	        // Incluindo o Cidade
	        tCidade = tDao.create(pCidade);
	        if (tCidade == null)
	        {
	            return new CidadeDto(false, "Erro no processo de inclus�o");
	        }

	        // Retornando o indicativo de sucesso
	        return new CidadeDto(true, "Cidade inclu�do com sucesso", tCidade);
	    }

	    public CidadeDto recuperarCidade(int pCodigo)
	    {
	        // Verificar as informa��es
	        if (pCodigo <=0)
	        {
	            return new CidadeDto(false, "Identificador do Cidade inv�lido");
	        }

	        // Criando o objeto de persist�ncia
	        CidadeDao tDao = new CidadeDao();

	        // Recuperando o Cidade
	        Cidade tCidade = tDao.recovery(pCodigo);
	        if (tCidade == null)
	        {
	            return new CidadeDto(false, "N�o existe Cidade com o identificador informado");
	        }

	        // Retornando o indicativo de sucesso
	        return new CidadeDto(true, "Cidade recuperado com sucesso", tCidade);
	    }

	    public CidadeDto atualizarCidade(Cidade pCidade)
	    {
	        // Verificar as informa��es
	        if (pCidade == null)
	        {
	            return new CidadeDto(false, "Tentativa de atualiza��o de Cidade nulo");
	        }

	        // Criando o objeto de persist�ncia
	        CidadeDao tDao = new CidadeDao();

	        // Verificando se existe um Cidade com o novo CPF
	        Cidade tCidade = tDao.recovery(pCidade.getCodigo());
            if (tCidade == null)
            {
                return new CidadeDto(false, "N�o existe Cidade com o código informado");
            }

            if (pCidade.getCodigo() != tCidade.getCodigo())
            {
                // Verificando se existe um Cidade com o novo Login
                tCidade = tDao.recovery(pCidade.getCodigo());
                if (tCidade != null)
                {
                    return new CidadeDto(false, "J� existe Cidade com o código informado");
                }
            }

	        // Atualizando o Cidade
	        tCidade = tDao.update(pCidade);
	        if (tCidade == null)
	        {
	            return new CidadeDto(false, "N�o existe Cidade com o código informado");
	        }

	        // Retornando o indicativo de sucesso
	        return new CidadeDto(true, "Cidade alterada com sucesso", tCidade);
	    }

	    public CidadeDto removeCidade(int pCodigo)
	    {
	        // Verificar as informa��es
	        if (pCodigo <=0)
	        {
	            return new CidadeDto(false, "Identificador do Cidade inv�lido");
	        }

	        // Criando o objeto de persist�ncia
	        MensagemDao tDaoMensagem = new MensagemDao();

	        // Verificando se a Cidade j� existe
	        int tQtde = tDaoMensagem.countByCidade(pCodigo);
	        if (tQtde != 0)
	        {
	            return new CidadeDto(false, "Cidade sendo usada no sistema. Remo��o pro�bida");
	        }

	        // Criando o objeto de persist�ncia
	        CidadeDao tDao = new CidadeDao();

	        // Incluindo o Cidade
	        if (tDao.delete(pCodigo))
	        {
	            // Retornando o indicativo de sucesso
	            return new CidadeDto(true, "Cidade removida com sucesso");
	        }

	        // Retornando o indicativo de erro
	        return new CidadeDto(false, "Erro no processo de remo��o");
	    }
	    
	    public CidadeDto pesquisarCidadesPorEstado(String pEstado)
	    {
	        // Criando a lista de retorno
	        List<Cidade> tLista = new ArrayList<>();

	        // Criando o objeto de persist�ncia
	        CidadeDao tDao = new CidadeDao();

	        // Recuperando o paciente
	        tLista = tDao.searchByEstado(pEstado);

	        // Retornando o indicativo de sucesso
	        return new CidadeDto(true, "Lista de cidades recuperada com sucesso", tLista);
	    }
	}
