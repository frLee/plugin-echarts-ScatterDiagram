package com.fr.plugin.echarts.common.ui.filter;

import com.fr.chart.chartattr.ChartCollection;
import com.fr.chart.chartattr.Plot;
import com.fr.design.gui.frpane.AbstractAttrNoScrollPane;
import com.fr.design.mainframe.chart.gui.ChartDataPane;
import com.fr.design.mainframe.chart.gui.style.ThirdTabPane;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kk on 2017/5/22.
 */
public class NewDataFilterPane extends ThirdTabPane<ChartCollection> {

    public NewDataFilterPane(Plot plot, ChartDataPane parent) {
        super(plot, parent);
    }

    /**
     * 初始化面板内容list
     * @param plot
     * @param parent
     * @return 返回list
     */
    @Override
    protected List<NamePane> initPaneList(Plot plot, AbstractAttrNoScrollPane parent) {
        List<NamePane> paneList = new ArrayList<NamePane>();
        return paneList;
    }

    /**
     * 面板内容更新
     * @param ob
     */
    @Override
    public void populateBean(ChartCollection ob) {

    }

    /**
     * 弹出的title
     * @return
     */
    @Override
    protected String title4PopupWindow() {
        return null;
    }
}
