package br.edu.opet.ouvidoria.model;

import java.time.LocalDate;

public class Usuario
{

    // Atributos

	private long   cpf;
	private String nome;
    private LocalDate dataNascimento;
    private String endereco;
    private int codigo;
    private String email;
    private long   telefone;
    private String sexo;

    // Construtores

    public Usuario()
    {
        super();
    }

    public Usuario(long pCpf, String pNome, LocalDate pDataNascimento,String pEndereco, int pCodigo, String pEmail,long pTelefone, String pSexo)
    {
        super();
        setCpf(pCpf);
        setNome(pNome);
        setDataNascimento(pDataNascimento);
        setEndereco(pEndereco);
        setCodigo(pCodigo);
        setEmail(pEmail);
        setTelefone(pTelefone);
        setSexo(pSexo);


    }

    // M�todos de Usuario

    public long getCpf()
    {
        return cpf;
    }


    public void setCpf(long pCpf)
    {
        cpf = pCpf;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String pNome)
    {
        nome = pNome;
    }

    public LocalDate getDataNascimento()
    {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate pDataNascimento)
    {
        dataNascimento = pDataNascimento;
    }


    public String getEndereco()
    {
        return endereco;
    }

    public void setEndereco(String pEndereco)
    {
        endereco = pEndereco;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int pCodigo) {
        codigo = pCodigo;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String pEmail)
    {
        email = pEmail;
    }

    public long getTelefone()
    {
        return telefone;
    }

    public void setTelefone(long pTelefone)
    {
        telefone = pTelefone;
    }

    public String getSexo()
    {
        return sexo;
    }

    public void setSexo(String i)
    {
        sexo = i;
    }



    // M�todos gerais

    @Override
    public String toString()
    {


        StringBuilder tBuilder = new StringBuilder();
        tBuilder.append("[");
        tBuilder.append(getCpf());
        tBuilder.append("]");
        tBuilder.append(getNome());
        tBuilder.append("]");
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
        tBuilder.append("]");
        return tBuilder.toString();
    }
}

