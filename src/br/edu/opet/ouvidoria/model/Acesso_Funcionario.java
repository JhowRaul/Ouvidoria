package br.edu.opet.ouvidoria.model;

public class Acesso_Funcionario
{

    // Atributos

	private int login;
    private String senha;
    private String nome;
    private int matricula;
    private int	codigo;

    // Construtores

    public Acesso_Funcionario()
    {
        super();
    }

    public Acesso_Funcionario(int pLogin, String pSenha, int pMatricula, String pNome, int pCodigo)
    {

    	super ();
    	setLogin(pLogin);
        setSenha(pSenha);
        setNome(pNome);
        setMatricula(pMatricula);
        setCodigo(pCodigo);

    }

    // M�todos de acesso

    public int getLogin()
    {
        return login;
    }

    public void setLogin(int pLogin)
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

    public int getMatricula()
    {
        return matricula;
    }

    public void setMatricula(int pMatricula)
    {
        matricula = pMatricula;
    }

    public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int pCodigo) {
		codigo = pCodigo;
	}

	// M�todos gerais

	@Override
    public String toString()
    {
        StringBuilder tBuilder = new StringBuilder();
        tBuilder.append("[");
        tBuilder.append(getLogin());
        tBuilder.append(", ");
        tBuilder.append(getSenha());
        tBuilder.append(", ");
        tBuilder.append(getMatricula());
        tBuilder.append(", ");
        tBuilder.append(getCodigo());
        tBuilder.append("] ");
        return tBuilder.toString();
    }
}

