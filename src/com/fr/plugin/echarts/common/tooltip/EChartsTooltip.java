package com.fr.plugin.echarts.common.tooltip;

import com.fr.general.ComparatorUtils;
import com.fr.json.JSONException;
import com.fr.json.JSONObject;
import com.fr.stable.StringUtils;
import com.fr.stable.web.Repository;
import com.fr.stable.xml.XMLPrintWriter;
import com.fr.stable.xml.XMLable;
import com.fr.stable.xml.XMLableReader;

/**
 * Created by kk on 2017/5/19.
 */
public class EChartsTooltip implements XMLable {

    private static final String TRIGGER = "trigger";
    private static final String FORMATTER = "formatter";
    private static final String ATTR = "Attr";
    private static final String FORMAT = "format";
    public static final String XML_TAG = "Tooltip";

    private TriggerType triggerType;
    private String format;

    public EChartsTooltip() {
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public TriggerType getTriggerType() {
        return triggerType;
    }

    public void setTriggerType(TriggerType triggerType) {
        this.triggerType = triggerType;
    }

    /**
     *将trigger和format以JSONObject写入
     * @param repo
     * @return JSONObject
     * @throws JSONException
     */
    public JSONObject toJSONObject(Repository repo) throws JSONException {
        JSONObject jo = JSONObject.create();
        jo.put(TRIGGER, triggerType.getType());
        jo.put(FORMAT, FORMATTER);
        return jo;
    }

    /**
     * 判断对象是否一致
     * @param obj
     * @return 返回true或者false
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof EChartsTooltip
                && ComparatorUtils.equals(triggerType, ((EChartsTooltip) obj).triggerType)
                && ComparatorUtils.equals(format, ((EChartsTooltip) obj).format);
    }

    /**
     * 读取XML标签中trigger和format内容
     * @param reader XML读取对象
     */
    @Override
    public void readXML(XMLableReader reader) {
        if (reader.isChildNode()) {
            String tagName = reader.getTagName();
            if (tagName.equals(ATTR)) {
                triggerType = TriggerType.parse(reader.getAttrAsString(TRIGGER, ""));
                format = reader.getAttrAsString(FORMAT, "");
            }
        }
    }

    /**
     * 将trigger和format写入XML标签中
     * @param writer XML写入对象
     */
    @Override
    public void writeXML(XMLPrintWriter writer) {
        writer.startTAG(ATTR);
        if (triggerType != null) {
            writer.attr(TRIGGER, triggerType.getType());
        }
        if (StringUtils.isNotEmpty(format)) {
            writer.attr(FORMAT, format);
        }
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
}
