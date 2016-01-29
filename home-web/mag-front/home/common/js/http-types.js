'use strict';

(function(angular) {
    angular.module('dayApp').factory('httpTypesFactory',['commonHttp', function(commonHttp){
        var url = "";
        return {
            //总数
            types_count: function(params){
                url = commonHttp.contextPath + 'home/types_Types_countJSON.htm';
                return commonHttp.post(url ,params);
            },
            //列表
            types_listByPage: function(params){
                    url = commonHttp.contextPath + 'home/types_Types_listByPageJSON.htm';
                return commonHttp.post(url ,params);
            }
            //获取数据字典中定义
            //ems_dict_Dict_queryJSON: function(params){
            //        return commonHttp.post(commonVar.contextPath + 'plugins/ems_dict_Dict_queryJSON.htm',params);
            //}
        }
    }]);
})(window.angular);
