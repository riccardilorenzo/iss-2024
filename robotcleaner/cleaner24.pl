%====================================================================================
% cleaner24 description   
%====================================================================================
dispatch( cmd, cmd(MOVE) ).
request( step, step(TIME) ).
reply( stepdone, stepdone(R) ).  %%for step
reply( stepfailed, stepfailed(T,CAUSE) ).  %%for step
%====================================================================================
context(ctxcleaner24, "localhost",  "TCP", "8032").
 qactor( robot, ctxcleaner24, "it.unibo.robot.Robot").
 static(robot).
  qactor( cleaner24, ctxcleaner24, "it.unibo.cleaner24.Cleaner24").
 static(cleaner24).
