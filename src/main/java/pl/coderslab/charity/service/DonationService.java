package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.Donation;

import java.util.List;

public interface DonationService {
    Integer getBagQuantity();
    int getDonationQuantity();
    void save(Donation donation);
    List<Donation> findUserDonations(long id);
    Donation getOne(long id);
    List<Donation> findAll();
    void changeIdToNull(long id);
    void changeUserIdToNull(long id);
}
