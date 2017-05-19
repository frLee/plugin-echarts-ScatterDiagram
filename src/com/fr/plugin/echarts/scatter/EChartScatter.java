package com.fr.plugin.echarts.scatter;


import com.fr.chart.chartattr.Chart;
import com.fr.plugin.echarts.common.base.AbstractIndependentEchartsProvider;

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
        return new Chart[0];
    }

    @Override
    public String getChartImagePath() {
        return "com/fr/plugin/echarts/scatters/images/pie256.png";
    }
}
