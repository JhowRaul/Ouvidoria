package br.edu.opet.ouvidoria.jsf.javabean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.opet.ouvidoria.controller.AssuntoController;
import br.edu.opet.ouvidoria.dto.AssuntoDto;
import br.edu.opet.ouvidoria.model.Assunto;


@ViewScoped
@ManagedBean(name = "AssuntoVB")

public class AssuntoJavaBean
{


    // Atributos - Valores dos componentes visuais

        private Integer id;
        private String assunto;

        private boolean        edicao;
        private String         tela;
        private List<Assunto> listaAssunto;

        @PostConstruct
        public void init()
        {
            Assunto tAssunto = (Assunto) FacesContext.getCurrentInstance().getExternalContext()
                            .getRequestMap().get("Assunto");
            if (tAssunto != null)
            {
                id = tAssunto.getId();
                assunto = tAssunto.getAssunto();
                edicao = true;
            }
        }

        public Integer getId()
        {
            return id;
        }

        public void setId(Integer pId)
        {
            id = pId;
        }

        public String getassunto()
        {
            return assunto;
        }

        public void setassunto(String passunto)
        {
            assunto = passunto;
        }



        public boolean isEdicao()
        {
            return edicao;
        }

        public void setEdicao(boolean pEdicao)
        {
            edicao = pEdicao;
        }

        public String getTela()
        {
            return tela;
        }

        public void setTela(String pTela)
        {
            tela = pTela;
        }

        public List<Assunto> getListaAssunto()
        {
            return listaAssunto;
        }

        public void setListaAssunto(List<Assunto> pListaAssunto)
        {
            listaAssunto = pListaAssunto;
        }

        // Métodos da Controller
        public String limpar()
        {
            id = null;
            assunto = null;
            edicao = false;

            return tela;
        }

        public String cadastrar()
        {
            System.out.println("AssuntoVB - Cadastrar : " + this);

            Assunto tAssunto = new Assunto();
            tAssunto.setAssunto(assunto);


            AssuntoController tController = new AssuntoController();

            AssuntoDto tDto = tController.cadastrarAssunto(tAssunto);
            if (tDto.isOk())
            {
                // Ok, incluído
                id = tDto.getAssunto().getId();

                // Colocando a mensagem do sistema
                FacesContext.getCurrentInstance().addMessage(null,
                                new FacesMessage(FacesMessage.SEVERITY_INFO, tDto.getMensagem(), tDto.getMensagem()));
            }
            else
            {
                // Erro de inclusão

                // Colocando a mensagem do sistema
                FacesContext.getCurrentInstance().addMessage(null,
                                new FacesMessage(FacesMessage.SEVERITY_ERROR, tDto.getMensagem(), tDto.getMensagem()));
            }
            return null;
        }

        public String alterar()
        {
            System.out.println("AssuntoVB - Alterar : " + this);

            Assunto tAssunto = new Assunto();
            tAssunto.setId(id);
            tAssunto.setAssunto(assunto);



            AssuntoController tController = new AssuntoController();

            AssuntoDto tDto = tController.atualizarAssunto(tAssunto);
            if (tDto.isOk())
            {
                // Ok, alterado
                id = tDto.getAssunto().getId();

                // Colocando a mensagem do sistema
                FacesContext.getCurrentInstance().addMessage(null,
                                new FacesMessage(FacesMessage.SEVERITY_INFO, tDto.getMensagem(), tDto.getMensagem()));
            }
            else
            {
                // Erro de alteração

                // Colocando a mensagem do sistema
                FacesContext.getCurrentInstance().addMessage(null,
                                new FacesMessage(FacesMessage.SEVERITY_ERROR, tDto.getMensagem(), tDto.getMensagem()));
            }
            return null;
        }

        public String consultar()
        {
            System.out.println("AssuntoVB - Consultar : " + this);

            AssuntoController tController = new AssuntoController();

            AssuntoDto tDto = tController.recuperarAssunto(id);
            if (tDto.isOk())
            {
                // Ok, recuperado
                Assunto tAssunto = tDto.getAssunto();
                id = tAssunto.getId();
                assunto = tAssunto.getAssunto();


                // indicando que a pesquisa deu certo
                edicao = true;

                // Passando o obejto para outra instância de ViewBean, se necessário
                FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Assunto", tAssunto);
            }
            else
            {
                // Erro de consulta
                edicao = false;

                // Colocando a mensagem do sistema
                FacesContext.getCurrentInstance().addMessage(null,
                                new FacesMessage(FacesMessage.SEVERITY_ERROR, tDto.getMensagem(), tDto.getMensagem()));
            }

            return tela;
        }

        public String excluir()
        {
            System.out.println("AssuntoVB - Excluir : " + this);

            AssuntoController tController = new AssuntoController();

            AssuntoDto tDto = tController.removeAssunto(id);
            if (tDto.isOk())
            {
                // Ok, exluido
                limpar();

                // indicando que a pesquisa deu certo
                edicao = false;

                // Colocando a mensagem do sistema
                FacesContext.getCurrentInstance().addMessage(null,
                                new FacesMessage(FacesMessage.SEVERITY_INFO, tDto.getMensagem(), tDto.getMensagem()));

            }
            else
            {
                // Erro de consulta
                edicao = false;

                // Colocando a mensagem do sistema
                FacesContext.getCurrentInstance().addMessage(null,
                                new FacesMessage(FacesMessage.SEVERITY_ERROR, tDto.getMensagem(), tDto.getMensagem()));
            }

            return null;
        }


        // Métodos Gerais
        @Override
        public String toString()
        {
            StringBuilder tBuilder = new StringBuilder();
            tBuilder.append(" [");
            tBuilder.append(id);
            tBuilder.append(", ");
            tBuilder.append(assunto);
            tBuilder.append("]");
            return tBuilder.toString();
        }
  }
