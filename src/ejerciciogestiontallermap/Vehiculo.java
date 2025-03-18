
package ejerciciogestiontallermap;

import java.util.Map;
import java.util.Objects;

public class Vehiculo implements Comparable<Vehiculo>{
    //Atributos
    private String matricula;
    private String marca;
    private String modelo;
    private String fechaMatriculacion;

    //Getter and Setter
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFechaMatriculacion() {
        return fechaMatriculacion;
    }

    public void setFechaMatriculacion(String fechaMatriculacion) {
        this.fechaMatriculacion = fechaMatriculacion;
    }

    //Constructor
    public Vehiculo() {
    }

    public Vehiculo(String matricula, String marca, String modelo, String fechaMatriculacion) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.fechaMatriculacion = fechaMatriculacion;
    }
    
    //ToString para visualizar

    @Override
    public String toString() {
        return "\n\tMatricula: " + matricula + "\n\tMarca: " + marca
                + "\n\tModelo: " + modelo
                + "\n\tFecha de Matriculacion: " + fechaMatriculacion;
    }
    
    
    //Sobreescribir hashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.matricula);
        hash = 19 * hash + Objects.hashCode(this.marca);
        hash = 19 * hash + Objects.hashCode(this.modelo);
        hash = 19 * hash + Objects.hashCode(this.fechaMatriculacion);
        return hash;
    }

    //Sobreescribir equals

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehiculo other = (Vehiculo) obj;
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        return Objects.equals(this.fechaMatriculacion, other.fechaMatriculacion);
    }
    
    @Override
    public int compareTo(Vehiculo obj) {
        return this.matricula.compareTo(obj.matricula);
    }

    
}
