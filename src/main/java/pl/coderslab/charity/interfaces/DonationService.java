package pl.coderslab.charity.interfaces;

import pl.coderslab.charity.entity.Donation;

public interface DonationService {
    Integer getBagQuantity();
    int getDonationQuantity();
    void save(Donation donation);
}
