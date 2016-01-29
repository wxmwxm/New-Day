'use strict';

(function(angular) {
    angular.module('dayApp')
        .factory('commonHttp',['$http', function($http){
            var transFn = function (data) {
                    return $.param(data);
            }, postCfg = {
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded; application/json; charset=UTF-8'
                },
                transformRequest: transFn,
                timeout: 10000
            };

            function post(url,params) {
                //console.log(url,params);
                if(params){
                    return  $http.post(url, params,postCfg);
                } else {
                    return  $http.post(url,postCfg);
                }
            }

            return {
                contextPath: '/WebApp/',
                webfrontPath: '/home-web/',
                uploadfilePath: '/uploadfile/',
                post:post
            }
    }]).factory('httpService', ['commonHttp', 'httpSystemFactory','httpGoodsFactory','httpTypesFactory','httpBrandsFactory',
        function(commonHttp, httpSystemFactory, httpGoodsFactory,httpTypesFactory,httpBrandsFactory)
        {
            return angular.extend({
                    //ems_businessdata_BusinessData_getTopSearchJSON: function(params){
                    //        return commonHttp.post(commonVar.contextPath + 'ems/ems_businessdata_BusinessData_getTopSearchJSON.htm',params);
                    //}
                },
                httpSystemFactory,
                httpGoodsFactory,
                httpTypesFactory,
                httpBrandsFactory
                //httpSystemFactory
            );
        }
    ]);
})(window.angular);
