package com.lumos.alexa.handler.custom;

import static com.amazon.ask.request.Predicates.intentName;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.IntentConfirmationStatus;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.lumos.alexa.encryption.Cipher;
import com.lumos.alexa.utils.Constants;
import com.lumos.alexa.utils.RandomSpeechGenerator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

public class TtpDeleteIntent implements RequestHandler {

  public boolean canHandle(HandlerInput input) {
    return input.matches(intentName("TtpDeleteIntent"));
  }


  /**
   * TtpDeleteIntent Handler.
   * Retrieves user's data.
   * Delete that data if the user wants to.
   */
  public Optional<Response> handle(HandlerInput input) {

    // Obtaining intent's confirmation status.
    IntentRequest request = (IntentRequest) input.getRequestEnvelope().getRequest();
    IntentConfirmationStatus state = request.getIntent().getConfirmationStatus();

    // Obtaining session attributes.
    Map<String, Object> userData = input.getAttributesManager().getSessionAttributes();

    // Check if the user has a card registered
    if (!userData.isEmpty()) {

      // Check if the user confirmed the deletion
      if (state == IntentConfirmationStatus.CONFIRMED) {

        // Remove user's data from session & persistent data
        userData.clear();
        input.getAttributesManager().setSessionAttributes(userData);
        input.getAttributesManager().setPersistentAttributes(userData);
        input.getAttributesManager().savePersistentAttributes();

        return input.getResponseBuilder()
            .withSpeech(Constants.Deletion_Done + RandomSpeechGenerator.generateByeMessage())
            .withShouldEndSession(true)
            .build();
      } else {

        // Do not remove anything if the user does not want to
        if (state == IntentConfirmationStatus.DENIED) {
          return input.getResponseBuilder()
              .withSpeech(Constants.Deletion_Denied + RandomSpeechGenerator.generateByeMessage())
              .withShouldEndSession(true)
              .build();
        } else {

          // Compose confirmation message & ask for it
          String number = Cipher.decrypt(userData.get("code").toString());
          String lastNumbers = number.substring(number.length() - 4, number.length());
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
          String date = sdf.format(new Date(Long.valueOf(userData.get("creationDate").toString())));
          String speech = Constants.Confirmacion_Borrar;
          speech = speech.replace("{lastNumbers}", lastNumbers);
          speech = speech.replace("{date}", date);
          
          //Delegate on Alexa to confirm the intent
          return input.getResponseBuilder()
              .withSpeech(speech)
              .addConfirmIntentDirective(request.getIntent())
              .build();
        }
      }
    } else {
      // Oops! The user has not a card
      return input.getResponseBuilder()
          .withSpeech(Constants.No_Card_Registered)
          .withShouldEndSession(true)
          .build();
    }
  }
}
