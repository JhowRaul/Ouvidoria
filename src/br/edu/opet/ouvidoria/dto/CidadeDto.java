package br.edu.opet.ouvidoria.dto;

import java.util.List;

import br.edu.opet.ouvidoria.model.Cidade;

public class CidadeDto
{
    private boolean        ok;
    private String         mensagem;
    private Cidade       cidade ;
    private List<Cidade > lista;


    public CidadeDto(boolean pOk, String pMensagem)
    {
        super();
        ok = pOk;
        mensagem = pMensagem;
    }

    public CidadeDto(boolean pOk, String pMensagem, Cidade  pCidade )
    {
        super();
        ok = pOk;
        mensagem = pMensagem;
        cidade  = pCidade ;
    }

    public CidadeDto(boolean pOk, String pMensagem, List<Cidade > pLista)
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

    public Cidade  getCidade()
    {
        return cidade;
    }

    public void setCidade(Cidade  pCidade)
    {
        cidade  = pCidade ;
    }

    public List<Cidade > getLista()
    {
        return lista;
    }

    public void setLista(List<Cidade > pLista)
    {
        lista = pLista;
    }

}
