package com.weather.app.module;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ErrorResponse {
    private List<ErrorItem> errors;

    public ErrorResponse() {
        this.errors = new ArrayList();
    }

    public ErrorResponse(ErrorCode code) {
        this(code, null);
    }

    public ErrorResponse(ErrorCode code, String message) {
        this(new ErrorResponse.ErrorItem(code, message));
    }

    public static ErrorResponse initError() {
        ErrorResponse.ErrorItem item = new ErrorResponse.ErrorItem(ErrorCode.InternalError, null);
        return new ErrorResponse(item);
    }

    public ErrorResponse(ErrorResponse.ErrorItem item) {
        this();
        this.errors.add(item);
    }

    public ErrorResponse(List<ErrorResponse.ErrorItem> errors) {
        this.errors = errors;
    }

    public boolean IsHaveError() {
        return errors.size() > 0;
    }

    public void addError(ErrorResponse.ErrorItem item) {
        this.errors.add(item);
    }

    public void appendErrors(List<ErrorResponse.ErrorItem> errors) {
        this.errors.addAll(errors);
    }

    @Setter
    @Getter
    @AllArgsConstructor
    public static class ErrorItem {
        private ErrorCode code;
        private String message;

        public ErrorItem() {
            this(ErrorCode.InternalError, null);
        }

        public ErrorItem(ErrorCode code) {
            this(code, null);
        }

    }
}
