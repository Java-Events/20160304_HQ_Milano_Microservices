package org.rapidpm.event.miceoservices.startup.ee.embedded.wildfly.model;

/**
 * Created by sven on 22.05.15.
 */
public class Person {

  private final String name;

  public Person(final String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
