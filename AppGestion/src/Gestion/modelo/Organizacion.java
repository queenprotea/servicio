package Gestion.modelo;

public class Organizacion {

    private int idOrganizacion;
    private String razonSocial;
    private String telefono;
    private String correo;
    private String calle;
    private String Estado;
    private String ciudad;
    private String codigoPostal;
    private String sector;
    private String descripcion;
    private String activa;

    public Organizacion() {}
    public Organizacion(int idOrganizacion, String razonSocial, String telefono, String correo, String calle, String Estado, String ciudad, String codigoPostal, String sector, String descripcion, String activa) {
        this.idOrganizacion = idOrganizacion;
        this.razonSocial = razonSocial;
        this.telefono = telefono;
        this.correo = correo;
        this.calle = calle;
        this.Estado = Estado;
        this.ciudad = ciudad;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public void setActiva(String activa) {
        this.activa = activa;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setIdOrganizacion(int idOrganizacion) {
        this.idOrganizacion = idOrganizacion;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getEstado() {
        return Estado;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getIdOrganizacion() {
        return idOrganizacion;
    }

    public String getActiva() {
        return activa;
    }

    public String getCalle() {
        return calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public String getSector() {
        return sector;
    }

}