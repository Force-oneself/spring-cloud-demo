package pers.quan.cloud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pers.quan.cloud.po.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, String> {

}