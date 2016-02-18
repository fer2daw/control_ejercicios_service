
import java.sql.Date;
import java.util.List;
import negocio.dominio.Ejercicio;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import persistencia.dao.EjercicioDAO;
import persistencia.dao.impl.EjercicioDAOImplJDBC;
import persistencia.dao.impl.HibernateUtil;

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

        HibernateUtil.buildSessionFactory();

        try {
            HibernateUtil.openSessionAndBindToThread();

            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Ejercicio ejercicioInsert = new Ejercicio(7, "hu", "h1", "h1", Date.valueOf("2016-02-18"), "h1");
            //Ejercicio ejercicio = (Ejercicio) session.get(Ejercicio.class, 2);
            session.beginTransaction();

            session.delete(ejercicioInsert); //<|--- Aqui guardamos el objeto en la base de datos.

            session.getTransaction().commit();
            //System.out.println(ejercicio.getFechaEjercicio());
        } finally {
            HibernateUtil.closeSessionAndUnbindFromThread();
        }

        HibernateUtil.closeSessionFactory();

        //Ejercicio ejercicio=(Ejercicio)session.get(Ejercicio.class,2);
        //System.out.println(ejercicioDAO.get(1).getDescripcionEjercicio());
        //System.out.println(ejercicioDAO.insert(new Ejercicio("cvbn", "asdf2ASDF", "sdfg", Date.valueOf("2015-06-08"), "asdf")));
        //System.out.println(ejercicioDAO.update(new Ejercicio(1, "u", "u", "u", Date.valueOf("2015-06-08"), "u")));
        //ejercicioDAO.delete(3);
//        List<Ejercicio> ejercicios = ejercicioDAO.findAll();
//       for(int i = 0; i<ejercicios.size(); i++){
//            System.out.println(ejercicios.get(i).getNombreEjercicio());
//        }
//        List<Ejercicio> ejercicios = ejercicioDAO.findByCategoria("u");
//        for(int i = 0; i<ejercicios.size(); i++){
//            System.out.println(ejercicios.get(i).getNombreEjercicio());
//        }
    }

}
