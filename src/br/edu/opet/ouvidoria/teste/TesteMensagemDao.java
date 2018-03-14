package br.edu.opet.ouvidoria.teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import br.edu.opet.ouvidoria.dao.Acesso_FuncionarioDao;
import br.edu.opet.ouvidoria.dao.AssuntoDao;
import br.edu.opet.ouvidoria.dao.CidadeDao;
import br.edu.opet.ouvidoria.dao.MensagemDao;
import br.edu.opet.ouvidoria.dao.ProtocoloDao;
import br.edu.opet.ouvidoria.dao.RespostaDao;
import br.edu.opet.ouvidoria.dao.SetorDao;
import br.edu.opet.ouvidoria.dao.UsuarioDao;
import br.edu.opet.ouvidoria.model.Acesso_Funcionario;
import br.edu.opet.ouvidoria.model.Assunto;
import br.edu.opet.ouvidoria.model.Cidade;
import br.edu.opet.ouvidoria.model.Mensagem;
import br.edu.opet.ouvidoria.model.Protocolo;
import br.edu.opet.ouvidoria.model.Resposta;
import br.edu.opet.ouvidoria.model.Setor;
import br.edu.opet.ouvidoria.model.Usuario;

public class TesteMensagemDao
{
     private static SimpleDateFormat sFormatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        public static void main(String[] pArgs) throws ParseException
        {
            //
            // Pr� Teste
            //
            // Criar um Funcionario
            Acesso_Funcionario tAcesso_FuncionarioA = new Acesso_Funcionario(0, "E5465", 3432, "eddd", 0);
            Acesso_Funcionario tAcesso_FuncionarioB = new Acesso_Funcionario(0, "54513", 22222, "pat", 0);

            // Criando o objeto de persist�ncia
            Acesso_FuncionarioDao tAcesso_FuncionarioDao = new Acesso_FuncionarioDao();

            // Incluir o Acesso_Funcionario
            System.out.println();
            System.out.println("Incluindo Acesso_Funcionario");
            Acesso_Funcionario tAcesso_Funcionario2a = tAcesso_FuncionarioDao.create(tAcesso_FuncionarioA);
            if (tAcesso_Funcionario2a != null)
                System.out.println("OK...... : " + tAcesso_Funcionario2a);
            else
                System.out.println("ERRO.... : " + tAcesso_Funcionario2a);
            Acesso_Funcionario tAcesso_Funcionario2b = tAcesso_FuncionarioDao.create(tAcesso_FuncionarioB);
            if (tAcesso_Funcionario2b != null)
                System.out.println("OK...... : " + tAcesso_Funcionario2b);
            else
                System.out.println("ERRO.... : " + tAcesso_Funcionario2b);

            // Criar um Assunto
            Assunto tAssuntoA = new Assunto(0, "a");
            Assunto tAssuntoB = new Assunto(0, "iii");

            // Criando o objeto de persist�ncia
            AssuntoDao tAssuntoDao = new AssuntoDao();

            // Incluir o Assunto
            System.out.println();
            System.out.println("Incluindo Assunto");
            Assunto tAssunto2a = tAssuntoDao.create(tAssuntoA);
            if (tAssunto2a != null)
                System.out.println("OK...... : " + tAssunto2a);
            else
                System.out.println("ERRO.... : " + tAssunto2a);
            Assunto tAssunto2b = tAssuntoDao.create(tAssuntoB);
            if (tAssunto2b != null)
                System.out.println("OK...... : " + tAssunto2b);
            else
                System.out.println("ERRO.... : " + tAssunto2b);

         // Criar um Cidade
            Cidade tCidadeA = new Cidade(0, "PR", "Brasil", "Paran�");
            Cidade tCidadeB = new Cidade(0, "SC", "Brasil", "Santa Catarina");

            // Criando o objeto de persist�ncia
            CidadeDao tCidadeDao = new CidadeDao();

            // Incluir o Cidade
            System.out.println();
            System.out.println("Incluindo Cidade");
            Cidade tCidade2a = tCidadeDao.create(tCidadeA);
            if (tCidade2a != null)
                System.out.println("OK...... : " + tCidade2a);
            else
                System.out.println("ERRO.... : " + tCidade2a);
            Cidade tCidade2b = tCidadeDao.create(tCidadeB);
            if (tCidade2b != null)
                System.out.println("OK...... : " + tCidade2b);
            else
                System.out.println("ERRO.... : " + tCidade2b);

         // Criar um Protocolo
            Protocolo tProtocoloA = new Protocolo(0, 2);
            Protocolo tProtocoloB = new Protocolo(0, 5);

            // Criando o objeto de persist�ncia
            ProtocoloDao tProtocoloDao = new ProtocoloDao();

            // Incluir o Protocolo
            System.out.println();
            System.out.println("Incluindo Protocolo");
            Protocolo tProtocolo2a = tProtocoloDao.create(tProtocoloA);
            if (tProtocolo2a != null)
                System.out.println("OK...... : " + tProtocolo2a);
            else
                System.out.println("ERRO.... : " + tProtocolo2a);
            Protocolo tProtocolo2b = tProtocoloDao.create(tProtocoloB);
            if (tProtocolo2b != null)
                System.out.println("OK...... : " + tProtocolo2b);
            else
                System.out.println("ERRO.... : " + tProtocolo2b);

         // Criar um Resposta
            Resposta tRespostaA = new Resposta(0,"a", 12, LocalDate.of(1978, 8, 29));
            Resposta tRespostaB = new Resposta(0,"bb", 11, LocalDate.of(1978,7, 29));

            // Criando o objeto de persist�ncia
            RespostaDao tRespostaDao = new RespostaDao();

            // Incluir o Resposta
            System.out.println();
            System.out.println("Incluindo Resposta");
            Resposta tResposta2a = tRespostaDao.create(tRespostaA);
            if (tResposta2a != null)
                System.out.println("OK...... : " + tResposta2a);
            else
                System.out.println("ERRO.... : " + tResposta2a);
            Resposta tResposta2b = tRespostaDao.create(tRespostaB);
            if (tResposta2b != null)
                System.out.println("OK...... : " + tResposta2b);
            else
                System.out.println("ERRO.... : " + tResposta2b);

            // Criar um Setor
            Setor tSetorA = new Setor(0, "a");
            Setor tSetorB = new Setor(0, "iii");

            // Criando o objeto de persist�ncia
            SetorDao tSetorDao = new SetorDao();

            // Incluir o Setor
            System.out.println();
            System.out.println("Incluindo Setor");
            Setor tSetor2a = tSetorDao.create(tSetorA);
            if (tSetor2a != null)
                System.out.println("OK...... : " + tSetor2a);
            else
                System.out.println("ERRO.... : " + tSetor2a);
            Setor tSetor2b = tSetorDao.create(tSetorB);
            if (tSetor2b != null)
                System.out.println("OK...... : " + tSetor2b);
            else
                System.out.println("ERRO.... : " + tSetor2b);

            // Criar um Usuario
            Usuario tUsuarioA = new Usuario(71028519102L,"Yerlandia Westrocia", LocalDate.of(1978, 8, 29),"Rua xxx", 0, "restro@outlook.com", 41111,"F");
            Usuario tUsuarioB = new Usuario(71028519156L,"Yera Westrocia", LocalDate.of(1978, 7, 29),"Rua xvvv", 0, "re@outlook.com",41212, "M");

            // Criando o objeto de persist�ncia
            UsuarioDao tUsuarioDao = new UsuarioDao();

            // Incluir o Usuario
            System.out.println();
            System.out.println("Incluindo Usuario");
            Usuario tUsuario2a = tUsuarioDao.create(tUsuarioA);
            if (tUsuario2a != null)
                System.out.println("OK...... : " + tUsuario2a);
            else
                System.out.println("ERRO.... : " + tUsuario2a);
            Usuario tUsuario2b = tUsuarioDao.create(tUsuarioB);
            if (tUsuario2b != null)
                System.out.println("OK...... : " + tUsuario2b);
            else
                System.out.println("ERRO.... : " + tUsuario2b);


            //
            // Teste
            //
            // Criar uma Mensagem
            Date tData1 = sFormatador.parse("15/09/2017 18:30");
            Date tData2 = sFormatador.parse("04/10/2017 10:45");


            Mensagem tMensagemA = new Mensagem(0, tProtocolo2a.getId(), tAssunto2a.getId(), tSetor2a.getId(),tUsuario2a.getCpf(), tAcesso_Funcionario2a.getLogin(), tUsuario2a.getNome(), tData1,"aberto", "gostei");
            Mensagem tMensagemB = new Mensagem(0, tProtocolo2b.getId(), tAssunto2b.getId(), tSetor2b.getId(),tUsuario2b.getCpf(), tAcesso_Funcionario2b.getLogin(), tUsuario2b.getNome(), tData2,"Aberto", "muito bom");

            // Criando o objeto de persist�ncia
            MensagemDao tDao = new MensagemDao();

            // Incluir a Mensagem
            System.out.println();
            System.out.println("Incluindo Mensagem");
            Mensagem tMensagem2a = tDao.create(tMensagemA);
            if (tMensagem2a != null)
                System.out.println("OK...... : " + tMensagem2a);
            else
                System.out.println("ERRO.... : " + tMensagem2a);
            Mensagem tMensagem2b = tDao.create(tMensagemB);
            if (tMensagem2b != null)
                System.out.println("OK...... : " + tMensagem2b);
            else
                System.out.println("ERRO.... : " + tMensagem2b);

            // Recuperando a Mensagem
            System.out.println();
            System.out.println("Recuperando Mensagem");
            Mensagem tMensagem3a = tDao.recovery(tMensagem2a.getId());
            if (tMensagem3a != null)
                System.out.println("OK...... : " + tMensagem3a);
            else
                System.out.println("ERRO.... : " + tMensagem3a);
            Mensagem tMensagem3b = tDao.recovery(tMensagem2b.getId());
            if (tMensagem3b != null)
                System.out.println("OK...... : " + tMensagem3b);
            else
                System.out.println("ERRO.... : " + tMensagem3b);

            // Atualizando a Mensagem
            Date tData3 = sFormatador.parse("25/09/2017 10:30");
            Date tData4 = sFormatador.parse("14/11/2017 08:00");
            System.out.println();
            System.out.println("Atualizando Mensagem");


            tMensagem2a.setNome(tUsuario2b.getNome());
            tMensagem2a.setData_Mensagem(tData3);
            tMensagem2a.setStatus(tMensagem2b.getStatus());

            Mensagem tMensagem4a = tDao.update(tMensagem2a);
            if (tMensagem4a != null)
                System.out.println("OK...... : " + tMensagem4a);
            else
                System.out.println("ERRO.... : " + tMensagem4a);
            tMensagem2b.setNome(tUsuario2a.getNome());
            tMensagem2b.setData_Mensagem(tData4);
            tMensagem2b.setStatus(tMensagem2a.getStatus());
            Mensagem tMensagem4b = tDao.update(tMensagem2b);
            if (tMensagem4a != null)
                System.out.println("OK...... : " + tMensagem4b);
            else
                System.out.println("ERRO.... : " + tMensagem4b);

            // Recuperando a Mensagem
            System.out.println();
            System.out.println("Recuperando Mensagem");
            Mensagem tMensagem5a = tDao.recovery(tMensagem2a.getId());
            if (tMensagem5a != null)
                System.out.println("OK...... : " + tMensagem5a);
            else
                System.out.println("ERRO.... : " + tMensagem5a);
            Mensagem tMensagem5b = tDao.recovery(tMensagem2b.getId());
            if (tMensagem5b != null)
                System.out.println("OK...... : " + tMensagem5b);
            else
                System.out.println("ERRO.... : " + tMensagem5b);

            // Listar as Mensagems
            List<Mensagem> tLista = tDao.search();
            System.out.println();
            System.out.println("Pesquisando Mensagem");
            for (Mensagem tMensagem : tLista)
            {
                System.out.println("OK...... : " + tMensagem);
            }

            // Listar os Usuarios
            tLista = tDao.searchByUsuario(tUsuario2a.getCpf());
            System.out.println();
            System.out.println("Listando Usuario");
            for (Mensagem tMensagem : tLista)
            {
                System.out.println("OK...... : " + tMensagem);
            }

            // Contar as Mensagems
            Long tQtde = tDao.countByUsuario(tUsuario2a.getCpf());
            System.out.println();
            System.out.println("Contando Mensagems por Usuario");
            System.out.println("OK...... : " + tQtde);

            // Remover a Mensagem
            System.out.println();
            System.out.println("Removendo");
            if (tDao.delete(tMensagem2a.getId()))
                System.out.println("OK...... : " + tMensagem2a);
            else
                System.out.println("ERRO.... : " + tMensagem2a);
            if (tDao.delete(tMensagem2b.getId()))
                System.out.println("OK...... : " + tMensagem2b);
            else
                System.out.println("ERRO.... : " + tMensagem2b);

            // Verificando se removeu
            System.out.println();
            System.out.println("Verificando a remo��o");
            if (tDao.delete(tMensagem2a.getId()))
                System.out.println("ERRO.... : " + tMensagem2a);
            else
                System.out.println("OK...... : " + tMensagem2a);
            if (tDao.delete(tMensagem2b.getId()))
                System.out.println("ERRO.... : " + tMensagem2b);
            else
                System.out.println("OK...... : " + tMensagem2b);

            //
            // P�s teste
            //
            // Remover o Usuario
            System.out.println();
            System.out.println("Removendo Usuario");
            if (tUsuarioDao.delete(tUsuario2a.getCpf()))
                System.out.println("OK...... : " + tUsuario2a);
            else
                System.out.println("ERRO.... : " + tUsuario2a);
            if (tUsuarioDao.delete(tUsuario2b.getCpf()))
                System.out.println("OK...... : " + tUsuario2b);
            else
                System.out.println("ERRO.... : " + tUsuario2b);

            // Remover o Acesso_Funcionario
            System.out.println();
            System.out.println("Removendo Acesso_Funcionario");
            if (tAcesso_FuncionarioDao.delete(tAcesso_Funcionario2a.getLogin()))
                System.out.println("OK...... : " + tAcesso_Funcionario2a);
            else
                System.out.println("ERRO.... : " + tAcesso_Funcionario2a);
            if (tAcesso_FuncionarioDao.delete(tAcesso_Funcionario2b.getLogin()))
                System.out.println("OK...... : " + tAcesso_Funcionario2b);
            else
                System.out.println("ERRO.... : " + tAcesso_Funcionario2b);

            // Remover o Assunto
            System.out.println();
            System.out.println("Removendo Assunto");
            if (tAssuntoDao.delete(tAssunto2a.getId()))
                System.out.println("OK...... : " + tAssunto2a);
            else
                System.out.println("ERRO.... : " + tAssunto2a);
            if (tAssuntoDao.delete(tAssunto2b.getId()))
                System.out.println("OK...... : " + tAssunto2b);
            else
                System.out.println("ERRO.... : " + tAssunto2b);

            // Remover a Cidade
            System.out.println();
            System.out.println("Removendo Cidade");
            if (tCidadeDao.delete(tCidade2a.getCodigo()))
                System.out.println("OK...... : " + tCidade2a);
            else
                System.out.println("ERRO.... : " + tCidade2a);
            if (tCidadeDao.delete(tCidade2b.getCodigo()))
                System.out.println("OK...... : " + tCidade2b);
            else
                System.out.println("ERRO.... : " + tCidade2b);

            // Remover o Protocolo
            System.out.println();
            System.out.println("Removendo Protocolo");
            if (tProtocoloDao.delete(tProtocolo2a.getId()))
                System.out.println("OK...... : " + tProtocolo2a);
            else
                System.out.println("ERRO.... : " + tProtocolo2a);
            if (tProtocoloDao.delete(tProtocolo2b.getId()))
                System.out.println("OK...... : " + tProtocolo2b);
            else
                System.out.println("ERRO.... : " + tProtocolo2b);

            // Remover a Setor
            System.out.println();
            System.out.println("Removendo Setor");
            if (tSetorDao.delete(tSetor2a.getId()))
                System.out.println("OK...... : " + tSetor2a);
            else
                System.out.println("ERRO.... : " + tSetor2a);
            if (tSetorDao.delete(tSetor2b.getId()))
                System.out.println("OK...... : " + tSetor2b);
            else
                System.out.println("ERRO.... : " + tSetor2b);

            // Remover a Resposta
            System.out.println();
            System.out.println("Removendo Resposta");
            if (tRespostaDao.delete(tResposta2a.getId()))
                System.out.println("OK...... : " + tResposta2a);
            else
                System.out.println("ERRO.... : " + tResposta2a);
            if (tRespostaDao.delete(tResposta2b.getId()))
                System.out.println("OK...... : " + tResposta2b);
            else
                System.out.println("ERRO.... : " + tResposta2b);

        }
    }
