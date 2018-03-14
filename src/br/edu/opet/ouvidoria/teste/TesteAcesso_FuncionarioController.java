package br.edu.opet.ouvidoria.teste;

import br.edu.opet.ouvidoria.controller.Acesso_FuncionarioController;
import br.edu.opet.ouvidoria.dao.Acesso_FuncionarioDao;
import br.edu.opet.ouvidoria.dto.Acesso_FuncionarioDto;
import br.edu.opet.ouvidoria.model.Acesso_Funcionario;

public class TesteAcesso_FuncionarioController
{

    public static void main(String[] pArgs)
    {
        //
        // Pr� Teste
        //
        // Criar um Acesso_Funcionario
        Acesso_Funcionario tAcesso_FuncionarioA = new Acesso_Funcionario(0, "E5465", 3432, "eddd", 1);

        // Criando o objeto de persist�ncia
        Acesso_FuncionarioDao tDao = new Acesso_FuncionarioDao();

        // Incluir o Acesso_Funcionario
        System.out.println();
        System.out.println("Incluindo um Acesso_Funcionario");
        Acesso_Funcionario tAcesso_Funcionario2a = tDao.create(tAcesso_FuncionarioA);
        if (tAcesso_Funcionario2a != null)
            System.out.println("OK...... : " + tAcesso_Funcionario2a);
        else
            System.out.println("ERRO.... : " + tAcesso_Funcionario2a);

        //
        // Teste
        //
        // Criar um Acesso_Funcionario
        Acesso_Funcionario tAcesso_FuncionarioB = new Acesso_Funcionario(0, "E5465", 3432, "eddd", 1);

        // Criando o objeto de Controller
        Acesso_FuncionarioController tController = new Acesso_FuncionarioController();

        // Incluindo o Acesso_Funcionario
        System.out.println();
        System.out.println("Incluindo um Acesso_Funcionario via controller");
        Acesso_FuncionarioDto tDto = tController.cadastrarAcesso_Funcionario(tAcesso_FuncionarioB);
        if (tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
            System.out.println("           " + tDto.getAcesso_Funcionario());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        // Incluindo o Acesso_Funcionario
        System.out.println();
        System.out.println("Incluindo um Acesso_Funcionario nulo");
        tDto = tController.cadastrarAcesso_Funcionario(null);
        if (!tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        // Incluindo o Acesso_Funcionario
        System.out.println();
        System.out.println("Incluindo um Acesso_Funcionario j� existente");
        tDto = tController.cadastrarAcesso_Funcionario(tAcesso_FuncionarioA);
        if (!tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        //
        // P�s teste
        //
        // Remover o Acesso_Funcionario
        System.out.println();
        System.out.println("Removendo um Acesso_Funcionario");
        if (tDao.delete(tAcesso_Funcionario2a.getLogin()))
            System.out.println("OK...... : " + tAcesso_Funcionario2a);
        else
            System.out.println("ERRO.... : " + tAcesso_Funcionario2a);
    }
}
