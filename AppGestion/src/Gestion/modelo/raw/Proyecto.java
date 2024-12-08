package Gestion.modelo.raw;

public class Proyecto {
    private int idProyecto;
    private String nombre;
    private String descripcion;
    private String estado;
    private Coordinador coordinador;
    private Organizacion organizacion;
    private String fechaInicio;
    private String fechaFin;
    private Encargado encargado;
    private int cupos;
    private String tipo;

    public Proyecto() {}
    public Proyecto(int idProyecto, String nombre, String descripcion, String estado, Coordinador coordinador, Organizacion organizacion, String fechaInicio, String fechaFin, Encargado encargado, int cupos, String tipo) {
        this.idProyecto = idProyecto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.coordinador = coordinador;
        this.organizacion = organizacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.encargado = encargado;
        this.cupos = cupos;
        this.tipo = tipo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }

    public void setEncargado(Encargado encargado) {
        this.encargado = encargado;
    }

    public String getEstado() {
        return estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public Coordinador getCoordinador() {
        return coordinador;
    }

    public Encargado getEncargado() {
        return encargado;
    }

    public int getCupos() {
        return cupos;
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
