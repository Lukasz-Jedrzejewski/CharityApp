package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.entity.Donation;

import java.util.List;
import java.util.Optional;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query("select count (d) from Donation d")
    int getDonationQuantity();

    @Query("select sum(d.quantity) from Donation d ")
    Optional<Integer> getBagQuantity();

    @Query("select d from Donation d where d.user.id=:id order by d.picked ASC, d.pickUpDate ASC, d.created ASC")
    List<Donation> findUserDonations(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value = "update Donation d set d.institution.id = null where d.institution.id = :id")
    int setInstitutionIdToNull(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value = "update Donation d set d.user.id = null where d.user.id = :id")
    int setUserIdToNull(@Param("id") long id);
}
