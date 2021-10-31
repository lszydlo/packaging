package eu.skillcraft.packaging.businessModuleA;

import eu.skillcraft.packaging.businessModuleA.AService.AAggregate;
import eu.skillcraft.packaging.shared.id.AID;
import eu.skillcraft.packaging.shared.AuditDao;
import eu.skillcraft.packaging.shared.BaseDao;
import eu.skillcraft.packaging.shared.messages.DomainEvent;
import java.util.UUID;
import java.util.function.Function;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
@Transactional
public class ARepo {

  private ADao aDao;
  private AuditDao auditDao;

  void apply(AID aggregateId, Function<AAggregate, DomainEvent> function) {
    ARecord aRecord = aDao.findById(aggregateId.uuid()).orElse(new ARecord(aggregateId.uuid()));
    DomainEvent domainEvent = function.apply(new AAggregate(aRecord));
    aRecord.apply(domainEvent);
    aDao.save(aRecord);
    auditDao.append(domainEvent);
  }

  static class ARecord {

    @Id
    private final UUID uuid;

    public ARecord(UUID uuid) {
      this.uuid = uuid;
    }

    public void apply(DomainEvent domainEvent) {
    }
  }

  interface ADao extends BaseDao<ARecord, UUID> {

  }
}
