package com.azavea.opentransit.indicators

import com.github.nscala_time.time.Imports._

case class SamplePeriod(
  id: Int,
  periodType: String,
  start: LocalDateTime,
  end: LocalDateTime
) {
  def period: Period = new Period(start, end)
}

object SamplePeriod {
  def getRepresentativeWeekday(periods: Seq[SamplePeriod]): Option[LocalDate] =
    periods
      .find { p => p.periodType != "alltime" && p.periodType != "weekend" }
      .map { p => p.start.toLocalDate }
}
