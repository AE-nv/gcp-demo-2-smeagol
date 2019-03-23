# Smeagol
Part 2 of the Google Cloud Platform demo for the [TA evening session #6](https://aewiki.atlassian.net/wiki/spaces/KEN/pages/164593724/TA+Avondsessie+2017+6+Google+Cloud+DORA+Devops) on 14/12/2017.
This part demonstrates 
- how to deploy applications to **Google App Engine Flex**, 
- how to work with **Google Cloud SQL**,
- how to work with **Cloud Functions**,
- how to work with **Google Pub/Sub**

## Context
Webshop bael.com wants to assess the customer satisfaction of its visitors after customers have placed an order.
In part 1 we created a message board on which customers can place comments on their experience in the webshop.
For part 2, we will create mock client of our webshop, called Smeagol.

A couple of characteristics:
- Smeagol is bipolar: he can be angry (Gollom) and he can be happy (Smeagol)
- Gollom publishes angry quotes
- Smeagol publishes happy quotes
- We can change Smeagol-Gollom ratio in the Google App Engine UI
- Smeagol/Gollom quotes are published to the Maessage Board and processed as any other quote

## Solution
We will create an application with the following components:
- a Spring (Java) backend on Google App Engine Flex,
- two Google Cloud SQL databases,
- a Google Pub/Sub topic,
- an Angular front end

### Spring (Java) backend on Google App Engine Flex
For the backend, we will use a Spring Boot application running on Google App Engine Flex, exposing
a webservice that returns returns random quotes from the connected database.

Two versions of this application will be running: 
- one that's connected to a database of Smeagol quotes and
- one that's connected to a database of Gollom quotes.

The connected database can be configured in the application.properties file.

Quotes that are fetched from the /quote endpoint are also published on a Pub/Sub topic, so they can
be processed by subscribers.


### Angular front end
The front end is written in Angular and can be found in /src/main/resources/static. This folder contains the build
of the angular project smeagol-front. More details about the front end can be found in this project.

## Setup
### Create Google App Engine Flex project
TODO

### Create 2 Cloud SQL DB's

### Configure application to use the correct DB's

### Enable the necessary APIs
In order for this application to function properly, the following APIs need to be enabled in your project:
- TODO

There is a [dashboard](https://console.cloud.google.com/apis/dashboard) available for your enabled APIs.

## Deploying to Google App Engine Flex
TODO

## Dependencies
TODO

### @google-cloud/pubsub
Modules provided by Google to simplify working with Google Cloud APIs like Natural Language API and PubSub.
PubSub is not necessary for this part of the demo, but is added due to modifications for later parts of the demo.
