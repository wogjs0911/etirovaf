package com.etirovaf.backend.common.exception;

import com.etirovaf.backend.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BaseResDto extends BaseEntity {
    private int resultCode = ResultCode.SUCCESS.getResultCode();
    private String resultMessage = ResultCode.SUCCESS.getResultMessage();
}