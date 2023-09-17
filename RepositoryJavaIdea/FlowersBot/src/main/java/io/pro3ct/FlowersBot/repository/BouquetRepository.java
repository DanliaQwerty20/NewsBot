package io.pro3ct.FlowersBot.repository;

import io.pro3ct.FlowersBot.model.Bouquet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BouquetRepository extends CrudRepository<Bouquet,Long> {
}
