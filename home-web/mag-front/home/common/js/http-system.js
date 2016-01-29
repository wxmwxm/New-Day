'use strict';

(function(angular) {
    angular.module('dayApp').factory('httpSystemFactory',['commonHttp', function(commonHttp){
        return {
            //注销
            login_logout: function(params){
                    return commonHttp.post(commonHttp.contextPath + '',params);
            }
            //获取数据字典中定义
            //ems_dict_Dict_queryJSON: function(params){
            //        return commonHttp.post(commonVar.contextPath + 'plugins/ems_dict_Dict_queryJSON.htm',params);
            //}
        }
    }]);
})(window.angular);
