package com.fr.plugin.echarts.common.tooltip;

import com.fr.json.JSONException;
import com.fr.json.JSONObject;
import com.fr.stable.web.Repository;
import com.fr.stable.xml.XMLPrintWriter;
import com.fr.stable.xml.XMLable;
import com.fr.stable.xml.XMLableReader;

/**
 * Created by kk on 2017/5/19.
 */
public class EChartsTooltip implements XMLable {

    public EChartsTooltip() {
    }

    public JSONObject toJSONObject(Repository repo) throws JSONException {
        JSONObject jo = JSONObject.create();
        return jo;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof EChartsTooltip;
    }

    @Override
    public void readXML(XMLableReader reader) {
        if (reader.isChildNode()) {
            String tagName = reader.getTagName();
            if (tagName.equals("")) {

            }
        }
    }

    @Override
    public void writeXML(XMLPrintWriter writer) {
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
