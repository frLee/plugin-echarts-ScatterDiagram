package com.fr.plugin.echarts.common.glyph;

import com.fr.chart.chartglyph.PlotGlyph;
import com.fr.json.JSONArray;
import com.fr.json.JSONException;
import com.fr.json.JSONObject;
import com.fr.stable.web.Repository;

/**
 * Created by kk on 2017/5/24.
 */
public abstract class EChartsPlotGlyph extends PlotGlyph {

    public abstract JSONArray toSeriesData(Repository repo) throws JSONException;

    @Override
    public void layoutAxisGlyph(int resolution) {

    }

    @Override
    public void layoutDataSeriesGlyph(int resolution) {

    }

    /**
     * 图例部分 暂时没开发
     * @param repo 请求
     * @return
     * @throws JSONException
     */
    @Override
    public JSONObject toJSONObject(Repository repo) throws JSONException {
        throw new UnsupportedOperationException("Not support yet");
    }
}
