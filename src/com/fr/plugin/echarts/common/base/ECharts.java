package com.fr.plugin.echarts.common.base;

import com.fr.base.chart.BaseChartGlyph;
import com.fr.base.chart.chartdata.ChartData;
import com.fr.chart.chartattr.Chart;
import com.fr.plugin.echarts.common.glyph.EChartsGlyph;
import com.fr.plugin.echarts.common.plot.EChartsPlot;
import com.fr.plugin.echarts.common.theme.EChartsTheme;
import com.fr.plugin.echarts.common.title.EChartsTitle;
import com.fr.plugin.echarts.common.tooltip.EChartsTooltip;
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

    private EChartsTheme theme;
    private EChartsTooltip tooltip;

    public ECharts() {
        this(null);
    }

    public ECharts(EChartsPlot echartPlot) {
        super(echartPlot);
        setWrapperName(WRAPPERNAME);
    }

    public EChartsTheme getTheme() {
        return theme;
    }

    public void setTheme(EChartsTheme theme) {
        this.theme = theme;
    }

    public EChartsTooltip getTooltip() {
        return tooltip;
    }

    public void setTooltip(EChartsTooltip tooltip) {
        this.tooltip = tooltip;
    }

    @Override
    public BaseChartGlyph createGlyph(ChartData chartData) {
        EChartsGlyph glyph = new EChartsGlyph();
        glyph.setGeneralInfo(this);
        setTitle(new EChartsTitle());
    }
}
