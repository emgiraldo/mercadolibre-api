# mercadolibre-api

This is basic example for interacting with Mercadolibre API. The project shows the following features:

- Consuming Mercadolibre REST API Services without SDK: The projects adds a middle integration layer based on services, each service is domain-specific accoding to Mercadolibre. This layer also includes domain specific components like messages constants, dtos and utilities. 
- Generic Rest consumer service based on Spring RestTemplate: A generic Rest consumer service was created for querying Mercadolibre API, it is based on Spring and uses a based generic domain interface for defining the signature of the client, and an specific spring implementation.
- Java SDK for Authorization: The project also uses Meli Java SDK ([Mercadolibre Java SDK](http://developers.mercadolibre.com/java-sdk/) for authorization and validation access for specific methods, in this case, for listing an item. Please keep in mind that up to now the redirect url is generated from a java class, so it is necessary to manually copy it and past it on the browser for authorize the App, after that, it will redirect to localhost:8080/mercadolibre/callback. It is used also for getting the access token after the authorization is made.
- Spring Rest functionality: The project is based on Spring, so, it uses its core concepts like bean injection, classpatch scanning for stereotype definition in each layer (Services and Controllers), properties injection.
- Maven Project: This project is based on a basic archetype for web app.
- Bootstrap Front-End: It uses a basic Bootstrap definition for the UI. The connection to the backend is made in two different ways: (1) Calling project backend services for categories, listing types and list item, (2) Calling mercadolibre REST API Service directly for currencies. The associated dependencies are accessed by CDN.

The project is still missing to complete the procedure for authorization and publishing an item.

# instructions
1. Simple clone the project in your favorite IDE or directly to your filesystem
2. Run mvn clean install for cleaning, updating dependencies and generating a the final artifact
3. Deploy in your favorite Web or App container, manually or from your IDE.
4. Go into http://localhost:8080/mercadolibre/index.html

# structure

# backend
**com.emgiraldo.mercadolibre.service**: Contains the middle domain specific services for interacting with Mercadolibre API and the basic generic rest service client. It also contains components and utilites for each service (DTOs, Enums, Constants)

**com.emgiraldo.mercadolibre.controller**: Contains the project specific services for the FrontEnd and the Callback REST Service for receiving the client after authorizating the app.

**com.emgiraldo.mercadolibre.site.util**: Contains generic enum for Countries and java standalone class for getting the redirect URL.

# frontend
**webapp/js**: Project specific javascript files

**webapp/css**: Project specific css files

# suggestions

Mercadolibre highly suggests to use its SDK, so do I, the main idea of the project is to offer a general integration example from a common framework with Mercadolibre by using a raw rest consume process for its REST Services, and also, use Meli Java SDK for an specific function. Please refer to [Authentication](http://developers.mercadolibre.com/authentication-and-authorization/).

