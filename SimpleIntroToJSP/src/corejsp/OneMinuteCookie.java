package corejsp;

import javax.servlet.http.*;

/* Cookie that persists 1 minute. Default Cookie doesn't
 *  persist past current browsing session.
 */

public class OneMinuteCookie extends Cookie {
  public static final int SECONDS_PER_MINUTE = 60;
  
  public OneMinuteCookie(String name, String value) {
    super(name, value);
    setMaxAge(SECONDS_PER_MINUTE);
  }
}
