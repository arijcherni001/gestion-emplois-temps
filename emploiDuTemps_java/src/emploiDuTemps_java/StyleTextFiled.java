package emploiDuTemps_java;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.AbstractBorder;

public class StyleTextFiled extends AbstractBorder implements FocusListener {
	   private final int radius;
	    private final Color borderColor;
	    private final Color focusedColor;
	    
	public StyleTextFiled(int radius) {
        this.radius = radius;
        this.borderColor = new Color(192,192,192);
        this.focusedColor = new Color(255,228,181);
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        super.paintBorder(c, g, x, y, width, height);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(borderColor);
        g2d.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        g2d.dispose();
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(radius + 1, radius + 1, radius + 1, radius + 1);
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        insets.left = insets.top = insets.right = insets.bottom = radius + 1;
        return insets;
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getComponent() instanceof JTextField) {
            JTextField textField = (JTextField) e.getComponent();
            textField.setBackground(focusedColor);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getComponent() instanceof JTextField) {
            JTextField textField = (JTextField) e.getComponent();
            textField.setBackground(Color.WHITE); // Reset to default background color
        }
    }
}
