package com.company.project.shared.services.questions;

import com.company.project.shared.services.models.users.Users;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class GetUsersQuestions implements Question<Users> {
    @Override
    public Users answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(Users.class);
    }
}
