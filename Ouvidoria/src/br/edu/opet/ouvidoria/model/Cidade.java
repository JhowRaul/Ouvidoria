package br.edu.opet.ouvidoria.model;


public class Cidade
{

    // Atributos

   private int 	  codigo;
   private String descricao;
   private String pais;
   private String estado;

// Construtores

   public Cidade()
{
    super();

}

public Cidade(int pCodigo, String pDescricao, String pPais, String pEstado)
   {
       super();
       setCodigo(pCodigo);
       setDescricao(pDescricao);
       setPais(pPais);
       setEstado(pEstado);
   }

// M�todos de acesso
   public int getCodigo()
   {
       return codigo;
   }

   public void setCodigo(int pCodigo)
   {
       codigo = pCodigo;
   }


   public String getDescricao()
   {
       return descricao;
   }

   public void setDescricao(String pDescricao)
   {
       descricao = pDescricao;
   }

   public String getPais()
   {
       return pais;
   }

   public void setPais(String pPais)
   {
       pais = pPais;
   }
   public String getEstado()
   {
       return estado;
   }

   public void setEstado(String pEstado)
   {
       estado = pEstado;
   }

   // M�todos gerais

   @Override
   public String toString()
   {
       StringBuilder tBuilder = new StringBuilder();
       tBuilder.append("[");
       tBuilder.append(getCodigo());
       tBuilder.append(", ");
       tBuilder.append(getDescricao());
       tBuilder.append(", ");
       tBuilder.append(getPais());
       tBuilder.append(", ");
       tBuilder.append(getEstado());
       tBuilder.append("]");
       return tBuilder.toString();
   }
}
