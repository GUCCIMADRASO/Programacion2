package co.edu.uniquindio;

import java.util.LinkedList;

public class Gerente extends Empleado implements Contribuyente {

    //Constructor de Gerente que usa los atributos de Empleado

    public Gerente(String nombre, String id, Departamento departamento) {
        super(nombre, id, departamento);
    }

    //Implementacion del metodo contribuir

    @Override
    public String contribuir() {
        return "El gerente hizo una contribucion";
    }

    //Metodo para gestionar un proyecto

    public Proyecto gestionarProyectos(LinkedList<Proyecto> proyectos, String nombreProyecto) {
        Proyecto proyectoEncontrado = new Proyecto(null,null);
        for (Proyecto proyecto : proyectos) {
            if (proyecto.getNombre().equalsIgnoreCase(nombreProyecto)) {
                proyectoEncontrado.setNombre(proyecto.getNombre());
                proyectoEncontrado.setCodigo(proyecto.getCodigo());
                proyectoEncontrado.setListEmpleadosAsociados(proyecto.getListEmpleadosAsociados());
                // Retorna el proyecto si se encuentra
            }
            else {
                System.out.print("El proyecto con el nombre: " + nombreProyecto + " no ha sido encontrado.");
                // Retorna un mensaje si no se encuentra el proyecto
            }
        }
        return proyectoEncontrado;
    }
}
