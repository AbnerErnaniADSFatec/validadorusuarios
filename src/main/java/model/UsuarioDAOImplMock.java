/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabricio
 */
public class UsuarioDAOImplMock implements UsuarioDAO{

    private List<Usuario> database;
    
    public UsuarioDAOImplMock(){
        database = new ArrayList();
        database.add(new Usuario("fabricio","123"));
        database.add(new Usuario("jadson","456"));
        database.add(new Usuario("victor","xyz"));
    }
    
    @Override
    public Usuario buscar(String userName) {
            Usuario found = null;
            for(Usuario u: database){
                if (u.getUserName().equals(userName)){
                    found = new Usuario(u.getUserName(),
                                        u.getSenha());
                    break;
                }
            }
            return found;
    }

    @Override
    public boolean testeCon() {
        return true;
    }
}
