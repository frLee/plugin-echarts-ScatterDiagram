package com.fr.plugin.echarts.common.ui;

import com.fr.base.Formula;
import com.fr.design.dialog.BasicScrollPane;
import com.fr.design.formula.TinyFormulaPane;
import com.fr.design.gui.ibutton.UIButtonGroup;
import com.fr.design.gui.ilable.UILabel;
import com.fr.design.layout.TableLayout;
import com.fr.design.layout.TableLayoutHelper;
import com.fr.general.GeneralUtils;
import com.fr.general.Inter;
import com.fr.plugin.echarts.common.base.ECharts;
import com.fr.plugin.echarts.common.title.EChartsTitle;
import com.fr.stable.StableUtils;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kk on 2017/5/22.
 */
public class EChartsTitlePane extends BasicScrollPane<ECharts> {

    private UIButtonGroup<Boolean> showTitle;
    private TinyFormulaPane tinyFormulaPane;
    private EChartStylePane stylePane;

    public EChartsTitlePane(EChartStylePane stylePane) {
        this.stylePane = stylePane;
    }

    /**
     * 更新title
     * @param ob
     */
    @Override
    public void populateBean(ECharts ob) {
        EChartsTitle title = (EChartsTitle) ob.getTitle();
        if (title == null) {
            return;
        }
        showTitle.setSelectedItem(title.isTitleVisible());
        if (title.getTextObject() instanceof Formula) {
            tinyFormulaPane.populateBean(((Formula) title.getTextObject()).getContent());
        } else {
            tinyFormulaPane.populateBean(GeneralUtils.objectToString(title.getTextObject()));
        }
    }

    /**
     * 更新标题部分的控件内容
     * @param ob
     */
    @Override
    public void updateBean(ECharts ob) {
        if (ob == null) {
            ob = new ECharts();
        }
        EChartsTitle title = new EChartsTitle();
        ob.setTitle(title);
        title.setTitleVisible(showTitle.getSelectedItem());
        String titleStr = tinyFormulaPane.updateBean();
        Object titleObj;
        if (StableUtils.maybeFormula(titleStr)) {
            titleObj = new Formula(titleStr);
        } else {
            titleObj = titleStr;
        }
        title.setTextObject(titleObj);
    }

    /**
     * 创建图例部分的显示内容
     * @return
     */
    @Override
    protected JPanel createContentPane() {
        JPanel jPanel = new JPanel(new BorderLayout());
        double p = TableLayout.PREFERRED;
        double f = TableLayout.FILL;
        double[] rowSize = {p, p};
        double[] columnSize = {p, f};
        showTitle = new UIButtonGroup<Boolean>(
                new String[]{
                        Inter.getLocText("Plugin-ECharts_Title_Show"),
                        Inter.getLocText("Plugin-ECharts_Title_Not_Show")
                },
                new Boolean[]{true, false}
        );
        showTitle.setSelectedIndex(0);
        tinyFormulaPane = new TinyFormulaPane();
        JPanel center = TableLayoutHelper.createTableLayoutPane(new Component[][]{
                {new UILabel(Inter.getLocText("Plugin-ECharts_Title_Show_Label")), showTitle},
                {new UILabel(Inter.getLocText("Plugin-ECharts_Title_Content")), tinyFormulaPane}
        }, rowSize, columnSize);
        jPanel.add(center, BorderLayout.CENTER);
        return jPanel;
    }

    /**
     * 弹出窗显示标题
     * @return
     */
    @Override
    protected String title4PopupWindow() {
        return Inter.getLocText("Plugin-ECharts_Title");
    }
}
