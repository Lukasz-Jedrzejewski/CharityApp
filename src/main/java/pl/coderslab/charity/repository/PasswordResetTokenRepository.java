package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.entity.PasswordResetToken;
import pl.coderslab.charity.entity.VerificationToken;

@Repository
public interface PasswordResetTokenRepository extends JpaRepository<VerificationToken, Long> {
    PasswordResetToken findByToken(String token);

    @Modifying
    @Transactional
    @Query(value = "delete from PasswordResetToken p where p.user.id = :id")
    void deleteByUserId(@Param("id") long id);
}
