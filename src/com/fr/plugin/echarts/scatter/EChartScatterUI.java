package com.fr.plugin.echarts.scatter;

import com.fr.chart.chartattr.Plot;
import com.fr.design.mainframe.chart.gui.ChartDataPane;
import com.fr.design.mainframe.chart.gui.data.report.AbstractReportDataContentPane;
import com.fr.design.mainframe.chart.gui.data.table.AbstractTableDataContentPane;
import com.fr.design.mainframe.chart.gui.type.AbstractChartTypePane;
import com.fr.plugin.echarts.common.ui.AbstractIndependentEChartsUI;
import com.fr.plugin.echarts.scatter.ui.EChartScatterChartTypePane;
import com.fr.plugin.echarts.scatter.ui.EChartScatterReportDataContentPane;
import com.fr.plugin.echarts.scatter.ui.EChartScatterTableDataContentPane;

/**
 * Created by kk on 2017/5/19.
 */
public class EChartScatterUI extends AbstractIndependentEChartsUI {

    @Override
    public AbstractChartTypePane getPlotTypePane() {
        return new EChartScatterChartTypePane();
    }

    @Override
    public AbstractTableDataContentPane getTableDataSourcePane(Plot plot, ChartDataPane parent) {
        return new EChartScatterTableDataContentPane(parent);
    }

    @Override
    public AbstractReportDataContentPane getReportDataSourcePane(Plot plot, ChartDataPane parent) {
        return new EChartScatterReportDataContentPane(parent);
    }

    @Override
    public String getIconPath() {
        return "com/fr/solution/plugin/chart/echarts/pie/images/pie.png";
    }
}
