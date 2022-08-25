import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class DDA extends JPanel {

    @Override
    public void paint(Graphics g) {        
        DDAAlgorithm(g, 10, 10, 470, 10); // 0°
        DDAAlgorithm(g, 10, 10, 470, 250);  // 45°
        DDAAlgorithm(g, 10, 10, 10, 470); // 90°
    }

    public void DDAAlgorithm(Graphics g, int xi, int yi, int xf, int yf) {
        int steps;
        float x = xi, y = yi, incX, incY;

        int dx = xf - xi;
        int dy = yf - yi;

        if (Math.abs(dx) > Math.abs(dy)) {
            steps = Math.abs(dx);
            incX = 1;
            incY = (float) dy / dx;
        } else {
            steps = Math.abs(dy);
            incY = 1;
            incX = (float) dx / dy;
        }

        for (int i = 0; i < steps; i++) {
            x = x + incX;
            y = y + incY;
            this.putPixel(g, Math.round(x), Math.round(y));
        }
    }

    public void putPixel(Graphics g, int x, int y) {
        g.drawLine(x, y, x, y);
    }
}

class DDAWindow extends JFrame {

    public static void main(String[] args) {
        new DDAWindow();
    }

    private DDAWindow() {
        this.setTitle("Algoritmo de Linhas • DDA");
        this.setSize(500, 300);
        this.add("Center", new DDA());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBackground(Color.WHITE);
        
        this.setVisible(true);
    }
}
