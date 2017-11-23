package br.edu.opet.ouvidoria.controller;

import br.edu.opet.ouvidoria.dao.RespostaDao;
import br.edu.opet.ouvidoria.dao.MensagemDao;
import br.edu.opet.ouvidoria.dto.RespostaDto;
import br.edu.opet.ouvidoria.model.Resposta;

public class RespostaController {
	public RespostaDto cadastrarResposta(Resposta pResposta)
    {
        // Verificar as informa��es
        if (pResposta == null)
        {
            return new RespostaDto(false, "Tentativa de inclus�o de Resposta nulo");
        }

        // Criando o objeto de persist�ncia
        RespostaDao tDao = new RespostaDao();

        // Verificando se o Resposta j� existe
        Resposta tResposta = tDao.recovery(pResposta.getId());
        if (tResposta != null)
        {
            return new RespostaDto(false, "J� existe Resposta com o ID informado");
        }

        // Incluindo o Resposta
        tResposta = tDao.create(pResposta);
        if (tResposta == null)
        {
            return new RespostaDto(false, "Erro no processo de inclus�o");
        }

        // Retornando o indicativo de sucesso
        return new RespostaDto(true, "Resposta inclu�do com sucesso", tResposta);
    }

    public RespostaDto recuperarResposta(int pId)
    {
        // Verificar as informa��es
        if (pId <=0)
        {
            return new RespostaDto(false, "Identificador do Resposta inv�lido");
        }

        // Criando o objeto de persist�ncia
        RespostaDao tDao = new RespostaDao();

        // Recuperando o Resposta
        Resposta tResposta = tDao.recovery(pId);
        if (tResposta == null)
        {
            return new RespostaDto(false, "N�o existe Resposta com o identificador informado");
        }

        // Retornando o indicativo de sucesso
        return new RespostaDto(true, "Resposta recuperado com sucesso", tResposta);
    }

    public RespostaDto atualizarResposta(Resposta pResposta)
    {
        // Verificar as informa��es
        if (pResposta == null)
        {
            return new RespostaDto(false, "Tentativa de atualiza��o de Resposta nulo");
        }

        // Criando o objeto de persist�ncia
        RespostaDao tDao = new RespostaDao();

        // Verificando se existe um Resposta com o novo CPF
        Resposta tResposta = tDao.recovery(pResposta.getId());
        if (tResposta != null)
        {
            return new RespostaDto(false, "J� existe Resposta com o ID informado");
        }

        // Atualizando o Resposta
        tResposta = tDao.update(pResposta);
        if (tResposta == null)
        {
            return new RespostaDto(false, "N�o existe Resposta com o identificador informado");
        }

        // Retornando o indicativo de sucesso
        return new RespostaDto(true, "Resposta alterado com sucesso", tResposta);
    }

    public RespostaDto removeResposta(int pId)
    {
        // Verificar as informa��es
        if (pId <=0)
        {
            return new RespostaDto(false, "Identificador do Resposta inv�lido");
        }

        // Criando o objeto de persist�ncia
        MensagemDao tDaoMensagem = new MensagemDao();

        // Verificando se o Resposta j� existe
        int tQtde = tDaoMensagem.countByResposta(pId);
        if (tQtde != 0)
        {
            return new RespostaDto(false, "Resposta j� tem mensagem no sistema. Remo��o pro�bida");
        }

        // Criando o objeto de persist�ncia
        RespostaDao tDao = new RespostaDao();

        // Incluindo o Resposta
        if (tDao.delete(pId))
        {
            // Retornando o indicativo de sucesso
            return new RespostaDto(true, "Resposta removido com sucesso");
        }

        // Retornando o indicativo de erro
        return new RespostaDto(false, "Erro no processo de remo��o");
    }
}
