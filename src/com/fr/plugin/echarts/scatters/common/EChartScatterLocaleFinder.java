package com.fr.plugin.echarts.scatters.common;

import com.fr.stable.EncodeConstants;
import com.fr.stable.fun.impl.AbstractJavaScriptFileHandler;

/**
 * Created by kk on 2017/5/17.
 */
public class EChartScatterLocaleFinder extends AbstractJavaScriptFileHandler {

    @Override
    public String[] pathsForFiles() {
        return new String[]{
                "",
                ""
        };
    }

    @Override
    public String encode() {
        return EncodeConstants.ENCODING_UTF_8;
    }
}
