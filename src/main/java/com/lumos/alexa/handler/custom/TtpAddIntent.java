package com.lumos.alexa.handler.custom;

import static com.amazon.ask.request.Predicates.intentName;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import com.amazon.ask.model.SlotConfirmationStatus;
import com.lumos.alexa.encryption.Cipher;
import com.lumos.alexa.utils.Constants;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TtpAddIntent implements RequestHandler {

  public boolean canHandle(HandlerInput input) {
    return input.matches(intentName("TtpAddIntent"));
  }


  /**
   * TtpAddIntent Handler.
   * Asks user for card numbers
   * Sets the number as session attributes and also as persistent attributes
   */
  public Optional<Response> handle(HandlerInput input) {

    //Check if user has a card registered
    if (input.getAttributesManager().getSessionAttributes().isEmpty()) {
      // Obtaining slots values
      IntentRequest request = (IntentRequest) input.getRequestEnvelope().getRequest();
      Slot codeUp = request.getIntent().getSlots().get(Constants.Slot_titleCodeUp);
      Slot codeDown = request.getIntent().getSlots().get(Constants.Slot_titleCodeDown);

      // Check confirmation statuses
      if (codeUp.getValue() != null 
          && codeDown.getValue() != null
          && codeUp.getConfirmationStatus() == SlotConfirmationStatus.CONFIRMED
          && codeDown.getConfirmationStatus() == SlotConfirmationStatus.CONFIRMED) {

        // Format card number (for external API calls purposes)
        String cardNumber = codeUp.getValue().trim().replaceAll(" ", "") 
            + codeDown.getValue().trim().replaceAll(" ", "");

        // Create user's data (creation date & encrypted card number)
        Map<String, Object> userData = new HashMap<>();
        userData.put("code", Cipher.encrypt(cardNumber));
        userData.put("creationDate", new Date().getTime());

        // Set & save session & persistent attributes
        input.getAttributesManager().setPersistentAttributes(userData);
        input.getAttributesManager().setSessionAttributes(userData);
        input.getAttributesManager().savePersistentAttributes();

        return input.getResponseBuilder()
            .withSpeech(Constants.Config_Done)
            .withReprompt(" ")
            .build(); 
      } else {
        // If slot values are not set, delegate on Alexa to recollect.
        return input.getResponseBuilder()
            .addDelegateDirective(request.getIntent())
            .build();
      }
    } else {
      // Card configured
      return input.getResponseBuilder()
          .withSpeech(Constants.Config_Done_OUT)
          .withReprompt(" ")
          .build();
    }
  }
}