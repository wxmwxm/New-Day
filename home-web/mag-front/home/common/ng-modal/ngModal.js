'use strict'
angular.module('dayApp').controller('ngModalController', ['$scope', 'data',
  function ($scope, data) {
    $scope.data = data;
}]).factory('ngModal', [
    '$uibModal',
    function($uibModal){
        return {
            showEmsModal: function(modalUrl,modalData){ //modalUrl:弹出框页面url   modalData：出入弹出框的数据
                return $uibModal.open({
                    animation: true,
                    templateUrl: modalUrl,
                    controller: 'ngModalController',
                    resolve: {
                        data: function(){
                            return modalData;
                        }
                    }
                });
            },
            showEmsCustomModal: function(title,msg, buttons){  //title:弹出框标题  msg：弹出框信息 buttons：弹出框按钮数组[{name:;'按钮显示名称',result:'按钮触发判读值'}]
                return $uibModal.open({
                    animation: true,
                    templateUrl: 'home/common/ng-modal/ngModal.html',
                    controller: 'ngModalController',
                    resolve: {
                        data: function(){
                            return {title:title,msg:msg,buttons:buttons};
                        }
                    }
                });
            },
            showEmsInfoModal: function(title,msg){//title:弹出框标题  msg：弹出框信息
                return $uibModal.open({
                    animation: true,
                    templateUrl: 'home/common/ng-modal/ngModal.html',
                    controller: 'ngModalController',
                    resolve: {
                        data: function(){
                            return {title:title,msg:msg,buttons:[{name:'确定',result:'ok'}]};
                        }
                    }
                });
            },
            showEmsConfirmModal: function(title,msg){//title:弹出框标题  msg：弹出框信息
                return $uibModal.open({
                    animation: true,
                    templateUrl: 'home/common/ng-modal/ngModal.html',
                    controller: 'ngModalController',
                    resolve: {
                        data: function(){
                            return {title:title,msg:msg,buttons:[{name:'确定',result:'ok'},{name:'取消',result:'cancel'}]};
                        }
                    }
                });
            },
            showEmsDivModal: function(title,modalUrl){//title:弹出框标题  modalUrl：弹出框信息的html
                return $uibModal.open({
                    animation: true,
                    templateUrl: 'home/common/ng-modal/ngModal.html',
                    controller: 'ngModalController',
                    resolve: {
                        data: function(){
                            return {title:title,url:modalUrl,buttons:[{name:'确定',result:'ok'}]};
                        }
                    }
                });
            }
        };
    }
]);
/**
 *
 var title="信息提示";
 var msg="确认要删除吗？";
 ngModal.showEmsConfirmModal(title,msg).result.then(
 function(clickValue) {
                console.log(clickValue);
                if (clickValue && clickValue == "ok") {
                }
            }
 );
 **/