package com.fr.plugin.echarts.common.ui;

import com.fr.design.dialog.BasicScrollPane;
import com.fr.design.gui.icombobox.UIDictionaryComboBox;
import com.fr.design.gui.ilable.UILabel;
import com.fr.design.gui.itextfield.UITextField;
import com.fr.design.layout.TableLayout;
import com.fr.design.layout.TableLayoutHelper;
import com.fr.general.Inter;
import com.fr.plugin.echarts.common.base.ECharts;
import com.fr.plugin.echarts.common.tooltip.EChartsTooltip;
import com.fr.plugin.echarts.common.tooltip.TriggerType;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kk on 2017/5/22.
 */
public class EChartsTooltipPane extends BasicScrollPane<ECharts> {

    private static final String LABELTITLE = "触发点";
    private static final String LEGEND = "图例";
    private static final String AXES = "坐标轴";
    private static final String FORMATLABEL = "显示格式";
    private static final int FORMATEXTFIELDCOLUMN = 12;
    private UIDictionaryComboBox<TriggerType> triggerComboBox;
    private UITextField formatTextField;

    public EChartsTooltipPane(EChartStylePane parent) {

    }

    /**
     * 更新combobox和textfield的内容
     * @param ob
     */
    @Override
    public void populateBean(ECharts ob) {
        if (ob == null) {
            return;
        }
        EChartsTooltip tooltip = ob.getTooltip();
        if (tooltip == null) {
            return;
        }
        triggerComboBox.setSelectedItem(tooltip.getTriggerType());
        formatTextField.setText(tooltip.getFormat());
    }

    /**
     * 创建内容pane
     * @return
     */
    @Override
    protected JPanel createContentPane() {
        JPanel panel = new JPanel();
        double p = TableLayout.PREFERRED;
        double f = TableLayout.FILL;
        double[] rowSize = {p, p};
        double[] columnSize = {p, f};
        UILabel titleLabel = new UILabel(LABELTITLE);

        triggerComboBox = new UIDictionaryComboBox<TriggerType>(
                new TriggerType[]{TriggerType.ITEM, TriggerType.AXIS},
                new String[]{LEGEND, AXES}
        );

        UILabel formatLabel = new UILabel(FORMATLABEL);

        formatTextField = new UITextField(FORMATEXTFIELDCOLUMN);

        JPanel center = TableLayoutHelper.createTableLayoutPane(new Component[][] {
                {titleLabel, triggerComboBox},
                {formatLabel, formatTextField}
        },rowSize, columnSize);
        panel.add(center, BorderLayout.CENTER);

        return panel;
    }

    /**
     * 更新tooltip控件
     * @param ob
     */
    @Override
    public void updateBean(ECharts ob) {
        if (ob == null) {
            ob = new ECharts();
        }
        EChartsTooltip tooltip = new EChartsTooltip();
        tooltip.setTriggerType(triggerComboBox.getSelectedItem());
        tooltip.setFormat(formatTextField.getText());
        ob.setTooltip(tooltip);
    }

    /**
     * 弹出框体内容显示
     * @return
     */
    @Override
    protected String title4PopupWindow() {
        return Inter.getLocText("Plugin-ECharts_Tooltip");
    }
}
