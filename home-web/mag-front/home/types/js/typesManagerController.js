/**
 * Created by Mr.Wu on 2015/12/31.
 */
angular.module('dayApp')
    .controller('typeManagerController',['$scope','$http','httpService','ngModal','$element','Upload',
        function($scope,$http,httpService,ngModal,$element,Upload){
        console.log('typeManagerController--------------');

        $scope.maxSize = 5;  //显示多少页
        $scope.currentSize = 5; // 当前页多少条
        $scope.totalItems = 0;  // 总记录
        $scope.currentPage = 1; //当前页

        $scope.opt = false; //操作 true:add、edit
        $scope.typesList = [];
        $scope.types = {};
        $scope.updateInfo = function(types){
            $scope.opt = true;
            $scope.types = types;
        };
        $scope.goback = function(){
            $scope.opt = false;
        };
        $scope.setPage = function(pageNo){
            angular.element('body').scope().startLoading("goodsManagerLoading");
            $scope.currentPage = pageNo;
            var params = {};
            params["page"] = pageNo;
            params["rows"] = $scope.currentSize;
            httpService.types_count().success(function(size){
                $scope.totalItems = size;
                httpService.types_listByPage( params).success(function(data){
                    $scope.typesList = data;
                }).error(function () {
                    console.log("concern error");
                });
            }).error(function () {
                console.log("concern error");
            }).finally(function(){
                angular.element('body').scope().finishLoading('goodsManagerLoading');
            });
        };
    }]);
