package br.edu.opet.ouvidoria.dto;

import java.util.List;

import br.edu.opet.ouvidoria.model.Acesso_Funcionario;


public class Acesso_FuncionarioDto
{
            private boolean        ok;
            private String         mensagem;
            private Acesso_Funcionario       acesso_funcionario ;
            private List<Acesso_Funcionario > lista;


            public Acesso_FuncionarioDto(boolean pOk, String pMensagem)
            {
                super();
                ok = pOk;
                mensagem = pMensagem;
            }

            public Acesso_FuncionarioDto(boolean pOk, String pMensagem, Acesso_Funcionario  pAcesso_Funcionario )
            {
                super();
                ok = pOk;
                mensagem = pMensagem;
                acesso_funcionario  = pAcesso_Funcionario ;
            }

            public Acesso_FuncionarioDto(boolean pOk, String pMensagem, List<Acesso_Funcionario > pLista)
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

            public Acesso_Funcionario  getAcesso_Funcionario()
            {
                return acesso_funcionario;
            }

            public void setAcesso_Funcionario(Acesso_Funcionario  pAcesso_Funcionario)
            {
                acesso_funcionario  = pAcesso_Funcionario ;
            }

            public List<Acesso_Funcionario > getLista()
            {
                return lista;
            }

            public void setLista(List<Acesso_Funcionario > pLista)
            {
                lista = pLista;
            }
}
