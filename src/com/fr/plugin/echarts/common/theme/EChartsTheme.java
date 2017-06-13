package com.fr.plugin.echarts.common.theme;

import com.fr.general.ComparatorUtils;
import com.fr.stable.xml.XMLPrintWriter;
import com.fr.stable.xml.XMLable;
import com.fr.stable.xml.XMLableReader;

/**
 * Created by kk on 2017/5/19.
 */
public class EChartsTheme implements XMLable {

    private static final String DEFAULT = "default";
    private static final String SCATTERTHEME = "ScatterTheme";
    private static final String NAME = "name";

    private String themeName;

    public EChartsTheme() {
        this(DEFAULT);
    }

    public EChartsTheme(String themeName) {
        this.themeName = themeName;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    /**
     *读取XML标签中主题内容
     * @param reader XML读取对象
     */
    @Override
    public void readXML(XMLableReader reader) {
        if (reader.isChildNode()) {
            String tagName = reader.getTagName();
            if (tagName.equals(SCATTERTHEME)) {
                themeName = reader.getAttrAsString(NAME, DEFAULT);
            }
        }
    }

    /**
     * 将主题内容写入XML标签
     * @param writer XML写入对象
     */
    @Override
    public void writeXML(XMLPrintWriter writer) {
        writer.startTAG(SCATTERTHEME);
        writer.attr(NAME, themeName);
        writer.end();
    }

    /**
     * 浅拷贝
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof EChartsTheme
                && ComparatorUtils.equals(themeName, ((EChartsTheme) obj).themeName);
    }
}
