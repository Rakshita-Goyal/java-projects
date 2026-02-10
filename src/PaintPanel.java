import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

class PaintPanels extends JPanel {

    private ArrayList<Point> points = new ArrayList<>();
    private ArrayList<Color> colors = new ArrayList<>();
    private Color currentColor = Color.BLACK;

    public PaintPanels() {
        setBackground(Color.WHITE);

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                points.add(e.getPoint());
                colors.add(currentColor);
                repaint();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                points.add(e.getPoint());
                colors.add(currentColor);
                repaint();
            }
        });
    }

    public void setCurrentColor(Color color) {
        currentColor = color;
    }

    public void clearCanvas() {
        points.clear();
        colors.clear();
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < points.size(); i++) {
            g.setColor(colors.get(i));
            Point p = points.get(i);
            g.fillOval(p.x, p.y, 6, 6);
        }
    }
}
public class PaintPanel {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mini Paint App");
        PaintPanels paintPanel = new PaintPanels();

        JButton blackBtn = new JButton("Black");
        JButton redBtn = new JButton("Red");
        JButton blueBtn = new JButton("Blue");
        JButton clearBtn = new JButton("Clear");

        blackBtn.addActionListener(e -> paintPanel.setCurrentColor(Color.BLACK));
        redBtn.addActionListener(e -> paintPanel.setCurrentColor(Color.RED));
        blueBtn.addActionListener(e -> paintPanel.setCurrentColor(Color.BLUE));
        clearBtn.addActionListener(e -> paintPanel.clearCanvas());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(blackBtn);
        buttonPanel.add(redBtn);
        buttonPanel.add(blueBtn);
        buttonPanel.add(clearBtn);

        frame.setLayout(new BorderLayout());
        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(paintPanel, BorderLayout.CENTER);

        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}