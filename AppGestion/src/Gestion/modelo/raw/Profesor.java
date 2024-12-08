package Gestion.modelo.raw;

public class Profesor {

    private String idUsuario;
    private String contrasena;
    private String correo;
    private String nombre;
    private String especialidad;
    private String estado;
    private String matricula;
    private String telefono;
    private String apellidoPaterno;
    private String apellidoMaterno;

    public Profesor() {
    }
    public Profesor(String idUsuario, String contrasena, String correo, String nombre, String especialidad, String estado, String matricula, String telefono, String apellidoPaterno, String apellidoMaterno) {
        this.idUsuario = idUsuario;
        this.contrasena = contrasena;
        this.correo = correo;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.estado = estado;
        this.matricula = matricula;
        this.telefono = telefono;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoPaterno = apellidoPaterno;
    }
    public String getEstado() {
        return estado;
    }
    public String getMatricula() {
        return matricula;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getIdUsuario() {
        return idUsuario;
    }
    public String getContrasena() {
        return contrasena;
    }
    public String getCorreo() {
        return correo;
    }
    public String getNombre() {
        return nombre;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }
}
