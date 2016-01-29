/**
 * Created by Mr.Wu on 2015/12/10.
 */
angular.module('dayApp').controller('mainController',[
    '$scope', '$http', '$state','$loading',
    function($scope, $http,$state,$loading){
        $scope.String2Date = function(timestamp){
            var result = '';
            if(timestamp){
                result = new Date(timestamp).Format("yyyy-MM-dd hh:mm:ss");
            }
            return result;
        };
        $scope.MenuClick = function (url,$event) {
            $($event.target).parent().find(".middle-menu").removeClass("currMenu");
            $($event.target).addClass("currMenu");
            $scope.commonMenuClick(url);
        };
        $scope.ChangeMainMenu = function($event){
            $($event.target).parent().parent().find(".navMenuMiddle").removeClass("currMenu");
            $($event.target).parent().addClass("currMenu");
        };
        $scope.commonMenuClick = function (url) {
            //$scope.startLoading();
            try{
                var tmp = url.split('.');
                if (tmp[tmp.length - 1] == 'htm') {
                    $scope.caniFrame = 1;
                    //$scope.iframeUrl= '/itpub-web/' + url;
                } else {
                    $scope.caniFrame = 0;
                    var goUrl = 'main.menu';
                    $state.go(goUrl, {name:  url},{
                        //reload: true
                    });
                }
            }
            finally{
                //$scope.leftMin = true;
                //$scope.finishLoading();
            }
        };

        $scope.startLoading = function(loading) {
            // console.log('emsloading start',loading);
            if(loading==undefined){
                $loading.start('ngloading');
            } else {
                $loading.start(loading);
            }

        };
        $scope.finishLoading = function(loading) {
            // console.log('emsloading finish', loading);
            if (loading == undefined) {
                $loading.finish('emsloading');
            } else {
                $loading.finish(loading);
            }
        };
    }
]);