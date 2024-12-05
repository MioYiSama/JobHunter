package top.mioyi.services.auth.services;

import top.mioyi.requests.auth.LoginRequest;
import top.mioyi.requests.auth.SignupRequest;
import top.mioyi.responses.auth.LoginResponse;
import top.mioyi.responses.auth.SignupResponse;

public interface AuthService {
    LoginResponse login(LoginRequest request);

    SignupResponse signup(SignupRequest request);

    boolean logout(String header);
}
