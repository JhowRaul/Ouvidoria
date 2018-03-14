package br.edu.opet.ouvidoria.jsf.javabean;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.opet.ouvidoria.controller.CidadeController;
import br.edu.opet.ouvidoria.controller.UsuarioController;
import br.edu.opet.ouvidoria.dto.CidadeDto;
import br.edu.opet.ouvidoria.dto.UsuarioDto;
import br.edu.opet.ouvidoria.model.Cidade;
import br.edu.opet.ouvidoria.model.Usuario;

@ViewScoped
@ManagedBean(name = "UsuarioVB")
public class UsuarioJavaBean {

	private Long		cpf;
	private String 		nome;
    private Date	 	dataNascimento;
    private String 		endereco;
    private Integer		codigo;
    private String 		email;
    private Long   		telefone;
    private String 		sexo;
 		private String 	     descricao;
 	    private String       pais;
 	    private String       estado;
	private boolean		edicao;
	    private boolean 	 edicaoCidade;
	    private boolean		 edicaoEndereco;
	private String  	tela;
	    private List<Cidade> listaCidades;
    
	    @PostConstruct
	    public void init()
	    {
	        Usuario tUsuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext()
	                        .getRequestMap().get("USUARIO");
	        if (tUsuario != null)
	        {
	            cpf = tUsuario.getCpf();
	            codigo = tUsuario.getCodigo();
	            	            	        
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
	            
	            nome = tUsuario.getNome();
	            dataNascimento = java.sql.Date.valueOf(tUsuario.getDataNascimento());
	            endereco = tUsuario.getEndereco();
	            email = tUsuario.getEmail();
	            telefone = tUsuario.getTelefone();
	            sexo = tUsuario.getSexo();
	            edicaoCidade = true;
	            edicao = true;	            
	        }
	    }

		public Long getCpf() {
			return cpf;
		}

		public void setCpf(Long pCpf) {
			cpf = pCpf;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String pNome) {
			nome = pNome;
		}

		public Date getDataNascimento() {
			return dataNascimento;
		}

		public void setDataNascimento(Date pDataNascimento) {
			dataNascimento = pDataNascimento;
		}

		public String getEndereco() {
			return endereco;
		}

		public void setEndereco(String pEndereco) {
			endereco = pEndereco;
		}

		public Integer getCodigo() {
			return codigo;
		}

		public void setCodigo(Integer pCodigo) {
			codigo = pCodigo;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String pEmail) {
			email = pEmail;
		}

		public Long getTelefone() {
			return telefone;
		}

		public void setTelefone(Long pTelefone) {
			telefone = pTelefone;
		}

		public String getSexo() {
			return sexo;
		}

		public void setSexo(String pSexo) {
			sexo = pSexo;
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
		}

		public boolean isEdicao() {
			return edicao;
		}

		public void setEdicao(boolean pEdicao) {
			edicao = pEdicao;
		}

		public boolean isEdicaoCidade() {
			return edicaoCidade;
		}

		public void setEdicaoCidade(boolean pEdicaoCidade) {
			edicaoCidade = pEdicaoCidade;
		}

		public boolean isEdicaoEndereco() {
			return edicaoEndereco;
		}

		public void setEdicaoEndereco(boolean pEdicaoEndereco) {
			edicaoEndereco = pEdicaoEndereco;
		}

		public String getTela() {
			return tela;
		}

		public void setTela(String pTela) {
			tela = pTela;
		}

		public List<Cidade> getListaCidades() {
			return listaCidades;
		}

		public void setListaCidades(List<Cidade> pListaCidades) {
			listaCidades = pListaCidades;
		}
		
		public String limpar()
		{
			cpf = null;
			nome = null;
		    dataNascimento = null;
		    endereco = null;
		    codigo = null;
		    email = null;
		    telefone = null;
		    sexo = null;
		 	descricao = null;
		 	pais = null;
		 	estado = null;
			
			return tela;
		}
		
		public String cadastrar()
		{
			System.out.println("UsuarioVB - Cadastrar : " + this);
			
			Usuario tUsuario = new Usuario();
			tUsuario.setCodigo(codigo);
			
			tUsuario.setCpf(cpf);
			tUsuario.setNome(nome);
			LocalDate tDataNascimento = new java.sql.Date(dataNascimento.getTime()).toLocalDate();
	        tUsuario.setDataNascimento(tDataNascimento);
			tUsuario.setEndereco(endereco);
			tUsuario.setTelefone(telefone);
			tUsuario.setSexo(sexo);
			
			UsuarioController tController = new UsuarioController();
			
			UsuarioDto tDto = tController.cadastrarUsuario(tUsuario);
			if (tDto.isOk())
			{
				// Ok, incluído
				cpf = tDto.getUsuario().getCpf();
				
				// Colocando a mensaem do sistema
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
		
		public String consultarCidade()
	    {
	        System.out.println("UsuarioVB - consultarCidade : " + this);

	        CidadeController tController = new CidadeController();

	        CidadeDto tDto = tController.pesquisarCidadesPorEstado(estado);
	        if (tDto.isOk())
	        {
	            // Ok, recuperado
	            listaCidades = tDto.getLista();
	            edicaoCidade = ! listaCidades.isEmpty();
	        }
	        else
	        {
	            // Colocando a mensagem do sistema
	            FacesContext.getCurrentInstance().addMessage(null,
	                            new FacesMessage(FacesMessage.SEVERITY_ERROR, tDto.getMensagem(), tDto.getMensagem()));
	        }

	        return null;
	    }
		
		public void selecionarCidade()
		{
			edicaoEndereco = descricao == null;
		}
		
		public String alterar()
	    {
	        System.out.println("UsuarioVB - Alterar : " + this);

	        Usuario tUsuario = new Usuario();
	        tUsuario.setCpf(cpf);
	        tUsuario.setNome(nome);
	        LocalDate tDataNascimento = new java.sql.Date(dataNascimento.getTime()).toLocalDate();
	        tUsuario.setDataNascimento(tDataNascimento);
	        tUsuario.setEndereco(endereco);
	        tUsuario.setCodigo(codigo);
	        tUsuario.setEmail(email);
	        tUsuario.setTelefone(telefone);
	        tUsuario.setSexo(sexo);

	        UsuarioController tController = new UsuarioController();

	        UsuarioDto tDto = tController.atualizarUsuario(tUsuario);
	        if (tDto.isOk())
	        {
	            // Ok, alterado
	            cpf = tDto.getUsuario().getCpf();

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
	        System.out.println("UsuarioVB - Consultar : " + this);

	        UsuarioController tController = new UsuarioController();

	        UsuarioDto tDto = tController.recuperarUsuario(cpf);
	        if (tDto.isOk())
	        {
	            // Ok, recuperado
	            Usuario tUsuario = tDto.getUsuario();
	            cpf = tUsuario.getCpf();
	            nome = tUsuario.getNome();
	            dataNascimento = java.sql.Date.valueOf(tUsuario.getDataNascimento());
	            endereco = tUsuario.getEndereco();
	            codigo = tUsuario.getCodigo();
	            email = tUsuario.getEmail();
	            telefone = tUsuario.getTelefone();
	            sexo = tUsuario.getSexo();

	            // indicando que a pesquisa deu certo
	            edicao = true;
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
		
		public String excluir()
	    {
	        System.out.println("UsuarioVB - Excluir : " + this);

	        UsuarioController tController = new UsuarioController();

	        UsuarioDto tDto = tController.removeUsuario(cpf);
	        if (tDto.isOk())
	        {
	            // Ok, exluído
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

		@Override
		public String toString() {
			StringBuilder tBuilder = new StringBuilder();
			tBuilder.append("[ ");
			tBuilder.append(getCpf());
			tBuilder.append(", ");
			tBuilder.append(getNome());
			tBuilder.append(", ");
			tBuilder.append(getDataNascimento());
			tBuilder.append(", ");
			tBuilder.append(getEndereco());
			tBuilder.append(", ");
			tBuilder.append(getCodigo());
			tBuilder.append(", ");
			tBuilder.append(getEmail());
			tBuilder.append(", ");
			tBuilder.append(getTelefone());
			tBuilder.append(", ");
			tBuilder.append(getSexo());
			tBuilder.append(", ");
			tBuilder.append(getDescricao());
			tBuilder.append(", ");
			tBuilder.append(getPais());
			tBuilder.append(", ");
			tBuilder.append(getEstado());
			tBuilder.append(", ");
			tBuilder.append(isEdicao());
			tBuilder.append(", ");
			tBuilder.append(isEdicaoCidade());
			tBuilder.append(", ");
			tBuilder.append(getTela());
			tBuilder.append(", ");
			tBuilder.append(getListaCidades());
			tBuilder.append(" ]");
			return tBuilder.toString();
		}  
	    
}
