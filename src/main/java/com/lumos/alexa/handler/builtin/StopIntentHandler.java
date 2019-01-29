package com.lumos.alexa.handler.builtin;

import static com.amazon.ask.request.Predicates.intentName;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.lumos.alexa.utils.RandomSpeechGenerator;

import java.util.Optional;

public class StopIntentHandler implements RequestHandler {

  public boolean canHandle(HandlerInput input) {
    return input.matches(intentName("AMAZON.StopIntent"));
  }

  /**
   * StopIntent Handler.
   */
  public Optional<Response> handle(HandlerInput input) {
    return input.getResponseBuilder()
        .withShouldEndSession(true)
        .withSpeech(RandomSpeechGenerator.generateByeMessage())
        .build();
  }
}