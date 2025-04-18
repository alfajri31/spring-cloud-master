package org.group.reactiveexample.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> {
    private boolean success;
    private String message;
    private T data;

    public static <T> BaseResponse<T> createSuccessResponse(T data) {
        return new BaseResponse<>(true, "Success", data);
    }

    public static <T> BaseResponse<T> createErrorResponse(String message) {
        return new BaseResponse<>(false, message, null);
    }
}
