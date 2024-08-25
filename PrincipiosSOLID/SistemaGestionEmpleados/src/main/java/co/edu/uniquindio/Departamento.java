package co.edu.uniquindio;

import java.util.LinkedList;

public class Departamento {
    private String nombre;
    private String codigo;
    private LinkedList<Empleado> listEmpleados;

    //Construcor de Departamento

    public Departamento(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.listEmpleados = new LinkedList<>();
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

    public LinkedList<Empleado> getListEmpleados() {
        return listEmpleados;
    }

    public void setListEmpleados(LinkedList<Empleado> listEmpleados) {
        this.listEmpleados = listEmpleados;
    }
}
