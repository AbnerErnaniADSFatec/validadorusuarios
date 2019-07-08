package model;
import model.Usuario;
import java.util.List;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.query.Query;
public class UsuarioDAOImpl implements UsuarioDAO{
    private ObjectContainer users;
    private Query query;
    private boolean conexao;

    public UsuarioDAOImpl(){
        try {
            this.users = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/usuarios.db4o");
            // users.store(new Usuario("fabricio","123"));
            // users.commit();
            // users.store(new Usuario("jadson","456"));
            // users.commit();
            // users.store(new Usuario("victor","xyz"));
            // users.commit();
            // users.store(new Usuario("abner","152a"));
            // users.commit();
            // users.store(new Usuario("Mari","1234"));
            // users.commit();
            // users.store(new Usuario("vitoria","1245"));
		    // users.commit();
            this.query = users.query();
            this.conexao = true;
        } catch (Exception e) {
            e.printStackTrace();
            this.conexao = false;
        }
    }
    
    @Override
    public Usuario buscar(String userName) {
        Usuario found = null;
        try {
            this.query.constrain(Usuario.class);
            List<Usuario> allUsers = this.query.execute();
		    for (Usuario usr : allUsers){
                if (usr.getUserName().equals(userName)){
                    found = new Usuario(usr.getUserName(), usr.getSenha());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return found;
    }

    @Override
    public boolean testeCon() {
        return this.conexao;
    }
}