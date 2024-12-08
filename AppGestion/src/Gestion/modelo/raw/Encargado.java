package Gestion.modelo.raw;

public class Encargado {

    private int idUsuario;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String contrasena;
    private String correo;
    private String telefono;
    private Organizacion organizacion;
    private String estado;
    private String puesto;

    public Encargado() {
    }

    public Encargado(int idUsuario, String nombre, String apellidoPaterno, String apellidoMaterno, String contrasena, String correo, String telefono, Organizacion organizacion, String estado, String puesto) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.contrasena = contrasena;
        this.correo = correo;
        this.telefono = telefono;
        this.organizacion = organizacion;
        this.estado = estado;
        this.puesto = puesto;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }
    public String getContrasena() {
        return contrasena;
    }
    public String getCorreo() {
        return correo;
    }
    public String getTelefono() {
        return telefono;
    }
    public Organizacion getOrganizacion() {
        return organizacion;
    }
    public String getEstado() {
        return estado;
    }
    public String getPuesto() {
        return puesto;
    }
    public int getIdUsuario() {
        return idUsuario;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

}
