package br.edu.opet.ouvidoria.teste;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import br.edu.opet.ouvidoria.controller.MensagemController;
import br.edu.opet.ouvidoria.dao.Acesso_FuncionarioDao;
import br.edu.opet.ouvidoria.dao.AssuntoDao;
import br.edu.opet.ouvidoria.dao.CidadeDao;
import br.edu.opet.ouvidoria.dao.MensagemDao;
import br.edu.opet.ouvidoria.dao.ProtocoloDao;
import br.edu.opet.ouvidoria.dao.RespostaDao;
import br.edu.opet.ouvidoria.dao.SetorDao;
import br.edu.opet.ouvidoria.dao.UsuarioDao;
import br.edu.opet.ouvidoria.dto.MensagemDto;
import br.edu.opet.ouvidoria.model.Acesso_Funcionario;
import br.edu.opet.ouvidoria.model.Assunto;
import br.edu.opet.ouvidoria.model.Cidade;
import br.edu.opet.ouvidoria.model.Mensagem;
import br.edu.opet.ouvidoria.model.Protocolo;
import br.edu.opet.ouvidoria.model.Resposta;
import br.edu.opet.ouvidoria.model.Setor;
import br.edu.opet.ouvidoria.model.Usuario;

public class TesteMensagemController
{
    private static SimpleDateFormat sFormatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public static void main(String[] pArgs) throws ParseException
    {
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


     // Obtendo a data de amanh� a partir da data atual
        Date tAmanha = new Date(new Date().getTime() + /* 1 dia */ 24L * 60 * 60 * 1000);
        String tAmanhaStr = DateFormat.getDateInstance(DateFormat.MEDIUM).format(tAmanha);
        Date tData1 = sFormatador.parse(tAmanhaStr + " 18:30");
        Mensagem tMensagemA = new Mensagem(0, tProtocolo2a.getId(), tAssunto2a.getId(), tSetor2a.getId(),tUsuario2a.getCpf(), tAcesso_Funcionario2a.getLogin(), tUsuario2a.getNome(), tData1,"aberto", "gostei");

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

        //
        // Teste
        //

        // Criando o objeto de Controller
        MensagemController tController = new MensagemController();

        // cadastrar uma Mensagem
        Date tData2 = sFormatador.parse(tAmanhaStr + " 10:00");
        Mensagem tMensagemB = new Mensagem(0, tProtocolo2b.getId(), tAssunto2b.getId(), tSetor2b.getId(),tUsuario2b.getCpf(), tAcesso_Funcionario2b.getLogin(), tUsuario2b.getNome(), tData2,"Aberto", "muito bom");

        // cadastrar a Mensagem
        System.out.println();
        System.out.println("Cadastrando a Mensagem via controller");
        MensagemDto tDto = tController.cadastrarMensagem(tMensagemB);
        if (tDto.isOk())
        {
            // Recuperando o Usuario inclu�do para informar o CPF
            tMensagemB = tDto.getMensagem();
            System.out.println("OK...... : " + tDto.getMensagem());
            System.out.println("           " + tMensagemB);
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        // cadastrar a Mensagem para Usuario que n�o existe
        System.out.println();
        System.out.println("Cadastrando a Mensagem para Usuario que n�o existe");
        tMensagemB.setCpf(0);
        tDto = tController.cadastrarMensagem(tMensagemB);
        if (!tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        // cadastrar a Mensagem por Funcion�rio que n�o existe
        System.out.println();
        System.out.println("Cadastrando a Mensagem para Funcion�rio que n�o existe");
        tMensagemB.setLogin(0);
        tDto = tController.cadastrarMensagem(tMensagemB);
        if (!tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        // cadastrar a Mensagem para ontem
        System.out.println();
        System.out.println("Cadastrando a Mensagem para ontem via controller");
        // Acertando a data de Mensagem para ontem
        Date tDataOntem = new Date(new Date().getTime() - /* 1 dia */ 24L * 60 * 60 * 1000);
        tMensagemB.setData_Mensagem(tDataOntem);
        tDto = tController.cadastrarMensagem(tMensagemB);
        if (!tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

         // Recuperar a Mensagem
        System.out.println();
        System.out.println("Recuperando a Mensagem via controller");
        tDto = tController.recuperarMensagem(tMensagemB.getId());
        if (tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
            System.out.println("           " + tDto.getMensagem());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        System.out.println();
        System.out.println("Recuperando uma Mensagem com id inv�lido");
        tDto = tController.recuperarMensagem(-32432);
        if (!tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        System.out.println();
        System.out.println("Recuperando uma Mensagem n�o existente");
        tDto = tController.recuperarMensagem(9999999);
        if (!tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }


        // Recuperando as Mensagems por Usuario
        System.out.println();
        System.out.println("Recuperando as Mensagems por Usuario");
        tDto = tController.pesquisarMensagemPorUsuario(tUsuario2b.getCpf());
        if (tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
            List<Mensagem> tLista = tDto.getLista();
            for (Mensagem tMensagem : tLista)
            {
                System.out.println("         : " + tMensagem);
            }
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }


        // Recuperando as Mensagems por data
        System.out.println();
        System.out.println("Recuperando as Mensagems por data");
        tDto = tController.pesquisarMensagemPorData_Mensagem(tData2);
        if (tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
            List<Mensagem> tLista = tDto.getLista();
            for (Mensagem tMensagem : tLista)
            {
                System.out.println("         : " + tMensagem);
            }
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

    }

}
