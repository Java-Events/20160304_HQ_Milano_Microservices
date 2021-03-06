package junit.org.rapidpm.event.miceoservices.startup.rapidpm;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.rapidpm.event.miceoservices.startup.rapidpm.Resource;
import org.rapidpm.microservice.Main;
import org.rapidpm.microservice.test.PortUtils;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

/**
 * Copyright (C) 2015 RapidPM
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
 * Created by RapidPM - Team on 04.03.16.
 */
public class ResourceTest extends BasicRestTest {

  @BeforeClass
  public static void setUpClass() {
    System.setProperty(Main.REST_PORT_PROPERTY, new PortUtils().nextFreePortForTest() + "");
    System.setProperty(Main.SERVLET_PORT_PROPERTY, new PortUtils().nextFreePortForTest() + "");
  }

  @Test
  public void testApplicationPath() throws Exception {
    Client client = ClientBuilder.newClient();
    final String generateBasicReqURL = generateBasicReqURL(Resource.class);
    System.out.println("generateBasicReqURL = " + generateBasicReqURL);
    String val = client
        .target(generateBasicReqURL)
        .request()
        .get(String.class);
    System.out.println("val = " + val);
    Assert.assertEquals("Hello Rest World CDI Service", val);
    client.close();
  }


}
