import java.util.LinkedList;

public class EmpresaTransporte {
    private LinkedList<Propietario> propietarios = new LinkedList<>();
    private LinkedList<Usuario> usuarios = new LinkedList<>();
    private LinkedList<VehiculoTransporte> vehiculosTransporte = new LinkedList<>();
    private LinkedList<VehiculoCarga> vehiculosCarga = new LinkedList<>();

    public LinkedList<Propietario> getPropietarios() {
        return propietarios;
    }

    public LinkedList<Usuario> getUsuarios() {
        return usuarios;
    }

    public LinkedList<VehiculoTransporte> getVehiculosTransporte() {
        return vehiculosTransporte;
    }

    public LinkedList<VehiculoCarga> getVehiculosCarga() {
        return vehiculosCarga;
    }
}
