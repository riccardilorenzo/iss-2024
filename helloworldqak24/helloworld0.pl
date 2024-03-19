%====================================================================================
% helloworld0 description   
%====================================================================================
dispatch( info, info(N) ). %commento
%====================================================================================
context(ctxhello, "localhost",  "TCP", "8000").
 qactor( display, ctxhello, "it.unibo.display.Display").
 static(display).
  qactor( worker, ctxhello, "it.unibo.worker.Worker").
 static(worker).
