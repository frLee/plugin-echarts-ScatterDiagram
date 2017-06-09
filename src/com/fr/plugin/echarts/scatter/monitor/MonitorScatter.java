package com.fr.plugin.echarts.scatter.monitor;

import com.fr.general.Inter;
import com.fr.stable.fun.FunctionHelper;
import com.fr.stable.fun.impl.AbstractFunctionProcessor;

/**
 * Created by kk on 2017/5/26.
 */
public class MonitorScatter extends AbstractFunctionProcessor {
    
    private static MonitorScatter instance = new MonitorScatter();
    
    public static MonitorScatter getInstance() {
        return instance;
    }

    @Override
    public int getId() {
        return FunctionHelper.generateFunctionID("com.fr.plugin.echarts.scatter");
    }

    @Override
    public String toString() {
        return Inter.getLocText("Plugin-ECharts_Scatter");
    }

    @Override
    public String getLocaleKey() {
        return "Plugin-ECharts_Scatter";
    }
}
