%====================================================================================
% synchservice description   
%====================================================================================
request( dojob, dojob(N) ).
%====================================================================================
context(ctx, "localhost",  "TCP", "8015").
 qactor( calculator, ctx, "it.unibo.calculator.Calculator").
 static(calculator).
  qactor( client, ctx, "it.unibo.client.Client").
 static(client).
