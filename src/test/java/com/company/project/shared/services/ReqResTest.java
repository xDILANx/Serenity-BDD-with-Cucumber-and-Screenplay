package com.company.project.shared.services;

import com.company.project.shared.services.Facts.NetflixPlans;
import com.company.project.shared.services.models.users.Datum;
import com.company.project.shared.services.models.users.RegisterUsersInfo;
import com.company.project.shared.services.questions.GetUsersQuestions;
import com.company.project.shared.services.questions.ResponseCodeQuestion;
import com.company.project.shared.services.tasks.GetUsersTask;
import com.company.project.shared.services.tasks.RegisterUsersTask;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import net.serenitybdd.junit5.SerenityJUnit5Extension;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;


@ExtendWith(SerenityJUnit5Extension.class)
public class ReqResTest {

    private static final String  restApiUrl = "http://mipc:5000/api";
    Actor DEVS = Actor.named("Devs").whoCan(CallAnApi.at(restApiUrl));

    @Test
    public void getUsers(){

        DEVS.attemptsTo(
                GetUsersTask.fromPage(1)
        );
        //assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(200);
        DEVS.should(
                seeThat("El codigo de respuesta", ResponseCodeQuestion.WAS(), equalTo(200))
        );

        Datum user = new GetUsersQuestions().answeredBy(DEVS).getData().stream().filter(s -> s.getId() == 1).findFirst().orElseThrow(() -> new AssertionError("No se encontró el usuario con ID 1 en la respuesta"));

        DEVS.should(
                seeThat("Usuario no es nulo", actor ->  user, notNullValue())
        );

        DEVS.should(
                seeThat("El email del usuario", actor ->  user.getEmail(), equalTo("george.bluth@reqres.in")),
                seeThat("El email del usuario", actor ->  user.getAvatar(), equalTo("https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg"))
        );
    }

    @Test
    public void registerUsers1(){

        String registerUserInfo = """
                 {
                    "name": "morpheus",
                    "job": "leader",
                    "email": "tobias.funke@reqres.in",
                    "password": "serenity"
                 }\
                """;

        DEVS.attemptsTo(
                RegisterUsersTask.withInfo(registerUserInfo)
        );

        DEVS.should(
                seeThat("El codigo de respuesta", ResponseCodeQuestion.WAS(), equalTo(200))
        );
    }

    @Test
    public void registerUsers2(){

        RegisterUsersInfo registerUsersInfo = new RegisterUsersInfo();

        registerUsersInfo.setName("morpheus");
        registerUsersInfo.setJob("leader");
        registerUsersInfo.setEmail("tracey.ramos@reqres.in");
        registerUsersInfo.setPassword("serenity");


        DEVS.attemptsTo(
                RegisterUsersTask.withInfo(registerUsersInfo)
        );

        DEVS.should(
                seeThat("El codigo de respuesta", ResponseCodeQuestion.WAS(), equalTo(200))
        );
    }

    @Test
    public void factTest(){

        DEVS.has(NetflixPlans.toViewSeries());

    }

}
