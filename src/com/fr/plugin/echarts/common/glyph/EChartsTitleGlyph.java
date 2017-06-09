package com.fr.plugin.echarts.common.glyph;

import com.fr.chart.chartglyph.TitleGlyph;
import com.fr.json.JSONException;
import com.fr.json.JSONObject;
import com.fr.stable.web.Repository;

/**
 * Created by kk on 2017/5/19.
 */
public class EChartsTitleGlyph extends TitleGlyph {

    private static final String TEXT = "text";
    private static final String X = "x";
    private static final String CENTER = "center";
    private static final String SHOW = "show";

    public EChartsTitleGlyph(String title) {
        setText(title);
    }

    @Override
    public JSONObject toJSONObject(Repository repo) throws JSONException {
        return createTitle(repo);
    }

    /**
     * 将TitleGlyph以JSONObject写入
     * @param repo
     * @return JSONObject
     * @throws JSONException
     */
    private JSONObject createTitle(Repository repo) throws JSONException {
        JSONObject t = JSONObject.create()
                .put(TEXT, getText())
                .put(X, CENTER);
        t.put(SHOW, isVisible());
        return t;
    }
}
