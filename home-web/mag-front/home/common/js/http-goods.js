'use strict';

(function(angular) {
    angular.module('dayApp').factory('httpGoodsFactory',['commonHttp', function(commonHttp){
        var url = "";
        return {
            //总数
            goods_count: function(params){
                url = commonHttp.contextPath + 'home/goods_Goods_countJSON.htm';
                return commonHttp.post(url ,params);
            },
            //列表
            goods_listByPage: function(params){
                    url = commonHttp.contextPath + 'home/goods_Goods_listByPageJSON.htm';
                return commonHttp.post(url ,params);
            }
            ,goods_upload : function(){
                url = commonHttp.contextPath +  'home/file_Uploader_uploadJSON.htm';
                return commonHttp.post(url ,params);
            }
            //获取数据字典中定义
            //ems_dict_Dict_queryJSON: function(params){
            //        return commonHttp.post(commonVar.contextPath + 'plugins/ems_dict_Dict_queryJSON.htm',params);
            //}
        }
    }]);
})(window.angular);
