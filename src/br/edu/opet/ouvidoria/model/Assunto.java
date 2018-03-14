package br.edu.opet.ouvidoria.model;

public class Assunto
{


	 // Atributos

	private int id;
    private String assunto;

 // Construtores

    public Assunto()
    {
        super();
    }
    public Assunto(int pId, String pAssunto)
    {
        super();
        setId(pId);
        setAssunto(pAssunto);
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


    public String getAssunto()
    {
        return assunto;
    }

    public void setAssunto(String pAssunto)
    {
        assunto = pAssunto;
    }


    // Métodos gerais

    @Override
    public String toString()
    {
        StringBuilder tBuilder = new StringBuilder();
        tBuilder.append("[");
        tBuilder.append(getId());
        tBuilder.append(",");
        tBuilder.append(getAssunto());
        tBuilder.append("]");
        return tBuilder.toString();
    }
}
