package com.fr.plugin.echarts.scatter.glyph;

import com.fr.chart.chartglyph.DataPoint;
import com.fr.chart.chartglyph.DataSeries;
import com.fr.json.JSONArray;
import com.fr.json.JSONException;
import com.fr.json.JSONObject;
import com.fr.plugin.echarts.common.glyph.EChartsPlotGlyph;
import com.fr.plugin.echarts.scatter.plot.ScatterType;
import com.fr.stable.web.Repository;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by kk on 2017/5/26.
 */
public class EChartScatterPlotGlyph extends EChartsPlotGlyph {

    private static final NumberFormat format = new DecimalFormat("##%");
    private static final String ECHARTSCATTERPLOTGLYPH = "EChartScatterPlotGlyph";
    private static final String ECHARTSCATTER = "EchartScatter";
    private static final String TYPE = "type";
    private static final String SCATTER = "scatter";
    private static final String RADIUS = "radius";
    private static final String CENTER = "center";
    private static final String SCATTERTYPE = "scatterType";
    private static final String ITEMSTYLE = "itemStyle";
    private static final String NORMAL = "normal";
    private static final String LABEL = "label";
    private static final String FORMATTER = "formatter";
    private static final String FORMAT_VALUE = "{c}";
    private static final String DATA = "data";
    private static final String NAME = "name";
    private static final String VALUE = "value";

    private ScatterType scatterType;

    public EChartScatterPlotGlyph() {
        this(ScatterType.NONE);
    }

    public EChartScatterPlotGlyph(ScatterType scatterType) {
        this.scatterType = scatterType;
    }

    @Override
    public String getPlotGlyphType() {
        return ECHARTSCATTERPLOTGLYPH;
    }

    @Override
    public String getChartType() {
        return ECHARTSCATTER;
    }

    /**
     * 将图表部分的设置放入JSONArray
     * @param repo
     * @return JSONArray
     * @throws JSONException
     */
    @Override
    public JSONArray toSeriesData(Repository repo) throws JSONException {
        JSONArray result = JSONArray.create();
        int cn = getCategoryCount();
        String r = "100%";
        if (cn > 1) {
            r = format.format(1.0 / (cn + 1));
        }
        for (int c = 0; c < cn; c++) {
            JSONObject wrapper = JSONObject.create();
            result.put(wrapper);
            wrapper.put(TYPE, SCATTER);
            if (cn > 1) {
                wrapper.put(RADIUS, r);
                wrapper.put(CENTER, JSONArray.create().put(format.format(1.0 * c / (cn + 1) + 0.2)).put("55%"));
            }
            wrapper.put(SCATTERTYPE, scatterType.toTypeString());
            wrapper.put(ITEMSTYLE,
                    JSONObject.create().put(NORMAL,
                            JSONObject.create().put(LABEL,
                                    JSONObject.create().put(FORMATTER, FORMAT_VALUE))));
            JSONArray data = JSONArray.create();
            wrapper.put(DATA, data);

            for (int i = 0, len = getSeriesSize(); i < len; i++) {
                DataSeries series = getSeries(i);
                String name = series.getSeriesName();
                JSONObject item = JSONObject.create();
                data.put(item);
                item.put(NAME, name);
                if (series.getDataPointCount() > 0) {
                    DataPoint dataPoint = series.getDataPoint(c);
                    item.put(VALUE, dataPoint.getValue());
                    wrapper.put(NAME, dataPoint.getCategoryName());
                }
            }
        }
        return result;
    }
}
