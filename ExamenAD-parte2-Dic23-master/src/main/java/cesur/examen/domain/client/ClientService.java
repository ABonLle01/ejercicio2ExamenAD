package cesur.examen.domain.client;

import cesur.examen.common.HibernateUtil;
import cesur.examen.domain.car.Car;
import cesur.examen.domain.car.CarDAO;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * EXAMEN DE ACCESO A DATOS
 * Diciembre 2023
 *
 * Nombre del alumno: Álvaro Bonilla Lledó
 * Fecha: 11/12/2023
 */

public class ClientService {

    /**
     * Return a List of Client entities that have one or more cars of the given manufacturer.
     * If a client has more than one car of the manufacturer, it only appears once in
     * the list (similar to a Set). Tip: start querying to Car entities...
     *
     * @param manufacturer
     * @return the list of clients
     */
    public static List<Client> hasManufacturer(String manufacturer){
        var out= new ArrayList<Client>(0);

        /* Implement method here */

        try( org.hibernate.Session s = HibernateUtil.getSessionFactory().openSession()) {
            Query<Client> q = s.createQuery( "from Client c join Car car on c.id=car.client.id where car.manufacturer=:m", Client.class);
            q.setParameter("m",manufacturer);
            out = (ArrayList<Client>) q.getResultList();
        }


        return out;
    }
}
