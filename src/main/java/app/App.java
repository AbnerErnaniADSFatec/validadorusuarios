/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package app;

import java.util.Scanner;
import model.Usuario;
import model.UsuarioService;
import model.UsuarioServiceImpl;

public class App {

    public static void main(String[] args) {
        UsuarioService usuarioService = new UsuarioServiceImpl();
        boolean continua = true;
        String userName, senha;
        Scanner reader = new Scanner(System.in);
        while (continua){
            System.out.print("Digite o nome de usuario: ");
            userName = reader.next();
            System.out.print("Digite a senha: ");
            senha = reader.next();
            System.out.println(userName);
            System.out.println(senha);
            Usuario u = usuarioService.autenticar(userName, senha);
            if ( u == null )
            {
                System.out.println("Falha de autenticacao!");
                if (usuarioService.usuarioBloqueado(userName)){
                   continua = false; 
                   System.out.println("Usuario Bloqueado!");
                }
            }else{
                System.out.println("Usuario autenticado com sucesso!");
            }                 
        }
        reader.close();
    }
}
