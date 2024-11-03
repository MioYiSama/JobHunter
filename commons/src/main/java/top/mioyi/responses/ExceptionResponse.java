package top.mioyi.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {
    private String exception;

    private String message;

    public ExceptionResponse(Exception e) {
        this.exception = e.getClass().getName();
        this.message = e.getMessage();
    }
}
