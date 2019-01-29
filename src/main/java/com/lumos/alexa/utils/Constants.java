package com.lumos.alexa.utils;

/**
 * Constants.
 * 
 * @author lumos
 */
public class Constants {

  private Constants() {
  }

  // Environment variables
  public static final String Skill_ID = "SkillID";
  public static final String KMS = "KMS";
  public static final String Table_Name = "TableName";
  public static final String Img_Small = "Img_Small";
  public static final String Img_Large = "Img_Large";

  // SSML
  public static final String DelayMidSec = "<break time=\"0.5s\" />";
  public static final String DelaySec = "<break time=\"1s\" />";
  public static final String Delay5Sec = "<break time=\"5s\" />";

  // Slots
  public static final String Slot_titleCodeUp = "ttpCodeUp";
  public static final String Slot_titleCodeDown = "ttpCodeDown";
  public static final String Slot_lastNumbers = "lastNumbers";
  public static final String Slot_date = "date";

  // Traces
  public static final String INFO = "[Alexa TTP] (INFO) ";
  public static final String ERROR = "[Alexa TTP] (ERROR) ";
  public static final String EXCEPTION = "<speak>\n" + "<say-as interpret-as=\"interjection\">ay ay ay...</say-as>\n"
      + "No he podido entenderte</speak>";

  // Table Fields
  public static final String USER_ID = "userId";
  public static final String CREATION_DATE = "creationDate";
  public static final String TITLE_CODE = "titleCode";

  // Encryption
  public static final String EncryptionContext = "EncryptionContext";

  // External services
  public static final String TTP_POST_ENDPOINT = "TTP_POST_ENDPOINT";
  public static final String TTP_HOST = "TTP_HOST";
  public static final String TTP_SOAP = "TTP_SOAP";
  public static final String TTP_BODY = "TTP_BODY";
  public static final String TTP_BODY_CARD = "{TTP-OP-CODE}";

  // Speeches
  public static final String Launch_NoData = "<prosody pitch=\"medium\">Todavía no has configurado tu abono. Podemos configurarlo enseguida."
      + " Si necesitas ayuda... di ayuda en cualquier momento.</prosody>"
      + "<break time=\"0.5s\"/>  <prosody pitch=\"medium\"> Bueno, ¿Qué quieres hacer?</prosody>";

  public static final String Launch_ExistData = "<prosody pitch=\"medium\"> ¿Quieres consultar cuándo caduca tu título?¿O... quieres eliminarlo?"
  		+ " </prosody>";

  public static final String Help_Card = ""
  		+ "-> Configuración y consultas\n "
  		+ "Para configurar tu abono, debes introducir los dígitos que aparecen sombreados en verde en la imagen superior.\n"
  		+ "Una vez configurado, puedes consultar cuándo va a caducar el abono. Si lo deseas, también puedes eliminarlo.\n"
  		+ "En caso de que lo elimines, será necesario volver a configurarlo de nuevo si se quiere consultar el saldo.\n\n"
  		+ "-> Notificaciones\n"
  		+ "Si activas las notificaciones desde la configuración de esta skill, recibirás una notificación tres días antes de que tu abono caduque.\n";
  
  public static final String Help_Speech = "Esta skill te permite saber cuándo va a caducar tu abono de transportes. Si tienes dudas sobre cómo configurar tu abono,"
  		+ " abre la App Alexa. Encontrarás una tarjeta con más información."
	      + " También puedes activar las notificaciones desde la App para que pueda avisarte unos días antes de que tu abono vaya a caducar.";

  public static final String Config_Done = "<speak>\r\n"
      + "<prosody pitch=\"medium\"> Estupendo. Ya has configurado tu abono. Por cierto, te recomiendo que actives las notificaciones desde la App Alexa. "
      + "Así podré notificarte unos días antes de que tu abono caduque. Bueno, ¿Quieres consultar cuándo caduca tu título?¿O... quieres eliminarlo?"
      + "</prosody>\r\n</speak>";

  public static final String Config_Done_OUT = "<speak>\r\n"
      + "<prosody pitch=\"medium\"> Ya tienes el abono configurado. ¿Quieres consultar cuándo caduca tu título?¿O... quieres eliminarlo?"
      + " </prosody>\r\n</speak>";
  
  public static final String Deletion_Done = "Estupendo. Ya se ha eliminado tu abono.";

  public static final String Deletion_Denied = "De acuerdo. No se ha eliminado nada.";

  public static final String No_Card_Registered = "No has configurado aún ningún abono.";

  public static final String ConsultaSaldo_OK = "Tu abono caducará el ";

  public static final String ConsultaSaldo_Error = "<speak>\n"
      + "<say-as interpret-as=\"interjection\">ay ay ay...</say-as>\n"
      + "No he encontrado nada con el número que me dijiste</speak>";

  public static final String Confirmacion_Borrar = "Quieres eliminar el abono que termina en {lastNumbers} que configuraste el día {date} ?";

  public static final String[] WELCOME_MESSAGES = {
      "<say-as interpret-as=\"interjection\">¿qué hay?</say-as>", 
      "<say-as interpret-as=\"interjection\">¿qué tal?</say-as>",
      "<say-as interpret-as=\"interjection\">buenas</say-as>" };

  public static final String[] BYE_MESSAGES = {
      "<say-as interpret-as=\"interjection\">que tengas suerte</say-as>", 
      "<say-as interpret-as=\"interjection\">que sea leve</say-as>",
      "<say-as interpret-as=\"interjection\">hasta luego</say-as>",
      "<say-as interpret-as=\"interjection\">chao</say-as>"};
}
