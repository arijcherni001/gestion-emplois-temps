package emploiDuTemps_java;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HeaderLogo extends JPanel {

    private JLabel isilogoLabel;
    private JLabel manarlogoLabel;
    private JLabel titleLabel;

    public HeaderLogo(String title) {
        setLayout(null);
        setBackground(new Color(255, 255, 234)); 

        initIsiLogo();
        initManarLogo();
        initTitleLabel(title);
    }

    private void initIsiLogo() {
        ImageIcon isiLogoIcon = new ImageIcon("C://Users/Arij/eclipse-workspace/emploiDuTemps_java/isi.png");
        Image isiLogoImage = isiLogoIcon.getImage();
        int isilogoWidth = 100;
        int isilogoHeight = 70;
        Image isiscaledLogoImage = isiLogoImage.getScaledInstance(isilogoWidth, isilogoHeight, Image.SCALE_SMOOTH);
        ImageIcon isiscaledLogoIcon = new ImageIcon(isiscaledLogoImage);
        isilogoLabel = new JLabel(isiscaledLogoIcon);
        int isilogoX = 20; 
        int isilogoY = 20;
        isilogoLabel.setBounds(isilogoX, isilogoY, isilogoWidth, isilogoHeight);
        add(isilogoLabel);
    }

    private void initManarLogo() {
        ImageIcon manarLogoIcon = new ImageIcon("C://Users/Arij/eclipse-workspace/emploiDuTemps_java/manar.png");
        Image manarLogoImage = manarLogoIcon.getImage();
        int manarlogoWidth = 90;
        int manarlogoHeight = 70;
        Image manarscaledLogoImage = manarLogoImage.getScaledInstance(manarlogoWidth, manarlogoHeight, Image.SCALE_SMOOTH);
        ImageIcon manarscaledLogoIcon = new ImageIcon(manarscaledLogoImage);
        manarlogoLabel = new JLabel(manarscaledLogoIcon);
        int manarlogoX = 900 - manarlogoWidth - 20; 
        int manarlogoY = 20;
        manarlogoLabel.setBounds(manarlogoX, manarlogoY, manarlogoWidth, manarlogoHeight);
        add(manarlogoLabel);
    }
    private void initTitleLabel(String title) {
        titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 28)); 
        titleLabel.setForeground(new Color(251, 118, 28)); 
        titleLabel.setBounds(160, 30, 600, 50); 
        titleLabel.setHorizontalAlignment(JLabel.CENTER); 
        add(titleLabel);
    }
}

