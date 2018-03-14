package br.edu.opet.ouvidoria.dto;

import java.util.List;

import br.edu.opet.ouvidoria.model.Assunto;


public class AssuntoDto
{
                private boolean        ok;
                private String         mensagem;
                private Assunto       assunto ;
                private List<Assunto > lista;


                public AssuntoDto(boolean pOk, String pMensagem)
                {
                    super();
                    ok = pOk;
                    mensagem = pMensagem;
                }

                public AssuntoDto(boolean pOk, String pMensagem, Assunto  pAssunto )
                {
                    super();
                    ok = pOk;
                    mensagem = pMensagem;
                    assunto  = pAssunto ;
                }

                public AssuntoDto(boolean pOk, String pMensagem, List<Assunto > pLista)
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

                public Assunto  getAssunto()
                {
                    return assunto;
                }

                public void setAssunto(Assunto  pAssunto)
                {
                    assunto  = pAssunto ;
                }

                public List<Assunto > getLista()
                {
                    return lista;
                }

                public void setLista(List<Assunto > pLista)
                {
                    lista = pLista;
                }
  }
