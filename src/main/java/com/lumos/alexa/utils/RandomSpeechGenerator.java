package com.lumos.alexa.utils;

import java.util.Random;

public class RandomSpeechGenerator {

  private RandomSpeechGenerator() {}
  
  public static String generateWelcomeMessage() {
    int rnd = new Random().nextInt(Constants.WELCOME_MESSAGES.length);
    return  Constants.WELCOME_MESSAGES[rnd];
  }
  
  public static String generateByeMessage() {
    int rnd = new Random().nextInt(Constants.BYE_MESSAGES.length);
    return Constants.BYE_MESSAGES[rnd];
  }
}
