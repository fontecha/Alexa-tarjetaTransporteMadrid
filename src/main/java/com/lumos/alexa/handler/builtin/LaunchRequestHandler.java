package com.lumos.alexa.handler.builtin;

import static com.amazon.ask.request.Predicates.requestType;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;

import com.lumos.alexa.utils.Constants;
import com.lumos.alexa.utils.RandomSpeechGenerator;

import java.util.Map;
import java.util.Optional;

public class LaunchRequestHandler implements RequestHandler  {

  public boolean canHandle(HandlerInput input) {
    return input.matches(requestType(LaunchRequest.class));
  }

  /**
   * LaunchRequest Handler
   * Offers differents options depending on user's attributes.
   */
  public Optional<Response> handle(HandlerInput input) {

    //Retrieve persistent attributes (see GeneralRequestInterceptor)
    Map<String, Object> userData = input.getAttributesManager().getSessionAttributes();
    String speech;
    
    if (userData.isEmpty()) {
      // Tell user how to register the card & help.
      speech = Constants.Launch_NoData;
    } else {
      // Tell user all the options.
      speech = Constants.Launch_ExistData;
    }

    return input.getResponseBuilder()
        .withSpeech(RandomSpeechGenerator.generateWelcomeMessage() + "." + speech)
        .withReprompt("")
        .build();
  }
}
