package com.fr.plugin.echarts.scatter;


import com.fr.chart.chartattr.Chart;
import com.fr.plugin.echarts.common.base.AbstractIndependentEchartsProvider;
import com.fr.plugin.echarts.common.base.ECharts;
import com.fr.plugin.echarts.scatter.plot.EChartScatterPlot;
import com.fr.plugin.echarts.scatter.plot.ScatterType;

/**
 * Created by kk on 2017/5/17.
 */
public class EChartScatter extends AbstractIndependentEchartsProvider {

    private static final String CHARTNAME = "Plugin-ECharts_Scatter";

    @Override
    public String getChartName() {
        return CHARTNAME;
    }

    @Override
    public Chart[] getChartTypes() {
        return charts;
    }

    @Override
    public String getChartImagePath() {
        return "com/fr/plugin/echarts/scatters/images/pie256.png";
    }

    private static ECharts createScatter(ScatterType type) {
        EChartScatterPlot plot = new EChartScatterPlot(type);
        return new ECharts(plot);
    }

    public static ECharts[] charts = new ECharts[] {
            createScatter(ScatterType.NONE),
            createScatter(ScatterType.AREA),
            createScatter(ScatterType.RADIUS)
    };
}
