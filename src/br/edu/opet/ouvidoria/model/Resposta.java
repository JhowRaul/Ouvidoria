package br.edu.opet.ouvidoria.model;

import java.time.LocalDate;

public class Resposta
{

	 // Atributos
	private int id;
    private String conteudo;
    private int id_protocolo;
    private LocalDate data;

    // Construtores

    public Resposta()
    {
        super();
    }
    public Resposta(int pId, String pConteudo, int pId_Protocolo, LocalDate pData)
    {
        super();
        setId(pId);
        setConteudo(pConteudo);
        setId_Protocolo(pId_Protocolo);
        setData(pData);
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


    public String getConteudo()
    {
        return conteudo;
    }

    public void setConteudo(String pConteudo)
    {
        conteudo = pConteudo;
    }


    public int getId_Protocolo()
    {
        return id_protocolo;
    }

    public void setId_Protocolo(int pId_Protocolo)
    {
        id_protocolo = pId_Protocolo;
    }

    public LocalDate getData()
    {
        return data;
    }

    public void setData(LocalDate pData)
    {
        data = pData;
    }
    // Métodos gerais

    @Override
    public String toString()
    {
        StringBuilder tBuilder = new StringBuilder();
        tBuilder.append("[");
        tBuilder.append(getId());
        tBuilder.append(", ");     
        tBuilder.append(getConteudo());
        tBuilder.append(", ");
        tBuilder.append(getId_Protocolo());
        tBuilder.append(", ");
        tBuilder.append(getData());
        tBuilder.append("]");
        return tBuilder.toString();
    }
}
