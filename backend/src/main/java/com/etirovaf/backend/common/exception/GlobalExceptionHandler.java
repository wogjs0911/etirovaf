package com.etirovaf.backend.common.exception;

import com.etirovaf.backend.common.BaseEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.platform.commons.util.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
    private static final String field = "${field}";

    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.OK)
    public BaseEntity exception(ServiceException e){
        BaseEntity baseEntity = new BaseEntity();
        baseEntity.setResultCode(e.getResultCode());
        baseEntity.setResultMessage(e.getResultMessage());
        log.info("ServiceException: code[{}], message[{}]" , baseEntity.getResultCode(), baseEntity.getResultMessage());
        return baseEntity;
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.OK)
    public BaseEntity exception(BindException e){
        BaseEntity baseEntity = new BaseEntity();
        FieldError fieldError = e.getBindingResult().getFieldError();

        if(fieldError == null){
            baseEntity.setResultCode(ResultCode.INTERNAL_ERROR.getResultCode());
            baseEntity.setResultMessage(ResultCode.INTERNAL_ERROR.getResultMessage());
            log.info("Internal Exception: code[{}]", ExceptionUtils.readStackTrace(e));
        }

    String code = fieldError.getCode();

    if ("NotNull".equals(code) || "NotEmpty".equals(code) || "NotBlank".equals(code)) {
        baseEntity.setResultCode(ResultCode.VALID_NOT_NULL.getResultCode());
        baseEntity.setResultMessage(ResultCode.VALID_NOT_NULL.getResultMessage().replace(field, fieldError.getField()));
    } else if ("Pattern".equals(code)) {
        baseEntity.setResultCode(ResultCode.VALID_NOT_REGEXP.getResultCode());
        baseEntity.setResultMessage(ResultCode.VALID_NOT_REGEXP.getResultMessage().replace(field, fieldError.getField()));
    }  else if ("MaxByte".equals(code)) {
        baseEntity.setResultCode(ResultCode.PARAM_NOT_VALID.getResultCode());
        baseEntity.setResultMessage(String.format("%s 값이 %dbyte 보다 큽니다.", fieldError.getRejectedValue(), fieldError.getArguments()[1]));
    } else {
        baseEntity.setResultCode(ResultCode.PARAM_NOT_VALID.getResultCode());
        baseEntity.setResultMessage(ResultCode.PARAM_NOT_VALID.getResultMessage());
    }
		log.error("ValidationException: message[{}]", e.getMessage());

        return baseEntity;
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.OK)
    public BaseEntity exception(MissingServletRequestParameterException e) {
        BaseEntity baseEntity = new BaseEntity();
        baseEntity.setResultCode(ResultCode.VALID_NOT_NULL.getResultCode());
        baseEntity.setResultMessage(ResultCode.VALID_NOT_NULL.getResultMessage().replace(field, e.getParameterName()));
        log.error("ValidationException: message[{}]", ExceptionUtils.readStackTrace(e));

        return baseEntity;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public BaseEntity exception(Exception e) {
        BaseEntity baseEntity = new BaseEntity();
        baseEntity.setResultCode(ResultCode.INTERNAL_ERROR.getResultCode());
        baseEntity.setResultMessage(ResultCode.INTERNAL_ERROR.getResultMessage());
        log.error("Internal Exception: {}", ExceptionUtils.readStackTrace(e));

        return baseEntity;
    }
}
