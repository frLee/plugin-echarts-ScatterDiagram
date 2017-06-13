package com.fr.plugin.echarts.common.ui;

import com.fr.chart.chartattr.ChartCollection;
import com.fr.design.beans.BasicBeanPane;
import com.fr.design.dialog.BasicPane;
import com.fr.design.dialog.MultiTabPane;
import com.fr.design.event.UIObserver;
import com.fr.design.event.UIObserverListener;
import com.fr.design.gui.frpane.AttributeChangeListener;
import com.fr.design.mainframe.chart.AbstractChartAttrPane;
import com.fr.design.mainframe.chart.PaneTitleConstants;
import com.fr.general.Inter;
import com.fr.plugin.echarts.common.base.ECharts;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by kk on 2017/5/19.
 */
public class EChartStylePane extends AbstractChartAttrPane implements UIObserver {

    private static final int RIGHT = 10;
    private static final String TAB = "tab";

    private AttributeChangeListener listener;
    private UIObserverListener uiObserverListener;
    private ECharts chart;

    private EChartsTitlePane titlePane;
    private BasicPane tooltipPane;
    private BasicPane themePane;
    private BasicPane legendPane;

    private KindOfTabPane kindOfTabPane;

    public EChartStylePane(AttributeChangeListener listener) {
        this.listener = listener;
        this.initComponents();
    }

    /**
     * 初始化swing控件
     */
    private void initComponents() {
        setLayout(new BorderLayout());
        titlePane = new EChartsTitlePane(this);
        tooltipPane = new BasicPane() {
            @Override
            protected String title4PopupWindow() {
                return Inter.getLocText("Plugin-ECharts_Tooltip");
            }
        };
        themePane = new BasicPane() {
            @Override
            protected String title4PopupWindow() {
                return Inter.getLocText("Plugin-ECharts_Theme");
            }
        };
        legendPane = new BasicPane() {
            @Override
            protected String title4PopupWindow() {
                return Inter.getLocText("Plugin-ECharts_Legend");
            }
        };
    }

    /**
     * 初始化swing控件的监听
     * @param parentComponent
     */
    protected void initSelfListener(Container parentComponent) {
        for (int i = 0; i < parentComponent.getComponentCount(); i++) {
            Component tmpComp = parentComponent.getComponent(i);
            if (tmpComp instanceof Container) {
                initListener((Container) tmpComp);
            }
            if (tmpComp instanceof UIObserver) {
                ((UIObserver) tmpComp).registerChangeListener(uiObserverListener);
            }
        }
    }

    /**
     * 获取图标文件路径
     * @return
     */
    public String getIconPath() {
        return "com/fr/plugin/echarts/images/toolbar_item.png";
    }

    /**
     * 弹框内容标题
     * @return
     */
    public String title4PopupWindow() {
        return PaneTitleConstants.CHART_STYLE_TITLE;
    }

    /**
     * 注册监听事件
     * @param listener 观察者监听事件
     */
    public void registerChangeListener(UIObserverListener listener) {
        this.uiObserverListener = listener;
    }

    /**
     * 是否可用回馈变化监听
     * @return
     */
    public boolean shouldResponseChangeListener() {
        return true;
    }

    /**
     * 创建pane组中的控件内容
     */
    public class KindOfTabPane extends MultiTabPane<ECharts> {

        private void dealWithChosenPane(int index) {
            if (index == 0) {
                return;
            }
            BasicPane chosenPane = paneList.get(index);
            centerPane.remove(index);
            paneList.remove(index);
            if (chosenPane == tooltipPane) {
                chosenPane = new EChartsTooltipPane(EChartStylePane.this);
            } else if (chosenPane == themePane) {
                chosenPane = new EChartsThemePane(EChartStylePane.this);
            } else if (chosenPane == legendPane) {
                chosenPane = new EChartsLegendPane(EChartStylePane.this);
            }
            initSelfListener(chosenPane);
            centerPane.add(chosenPane, chosenPane.getTitle(), index);
            paneList.add(index, chosenPane);
        }

        /**
         * 初始化控件位置
         */
        @Override
        protected void initLayout() {
            JPanel tabpane1 = new JPanel(new BorderLayout());
            tabpane1.setBorder(BorderFactory.createMatteBorder(0, 0, 0, RIGHT, getBackground()));
            tabpane1.add(tabPane, BorderLayout.CENTER);
            setLayout(new BorderLayout(0, 4));
            add(tabpane1, BorderLayout.NORTH);
            add(centerPane, BorderLayout.CENTER);
        }

        /**
         * 处理tab变化的动作操作
         * @param index
         */
        @Override
        protected void dealWithTabChanged(int index) {
            dealWithChosenPane(index);
            cardLayout.show(centerPane, NameArray[index]);
            tabChanged();
        }

        /**
         * tab变动
         */
        @Override
        protected void tabChanged() {
            EChartStylePane.this.removeAttributeChangeListener();
            ((BasicBeanPane<ECharts>)paneList.get(tabPane.getSelectedIndex())).populateBean(chart);
            EChartStylePane.this.addAttributeChangeListener(listener);
        }

        /**
         * 初始化panlist
         * @return
         */
        @Override
        protected List<BasicPane> initPaneList() {
            List<BasicPane> paneList = new ArrayList<>();
            paneList.add(titlePane);
            paneList.add(tooltipPane);
            paneList.add(themePane);
            paneList.add(legendPane);
            return paneList;
        }

        /**
         * 更新控件
         * @param ob
         */
        @Override
        public void populateBean(ECharts ob) {
            if (chart == null || kindOfTabPane.getSelectedIndex() == -1) {
                return;
            }
            ((BasicBeanPane<ECharts>) paneList.get(kindOfTabPane.getSelectedIndex())).populateBean(chart);
        }

        /**
         * 更新控件
         * @return
         */
        @Override
        public ECharts updateBean() {
            if (chart == null) {
                return null;
            }
            ((BasicBeanPane<ECharts>) paneList.get(kindOfTabPane.getSelectedIndex())).updateBean(chart);
            return chart;
        }

        /**
         * 更新控件
         * @param ob
         */
        @Override
        public void updateBean(ECharts ob) {
            BasicBeanPane<ECharts> pane = ((BasicBeanPane<ECharts>) paneList.get(kindOfTabPane.getSelectedIndex()));
            pane.updateBean(ob);
        }

        @Override
        public boolean accept(Object ob) {
            return true;
        }

        /**
         * 弹出框title
         * @return
         */
        @Override
        public String title4PopupWindow() {
            return TAB;
        }

        @Override
        public void reset() {
        }
    }

    /**
     * 创建内容pane
     * @return
     */
    @Override
    protected JPanel createContentPane() {
        JPanel content = new JPanel(new BorderLayout());
        if (chart == null) {
            return content;
        }
        kindOfTabPane = new KindOfTabPane();
        content.add(kindOfTabPane, BorderLayout.CENTER);
        return content;
    }

    /**
     * 更新界面 数据内容
     * @param collection
     */
    @Override
    public void populate(ChartCollection collection) {
        this.chart = (ECharts) collection.getSelectedChart();
        this.remove(leftContentPane);
        initContentPane();
        this.removeAttributeChangeListener();
        kindOfTabPane.populateBean(chart);
        this.addAttributeChangeListener(listener);
        this.initAllListeners();
    }

    /**
     * 更新样式
     * @param collection
     */
    @Override
    public void update(ChartCollection collection) {
        kindOfTabPane.updateBean((ECharts) collection.getSelectedChart());
    }
}
