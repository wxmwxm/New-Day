/**
 * Created by Mr.Wu on 2015/12/31.
 */
angular.module('dayApp')
    .controller('brandsManagerController',['$scope','$http','httpService','ngModal','$element','Upload',
        function($scope,$http,httpService,ngModal,$element,Upload){
        console.log('brandsManagerController--------------');

        $scope.maxSize = 5;  //显示多少页
        $scope.currentSize = 5; // 当前页多少条
        $scope.totalItems = 0;  // 总记录
        $scope.currentPage = 1; //当前页

        $scope.opt = false; //操作 true:add、edit
        $scope.brandsList = [];
        $scope.brands = {};
        $scope.updateInfo = function(brands){
            $scope.opt = true;
            $scope.brands = brands;
        };
        $scope.goback = function(){
            $scope.opt = false;
        };
        $scope.setPage = function(pageNo){
            angular.element('body').scope().startLoading("brandsManagerLoading");
            $scope.currentPage = pageNo;
            var params = {};
            params["page"] = pageNo;
            params["rows"] = $scope.currentSize;
            httpService.types_count().success(function(size){
                //console.log(size);
                $scope.totalItems = size;
                httpService.types_listByPage( params).success(function(data){
                    //console.log(data);
                    $scope.brandsList = data;
                }).error(function () {
                    console.log("concern error");
                });
            }).error(function () {
                console.log("concern error");
            }).finally(function(){
                angular.element('body').scope().finishLoading('brandsManagerLoading');
            });
        };
    }]);
