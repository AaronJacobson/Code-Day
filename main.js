var draw = function(){

}

var MY_VARS = function(){
    var globals = {
        URL : "http://someUrl",
        protocal : "blah";
    }
    return{ getUrl : function(s){
        return globals[s];
      }
    }
}();


var webSocket = function(){
 var socket = new webSocket(MY_VARS.getUrl('URL'), MY_VARS.getUrl('protocal');
}
