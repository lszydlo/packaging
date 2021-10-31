package eu.skillcraft.packaging.shared;

import eu.skillcraft.packaging.shared.messages.DomainEvent;

public interface AuditDao {

  void append(DomainEvent domainEvent);

}
