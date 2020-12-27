package com.weather.app.weatherapi;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonInclude()
public class Condition implements java.io.Serializable {
    private static final long serialVersionUID = 330043717074438001L;
    private String text;
    private String icon;
    private Integer code;

    /**
     * GETTER
     * Weather condition text
     */
    @JsonGetter("text")
    public String getText() {
        return this.text;
    }

    /**
     * SETTER
     * Weather condition text
     */
    @JsonSetter("text")
    public void setText(String value) {
        this.text = value;
    }

    /**
     * GETTER
     * Weather icon url
     */
    @JsonGetter("icon")
    public String getIcon() {
        return this.icon;
    }

    /**
     * SETTER
     * Weather icon url
     */
    @JsonSetter("icon")
    public void setIcon(String value) {
        this.icon = value;
    }

    /**
     * GETTER
     * Weather condition unique code.
     */
    @JsonGetter("code")
    public Integer getCode() {
        return this.code;
    }

    /**
     * SETTER
     * Weather condition unique code.
     */
    @JsonSetter("code")
    public void setCode(Integer value) {
        this.code = value;
    }
}
