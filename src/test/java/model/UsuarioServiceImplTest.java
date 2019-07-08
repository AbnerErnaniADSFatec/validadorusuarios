/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

public class UsuarioServiceImplTest {
    
    private static final UsuarioService usuarioServiceBlock = new UsuarioServiceImpl();

    @ParameterizedTest(name="Busca do usuario {0}")
    @CsvFileSource(resources="/usuarios.csv",delimiter=',')
    public void autenticarTestSucesso(String userName, String password){
        UsuarioDAO udao = new UsuarioDAOImpl();
        assumeTrue(udao.testeCon());
        Usuario u = udao.buscar(userName);
        assertEquals(userName, u.getUserName());
        assertEquals(password, u.getSenha());
    }
    
    @RepeatedTest(3)
    public void autenticarTestBloqueio(RepetitionInfo repetitionInfo){
        UsuarioDAO udao = new UsuarioDAOImpl();
        assumeTrue(udao.testeCon());
        if (repetitionInfo.getCurrentRepetition() < 3){
            Usuario u = usuarioServiceBlock.autenticar("fabricio", "1234");
            assertNull(u);
        } else if (repetitionInfo.getCurrentRepetition() == 2) {
            Usuario u = usuarioServiceBlock.autenticar("fabricio", "123");
            assertFalse(usuarioServiceBlock.usuarioBloqueado("fabricio"));
            assertEquals(0, usuarioServiceBlock.getFalha("fabricio"));
        }
    }
}
