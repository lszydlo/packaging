package eu.skillcraft.packaging.ui;

import eu.skillcraft.packaging.businessModuleA.AService;
import eu.skillcraft.packaging.businessModuleC.ServiceC;
import org.springframework.web.bind.annotation.RestController;

@RestController("/ResourceX")
public class ResourceX {

  private final ServiceC serviceC;
  private final AService AService;

  public ResourceX(ServiceC serviceC, AService AService) {
    this.serviceC = serviceC;
    this.AService = AService;
  }
}
