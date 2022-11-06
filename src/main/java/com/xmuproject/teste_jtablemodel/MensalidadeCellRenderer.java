package com.xmuproject.teste_jtablemodel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * @AUTHOR MURILO TADEU D. TISCHER ON 11/6/2022
 */
public class MensalidadeCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus,
                row, column);

        Object val = table.getValueAt(row, column);
        // verifica se o valor é do tipo esperado
        if (val instanceof BigDecimal) {
            // faz o casting para BigDecimal
            BigDecimal mensalidade = (BigDecimal) val;
            // formata o valor e seta como o texto do renderer
            NumberFormat nf = NumberFormat.getCurrencyInstance();
            setText(mensalidade != null ? nf.format(mensalidade) : "");
        }

        return this;
    }
}
