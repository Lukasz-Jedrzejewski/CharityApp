package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.interfaces.DonationService;
import pl.coderslab.charity.repository.DonationRepository;

@Service
public class DonationServiceImpl implements DonationService {

    private DonationRepository donationRepository;

    public DonationServiceImpl(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }
}
