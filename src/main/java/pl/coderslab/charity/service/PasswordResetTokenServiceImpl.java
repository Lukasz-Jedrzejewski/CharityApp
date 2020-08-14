package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.PasswordResetToken;
import pl.coderslab.charity.interfaces.PasswordResetTokenService;
import pl.coderslab.charity.repository.PasswordResetTokenRepository;

@Service
public class PasswordResetTokenServiceImpl implements PasswordResetTokenService {

    private final PasswordResetTokenRepository passwordResetTokenRepository;

    public PasswordResetTokenServiceImpl(PasswordResetTokenRepository passwordResetTokenRepository) {
        this.passwordResetTokenRepository = passwordResetTokenRepository;
    }

    @Override
    public PasswordResetToken findToken(String token) {
        return passwordResetTokenRepository.findByToken(token);
    }

    @Override
    public void save(PasswordResetToken passwordResetToken) {
        passwordResetTokenRepository.save(passwordResetToken);
    }

    @Override
    public void deleteByUserId(long id) {
        passwordResetTokenRepository.deleteByUserId(id);
    }
}
