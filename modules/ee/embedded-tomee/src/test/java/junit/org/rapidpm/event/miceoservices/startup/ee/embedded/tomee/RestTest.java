package junit.org.rapidpm.event.miceoservices.startup.ee.embedded.tomee;

import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sven on 28.05.15.
 */

//@EnableServices(value = "jaxrs")
//@RunWith(ApplicationComposer.class)
public class RestTest {


  @BeforeClass
  public static void setUp() throws Exception {
    Map<String, String> properties = new HashMap<>();
    properties.put("httpejbd.print", "true");
    properties.put("httpejbd.indent.xml", "true");
    properties.put("openejb.embedded.remotable", "true");
    EJBContainer.createEJBContainer(properties);
  }


  @Test
  public void get() throws IOException {
    final String message = WebClient
        .create("http://127.0.0.1:4204")
        .path("/embedded-tomee/people/master")
        .get(String.class);
    Assert.assertEquals("{\"name\":\"Christian - Service used\"}", message);
  }

  @Test
  public void post() throws IOException {
    final String message = WebClient
        .create("http://localhost:4204")
        .path("/embedded-tomee/people/masterpost")
        .post("Hi REST!", String.class);
    Assert.assertEquals("{\"name\":\"Christian - Hi REST!Service used\"}", message);
  }
}
