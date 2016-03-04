package org.rapidpm.event.miceoservices.startup.ee.embedded.wildfly;

import org.rapidpm.event.miceoservices.startup.ee.embedded.wildfly.rest.PeopleResource;
import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.jaxrs.JaxRsDeployment;

/**
 * Created by sven on 24.05.15.
 */
public class Main {

  private Main() {
  }

  public static void main(String[] args) {
    System.out.println("args = " + args);

    Container container = new Container();

//    container.subsystem(new MessagingFraction()
//            .server(
//                new MessagingServer()
//                    .enableInVmConnector()
//                    .topic("my-topic")
//                    .queue("my-queue")
//            )
//    );


    // Start the container
//    container.subsystem(new WeldFraction());
    try {
      container.start();


      JaxRsDeployment appDeployment = new JaxRsDeployment();
      appDeployment.addResource(PeopleResource.class);

      // Deploy your JAX-RS app
      container.deploy(appDeployment);
    } catch (Exception e) {
      System.out.println("e = " + e);
    }

    // Create an MSC deployment
//    ServiceDeployment deployment = new ServiceDeployment();
//    deployment.addService(new MyService("/jms/topic/my-topic" ) );

    // Deploy the services
//    container.deploy( deployment );
  }
}
