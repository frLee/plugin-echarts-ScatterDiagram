package com.fr.plugin.echarts.scatters.scatter;


import com.fr.chart.chartattr.Chart;
import com.fr.plugin.echarts.scatters.common.base.AbstractIndependentEchartScatterProvider;

/**
 * Created by kk on 2017/5/17.
 */
public class EChartScatter extends AbstractIndependentEchartScatterProvider {

    private static final String CHARTNAME = "Plugin-ECharts_Scatter";

    @Override
    public String getChartName() {
        return CHARTNAME;
    }

    @Override
    public Chart[] getChartTypes() {
        return new Chart[0];
    }

    @Override
    public String getChartImagePath() {
        return "com/fr/plugin/echarts/scatters/images/pie256.png";
    }
}
