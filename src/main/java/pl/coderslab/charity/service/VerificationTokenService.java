package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.VerificationToken;

public interface VerificationTokenService {
    VerificationToken findToken(String token);
    void save(VerificationToken verificationToken);
    void deleteByUserId(long id);
}
