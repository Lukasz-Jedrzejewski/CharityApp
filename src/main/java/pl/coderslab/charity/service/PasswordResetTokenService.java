package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.PasswordResetToken;

public interface PasswordResetTokenService {
    PasswordResetToken findToken(String token);
    void save(PasswordResetToken passwordResetToken);
    void deleteByUserId(long id);
}
