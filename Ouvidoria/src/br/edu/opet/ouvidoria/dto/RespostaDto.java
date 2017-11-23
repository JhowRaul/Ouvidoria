package br.edu.opet.ouvidoria.dto;

import java.util.List;
import br.edu.opet.ouvidoria.model.Resposta;

public class RespostaDto
{
      private boolean        ok;
        private String         mensagem;
        private Resposta       resposta ;
        private List<Resposta > lista;


        public RespostaDto(boolean pOk, String pMensagem)
        {
            super();
            ok = pOk;
            mensagem = pMensagem;
        }

        public RespostaDto(boolean pOk, String pMensagem, Resposta  pResposta)
        {
            super();
            ok = pOk;
            mensagem = pMensagem;
            resposta  = pResposta ;
        }

        public RespostaDto(boolean pOk, String pMensagem, List<Resposta > pLista)
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

        public Resposta  getResposta()
        {
            return resposta;
        }

        public void setResposta(Resposta  pResposta)
        {
            resposta  = pResposta ;
        }

        public List<Resposta> getLista()
        {
            return lista;
        }

        public void setLista(List<Resposta > pLista)
        {
            lista = pLista;
        }

    }
