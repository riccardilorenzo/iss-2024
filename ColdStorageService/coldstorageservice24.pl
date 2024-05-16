%====================================================================================
% coldstorageservice24 description   
%====================================================================================
request( store, store(KG) ).
reply( storeAccepted, storeAccepted(TICKET) ). %%for store | ticket N intero identificativo
reply( storeRejected, storeRejected(REASON) ).  %%for store
request( load, load(KG) ).
%====================================================================================
context(ctxlocal, "localhost",  "TCP", "8080").
 qactor( coldstorageservice, ctxlocal, "it.unibo.coldstorageservice.Coldstorageservice").
 static(coldstorageservice).
  qactor( drivermock, ctxlocal, "it.unibo.drivermock.Drivermock").
 static(drivermock).
