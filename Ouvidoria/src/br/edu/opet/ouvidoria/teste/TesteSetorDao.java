package br.edu.opet.ouvidoria.teste;

import java.util.List;

import br.edu.opet.ouvidoria.dao.SetorDao;
import br.edu.opet.ouvidoria.model.Setor;

public class TesteSetorDao
{public static void main(String[] pArgs)
{
    // Criar um Setor
    Setor tSetorA = new Setor(0, "a");
    Setor tSetorB = new Setor(0, "iii");

    // Criando o objeto de persistência
    SetorDao tDao = new SetorDao();

    // Incluir o Setor
    System.out.println();
    System.out.println("Incluindo");
    Setor tSetor2a = tDao.create(tSetorA);
    if (tSetor2a != null)
        System.out.println("OK...... : " + tSetor2a);
    else
        System.out.println("ERRO.... : " + tSetor2a);
    Setor tSetor2b = tDao.create(tSetorB);
    if (tSetor2b != null)
        System.out.println("OK...... : " + tSetor2b);
    else
        System.out.println("ERRO.... : " + tSetor2b);

    // Recuperando o Setor
    System.out.println();
    System.out.println("Recuperando");
    Setor tSetor3a = tDao.recovery(tSetor2a.getId());
    if (tSetor3a != null)
        System.out.println("OK...... : " + tSetor3a);
    else
        System.out.println("ERRO.... : " + tSetor3a);
    Setor tSetor3b = tDao.recovery(tSetor2b.getId());
    if (tSetor3b != null)
        System.out.println("OK...... : " + tSetor3b);
    else
        System.out.println("ERRO.... : " + tSetor3b);

    // Atualizando o Setor
    System.out.println();
    System.out.println("Atualizando");
    tSetor2a.setNome(tSetor2a.getNome() + " outras");
    Setor tSetor4a = tDao.update(tSetor2a);
    if (tSetor4a != null)
        System.out.println("OK...... : " + tSetor4a);
    else
        System.out.println("ERRO.... : " + tSetor4a);

    tSetor2b.setNome(tSetor2b.getNome() + " Sundreco");
    Setor tSetor4b = tDao.update(tSetor2b);
    if (tSetor4a != null)
        System.out.println("OK...... : " + tSetor4b);
    else
        System.out.println("ERRO.... : " + tSetor4b);

    // Recuperando o Setor
    System.out.println();
    System.out.println("Recuperando");
    Setor tSetor5a = tDao.recovery(tSetor2a.getId());
    if (tSetor5a != null)
        System.out.println("OK...... : " + tSetor5a);
    else
        System.out.println("ERRO.... : " + tSetor5a);
    Setor tSetor5b = tDao.recovery(tSetor2b.getId());
    if (tSetor5b != null)
        System.out.println("OK...... : " + tSetor5b);
    else
        System.out.println("ERRO.... : " + tSetor5b);

    // Listar os Setors
    List<Setor> tLista = tDao.search();
    System.out.println();
    System.out.println("Pesquisando");
    for (Setor tSetor : tLista)
    {
        System.out.println("OK...... : " + tSetor);
    }

    // Remover o Setor
    System.out.println();
    System.out.println("Removendo");
    if (tDao.delete(tSetor2a.getId()))
        System.out.println("OK...... : " + tSetor2a);
    else
        System.out.println("ERRO.... : " + tSetor2a);
    if (tDao.delete(tSetor2b.getId()))
        System.out.println("OK...... : " + tSetor2b);
    else
        System.out.println("ERRO.... : " + tSetor2b);

    // Verificando se removeu
    System.out.println();
    System.out.println("Verificando a remoção");
    if (tDao.delete(tSetor2a.getId()))
        System.out.println("ERRO.... : " + tSetor2a);
    else
        System.out.println("OK...... : " + tSetor2a);
    if (tDao.delete(tSetor2b.getId()))
        System.out.println("ERRO.... : " + tSetor2b);
    else
        System.out.println("OK...... : " + tSetor2b);
}

}
