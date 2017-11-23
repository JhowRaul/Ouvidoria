package br.edu.opet.ouvidoria.model;

public class Protocolo
{

 // Atributos

    private int id;
	private int numero;

    // Construtores
    public Protocolo()
    {
        super();
    }

    public Protocolo(int pId, int pNumero)
    {
        super();

        setId(pId);
        setNumero(pNumero);
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

        public int getNumero()
        {
            return numero;
        }

        public void setNumero(int pNumero)
        {
            numero = pNumero;
        }

        // Métodos gerais

        @Override
        public String toString()
        {
            StringBuilder tBuilder = new StringBuilder();
            tBuilder.append("[");
            tBuilder.append(getId());
            tBuilder.append(", ");
            tBuilder.append(getNumero());
            tBuilder.append("]");
            return tBuilder.toString();
        }
    }
