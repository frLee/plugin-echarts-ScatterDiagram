package com.fr.plugin.echarts.scatter.ui;

import com.fr.chart.chartattr.Chart;
import com.fr.chart.chartattr.Plot;
import com.fr.design.mainframe.chart.gui.type.ChartImagePane;
import com.fr.general.FRLogger;
import com.fr.general.Inter;
import com.fr.plugin.echarts.common.base.ECharts;
import com.fr.plugin.echarts.common.ui.AbstractEChartsTypePane;
import com.fr.plugin.echarts.scatter.EChartScatter;
import com.fr.plugin.echarts.scatter.plot.EChartScatterPlot;
import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by kk on 2017/5/26.
 */
public class EChartScatterChartTypePane extends AbstractEChartsTypePane {

    private static final String ERROR = "Error In ColumnChart";

    /**
     * 界面是否接受
     * @param obj 待判定的对象
     * @return
     */
    @Override
    public boolean accept(Object obj) {
        return (obj instanceof ECharts) && ((ECharts) obj).getPlot().accept(EChartScatterPlot.class);
    }

    /**
     * 弹出框的标题
     * @return
     */
    @Override
    public String title4PopupWindow() {
        return Inter.getLocText("Plugin-ECharts_Scatter");
    }

    /**
     * 图表子类型的名字，需要和图标的子类型数量保持一致
     * @return
     */
    @Override
    protected String[] getTypeTipName() {
        return getNamesOfTypes();
    }

    /**
     * 图表子类型的名字，需要和图标的子类型数量保持一致
     * @return
     */
    @Override
    protected String[] getTypeLayoutTipName() {
        return getNamesOfTypes();
    }

    /**
     * 更新页面
     * @param chart
     */
    @Override
    public void populateBean(Chart chart) {
        for (ChartImagePane imagePane : typeDemo) {
            imagePane.isPressing = false;
        }
        Plot plot = chart.getPlot();
        if (plot instanceof EChartScatterPlot) {
            lastTypeIndex = ((EChartScatterPlot) plot).getScatterType().ordinal();
            typeDemo.get(lastTypeIndex).isPressing = true;
        }
        checkDemosBackground();
    }

    @Override
    protected String getPlotTypeID() {
        return EChartScatterPlot.PLOT_ID;
    }

    @Override
    public Chart getDefaultChart() {
        return EChartScatter.charts[0];
    }

    /**
     * 子类覆盖
     * @return
     */
    @Override
    public Plot getSelectedClonedPlot() {
        EChartScatterPlot newPlot = null;
        Chart[] scatterChart = EChartScatter.charts;
        for (int i = 0, len = scatterChart.length; i < len; i++) {
            if (typeDemo.get(i).isPressing) {
                newPlot = (EChartScatterPlot) scatterChart[i].getPlot();
            }
        }
        Plot cloned = null;
        try {
            cloned = (Plot) newPlot.clone();
        } catch (CloneNotSupportedException e) {
            FRLogger.getLogger().error(ERROR);
        }
        return cloned;
    }

    /**
     * 获取图标文件路径
     * @return
     */
    @Override
    public String[] getIconsOfTypes() {
        return new String[] {
                "/com/fr/solution/plugin/chart/echarts/pie/images/pie_type_none.png",
                "/com/fr/solution/plugin/chart/echarts/pie/images/pie_type_area.png",
                "/com/fr/solution/plugin/chart/echarts/pie/images/pie_type_radius.png",
        };
    }

    /**
     * 图标类型名字
     * @return
     */
    @Override
    public String[] getNamesOfTypes() {
        return new String[] {
                "Normal",
                "Area",
                "Redius"
        };
    }
}
