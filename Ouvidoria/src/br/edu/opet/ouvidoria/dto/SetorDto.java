package br.edu.opet.ouvidoria.dto;

import java.util.List;

import br.edu.opet.ouvidoria.model.Setor;

public class SetorDto
{

    private boolean        ok;
    private String         mensagem;
    private Setor          setor;
    private List<Setor> lista;

    public SetorDto()
    {

    }

    public SetorDto(boolean pOk, String pMensagem)
    {
        super();
        ok = pOk;
        mensagem = pMensagem;
    }

    public SetorDto(boolean pOk, String pMensagem, Setor pSetor)
    {
        super();
        ok = pOk;
        mensagem = pMensagem;
        setor = pSetor;
    }

    public SetorDto(boolean pOk, String pMensagem, List<Setor> pLista)
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

    public Setor getSetor()
    {
        return setor;
    }

    public void setSetor(Setor pSetor)
    {
        setor = pSetor;
    }

    public List<Setor> getLista()
    {
        return lista;
    }

    public void setLista(List<Setor> pLista)
    {
        lista = pLista;
    }

}
