package com.fr.plugin.echarts.common.ui;

import com.fr.design.dialog.BasicScrollPane;
import com.fr.design.gui.ilable.UILabel;
import com.fr.general.Inter;
import com.fr.plugin.echarts.common.base.ECharts;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kk on 2017/5/22.
 */
public class EChartsLegendPane extends BasicScrollPane<ECharts> {

    public EChartsLegendPane(EChartStylePane parent) {
    }

    /**
     * 创建内容页面
     * @return 图例内容页面
     */
    @Override
    protected JPanel createContentPane() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new UILabel("待开发", SwingConstants.CENTER), BorderLayout.CENTER);
        return panel;
    }

    /**
     * 更新页面内容
     * @param ob
     */
    @Override
    public void populateBean(ECharts ob) {

    }

    /**
     *弹出显示标题
     * @return 图例
     */
    @Override
    protected String title4PopupWindow() {
        return Inter.getLocText("Plugin-ECharts_Legend");
    }
}
