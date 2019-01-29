package com.lumos.alexa.interceptor;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.interceptor.RequestInterceptor;

import java.util.Map;

public class GeneralRequestInterceptor implements RequestInterceptor {

  @Override
  public void process(HandlerInput input) {
    
    // Load persistent attributes
    // Useful for one-shot invocation (open 'my skill' AND 'doSomething')
    if (input.getAttributesManager().getSessionAttributes().isEmpty()) {
      Map<String, Object> persistentAttributes = input.getAttributesManager().getPersistentAttributes();
      input.getAttributesManager().setSessionAttributes(persistentAttributes);
    }
  }

}
