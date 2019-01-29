package com.lumos.alexa;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;
import com.lumos.alexa.handler.custom.ConsultaSaldoIntent;
import com.lumos.alexa.handler.custom.TtpAddIntent;
import com.lumos.alexa.handler.custom.TtpDeleteIntent;
import com.lumos.alexa.handler.exception.GeneralExceptionHandler;
import com.lumos.alexa.interceptor.GeneralRequestInterceptor;
import com.lumos.alexa.utils.Constants;
import com.lumos.alexa.handler.builtin.CancelIntentHandler;
import com.lumos.alexa.handler.builtin.HelpIntentHandler;
import com.lumos.alexa.handler.builtin.LaunchRequestHandler;
import com.lumos.alexa.handler.builtin.SessionEndedRequestHandler;
import com.lumos.alexa.handler.builtin.StopIntentHandler;

/**
 * Skill Stream Handler.
 * @author lumos
 *
 */
public class TtpStreamHandler extends SkillStreamHandler {

  private static Skill getSkill() {

    return Skills.standard()
        .addRequestHandlers(
            new TtpAddIntent(),
            new TtpDeleteIntent(),
            new ConsultaSaldoIntent(),
            new LaunchRequestHandler(),
            new HelpIntentHandler(),
            new StopIntentHandler(),
            new CancelIntentHandler(),
            new SessionEndedRequestHandler())
        .addExceptionHandler(
            new GeneralExceptionHandler())
        .addRequestInterceptor(
            new GeneralRequestInterceptor())
        .withSkillId(System.getenv(Constants.Skill_ID))
        .withTableName(System.getenv(Constants.Table_Name))
        .withAutoCreateTable(false)
        .build();
  }

  public TtpStreamHandler() {
    super(getSkill());
  }
}
