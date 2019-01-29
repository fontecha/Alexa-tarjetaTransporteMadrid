package com.lumos.alexa.handler.exception;

import com.amazon.ask.dispatcher.exception.ExceptionHandler;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.lumos.alexa.utils.Constants;

import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GeneralExceptionHandler implements ExceptionHandler {

  @Override
  public boolean canHandle(HandlerInput input, Throwable throwable) {
    return true;
  }

  @Override
  public Optional<Response> handle(HandlerInput input, Throwable throwable) {
    log.error(Constants.ERROR + throwable.getMessage());

    //Obtaining input info
    IntentRequest request = (IntentRequest) input.getRequestEnvelope().getRequest();
    String speech;
    
    if ("TtpConsultaIntent".equals(request.getIntent().getName())) {
      speech = Constants.ConsultaSaldo_Error;
    } else {
      speech = Constants.EXCEPTION;
    }

    return input.getResponseBuilder()
        .withSpeech(speech)
        .withShouldEndSession(true)
        .build();
  }


}
