package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);

    boolean existsRoleByName(String name);

    @Modifying
    @Transactional
    @Query(value = "delete from user_role where user_id = :id", nativeQuery = true)
    void deleteByUserId(@Param("id") long id);
}
