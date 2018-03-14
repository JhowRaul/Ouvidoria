package br.edu.opet.ouvidoria.dto;

import java.util.List;

import br.edu.opet.ouvidoria.model.Usuario;

public class UsuarioDto
{

    private boolean        ok;
    private String         mensagem;
    private Usuario        usuario;
    private List<Usuario> lista;

    public UsuarioDto()
    {

    }

    public UsuarioDto(boolean pOk, String pMensagem)
    {
        super();
        ok = pOk;
        mensagem = pMensagem;
    }

    public UsuarioDto(boolean pOk, String pMensagem, Usuario pUsuario)
    {
        super();
        ok = pOk;
        mensagem = pMensagem;
        usuario = pUsuario;
    }

    public UsuarioDto(boolean pOk, String pMensagem, List<Usuario> pLista)
    {
        super();
        ok = pOk;
        mensagem = pMensagem;
        lista = pLista;
    }

    public boolean isOk()
    {
        return ok;
    }

    public void setOk(boolean pOk)
    {
        ok = pOk;
    }

    public String getMensagem()
    {
        return mensagem;
    }

    public void setMensagem(String pMensagem)
    {
        mensagem = pMensagem;
    }

    public Usuario getUsuario()
    {
        return usuario;
    }

    public void setUsuario(Usuario pUsuario)
    {
        usuario = pUsuario;
    }

    public List<Usuario> getLista()
    {
        return lista;
    }

    public void setLista(List<Usuario> pLista)
    {
        lista = pLista;
    }

}
