import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Analitico extends JPanel {

    @Override
    public void paint(Graphics g) {        
        AnaliticAlgorithm(g, 10, 10, 470, 10); // 0°
        AnaliticAlgorithm(g, 10, 10, 470, 250);  // 45°
        AnaliticAlgorithm(g, 10, 10, 10, 470); // 90°
    }

    public void AnaliticAlgorithm(Graphics g, int xi, int yi, int xf, int yf) {
        float m, b, dy, dx;

        dy = yf - yi;
        dx = xf - xi;

        m = (float) dy / dx;

        b = (float) (yi - m * xi);

        for (int x = xi; x <= xf; x++) {
            int y = (int) (m * x + b);
            this.putPixel(g, x, y);
        }
    }

    public void putPixel(Graphics g, int x, int y) {
        g.drawLine(x, y, x, y);
    }
}

class AnaliticoWindow extends JFrame {

    public static void main(String[] args) {
        new AnaliticoWindow();
    }

    private AnaliticoWindow() {
        this.setTitle("Algoritmo de Linhas • Analítico");
        this.setSize(500, 300);
        this.add("Center", new Analitico());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBackground(Color.WHITE);
        
        this.setVisible(true);
    }
}
