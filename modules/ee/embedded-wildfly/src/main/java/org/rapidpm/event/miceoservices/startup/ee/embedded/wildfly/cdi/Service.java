package org.rapidpm.event.miceoservices.startup.ee.embedded.wildfly.cdi;

import java.time.LocalDateTime;

/**
 * Created by sven on 24.05.15.
 */
public class Service {

  public String doWork() {
    return LocalDateTime.now().toString();
  }

}
