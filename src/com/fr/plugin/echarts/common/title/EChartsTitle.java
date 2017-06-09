package com.fr.plugin.echarts.common.title;

import com.fr.base.Formula;
import com.fr.base.Utils;
import com.fr.chart.chartattr.Title;
import com.fr.general.GeneralUtils;
import com.fr.plugin.echarts.common.glyph.EChartsTitleGlyph;
import com.fr.stable.xml.XMLPrintWriter;
import com.fr.stable.xml.XMLableReader;

/**
 * Created by kk on 2017/5/19.
 */
public class EChartsTitle extends Title {

    public static final String XML_TAG = "EChartsTitle";
    private static final String ATTR4ECHARTS = "Attr4ECharts";

    /**
     * 将标题属性转为标题图形
     * @return 标题图形
     */
    @Override
    public EChartsTitleGlyph createGlyph() {
        Object title = getTextObject();
        String text4Glyph = null;
        if (title instanceof Formula) {
            Formula formula = (Formula) title;
            if (formula.getResult() != null) {
                text4Glyph = Utils.objectToString(formula.getResult());
            }
        } else {
            text4Glyph = GeneralUtils.objectToString(title);
        }
        EChartsTitleGlyph titleGlyph = new EChartsTitleGlyph(text4Glyph);
        titleGlyph.setVisible(isTitleVisible());
        return titleGlyph;
    }

    /**
     *读取图表Attr属性
     * @param reader XML读取器
     */
    @Override
    public void readXML(XMLableReader reader) {
        super.readXML(reader);
        if (reader.isChildNode()) {
            String name = reader.getTagName();
            if (ATTR4ECHARTS.equals(name)) {
            }
        }
    }

    /**
     * 将图表Attr属性写入XML标签
     * @param writer XML属性输出
     */
    @Override
    public void writeXML(XMLPrintWriter writer) {
        writer.startTAG(XML_TAG);
        super.writeXML(writer);
        writer.startTAG(ATTR4ECHARTS).end();
        writer.end();
    }
}
