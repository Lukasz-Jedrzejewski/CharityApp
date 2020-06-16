package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.interfaces.DonationService;
import pl.coderslab.charity.repository.DonationRepository;

import java.util.List;

@Service
public class DonationServiceImpl implements DonationService {

    private DonationRepository donationRepository;

    public DonationServiceImpl(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @Override
    public int getBagQuantity() {
        int bags = 0;
        List<Donation> allBags = donationRepository.findAll();
        for (Donation bag : allBags) {
            bags += bag.getQuantity();
        }
        return bags;
    }

    @Override
    public int getDonationQuantity() {
        int donations = donationRepository.findAll().size();
        return donations;
    }
}
