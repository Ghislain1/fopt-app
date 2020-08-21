welche code

Object obj=...

String methodName= ...

Object[] actualParameterList = ..

Class[] formalParameterList = new Class[actualParameterList.length]


welche methode
Class c = obj.getClass();
Method m = c.getMethod(methodeName, formalParameterList)

Object result = m.invoke(obj, actualParameterList)


welche Funktion:
The skeleton is an object, acts as a gateway for the server side object. 
Skeleton verbindung und auftrag entgegennehmen.

All the incoming requests are routed through it. 
When the skeleton receives the incoming request, 
it does the following tasks:

It reads the parameter for the remote method
It invokes the method on the actual remote object, and
It writes and transmits (marshals) the result to the caller.