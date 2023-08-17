package proyecto;

public class Ganado {
    private String codigo;
    private String nombre;
    private String fechaNacimiento;
    private double ultimoPeso;
    private String sexo; // 'M' para masculino, 'F' para femenino
    private String raza;

    // Constructor
    public Ganado(String codigo, String nombre, String fechaNacimiento, double ultimoPeso, String sexo, String raza){

        this.codigo = codigo;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.ultimoPeso = ultimoPeso;
        this.sexo= sexo;
        this.raza = raza;
    }

    // Getters
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public double getUltimoPeso() {
        return ultimoPeso;
    }

    public String getSexo() {
        return sexo;
    }

    public String getRaza() {
        return raza;
    }

    // Setters
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setUltimoPeso(double ultimoPeso) {
        this.ultimoPeso = ultimoPeso;
    }

    public void setSexo(String sexo) {
        if (sexo.equals("M") || sexo.equals("F")) {
            this.sexo = sexo;
        } else {
            System.out.println("Sexo no válido. Debe ser 'M' o 'F'.");
        }
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Override
    public String toString() {
        return "Ganado: " + 
               "\nCodigo: " + codigo +
               "\nNombre: " + nombre +
               "\nFecha de Nacimiento: " + fechaNacimiento +
               "\nUltimo Peso registrado: " + ultimoPeso +
               "\nSexo: " + sexo +
               "\nRaza: " + raza;
    }
}
