/**
 * Created by kk on 2017/5/17.
 */
EChartsFactory = function (options, $dom) {
    this.options = options;
    this.$dom = $dom;
    this.chartID = options.chartID;
    this.autoRefreshTime = options.autoRefreshTime || 0;

    this.width = options.width || $dom.width();
    this.height = options.height || $dom.height();
    this.sheetIndex = options.sheetIndex || 0;
    this.ecName = options.ecName || '';

    FR.Chart.WebUtils._installChart(this, this.chartID);
};

EChartsFactory.prototype = {
    constructor: EChartsFactory,
    
    inits : function () {
        var ct = this.options.chartAttr;
        if(ct.theme != 'default') {
            FR.$defaultImport('/com/fr/plugin/echarts/common/web/theme/' + ct.theme + '.js');
        }
        this.newCharts = echarts.init(this.$dom[0], EChartsTheme[ct.theme]);
        this.newCharts.setOption(ct);
    },

    resize : function () {
        this.newCharts.resize();
    },

    refresh : function () {

    },

    refreshData : function (options) {
        
    },
    
    setData : function (options, animation) {
        
    }
};