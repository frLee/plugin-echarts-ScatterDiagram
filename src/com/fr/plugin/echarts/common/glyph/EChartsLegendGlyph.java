package com.fr.plugin.echarts.common.glyph;

import com.fr.chart.chartglyph.LegendGlyph;
import com.fr.chart.chartglyph.LegendItem;
import com.fr.json.JSONArray;
import com.fr.json.JSONException;
import com.fr.json.JSONObject;
import com.fr.stable.ArrayUtils;
import com.fr.stable.web.Repository;

/**
 * Created by kk on 2017/5/17.
 */
public class EChartsLegendGlyph extends LegendGlyph {

    private static final String ORIENT = "orient";
    private static final String HORIZONTAL = "horizontal";
    private static final String Y = "y";
    private static final String BOTTOM = "bottom";
    private static final String DATA = "data";
    private static final String LABEL = "label";

    public EChartsLegendGlyph(LegendItem[] items) {
        super(items);
    }

    /**
     * 将LegendGlyph以JSONObject写入
     * @param repo 请求
     * @return JSONObject
     * @throws JSONException
     */
    @Override
    public JSONObject toJSONObject(Repository repo) throws JSONException {
        JSONObject result = JSONObject.create()
                .put(ORIENT, HORIZONTAL)
                .put(Y, BOTTOM);
        LegendItem[] items = getItems();
        if (ArrayUtils.isNotEmpty(items)) {
            JSONArray data = JSONArray.create();
            result.put(DATA, data);
            for (LegendItem item : items) {
                JSONObject jo = item.toJSONObject(repo);
                data.put(jo.optString(LABEL));
            }
        }
        return result;
    }
}
