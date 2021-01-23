package com.kata.employee.employeeportalservice.exception;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;

import java.util.*;

import static com.kata.employee.employeeportalservice.constant.EmployeePortalServiceConstants.*;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({BindingResult.class, MethodArgumentNotValidException.class})
public class CustomRequestValidationExceptionHandlerTest {

    @Mock
    private BindingResult result;

    @Mock
    private MethodArgumentNotValidException methodArgumentNotValidMockedException;

    private final CustomRequestValidationExceptionHandler advice = new CustomRequestValidationExceptionHandler();

    @Test
    public void should_handle_method_argument_validation_exception_and_return_in_proper_format() {
        List<String> expectedMessage = Arrays.asList(FIRST_NAME_FIELD_MANDATORY_MESSAGE, LAST_NAME_FIELD_MANDATORY_MESSAGE);
        when(methodArgumentNotValidMockedException.getBindingResult()).thenReturn(result);
        when(result.getFieldErrors()).thenReturn(getDummyFieldErrors());
        final ResponseEntity<Object> responseEntity = advice.handleMethodArgumentNotValid(methodArgumentNotValidMockedException, new HttpHeaders(), HttpStatus.BAD_REQUEST, Mockito.mock(WebRequest.class));
        Assert.assertNotNull(responseEntity);
        Assert.assertEquals("The error should be 400 Bad Request", HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        Assert.assertEquals("The error should be equal", expectedMessage, ((Map<String, Object>) responseEntity.getBody()).get("error"));
    }

    private List<FieldError> getDummyFieldErrors() {
        final List<FieldError> fieldErrors = new ArrayList<>();
        fieldErrors.add(new FieldError("firstName", "field", FIRST_NAME_FIELD_MANDATORY_MESSAGE));
        fieldErrors.add(new FieldError("lastName", "field", LAST_NAME_FIELD_MANDATORY_MESSAGE));
        return fieldErrors;
    }
}
