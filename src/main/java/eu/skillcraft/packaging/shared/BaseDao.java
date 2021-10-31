package eu.skillcraft.packaging.shared;

import java.util.Optional;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface BaseDao <R, ID> extends Repository<R, ID> {
  Optional<R> findById(ID id);

  <S extends R> S save(S entity);
}
