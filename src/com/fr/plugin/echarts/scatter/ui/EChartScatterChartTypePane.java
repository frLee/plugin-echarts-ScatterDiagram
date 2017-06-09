package com.fr.plugin.echarts.scatter.ui;

import com.fr.chart.chartattr.Chart;
import com.fr.chart.chartattr.Plot;
import com.fr.design.mainframe.chart.gui.type.ChartImagePane;
import com.fr.general.Inter;
import com.fr.plugin.echarts.common.base.ECharts;
import com.fr.plugin.echarts.common.ui.AbstractEChartsTypePane;
import com.fr.plugin.echarts.scatter.plot.EChartScatterPlot;

/**
 * Created by kk on 2017/5/26.
 */
public class EChartScatterChartTypePane extends AbstractEChartsTypePane {

    @Override
    public boolean accept(Object obj) {
        return (obj instanceof ECharts) && ((ECharts) obj).getPlot().accept(EChartScatterPlot.class);
    }

    @Override
    public String title4PopupWindow() {
        return Inter.getLocText("Plugin-ECharts_Scatter");
    }

    @Override
    protected String[] getTypeTipName() {
        return getNamesOfTypes();
    }

    @Override
    protected String[] getTypeLayoutTipName() {
        return getNamesOfTypes();
    }

    @Override
    public void populateBean(Chart chart) {
        for (ChartImagePane imagePane : typeDemo) {
            imagePane.isPressing = false;
        }
        Plot plot = chart.getPlot();
        if (plot instanceof EChartScatterPlot) {
        }
    }

    @Override
    protected String getPlotTypeID() {
        return null;
    }

    @Override
    public Chart getDefaultChart() {
        return super.getDefaultChart();
    }
}
