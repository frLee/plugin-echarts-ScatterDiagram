package com.fr.plugin.echarts.scatters.common.base;

import com.fr.chart.chartattr.Chart;
import com.fr.plugin.echarts.scatters.common.plot.EChartsScatterPlot;
import com.fr.stable.fun.FunctionHelper;
import com.fr.stable.fun.FunctionProcessor;
import com.fr.stable.fun.impl.AbstractFunctionProcessor;

/**
 * Created by kk on 2017/5/17.
 */
public class ECharts extends Chart {

    private static final String WRAPPERNAME = "EChartsFactory";

    private static final FunctionProcessor P = new AbstractFunctionProcessor() {
        @Override
        public int getId() {
            return FunctionHelper.generateFunctionID("com.fr.plugin.echarts.scatters");
        }

        @Override
        public String getLocaleKey() {
            return "EChartScatters";
        }
    };

    public ECharts() {
    }

    public ECharts(EChartsScatterPlot scatterPlot) {
        super(scatterPlot);
        setWrapperName(WRAPPERNAME);
        setTitle();
        setTooltip();
    }

}
