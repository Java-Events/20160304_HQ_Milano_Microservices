package org.rapidpm.event.miceoservices.startup.ee.embedded.tomee;

import org.apache.openejb.testing.ApplicationComposers;
import org.apache.openejb.testing.Classes;
import org.apache.openejb.testing.EnableServices;
import org.rapidpm.event.miceoservices.startup.ee.embedded.tomee.service.cdi.Service;
import org.rapidpm.event.miceoservices.startup.ee.embedded.tomee.service.rest.PeopleResource;
import org.rapidpm.event.miceoservices.startup.ee.embedded.tomee.service.servlet.MessageServlet;
import org.rapidpm.event.miceoservices.startup.ee.embedded.tomee.service.soap.PeopleWebService;

/**
 * Copyright (C) 2010 RapidPM
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Created by RapidPM - Team on 02.03.16.
 */
@EnableServices(jaxws = true, jaxrs = true, httpDebug = false)
@Classes(context = "/", value = {
    PeopleResource.class,
    PeopleWebService.class,
    MessageServlet.class,
    Service.class})
//@Classes(context = "/", value = {PeopleResource.class, PeopleWebService.class})
public class MyApp {
  public static void main(final String[] args) {
    System.out.println("args = " + args);
    ApplicationComposers.run(MyApp.class, args);
  }

}
