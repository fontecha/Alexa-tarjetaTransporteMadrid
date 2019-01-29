package com.lumos.alexa.service;

import com.lumos.alexa.utils.Constants;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * TtpService class.
 * Usage: Retrieve expiration date of a card.
 * @author lumos.
 */
public class TtpService {

  /**
   * <b> Description </b>: Retrieves expiration date of the given card.
   * @param ttpCode - The number of the card.
   * @return Expiration date
   * @throws UnirestException - If any problem during connection occurs.
   */
  public String getFechaCaducidad(String ttpCode) throws UnirestException {

    // Create the POST request
    String body = System.getenv(Constants.TTP_BODY);

    HttpResponse<String> response = Unirest.post(System.getenv(Constants.TTP_POST_ENDPOINT))
        .header("content-type", "text/xml;charset=utf-8")
        .header("host", System.getenv(Constants.TTP_HOST))
        .header("connection", "Keep-Alive")
        .header("accept-encoding", "gzip")
        .header("soapaction", System.getenv(Constants.TTP_SOAP))
        .header("cache-control", "no-cache")
        .body(body.replace("{TTP-OP-CODE}", ttpCode))
        .asString();

    // Process response & retrieve expiration date
    String particula = response.getBody().substring(response.getBody().indexOf(";ChargeEndDate"));
    String [] partes = particula.split("&lt");
    return partes[0].split(";")[2];
  }

}
