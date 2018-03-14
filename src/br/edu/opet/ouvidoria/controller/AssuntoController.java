package br.edu.opet.ouvidoria.controller;

import br.edu.opet.ouvidoria.dao.AssuntoDao;
import br.edu.opet.ouvidoria.dao.MensagemDao;
import br.edu.opet.ouvidoria.dto.AssuntoDto;
import br.edu.opet.ouvidoria.model.Assunto;

public class AssuntoController 

{
	public AssuntoDto cadastrarAssunto(Assunto pAssunto)
    {
        // Verificar as informações
        if (pAssunto == null)
        {
            return new AssuntoDto(false, "Tentativa de inclusão de assunto nulo");
        }

        // Criando o objeto de persistência
        AssuntoDao tDao = new AssuntoDao();

        // Verificando se o Assunto já existe
        Assunto tAssunto = tDao.recovery(pAssunto.getId());
        if (tAssunto != null)
        {
            return new AssuntoDto(false, "Já existe assunto com o ID informado");
        }

        // Incluindo o Assunto
        tAssunto = tDao.create(pAssunto);
        if (tAssunto == null)
        {
            return new AssuntoDto(false, "Erro no processo de inclusão");
        }

        // Retornando o indicativo de sucesso
        return new AssuntoDto(true, "assunto incluído com sucesso", tAssunto);
    }

    public AssuntoDto recuperarAssunto(int pId)
    {
        // Verificar as informações
        if (pId <=0)
        {
            return new AssuntoDto(false, "Identificador do assunto inválido");
        }

        // Criando o objeto de persistência
        AssuntoDao tDao = new AssuntoDao();

        // Recuperando o Assunto
        Assunto tAssunto = tDao.recovery(pId);
        if (tAssunto == null)
        {
            return new AssuntoDto(false, "Não existe assunto com o identificador informado");
        }

        // Retornando o indicativo de sucesso
        return new AssuntoDto(true, "assunto recuperado com sucesso", tAssunto);
    }

    public AssuntoDto atualizarAssunto(Assunto pAssunto)
    {
        // Verificar as informações
        if (pAssunto == null)
        {
            return new AssuntoDto(false, "Tentativa de atualização de assunto nulo");
        }

        // Criando o objeto de persistência
        AssuntoDao tDao = new AssuntoDao();

        // Verificando se existe um Assunto com o novo CPF
        Assunto tAssunto = tDao.recovery(pAssunto.getId());
        if (tAssunto != null)
        {
            return new AssuntoDto(false, "Já existe assunto com o ID informado");
        }

        // Atualizando o Assunto
        tAssunto = tDao.update(pAssunto);
        if (tAssunto == null)
        {
            return new AssuntoDto(false, "Não existe assunto com o identificador informado");
        }

        // Retornando o indicativo de sucesso
        return new AssuntoDto(true, "assunto alterado com sucesso", tAssunto);
    }

    public AssuntoDto removeAssunto(int pId)
    {
        // Verificar as informações
        if (pId <=0)
        {
            return new AssuntoDto(false, "Identificador do assunto inválido");
        }

        // Criando o objeto de persistência
        MensagemDao tDaoMensagem = new MensagemDao();

        // Verificando se o Assunto já existe
        int tQtde = tDaoMensagem.countByAssunto(pId);
        if (tQtde != 0)
        {
            return new AssuntoDto(false, "assunto já tem mensagem no sistema. Remoção proíbida");
        }

        // Criando o objeto de persistência
        AssuntoDao tDao = new AssuntoDao();

        // Incluindo o Assunto
        if (tDao.delete(pId))
        {
            // Retornando o indicativo de sucesso
            return new AssuntoDto(true, "assunto removido com sucesso");
        }

        // Retornando o indicativo de erro
        return new AssuntoDto(false, "Erro no processo de remoção");
    }
}
