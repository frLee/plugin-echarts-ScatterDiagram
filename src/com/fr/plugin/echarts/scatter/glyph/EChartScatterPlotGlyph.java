package com.fr.plugin.echarts.scatter.glyph;

import com.fr.json.JSONArray;
import com.fr.json.JSONException;
import com.fr.plugin.echarts.common.glyph.EChartsPlotGlyph;
import com.fr.plugin.echarts.scatter.plot.ScatterType;
import com.fr.stable.web.Repository;

/**
 * Created by kk on 2017/5/26.
 */
public class EChartScatterPlotGlyph extends EChartsPlotGlyph {

    private ScatterType scatterType;

    public EChartScatterPlotGlyph() {
        this(ScatterType.NONE);
    }

    public EChartScatterPlotGlyph(ScatterType scatterType) {
        this.scatterType = scatterType;
    }

    @Override
    public String getPlotGlyphType() {
        return null;
    }

    @Override
    public String getChartType() {
        return null;
    }

    @Override
    public JSONArray toSeriesData(Repository repo) throws JSONException {
        return null;
    }
}
