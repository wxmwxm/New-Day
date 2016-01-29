/**
 * Created by Mr.Wu on 2015/12/11.
 */
console.log("login.js------------");
function LoginSubmit(){
    console.log("LoginSubmit------");
    try{
        $("#dayLogin_form").ajaxSubmit(function(data){
            var obj = eval('(' + data + ')');
            if(obj.errorCode=='0') {
                self.location='#/main';
            } else {
                alert(obj);
                //$("#verifyImg").trigger("click");
                //$("#validateCode").val('');
                //$("#validateCode").focus();
            }
        });
    }catch (e){
        console.log(e);
    }
    return false;
}
