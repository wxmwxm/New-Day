'use strict';

(function(angular) {
    angular.module('dayApp').factory('commonService', [
        function () {
            var transFn = function (data) {
                return $.param(data);
            }, postCfg = {
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
                },
                transformRequest: transFn,
                timeout: 10000
            };

            return {
                contextPath: '/itpub-web/',
                webfrontPath: '/web-front/',
                uploadfilePath: '/uploadfile/',
                logMenuUrl: 'app/logquery/html/index.html',//logquery.html.index',
                alarmMenuUrl: 'app/alarm/index.html',
                appNavMenuUrl: 'app/mainnav/html/appNav.html',
                moduleNavMenuUrl: 'app/mainnav/html/moduleNav.html',
                clusterNavMenuUrl: 'app/mainnav/html/clusterNav.html',
                hostNavMenuUrl: 'app/mainnav/html/hostNav.html',
                postCfg: postCfg
            };
        }
    ])
})(window.angular);

var commonFn = (function () {
    function getRequest(url) {
        var theRequest = new Object();
        var str = url;
        var strs = str.split("&");
        for (var i = 0; i < strs.length; i++) {
            var attrName = strs[i].split("=")[0];
            var attrValue = unescape(strs[i].split("=")[1]);
            //Object.defineProperty(theRequest,attrName,{enumerable:false,value:attrValue});
              theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
        }
        return theRequest;
    }
    function parseString2Object(str) {
        if(str && str != ''){
            var ro = {};
            ro.default=[];
            var tmp = str.replace(/^[:=]*|[:=]*$|\B[:=]*|[:=]*\B/g,'');
            tmp = tmp.replace(/:/g,'=');
            var arr = tmp.split(' ');
            arr.forEach(function(value){
                var i = value.indexOf('=');
                if(i>=0){
                    ro[value.substring(0,i)]=value.substring(i+1,value.length);
                }else{
                    ro.default.push(value);
                }
            });
            return ro;            
        }
    }
    function parseObject2String(obj){
        var arr=[];
        for(var a in obj){
            arr.push(a+'='+obj[a]);
        }
        return arr.join(' ');
    }
    return {
        getRequest: getRequest,
        parseString2Object: parseString2Object,
        parseObject2String: parseObject2String
    }
})();


Date.prototype.Format = function (fmt) { //author: meizz
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}