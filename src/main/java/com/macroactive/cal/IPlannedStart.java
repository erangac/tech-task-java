package com.macroactive.cal;

import java.time.LocalDateTime;

/**
 * The following changes are done.
 * 1.) Removed unnecessary public
 * 2.) Moved class to a package
 */
public interface IPlannedStart {
   LocalDateTime getStartTime();
   void setStartTime(LocalDateTime startTime);
   long getCount();
   void setCount(long count);
}
