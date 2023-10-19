package injectionDependency;

import dto.RegisterRecord;
import dto.SignInRecord;
import page.RegisterPage;
import page.SingInPage;
import steps.Hook;

import java.security.Signature;

public class InjectionStart {

    // Inyecciones de PicoContainer
    public SignInRecord signInRecord;
    public RegisterRecord registerRecord;
    public SingInPage singInPage;
    public RegisterPage registerPage;


}
