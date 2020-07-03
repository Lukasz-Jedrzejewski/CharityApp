package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    boolean existsCategoryByName(String name);

    @Modifying
    @Transactional
    @Query(value = "update donations_categories set categories_id = null where categories_id = :id", nativeQuery = true)
    int setCategoryIdToNull(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value = "alter table donations_categories modify categories_id BIGINT NULL", nativeQuery = true)
    void setNullable();
}
