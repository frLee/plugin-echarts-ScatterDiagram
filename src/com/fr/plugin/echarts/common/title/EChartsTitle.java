package com.fr.plugin.echarts.common.title;

import com.fr.chart.chartattr.Title;
import com.fr.chart.chartglyph.TitleGlyph;
import com.fr.plugin.echarts.common.glyph.EChartsTitleGlyph;
import com.fr.stable.xml.XMLPrintWriter;
import com.fr.stable.xml.XMLableReader;

/**
 * Created by kk on 2017/5/19.
 */
public class EChartsTitle extends Title {

    private static final String XML_TAG = "EChartsTitle";

    @Override
    public EChartsTitleGlyph createGlyph() {
        return super.createGlyph();
    }

    @Override
    public void readXML(XMLableReader reader) {
        super.readXML(reader);
    }

    @Override
    public void writeXML(XMLPrintWriter writer) {
        super.writeXML(writer);
    }
}
