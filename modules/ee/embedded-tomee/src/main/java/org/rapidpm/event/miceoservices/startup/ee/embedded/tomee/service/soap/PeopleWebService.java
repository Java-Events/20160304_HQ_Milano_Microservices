package org.rapidpm.event.miceoservices.startup.ee.embedded.tomee.service.soap;

import org.rapidpm.event.miceoservices.startup.ee.embedded.tomee.service.cdi.Service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import java.time.LocalDateTime;

/**
 * Created by sven on 22.05.15.
 */
@WebService(
    portName = "PeoplePort",
    serviceName = "PeopleWebService",
    targetNamespace = "http://rapidpm.org/wsdl",
    endpointInterface = "org.rapidpm.event.miceoservices.startup.ee.embedded.tomee.service.soap.PeopleWS"
)
@Stateless
public class PeopleWebService implements PeopleWS {


//  @Inject Service service;
  @Inject Service service = new Service();

  @Override
  public String doWorkA() {
    Byte[] bytes = new Byte[1_000_000];
    return "doWorkA" + bytes.length + service.doWork();
  }

  @Override
  public String doWorkB(String txt) {
    return txt + " worked on " + LocalDateTime.now().toString();
  }
}
