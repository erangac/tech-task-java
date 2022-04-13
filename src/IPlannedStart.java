import java.time.LocalDateTime;

public interface IPlannedStart {
   public LocalDateTime getStartTime();
   public void setStartTime(LocalDateTime startTime);
   public int getCount();
   public void setCount(int count);
}
