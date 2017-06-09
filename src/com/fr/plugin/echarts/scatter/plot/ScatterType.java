package com.fr.plugin.echarts.scatter.plot;

import com.fr.general.ComparatorUtils;

/**
 * Created by kk on 2017/5/31.
 */
public enum ScatterType {

    NONE("none");

    private String type;

    ScatterType(String type) {
        this.type = type;
    }

    public String toTypeString() {
        return type;
    }

    private static ScatterType[] positions;

    public static ScatterType parse(String p) {
        if (positions == null) {
            positions = ScatterType.values();
        }
        for (ScatterType st : positions) {
            if (ComparatorUtils.equals(p, st.type)) {
                return st;
            }
        }
        return NONE;
    }
}
