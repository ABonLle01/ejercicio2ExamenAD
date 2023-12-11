package cesur.examen.domain.car;

import cesur.examen.domain.client.Client;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

/**
 * EXAMEN DE ACCESO A DATOS
 * Diciembre 2023
 *
 * Nombre del alumno: Álvaro Bonilla Lledó
 * Fecha: 11/12/2023
 */


@Data
@Entity
@Table(name = "garaje")
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    private Long id;

    @Column(name = "matricula")
    private String plate;

    @Column(name = "modelo")
    private String model;

    @Column(name = "fabricante")
    private String manufacturer;

    @ManyToOne
    @JoinColumn(name = "id")
    private Client client;

    /**
     * Override inherited toString() method to prevent stackOverFlow exceptions
     * from relationship.
     * @return
     */
    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", plate='" + plate + '\'' +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", client=" + client.getName() +
                '}';
    }
}
