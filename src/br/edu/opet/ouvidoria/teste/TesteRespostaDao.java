package br.edu.opet.ouvidoria.teste;

import java.time.LocalDate;
import java.util.List;

import br.edu.opet.ouvidoria.dao.RespostaDao;
import br.edu.opet.ouvidoria.model.Resposta;

public class TesteRespostaDao
{
    public static void main(String[] pArgs)
        {
        // Criar um Resposta
        Resposta tRespostaA = new Resposta(0,"a", 12, LocalDate.of(1978, 8, 29));
        Resposta tRespostaB = new Resposta(0,"bb", 11, LocalDate.of(1978,7, 29));

        // Criando o objeto de persistência
        RespostaDao tDao = new RespostaDao();

        // Incluir o Resposta
        System.out.println();
        System.out.println("Incluindo");
        Resposta tResposta2a = tDao.create(tRespostaA);
        if (tResposta2a != null)
            System.out.println("OK...... : " + tResposta2a);
        else
            System.out.println("ERRO.... : " + tResposta2a);
        Resposta tResposta2b = tDao.create(tRespostaB);
        if (tResposta2b != null)
            System.out.println("OK...... : " + tResposta2b);
        else
            System.out.println("ERRO.... : " + tResposta2b);

        // Recuperando o Resposta
        System.out.println();
        System.out.println("Recuperando");
        Resposta tResposta3a = tDao.recovery(tResposta2a.getId());
        if (tResposta3a != null)
            System.out.println("OK...... : " + tResposta3a);
        else
            System.out.println("ERRO.... : " + tResposta3a);
        Resposta tResposta3b = tDao.recovery(tResposta2b.getId());
        if (tResposta3b != null)
            System.out.println("OK...... : " + tResposta3b);
        else
            System.out.println("ERRO.... : " + tResposta3b);

        // Atualizando o Resposta
        System.out.println();
        System.out.println("Atualizando");
        tResposta2a.setConteudo(tResposta2a.getConteudo()+ "tão");
        tResposta2a.setData(LocalDate.of(2000, 1, 31));

        Resposta tResposta4a = tDao.update(tResposta2a);
        if (tResposta4a != null)
            System.out.println("OK...... : " + tResposta4a);
        else
            System.out.println("ERRO.... : " + tResposta4a);

        tResposta2a.setConteudo(tResposta2a.getConteudo()+ "gio");
        tResposta2a.setData(LocalDate.of(2018, 3, 31));
        Resposta tResposta4b = tDao.update(tResposta2b);
        if (tResposta4a != null)
            System.out.println("OK...... : " + tResposta4b);
        else
            System.out.println("ERRO.... : " + tResposta4b);

        // Recuperando o Resposta
        System.out.println();
        System.out.println("Recuperando");
        Resposta tResposta5a = tDao.recovery(tResposta2a.getId());
        if (tResposta5a != null)
            System.out.println("OK...... : " + tResposta5a);
        else
            System.out.println("ERRO.... : " + tResposta5a);
        Resposta tResposta5b = tDao.recovery(tResposta2b.getId());
        if (tResposta5b != null)
            System.out.println("OK...... : " + tResposta5b);
        else
            System.out.println("ERRO.... : " + tResposta5b);

        // Listar os Respostas
        List<Resposta> tLista = tDao.search();
        System.out.println();
        System.out.println("Pesquisando");
        for (Resposta tResposta : tLista)
        {
            System.out.println("OK...... : " + tResposta);
        }

        // Remover o Resposta
        System.out.println();
        System.out.println("Removendo");
        if (tDao.delete(tResposta2a.getId()))
            System.out.println("OK...... : " + tResposta2a);
        else
            System.out.println("ERRO.... : " + tResposta2a);
        if (tDao.delete(tResposta2b.getId()))
            System.out.println("OK...... : " + tResposta2b);
        else
            System.out.println("ERRO.... : " + tResposta2b);

        // Verificando se removeu
        System.out.println();
        System.out.println("Verificando a remoção");
        if (tDao.delete(tResposta2a.getId()))
            System.out.println("ERRO.... : " + tResposta2a);
        else
            System.out.println("OK...... : " + tResposta2a);
        if (tDao.delete(tResposta2b.getId()))
            System.out.println("ERRO.... : " + tResposta2b);
        else
            System.out.println("OK...... : " + tResposta2b);
    }

}

