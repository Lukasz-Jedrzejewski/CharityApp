package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.entity.Donation;

import java.lang.annotation.Native;
import java.util.List;
import java.util.Optional;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query("select count (d) from Donation d")
    int getDonationQuantity();

    @Query("select sum(d.quantity) from Donation d ")
    Optional<Integer> getBagQuantity();

    @Query("select d from Donation d inner join d.user u where u.id=:id")
    List<Donation> findUserDonations(@Param("id") long id);
}
