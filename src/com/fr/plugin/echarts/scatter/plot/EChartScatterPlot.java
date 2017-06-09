package com.fr.plugin.echarts.scatter.plot;

import com.fr.base.chart.chartdata.ChartData;
import com.fr.chart.chartattr.Plot;
import com.fr.chart.chartdata.NormalChartData;
import com.fr.chart.chartglyph.PlotGlyph;
import com.fr.plugin.echarts.common.plot.EChartsPlot;
import com.fr.plugin.echarts.scatter.glyph.EChartScatterPlotGlyph;
import com.fr.plugin.echarts.scatter.monitor.MonitorScatter;
import com.fr.stable.fun.FunctionProcessor;

/**
 * Created by kk on 2017/5/19.
 */
public class EChartScatterPlot extends EChartsPlot {

    public static final String PLOT_ID = "EChartScatterPlot";

    private ScatterType scatterType;

    public ScatterType getScatterType() {
        return scatterType;
    }

    public EChartScatterPlot() {
        this(ScatterType.NONE);
    }

    public EChartScatterPlot(ScatterType scatterType) {
        this.scatterType = scatterType;
    }

    @Override
    public PlotGlyph createPlotGlyph(ChartData chartData) {
        PlotGlyph glyph = new EChartScatterPlotGlyph(scatterType);
        install4PlotGlyph(glyph, chartData);
        return glyph;
    }

    @Override
    public String getPlotID() {
        return PLOT_ID;
    }

    @Override
    public boolean matchPlotType(Plot newPlot) {
        return newPlot instanceof EChartScatterPlot;
    }

    @Override
    public ChartData defaultChartData() {
        return new NormalChartData();
    }

    @Override
    public FunctionProcessor getFunctionToRecord() {
        return MonitorScatter.getInstance();
    }


}
