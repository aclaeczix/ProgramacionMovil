import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Fred extends JFrame {

    JButton[] casillas = new JButton[4];
    int[] secuencia = new int[5];
    Random random = new Random();

    Color[] colores = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW};

    public Fred() {
        setTitle("Fred20");
        setDefaultCloseOperation(3);
        setSize(300, 300);
        setLayout(new GridLayout(2, 2));

        for (int i = 0; i < 4; i++) {
            casillas[i] = new JButton();
            casillas[i].setBackground(Color.LIGHT_GRAY);

            int index = i; // importante para lambda

            casillas[i].addActionListener(e -> {
                casillas[index].setBackground(colores[index]);

                // regresar a gris después de un tiempo
                new Thread(() -> {
                    try {
                        Thread.sleep(300);
                        casillas[index].setBackground(Color.LIGHT_GRAY);
                    } catch (Exception ex) {}
                }).start();
            });

            add(casillas[i]);
        }

        generarSecuencia();
        mostrarSecuencia();
    }

    public void generarSecuencia() {
        for (int i = 0; i < secuencia.length; i++) {
            secuencia[i] = random.nextInt(4);
        }
    }

    public void mostrarSecuencia() {
        Thread hilo = new Thread(() -> {
            try {
                for (int i = 0; i < secuencia.length; i++) {
                    int indice = secuencia[i];
                    casillas[indice].setBackground(colores[indice]);
                    Thread.sleep(1000);
                    casillas[indice].setBackground(Color.LIGHT_GRAY);
                    Thread.sleep(500);
                }
            } catch (Exception e) {}
        });
        hilo.start();
    }

    public static void main(String[] args) {
        Fred f = new Fred();
        f.setVisible(true);
    }
}
