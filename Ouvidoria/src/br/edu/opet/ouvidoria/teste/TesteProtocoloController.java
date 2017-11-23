package br.edu.opet.ouvidoria.teste;

import br.edu.opet.ouvidoria.controller.ProtocoloController;
import br.edu.opet.ouvidoria.dao.ProtocoloDao;
import br.edu.opet.ouvidoria.dto.ProtocoloDto;
import br.edu.opet.ouvidoria.model.Protocolo;

public class TesteProtocoloController
{
    public static void main(String[] pArgs)
    {
        //
        // Pré Teste
        //
        // Criar um Protocolo
        Protocolo tProtocoloA = new Protocolo(0, 2);

        // Criando o objeto de persistência
        ProtocoloDao tDao = new ProtocoloDao();

        // Incluir o Protocolo
        System.out.println();
        System.out.println("Incluindo um Protocolo");
        Protocolo tProtocolo2a = tDao.create(tProtocoloA);
        if (tProtocolo2a != null)
            System.out.println("OK...... : " + tProtocolo2a);
        else
            System.out.println("ERRO.... : " + tProtocolo2a);

        //
        // Teste
        //
        // Criar um Protocolo
        Protocolo tProtocoloB = new Protocolo(0, 2);

        // Criando o objeto de Controller
        ProtocoloController tController = new ProtocoloController();

        // Incluindo o Protocolo
        System.out.println();
        System.out.println("Incluindo um Protocolo via controller");
        ProtocoloDto tDto = tController.cadastrarProtocolo(tProtocoloB);
        if (tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
            System.out.println("           " + tDto.getProtocolo());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        // Incluindo o Protocolo
        System.out.println();
        System.out.println("Incluindo um Protocolo nulo");
        tDto = tController.cadastrarProtocolo(null);
        if (!tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        // Incluindo o Protocolo
        System.out.println();
        System.out.println("Incluindo um Protocolo já existente");
        tDto = tController.cadastrarProtocolo(tProtocoloA);
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
        // Remover o Protocolo
        System.out.println();
        System.out.println("Removendo um Protocolo");
        if (tDao.delete(tProtocolo2a.getId()))
            System.out.println("OK...... : " + tProtocolo2a);
        else
            System.out.println("ERRO.... : " + tProtocolo2a);
    }
}

