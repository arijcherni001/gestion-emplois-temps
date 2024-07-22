package emploiDuTemps_java;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class StyleCellTable extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        c.setBackground(row % 2 == 0 ? new Color(251,239,197) : Color.WHITE);
        return c;
    }
}
