package br.edu.opet.ouvidoria.jsf.javabean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.time.LocalDate;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.opet.ouvidoria.controller.Acesso_FuncionarioController;
import br.edu.opet.ouvidoria.controller.AssuntoController;
import br.edu.opet.ouvidoria.controller.MensagemController;
import br.edu.opet.ouvidoria.controller.ProtocoloController;
import br.edu.opet.ouvidoria.controller.SetorController;
import br.edu.opet.ouvidoria.controller.UsuarioController;
import br.edu.opet.ouvidoria.dto.Acesso_FuncionarioDto;
import br.edu.opet.ouvidoria.dto.AssuntoDto;
import br.edu.opet.ouvidoria.dto.MensagemDto;
import br.edu.opet.ouvidoria.dto.ProtocoloDto;
import br.edu.opet.ouvidoria.dto.SetorDto;
import br.edu.opet.ouvidoria.dto.UsuarioDto;
import br.edu.opet.ouvidoria.model.Acesso_Funcionario;
import br.edu.opet.ouvidoria.model.Assunto;
import br.edu.opet.ouvidoria.model.Mensagem;
import br.edu.opet.ouvidoria.model.Protocolo;
import br.edu.opet.ouvidoria.model.Setor;
import br.edu.opet.ouvidoria.model.Usuario;

/* Nesse JavaBean já concluí-se dos @ManagedBean: 
 * 		* Mensagem
 *		* Protocolo 
 *						Das já concluídas: Acesso_Funcionario e Usuário
 *
 *						Das faltantes: 	   Assunto, Cidade, Setor (3 simples) e resposta (1 detalhada)
 */

 	//	Prioridade: Concluir as Views dos CRUDS das ja concluídos e essa View (Mensagem).
 

@ViewScoped
@ManagedBean(name = "MensagemVB")
public class MensagemJavaBean {
	// Atributos
    private Integer id;
    private Long   cpf_usuario;
    private String nome_usuario;
    private Integer id_protocolo;
    private Integer numero_protocolo;
    private Integer id_assunto;
    private String assunto;
    private Integer id_setor;
    private String nome_setor;
    private Integer login_funcionario;
    private Date data_mensagem ;
    private Date hora_mensagem;
    private String status;
    private String conteudo;
    private String tela;
    private boolean edicaoMensagem;
    private boolean edicaoAssunto;
    private boolean edicaoUsuario;
    private boolean edicaoProtocolo;
    private boolean edicaoAcesso_Funcionario;
    private boolean edicaoSetor;
    private Usuario usuario;
    
    
    
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario pUsuario) {
		usuario = pUsuario;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer pId) {
		id = pId;
	}
	
	public Long getCpf_usuario() {
		return cpf_usuario;
	}

	public void setCpf_usuario(Long pCpf_usuario) {
		cpf_usuario = pCpf_usuario;
	}

	public String getNome_usuario() {
		return nome_usuario;
	}

	public void setNome_usuario(String pNome_usuario) {
		nome_usuario = pNome_usuario;
	}

	public Integer getId_protocolo() {
		return id_protocolo;
	}

	public void setId_protocolo(Integer pId_protocolo) {
		id_protocolo = pId_protocolo;
	}

	public Integer getNumero_protocolo() {
		return numero_protocolo;
	}

	public void setNumero_protocolo(Integer pNumero_protocolo) {
		numero_protocolo = pNumero_protocolo;
	}

	public Integer getId_assunto() {
		return id_assunto;
	}

	public void setId_assunto(Integer pId_assunto) {
		id_assunto = pId_assunto;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String pAssunto) {
		assunto = pAssunto;
	}

	public Integer getId_setor() {
		return id_setor;
	}

	public void setId_setor(Integer pId_setor) {
		id_setor = pId_setor;
	}

	public String getNome_setor() {
		return nome_setor;
	}

	public void setNome_setor(String pNome_setor) {
		nome_setor = pNome_setor;
	}

	public Integer getLogin_funcionario() {
		return login_funcionario;
	}

	public void setLogin_funcionario(Integer pLogin_funcionario) {
		login_funcionario = pLogin_funcionario;
	}

	public Date getData_mensagem() {
		return data_mensagem;
	}

	public void setData_mensagem(Date pData_mensagem) {
		data_mensagem = pData_mensagem;
	}

	public Date getHora_mensagem() {
		return hora_mensagem;
	}

	public void setHora_mensagem(Date pHora_mensagem) {
		hora_mensagem = pHora_mensagem;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String pStatus) {
		status = pStatus;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String pConteudo) {
		conteudo = pConteudo;
	}

	public String getTela() {
		return tela;
	}

	public void setTela(String pTela) {
		tela = pTela;
	}

	public boolean isEdicaoMensagem() {
		return edicaoMensagem;
	}

	public void setEdicaoMensagem(boolean pEdicaoMensagem) {
		edicaoMensagem = pEdicaoMensagem;
	}

	public boolean isEdicaoAssunto() {
		return edicaoAssunto;
	}

	public void setEdicaoAssunto(boolean pEdicaoAssunto) {
		edicaoAssunto = pEdicaoAssunto;
	}

	public boolean isEdicaoUsuario() {
		return edicaoUsuario;
	}

	public void setEdicaoUsuario(boolean pEdicaoUsuario) {
		edicaoUsuario = pEdicaoUsuario;
	}

	public boolean isEdicaoProtocolo() {
		return edicaoProtocolo;
	}

	public void setEdicaoProtocolo(boolean pEdicaoProtocolo) {
		edicaoProtocolo = pEdicaoProtocolo;
	}

	public boolean isEdicaoAcesso_Funcionario() {
		return edicaoAcesso_Funcionario;
	}

	public void setEdicaoAcesso_Funcionario(boolean pEdicaoAcesso_Funcionario) {
		edicaoAcesso_Funcionario = pEdicaoAcesso_Funcionario;
	}

	public boolean isEdicaoSetor() {
		return edicaoSetor;
	}

	public void setEdicaoSetor(boolean pEdicaoSetor) {
		edicaoSetor = pEdicaoSetor;
	}


	@PostConstruct
    public void init()
    {
        Mensagem tMensagem = (Mensagem) FacesContext.getCurrentInstance().getExternalContext()
                        .getRequestMap().get("MENSAGEM");
        if (tMensagem != null)
        {
            id = tMensagem.getId();
            cpf_usuario = tMensagem.getCpf();
            id_protocolo = tMensagem.getId_Protocolo();
            id_assunto = tMensagem.getId_Assunto();
            login_funcionario = tMensagem.getLogin();
            id_setor = tMensagem.getId_Setor();
            
            UsuarioController tUsuarioController = new UsuarioController();
            
            UsuarioDto tUsuarioDto = tUsuarioController.recuperarUsuario(cpf_usuario);
            if (tUsuarioDto.isOk())
            {
            	Usuario tUsuario = tUsuarioDto.getUsuario();
            	cpf_usuario = tUsuario.getCpf();
	            nome_usuario = tUsuario.getNome();
            }
            else
            {
            	cpf_usuario = null;
	            nome_usuario = null;
            }

            ProtocoloController tProtocoloController = new ProtocoloController();

            ProtocoloDto tProtocoloDto = tProtocoloController.recuperarProtocolo(id_protocolo);
            if (tProtocoloDto.isOk())
            {
                Protocolo tProtocolo = tProtocoloDto.getProtocolo();
                id_protocolo = tProtocolo.getId();
                numero_protocolo = tProtocolo.getNumero();
            }
            else
            {
                id_protocolo = null;
                numero_protocolo = null;
            }

            AssuntoController tAssuntoController = new AssuntoController();

            AssuntoDto tAssuntoDto = tAssuntoController.recuperarAssunto(id_assunto);
            if (tAssuntoDto.isOk())
            {
                Assunto tAssunto = tAssuntoDto.getAssunto();
                id_assunto = tAssunto.getId();
                assunto = tAssunto.getAssunto();
            }
            else
            {
                assunto=null;
            }
            
            Acesso_FuncionarioController tAcesso_FuncionarioController = new Acesso_FuncionarioController();

            Acesso_FuncionarioDto tAcesso_FuncionarioDto = tAcesso_FuncionarioController.recuperarAcesso_Funcionario(login_funcionario);
            if (tAcesso_FuncionarioDto.isOk())
            {
                Acesso_Funcionario tAcesso_Funcionario = tAcesso_FuncionarioDto.getAcesso_Funcionario();
                login_funcionario = tAcesso_Funcionario.getLogin();
            }
            else
            {
            	login_funcionario = null;
            }
            
            SetorController tSetorController = new SetorController();

            SetorDto tSetorDto = tSetorController.recuperarSetor(id_setor);
            if (tSetorDto.isOk())
            {
                Setor tSetor = tSetorDto.getSetor();
                id_setor = tSetor.getId();
                nome_setor = tSetor.getNome();
            }
            else
            {
                assunto=null;
            }
            
            
            data_mensagem = tMensagem.getData_Mensagem();
            hora_mensagem = tMensagem.getData_Mensagem();
            status = tMensagem.getStatus();
            conteudo = tMensagem.getConteudo();
            edicaoMensagem = true;            
            edicaoProtocolo = true;
            edicaoUsuario = true;
            edicaoAssunto = true;
            edicaoAcesso_Funcionario = true;
            edicaoSetor = true;            
        }
    }
	
	// Métodos da controller
	public String limpar()
	{
		id = null;
	    cpf_usuario = null;
	    nome_usuario = null;
	    id_protocolo = null;
	    numero_protocolo = null;
	    id_assunto = null;
	    assunto = null;
	    id_setor = null;
	    nome_setor = null;
	    login_funcionario = null;
	    data_mensagem = null;
	    hora_mensagem = null;
	    status = null;
	    conteudo = null;
	    edicaoMensagem = false;
	    edicaoAssunto = false;
	    edicaoUsuario = false;
	    edicaoProtocolo = false;
	    edicaoAcesso_Funcionario = false;
	    edicaoSetor = false;
	    
	    return tela;
	}
	
	public String cadastrar()
	{
		System.out.println("MensagemVB - Cadastrar : " + this);

        Mensagem tMensagem = new Mensagem();
        tMensagem.setId_Protocolo(id_protocolo);
        tMensagem.setId_Assunto(id_assunto);
        tMensagem.setCpf(cpf_usuario);
        tMensagem.setLogin(login_funcionario);
        tMensagem.setId_Setor(id_setor);

        // Pegando a data e hora e convertendo somente para uma data
        SimpleDateFormat tFormatadorData = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat tFormatadorHora = new SimpleDateFormat("HH:mm");
        SimpleDateFormat tConversorData = new SimpleDateFormat("dd/MM/yyyy-HH:mm");
        String tData = tFormatadorData.format(data_mensagem);
        String tHora = tFormatadorHora.format(hora_mensagem);        
        Date tDataMensagem;
        try
        {
            tDataMensagem = tConversorData.parse(tData + "-" + tHora);
            tMensagem.setData_Mensagem(tDataMensagem);;
        }
        catch (ParseException tExcept)
        {
            tExcept.printStackTrace();
        }
        
        tMensagem.setStatus(status);
        tMensagem.setConteudo(conteudo);

        MensagemController tController = new MensagemController();

        MensagemDto tDto = tController.cadastrarMensagem(tMensagem);
        if (tDto.isOk())
        {
            // Ok, inclu�do
            id = tDto.getMensagem().getId();

            // Colocando a mensagem do sistema
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, tDto.getMensage(), tDto.getMensage()));	
        }
        else
        {
            // Erro de inclus�o

            // Colocando a mensagem do sistema
            FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR, tDto.getMensage(), tDto.getMensage()));
        }
        return null;
	}
	
	public void consultarProtocolo()
	{
		// Tem que gerar um protocolo
	}
	
	public String consultarAssunto()
	{

        System.out.println("MensagemVB - consultarAssunto : " + this);

        AssuntoController tController = new AssuntoController();

        AssuntoDto tDto = tController.recuperarAssunto(id_assunto);
        if (tDto.isOk())
        {
            // Ok, recuperado
            Assunto tAssunto = tDto.getAssunto();
            id_assunto = tAssunto.getId();
            assunto = tAssunto.getAssunto();
            
            // Indicando que a pesquisa deu certo
            edicaoAssunto = true;
        }
        else
        {
        	// Erro de consulta
        	edicaoAssunto = false;
        	
            // Colocando a mensagem do sistema
            FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR, tDto.getMensagem(), tDto.getMensagem()));
        }

        return null;
	}
	
	public String consultarUsuario()
	{
		System.out.println("MensagemVB - consultarUsuario : " + this);

        UsuarioController tController = new UsuarioController();

        UsuarioDto tDto = tController.recuperarUsuario(cpf_usuario);
        if (tDto.isOk())
        {
            // Ok, recuperado
            Usuario tUsuario = tDto.getUsuario();
            cpf_usuario = tUsuario.getCpf();
            nome_usuario = tUsuario.getNome();
            
            // Indicando que a pesquisa deu certo
            edicaoUsuario = true;
        }
        else
        {
        	// Erro de consulta
        	edicaoUsuario = false;
        	
            // Colocando a mensagem do sistema
            FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR, tDto.getMensagem(), tDto.getMensagem()));
        }

        return null;
	}
	
	public String consultarAcesso_Funcionario()
	{
		System.out.println("MensagemVB - consultarFuncionario : " + this);

        Acesso_FuncionarioController tController = new Acesso_FuncionarioController();

        Acesso_FuncionarioDto tDto = tController.recuperarAcesso_Funcionario(login_funcionario);
        if (tDto.isOk())
        {
            // Ok, recuperado
            Acesso_Funcionario tAcesso_Funcionario = tDto.getAcesso_Funcionario();
            login_funcionario = tAcesso_Funcionario.getLogin();
            
            // Indicando que a pesquisa deu certo
            edicaoAcesso_Funcionario = true;
        }
        else
        {
        	// Erro de consulta
        	edicaoAcesso_Funcionario = false;
        	
            // Colocando a mensagem do sistema
            FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR, tDto.getMensagem(), tDto.getMensagem()));
        }

        return null;
	}
	
	public String consultarSetor()
	{
		System.out.println("MensagemVB - consultarSetor : " + this);

        SetorController tController = new SetorController();

        SetorDto tDto = tController.recuperarSetor(login_funcionario);
        if (tDto.isOk())
        {
            // Ok, recuperado
            Setor tSetor = tDto.getSetor();
            id_setor = tSetor.getId();
            nome_setor = tSetor.getNome();
            
            // Indicando que a pesquisa deu certo
            edicaoSetor = true;
        }
        else
        {
        	// Erro de consulta
        	edicaoSetor = false;
        	
            // Colocando a mensagem do sistema
            FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR, tDto.getMensagem(), tDto.getMensagem()));
        }

        return null;
	}
	
	public String alterar()
	{
		System.out.println("MensagemVB - Alterar : " + this);

        Mensagem tMensagem = new Mensagem();
        tMensagem.setCpf(cpf_usuario);
        tMensagem.setNome(nome_usuario);
        tMensagem.setId_Protocolo(id_protocolo);
        tMensagem.setId_Assunto(id_assunto);
        tMensagem.setId_Setor(id_setor);
        tMensagem.setLogin(login_funcionario);
        
        // Colocar data e hora de alteração
        //LocalDate tDataMensagem = new java.sql.Date(data_mensagem.getTime()).toLocalDate();                    
        tMensagem.setStatus(status);
        tMensagem.setConteudo(conteudo);

        MensagemController tController = new MensagemController();

        MensagemDto tDto = tController.atualizarMensagem(tMensagem);
        if (tDto.isOk())
        {
            // Ok, alterado
            id = tDto.getMensagem().getId();

            // Colocando a mensagem do sistema
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, tDto.getMensage(), tDto.getMensage()));
        }
        else
        {
        	// Erro de consulta
        	edicaoSetor = false;
        	
            // Colocando a mensagem do sistema
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, tDto.getMensage(), tDto.getMensage()));
        }
        return null;
	}
	
	public void consultar()
	{
		
	}
	
	public void excluir()
	{
		
	}	
}
