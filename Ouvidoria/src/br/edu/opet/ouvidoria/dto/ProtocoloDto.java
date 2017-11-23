package br.edu.opet.ouvidoria.dto;

import java.util.List;

import br.edu.opet.ouvidoria.model.Protocolo;

public class ProtocoloDto
{
        private boolean        ok;
        private String         mensagem;
        private Protocolo       protocolo ;
        private List<Protocolo > lista;


        public ProtocoloDto(boolean pOk, String pMensagem)
        {
            super();
            ok = pOk;
            mensagem = pMensagem;
        }

        public ProtocoloDto(boolean pOk, String pMensagem, Protocolo  pProtocolo )
        {
            super();
            ok = pOk;
            mensagem = pMensagem;
            protocolo  = pProtocolo ;
        }

        public ProtocoloDto(boolean pOk, String pMensagem, List<Protocolo > pLista)
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

        public Protocolo  getProtocolo()
        {
            return protocolo;
        }

        public void setprotocolo(Protocolo  pProtocolo)
        {
            protocolo  = pProtocolo ;
        }

        public List<Protocolo > getLista()
        {
            return lista;
        }

        public void setLista(List<Protocolo > pLista)
        {
            lista = pLista;
        }

    }