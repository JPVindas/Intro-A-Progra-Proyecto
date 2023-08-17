package proyecto;

public class Potrero {
    private String codigo;
    private String nombre;
    private String estado;
    private String fechaEntrada;
    private String fechaSalida;
    private int cantidadAnimales;
    private boolean poseeAgua;
    private String tipoTerreno;
    private int numeroAnimales;
    private double extension;
    private int capacidadAnimales;
    private String tipoPasto;
    private int cantidadGanado;
    private double Capacidad;

    
    public Potrero(String codigo, String nombre, String estado, String fechaEntrada, String fechaSalida, int cantidadAnimales, boolean poseeAgua, String tipoTerreno, double extension, int capacidadAnimales, String tipoPasto, int Ganado, double Capacidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.estado = estado;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.cantidadAnimales = cantidadAnimales;
        this.poseeAgua = poseeAgua;
        this.tipoTerreno = tipoTerreno;
        this.extension = extension;
        this.capacidadAnimales = capacidadAnimales;
        this.tipoPasto = tipoPasto;
    }

    public int getCantidadGanado() {
        return cantidadGanado;
    }

    public double getCapacidad() {
        return Capacidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEstado() {
        return estado;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public int getCantidadAnimales() {
        return cantidadAnimales;
    }

    public boolean isPoseeAgua() {
        return poseeAgua;
    }

    public String getTipoTerreno() {
        return tipoTerreno;
    }

    public double getExtension() {
        return extension;
    }

    public int getCapacidadAnimales() {
        return capacidadAnimales;
    }

    public String getTipoPasto() {
        return tipoPasto;
    }
     public int getNumeroAnimales() {
        return numeroAnimales;
    }

    public void setCantidadGanado(int cantidadGanado) {
        this.cantidadGanado = cantidadGanado;
    }

    public void setCapacidad(double Capacidad) {
        this.Capacidad = Capacidad;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public void setNumeroAnimales(int nuevoNumeroAnimales) {
        this.numeroAnimales = nuevoNumeroAnimales;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public void setCantidadAnimales(int cantidadAnimales) {
        this.cantidadAnimales = cantidadAnimales;
    }

    public void setPoseeAgua(boolean poseeAgua) {
        this.poseeAgua = poseeAgua;
    }

    public void setTipoTerreno(String tipoTerreno) {
        this.tipoTerreno = tipoTerreno;
    }

    public void setExtension(double extension) {
        this.extension = extension;
    }

    public void setCapacidadAnimales(int capacidadAnimales) {
        this.capacidadAnimales = capacidadAnimales;
    }

    public void setTipoPasto(String tipoPasto) {
        this.tipoPasto = tipoPasto;
    }
     @Override
    public String toString() {
        return "Potrero: " + 
               "\nCódigo: " + codigo +
               "\nNombre: " + nombre +
               "\nEstado: " + estado +
               "\nFecha de Entrada: " + fechaEntrada +
               "\nFecha de Salida: " + fechaSalida +
               "\nCantidad de Animales: " + cantidadAnimales +
               "\nPosee Agua: " + (poseeAgua ? "Sí" : "No") +
               "\nTipo de Terreno: " + tipoTerreno +
               "\nExtensión: " + extension + " hectáreas" +
               "\nCapacidad de Animales: " + capacidadAnimales +
               "\nTipo de Pasto: " + tipoPasto;
    }

}


    
