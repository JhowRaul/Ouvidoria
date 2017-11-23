package br.edu.opet.ouvidoria.teste;

import br.edu.opet.ouvidoria.controller.CidadeController;
import br.edu.opet.ouvidoria.dao.CidadeDao;
import br.edu.opet.ouvidoria.dto.CidadeDto;
import br.edu.opet.ouvidoria.model.Cidade;

public class TesteCidadeController
{
      public static void main(String[] pArgs)
            {
                //
                // Pré Teste
                //
                // Criar um Cidade
                Cidade tCidadeA = new Cidade(0, "PR", "Brasil", "Paraná");

                // Criando o objeto de persistência
                CidadeDao tDao = new CidadeDao();

                // Incluir o Cidade
                System.out.println();
                System.out.println("Incluindo um Cidade");
                Cidade tCidade2a = tDao.create(tCidadeA);
                if (tCidade2a != null)
                    System.out.println("OK...... : " + tCidade2a);
                else
                    System.out.println("ERRO.... : " + tCidade2a);

                //
                // Teste
                //
                // Criar um Cidade
                Cidade tCidadeB = new Cidade(0, "SC", "Brasil", "Santa Catarina");

                // Criando o objeto de Controller
                CidadeController tController = new CidadeController();

                // Incluindo o Cidade
                System.out.println();
                System.out.println("Incluindo um Cidade via controller");
                CidadeDto tDto = tController.cadastrarCidade(tCidadeB);
                if (tDto.isOk())
                {
                    System.out.println("OK...... : " + tDto.getMensagem());
                    System.out.println("           " + tDto.getCidade());
                }
                else
                {
                    System.out.println("ERRO.... : " + tDto.getMensagem());
                }

                // Incluindo o Cidade
                System.out.println();
                System.out.println("Incluindo um Cidade nulo");
                tDto = tController.cadastrarCidade(null);
                if (!tDto.isOk())
                {
                    System.out.println("OK...... : " + tDto.getMensagem());
                }
                else
                {
                    System.out.println("ERRO.... : " + tDto.getMensagem());
                }

                // Incluindo o Cidade
                System.out.println();
                System.out.println("Incluindo um Cidade já existente");
                tDto = tController.cadastrarCidade(tCidadeA);
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
                // Remover o Cidade
                System.out.println();
                System.out.println("Removendo um Cidade");
                if (tDao.delete(tCidade2a.getCodigo()))
                    System.out.println("OK...... : " + tCidade2a);
                else
                    System.out.println("ERRO.... : " + tCidade2a);
            }
   }
