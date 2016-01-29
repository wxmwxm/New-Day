/**
 * Created by Mr.Wu on 2015/12/31.
 */
angular.module('dayApp')
    .controller('goodsManagerController',['$scope','$http','httpService','ngModal','$element','Upload',
        function($scope,$http,httpService,ngModal,$element,Upload){
        console.log('goodsManagerController--------------');

        $scope.imagesList = [{id:0,url:''},{id:0},{id:0},{id:0}];
        $scope.maxSize = 5;  //显示多少页
        $scope.currentSize = 5; // 当前页多少条
        $scope.totalItems = 0;  // 总记录
        $scope.currentPage = 1; //当前页

        $scope.opt = false; //操作 true:add、edit
        $scope.goodsList = [];
        $scope.goods = {};
        $scope.simpleConfig = {
            //这里可以选择自己需要的工具按钮名称,此处仅选择如下五个
            toolbars:[
                ['fullscreen', 'source', 'undo', 'redo','bold', 'italic', 'underline', 'fontborder', 'strikethrough', 'superscript', 'subscript', 'removeformat', 'formatmatch',
                    'autotypeset', 'blockquote', 'pasteplain', '|', 'forecolor', 'backcolor', 'insertorderedlist', 'insertunorderedlist',
                    'selectall', 'cleardoc'
                ],
                [
                    'horizontal', 'date', 'time', '|', 'imagenone', 'imageleft', 'imageright', 'imagecenter', '|',
                    'simpleupload', 'insertimage', 'emotion', 'scrawl', 'insertvideo', 'music', 'attachment', 'background', 'snapscreen', 'spechars'
                ]
            ],
            wordCount:false,//关闭字数统计
            initialFrameWidth:870,//初始宽度
            initialFrameHeight: 220,//初始高度
            elementPathEnabled:false //关闭elementPath
        }
        $scope.content = 'Hello Ueditor';
        $scope.updateInfo = function(goods){
            $scope.opt = true;
            $scope.goods = goods;
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
            httpService.goods_count().success(function(size){
                $scope.totalItems = size;
                httpService.goods_listByPage( params).success(function(data){
                    console.log(JSON.stringify(data));
                    $scope.goodsList = data;
                }).error(function () {
                    console.log("concern error");
                });
            }).error(function () {
                console.log("concern error");
            }).finally(function(){
                angular.element('body').scope().finishLoading('goodsManagerLoading');
            });
        };
        $scope.onFileSelect = function($files) {    //$files: an array of files selected, each file has name, size, and type.
            for (var i = 0; i < $files.length; i++) {
                var file = $files[i];
                console.log('---------',file);
               /* $scope.upload = Upload.upload({
                    url: 'server/upload/url', //upload.php script, node.js route, or servlet url
                    //method: 'POST' or 'PUT',
                    //headers: {'header-key': 'header-value'},
                    //withCredentials: true,
                    data: {myObj: $scope.myModelObj},
                    file: file, // or list of files ($files) for html5 only
                    //fileName: 'doc.jpg' or ['1.jpg', '2.jpg', ...] // to modify the name of the file(s)
                    // customize file formData name ('Content-Disposition'), server side file variable name.
                    //fileFormDataName: myFile, //or a list of names for multiple files (html5). Default is 'file'
                    // customize how data is added to formData. See #40#issuecomment-28612000 for sample code
                    //formDataAppender: function(formData, key, val){}
                }).progress(function(evt) {        console.log('percent: ' + parseInt(100.0 * evt.loaded / evt.total));
                }).success(function(data, status, headers, config) {        // file is uploaded successfully
                    console.log(data);
                });      */
                //.error(...)
                //.then(success, error, progress);
                // access or attach event listeners to the underlying XMLHttpRequest.
                //.xhr(function(xhr){xhr.upload.addEventListener(...)})
            }    /* alternative way of uploading, send the file binary with the file's content-type.       Could be used to upload files to CouchDB, imgur, etc... html5 FileReader is needed.        It could also be used to monitor the progress of a normal http post/put request with large data*/
            // $scope.upload = $upload.http({...})  see 88#issuecomment-31366487 for sample code.
        };
        $scope.deleteUplodImage = function(index){
            $scope.imagesList[index] = {id:0};
        };
        $scope.openUplodImage = function(index){
            $element.find('#goodsManagerUploadImageModal').modal('show');
            //$scope.imagesList[index] = {id:index+1};
        };
        $scope.showInfoImageOpts = function($event){
            if($($event.target).hasClass("has-media"))
                $($event.target).parent().find(".operate").show();
        };
        $scope.hideInfoImageOpts = function($event){
            $($event.target).parent().find(".operate").hide();
        };
    }]);
