package com.lumos.alexa.handler.custom;

import static com.amazon.ask.request.Predicates.intentName;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.lumos.alexa.encryption.Cipher;
import com.lumos.alexa.service.TtpService;
import com.lumos.alexa.utils.Constants;
import com.lumos.alexa.utils.RandomSpeechGenerator;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.Map;
import java.util.Optional;

public class ConsultaSaldoIntent implements RequestHandler {

  public boolean canHandle(HandlerInput input) {
    return input.matches(intentName("TtpConsultaIntent"));
  }


  /**
   * ConsultaSaldoIntent Handler.
   * Retrieves user's card code and then looks for the expiration date.
   */
  public Optional<Response> handle(HandlerInput input) {

    TtpService service = new TtpService();

    String fecha = "";

    // Retrieving session attrs
    Map<String, Object> userData = input.getAttributesManager().getSessionAttributes();

    String speech;

    if (userData.isEmpty()) {
      speech = Constants.No_Card_Registered;
    } else {
      try {
        // Obtaining expiration date
        fecha = service.getFechaCaducidad(Cipher.decrypt(userData.get("code").toString()));
        speech = Constants.ConsultaSaldo_OK + fecha + ".";
      } catch (UnirestException e) {
        return input.getResponseBuilder()
            .withSpeech(Constants.ConsultaSaldo_Error + RandomSpeechGenerator.generateByeMessage())
            .build();
      }
    }
    return input.getResponseBuilder()
        .withSpeech(speech + RandomSpeechGenerator.generateByeMessage())
        .build();

  }

}
