import java.time.LocalDateTime;
import java.util.LinkedList;

public class LegacyCalculator {

   public IPlannedStart calculate(LinkedList<LocalDateTime> dates) {
      // default value is 1
      return calculate(dates, 1);
   }

   public IPlannedStart calculate(LinkedList<LocalDateTime> dates, int requiredDays) {
      dates.sort((a,b) -> a.compareTo(b));

      var plannedStart = new PlannedStart();
      plannedStart.setStartTime(LocalDateTime.MIN);
      plannedStart.setCount(0);

      // check if dates no items then return early
      if(dates.size() == 0){
         return plannedStart;
      }

      var requiredNumberInFirstWeek = requiredDays;

      var startOfFirstWeek = dates.get(0);
      // add a week
      var startOfSecondWeek = startOfFirstWeek.plusMinutes(7 * 24 * 60);

      var countsForFirstWeek = dates
         .stream()
         .filter(x -> x.isAfter(startOfFirstWeek) && x.isBefore(startOfFirstWeek.plusMinutes(7 * 24 * 60)))
         .count()
         ;

      var countsForSecondWeek = dates
         .stream()
         .filter(x -> x.isAfter(startOfSecondWeek) && x.isBefore(startOfSecondWeek.plusMinutes(7 * 24 * 60)))
         .count()
         ;

      if( countsForSecondWeek > countsForFirstWeek && countsForSecondWeek >= requiredNumberInFirstWeek){
         plannedStart.setStartTime(startOfSecondWeek);
         plannedStart.setCount(countsForSecondWeek);
      }

      return plannedStart;
   }

}
