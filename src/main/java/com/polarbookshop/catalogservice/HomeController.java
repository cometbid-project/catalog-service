/**
 * 
 */
package com.polarbookshop.catalogservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.polarbookshop.catalogservice.config.PolarProperties;

/**
 * @author Gbenga
 *
 */
@RestController
public class HomeController {

  private final PolarProperties polarProperties;

  public HomeController(PolarProperties polarProperties) {
    this.polarProperties = polarProperties;
  }

  @GetMapping("/")
  public String getGreeting() {
    return polarProperties.getGreeting();
  }

}
