package com.fr.plugin.echarts.common.ui;

import com.fr.chart.chartattr.ChartCollection;
import com.fr.design.event.UIObserver;
import com.fr.design.event.UIObserverListener;
import com.fr.design.gui.frpane.AttributeChangeListener;
import com.fr.design.mainframe.chart.AbstractChartAttrPane;
import com.fr.plugin.echarts.common.base.ECharts;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kk on 2017/5/19.
 */
public class EChartStylePane extends AbstractChartAttrPane implements UIObserver {

    private AttributeChangeListener listener;
    private UIObserverListener uiObserverListener;
    private ECharts chart;

    public EChartStylePane(AttributeChangeListener listener) {
        this.listener = listener;
        this.initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
    }

    protected void initSelfListener(Container parentComponent) {
        for (int i = 0; i < parentComponent.getComponentCount(); i++) {
            Component tmpComp = parentComponent.getComponent(i);
            if (tmpComp instanceof Container) {
                initListener((Container) tmpComp);
            }
            if (tmpComp instanceof UIObserver) {
                ((UIObserver) tmpComp).registerChangeListener(uiObserverListener);
            }
        }
    }

    @Override
    protected JPanel createContentPane() {
        JPanel content = new JPanel(new BorderLayout());
        if (chart == null) {
            return content;
        }
        return content;
    }

    @Override
    public void populate(ChartCollection collection) {
    }

    @Override
    public void update(ChartCollection collection) {
    }
}
