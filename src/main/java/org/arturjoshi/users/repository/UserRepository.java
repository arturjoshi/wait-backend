package org.arturjoshi.users.repository;

import org.arturjoshi.users.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;
import java.util.Set;

@RepositoryRestResource(path = "people")
public interface UserRepository extends CrudRepository<User, Long> {
    @RestResource(exported = false)
    List<User> findByUsernameContainingIgnoreCase(@Param("username") String username);

    @RestResource(exported = false)
    List<User> findByPhonenumberContaining(@Param("phonenumber") String phonenumber);

    @Override
    @RestResource(exported = false)
    public User save(User user);

    @Override
    @RestResource(exported = false)
    public void delete(User user);

    @Override
    @RestResource(exported = false)
    public void delete(Long id);

    @Override
    @RestResource(exported = false)
    public void deleteAll();
}