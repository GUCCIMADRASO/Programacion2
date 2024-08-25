package co.edu.uniquindio;

import java.util.LinkedList;

public class Proyecto {
    private String nombre;
    private String codigo;
    private LinkedList<Empleado> listEmpleadosAsociados;

    //Construcor de Proyecto

    public Proyecto(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.listEmpleadosAsociados = new LinkedList<>();
    }

    //Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LinkedList<Empleado> getListEmpleadosAsociados() {
        return listEmpleadosAsociados;
    }

    public void setListEmpleadosAsociados(LinkedList<Empleado> listEmpleadosAsociados) {
        this.listEmpleadosAsociados = listEmpleadosAsociados;
    }
}
