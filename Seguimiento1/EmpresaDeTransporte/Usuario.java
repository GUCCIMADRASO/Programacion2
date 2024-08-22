public class Usuario {
    private String nombre;
    private String edad;
    private Vehiculo vehiculo;
    private double peso;

    public Usuario(String nombre, String edad, double peso , Vehiculo vehiculo) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.vehiculo = vehiculo;
    }

    public Usuario(String nombre, String edad, double peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
    }

    public Usuario () {}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Vehiculo getVehiculo() { return vehiculo; }

    @Override
    public String toString() {
        return "{" +
                "nombre='" + nombre + '\'' +
                ", edad='" + edad + '\'' +
                ", peso='" + peso + '\'' +
                ", vehiculo=" + vehiculo +
                '}';
    }
}
