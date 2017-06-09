package com.fr.plugin.echarts.common.data;

import com.fr.chart.chartdata.NormalChartData;

/**
 * Created by kk on 2017/5/24.
 */
public class EChartsNormalChartData extends NormalChartData {

    public EChartsNormalChartData() {

    }

    public EChartsNormalChartData(Object[] category_array, Object[] series_array, Object[][] series_value_2D) {
        super(category_array, series_array, series_value_2D);
    }

    /**
     * 处理大数据.1000分类.
     * 不做任何处理
     */
    public void dealHugeData() {
    }
}
