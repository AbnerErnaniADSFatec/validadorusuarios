/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
/**
 *
 * @author fabricio
 */
public class UsuarioDAOImplTest {
    @Test
    @DisplayName("Teste de conexão do banco")
    public void buscarTest(){
        UsuarioDAO udao = new UsuarioDAOImpl();
        assumeTrue(udao.testeCon());
    }
}
