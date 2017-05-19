package com.fr.plugin.echarts.common.glyph;

import com.fr.chart.chartglyph.TitleGlyph;
import com.fr.json.JSONException;
import com.fr.json.JSONObject;
import com.fr.stable.web.Repository;

/**
 * Created by kk on 2017/5/19.
 */
public class EChartsTitleGlyph extends TitleGlyph {

    public EChartsTitleGlyph(String title) {
        setText(title);
    }

    @Override
    public JSONObject toJSONObject(Repository repo) throws JSONException {
        return createTitle(repo);
    }

    private JSONObject createTitle(Repository repo) throws JSONException {
        JSONObject t = JSONObject.create()
                .put("text", getText())
                .put("x", "center");
        t.put("show", isVisible());
        return t;
    }
}
