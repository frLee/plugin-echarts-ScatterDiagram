package com.fr.plugin.echarts.common.data;

import com.fr.chart.chartdata.NormalChartData;
import com.fr.chart.chartdata.NormalReportDataDefinition;

/**
 * Created by kk on 2017/5/24.
 */
public class EChartsNormalReportDataDefinition extends NormalReportDataDefinition {

    private static final long serialVersionUID = -645098535257304519L;

    protected NormalChartData getNormalDataObject() {
        return new EChartsNormalChartData();
    }

}
