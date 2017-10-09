package br.com.pedront.expensemanager.core.repository;

import br.com.pedront.expensemanager.core.entity.EarnEntity;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EarnRepository extends MongoRepository<EarnEntity, String> {

    public List<EarnEntity> findByUser(String user);

}
