%====================================================================================
% ledsystem description   
%====================================================================================
event( ledon, ledon(N) ).
event( ledoff, ledoff(N) ).
%====================================================================================
context(ctxled, "localhost",  "TCP", "8815").
 qactor( ledusage, ctxled, "it.unibo.ledusage.Ledusage").
 static(ledusage).
  qactor( led, ctxled, "it.unibo.led.Led").
 static(led).
