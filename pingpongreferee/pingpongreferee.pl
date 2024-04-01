%====================================================================================
% pingpongreferee description   
%====================================================================================
dispatch( ping, ping(N) ).
dispatch( pong, pong(N) ).
event( connected, connected(N) ).
event( start, start(N) ).
event( end, end(N) ).
%====================================================================================
context(ctxdef, "localhost",  "TCP", "8015").
 qactor( pinger, ctxdef, "it.unibo.pinger.Pinger").
 static(pinger).
  qactor( ponger, ctxdef, "it.unibo.ponger.Ponger").
 static(ponger).
  qactor( referee, ctxdef, "it.unibo.referee.Referee").
 static(referee).
