package pl.coderslab.charity.interfaces;

import pl.coderslab.charity.entity.VerificationToken;

public interface VerificationTokenService {
    VerificationToken findToken(String token);
    void save(VerificationToken verificationToken);
}
