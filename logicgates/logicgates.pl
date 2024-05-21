%====================================================================================
% logicgates description   
%====================================================================================
dispatch( signals, signals(F,S) ).
%====================================================================================
context(ctxlocal, "localhost",  "TCP", "8123").
 qactor( nor, ctxlocal, "it.unibo.nor.Nor").
 static(nor).
  qactor( controller, ctxlocal, "it.unibo.controller.Controller").
 static(controller).
