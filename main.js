var draw = function(){

  //window is 601,750
  var c = document.getElementById("myCanvas");
  var ctx = c.getContext("2d");

  ctx.fillRect(99,174,403,403);

  ctx.beginPath();
  ctx.moveTo(199,174);
  ctx.lineTo(199,577);
  ctx.moveTo(299,174);
  ctx.lineTo(299,577);
  ctx.moveTo(399,174);
  ctx.lineTo(399,577);


  ctf.fillStyle("#00008F");
  ctx.arc(150,100,100,0,Math.PI*2,true);
  ctf.fill();
  ctx.arc(300,100,100,0,Math.PI*2,true);
  ctf.fill();
  ctx.arc(450,100,100,0,Math.PI*2,true);
  ctf.fill();

  //#A30000 p2 red
  ctf.fillStyle("#A30000");
  ctx.arc(150,650,100,0,Math.PI*2,true);
  ctf.fill();
  ctx.arc(300,650,100,0,Math.PI*2,true);
  ctf.fill();
  ctx.arc(450,650,100,0,Math.PI*2,true);
  ctf.fill();


  //context.arc(x,y,r,sAngle,eAngle,counterclockwise);
  //ctx.arc(225,150,50,0,Math.PI*2,true);

  // for(var x= 0; x<= 3; x++){
  //   for(var y =0 ; y<= 3; y++){
  //   }
  // }

}

// function WebSocketTest()
// {
//   if("webSocket" in window){
//     url = "a url"
//     protocal = "tcp"
//     ws = new webSocket(url, protocal);
//     ws.onopen = onSocketConnected();
//     ws.onclose = onSocketDisconnect();
//     ws.onmessage = onSocketMessage();
//     ws.onerror = onSocketError();


//     ws.send("hi i work");


//        // Socket message
//       function onSocketMessage(message) {
//           console.log('Message: ' + message.data);
//       };

//       // Socket error
//       function onSocketError(error) {
//           console.log('Error: ' + error.data);
//       };

//       // Socket connected
//       function onSocketConnected() {
//           console.log("Connected to socket server");
//       };

//       // Socket disconnected
//       function onSocketDisconnect() {
//           console.log("Disconnected from socket server");
//       };

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
  // }

//}
