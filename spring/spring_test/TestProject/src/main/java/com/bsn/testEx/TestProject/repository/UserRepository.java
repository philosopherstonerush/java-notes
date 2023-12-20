package com.bsn.testEx.TestProject.repository;
import com.bsn.testEx.TestProject.Entity.UserCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<UserCustom, Integer>, PagingAndSortingRepository<UserCustom, Integer> {

}
