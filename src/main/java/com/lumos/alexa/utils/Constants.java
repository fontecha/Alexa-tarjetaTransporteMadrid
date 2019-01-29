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
  public static final String Launch_NoData = "<prosody pitch=\"medium\">Todav�a no has configurado tu abono. Podemos configurarlo enseguida."
      + " Si necesitas ayuda... di ayuda en cualquier momento.</prosody>"
      + "<break time=\"0.5s\"/>  <prosody pitch=\"medium\"> Bueno, �Qu� quieres hacer?</prosody>";

  public static final String Launch_ExistData = "<prosody pitch=\"medium\"> �Quieres consultar cu�ndo caduca tu t�tulo?�O... quieres eliminarlo?"
  		+ " </prosody>";

  public static final String Help_Card = ""
  		+ "-> Configuraci�n y consultas\n "
  		+ "Para configurar tu abono, debes introducir los d�gitos que aparecen sombreados en verde en la imagen superior.\n"
  		+ "Una vez configurado, puedes consultar cu�ndo va a caducar el abono. Si lo deseas, tambi�n puedes eliminarlo.\n"
  		+ "En caso de que lo elimines, ser� necesario volver a configurarlo de nuevo si se quiere consultar el saldo.\n\n"
  		+ "-> Notificaciones\n"
  		+ "Si activas las notificaciones desde la configuraci�n de esta skill, recibir�s una notificaci�n tres d�as antes de que tu abono caduque.\n";
  
  public static final String Help_Speech = "Esta skill te permite saber cu�ndo va a caducar tu abono de transportes. Si tienes dudas sobre c�mo configurar tu abono,"
  		+ " abre la App Alexa. Encontrar�s una tarjeta con m�s informaci�n."
	      + " Tambi�n puedes activar las notificaciones desde la App para que pueda avisarte unos d�as antes de que tu abono vaya a caducar.";

  public static final String Config_Done = "<speak>\r\n"
      + "<prosody pitch=\"medium\"> Estupendo. Ya has configurado tu abono. Por cierto, te recomiendo que actives las notificaciones desde la App Alexa. "
      + "As� podr� notificarte unos d�as antes de que tu abono caduque. Bueno, �Quieres consultar cu�ndo caduca tu t�tulo?�O... quieres eliminarlo?"
      + "</prosody>\r\n</speak>";

  public static final String Config_Done_OUT = "<speak>\r\n"
      + "<prosody pitch=\"medium\"> Ya tienes el abono configurado. �Quieres consultar cu�ndo caduca tu t�tulo?�O... quieres eliminarlo?"
      + " </prosody>\r\n</speak>";
  
  public static final String Deletion_Done = "Estupendo. Ya se ha eliminado tu abono.";

  public static final String Deletion_Denied = "De acuerdo. No se ha eliminado nada.";

  public static final String No_Card_Registered = "No has configurado a�n ning�n abono.";

  public static final String ConsultaSaldo_OK = "Tu abono caducar� el ";

  public static final String ConsultaSaldo_Error = "<speak>\n"
      + "<say-as interpret-as=\"interjection\">ay ay ay...</say-as>\n"
      + "No he encontrado nada con el n�mero que me dijiste</speak>";

  public static final String Confirmacion_Borrar = "Quieres eliminar el abono que termina en {lastNumbers} que configuraste el d�a {date} ?";

  public static final String[] WELCOME_MESSAGES = {
      "<say-as interpret-as=\"interjection\">�qu� hay?</say-as>", 
      "<say-as interpret-as=\"interjection\">�qu� tal?</say-as>",
      "<say-as interpret-as=\"interjection\">buenas</say-as>" };

  public static final String[] BYE_MESSAGES = {
      "<say-as interpret-as=\"interjection\">que tengas suerte</say-as>", 
      "<say-as interpret-as=\"interjection\">que sea leve</say-as>",
      "<say-as interpret-as=\"interjection\">hasta luego</say-as>",
      "<say-as interpret-as=\"interjection\">chao</say-as>"};
}
