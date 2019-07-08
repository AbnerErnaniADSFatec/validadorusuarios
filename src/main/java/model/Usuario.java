/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author fabricio
 */
public class Usuario {
    private String userName;
    private String senha;

    public Usuario(){}
    
    public Usuario(String userName, String senha){
        this.setSenha(senha);
        this.setUserName(userName);
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
