package co.edu.uniquindio;

public class Tecnico extends Empleado implements Contribuyente{

    //Constructor de Tecnico que usa los atributos de Empleado

    public Tecnico(String nombre, String id, Departamento departamento) {
        super(nombre, id, departamento);
    }

    //Implementacion del metodo contribuir

    @Override
    public String contribuir(){
        return "El tecnico hizo una contribucion";
    }

}
