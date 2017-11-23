package br.edu.opet.ouvidoria.jsf.javabean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import br.edu.opet.ouvidoria.controller.Acesso_FuncionarioController;
import br.edu.opet.ouvidoria.controller.CidadeController;
import br.edu.opet.ouvidoria.dto.Acesso_FuncionarioDto;
import br.edu.opet.ouvidoria.dto.CidadeDto;
import br.edu.opet.ouvidoria.model.Acesso_Funcionario;
import br.edu.opet.ouvidoria.model.Cidade;
import br.edu.opet.ouvidoria.model.Funcionario;


@ApplicationScoped
@ManagedBean(name = "Acesso_FuncionarioVB")

public class Acesso_FuncionarioJavaBean

{
		// Atributos est�ticos
	    private static final String NOME_FORMULARIO  = "funcionario:formulario";
	
	    // Atributos - Valores dos componentes visuais
	    
	    private Funcionario funcionario;
	    	    
	    private Integer login;
	    private String  senha;
	    private String  nome;
	    private Integer matricula;
	    private Integer	    codigo;	    
		private String 	    descricao;
	    private String      pais;
	    private String      estado;
	    private boolean edicao;
	    private boolean 	edicaoCidade;
	    private String  tela;
	    private List<Cidade> listaCidades;
	    private String senhaA;

	    @PostConstruct
	    public void init()
	    {
	        Acesso_Funcionario tAcesso_Funcionario = (Acesso_Funcionario) FacesContext.getCurrentInstance().getExternalContext()
	                        .getRequestMap().get("ACESSO_FUNCIONARIO");
	        if (tAcesso_Funcionario != null)
	        {
	            login = tAcesso_Funcionario.getLogin();
	            codigo = tAcesso_Funcionario.getCodigo();
	            	            	        
		        CidadeController tCidadeController = new CidadeController();
	
	            CidadeDto tCidadeDto = tCidadeController.recuperarCidade(codigo);
	            if (tCidadeDto.isOk())
	            {
	                Cidade tCidade = tCidadeDto.getCidade();
	                estado = tCidade.getEstado();
	                descricao = tCidade.getDescricao();
	            }
	            else 
	            {
	                descricao = null;
	            }
	            
	            senha = tAcesso_Funcionario.getSenha();
	            nome = tAcesso_Funcionario.getNome();
	            matricula = tAcesso_Funcionario.getMatricula();
	            edicaoCidade = true;
	            edicao = true;	            
	        }
	    }
	    
	    public Integer getLogin()
	    {
	        return login;
	    }

	    public void setLogin(Integer pLogin)
	    {
	        login = pLogin;
	    }

	    public String getSenha()
	    {
	        return senha;
	    }
	    public void setSenha(String pSenha)
	    {
	        senha = pSenha;
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

	    public boolean isEdicaoCidade() {
			return edicaoCidade;
		}

		public void setEdicaoCidade(boolean pEdicaoCidade) {
			edicaoCidade = pEdicaoCidade;
		}

		public String getTela()
	    {
	        return tela;
	    }

	    public void setTela(String pTela)
	    {
	        tela = pTela;
	    }
	    
	    public Integer getMatricula()
	    {
	        return matricula;
	    }

	    public void setMatricula(Integer pMatricula)
	    {
	        matricula = pMatricula;
	    }	    
	    
	    public Integer getCodigo() {
			return codigo;
		}

		public void setCodigo(Integer pCodigo) {
			codigo = pCodigo;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String pDescricao) {
			descricao = pDescricao;
		}

		public String getPais() {
			return pais;
		}

		public void setPais(String pPais) {
			pais = pPais;
		}

		public String getEstado() {
			return estado;
		}

		public void setEstado(String pEstado) {
			estado = pEstado;
			
			consultarCidade();
			
			
		}


	    public List<Cidade> getListaCidades() {
			return listaCidades;
		}

		public void setListaCidades(List<Cidade> pListaCidades) {
			listaCidades = pListaCidades;
		}
		
		public String getSenhaA()
	    {
	        return senhaA;
	    }
	    public void setSenhaA(String pSenhaA)
	    {
	        senhaA = pSenhaA;
	    }

		// M�todos da Controller
	    public String limpar()
	    {    	
	    	System.out.println("Acesso_Funcionario - Limpar : " + this);
	    	
	        login = null;
	        codigo = null;
	        senha = null;
	        nome = null;
	        matricula = null;	        
	        descricao = null;
	        pais = null;
	        estado = null;
	        senhaA = null;
	        edicaoCidade = false;
	        edicao = false;
	        
	        RequestContext.getCurrentInstance().reset(NOME_FORMULARIO);
	        	        
	        return tela;
	    }

	    public String cadastrar()
	    {
	        System.out.println("Acesso_FuncionarioVB - Cadastrar : " + this);

	        Acesso_Funcionario tAcesso_Funcionario = new Acesso_Funcionario();	        
	        tAcesso_Funcionario.setCodigo(codigo);
	        
	        tAcesso_Funcionario.setSenha(senha);
	        tAcesso_Funcionario.setNome(nome);
	        tAcesso_Funcionario.setMatricula(matricula);

	        Acesso_FuncionarioController tController = new Acesso_FuncionarioController();

	        Acesso_FuncionarioDto tDto = tController.cadastrarAcesso_Funcionario(tAcesso_Funcionario);
	        if (tDto.isOk())
	        {
	            // Ok, inclu�do
	            login = tDto.getAcesso_Funcionario().getLogin();

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
	    
	    public String consultarCidade()
	    {
	        System.out.println("Acesso_FuncionarioVB - consultarCidade : " + this);

	        CidadeController tController = new CidadeController();

	        CidadeDto tDto = tController.pesquisarCidadesPorEstado(estado);
	        if (tDto.isOk())
	        {
	            // Ok, recuperado
	            listaCidades = tDto.getLista();
	            edicaoCidade = true;
	        }
	        else
	        {
	            // Colocando a mensagem do sistema
	            FacesContext.getCurrentInstance().addMessage(null,
	                            new FacesMessage(FacesMessage.SEVERITY_ERROR, tDto.getMensagem(), tDto.getMensagem()));
	        }

	        return null;
	    }

	    public String alterar()
	    {
	        System.out.println("Acesso_FuncionarioVB - Alterar : " + this);

	        Acesso_Funcionario tAcesso_Funcionario = new Acesso_Funcionario();
	        tAcesso_Funcionario.setLogin(login);
	        tAcesso_Funcionario.setSenha(senha);
	        tAcesso_Funcionario.setNome(nome);
	        tAcesso_Funcionario.setMatricula(matricula);
	        tAcesso_Funcionario.setCodigo(codigo);
	        
	        CidadeController tCidadeController = new CidadeController();
	    	
            CidadeDto tCidadeDto = tCidadeController.recuperarCidade(codigo);
            if (tCidadeDto.isOk())
            {
                Cidade tCidade = tCidadeDto.getCidade();
                estado = tCidade.getEstado();
                descricao = tCidade.getDescricao();
            }
            else 
            {
                descricao = null;
            }

	        Acesso_FuncionarioController tController = new Acesso_FuncionarioController();

	        Acesso_FuncionarioDto tDto = tController.atualizarAcesso_Funcionario(tAcesso_Funcionario);
	        if (tDto.isOk())
	        {
	            // Ok, alterado
	            login = tDto.getAcesso_Funcionario().getLogin();

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
	        System.out.println("Acesso_FuncionarioVB - Consultar : " + this);

	        Acesso_FuncionarioController tController = new Acesso_FuncionarioController();

	        Acesso_FuncionarioDto tDto = tController.recuperarAcesso_Funcionario(login);
	        
	        
	        
	        if (tDto.isOk())
	        {	        	
	            // Ok, recuperado
	            Acesso_Funcionario tAcesso_Funcionario = tDto.getAcesso_Funcionario();
	            login = tAcesso_Funcionario.getLogin();
	            senha = tAcesso_Funcionario.getSenha();
	            senhaA = "*******";
	            nome = tAcesso_Funcionario.getNome();
	            matricula = tAcesso_Funcionario.getMatricula();
	            codigo = tAcesso_Funcionario.getCodigo();
	            
	            CidadeController tCidadeController = new CidadeController();

		        CidadeDto tCidadeDto = tCidadeController.recuperarCidade(codigo);
		        
		        if (tCidadeDto.isOk())
		        {
		            // Ok, recuperado
		        	Cidade tCidade = tCidadeDto.getCidade();
		        	pais = tCidade.getPais();
		        	estado = tCidade.getEstado();
		        	descricao = tCidade.getDescricao();        	
		        	
		            edicaoCidade = true;
		        }
		        else
		        {
		            // Colocando a mensagem do sistema
		            FacesContext.getCurrentInstance().addMessage(null,
		                            new FacesMessage(FacesMessage.SEVERITY_ERROR, tDto.getMensagem(), tDto.getMensagem()));
		        }

		        edicao = true;
	        }
	        else
	        {
	            // Erro de consulta
	            edicao = false;
	            edicaoCidade = false;

	            limpar();
	            
	            // Colocando a mensagem do sistema
	            FacesContext.getCurrentInstance().addMessage(null,
	                            new FacesMessage(FacesMessage.SEVERITY_ERROR, tDto.getMensagem(), tDto.getMensagem()));
	        }

	        return tela;
	    }

	    public String excluir()
	    {
	        System.out.println("Acesso_FuncionarioVB - Excluir : " + this);

	        Acesso_FuncionarioController tController = new Acesso_FuncionarioController();

	        Acesso_FuncionarioDto tDto = tController.removeAcesso_Funcionario(login);
	        if (tDto.isOk())
	        {
	            // Ok, exluLogino
	            limpar();

	            // indicando que a pesquisa deu certo
	            edicao = false;
	            edicaoCidade = false;

	            // Colocando a mensagem do sistema
	            FacesContext.getCurrentInstance().addMessage(null,
	                            new FacesMessage(FacesMessage.SEVERITY_INFO, tDto.getMensagem(), tDto.getMensagem()));

	        }
	        else
	        {
	            // Erro de consulta
	            edicao = false;
	            edicaoCidade = false;

	            // Colocando a mensagem do sistema
	            FacesContext.getCurrentInstance().addMessage(null,
	                            new FacesMessage(FacesMessage.SEVERITY_ERROR, tDto.getMensagem(), tDto.getMensagem()));
	        }

	        return null;
	    }
	    
	    public String homepage() {
	    	
	    	limpar();
	    	
	    	return "/index";
	    }
	    	       
	    
	    // M�todos Gerais
	    @Override
	    public String toString()
	    {
	        StringBuilder tBuilder = new StringBuilder();
	        tBuilder.append(" [");
	        tBuilder.append(login);
	        tBuilder.append(", ");
	        tBuilder.append(senha);
	        tBuilder.append(", ");
	        tBuilder.append(nome);
	        tBuilder.append(", ");
	        tBuilder.append(matricula);
	        tBuilder.append(", ");
	        tBuilder.append(codigo);
	        tBuilder.append(", ");
	        tBuilder.append(descricao);
	        tBuilder.append(", ");
	        tBuilder.append(pais);
	        tBuilder.append(", ");
	        tBuilder.append(estado);
	        tBuilder.append(", ");
	        tBuilder.append(edicao);
	        tBuilder.append(", ");
	        tBuilder.append(edicaoCidade);
	        tBuilder.append(", ");
	        tBuilder.append(tela);
	        tBuilder.append(", ");
	        tBuilder.append("]");
	        
	        return tBuilder.toString();
	    }
	}

