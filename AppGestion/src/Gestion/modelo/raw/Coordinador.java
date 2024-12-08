package Gestion.modelo.raw;

public class Coordinador {

    private String nombre;
    private int idUsuario;
    private String area_especialidad;
    private String contrasena;
    private String correo;
    private String matricula;

    public Coordinador() {
    }

    public Coordinador(String nombre, int idUsuario, String area_especialidad, String contrasena, String correo, String matricula) {
        this.nombre = nombre;
        this.idUsuario = idUsuario;
        this.area_especialidad = area_especialidad;
        this.contrasena = contrasena;
        this.correo = correo;
        this.matricula = matricula;
    }
    public String getNombre() {
        return nombre;
    }

    public String getContrasena() {
        return contrasena;
    }
    public String getCorreo() {
        return correo;
    }
    public String getMatricula() {
        return matricula;
    }
    public int getIdUsuario() {
        return idUsuario;
    }
    public String getArea_especialidad() {
        return area_especialidad;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public void setArea_especialidad(String area_especialidad) {
        this.area_especialidad = area_especialidad;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
