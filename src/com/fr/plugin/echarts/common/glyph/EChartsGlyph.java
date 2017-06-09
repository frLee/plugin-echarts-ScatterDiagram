package com.fr.plugin.echarts.common.glyph;

import com.fr.chart.chartglyph.ChartGlyph;
import com.fr.json.JSONException;
import com.fr.json.JSONObject;
import com.fr.plugin.echarts.common.theme.EChartsTheme;
import com.fr.plugin.echarts.common.tooltip.EChartsTooltip;
import com.fr.stable.web.Repository;

/**
 * Created by kk on 2017/5/19.
 */
public class EChartsGlyph extends ChartGlyph {

    private static final String TITLE = "title";
    private static final String LEGEND = "legend";
    private static final String SERIES = "series";
    private static final String THEME = "theme";
    private static final String TOOLTIP = "tooltip";

    private EChartsTheme theme;
    private EChartsTooltip tooltip;

    public void setTheme(EChartsTheme theme) {
        this.theme = theme;
    }

    public void setTooltip(EChartsTooltip tooltip) {
        this.tooltip = tooltip;
    }

    /**
     * 将Glyph内容以JSONObject写入
     * @param repo 请求.
     * @return JSONObject
     * @throws JSONException
     */
    @Override
    public JSONObject toJSONObject(Repository repo) throws JSONException {
        JSONObject jo = new JSONObject();
        EChartsTitleGlyph titleGlyph = (EChartsTitleGlyph) getTitleGlyph();
        if (titleGlyph != null) {
            jo.put(TITLE, titleGlyph.toJSONObject(repo));
        }
        EChartsLegendGlyph legendGlyph = (EChartsLegendGlyph) getLegendGlyph();
        if (legendGlyph != null) {
            jo.put(LEGEND, legendGlyph.toJSONObject(repo));
        }
        EChartsPlotGlyph plotGlyph = (EChartsPlotGlyph) getPlotGlyph();
        if (plotGlyph != null) {
            jo.put(SERIES, plotGlyph.toSeriesData(repo));
        }
        if (theme != null) {
            jo.put(THEME, theme.getThemeName());
        }
        if (tooltip != null) {
            jo.put(TOOLTIP, tooltip.toJSONObject(repo));
        }
        return jo;
    }
}
