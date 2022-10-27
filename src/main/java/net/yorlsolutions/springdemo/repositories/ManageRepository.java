package net.yorlsolutions.springdemo.repositories;

import net.yorlsolutions.springdemo.models.Manager;
import org.springframework.data.repository.CrudRepository;

public interface ManageRepository extends CrudRepository<Manager, Long> {
}
