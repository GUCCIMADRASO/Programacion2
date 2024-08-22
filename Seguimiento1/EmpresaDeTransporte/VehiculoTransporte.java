
public class VehiculoTransporte extends Vehiculo {

    private int maxPasajeros;
    private Usuario[]usuarios;

    public VehiculoTransporte(String placa, String modelo, String marca, String color,int maxPasajeros) {
        super(placa, modelo, marca, color);
        this.maxPasajeros = maxPasajeros;
        usuarios = new Usuario[maxPasajeros];
    }

    public VehiculoTransporte() {}

    public int getMaxPasajeros() {
        return maxPasajeros;
    }

    public void setMaxPasajeros(int maxPasajeros) {
        this.maxPasajeros = maxPasajeros;
    }

    public Usuario[] getUsuarios() {
        return usuarios;
    }

    public String datosUsuarios(){
        String mensaje = "";
        for (Usuario usuario: usuarios){
            mensaje += " nombre = " + usuario.getNombre() + " edad = " + usuario.getEdad() + " peso " + usuario.getPeso() + " ";
        }
        return mensaje;
    }
}
