package com.company.project.stepDefinitions;

import com.company.project.login.tasks.OpenBrowserTask;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.Actor;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class CommonSteps {


    Actor DEVS;

    @Given("que el usuario se encuentra en la pagina de inicio de sesion")
    public void queElUsuarioSeEncuentraEnLaPaginaDeInicioDeSesion() {

        //DEVS.attemptsTo(OpenBrowserTask.openBrowser());
        theActorCalled("User").wasAbleTo(OpenBrowserTask.openBrowser());
        throw new io.cucumber.java.PendingException();
    }
}
