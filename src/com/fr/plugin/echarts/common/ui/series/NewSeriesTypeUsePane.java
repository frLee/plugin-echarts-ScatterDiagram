package com.fr.plugin.echarts.common.ui.series;

import com.fr.base.chart.chartdata.TopDefinitionProvider;
import com.fr.chart.chartattr.ChartCollection;
import com.fr.chart.chartattr.Plot;
import com.fr.chart.chartdata.MoreNameCDDefinition;
import com.fr.chart.chartdata.OneValueCDDefinition;
import com.fr.design.beans.FurtherBasicBeanPane;
import com.fr.design.constants.LayoutConstants;
import com.fr.design.gui.frpane.UIComboBoxPane;
import com.fr.design.gui.ilable.UILabel;
import com.fr.design.mainframe.chart.gui.ChartDataPane;
import com.fr.design.mainframe.chart.gui.data.table.SeriesNameUseFieldNamePane;
import com.fr.design.mainframe.chart.gui.data.table.SeriesNameUseFieldValuePane;
import com.fr.design.utils.gui.GUICoreUtils;
import com.fr.general.Inter;
import com.fr.plugin.echarts.common.ui.filter.NewDataFilterPane;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kk on 2017/5/26.
 */
public class NewSeriesTypeUsePane extends UIComboBoxPane<ChartCollection> {

    private static final int HGAP = 4;
    private static final int WIDTH = 75;
    private static final int HEIGHT = 20;

    private ChartDataPane parent;
    private Plot initPlot;

    private boolean isNeedSummary = true;

    private NewDataFilterPane dataFilterPane;

    private SeriesNameUseFieldValuePane nameFieldValuePane;
    private SeriesNameUseFieldNamePane nameFieldNamePane;

    /**
     * NewSeriesTypeUsePane 构造函数
     * @param parent
     * @param initPlot
     */
    public NewSeriesTypeUsePane(ChartDataPane parent, Plot initPlot) {
        cards = initPaneList();
        this.parent = parent;
        this.initPlot = initPlot;
        this.isNeedSummary = true;
        initComponents();
    }

    /**
     * 初始化控件布局与大小
     */
    protected void initLayout() {
        this.setLayout(new BorderLayout(HGAP, LayoutConstants.VGAP_MEDIUM));
        JPanel northPane = new JPanel(new BorderLayout(HGAP, 0));
        UILabel label = new UILabel(Inter.getLocText("ChartF-Series_Name_From") + ":", SwingConstants.RIGHT);
        label.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        northPane.add(GUICoreUtils.createBorderLayoutPane(
                jcb, BorderLayout.CENTER,
                label, BorderLayout.WEST
        ));
        northPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 1));
        add(northPane, BorderLayout.NORTH);
        add(cardPane, BorderLayout.CENTER);
        dataFilterPane = new NewDataFilterPane(initPlot, parent);
        add(dataFilterPane, BorderLayout.SOUTH);
    }

    /**
     * 弹出窗口标题
     * @return
     */
    protected String title4PopupWindow() {
        return Inter.getLocText("ChartF-Series_Name_From");
    }

    /**
     * 设置控件是否可用
     * @param hasUse
     */
    public void checkUseBox(boolean hasUse) {
        jcb.setEnabled(hasUse);
        nameFieldValuePane.checkUse(hasUse);
    }

    /**
     * 数据集变动时，刷新Box选中项
     * @param list 列表
     */
    public void refreshBoxListWithSelectTableData(List list) {
        nameFieldValuePane.refreshBoxListWithSelectTableData(list);
        nameFieldNamePane.refreshBoxListWithSelectTableData(list);
    }

    /**
     * 清空Box列表内容
     */
    public void clearAllBoxList() {
        nameFieldNamePane.clearAllBoxList();
        nameFieldValuePane.clearAllBoxList();
    }

    /**
     * 更新控件内容
     * @param ob
     */
    public void populateBean(ChartCollection ob) {
        this.populateBean(ob, true);
    }

    /**
     * 更新Box内容控件选择
     * @param ob
     * @param isNeedSummary
     */
    public void populateBean(ChartCollection ob, boolean isNeedSummary) {
        this.isNeedSummary = isNeedSummary;
        TopDefinitionProvider definition = ob.getSelectedChart().getFilterDefinition();
        if (definition instanceof OneValueCDDefinition) {
            this.setSelectedIndex(0);
            nameFieldValuePane.populateBean(ob, isNeedSummary);
        } else if (definition instanceof MoreNameCDDefinition) {
            this.setSelectedIndex(1);
            nameFieldNamePane.populateBean(ob, isNeedSummary);
        }
    }

    /**
     * 控件重新布局
     * @param isNeedSummary
     */
    public void relayoutPane(boolean isNeedSummary) {
        this.isNeedSummary = isNeedSummary;
        if (jcb.getSelectedIndex() == 0) {
            nameFieldValuePane.relayoutPane(this.isNeedSummary);
        } else {
            nameFieldNamePane.relayoutPane(this.isNeedSummary);
        }
    }

    /**
     * 更新控件
     * @param ob
     */
    public void updateBean(ChartCollection ob) {
        if (this.getSelectedIndex() ==0) {
            nameFieldValuePane.updateBean(ob);
        } else {
            nameFieldNamePane.updateBean(ob);
        }
    }

    /**
     * 初始化面板控件Box内容list
     * @return
     */
    @Override
    protected List<FurtherBasicBeanPane<? extends ChartCollection>> initPaneList() {
        nameFieldValuePane = new SeriesNameUseFieldValuePane();
        nameFieldNamePane = new SeriesNameUseFieldNamePane();
        List<FurtherBasicBeanPane<? extends ChartCollection>> paneList = new ArrayList<>();
        paneList.add(nameFieldValuePane);
        paneList.add(nameFieldNamePane);
        return paneList;
    }

    /**
     * Box中item内容变化重新布局
     */
    @Override
    protected void comboBoxItemStateChanged() {
        if (jcb.getSelectedIndex() == 0) {
            nameFieldValuePane.relayoutPane(this.isNeedSummary);
        } else {
            nameFieldNamePane.relayoutPane(this.isNeedSummary);
        }
    }
}
