package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.interfaces.InstitutionService;
import pl.coderslab.charity.repository.InstitutionRepository;

@Service
public class InstitutionServiceImpl implements InstitutionService {

    private InstitutionRepository institutionRepository;

    public InstitutionServiceImpl(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }
}
