package br.edu.opet.ouvidoria.teste;

import java.util.List;

import br.edu.opet.ouvidoria.dao.CidadeDao;
import br.edu.opet.ouvidoria.model.Cidade;

public class TesteCidadeDao
{
    public static void main(String[] pArgs)
    {
        // Criar um Cidade
        Cidade tCidadeA = new Cidade(0, "PR", "Brasil", "Paraná");
        Cidade tCidadeB = new Cidade(0, "SC", "Brasil", "Santa Catarina");

        // Criando o objeto de persistência
        CidadeDao tDao = new CidadeDao();

        // Incluir o Cidade
        System.out.println();
        System.out.println("Incluindo");
        Cidade tCidade2a = tDao.create(tCidadeA);
        if (tCidade2a != null)
            System.out.println("OK...... : " + tCidade2a);
        else
            System.out.println("ERRO.... : " + tCidade2a);
        Cidade tCidade2b = tDao.create(tCidadeB);
        if (tCidade2b != null)
            System.out.println("OK...... : " + tCidade2b);
        else
            System.out.println("ERRO.... : " + tCidade2b);

     // Recuperando o cidade
        System.out.println();
        System.out.println("Recuperando");
        Cidade tCidade3a = tDao.recovery(tCidade2a.getCodigo());
        if (tCidade3a != null)
            System.out.println("OK...... : " + tCidade3a);
        else
            System.out.println("ERRO.... : " + tCidade3a);
        Cidade tCidade3b = tDao.recovery(tCidade2b.getCodigo());
        if (tCidade3b != null)
            System.out.println("OK...... : " + tCidade3b);
        else
            System.out.println("ERRO.... : " + tCidade3b);

        // Atualizando a Cidade
        System.out.println();
        System.out.println("Atualizando");
        tCidade2a.setDescricao(tCidade2a.getDescricao() + " outras");
        Cidade tCidade4a = tDao.update(tCidade2a);
        if (tCidade4a != null)
            System.out.println("OK...... : " + tCidade4a);
        else
            System.out.println("ERRO.... : " + tCidade4a);

        tCidade2b.setDescricao(tCidade2b.getDescricao() + " Sundreco");
        Cidade tCidade4b = tDao.update(tCidade2b);
        if (tCidade4a != null)
            System.out.println("OK...... : " + tCidade4b);
        else
            System.out.println("ERRO.... : " + tCidade4b);

        // Recuperando o Cidade
        System.out.println();
        System.out.println("Recuperando");
        Cidade tCidade5a = tDao.recovery(tCidade2a.getCodigo());
        if (tCidade5a != null)
            System.out.println("OK...... : " + tCidade5a);
        else
            System.out.println("ERRO.... : " + tCidade5a);
        Cidade tCidade5b = tDao.recovery(tCidade2b.getCodigo());
        if (tCidade5b != null)
            System.out.println("OK...... : " + tCidade5b);
        else
            System.out.println("ERRO.... : " + tCidade5b);

        // Listar os Cidades
        List<Cidade> tLista = tDao.search();
        System.out.println();
        System.out.println("Pesquisando");
        for (Cidade tCidade : tLista)
        {
            System.out.println("OK...... : " + tCidade);
        }

        // Remover o Cidade
        System.out.println();
        System.out.println("Removendo");
        if (tDao.delete(tCidade2a.getCodigo()))
            System.out.println("OK...... : " + tCidade2a);
        else
            System.out.println("ERRO.... : " + tCidade2a);
        if (tDao.delete(tCidade2b.getCodigo()))
            System.out.println("OK...... : " + tCidade2b);
        else
            System.out.println("ERRO.... : " + tCidade2b);

        // Verificando se removeu
        System.out.println();
        System.out.println("Verificando a remoção");
        if (tDao.delete(tCidade2a.getCodigo()))
            System.out.println("ERRO.... : " + tCidade2a);
        else
            System.out.println("OK...... : " + tCidade2a);
        if (tDao.delete(tCidade2b.getCodigo()))
            System.out.println("ERRO.... : " + tCidade2b);
        else
            System.out.println("OK...... : " + tCidade2b);
    }

}