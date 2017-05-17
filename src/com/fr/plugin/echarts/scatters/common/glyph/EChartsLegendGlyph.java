package com.fr.plugin.echarts.scatters.common.glyph;

import com.fr.chart.chartglyph.LegendGlyph;
import com.fr.chart.chartglyph.LegendItem;
import com.fr.json.JSONException;
import com.fr.json.JSONObject;
import com.fr.stable.web.Repository;

/**
 * Created by kk on 2017/5/17.
 */
public class EChartsLegendGlyph extends LegendGlyph {

    public EChartsLegendGlyph(LegendItem[] items) {
        super(items);
    }

    @Override
    public JSONObject toJSONObject(Repository repo) throws JSONException {
        return null;
    }
}
