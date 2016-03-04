package org.rapidpm.event.miceoservices.startup.ee.embedded.wildfly.rest;


import org.rapidpm.event.miceoservices.startup.ee.embedded.wildfly.cdi.Service;
import org.rapidpm.event.miceoservices.startup.ee.embedded.wildfly.model.Person;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by sven on 22.05.15.
 */
@Path("/people")
@Produces(MediaType.APPLICATION_JSON)
public class PeopleResource {

  @Inject Service service;


  @GET
  @Path("master")
  public Person master() {
//    return new Person("Christian - " + beanmanager.service.doWork());
    System.out.println("service = " + service);
    return new Person("Christian - ");
  }

  @GET
  @Path("student")
  public Person student() {
    return new Person("Ana");
  }
}
