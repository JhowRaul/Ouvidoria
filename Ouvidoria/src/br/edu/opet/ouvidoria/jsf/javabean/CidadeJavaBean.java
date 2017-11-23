package br.edu.opet.ouvidoria.jsf.javabean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import br.edu.opet.ouvidoria.controller.CidadeController;
import br.edu.opet.ouvidoria.dto.CidadeDto;
import br.edu.opet.ouvidoria.model.Cidade;


@ViewScoped
@ManagedBean(name = "CidadeVB")

public class CidadeJavaBean
{
	// Atributos est�ticos
    private static final String NOME_FORMULARIO  = "cidade:formulario";
	
    // Atributos - Valores dos componentes visuais

    private     Integer codigo;
    private     String descricao;
    private     String pais;
    private     String estado;
    private boolean        edicao;
    private String         tela;
    private List<Cidade> listaCidade;

    @PostConstruct
    public void init()
    {
        Cidade tCidade = (Cidade) FacesContext.getCurrentInstance().getExternalContext()
                        .getRequestMap().get("CIDADE");
        if (tCidade != null)
        {
            codigo = tCidade.getCodigo();
            descricao = tCidade.getDescricao();
            pais = tCidade.getPais();
            estado = tCidade.getEstado();
            edicao = true;
        }
    }

    public Integer getCodigo()
    {
        return codigo;
    }

    public void setCodigo(Integer pCodigo)
    {
        codigo = pCodigo;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String pDescricao)
    {
        descricao = pDescricao;
    }

    public String getPais()
    {
        return pais;
    }

    public void setPais(String pPais)
    {
        pais = pPais;
    }

    public String getEstado()
    {
        return estado;
    }

    public void setEstado(String pEstado)
    {
        estado = pEstado;
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

    public List<Cidade> getListaCidade()
    {
        return listaCidade;
    }

    public void setListaCidade(List<Cidade> pListaCidade)
    {
        listaCidade = pListaCidade;
    }

    // M�todos da Controller
    public String limpar()
    {
    	System.out.println("CidaderVB - Limpar : " + this);
    	
        codigo = null;
        descricao = null;
        pais = null;
        estado = null;
        edicao = false;

        RequestContext.getCurrentInstance().reset(NOME_FORMULARIO);
        
        return tela;
    }

    public String cadastrar()
    {
        System.out.println("CidadeVB - Cadastrar : " + this);

        Cidade tCidade = new Cidade();
        tCidade.setDescricao(descricao);
        tCidade.setPais(pais);
        tCidade.setEstado(estado);


        CidadeController tController = new CidadeController();

        CidadeDto tDto = tController.cadastrarCidade(tCidade);
        if (tDto.isOk())
        {
            // Ok, inclu�do
            codigo = tDto.getCidade().getCodigo();

            // Colocando a mensagem do sistema
            FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO, tDto.getMensagem(), tDto.getMensagem()));
        }
        else
        {
            // Erro de inclus�o

            // Colocando a mensagem do sistema
            FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR, tDto.getMensagem(), tDto.getMensagem()));
        }
        return null;
    }

    public String alterar()
    {
        System.out.println("CidadeVB - Alterar : " + this);

        Cidade tCidade = new Cidade();
        tCidade.setCodigo(codigo);
        tCidade.setDescricao(descricao);
        tCidade.setPais(pais);
        tCidade.setEstado(estado);


        CidadeController tController = new CidadeController();

        CidadeDto tDto = tController.atualizarCidade(tCidade);
        if (tDto.isOk())
        {
            // Ok, alterado
            codigo = tDto.getCidade().getCodigo();

            // Colocando a mensagem do sistema
            FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO, tDto.getMensagem(), tDto.getMensagem()));
        }
        else
        {
            // Erro de altera��o

            // Colocando a mensagem do sistema
            FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR, tDto.getMensagem(), tDto.getMensagem()));
        }
        return null;
    }

    public String consultar()
    {
        System.out.println("CidadeVB - Consultar : " + this);

        CidadeController tController = new CidadeController();

        CidadeDto tDto = tController.recuperarCidade(codigo);
        if (tDto.isOk())
        {
            // Ok, recuperado
            Cidade tCidade = tDto.getCidade();
            codigo = tCidade.getCodigo();
            descricao = tCidade.getDescricao();
            pais = tCidade.getPais();
            estado = tCidade.getEstado();

            // indicando que a pesquisa deu certo
            edicao = true;

            // Passando o obejto para outra inst�ncia de ViewBean, se necess�rio
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Cidade", tCidade);
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
        System.out.println("CidadeVB - Excluir : " + this);

        CidadeController tController = new CidadeController();

        CidadeDto tDto = tController.removeCidade(codigo);
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

    public String pesquisar()
    {
        System.out.println("CidadeVB - Pesquisar : " + this);

        CidadeController tController = new CidadeController();

        CidadeDto tDto = tController.pesquisarCidadesPorEstado(estado);
        if (tDto.isOk())
        {
            // Ok, recuperado
            listaCidade = tDto.getLista();
        }
        else
        {
            // Colocando a mensagem do sistema
            FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR, tDto.getMensagem(), tDto.getMensagem()));
        }

        return null;
    }

    // M�todos Gerais
    @Override
    public String toString()
    {
        StringBuilder tBuilder = new StringBuilder();
        tBuilder.append(" [");
        tBuilder.append(codigo);
        tBuilder.append(", ");
        tBuilder.append(descricao);
        tBuilder.append(", ");
        tBuilder.append(pais);
        tBuilder.append(", ");
        tBuilder.append(estado);
        tBuilder.append("]");
        return tBuilder.toString();
    }
}
