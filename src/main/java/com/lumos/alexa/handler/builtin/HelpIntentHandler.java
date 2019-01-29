package com.lumos.alexa.handler.builtin;

import static com.amazon.ask.request.Predicates.intentName;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.ui.Image;
import com.lumos.alexa.utils.Constants;

import java.util.Optional;

public class HelpIntentHandler implements RequestHandler {

	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("AMAZON.HelpIntent"));
	}

	/**
	 * HelpIntent handler.
	 */
	public Optional<Response> handle(HandlerInput input) {

		Image image = Image.builder()
				.withLargeImageUrl(System.getenv(Constants.Img_Large))
				.withSmallImageUrl(System.getenv(Constants.Img_Small))
				.build();

		return input.getResponseBuilder()
				.withSpeech(Constants.Help_Speech)
				.withStandardCard("Abono de Transportes", Constants.Help_Card, image)
				.withShouldEndSession(true)
				.build();
	}
}