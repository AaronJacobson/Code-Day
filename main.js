var url,
  protocal,
  ws;


var draw = function(){
  var canvas = new Canvas();
}

function WebSocketTest()
{
  if("webSocket" in window){
    ws = new webSocket(url, protocal);
    ws.onopen = onSocketConnected();
    ws.onclose = onSocketDisconnect();
    ws.onmessage = onSocketMessage();
    ws.onerror = onSocketError();

       // Socket message
      function onSocketMessage(message) {
          console.log('Message: ' + message.data);
      };

      // Socket error
      function onSocketError(error) {
          console.log('Error: ' + error.data);
      };

      // Socket connected
      function onSocketConnected() {
          console.log("Connected to socket server");
      };

      // Socket disconnected
      function onSocketDisconnect() {
          console.log("Disconnected from socket server");
      };

   //  ws.onopen = function()
   // {
   //    ws.send("Message to send");
   //    alert("package sent")
   //  };

   //  ws.onmessage = function (evt)
   //  {
   //    var received_msg = evt.data;
   //    alert("package is received...");
   //  };

   //  ws.onclose = function()
   //  {
   //    // websocket is closed.
   //    alert("Connection is closed...");
   //  };
  }

}
