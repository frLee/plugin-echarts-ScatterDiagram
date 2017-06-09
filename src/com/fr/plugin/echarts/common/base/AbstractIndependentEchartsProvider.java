package com.fr.plugin.echarts.common.base;

import com.fr.chart.fun.impl.AbstractIndependentChartProviderWithAPILevel;

/**
 * Created by kk on 2017/5/17.
 */
public abstract class AbstractIndependentEchartsProvider extends AbstractIndependentChartProviderWithAPILevel {

    private static final String WRAPPERNAME = "EChartsFactory";

    /**
     * 获取js bridge文件地址
     * @return 文件相对路径
     */
    @Override
    public String[] getRequiredJS() {
        return new String[] {
                "/com/fr/plugin/echarts/scatters/common/web/echarts.bridge.js"
        };
    }

    /**
     * JS对象名，该对象一般是一个函数，执行后会在给定的dom中绘制图表
     * @return js对象名
     */
    @Override
    public String getWrapperName() {
        return WRAPPERNAME;
    }

    /**
     * 当前接口的API等级,用于判断是否需要升级插件
     * @return API等级
     */
    @Override
    public int currentAPILevel() {
        return CURRENT_API_LEVEL;
    }
}
