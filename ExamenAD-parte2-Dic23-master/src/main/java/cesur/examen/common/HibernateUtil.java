package cesur.examen.common;

import com.mysql.cj.jdbc.ConnectionGroup;
import jdk.jshell.spi.ExecutionControlProvider;
import lombok.Getter;
import lombok.extern.java.Log;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * EXAMEN DE ACCESO A DATOS
 * Diciembre 2023
 *
 * Nombre del alumno: Álvaro Bonilla Lledó
 * Fecha: 11/12/2023
 *
 * No se permite escribir en consola desde las clases DAO, Service y Utils usando System.out.
 * En su lugar, usa log.info(), log.warning() y log.severe() para mostrar información interna
 * o para seguir la traza de ejecución.
 */

@Log
public class HibernateUtil {

    /**
     * SessionFactory is stored as a static final object accessible by all other classes
     * using getter (getter is autogenerated by lombok)
     *
     * Configuration data is retrieved from hibernate.cfg.xml located in resource folder.
     */
    @Getter
    private static final SessionFactory sessionFactory;

    static{
        log.info("Loading Hibernate configuration...");
        try {
            /* Complete method here */
            //sessionFactory = null;

            Configuration cfg = new Configuration();

            sessionFactory = cfg.configure().buildSessionFactory();

            if(sessionFactory!=null)
                log.info("SessionFactory created!");
            else
                log.info("SessionFactory not created yet!");

        } catch(Exception ex){
            log.severe("Something fails in buildSessionFactory()");
            log.severe(ex.getMessage());
            throw new RuntimeException("Hibernate config error");
        }
    }

}
