import java.time.LocalDateTime;

public class PlannedStart implements IPlannedStart {

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

   private LocalDateTime startTime = LocalDateTime.MIN;
   private long count = 0;
}
