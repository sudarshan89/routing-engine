# routing-engine
==
A opinionated implementation of a [Content-Based-Router] (http://www.enterpriseintegrationpatterns.com/patterns/messaging/ContentBasedRouter.html)

This implementation executes routing criteria and selects a matching endpoint to which the request should be routed.

As a user of the library you create a route register like the below

IRoutesRegister routesRegister = RoutesRegister.newRegister()
                .addRoute(newRoute(huonEndpoint, new SoapActionCriteria("simpleHUONSOAPAction")))
                .addRoute(newRoute(exigenEndpoint, new SoapActionCriteria("simpleExigenSOAPAction")));
                
A router register holds multiple routes where each route is composed of an endpoint and a criteria.
                
When a request is received by the library it uses the routes register to determine the criteria which is satisfies this request
and returns the corresponding the endpoint.

Example routes configuration can be found in the tests [here] (https://github.com/sudarshan89/routing-engine/blob/master/src/test/java/nz/co/iag/engine/SimpleRoutingEngineTest.java)
                
![Routing Engine in a picture](https://raw.github.com/sudarshan89/routing-engine/images/routing-engine.png?raw=true "Routing Engine")                 
