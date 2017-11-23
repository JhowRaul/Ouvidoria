package br.edu.opet.ouvidoria.teste;

import java.time.LocalDate;

import br.edu.opet.ouvidoria.controller.RespostaController;
import br.edu.opet.ouvidoria.dao.RespostaDao;
import br.edu.opet.ouvidoria.dto.RespostaDto;
import br.edu.opet.ouvidoria.model.Resposta;

public class TesteRespostaController
{
    public static void main(String[] pArgs)
    {
        //
        // Pré Teste
        //
        // Criar um Resposta
        Resposta tRespostaA = new Resposta(0,"a", 12, LocalDate.of(1978, 8, 29));

        // Criando o objeto de persistência
        RespostaDao tDao = new RespostaDao();

        // Incluir o Resposta
        System.out.println();
        System.out.println("Incluindo um Resposta");
        Resposta tResposta2a = tDao.create(tRespostaA);
        if (tResposta2a != null)
            System.out.println("OK...... : " + tResposta2a);
        else
            System.out.println("ERRO.... : " + tResposta2a);

        //
        // Teste
        //
        // Criar um Resposta
        Resposta tRespostaB = new Resposta(0,"bb", 11, LocalDate.of(1978,7, 29));

        // Criando o objeto de Controller
        RespostaController tController = new RespostaController();

        // Incluindo o Resposta
        System.out.println();
        System.out.println("Incluindo um Resposta via controller");
        RespostaDto tDto = tController.cadastrarResposta(tRespostaB);
        if (tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
            System.out.println("           " + tDto.getResposta());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        // Incluindo o Resposta
        System.out.println();
        System.out.println("Incluindo um Resposta nulo");
        tDto = tController.cadastrarResposta(null);
        if (!tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        // Incluindo o Resposta
        System.out.println();
        System.out.println("Incluindo um Resposta já existente");
        tDto = tController.cadastrarResposta(tRespostaA);
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
        // Remover o Resposta
        System.out.println();
        System.out.println("Removendo um Resposta");
        if (tDao.delete(tResposta2a.getId()))
            System.out.println("OK...... : " + tResposta2a);
        else
            System.out.println("ERRO.... : " + tResposta2a);
    }
}
