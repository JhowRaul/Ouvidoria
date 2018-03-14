package br.edu.opet.ouvidoria.teste;

import br.edu.opet.ouvidoria.controller.SetorController;
import br.edu.opet.ouvidoria.dao.SetorDao;
import br.edu.opet.ouvidoria.dto.SetorDto;
import br.edu.opet.ouvidoria.model.Setor;

public class TesteSetorController
{
    public static void main(String[] pArgs)
    {
        //
        // Pré Teste
        //
        // Criar um Setor
        Setor tSetorA = new Setor(0, "SAP");

        // Criando o objeto de persistência
        SetorDao tDao = new SetorDao();

        // Incluir o Setor
        System.out.println();
        System.out.println("Incluindo um Setor");
        Setor tSetor2a = tDao.create(tSetorA);
        if (tSetor2a != null)
            System.out.println("OK...... : " + tSetor2a);
        else
            System.out.println("ERRO.... : " + tSetor2a);

        //
        // Teste
        //
        // Criar um Setor
        Setor tSetorB = new Setor(0, "EAD");

        // Criando o objeto de Controller
        SetorController tController = new SetorController();

        // Incluindo o Setor
        System.out.println();
        System.out.println("Incluindo um Setor via controller");
        SetorDto tDto = tController.cadastrarSetor(tSetorB);
        if (tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
            System.out.println("           " + tDto.getSetor());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        // Incluindo o Setor
        System.out.println();
        System.out.println("Incluindo um Setor nulo");
        tDto = tController.cadastrarSetor(null);
        if (!tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        // Incluindo o Setor
        System.out.println();
        System.out.println("Incluindo um Setor já existente");
        tDto = tController.cadastrarSetor(tSetorA);
        if (!tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        //
        // Pós teste
        //
        // Remover o Setor
        System.out.println();
        System.out.println("Removendo um Setor");
        if (tDao.delete(tSetor2a.getId()))
            System.out.println("OK...... : " + tSetor2a);
        else
            System.out.println("ERRO.... : " + tSetor2a);
    }
}
