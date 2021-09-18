package com.mesutgolcuk.sellcellphone.model;

import com.mesutgolcuk.sellcellphone.model.base.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class ErrorResponse extends BaseResponse {
    public int errorCode;
    public String errorMessage;
    public LocalDateTime timestamp;
}
