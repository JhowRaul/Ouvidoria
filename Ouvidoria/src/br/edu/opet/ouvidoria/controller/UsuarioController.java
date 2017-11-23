package br.edu.opet.ouvidoria.controller;

import br.edu.opet.ouvidoria.dao.MensagemDao;
import br.edu.opet.ouvidoria.dao.UsuarioDao;
import br.edu.opet.ouvidoria.dto.UsuarioDto;
import br.edu.opet.ouvidoria.model.Usuario;

public class UsuarioController {
	public UsuarioDto cadastrarUsuario(Usuario pUsuario)
    {
        // Verificar as informa��es
        if (pUsuario == null)
        {
            return new UsuarioDto(false, "Tentativa de inclus�o de Usuario nulo");
        }

        // Criando o objeto de persist�ncia
        UsuarioDao tDao = new UsuarioDao();

        // Verificando se o Usuario j� existe
        Usuario tUsuario = tDao.recoveryByCpf(pUsuario.getCpf());
        if (tUsuario != null)
        {
            return new UsuarioDto(false, "J� existe Usuario com o CPF informado");
        }

        // Incluindo o Usuario
        tUsuario = tDao.create(pUsuario);
        if (tUsuario == null)
        {
            return new UsuarioDto(false, "Erro no processo de inclus�o");
        }

        // Retornando o indicativo de sucesso
        return new UsuarioDto(true, "Usuario inclu�do com sucesso", tUsuario);
    }

    public UsuarioDto recuperarUsuario(long pCpf)
    {
        // Verificar as informa��es
        if (pCpf <=0)
        {
            return new UsuarioDto(false, "Identificador do Usuario inv�lido");
        }

        // Criando o objeto de persist�ncia
        UsuarioDao tDao = new UsuarioDao();

        // Recuperando o Usuario
        Usuario tUsuario = tDao.recoveryByCpf(pCpf);
        if (tUsuario == null)
        {
            return new UsuarioDto(false, "N�o existe Usuario com o identificador informado");
        }

        // Retornando o indicativo de sucesso
        return new UsuarioDto(true, "Usuario recuperado com sucesso", tUsuario);
    }

    public UsuarioDto atualizarUsuario(Usuario pUsuario)
    {
        // Verificar as informa��es
        if (pUsuario == null)
        {
            return new UsuarioDto(false, "Tentativa de atualiza��o de Usuario nulo");
        }

        // Criando o objeto de persist�ncia
        UsuarioDao tDao = new UsuarioDao();

        // Verificando se existe um Usuario com o novo CPF
        Usuario tUsuario = tDao.recoveryByCpf(pUsuario.getCpf());
        if (tUsuario != null)
        {
            return new UsuarioDto(false, "J� existe Usuario com o CPF informado");
        }

        // Atualizando o Usuario
        tUsuario = tDao.update(pUsuario);
        if (tUsuario == null)
        {
            return new UsuarioDto(false, "N�o existe Usuario com o identificador informado");
        }

        // Retornando o indicativo de sucesso
        return new UsuarioDto(true, "Usuario alterado com sucesso", tUsuario);
    }

    public UsuarioDto removeUsuario(long pCpf)
    {
        // Verificar as informa��es
        if (pCpf <=0)
        {
            return new UsuarioDto(false, "Identificador do Usuario inv�lido");
        }

        // Criando o objeto de persist�ncia
        MensagemDao tDaoMensagem = new MensagemDao();

        // Verificando se o Usuario j� existe
        Long tQtde = tDaoMensagem.countByUsuario(pCpf);
        if (tQtde != 0)
        {
            return new UsuarioDto(false, "Usuario j� tem mensagem no sistema. Remo��o pro�bida");
        }

        // Criando o objeto de persist�ncia
        UsuarioDao tDao = new UsuarioDao();

        // Incluindo o Usuario
        if (tDao.delete(pCpf))
        {
            // Retornando o indicativo de sucesso
            return new UsuarioDto(true, "Usuario removido com sucesso");
        }

        // Retornando o indicativo de erro
        return new UsuarioDto(false, "Erro no processo de remo��o");
    }
}
