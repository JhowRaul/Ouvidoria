package br.edu.opet.ouvidoria.teste;

import java.util.List;

import br.edu.opet.ouvidoria.dao.Acesso_FuncionarioDao;
import br.edu.opet.ouvidoria.model.Acesso_Funcionario;

public class TesteAcesso_FuncionarioDao
{
    public static void main(String[] pArgs)
    {
        // Criar um Acesso_Funcionario
        Acesso_Funcionario tAcesso_FuncionarioA = new Acesso_Funcionario(0, "E5465", 3432, "eddd", 0);
        Acesso_Funcionario tAcesso_FuncionarioB = new Acesso_Funcionario(0, "54513", 22222, "pat", 0);

        // Criando o objeto de persist�ncia
        Acesso_FuncionarioDao tDao = new Acesso_FuncionarioDao();

        // Incluir o Acesso_Funcionario
        System.out.println();
        System.out.println("Incluindo");
        Acesso_Funcionario tAcesso_Funcionario2a = tDao.create(tAcesso_FuncionarioA);
        if (tAcesso_Funcionario2a != null)
            System.out.println("OK...... : " + tAcesso_Funcionario2a);
        else
            System.out.println("ERRO.... : " + tAcesso_Funcionario2a);
        Acesso_Funcionario tAcesso_Funcionario2b = tDao.create(tAcesso_FuncionarioB);
        if (tAcesso_Funcionario2b != null)
            System.out.println("OK...... : " + tAcesso_Funcionario2b);
        else
            System.out.println("ERRO.... : " + tAcesso_Funcionario2b);

        // Recuperando o Acesso_Funcionario
        System.out.println();
        System.out.println("Recuperando");
        Acesso_Funcionario tAcesso_Funcionario3a = tDao.recovery(tAcesso_Funcionario2a.getLogin());
        if (tAcesso_Funcionario3a != null)
            System.out.println("OK...... : " + tAcesso_Funcionario3a);
        else
            System.out.println("ERRO.... : " + tAcesso_Funcionario3a);
        Acesso_Funcionario tAcesso_Funcionario3b = tDao.recovery(tAcesso_Funcionario2b.getLogin());
        if (tAcesso_Funcionario3b != null)
            System.out.println("OK...... : " + tAcesso_Funcionario3b);
        else
            System.out.println("ERRO.... : " + tAcesso_Funcionario3b);

        // Atualizando o Acesso_Funcionario
        System.out.println();
        System.out.println("Atualizando");
        tAcesso_Funcionario2a.setSenha(tAcesso_Funcionario2a.getNome() + " Sentercio");
        tAcesso_Funcionario2a.setMatricula(4444);
        tAcesso_Funcionario2a.setNome("pat jul");
        Acesso_Funcionario tAcesso_Funcionario4a = tDao.update(tAcesso_Funcionario2a);
        if (tAcesso_Funcionario4a != null)
            System.out.println("OK...... : " + tAcesso_Funcionario4a);
        else
            System.out.println("ERRO.... : " + tAcesso_Funcionario4a);

        tAcesso_Funcionario2b.setSenha(tAcesso_Funcionario2b.getNome() + " Sundreco");
        tAcesso_Funcionario2b.setMatricula(2222);
        tAcesso_Funcionario2b.setNome("julieta");
        Acesso_Funcionario tAcesso_Funcionario4b = tDao.update(tAcesso_Funcionario2b);
        if (tAcesso_Funcionario4a != null)
            System.out.println("OK...... : " + tAcesso_Funcionario4b);
        else
            System.out.println("ERRO.... : " + tAcesso_Funcionario4b);

        // Recuperando o Acesso_Funcionario
        System.out.println();
        System.out.println("Recuperando");
        Acesso_Funcionario tAcesso_Funcionario5a = tDao.recovery(tAcesso_Funcionario2a.getLogin());
        if (tAcesso_Funcionario5a != null)
            System.out.println("OK...... : " + tAcesso_Funcionario5a);
        else
            System.out.println("ERRO.... : " + tAcesso_Funcionario5a);
        Acesso_Funcionario tAcesso_Funcionario5b = tDao.recovery(tAcesso_Funcionario2b.getLogin());
        if (tAcesso_Funcionario5b != null)
            System.out.println("OK...... : " + tAcesso_Funcionario5b);
        else
            System.out.println("ERRO.... : " + tAcesso_Funcionario5b);

        // Listar os Acesso_Funcionarios
        List<Acesso_Funcionario> tLista = tDao.search();
        System.out.println();
        System.out.println("Pesquisando");
        for (Acesso_Funcionario tAcesso_Funcionario : tLista)
        {
            System.out.println("OK...... : " + tAcesso_Funcionario);
        }

        // Remover o Acesso_Funcionario
        System.out.println();
        System.out.println("Removendo");
        if (tDao.delete(tAcesso_Funcionario2a.getLogin()))
            System.out.println("OK...... : " + tAcesso_Funcionario2a);
        else
            System.out.println("ERRO.... : " + tAcesso_Funcionario2a);
        if (tDao.delete(tAcesso_Funcionario2b.getLogin()))
            System.out.println("OK...... : " + tAcesso_Funcionario2b);
        else
            System.out.println("ERRO.... : " + tAcesso_Funcionario2b);

        // Verificando se removeu
        System.out.println();
        System.out.println("Verificando a remo��o");
        if (tDao.delete(tAcesso_Funcionario2a.getLogin()))
            System.out.println("ERRO.... : " + tAcesso_Funcionario2a);
        else
            System.out.println("OK...... : " + tAcesso_Funcionario2a);
        if (tDao.delete(tAcesso_Funcionario2b.getLogin()))
            System.out.println("ERRO.... : " + tAcesso_Funcionario2b);
        else
            System.out.println("OK...... : " + tAcesso_Funcionario2b);
    }

}
