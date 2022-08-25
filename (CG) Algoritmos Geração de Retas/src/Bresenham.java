import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Bresenham extends JPanel {

    @Override
    public void paint(Graphics g) {        
        BresenhamAlgorithm(g, 10, 10, 470, 10); // 0°
        BresenhamAlgorithm(g, 10, 10, 470, 250);  // 45°
        BresenhamAlgorithm(g, 10, 10, 10, 250); // 90°
    }

    public void BresenhamAlgorithm(Graphics g, int xi, int yi, int xf, int yf) {
        int x = xi, y = yi, d = 0, dx = xf - xi, dy = yf - yi, c, m, incX = 1, incY = 1;

        if (dx < 0) {
            incX = -1;
            dx = -dx;
        }
        if (dy < 0) {
            incY = -1;
            dy = -dy;
        }

        if (dy <= dx) {
            c = 2 * dx;
            m = 2 * dy;
            if (incX < 0) {
                dx++;
            }
            for (;;) {
                this.putPixel(g, x, y);
                if (x == xf) {
                    break;
                }
                x += incX;
                d += m;
                if (d >= dx) {
                    y += incY;
                    d -= c;
                }
            }
        } else {
            c = 2 * dy;
            m = 2 * dx;
            if (incY < 0) {
                dy++;
            }
            for (;;) {
                this.putPixel(g, x, y);
                if (y == yf) {
                    break;
                }
                y += incY;
                d += m;
                if (d >= dy) {
                    x += incX;
                    d -= c;
                }
            }
        }
    }

    public void putPixel(Graphics g, int x, int y) {
        g.drawLine(x, y, x, y);
    }
}

class BresenhamWindow extends JFrame {

    public static void main(String[] args) {
        new BresenhamWindow();
    }

    private BresenhamWindow() {
        this.setTitle("Algoritmo de Linhas • Bresenham");
        this.setSize(500, 300);
        this.add("Center", new Bresenham());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBackground(Color.WHITE);
        
        this.setVisible(true);
    }
}
