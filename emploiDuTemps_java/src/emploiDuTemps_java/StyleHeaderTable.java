package emploiDuTemps_java;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class StyleHeaderTable extends JLabel implements TableCellRenderer {
    public StyleHeaderTable() {
        setOpaque(true);
        setForeground(Color.WHITE);
        setBackground(new Color(221, 118, 28));  
        setFont(new Font("Arial", Font.BOLD, 13)); 
        int headerHeight = 28;
        setPreferredSize(new Dimension(getPreferredSize().width, headerHeight));
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText(value.toString());
        return this;
    }
}
