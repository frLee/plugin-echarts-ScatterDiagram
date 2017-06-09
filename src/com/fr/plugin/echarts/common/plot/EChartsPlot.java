package com.fr.plugin.echarts.common.plot;

import com.fr.chart.chartattr.Legend;
import com.fr.chart.chartattr.Plot;
import com.fr.chart.chartglyph.PlotGlyph;
import com.fr.general.ComparatorUtils;
import com.fr.plugin.echarts.common.glyph.EChartsLegendGlyph;
import com.fr.plugin.echarts.common.legend.EChartsLegend;
import com.fr.stable.xml.XMLableReader;

/**
 * Created by kk on 2017/5/17.
 */
public abstract class EChartsPlot extends Plot {

    public EChartsPlot() {
        setLegend(new EChartsLegend());
    }

    public boolean accept(Class<? extends Plot> obClass) {
        return ComparatorUtils.equals(EChartsPlot.class, obClass);
    }

    /**
     * 读取XML中Plot内容
     * @param reader XML读取对象
     */
    protected void readPlotXML(XMLableReader reader) {
        if (reader.isChildNode()) {
            String tagName = reader.getTagName();
            if (EChartsLegend.XML_TAG.equals(tagName)) {
                setLegend((Legend) reader.readXMLObject(new EChartsLegend()));
            }
        }
    }

    /**
     * 创建图例
     * @param plotGlyph  绘图区
     * @return 图例Glyph
     */
    @Override
    public EChartsLegendGlyph createLegendGlyph(PlotGlyph plotGlyph) {
        EChartsLegend legend = (EChartsLegend) getLegend();
        if (legend == null) {
            legend = new EChartsLegend();
            setLegend(legend);
        }
        return legend.createLegendGlyph(createLegendItems(plotGlyph));
    }
}
