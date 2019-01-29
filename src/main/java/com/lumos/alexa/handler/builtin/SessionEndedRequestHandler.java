package com.lumos.alexa.handler.builtin;

import static com.amazon.ask.request.Predicates.requestType;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.SessionEndedRequest;
import com.lumos.alexa.utils.RandomSpeechGenerator;

import java.util.Optional;

public class SessionEndedRequestHandler implements RequestHandler  {

  public boolean canHandle(HandlerInput input) {
    return input.matches(requestType(SessionEndedRequest.class));
  }
  
  /**
   * SessionEndedRequest Handler.
   */
  public Optional<Response> handle(HandlerInput input) {
    return input.getResponseBuilder()
        .withShouldEndSession(true)
        .withSpeech(RandomSpeechGenerator.generateByeMessage())
        .build();
  }
}

