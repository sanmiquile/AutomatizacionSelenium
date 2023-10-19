package injectionDependency;

import dto.ConfigureRecord;
import dto.ObjetiveRecord;
import dto.SignInRecord;
import page.ConfigurarSMSPage;
import page.HomeBasePage;
import page.ObjetivoPage;
import page.SingInPage;
import steps.Hook;

public class InjectionHome {

    public SignInRecord signInRecord;
    public ConfigureRecord configureRecord;
    public ObjetiveRecord objetiveRecord;

    public String objetiveCode;
    public SingInPage singInPage;

    public ConfigurarSMSPage configurarSMSPage;

    public ObjetivoPage objetivoPage;

    public HomeBasePage homeBasePage;
}
