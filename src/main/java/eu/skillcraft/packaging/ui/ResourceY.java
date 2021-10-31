package eu.skillcraft.packaging.ui;

import eu.skillcraft.packaging.businessModuleB.ServiceB;
import org.springframework.web.bind.annotation.RestController;

@RestController("ResourceY")
public class ResourceY {
  private final ServiceB serviceB;

  public ResourceY(ServiceB serviceB) {
    this.serviceB = serviceB;
  }
}
