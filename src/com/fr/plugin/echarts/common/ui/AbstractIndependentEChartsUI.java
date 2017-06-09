package com.fr.plugin.echarts.common.ui;

import com.fr.design.chart.fun.impl.AbstractIndependentChartUIWithAPILevel;
import com.fr.design.gui.frpane.AttributeChangeListener;
import com.fr.design.mainframe.chart.AbstractChartAttrPane;

/**
 * Created by kk on 2017/5/19.
 */
public abstract class AbstractIndependentEChartsUI extends AbstractIndependentChartUIWithAPILevel {

    private EChartStylePane stylePane;

    /**
     * 当前接口的API等级,用于判断是否需要升级插件
     * @return API等级
     */
    @Override
    public int currentAPILevel() {
        return CURRENT_API_LEVEL;
    }

    /**
     * 是否使用默认的界面，为了避免界面来回切换
     * @return 不显示默认界面
     */
    @Override
    public boolean isUseDefaultPane() {
        return false;
    }

    /**
     * 图表的属性界面数组
     * @param listener
     * @return 属性界面
     */
    public AbstractChartAttrPane[] getAttrPaneArray(AttributeChangeListener listener) {
        if (stylePane == null) {
            stylePane = new EChartStylePane(listener);
        }
        return new AbstractChartAttrPane[]{stylePane};
    }
}
