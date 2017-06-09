package com.fr.plugin.echarts.common.ui;

import com.fr.chart.chartattr.Chart;
import com.fr.chart.chartattr.Legend;
import com.fr.chart.chartattr.Plot;
import com.fr.design.mainframe.chart.gui.type.AbstractChartTypePane;
import com.fr.general.FRLogger;
import com.fr.stable.ArrayUtils;

/**
 * Created by kk on 2017/5/22.
 */
public abstract class AbstractEChartsTypePane extends AbstractChartTypePane {

    private static final long serialVersionUID = 7743244512351499265L;

    @Override
    protected String[] getTypeIconPath() {
        return getIconsOfTypes();
    }

    @Override
    protected String[] getTypeLayoutPath() {
        return ArrayUtils.EMPTY_STRING_ARRAY;
    }

    /**
     * 图表子类型的图标，需要和图标的子类型数量保持一致
     * @return 子类型图标的集合
     */
    public abstract String[] getIconsOfTypes();

    /**
     * 图表子类型的名字，需要和图标的子类型数量保持一致
     * @return 子类型名字的集合
     */
    public abstract String[] getNamesOfTypes();

    /**
     * 选择的图表子类型
     * @return 子类型
     */
    public abstract Plot getSelectedClonedPlot();

    /**
     * 选择界面课接收的图表类型
     * @param obj 待判定的对象
     * @return 能接收yes，反之no
     */
    public abstract boolean accept(Object obj);

    /**
     * 保存图表界面配置
     * @param chart
     */
    public void updateBean(Chart chart) {
        checkTypeChange();
        Plot oldPlot = chart.getPlot();
        Plot newPlot = getSelectedClonedPlot();
        boolean samePlot = accept(chart);
        if (typeChanged && samePlot) {
            cloneOldPlot2New(oldPlot, newPlot);
            chart.setPlot(newPlot);
        } else if (!samePlot) {
            chart.setPlot(newPlot);
        }
    }

    /**
     *检查type变化情况
     */
    protected void checkTypeChange() {
        for (int i = 0; i < typeDemo.size(); i++) {
            if (typeDemo.get(i).isPressing && i != lastStyleIndex) {
                typeChanged = true;
                lastTypeIndex = i;
                break;
            }
            typeChanged = false;
        }
    }

    /**
     * 同一个图表，子类型之间的切换
     * @param oldPlot 老的子类型
     * @param newPlot 新的子类型
     */
    protected void cloneOldPlot2New(Plot oldPlot, Plot newPlot) {
        try {
            if (oldPlot.getLegend() != null) {
                newPlot.setLegend((Legend) oldPlot.getLegend().clone());
            }
        } catch (CloneNotSupportedException e) {
            FRLogger.getLogger().error(e.getMessage());
        }
    }
}
