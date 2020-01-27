
package com.kkukielka.api.domain;

public class ExpirationDate {

    private String date;
    private String timezone;
    private Long timezoneType;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Long getTimezoneType() {
        return timezoneType;
    }

    public void setTimezoneType(Long timezoneType) {
        this.timezoneType = timezoneType;
    }

}
