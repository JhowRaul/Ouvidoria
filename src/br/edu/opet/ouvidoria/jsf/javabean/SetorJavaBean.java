package br.edu.opet.ouvidoria.jsf.javabean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.opet.ouvidoria.controller.SetorController;
import br.edu.opet.ouvidoria.dto.SetorDto;
import br.edu.opet.ouvidoria.model.Setor;


    @ViewScoped
    @ManagedBean(name = "SetorVB")

    public class SetorJavaBean
    {
        // Atributos - Valores dos componentes visuais

        private Integer id;
        private String nome;

        private boolean        edicao;
        private String         tela;
        private List<Setor> listaSetor;

        @PostConstruct
        public void init()
        {
            Setor tSetor = (Setor) FacesContext.getCurrentInstance().getExternalContext()
                            .getRequestMap().get("Setor");
            if (tSetor != null)
            {
                id = tSetor.getId();
                nome = tSetor.getNome();
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

        public String getNome()
        {
            return nome;
        }

        public void setNome(String pNome)
        {
            nome = pNome;
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

        public List<Setor> getListaSetor()
        {
            return listaSetor;
        }

        public void setListaSetor(List<Setor> pListaSetor)
        {
            listaSetor = pListaSetor;
        }

        // Métodos da Controller
        public String limpar()
        {
            id = null;
            nome = null;
            edicao = false;

            return tela;
        }

        public String cadastrar()
        {
            System.out.println("SetorVB - Cadastrar : " + this);

            Setor tSetor = new Setor();
            tSetor.setNome(nome);


            SetorController tController = new SetorController();

            SetorDto tDto = tController.cadastrarSetor(tSetor);
            if (tDto.isOk())
            {
                // Ok, incluído
                id = tDto.getSetor().getId();

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
            System.out.println("SetorVB - Alterar : " + this);

            Setor tSetor = new Setor();
            tSetor.setId(id);
            tSetor.setNome(nome);



            SetorController tController = new SetorController();

            SetorDto tDto = tController.atualizarSetor(tSetor);
            if (tDto.isOk())
            {
                // Ok, alterado
                id = tDto.getSetor().getId();

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
            System.out.println("SetorVB - Consultar : " + this);

            SetorController tController = new SetorController();

            SetorDto tDto = tController.recuperarSetor(id);
            if (tDto.isOk())
            {
                // Ok, recuperado
                Setor tSetor = tDto.getSetor();
                id = tSetor.getId();
                nome = tSetor.getNome();


                // indicando que a pesquisa deu certo
                edicao = true;

                // Passando o obejto para outra instância de ViewBean, se necessário
                FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Setor", tSetor);
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
            System.out.println("SetorVB - Excluir : " + this);

            SetorController tController = new SetorController();

            SetorDto tDto = tController.removeSetor(id);
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
            tBuilder.append(nome);
            tBuilder.append("]");
            return tBuilder.toString();
        }
    }
