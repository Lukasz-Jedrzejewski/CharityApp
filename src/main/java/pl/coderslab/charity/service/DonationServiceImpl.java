package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.interfaces.DonationService;
import pl.coderslab.charity.repository.DonationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DonationServiceImpl implements DonationService {

    private DonationRepository donationRepository;

    public DonationServiceImpl(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @Override
    public Integer getBagQuantity() {
        Optional<Integer> bags = donationRepository.getBagQuantity();
        if (bags.isPresent()) {
            return bags.get();
        } else {
            return 0;
        }
    }

    @Override
    public int getDonationQuantity() {
        int donations = donationRepository.getDonationQuantity();
        return donations;
    }

    @Override
    public void save(Donation donation) {
        donationRepository.save(donation);
    }

    @Override
    public List<Donation> findUserDonations(long id) {
        return donationRepository.findUserDonations(id);
    }

    @Override
    public Donation getOne(long id) {
        return donationRepository.getOne(id);
    }

    @Override
    public List<Donation> findAll() {
        return donationRepository.findAll();
    }
}
