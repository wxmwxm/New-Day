'use strict';

(function(angular) {
    angular.module('dayApp').factory('httpBrandsFactory',['commonHttp', function(commonHttp){
        var url = "";
        return {
            //总数
            brands_count: function(params){
                url = commonHttp.contextPath + 'home/brands_Brands_countJSON.htm';
                return commonHttp.post(url ,params);
            },
            //列表
            brands_listByPage: function(params){
                    url = commonHttp.contextPath + 'home/brands_Brands_listByPageJSON.htm';
                return commonHttp.post(url ,params);
            }
            //获取数据字典中定义
            //ems_dict_Dict_queryJSON: function(params){
            //        return commonHttp.post(commonVar.contextPath + 'plugins/ems_dict_Dict_queryJSON.htm',params);
            //}
        }
    }]);
})(window.angular);
