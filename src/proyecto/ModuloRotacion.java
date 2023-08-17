package proyecto;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;


public class ModuloRotacion {
    private Timer timer;
    private Finca finca;

    public ModuloRotacion(Finca finca) {
        this.finca = finca;
    }
  public void activarAlarmaRotacion(int intervaloMinutos) {
    if (timer != null) {
        timer.cancel();
    }

    timer = new Timer();
    timer.schedule(new TimerTask() {
        @Override
        public void run() {
            mostrarMensajeAlarma();
        }
    }, 0, intervaloMinutos * 60 * 1000); // Convierte los minutos a milisegundos
}

private void mostrarMensajeAlarma() {
  JOptionPane.showMessageDialog(null, "Alarma rota tu ganado " );
    
    
}
    public void rotarGanado() {
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();

        for (Potrero potrero : finca.getPotreros()) {
            try {
                Date fechaEntrada = sdf.parse(potrero.getFechaEntrada());
                calendar.setTime(fechaEntrada);
                calendar.add(Calendar.DAY_OF_YEAR, 5);
                Date fechaSalida = calendar.getTime();

                if (today.after(fechaSalida)) {
                    // Si el ganado ha estado en el potrero más de 5 días, lo rotamos
                    potrero.setEstado("En descanso");
                    potrero.setFechaSalida(sdf.format(today));

                    calendar.add(Calendar.DAY_OF_YEAR, 10); // Agregar 10 días para el descanso
                    potrero.setFechaEntrada(sdf.format(calendar.getTime()));
                    potrero.setCantidadAnimales(0);
                }
            } catch (Exception e) {
                System.out.println("Error al rotar el ganado: " + e.getMessage());
            }
        }
    }

    public void mostrarPotrerosEnDescanso() {
        System.out.println("Potreros en descanso:");
        for (Potrero potrero : finca.getPotreros()) {
            if ("En descanso".equals(potrero.getEstado())) {
                System.out.println(potrero.toString());
            }
        }
    }
}
