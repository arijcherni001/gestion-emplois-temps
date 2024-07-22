package emploiDuTemps_java;


import java.awt.Color;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class StyleComboBox extends JLabel implements ListCellRenderer<Object> {
    private Color backgroundColor;

    public StyleComboBox(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
            boolean cellHasFocus) {
        setText(value.toString());
        setBackground(isSelected ? list.getSelectionBackground() : backgroundColor);
        setForeground(isSelected ? list.getSelectionForeground() : list.getForeground());
        return this;
    }
}
