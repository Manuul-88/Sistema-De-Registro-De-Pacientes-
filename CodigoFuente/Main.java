/*
 Cárcamo Munguía Erika Audrey, 202334471, cm202334471@alm.buap.mx
 Cerón Reyes Geovanni, 202320421, cr202320421@alm.buap.mx
 Escalona Pérez Jovan Yeray, 202361489, ep202361489@alm.buap.mx
 Silva Madrid Manuel, 202356975, sm202356975@alm.buap.mx
*/
import javax.swing.SwingUtilities;
public class Main {
    public static void main(String[] args) {
        // Lanzamos la ventana en el hilo correcto
        SwingUtilities.invokeLater(() -> {
            AgendaCitasGUI frame = new AgendaCitasGUI();
            frame.setVisible(true); // Mostramos la app
        });
    }
}