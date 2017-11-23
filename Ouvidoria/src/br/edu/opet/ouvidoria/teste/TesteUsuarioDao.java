package br.edu.opet.ouvidoria.teste;

import java.time.LocalDate;
import java.util.List;

import br.edu.opet.ouvidoria.dao.UsuarioDao;
import br.edu.opet.ouvidoria.model.Usuario;

public class TesteUsuarioDao
{
    public static void main(String[] pArgs)
    {

        // Criar um Usuario
        Usuario tUsuarioA = new Usuario(71028519102L,"Yerlandia Westrocia", LocalDate.of(1978, 8, 29),"Rua xxx", 0, "restro@outlook.com", 41111,"F");
        Usuario tUsuarioB = new Usuario(71028519156L,"Yera Westrocia", LocalDate.of(1978, 7, 29),"Rua xvvv", 0, "re@outlook.com",41212, "M");

        // Criando o objeto de persist�ncia
        UsuarioDao tDao = new UsuarioDao();

        // Incluir o Usuario
        System.out.println();
        System.out.println("Incluindo");
        Usuario tUsuario2a = tDao.create(tUsuarioA);
        if (tUsuario2a != null)
            System.out.println("OK...... : " + tUsuario2a);
        else
            System.out.println("ERRO.... : " + tUsuario2a);
        Usuario tUsuario2b = tDao.create(tUsuarioB);
        if (tUsuario2b != null)
            System.out.println("OK...... : " + tUsuario2b);
        else
            System.out.println("ERRO.... : " + tUsuario2b);

        // Recuperando o Usuario
        System.out.println();
        System.out.println("Recuperando");
        Usuario tUsuario3a = tDao.recoveryByCpf(tUsuario2a.getCpf());
        if (tUsuario3a != null)
            System.out.println("OK...... : " + tUsuario3a);
        else
            System.out.println("ERRO.... : " + tUsuario3a);
        Usuario tUsuario3b = tDao.recoveryByCpf(tUsuario2b.getCpf());
        if (tUsuario3b != null)
            System.out.println("OK...... : " + tUsuario3b);
        else
            System.out.println("ERRO.... : " + tUsuario3b);

        // Atualizando o Usuario
        System.out.println();
        System.out.println("Atualizando");
        tUsuario2a.setCpf(71028519102L);
        tUsuario2a.setNome(tUsuario2a.getNome() + " Sildacio");
        tUsuario2a.setDataNascimento(LocalDate.of(2000, 1, 31));
        tUsuario2a.setTelefone(985008888L);
        tUsuario2a.setEmail("silda@outlook.com");
        Usuario tUsuario4a = tDao.update(tUsuario2a);
        if (tUsuario4a != null)
            System.out.println("OK...... : " + tUsuario4a);
        else
            System.out.println("ERRO.... : " + tUsuario4a);

        tUsuario2b.setCpf(71028519156L);
        tUsuario2b.setNome(tUsuario2b.getNome() + " Sundreco");
        tUsuario2b.setDataNascimento(LocalDate.of(2014, 3, 3));
        tUsuario2b.setTelefone(987886776L);
        tUsuario2b.setEmail("troncio@outlook.com");
        Usuario tUsuario4b = tDao.update(tUsuario2b);
        if (tUsuario4a != null)
            System.out.println("OK...... : " + tUsuario4b);
        else
            System.out.println("ERRO.... : " + tUsuario4b);

        // Recuperando o Usuario
        System.out.println();
        System.out.println("Recuperando");
        Usuario tUsuario5a = tDao.recoveryByCpf(tUsuario2a.getCpf());
        if (tUsuario5a != null)
            System.out.println("OK...... : " + tUsuario5a);
        else
            System.out.println("ERRO.... : " + tUsuario5a);
        Usuario tUsuario5b = tDao.recoveryByCpf(tUsuario2b.getCpf());
        if (tUsuario5b != null)
            System.out.println("OK...... : " + tUsuario5b);
        else
            System.out.println("ERRO.... : " + tUsuario5b);

        // Listar os Usuarios
        List<Usuario> tLista = tDao.search();
        System.out.println();
        System.out.println("Pesquisando");
        for (Usuario tUsuario : tLista)
        {
            System.out.println("OK...... : " + tUsuario);
        }

        // Remover o Usuario
        System.out.println();
        System.out.println("Removendo");
        if (tDao.delete(tUsuario2a.getCpf()))
            System.out.println("OK...... : " + tUsuario2a);
        else
            System.out.println("ERRO.... : " + tUsuario2a);
        if (tDao.delete(tUsuario2b.getCpf()))
            System.out.println("OK...... : " + tUsuario2b);
        else
            System.out.println("ERRO.... : " + tUsuario2b);

        // Verificando se removeu
        System.out.println();
        System.out.println("Verificando a remo��o");
        if (tDao.delete(tUsuario2a.getCpf()))
            System.out.println("ERRO.... : " + tUsuario2a);
        else
            System.out.println("OK...... : " + tUsuario2a);
        if (tDao.delete(tUsuario2b.getCpf()))
            System.out.println("ERRO.... : " + tUsuario2b);
        else
            System.out.println("OK...... : " + tUsuario2b);
    }
}
