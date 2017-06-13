package com.fr.plugin.echarts.common.ui;

import com.fr.design.dialog.BasicScrollPane;
import com.fr.design.gui.icombobox.UIDictionaryComboBox;
import com.fr.design.gui.ilable.UILabel;
import com.fr.design.layout.TableLayout;
import com.fr.design.layout.TableLayoutHelper;
import com.fr.general.Inter;
import com.fr.plugin.echarts.common.base.ECharts;
import com.fr.plugin.echarts.common.theme.EChartsTheme;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kk on 2017/5/22.
 */
public class EChartsThemePane extends BasicScrollPane<ECharts> {

    private UIDictionaryComboBox<String> themeComboBox;

    public EChartsThemePane(EChartStylePane stylePane) {
    }

    /**
     * 更新主题
     * @param ob
     */
    @Override
    public void populateBean(ECharts ob) {
        if (ob == null) {
            return;
        }
        EChartsTheme theme = ob.getTheme();
        if (theme != null) {
            themeComboBox.setSelectedItem(theme.getThemeName());
        }
    }

    /**
     * 更新主题
     * @param ob
     */
    @Override
    public void updateBean(ECharts ob) {
        if (ob == null) {
            ob = new ECharts();
        }
        EChartsTheme theme = new EChartsTheme();
        theme.setThemeName(themeComboBox.getSelectedItem());
        ob.setTheme(theme);
    }

    /**
     * 创建设计器内面板
     * @return
     */
    @Override
    protected JPanel createContentPane() {
        JPanel jPanel = new JPanel(new BorderLayout());
        double p = TableLayout.PREFERRED;
        double f = TableLayout.FILL;
        double[] rowSize = {p};
        double[] clolumnSize = {p, f};

        UILabel titleLabel = new UILabel(Inter.getLocText("Plugin-ECharts_Theme_Select"));
        themeComboBox = new UIDictionaryComboBox<String>(
                new String[]{"default", "dark"},
                new String[]{"默认", "暗黑"}
        );
        JPanel center = TableLayoutHelper.createTableLayoutPane(new Component[][] {
                {titleLabel, themeComboBox}
        }, rowSize, clolumnSize);
        jPanel.add(center, BorderLayout.CENTER);
        return jPanel;
    }

    /**
     * title显示内容
     * @return
     */
    @Override
    protected String title4PopupWindow() {
        return Inter.getLocText("Plugin-ECharts_Theme");
    }
}
