package com.fr.plugin.echarts.common.base;

import com.fr.base.chart.BaseChartGlyph;
import com.fr.base.chart.chartdata.ChartData;
import com.fr.chart.chartattr.Chart;
import com.fr.chart.chartattr.ChartXMLCompatibleUtils;
import com.fr.chart.chartattr.Plot;
import com.fr.chart.chartdata.TopDefinition;
import com.fr.chart.chartglyph.PlotGlyph;
import com.fr.general.ComparatorUtils;
import com.fr.general.xml.GeneralXMLTools;
import com.fr.plugin.echarts.common.data.EChartsMoreNameCDDefinition;
import com.fr.plugin.echarts.common.data.EChartsNormalReportDataDefinition;
import com.fr.plugin.echarts.common.glyph.EChartsGlyph;
import com.fr.plugin.echarts.common.glyph.EChartsLegendGlyph;
import com.fr.plugin.echarts.common.glyph.EChartsTitleGlyph;
import com.fr.plugin.echarts.common.plot.EChartsPlot;
import com.fr.plugin.echarts.common.theme.EChartsTheme;
import com.fr.plugin.echarts.common.title.EChartsTitle;
import com.fr.plugin.echarts.common.tooltip.EChartsTooltip;
import com.fr.plugin.echarts.common.data.EChartsOneValueCDDefinition;
import com.fr.stable.fun.FunctionHelper;
import com.fr.stable.fun.FunctionProcessor;
import com.fr.stable.fun.impl.AbstractFunctionProcessor;
import com.fr.stable.xml.XMLPrintWriter;
import com.fr.stable.xml.XMLReadable;
import com.fr.stable.xml.XMLableReader;

/**
 * Created by kk on 2017/5/17.
 */
public class ECharts extends Chart {

    private static final String WRAPPERNAME = "EChartsFactory";
    private static final String CHARTATTR = "ChartAttr";
    private static final String ISJSDRAW = "isJSDraw";
    private static final String ISTYLEGLOBAL = "isStyleGlobal";
    private static final String CHARTDEFINITION = "ChartDefinition";

    /**
     * 设置当前插件的唯一ID和国际化文件的key
     */
    private static final FunctionProcessor P = new AbstractFunctionProcessor() {
        @Override
        public int getId() {
            return FunctionHelper.generateFunctionID("com.fr.plugin.echarts.scatters");
        }

        @Override
        public String getLocaleKey() {
            return "ECharts";
        }
    };

    private EChartsTheme theme;
    private EChartsTooltip tooltip;

    public ECharts() {
        this(null);
    }

    public ECharts(EChartsPlot echartPlot) {
        super(echartPlot);
        setWrapperName(WRAPPERNAME);
        setTitle(new EChartsTitle());
        setTooltip(new EChartsTooltip());
    }

    public EChartsTheme getTheme() {
        return theme;
    }

    public void setTheme(EChartsTheme theme) {
        this.theme = theme;
    }

    public EChartsTooltip getTooltip() {
        return tooltip;
    }

    public void setTooltip(EChartsTooltip tooltip) {
        this.tooltip = tooltip;
    }

    public boolean accept(Class<? extends Chart> obClass){
        return ComparatorUtils.equals(ECharts.class, obClass);
    }

    /**
     * 读取当前ECharts中的数据设置，分类，系列部分的设置
     * @param reader  XML读取器
     * @return
     */
    public static TopDefinition readDefinition(XMLableReader reader) {
        TopDefinition definition;
        String tagName = reader.getTagName();
        if (EChartsOneValueCDDefinition.XML_TAG.equals(tagName)) {
            definition = new EChartsOneValueCDDefinition();
        } else if (EChartsMoreNameCDDefinition.XML_TAG.equals(tagName)) {
            definition = new EChartsMoreNameCDDefinition();
        } else if (EChartsNormalReportDataDefinition.XML_TAG.equals(tagName)) {
            definition = new EChartsNormalReportDataDefinition();
        } else {
            return ChartXMLCompatibleUtils.readDefinition(reader);
        }
        reader.readXMLObject(definition);
        return definition;
    }

    /**
     * 生成ChartGlyph，包括其标题(TitleGlyph)、绘图区(PlotGlyph)和图例(LegendGlyph)属性
     * @param chartData 生成ChartGlyph所用的图表数据
     * @return 返回图表Glyph
     */
    @Override
    public BaseChartGlyph createGlyph(ChartData chartData) {
        EChartsGlyph glyph = new EChartsGlyph();
        glyph.setGeneralInfo(this);
        EChartsPlot eChartsPlot = (EChartsPlot) getPlot();
        if (eChartsPlot != null) {
            PlotGlyph plotGlyph = eChartsPlot.createPlotGlyph(chartData);
            glyph.setPlotGlyph(plotGlyph);
            EChartsLegendGlyph legendGlyph = eChartsPlot.createLegendGlyph(plotGlyph);
            glyph.setLegendGlyph(legendGlyph);
        }
        EChartsTitle title = (EChartsTitle) getTitle();
        if (title != null) {
            EChartsTitleGlyph titleGlyph = title.createGlyph();
            glyph.setTitleGlyph(titleGlyph);
        }
        glyph.setWrapperName(getWrapperName());
        glyph.setChartImagePath(getImagePath());
        glyph.setRequiredJS(getRequiredJS());
        glyph.setJSDraw(isJSDraw());
        if (theme != null) {
            glyph.setTheme(theme);
        }
        if (tooltip != null) {
            glyph.setTooltip(tooltip);
        }
        return glyph;
    }

    /**
     * 读取XML文件中的ECharts标签
     * @param reader XML读取器
     */
    @Override
    public void readXML(XMLableReader reader) {
        if (reader.isChildNode()) {
            String tagName = reader.getTagName();
            if (tagName.equals(EChartsTitle.XML_TAG)) {
                setTitle(new EChartsTitle());
                reader.readXMLObject(getTitle());
            } else if (tagName.equals(Plot.XML_TAG)) {
                setPlot((Plot) GeneralXMLTools.readXMLable(reader));
            } else if (tagName.equals(CHARTATTR)) {
                this.setJSDraw(reader.getAttrAsBoolean(ISJSDRAW, true));
                this.setStyleGlobal(reader.getAttrAsBoolean(ISTYLEGLOBAL, false));
            } else if (ComparatorUtils.equals(tagName, CHARTDEFINITION)) {
                reader.readXMLObject(new XMLReadable() {
                    @Override
                    public void readXML(XMLableReader reader) {
                        setFilterDefinition(readDefinition(reader));
                    }
                });
            } else if (tagName.equals(EChartsTheme.XML_TAG)) {
                theme = (EChartsTheme) GeneralXMLTools.readXMLable(reader);
            } else if (tagName.equals(EChartsTooltip.XML_TAG)) {
                tooltip = (EChartsTooltip) GeneralXMLTools.readXMLable(reader);
            }
        }
    }

    /**
     * 将当前ECharts属性写入xml文件中
     * @param writer XML属性输出
     */
    @Override
    public void writeXML(XMLPrintWriter writer) {
        super.writeXML(writer);
        if (theme != null) {
            GeneralXMLTools.writeXMLable(writer, theme, EChartsTheme.XML_TAG);
        }
        if (tooltip != null) {
            GeneralXMLTools.writeXMLable(writer, theme, EChartsTooltip.XML_TAG);
        }
    }

    /**
     * 检测两个对象是否相等
     * @param ob 用 于比较的Object
     * @return 返回true或者false
     */
    @Override
    public boolean equals(Object ob) {
        return ob instanceof ECharts
                && super.equals(ob)
                && ComparatorUtils.equals(theme, ((ECharts) ob).theme)
                && ComparatorUtils.equals(tooltip, ((ECharts) ob).tooltip);
    }
}
