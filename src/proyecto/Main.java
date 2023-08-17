package proyecto;
import java.util.Timer;
import java.util.TimerTask;


public class Main {
    public static void main(String[] args) {
      
        // Instanciamos el menú y lo mostramos primero
        Menu menu = new Menu();
        menu.seleccionarModulo();
         Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                iniciarAlarmaRotacion();
                timer.cancel(); // Cancelar el timer después de iniciar la alarma
            }
        }, 2 * 60 * 1000); // Esperar 2 minutos 
    }
    private static void iniciarAlarmaRotacion() {
        ModuloRotacion rotacionInicial = new ModuloRotacion(null);
        int intervaloMinutosInicial = 2; // Intervalo de tiempo para la alarma, Esto lo hacemos de esta forma para simular los 5 dias para asi reducirlo a dos minutos para la hora de la presentacion
        rotacionInicial.activarAlarmaRotacion(intervaloMinutosInicial);
    }
}
