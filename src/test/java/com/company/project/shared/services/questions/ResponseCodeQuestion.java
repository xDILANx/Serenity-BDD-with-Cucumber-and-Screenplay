package com.company.project.shared.services.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResponseCodeQuestion implements Question<Integer> {

    public static Question<Integer> WAS(){
        return new ResponseCodeQuestion();
    }

    @Override
    public Integer answeredBy(Actor actor) {
        return SerenityRest.lastResponse().statusCode();
    }
}
