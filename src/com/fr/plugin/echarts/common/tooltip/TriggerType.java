package com.fr.plugin.echarts.common.tooltip;

import com.fr.general.ComparatorUtils;

/**
 * Created by kk on 2017/5/22.
 */
public enum TriggerType {

    ITEM("item"), AXIS("axis");

    private String type;

    TriggerType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static TriggerType parse(String type) {
        for (TriggerType tt : values()) {
            if (ComparatorUtils.equals(type, tt.type)) {
                return tt;
            }
        }
        return ITEM;
    }
}
