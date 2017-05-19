package com.fr.plugin.echarts.common.ui;

import com.fr.design.chart.fun.impl.AbstractIndependentChartUIWithAPILevel;
import com.fr.design.gui.frpane.AttributeChangeListener;
import com.fr.design.mainframe.chart.AbstractChartAttrPane;

/**
 * Created by kk on 2017/5/19.
 */
public abstract class AbstractIndependentEChartsUI extends AbstractIndependentChartUIWithAPILevel {

    private EChartStylePane stylePane;

    @Override
    public int currentAPILevel() {
        return CURRENT_API_LEVEL;
    }

    @Override
    public boolean isUseDefaultPane() {
        return false;
    }

    public AbstractChartAttrPane[] getAttrPaneArray(AttributeChangeListener listener) {
        if (stylePane == null) {
            stylePane = new EChartStylePane(listener);
        }
        return new AbstractChartAttrPane[]{stylePane};
    }
}
