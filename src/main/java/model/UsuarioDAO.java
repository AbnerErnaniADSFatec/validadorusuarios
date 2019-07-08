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
public interface UsuarioDAO {
    public Usuario buscar(String userName);
    public boolean testeCon();
}
