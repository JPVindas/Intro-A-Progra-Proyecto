package proyecto;

public class Finca {
    private String nombre;
    private String ubicacion;
    private double extension; // Tamaño de la finca en hectáreas
    private String propietario; // Nombre del propietario
    private String nombreEncargado;
    private String cedulaEncargado;
    private String telefonoEncargado;
    private int cantidadPotreros;
    private int cantidadAnimales;
    private int tamanoFinca; // Tamaño de la finca en una medida desconocida
    private String estado;
    private int cantidadTotalAnimales;
    private Potrero[] potreros;

    public Finca(String nombre, String ubicacion, double extension, String propietario, String nombreEncargado, String cedulaEncargado, String telefonoEncargado, int cantidadPotreros, int cantidadAnimales, int tamanoFinca, String estado, int cantidadTotalAnimales, Potrero[] potreros)
 {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.extension = extension;
        this.propietario = propietario;
        this.nombreEncargado = nombreEncargado;
        this.cedulaEncargado = cedulaEncargado;
        this.telefonoEncargado = telefonoEncargado;
        this.cantidadPotreros = cantidadPotreros;
        this.cantidadAnimales = cantidadAnimales;
        this.tamanoFinca = tamanoFinca;
        this.estado = estado;
        this.cantidadTotalAnimales = cantidadTotalAnimales;
        this.potreros = potreros;
        
        
    }

    public Potrero[] getPotreros() {
        return potreros;
    }


    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public double getExtension() {
        return extension;
    }

    public String getPropietario() {
        return propietario;
    }

    public String getNombreEncargado() {
        return nombreEncargado;
    }

    public String getCedulaEncargado() {
        return cedulaEncargado;
    }

    public String getTelefonoEncargado() {
        return telefonoEncargado;
    }

    public int getCantidadPotreros() {
        return cantidadPotreros;
    }

    public int getCantidadAnimales() {
        return cantidadAnimales;
    }

    public int getTamanoFinca() {
        return tamanoFinca;
    }

    public String getEstado() {
        return estado;
    }

    public int getCantidadTotalAnimales() {
        return cantidadTotalAnimales;
    }
    

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setExtension(double extension) {
        this.extension = extension;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public void setNombreEncargado(String nombreEncargado) {
        this.nombreEncargado = nombreEncargado;
    }

    public void setCedulaEncargado(String cedulaEncargado) {
        this.cedulaEncargado = cedulaEncargado;
    }

    public void setTelefonoEncargado(String telefonoEncargado) {
        this.telefonoEncargado = telefonoEncargado;
    }

    public void setCantidadPotreros(int cantidadPotreros) {
        this.cantidadPotreros = cantidadPotreros;
    }

    public void setCantidadAnimales(int cantidadAnimales) {
        this.cantidadAnimales = cantidadAnimales;
    }

    public void setTamanoFinca(int tamanoFinca) {
        this.tamanoFinca = tamanoFinca;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setPotreros(Potrero[] potreros) {
        this.potreros = potreros;
    }


    public void setCantidadTotalAnimales(int cantidadTotalAnimales) {
        this.cantidadTotalAnimales = cantidadTotalAnimales;
    }
    @Override
    public String toString() {
        StringBuilder potrerosStr = new StringBuilder();
        
        for(Potrero potrero : potreros) {
            potrerosStr.append(potrero.toString()).append("\n");
        }

        return "Finca: " + 
               "\nNombre: " + nombre +
               "\nUbicación: " + ubicacion +
               "\nExtensión: " + extension + " hectáreas" +
               "\nPropietario: " + propietario +
               "\nNombre del Encargado: " + nombreEncargado +
               "\nCédula del Encargado: " + cedulaEncargado +
               "\nTeléfono del Encargado: " + telefonoEncargado +
               "\nCantidad de Potreros: " + cantidadPotreros +
               "\nCantidad de Animales: " + cantidadAnimales +
               "\nTamaño de la finca: " + tamanoFinca +
               "\nEstado de la finca: " + estado +
               "\nCantidad Total de Animales de la finca: " + cantidadTotalAnimales+
               "\nPotreros: \n" + potrerosStr;
    }
}