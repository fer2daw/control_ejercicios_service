
import java.sql.Date;
import java.util.List;
import negocio.dominio.Ejercicio;
import persistencia.dao.EjercicioDAO;
import persistencia.dao.impl.EjercicioDAOImplJDBC;

/**
 *
 * @author fernandoarenasdev
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EjercicioDAO ejercicioDAO = new EjercicioDAOImplJDBC();
        
        //System.out.println(ejercicioDAO.get(1).getDescripcionEjercicio());
        System.out.println(ejercicioDAO.insert(new Ejercicio("cvbn", "asdf2ASDF", "sdfg", Date.valueOf("2015-06-08"), "asdf")));
        //System.out.println(ejercicioDAO.update(new Ejercicio(1, "u", "u", "u", Date.valueOf("2015-06-08"), "u")));
        //ejercicioDAO.delete(3);
//        List<Ejercicio> ejercicios = ejercicioDAO.findAll();
//        for(int i = 0; i<ejercicios.size(); i++){
//            System.out.println(ejercicios.get(i).getNombreEjercicio());
//        }

//        List<Ejercicio> ejercicios = ejercicioDAO.findByCategoria("u");
//        for(int i = 0; i<ejercicios.size(); i++){
//            System.out.println(ejercicios.get(i).getNombreEjercicio());
//        }
    
    
    }
    
}
