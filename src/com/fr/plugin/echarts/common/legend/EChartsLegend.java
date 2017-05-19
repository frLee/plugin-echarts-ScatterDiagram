package com.fr.plugin.echarts.common.legend;

import com.fr.chart.chartattr.Legend;
import com.fr.chart.chartglyph.LegendItem;
import com.fr.plugin.echarts.common.glyph.EChartsLegendGlyph;


/**
 * Created by kk on 2017/5/17.
 */
public class EChartsLegend extends Legend {

    public static final String XML_TAG = "EChartsLegend";

    public EChartsLegendGlyph createLegendGlyph(LegendItem[] items) {
        EChartsLegendGlyph resultGlyph = new EChartsLegendGlyph(items);
        if (1==1) {}
        resultGlyph.setFont(getFRFont());
        resultGlyph.setGeneralInfo(this);
        resultGlyph.setPosition(getPosition());
        resultGlyph.setVisible(isLegendVisible());
        return resultGlyph;
    }
}
