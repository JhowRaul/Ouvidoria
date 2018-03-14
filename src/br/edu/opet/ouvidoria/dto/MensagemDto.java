package br.edu.opet.ouvidoria.dto;

import java.util.List;

import br.edu.opet.ouvidoria.model.Mensagem;

public class MensagemDto
{

        private boolean        ok;
        private String         mensage;
        private Mensagem       mensagem ;
        private List<Mensagem > lista;


        public MensagemDto(boolean pOk, String pMensage)
        {
            super();
            ok = pOk;
            mensage = pMensage;
        }

        public MensagemDto(boolean pOk, String pMensagem, Mensagem  pMensage )
        {
            super();
            ok = pOk;
            mensagem = pMensage;
            mensagem = pMensage ;
        }

        public MensagemDto(boolean pOk, String pMensage, List<Mensagem > pLista)
        {
            super();
            ok = pOk;
            mensage = pMensage;
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

        public String getMensage()
        {
            return mensage;
        }

        public void setMensage(String pMensage)
        {
            mensage = pMensage;
        }

        public Mensagem  getMensagem()
        {
            return mensagem;
        }

        public void setMensagem(Mensagem  pMensagem)
        {
            mensagem  = pMensagem;
        }

        public List<Mensagem > getLista()
        {
            return lista;
        }

        public void setLista(List<Mensagem > pLista)
        {
            lista = pLista;
        }

    }
