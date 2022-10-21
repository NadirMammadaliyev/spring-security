package az.nadir.restapi.service.impl;

import az.nadir.restapi.service.TokenAuthenticationService;
import az.nadir.restapi.util.Utilities;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TokenAuthenticationServiceImpl implements TokenAuthenticationService {

    @Override
    public Boolean hasAccess(String token) {
        Claims claims =
                Jwts.parser()
                        .setSigningKey(Utilities.Token.SECRET)
                        .parseClaimsJws(token.replace(Utilities.Token.TOKEN_PREFIX, ""))
                        .getBody();
        System.out.println(claims);
        log.info("hasAccess claims: {}", claims);
        return true;
    }
}
