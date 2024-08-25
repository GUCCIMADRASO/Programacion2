package co.edu.uniquindio;

public abstract class Empleado {
    private String nombre;
    private String id;
    private Departamento departamento;

    //Construcor de Empleado

    public Empleado(String nombre, String id, Departamento departamento) {
        this.nombre = nombre;
        this.id = id;
        this.departamento = departamento;
    }

    //Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
