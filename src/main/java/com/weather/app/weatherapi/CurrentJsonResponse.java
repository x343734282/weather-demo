package com.weather.app.weatherapi;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonInclude
public class CurrentJsonResponse implements java.io.Serializable {
    private static final long serialVersionUID = 3346757744044920600L;
    private Location location;
    private Current current;

    /**
     * GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("location")
    public Location getLocation() {
        return this.location;
    }

    /**
     * SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("location")
    public void setLocation(Location value) {
        this.location = value;
    }

    /**
     * GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("current")
    public Current getCurrent() {
        return this.current;
    }

    /**
     * SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("current")
    public void setCurrent(Current value) {
        this.current = value;
    }
}
