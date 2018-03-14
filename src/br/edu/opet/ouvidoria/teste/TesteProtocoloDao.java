package br.edu.opet.ouvidoria.teste;

import java.util.List;

import br.edu.opet.ouvidoria.dao.ProtocoloDao;
import br.edu.opet.ouvidoria.model.Protocolo;

public class TesteProtocoloDao
{
    public static void main(String[] pArgs)
    {
        // Criar um Protocolo
        Protocolo tProtocoloA = new Protocolo(0, 2);
        Protocolo tProtocoloB = new Protocolo(0, 5);

        // Criando o objeto de persistência
        ProtocoloDao tDao = new ProtocoloDao();

        // Incluir o Protocolo
        System.out.println();
        System.out.println("Incluindo");
        Protocolo tProtocolo2a = tDao.create(tProtocoloA);
        if (tProtocolo2a != null)
            System.out.println("OK...... : " + tProtocolo2a);
        else
            System.out.println("ERRO.... : " + tProtocolo2a);
        Protocolo tProtocolo2b = tDao.create(tProtocoloB);
        if (tProtocolo2b != null)
            System.out.println("OK...... : " + tProtocolo2b);
        else
            System.out.println("ERRO.... : " + tProtocolo2b);

        // Recuperando o Protocolo
        System.out.println();
        System.out.println("Recuperando");
        Protocolo tProtocolo3a = tDao.recovery(tProtocolo2a.getId());
        if (tProtocolo3a != null)
            System.out.println("OK...... : " + tProtocolo3a);
        else
            System.out.println("ERRO.... : " + tProtocolo3a);
        Protocolo tProtocolo3b = tDao.recovery(tProtocolo2b.getId());
        if (tProtocolo3b != null)
            System.out.println("OK...... : " + tProtocolo3b);
        else
            System.out.println("ERRO.... : " + tProtocolo3b);

        // Atualizando o Protocolo
        System.out.println();
        System.out.println("Atualizando");
        tProtocolo2a.setNumero(tProtocolo2a.getNumero() + 1);
        Protocolo tProtocolo4a = tDao.update(tProtocolo2a);
        if (tProtocolo4a != null)
            System.out.println("OK...... : " + tProtocolo4a);
        else
            System.out.println("ERRO.... : " + tProtocolo4a);

        tProtocolo2b.setNumero(tProtocolo2b.getNumero() + 2);
        Protocolo tProtocolo4b = tDao.update(tProtocolo2b);
        if (tProtocolo4a != null)
            System.out.println("OK...... : " + tProtocolo4b);
        else
            System.out.println("ERRO.... : " + tProtocolo4b);

        // Recuperando o Protocolo
        System.out.println();
        System.out.println("Recuperando");
        Protocolo tProtocolo5a = tDao.recovery(tProtocolo2a.getId());
        if (tProtocolo5a != null)
            System.out.println("OK...... : " + tProtocolo5a);
        else
            System.out.println("ERRO.... : " + tProtocolo5a);
        Protocolo tProtocolo5b = tDao.recovery(tProtocolo2b.getId());
        if (tProtocolo5b != null)
            System.out.println("OK...... : " + tProtocolo5b);
        else
            System.out.println("ERRO.... : " + tProtocolo5b);

        // Listar os Protocolos
        List<Protocolo> tLista = tDao.search();
        System.out.println();
        System.out.println("Pesquisando");
        for (Protocolo tProtocolo : tLista)
        {
            System.out.println("OK...... : " + tProtocolo);
        }

        // Remover o Protocolo
        System.out.println();
        System.out.println("Removendo");
        if (tDao.delete(tProtocolo2a.getId()))
            System.out.println("OK...... : " + tProtocolo2a);
        else
            System.out.println("ERRO.... : " + tProtocolo2a);
        if (tDao.delete(tProtocolo2b.getId()))
            System.out.println("OK...... : " + tProtocolo2b);
        else
            System.out.println("ERRO.... : " + tProtocolo2b);

        // Verificando se removeu
        System.out.println();
        System.out.println("Verificando a remoção");
        if (tDao.delete(tProtocolo2a.getId()))
            System.out.println("ERRO.... : " + tProtocolo2a);
        else
            System.out.println("OK...... : " + tProtocolo2a);
        if (tDao.delete(tProtocolo2b.getId()))
            System.out.println("ERRO.... : " + tProtocolo2b);
        else
            System.out.println("OK...... : " + tProtocolo2b);
    }

}
