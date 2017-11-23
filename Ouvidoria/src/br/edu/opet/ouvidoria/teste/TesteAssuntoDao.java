package br.edu.opet.ouvidoria.teste;

import java.util.List;

import br.edu.opet.ouvidoria.dao.AssuntoDao;
import br.edu.opet.ouvidoria.model.Assunto;

public class TesteAssuntoDao {

	    public static void main(String[] pArgs)
	    {
	        // Criar um Assunto
	        Assunto tAssuntoA = new Assunto(0, "a");
	        Assunto tAssuntoB = new Assunto(0, "iii");

	        // Criando o objeto de persistência
	        AssuntoDao tDao = new AssuntoDao();

	        // Incluir o Assunto
	        System.out.println();
	        System.out.println("Incluindo");
	        Assunto tAssunto2a = tDao.create(tAssuntoA);
	        if (tAssunto2a != null)
	            System.out.println("OK...... : " + tAssunto2a);
	        else
	            System.out.println("ERRO.... : " + tAssunto2a);
	        Assunto tAssunto2b = tDao.create(tAssuntoB);
	        if (tAssunto2b != null)
	            System.out.println("OK...... : " + tAssunto2b);
	        else
	            System.out.println("ERRO.... : " + tAssunto2b);

	        // Recuperando o Assunto
	        System.out.println();
	        System.out.println("Recuperando");
	        Assunto tAssunto3a = tDao.recovery(tAssunto2a.getId());
	        if (tAssunto3a != null)
	            System.out.println("OK...... : " + tAssunto3a);
	        else
	            System.out.println("ERRO.... : " + tAssunto3a);
	        Assunto tAssunto3b = tDao.recovery(tAssunto2b.getId());
	        if (tAssunto3b != null)
	            System.out.println("OK...... : " + tAssunto3b);
	        else
	            System.out.println("ERRO.... : " + tAssunto3b);

	        // Atualizando o Assunto
	        System.out.println();
	        System.out.println("Atualizando");
	        tAssunto2a.setAssunto(tAssunto2a.getAssunto() + " outras");
	        Assunto tAssunto4a = tDao.update(tAssunto2a);
	        if (tAssunto4a != null)
	            System.out.println("OK...... : " + tAssunto4a);
	        else
	            System.out.println("ERRO.... : " + tAssunto4a);

	        tAssunto2b.setAssunto(tAssunto2b.getAssunto() + " Sundreco");
	        Assunto tAssunto4b = tDao.update(tAssunto2b);
	        if (tAssunto4a != null)
	            System.out.println("OK...... : " + tAssunto4b);
	        else
	            System.out.println("ERRO.... : " + tAssunto4b);

	        // Recuperando o Assunto
	        System.out.println();
	        System.out.println("Recuperando");
	        Assunto tAssunto5a = tDao.recovery(tAssunto2a.getId());
	        if (tAssunto5a != null)
	            System.out.println("OK...... : " + tAssunto5a);
	        else
	            System.out.println("ERRO.... : " + tAssunto5a);
	        Assunto tAssunto5b = tDao.recovery(tAssunto2b.getId());
	        if (tAssunto5b != null)
	            System.out.println("OK...... : " + tAssunto5b);
	        else
	            System.out.println("ERRO.... : " + tAssunto5b);

	        // Listar os Assuntos
	        List<Assunto> tLista = tDao.search();
	        System.out.println();
	        System.out.println("Pesquisando");
	        for (Assunto tAssunto : tLista)
	        {
	            System.out.println("OK...... : " + tAssunto);
	        }

	        // Remover o Assunto
	        System.out.println();
	        System.out.println("Removendo");
	        if (tDao.delete(tAssunto2a.getId()))
	            System.out.println("OK...... : " + tAssunto2a);
	        else
	            System.out.println("ERRO.... : " + tAssunto2a);
	        if (tDao.delete(tAssunto2b.getId()))
	            System.out.println("OK...... : " + tAssunto2b);
	        else
	            System.out.println("ERRO.... : " + tAssunto2b);

	        // Verificando se removeu
	        System.out.println();
	        System.out.println("Verificando a remoção");
	        if (tDao.delete(tAssunto2a.getId()))
	            System.out.println("ERRO.... : " + tAssunto2a);
	        else
	            System.out.println("OK...... : " + tAssunto2a);
	        if (tDao.delete(tAssunto2b.getId()))
	            System.out.println("ERRO.... : " + tAssunto2b);
	        else
	            System.out.println("OK...... : " + tAssunto2b);
	    }

	}
