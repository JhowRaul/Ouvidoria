package br.edu.opet.ouvidoria.teste;

import java.time.LocalDate;

import br.edu.opet.ouvidoria.controller.UsuarioController;
import br.edu.opet.ouvidoria.dao.UsuarioDao;
import br.edu.opet.ouvidoria.dto.UsuarioDto;
import br.edu.opet.ouvidoria.model.Usuario;

public class TesteUsuarioController
{
    public static void main(String[] pArgs)
    {
        //
        // Pr� Teste
        //
        // Criar um Usuario
        Usuario tUsuarioA = new Usuario(3275896989L,"Jairo Junior", LocalDate.of(1978, 8, 29),"Rua xxx", 0, "restro@outlook.com", 41111,"M");

        // Criando o objeto de persist�ncia
        UsuarioDao tDao = new UsuarioDao();

        // Incluir o Usuario
        System.out.println();
        System.out.println("Incluindo um Usuario");
        Usuario tUsuario2a = tDao.create(tUsuarioA);
        if (tUsuario2a != null)
            System.out.println("OK...... : " + tUsuario2a);
        else
            System.out.println("ERRO.... : " + tUsuario2a);

        //
        // Teste
        //
        // Criar um Usuario
        Usuario tUsuarioB = new Usuario(71028519102L,"Yerlandia Westrocia", LocalDate.of(1978, 8, 29),"Rua xxx", 0, "restro@outlook.com", 41111,"F");

        // Criando o objeto de Controller
        UsuarioController tController = new UsuarioController();

        // Incluindo o Usuario
        System.out.println();
        System.out.println("Incluindo um Usuario via controller");
        UsuarioDto tDto = tController.cadastrarUsuario(tUsuarioB);
        if (tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
            System.out.println("           " + tDto.getUsuario());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        // Incluindo o Usuario
        System.out.println();
        System.out.println("Incluindo um Usuario nulo");
        tDto = tController.cadastrarUsuario(null);
        if (!tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        // Incluindo o Usuario
        System.out.println();
        System.out.println("Incluindo um Usuario j� existente");
        tDto = tController.cadastrarUsuario(tUsuarioA);
        if (!tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        //
        // P�s teste
        //
        // Remover o Usuario
        System.out.println();
        System.out.println("Removendo um Usuario");
        if (tDao.delete(tUsuario2a.getCpf()))
            System.out.println("OK...... : " + tUsuario2a);
        else
            System.out.println("ERRO.... : " + tUsuario2a);
    }
}
