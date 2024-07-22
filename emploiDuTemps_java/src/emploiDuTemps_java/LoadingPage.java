package emploiDuTemps_java;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
public class LoadingPage {
    public LoadingPage() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Emploi du temps");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new LoadingPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                Timer timer = new Timer(6000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose(); 
                        Interface1 cr=new Interface1();
                		cr.setVisible(true);                    }
                });
                timer.setRepeats(false);  
                timer.start();
            }
        });
    }

    public class LoadingPane extends JPanel {

        private JLabel welcomeLabel;
        private JLabel logoLabel;
        private JLabel isilogoLabel;
        private JLabel manarlogoLabel;
        
        public LoadingPane() {
            setLayout(null);
            setBackground(new Color(255, 255, 234));

            ImageIcon logoIcon = new ImageIcon("C://Users/Arij/eclipse-workspace/emploiDuTemps_java/logo.png");
            Image logoImage = logoIcon.getImage();
            int logoWidth = 380;
            int logoHeight = 300;
            Image scaledLogoImage = logoImage.getScaledInstance(logoWidth, logoHeight, Image.SCALE_SMOOTH);
            ImageIcon scaledLogoIcon = new ImageIcon(scaledLogoImage);

            // Logo (Middle)
            logoLabel = new JLabel(scaledLogoIcon);
            int logoX = (900 - logoWidth) / 2;
            int logoY = (550 - logoHeight) / 2 - 50;
            logoLabel.setBounds(logoX, logoY+20, logoWidth, logoHeight);
            add(logoLabel);

            HeaderLogo headerLogo = new HeaderLogo("Bienvenue sur l'emploi du temps d'ISI Ariana");
            headerLogo.setBounds(0, 0, 900, 550); 
            add(headerLogo);
                   

            // Bubble Spinner
            BubblePanel bubblePanel = new BubblePanel();
            bubblePanel.setBounds((900 - 100) / 2, logoY + logoHeight + 10, 70, 70); 
            add(bubblePanel);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(900, 550);
        }
    }

    public class BubblePanel extends JPanel implements ActionListener {
        private static final int BUBBLE_COUNT = 8;
        private static final int BUBBLE_SIZE = 15;
        private static final int ANIMATION_DELAY = 100;
        private int[] bubbleOffsets = new int[BUBBLE_COUNT];
        private int[] bubbleAlphas = new int[BUBBLE_COUNT];
        private Timer timer;
        private Color[] bubbleColors = {
            new Color(139, 69, 19), new Color(160, 82, 45), new Color(205, 133, 63),
            new Color(222, 184, 135), new Color(245, 222, 179), new Color(210, 180, 140),
            new Color(188, 143, 143), new Color(244, 164, 96)
        };

        public BubblePanel() {
            setPreferredSize(new Dimension(100, 100));
            setBackground(new Color(255, 255, 234));

            timer = new Timer(ANIMATION_DELAY, this);
            timer.start();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int width = getWidth();
            int height = getHeight();
            int centerX = width / 2;
            int centerY = height / 2;

            for (int i = 0; i < BUBBLE_COUNT; i++) {
                double angle = Math.toRadians((360 / BUBBLE_COUNT) * i + bubbleOffsets[i]);
                int x = centerX + (int) (Math.cos(angle) * (width / 3));
                int y = centerY + (int) (Math.sin(angle) * (height / 3));

                g2d.setColor(new Color(bubbleColors[i].getRed(), bubbleColors[i].getGreen(), bubbleColors[i].getBlue(), bubbleAlphas[i]));
                g2d.fillOval(x - BUBBLE_SIZE / 2, y - BUBBLE_SIZE / 2, BUBBLE_SIZE, BUBBLE_SIZE);
            }

            g2d.dispose();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < BUBBLE_COUNT; i++) {
                bubbleOffsets[i] = (bubbleOffsets[i] + 5) % 360;
                bubbleAlphas[i] = (int) (128 + 127 * Math.sin(Math.toRadians(bubbleOffsets[i])));
            }
            repaint();
        }
    }

    public static void main(String[] args) {
        new LoadingPage();
    }
}
