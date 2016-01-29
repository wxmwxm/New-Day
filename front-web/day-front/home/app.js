/**
 * Created by Mr.Wu on 2015/12/9.
 */
'use strict';
(function(angular){
    var webApp = angular.module('dayApp',[
            'ui.router',
            'ui.router.util',
            'ui.router.router'
    ]);
    webApp.config(function($stateProvider){
            //console.log("路由加载",$stateProvider);
            $stateProvider
                .state('main',{
                    url : '/main',
                    views: {
                        '': {
                            templateUrl: 'home/index.html'
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
            }
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
