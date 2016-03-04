package org.rapidpm.event.miceoservices.startup.ee.embedded.tomee.service.soap;

import javax.jws.WebService;

/**
 * Created by sven on 22.05.15.
 */
@WebService(targetNamespace = "http://rapidpm.org/wsdl")
public interface PeopleWS {
  String doWorkA();

  String doWorkB(String txt);
}
