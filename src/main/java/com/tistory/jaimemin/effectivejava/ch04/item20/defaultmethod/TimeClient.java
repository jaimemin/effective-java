package com.tistory.jaimemin.effectivejava.ch04.item20.defaultmethod;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public interface TimeClient {

	void setTime(int hour, int minute, int second);

	void setDate(int day, int month, int year);

	void setDateAndTime(int day, int month, int year,
		int hour, int minute, int second);

	LocalDateTime getLocalDateTime();

	static ZoneId getZonedId(String zoneString) {
		try {
			return ZoneId.of(zoneString);
		} catch (DateTimeException e) {
			System.err.println(String.format("Invalid time zone: %s; using default time zone instead.", zoneString));

			return ZoneId.systemDefault();
		}
	}

	default ZonedDateTime getZonedDateTime(String zoneString) {
		return ZonedDateTime.of(getLocalDateTime(), getZonedId(zoneString));
	}

}
