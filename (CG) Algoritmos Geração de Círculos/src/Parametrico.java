
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Parametrico extends JPanel{
    
    @Override
    public void paint(Graphics g) {        
        ParametricoAlgorithm(g, new Point(250, 130), 100);
    }
    
    public static void ParametricoAlgorithm(Graphics g, Point coordinate, int radius) {
        int x, y;
        
        for (int ang = 0; ang < 360; ang++) {
            x = (int) (radius * Math.cos(Math.PI * ang / 180));
            y = (int) (radius * Math.sin(Math.PI * ang / 180));
            
            putPixel(g, x + (int) coordinate.getX(), y + (int) coordinate.getY());
        }
    }
    
    public static void putPixel(Graphics g, int x, int y) {
        g.drawLine(x, y, x, y);
    }
}

class ParametricoWindow extends JFrame {

    public static void main(String[] args) {
        new ParametricoWindow();
    }

    private ParametricoWindow() {
        this.setTitle("Algoritmo de Circulos • Paramétrico");
        this.setSize(500, 300);
        this.add("Center", new Parametrico());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBackground(Color.WHITE);
        
        this.setVisible(true);
    }
}
