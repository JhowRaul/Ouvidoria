package br.edu.opet.ouvidoria.teste;

import br.edu.opet.ouvidoria.controller.AssuntoController;
import br.edu.opet.ouvidoria.dao.AssuntoDao;
import br.edu.opet.ouvidoria.dto.AssuntoDto;
import br.edu.opet.ouvidoria.model.Assunto;

public class TesteAssuntoController
{
      public static void main(String[] pArgs)
        {
            //
            // Pré Teste
            //
            // Criar um Assunto
            Assunto tAssuntoA = new Assunto(0, "Sugestão");

            // Criando o objeto de persistência
            AssuntoDao tDao = new AssuntoDao();

            // Incluir o Assunto
            System.out.println();
            System.out.println("Incluindo um Assunto");
            Assunto tAssunto2a = tDao.create(tAssuntoA);
            if (tAssunto2a != null)
                System.out.println("OK...... : " + tAssunto2a);
            else
                System.out.println("ERRO.... : " + tAssunto2a);

            //
            // Teste
            //
            // Criar um Assunto
            Assunto tAssuntoB = new Assunto(0, "Elogio");

            // Criando o objeto de Controller
            AssuntoController tController = new AssuntoController();

            // Incluindo o Assunto
            System.out.println();
            System.out.println("Incluindo um Assunto via controller");
            AssuntoDto tDto = tController.cadastrarAssunto(tAssuntoB);
            if (tDto.isOk())
            {
                System.out.println("OK...... : " + tDto.getMensagem());
                System.out.println("           " + tDto.getAssunto());
            }
            else
            {
                System.out.println("ERRO.... : " + tDto.getMensagem());
            }

            // Incluindo o Assunto
            System.out.println();
            System.out.println("Incluindo um Assunto nulo");
            tDto = tController.cadastrarAssunto(null);
            if (!tDto.isOk())
            {
                System.out.println("OK...... : " + tDto.getMensagem());
            }
            else
            {
                System.out.println("ERRO.... : " + tDto.getMensagem());
            }

            // Incluindo o Assunto
            System.out.println();
            System.out.println("Incluindo um Assunto já existente");
            tDto = tController.cadastrarAssunto(tAssuntoA);
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
            // Remover o Assunto
            System.out.println();
            System.out.println("Removendo um Assunto");
            if (tDao.delete(tAssunto2a.getId()))
                System.out.println("OK...... : " + tAssunto2a);
            else
                System.out.println("ERRO.... : " + tAssunto2a);
        }
    }
