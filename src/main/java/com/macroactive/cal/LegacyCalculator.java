package com.macroactive.cal;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

/**
 * A calculator to calculate the planned start dates
 * TODO : @Manfred to bring more clarity on purpose of this cal
 */
public class LegacyCalculator {

   // better one operand be promoted to final type long to prevent from int overflow
   private static final long MINUTES_PER_WEEK = 7 * 24 * (long) 60;
   private static final int REQUIRED_DAYS = 1;

   /**
    * Calculate the planned start date based on the provided date list.
    *
    * @param dates dates list taken to calculate the planned start date
    * @return a planned start date
    */
   // Type of 'dates' changed to interface type 'List' from impl type 'LinkedList'
   public IPlannedStart calculate(List<LocalDateTime> dates) {
      // default value is 1
      return calculate(dates, REQUIRED_DAYS);
   }

   // Type of 'dates' changed to interface type 'List' from impl type 'LinkedList'
   private IPlannedStart calculate(List<LocalDateTime> dates, int requiredDays) {
      var plannedStart = new PlannedStart();

      // check if dates no items then return early
      // use more readable & performant 'isEmpty'
      if (dates == null || dates.isEmpty()) {
         return plannedStart;
      }

      dates.sort(Comparator.naturalOrder());

      var startOfFirstWeek = dates.get(0);
      // add a week
      var startOfSecondWeek = startOfFirstWeek.plusMinutes(MINUTES_PER_WEEK);

      var countsForFirstWeek = getCountForWeek(dates, startOfFirstWeek);

      var countsForSecondWeek = getCountForWeek(dates, startOfSecondWeek);

      if (countsForSecondWeek > countsForFirstWeek && countsForSecondWeek >= requiredDays) {
         plannedStart.setStartTime(startOfSecondWeek);
         plannedStart.setCount(countsForSecondWeek);
      }

      return plannedStart;
   }

   private long getCountForWeek(List<LocalDateTime> dates, LocalDateTime startOfWeek) {
      return dates.stream()
         .filter(date -> date.isAfter(startOfWeek) && date.isBefore(startOfWeek.plusMinutes(MINUTES_PER_WEEK)))
         .count();
   }

}
