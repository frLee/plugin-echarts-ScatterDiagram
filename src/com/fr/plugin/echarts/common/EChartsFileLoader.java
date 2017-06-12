package com.fr.plugin.echarts.common;

import com.fr.stable.EncodeConstants;
import com.fr.stable.fun.impl.AbstractJavaScriptFileHandler;

/**
 * Created by kk on 2017/5/17.
 */
public class EChartsFileLoader extends AbstractJavaScriptFileHandler {

    @Override
    public String[] pathsForFiles() {
        return new String[]{
                "/com/fr/plugin/echarts/common/web/echarts.loader.js",
                "/com/fr/plugin/echarts/common/web/lib/echarts.min.js"
        };
    }

    @Override
    public String encode() {
        return EncodeConstants.ENCODING_UTF_8;
    }
}
