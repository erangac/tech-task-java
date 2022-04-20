package com.macroactive.cal;

import java.time.LocalDateTime;

/**
 * The following changes are done.
 * 1.) Moved class to a package
 *
 * TODO : introduce lombok
 */
public class PlannedStart implements IPlannedStart {

   private LocalDateTime startTime = LocalDateTime.MIN;
   private long count = 0;

   @Override
   public LocalDateTime getStartTime() {
      return startTime;
   }

   @Override
   public void setStartTime(LocalDateTime startTime) {
      this.startTime = startTime;
   }

   @Override
   public long getCount() {
      return count;
   }

   @Override
   public void setCount(long count) {
      this.count = count;
   }

}
