package proyecto;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.*;

public class Menu {
    private JFrame frame;

    private Ganado[] ganados = new Ganado[100];
    private int indiceGanados = 0;

    private Finca[] fincas = new Finca[50];
    private int indiceFincas = 0;

    private Potrero[] potreros = new Potrero[200];
    private int indicePotreros = 0;
    
    ModuloGestionFincas ModuloGestionFincas = new ModuloGestionFincas();
    
        public void seleccionarModulo() {
        boolean continuar = true;
        
        

        while (continuar) {
            String opcionModulo = JOptionPane.showInputDialog(null,
                    "Seleccione un módulo: \n"
                            + "1. Catálogos \n"
                            + "2. Visualización general de la finca \n"
                            + "3. Consultar información pregrabada \n"
                            + "4. Rotación de animales \n"
                            + "5. Salir",
                    "Selección de Módulo - Fincas Anónimas S.A.",
                    JOptionPane.PLAIN_MESSAGE);

            switch (opcionModulo) {
                case "1":
                    //lógica del módulo o simplemente llamar a otro menú.
                    mostrarMenu();
                    break;
                case "2":
                case "3":
                    // funcionalidad para "Consultar información pregrabada"
                    ModuloGestionFincas gestionFincas = new ModuloGestionFincas();
                    gestionFincas.setVisible(true);
                    break;
                case "4":
    ModuloGestionFincas gestionFincasRotacion = new ModuloGestionFincas();
    gestionFincasRotacion.setVisible(true);

    // Esperar a que se cierre la ventana
    while (gestionFincasRotacion.isVisible()) {
        try {
            Thread.sleep(500);  // Espera medio segundo antes de volver a verificar
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Procesa la finca seleccionada (si hay una)
    Finca fincaSeleccionada1 = gestionFincasRotacion.getFincaSeleccionada();
    Finca fincaSeleccionada2 = gestionFincasRotacion.getFincaSeleccionada(); // Ya con un método para obtener la segunda finca

    if (fincaSeleccionada1 != null && fincaSeleccionada2 != null) {
        // Aquí puedes hacer el intercambio de ganado entre las fincas
        int ganadoFinca1 = fincaSeleccionada1.getCantidadTotalAnimales();
        int ganadoFinca2 = fincaSeleccionada2.getCantidadTotalAnimales();

        fincaSeleccionada1.setCantidadTotalAnimales(ganadoFinca2);
        fincaSeleccionada2.setCantidadTotalAnimales(ganadoFinca1);

        // Actualiza la tabla para reflejar el cambio
        gestionFincasRotacion.updateTableModel();

        JOptionPane.showMessageDialog(null, "El ganado ha rotado con éxito entre " + fincaSeleccionada1.getNombre() + " y " + fincaSeleccionada2.getNombre(), "Éxito", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(null, "Debe seleccionar exactamente dos fincas para la rotación", "Error", JOptionPane.ERROR_MESSAGE);
    }
    gestionFincasRotacion.updateTableModel();
    break;


                case "5":
                    continuar = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
    }

    public void mostrarMenu() {
        boolean continuar = true;

        while (continuar) {
            String opcion = JOptionPane.showInputDialog(null,
                    "Seleccione una opción: \n"
                            + "1. Agregar información \n"
                            + "2. Eliminar información \n"
                            + "3. Consultar información \n"
                            + "4. Modificar información \n"
                            + "5. Salir",
                    "Menú Fincas Anónimas S.A.",
                    JOptionPane.PLAIN_MESSAGE);

            switch (opcion) {
                case "1":
                    agregarInformacion();
                    break;
                case "2":
                    eliminarInformacion();
                    break;
                case "3":
                    consultarInformacion();
                    break;
                case "4":
                    modificarInformacion();
                    break;
                case "5":
                    continuar = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
    }

    private void agregarInformacion() {
        String tipo = JOptionPane.showInputDialog(null,
                "¿Qué deseas agregar? \n"
                        + "1. Ganado \n"
                        + "2. Finca \n"
                        + "3. Potrero",
                "Agregar Información",
                JOptionPane.PLAIN_MESSAGE);

        switch (tipo) {
            case "1":
                agregarGanado();
                break;
            case "2":
                agregarFinca();
                break;
            case "3":
                agregarPotrero();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida", "Error", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }
    private void agregarGanado() {
    String codigo = JOptionPane.showInputDialog("Ingresa el código del animal:");
    String nombre = JOptionPane.showInputDialog("Ingresa el nombre del animal:");
    String FechaNacimiento = JOptionPane.showInputDialog("Digite la fecha de nacimiento del animal (Mes/Día/Año)");
    int UltimoPeso = Integer.parseInt(JOptionPane.showInputDialog("Digite el ultimo peso en kg registrado"));
    String Sexo = JOptionPane.showInputDialog("Digite el sexo del animal(F/M)");
    String raza = JOptionPane.showInputDialog("Digite la raza del animal:");
    
    


    Ganado nuevoGanado = new Ganado(codigo, nombre, FechaNacimiento, UltimoPeso, Sexo, raza);

        if (indiceGanados < ganados.length) {
            ganados[indiceGanados] = nuevoGanado;
            indiceGanados++;
        } else {
            JOptionPane.showMessageDialog(null, "No hay espacio para más ganado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void agregarFinca() {
    String nombre = JOptionPane.showInputDialog("Ingresa el nombre de la finca:");
    String ubicacion = JOptionPane.showInputDialog("Ingresa la ubicación de la finca:");
    String nombreEncargado = JOptionPane.showInputDialog("Ingresa el nombre del encargado:");
    String cedulaEncargado = JOptionPane.showInputDialog("Ingrese la cédula del encargado:");
    String telefonoEncargado = JOptionPane.showInputDialog("Ingrese el teléfono del encargado:");
    int cantidadPotreros = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de potreros:"));
    double tamanoFinca = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el tamaño total de la finca (en hectáreas):"));
    int cantidadAnimales = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad total de animales:"));

        Finca nuevaFinca = new Finca(nombre, ubicacion, tamanoFinca, ubicacion, nombreEncargado, cedulaEncargado, telefonoEncargado, cantidadPotreros, cantidadAnimales, indiceFincas, nombre, cantidadAnimales, potreros);

        if (indiceFincas < fincas.length) {
            fincas[indiceFincas] = nuevaFinca;
            indiceFincas++;
        } else {
            JOptionPane.showMessageDialog(null, "No hay espacio para más fincas", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void agregarPotrero() {
    String codigo = JOptionPane.showInputDialog("Ingresa el código del potrero:");
    String nombre = JOptionPane.showInputDialog("Ingresa el nombre del potrero:");
    String estado = (String) JOptionPane.showInputDialog(
                    null, 
                    "Selecciona el estado del potrero:", 
                    "Estado del Potrero", 
                    JOptionPane.QUESTION_MESSAGE, 
                    null, 
                    new Object[] { "descanso", "libre", "ocupado", "No utilizable" },
                    "libre");
    String fechaEntrada = JOptionPane.showInputDialog("Ingresa la fecha de entrada de ganado (Mes/Día/Año):");
    String fechaSalida = JOptionPane.showInputDialog("Ingresa la fecha de salida del ganado (Mes/Día/Año):");
    int cantidadAnimales = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de animales en el potrero:"));
    boolean poseeAgua = JOptionPane.showConfirmDialog(null, "¿Posee agua para el ganado?", "Agua", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    String tipoTerreno = JOptionPane.showInputDialog("Ingrese el tipo de terreno del potrero:");


        Potrero nuevoPotrero = new Potrero(codigo, nombre, estado, fechaEntrada, fechaSalida, cantidadAnimales, poseeAgua, tipoTerreno, indiceGanados, cantidadAnimales, tipoTerreno, indiceGanados, indiceFincas);

        if (indicePotreros < potreros.length) {
            potreros[indicePotreros] = nuevoPotrero;
            indicePotreros++;
        } else {
            JOptionPane.showMessageDialog(null, "No hay espacio para más potreros", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarInformacion() {
    String tipo = JOptionPane.showInputDialog(null,
                "¿Qué información deseas eliminar? \n"
                        + "1. Ganado \n"
                        + "2. Finca \n"
                        + "3. Potrero",
                "Eliminar Información",
                JOptionPane.PLAIN_MESSAGE);

    switch (tipo) {
        case "1":
            eliminarGanado();
            break;
        case "2":
            eliminarFinca();
            break;
        case "3":
            eliminarPotrero();
            break;
        default:
            JOptionPane.showMessageDialog(null, "Opción no válida", "Error", JOptionPane.ERROR_MESSAGE);
            break;
    }
}

    private void consultarInformacion() {
    String tipo = JOptionPane.showInputDialog(null,
                "¿Qué información deseas consultar? \n"
                        + "1. Ganado \n"
                        + "2. Finca \n"
                        + "3. Potrero",
                "Consultar Información",
                JOptionPane.PLAIN_MESSAGE);

    switch (tipo) {
        case "1":
            consultarGanado();
            break;
        case "2":
            consultarFinca();
            break;
        case "3":
            consultarPotrero();
            break;
        default:
            JOptionPane.showMessageDialog(null, "Opción no válida", "Error", JOptionPane.ERROR_MESSAGE);
            break;
    }
}

    private void modificarInformacion() {
    String tipo = JOptionPane.showInputDialog(null,
                "¿Qué información deseas modificar? \n"
                        + "1. Ganado \n"
                        + "2. Finca \n"
                        + "3. Potrero",
                "Modificar Información",
                JOptionPane.PLAIN_MESSAGE);

    switch (tipo) {
        case "1":
            modificarGanado();
            break;
        case "2":
            modificarFinca();
            break;
        case "3":
            modificarPotrero();
            break;
        default:
            JOptionPane.showMessageDialog(null, "Opción no válida", "Error", JOptionPane.ERROR_MESSAGE);
            break;
    }
}

private void modificarGanado() {
    String codigo = JOptionPane.showInputDialog("Ingresa el código del animal que deseas modificar:");
    int indice = buscarGanadoPorCodigo(codigo);

    if (indice != -1) {
        String nuevoNombre = JOptionPane.showInputDialog("Ingresa el nuevo nombre del animal:");
        String nuevaFechaNacimiento = JOptionPane.showInputDialog("Digite la nueva fecha de nacimiento del animal (Mes/Día/Año):");
        int nuevoPeso = Integer.parseInt(JOptionPane.showInputDialog("Digite el nuevo peso en kg registrado:"));
        String nuevoSexo = JOptionPane.showInputDialog("Digite el nuevo sexo del animal (F/M):");

        ganados[indice].setNombre(nuevoNombre);


        JOptionPane.showMessageDialog(null, "Información del ganado actualizada con éxito");
    } else {
        JOptionPane.showMessageDialog(null, "No se encontró ganado con el código proporcionado", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

// Este método busca un ganado por su código y devuelve su índice. Si no se encuentra, devuelve -1.
private int buscarGanadoPorCodigo(String codigo) {
    for (int i = 0; i < ganados.length; i++) {
        // Suponiendo que tienes un método getCodigo() en tu clase Ganado
        if (ganados[i] != null && ganados[i].getCodigo().equals(codigo)) {
            return i;
        }
    }
    return -1;
}

private void modificarFinca() {
    String nombreFinca = JOptionPane.showInputDialog("Ingresa el nombre de la finca que deseas modificar:");
    int indice = buscarFincaPorNombre(nombreFinca);

    if (indice != -1) {
        String nuevoNombre = JOptionPane.showInputDialog("Ingresa el nuevo nombre de la finca:");
        String nuevaUbicacion = JOptionPane.showInputDialog("Ingresa la nueva ubicación de la finca:");
        String nuevoNombreEncargado = JOptionPane.showInputDialog("Ingresa el nuevo nombre del encargado:");
        String nuevaCedulaEncargado = JOptionPane.showInputDialog("Ingrese la nueva cédula del encargado:");
        String nuevoTelefonoEncargado = JOptionPane.showInputDialog("Ingrese el nuevo teléfono del encargado:");
        int nuevaCantidadPotreros = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad de potreros:"));
        double nuevoTamanoFinca = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo tamaño total de la finca (en hectáreas):"));
        int nuevaCantidadAnimales = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad total de animales:"));

        fincas[indice].setNombre(nuevoNombre);
        fincas[indice].setUbicacion(nuevaUbicacion);
        fincas[indice].setNombreEncargado(nuevoNombreEncargado);
        fincas[indice].setCedulaEncargado(nuevaCedulaEncargado);
        fincas[indice].setTelefonoEncargado(nuevoTelefonoEncargado);
        fincas[indice].setCantidadPotreros(nuevaCantidadPotreros);
        fincas[indice].setTamanoFinca((int)nuevoTamanoFinca); // TamanoFinca es int
        fincas[indice].setCantidadAnimales(nuevaCantidadAnimales);

        JOptionPane.showMessageDialog(null, "Información de la finca actualizada con éxito");
    } else {
        JOptionPane.showMessageDialog(null, "No se encontró finca con el nombre proporcionado", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

// Este método busca una finca por su nombre y devuelve su índice. Si no se encuentra, devuelve -1.
private int buscarFincaPorNombre(String nombreFinca) {
    for (int i = 0; i < fincas.length; i++) {
        if (fincas[i] != null && fincas[i].getNombre().equals(nombreFinca)) {
            return i;
        }
    }
    return -1;
}

private void modificarPotrero() {
    String codigoPotrero = JOptionPane.showInputDialog("Ingresa el código del potrero que deseas modificar:");
    int indice = buscarPotreroPorCodigo(codigoPotrero);

    if (indice != -1) {
        String nuevoNombre = JOptionPane.showInputDialog("Ingresa el nuevo nombre del potrero:");
        double nuevaExtension = Double.parseDouble(JOptionPane.showInputDialog("Ingresa la nueva extensión del potrero (en hectáreas):"));
        int nuevoNumeroAnimales = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el nuevo número de animales en el potrero:"));
        

        potreros[indice].setNombre(nuevoNombre);
        potreros[indice].setExtension(nuevaExtension);
        potreros[indice].setNumeroAnimales(nuevoNumeroAnimales);
        

        JOptionPane.showMessageDialog(null, "Información del potrero actualizada con éxito");
    } else {
        JOptionPane.showMessageDialog(null, "No se encontró el potrero con el código proporcionado", "Error", JOptionPane.ERROR_MESSAGE);
    }
}


// Este método busca un potrero por su nombre y devuelve su índice. Si no se encuentra, devuelve -1.
private int buscarPotreroPorCodigo(String codigo) {
    for (int i = 0; i < potreros.length; i++) {
        if (potreros[i] != null && potreros[i].getCodigo().equals(codigo)) {
            return i;
        }
    }
    return -1;
}

    private void consultarGanado() {
    String codigoConsulta = JOptionPane.showInputDialog("Ingresa el código del animal que deseas consultar:");

    Ganado ganadoBuscado = null;

    for (Ganado g : ganados) {
        if (g != null && g.getCodigo().equals(codigoConsulta)) {
            ganadoBuscado = g;
            break;
        }
    }

    if (ganadoBuscado != null) {
        String informacionGanado = "Código: " + ganadoBuscado.getCodigo() + 
                                   "\nNombre: " + ganadoBuscado.getNombre() + 
                                   "\nRaza: " + ganadoBuscado.getRaza() + 
                                   "\nPeso: " + ganadoBuscado.getUltimoPeso() + 
                                   "\nFecha de Nacimiento: " + ganadoBuscado.getFechaNacimiento() +
                                   "\nSexo: " + ganadoBuscado.getSexo();

        JOptionPane.showMessageDialog(null, informacionGanado, "Información del Ganado", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(null, "No se encontró ganado con el código ingresado", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    private void consultarFinca() {
    String nombreConsulta = JOptionPane.showInputDialog("Ingresa el nombre de la finca que deseas consultar:");
    Finca fincaBuscada = null;

    for (Finca f : fincas) {
        if (f != null && f.getNombre().equals(nombreConsulta)) {
            fincaBuscada = f;
            break;
        }
    }

    if (fincaBuscada != null) {
        String informacionFinca = "Nombre: " + fincaBuscada.getNombre() + 
                                  "\nUbicación: " + fincaBuscada.getUbicacion() + 
                                  "\nNombre del Encargado: " + fincaBuscada.getNombreEncargado() +
                                  "\nCédula del Encargado: " + fincaBuscada.getCedulaEncargado() +
                                  "\nTeléfono del Encargado: " + fincaBuscada.getTelefonoEncargado() +
                                  "\nCantidad de Potreros: " + fincaBuscada.getCantidadPotreros() +
                                 /* "\nTamaño de la Finca: " + fincaBuscada.() + " hectáreas" +*/
                                  "\nCantidad de Animales: " + fincaBuscada.getCantidadAnimales();

        JOptionPane.showMessageDialog(null, informacionFinca, "Información de la Finca", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(null, "No se encontró una finca con el nombre ingresado", "Error", JOptionPane.ERROR_MESSAGE);
    }
}




    private void consultarPotrero() {
    String codigoBuscado = JOptionPane.showInputDialog("Ingresa el código del potrero que deseas consultar:");

    Potrero potreroEncontrado = null;

    for (Potrero potrero : potreros) {
        if (potrero != null && potrero.getCodigo().equals(codigoBuscado)) {
            potreroEncontrado = potrero;
            break;
        }
    }

    if (potreroEncontrado != null) {
        String infoPotrero = "Información del potrero:\n"
                           + "Código: " + potreroEncontrado.getCodigo() + "\n"
                           + "Nombre: " + potreroEncontrado.getNombre() + "\n"
                           + "Estado: " + potreroEncontrado.getEstado() + "\n"
                           + "Fecha de entrada: " + potreroEncontrado.getFechaEntrada() + "\n"
                           + "Fecha de salida: " + potreroEncontrado.getFechaSalida() + "\n"
                           + "Cantidad de animales: " + potreroEncontrado.getCantidadAnimales() + "\n"
                           + "Posee agua: " + (potreroEncontrado.isPoseeAgua()? "Sí" : "No") + "\n"
                           + "Tipo de terreno: " + potreroEncontrado.getTipoTerreno();

        JOptionPane.showMessageDialog(null, infoPotrero);
    } else {
        JOptionPane.showMessageDialog(null, "Potrero no encontrado con el código proporcionado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }   

    private void eliminarGanado() {
    String codigoGanado = JOptionPane.showInputDialog("Ingresa el código del ganado que deseas eliminar:");
    int indice = buscarGanadoPorCodigo(codigoGanado);

    if (indice != -1) {
        ganados[indice] = null; // Es un arreglo de objetos por lo cual simplemente asignamos null para eliminar
        JOptionPane.showMessageDialog(null, "Ganado eliminado con éxito");
    } else {
        JOptionPane.showMessageDialog(null, "No se encontró el ganado con el código proporcionado", "Error", JOptionPane.ERROR_MESSAGE);
    }
}


    private void eliminarFinca() {
    String codigoFinca = JOptionPane.showInputDialog("Ingresa el código de la finca que deseas eliminar:");
    int indice = buscarFincaPorNombre(codigoFinca);

    if (indice != -1) {
        fincas[indice] = null; // Esu arreglo de objetos, simplemente asignamos null para eliminar
        compactarArregloFincas(); // Método adicional para reacomodar el arreglo y no dejar espacios nulos en medio
        JOptionPane.showMessageDialog(null, "Finca eliminada con éxito");
    } else {
        JOptionPane.showMessageDialog(null, "No se encontró la finca con el código proporcionado", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

private void compactarArregloFincas() {
    for (int i = 0; i < fincas.length - 1; i++) {
        if (fincas[i] == null) {
            fincas[i] = fincas[i + 1];
            fincas[i + 1] = null;
        }
    }
}

    private void eliminarPotrero() {
    String codigoPotrero = JOptionPane.showInputDialog("Ingresa el código del potrero que deseas eliminar:");

    int indice = buscarPotreroPorCodigo(codigoPotrero);

    if (indice != -1) {
        potreros[indice] = null;  // Elimina el potrero estableciendo su valor en null
        JOptionPane.showMessageDialog(null, "Potrero eliminado con éxito");
    } else {
        JOptionPane.showMessageDialog(null, "No se encontró el potrero con el código proporcionado", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    }
