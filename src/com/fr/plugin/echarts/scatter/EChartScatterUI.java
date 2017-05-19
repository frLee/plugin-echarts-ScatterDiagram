package com.fr.plugin.echarts.scatter;

import com.fr.chart.chartattr.Plot;
import com.fr.design.mainframe.chart.gui.ChartDataPane;
import com.fr.design.mainframe.chart.gui.data.report.AbstractReportDataContentPane;
import com.fr.design.mainframe.chart.gui.data.table.AbstractTableDataContentPane;
import com.fr.design.mainframe.chart.gui.type.AbstractChartTypePane;
import com.fr.plugin.echarts.common.ui.AbstractIndependentEChartsUI;

/**
 * Created by kk on 2017/5/19.
 */
public class EChartScatterUI extends AbstractIndependentEChartsUI {

    @Override
    public AbstractChartTypePane getPlotTypePane() {
        return null;
    }

    @Override
    public AbstractTableDataContentPane getTableDataSourcePane(Plot plot, ChartDataPane parent) {
        return null;
    }

    @Override
    public AbstractReportDataContentPane getReportDataSourcePane(Plot plot, ChartDataPane parent) {
        return null;
    }

    @Override
    public String getIconPath() {
        return null;
    }
}
