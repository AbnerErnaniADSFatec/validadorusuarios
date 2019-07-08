 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author fabricio
 */
public class UsuarioServiceImpl implements UsuarioService{

    private Map<String, Integer> falhaLogin;
    private UsuarioDAO usuarioDAO;
    
    public UsuarioServiceImpl(){
        falhaLogin = new HashMap();
        usuarioDAO = new UsuarioDAOImplMock();
    }
    
    @Override
    public Usuario autenticar(String userName, String senha) {
        Usuario ur = null;
        Usuario u = usuarioDAO.buscar(userName);
        if (u!=null){
            Integer contadorFalha = falhaLogin.get(u.getUserName());
            if ( contadorFalha == null || contadorFalha <= 3 ){
                if (u.getSenha().equals(senha) && contadorFalha == null){
                    ur = u;
                } else if ( u.getSenha().equals(senha) && contadorFalha != null && contadorFalha <= 3 ) {
                    ur = u;
                    if ( contadorFalha == 2 ) { falhaLogin.put(userName, 0); }
                } else {
                    if (contadorFalha != null) {
                        falhaLogin.put(userName, ++contadorFalha);
                    } else {
                        falhaLogin.put(userName, 1);
                    }
                }
            }
        }
        return ur;
    }

    @Override
    public boolean usuarioBloqueado(String userName) {
        Usuario u = usuarioDAO.buscar(userName);
        if (u!= null && this.falhaLogin.get(userName) > 3){
            return true;
        }
        return false;
    }

    @Override
    public int getFalha(String userName){
        if ( this.falhaLogin.get(userName) == null ) {
            return 0;
        } else {
            return this.falhaLogin.get(userName);
        }
    }
}