package br.edu.opet.ouvidoria.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Mensagem

{
    // Atributos

    //ID
    private int id;
    private long   cpf;
    private String nome;
    private int id_protocolo;
    private int id_assunto;
    private int id_setor;
    private int login;
    private Date data_mensagem ;
    private String status;
    private String conteudo;

    // Construtores

    public Mensagem()
    {
        super();
    }
    public Mensagem(int pId, int pId_Protocolo,int pId_Assunto, int pId_Setor,long pCpf, int pLogin,String pNome, Date pData_Mensagem,
   String pStatus, String pConteudo)

    {
        super();
        setId(pId);
        setId_Protocolo(pId_Protocolo);
        setId_Assunto(pId_Assunto);
        setId_Setor(pId_Setor);
        setCpf(pCpf);
        setNome(pNome);
        setLogin(pLogin);
        setData_Mensagem(pData_Mensagem);
        setStatus(pStatus);
        setConteudo(pConteudo);
    }

    // Métodos de acesso

    public int getId()
    {
        return id;
    }

    public void setId(int pId)
    {
        id = pId;
    }

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

    public void setId_Protocolo(int pId_Protocolo)
    {
    	id_protocolo = pId_Protocolo;
    }

    public int getId_Protocolo()
    {
        return id_protocolo;
    }

    public void setId_Assunto(int pId_Assunto)
    {
        id_assunto = pId_Assunto;
    }
    public int getId_Assunto()
    {
        return id_assunto;
    }

    public void setId_Setor(int pId_Setor)
    {
        id_setor = pId_Setor;
    }

    public int getId_Setor()
    {
        return id_setor;
    }

    public int getLogin()
    {
        return login;
    }

    public void setLogin(int pLogin)
    {
        login = pLogin;
    }


    public void setData_Mensagem(Date pData_Mensagem)
    {
        data_mensagem = pData_Mensagem;
    }

    public Date getData_Mensagem()
    {
        return data_mensagem;
    }


    public void setStatus(String pStatus)
    {
        status = pStatus;
    }

    public String getStatus()
    {
        return status;
    }


    public void setConteudo(String pConteudo)
    {
        conteudo = pConteudo;
    }

    public String getConteudo()
    {
        return conteudo;
    }

    // Métodos gerais

    @Override
    public String toString()
    {
        SimpleDateFormat tFormatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        StringBuilder tBuilder = new StringBuilder();
        tBuilder.append("[");
        tBuilder.append(getId());
        tBuilder.append(", ");
        tBuilder.append(getNome());
        tBuilder.append(", ");
        tBuilder.append(getId_Protocolo());
        tBuilder.append(", ");
        tBuilder.append(getId_Assunto());
        tBuilder.append(", ");
        tBuilder.append(getId_Setor());
        tBuilder.append(", ");
        tBuilder.append(tFormatador.format(getData_Mensagem()));
        tBuilder.append("]");
        tBuilder.append(getStatus());
        tBuilder.append("]");
        tBuilder.append(getConteudo());
        tBuilder.append("]");
        return tBuilder.toString();
    }

}


