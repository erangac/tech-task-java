import java.time.LocalDateTime;

public interface IPlannedStart {
   public LocalDateTime getStartTime();
   public void setStartTime(LocalDateTime startTime);
   public long getCount();
   public void setCount(long count);
}
