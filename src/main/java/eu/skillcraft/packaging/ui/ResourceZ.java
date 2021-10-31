package eu.skillcraft.packaging.ui;

import eu.skillcraft.packaging.businessModuleC.ServiceC;
import org.springframework.web.bind.annotation.RestController;

@RestController("/ResourceX/{id}/ResourceZ")
public class ResourceZ {

  private final ServiceC serviceC;

  public ResourceZ(ServiceC serviceC) {
    this.serviceC = serviceC;
  }


}
