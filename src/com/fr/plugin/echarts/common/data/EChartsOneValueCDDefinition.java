package com.fr.plugin.echarts.common.data;

import com.fr.chart.chartdata.NormalChartData;
import com.fr.chart.chartdata.OneValueCDDefinition;

/**
 * Created by kk on 2017/5/24.
 */
public class EChartsOneValueCDDefinition extends OneValueCDDefinition {

    private static final long serialVersionUID = -7069079313068958054L;

    /**
     * 从数据定义属性生成 图表数据的结果集 复用之前的方法
     * @param series_name_array
     * @param series_v_2D
     * @return 返回图表数据
     */
    protected NormalChartData getNormalChartData(Object[] series_name_array, Object[][] series_v_2D) {
        NormalChartData normal = new EChartsNormalChartData(categoryLabels, series_name_array, series_v_2D);
        normal.setSecondCates(secondLabels);
        normal.setThirdCates(thirdLabels);
        return normal;
    }
}
