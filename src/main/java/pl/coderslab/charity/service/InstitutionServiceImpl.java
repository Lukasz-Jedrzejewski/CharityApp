package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.interfaces.InstitutionService;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;

@Service
public class InstitutionServiceImpl implements InstitutionService {

    private InstitutionRepository institutionRepository;

    public InstitutionServiceImpl(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @Override
    public List<Institution> findAll() {
        return institutionRepository.findAll();
    }

    @Override
    public void delete(long id) {
        institutionRepository.delete(getOne(id));
    }

    @Override
    public Institution getOne(long id) {
        return institutionRepository.getOne(id);
    }

    @Override
    public void save(Institution institution) {
        institutionRepository.save(institution);
    }
}
