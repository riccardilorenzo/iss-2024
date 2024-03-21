%====================================================================================
% prodcons0 description   
%====================================================================================
dispatch( info, info(N) ).
dispatch( short, short(N) ).
request( myreq, myreq(N) ).
reply( rep, ack(N) ).  %%for myreq
%====================================================================================
context(ctxcustom, "localhost",  "TCP", "8015").
 qactor( consumer, ctxcustom, "it.unibo.consumer.Consumer").
 static(consumer).
