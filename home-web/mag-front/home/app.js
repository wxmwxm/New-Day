/**
 * Created by Mr.Wu on 2015/12/9.
 */
'use strict';
(function(angular){
    var webApp = angular.module('dayApp',[
        'ui.bootstrap',
        'ui.router',
        'ui.router.util',
        'ui.router.router',
        'darthwade.dwLoading',
        'ngFileUpload',
        'ng.ueditor'
    ]);
    webApp.config(function($stateProvider){
            //console.log("路由加载",$stateProvider);
            $stateProvider
                .state('main',{
                    url : '/main',
                    views: {
                        '': {
                            templateUrl: 'home/main/main.html'
                        }
                    }
                })
                .state('login',{
                    url : '/login',
                    views: {
                        '': {
                            templateUrl: 'home/login/login.html'
                        }
                    }
                })
                .state('main.menu', {
                    url: '/menu/{name:.*}',
                    views: {
                        'mainview@main': {
                                templateUrl: getMenuTemplateUrl
                            }
                        }
                    }
                )
                .state('about',{
                    url           : '/about',
                    views: {
                        '': {
                            templateUrl: getMenu
                        }
                    }
                });

            function getMenu($stateParams){
                console.log($stateParams);
                return "about.html";
            };
            function getMenuTemplateUrl($stateParams) {
                console.log('$stateParams1',$stateParams);
                var urlList = decodeURIComponent($stateParams.name).split('/');
                var urlname = urlList[0];
                var i = urlname.indexOf('?');
                if(i>=0){
                    $stateParams.param = commonFn.getRequest(urlname.substring(i+1));
                }
                console.log('$stateParams2',$stateParams);
                urlname = i==-1?urlname:urlname.substring(0,i);
                var tmp = urlname.split('.');
                var result='';
                if (tmp[tmp.length - 1] == 'htm') {
                    result = contextPath + urlname;
                } else {
                    result = 'home/' + urlname.replace(/\./g, '/') + '.html';
                }
                console.log('result url',result);
                return result;
            };
        })
        .run(function($rootScope,$location,$state,AuthService){
            $rootScope.$on('$stateChangeSuccess',function(e,a,b,c,d,f,g){
                //console.log('$stateChangeSuccess emsPanelDestroy',e,a,b,c,d,f,g);
                var mainScope = angular.element('body').scope();
                mainScope.$broadcast("dayPanelDestroy");
                //mainScope.pageState.isShowSidebar=false;
            });

            $rootScope.$on('$locationChangeSuccess', function(e) {
                console.log("登录检查...",e,$location.path());
                if($location.path() == '/login'){
                    AuthService.distroy();
                    return ;
                };
                var goUrl = '';
                if ($location.path() == '') {
                    goUrl = 'main';
                }
                AuthService.login();
                if(AuthService.isAuthenticated()){
                    if (goUrl) {
                        console.log(goUrl);
                        $state.go(goUrl, {}, {reload: true});
                    }else{
                        e.preventDefault();
                    }
                }else{
                    $state.go('login');
                }
            });
        })
        .service('Session',function(){
            this.isAuthenticated = null;
            this.data = null;
            this.distroy = function(){
                console.log('Session destroy');
                this.isAuthenticated = null;
                this.data = null;
            }
            return this;
        })
        .factory('AuthService',[
            '$http',
            'Session',
            function($http,Session){
                return {
                    logout: function(){
                        console.log("注销登录.");
                        Session.distroy();
                    },
                    login: function(){
                        if(!Session.isAuthenticated){
                            //console.log("用户登录中...");
                            $.ajax({
                                async: false,
                                url: '/WebApp/loginJson.htm',
                                success: function (data) {
                                    data = eval('(' + data + ')');
                                    if (data.errorCode == "0") {
                                        console.log('已登录');
                                        Session.isAuthenticated = true;
                                        Session.data = data.data;
                                    } else {
                                        console.log('未登录');
                                        Session.isAuthenticated = false;
                                    }
                                }, error: function () {
                                    console.log('登录检查失败');
                                    Session.isAuthenticated = false;
                                }
                            });
                        }
                    },
                    isAuthenticated: function(){
                        return Session.isAuthenticated;
                    },
                    data: function(){
                        return Session.data;
                    },
                    distroy: function(){
                        Session.distroy();
                    }
                };
            }
        ]);
})(window.angular);
