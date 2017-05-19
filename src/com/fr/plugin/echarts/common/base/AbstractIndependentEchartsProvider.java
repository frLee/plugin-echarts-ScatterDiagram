package com.fr.plugin.echarts.common.base;

import com.fr.chart.fun.impl.AbstractIndependentChartProviderWithAPILevel;

/**
 * Created by kk on 2017/5/17.
 */
public abstract class AbstractIndependentEchartsProvider extends AbstractIndependentChartProviderWithAPILevel {

    private static final String WRAPPERNAME = "EChartsFactory";

    @Override
    public String[] getRequiredJS() {
        return new String[] {
                "/com/fr/plugin/echarts/scatters/common/web/echarts.bridge.js"
        };
    }

    @Override
    public String getWrapperName() {
        return WRAPPERNAME;
    }

    @Override
    public int currentAPILevel() {
        return CURRENT_API_LEVEL;
    }
}
