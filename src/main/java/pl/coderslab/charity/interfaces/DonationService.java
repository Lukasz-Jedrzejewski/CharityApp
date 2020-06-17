package pl.coderslab.charity.interfaces;

import pl.coderslab.charity.entity.Donation;

public interface DonationService {
    int getBagQuantity();
    int getDonationQuantity();
    void save(Donation donation);
}
