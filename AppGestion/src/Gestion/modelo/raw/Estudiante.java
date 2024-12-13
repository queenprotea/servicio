package Gestion.modelo.raw;

public class Estudiante {

    private int idEstudiante;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String semestre;
    private String telefono;
    private String correo;
    private String password;
    private String estado;
    private String matricula;
    private String promedio;
    private int creditos;
    private Proyecto proyecto;
    private String seleccionProyecto;
    private String tipoProyecto;
    private boolean estadoProyecto;


    public Estudiante(int idEstudiante, String nombre, String apellidoPaterno, String apellidoMaterno, String semestre, String telefono, String correo, String password, String estado, String matricula, String promedio, int creditos) {
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.semestre = semestre;
        this.telefono = telefono;
        this.correo = correo;
        this.password = password;
        this.estado = estado;
        this.matricula = matricula;
        this.promedio = promedio;
        this.creditos = creditos;
    }
    public Estudiante() {
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getEstado() {
        return estado;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getPassword() {
        return password;
    }

    public String getPromedio() {
        return promedio;
    }

    public String getSemestre() {
        return semestre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPromedio(String promedio) {
        this.promedio = promedio;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setSeleccionProyecto(String seleccionProyecto) {
        this.seleccionProyecto = seleccionProyecto;
    }

    public String getSeleccionProyecto() {
        return seleccionProyecto;
    }

    public void setTipoProyecto(String tipoProyecto) {
        this.tipoProyecto = tipoProyecto;
    }

    public String getTipoProyecto() {
        return tipoProyecto;
    }

    public void setEstadoProyecto(boolean estadoProyecto) {
        this.estadoProyecto = estadoProyecto;
    }
    public boolean getEstadoProyecto() {
        return estadoProyecto;
    }
}
