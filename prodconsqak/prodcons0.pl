%====================================================================================
% prodcons0 description   
%====================================================================================
dispatch( info, info(N) ).
request( myreq, myreq(N) ).
reply( rep, rep(N) ).  %%for myreq
%====================================================================================
context(ctxcustom, "localhost",  "TCP", "8000").
 qactor( consumer, ctxcustom, "it.unibo.consumer.Consumer").
 static(consumer).
  qactor( producer1, ctxcustom, "it.unibo.producer1.Producer1").
 static(producer1).
  qactor( producer2, ctxcustom, "it.unibo.producer2.Producer2").
 static(producer2).
