package br.edu.opet.ouvidoria.model;

public class Setor
{

// Atributos
    private int id;
    private String nome;

 // Construtores

    public Setor()
    {
        super();
    }
    public Setor(int pId, String pNome)
    {
        super();
        setId(pId);
        setNome(pNome);
    }

    // M�todos de acesso

    public int getId()
    {
        return id;
    }

    public void setId(int pId)
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

    // M�todos gerais

    @Override
    public String toString()
    {
        StringBuilder tBuilder = new StringBuilder();
        tBuilder.append("[");
        tBuilder.append(getId());
        tBuilder.append(", ");
        tBuilder.append(getNome());
        tBuilder.append(", ");
        tBuilder.append("]");
        return tBuilder.toString();
    }
}

