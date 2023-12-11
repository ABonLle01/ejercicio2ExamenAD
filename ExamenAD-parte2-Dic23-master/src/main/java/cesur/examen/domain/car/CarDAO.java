package cesur.examen.domain.car;

import cesur.examen.common.DAO;
import cesur.examen.common.HibernateUtil;
import cesur.examen.domain.client.Client;
import lombok.extern.java.Log;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * EXAMEN DE ACCESO A DATOS
 * Diciembre 2023
 *
 * Nombre del alumno: Álvaro Bonilla Lledó
 * Fecha: 11/12/2023
 */

@Log
public class CarDAO implements DAO<Car> {
    @Override
    public Car save(Car car) {

        /* Implement method here */

        Car salida = null;

        try(org.hibernate.Session s = HibernateUtil.getSessionFactory().openSession()){
            Transaction t = s.beginTransaction();
            s.persist(car);
            t.commit();
            salida=car;
            log.info("Coche guardado "+car);
        }catch (Exception ex){
            log.severe("Error al guardar el coche "+car.toString());
        }


        return salida;
    }

    @Override
    public Car update(Car car) {
        return null;
    }

    @Override
    public boolean remove(Car car) {
        return false;
    }

    @Override
    public Car get(Long id) {
        return null;
    }

    @Override
    public List<Car> getAll() {
        return null;
    }

    public List<Car> getAllByManufacturer(String manufacturer){
        var out = new ArrayList<Car>();


        /* Implement method here */

        try( org.hibernate.Session s = HibernateUtil.getSessionFactory().openSession()) {
            Query<Car> q = s.createQuery( "from Car c where c.manufacturer=:m", Car.class);
            q.setParameter("m",manufacturer);
            out = (ArrayList<Car>) q.getResultList();
        }

        return out;
    }



}
