package com.xc.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;

public class SpringEvent extends ApplicationEvent {

  private String message;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * Create a new ContextStartedEvent.
   *
   * @param source the {@code ApplicationContext} that the event is raised for (must not be {@code null})
   */
  public SpringEvent(ApplicationContext source, String message) {
    super(source);
    this.message = message;
  }
}