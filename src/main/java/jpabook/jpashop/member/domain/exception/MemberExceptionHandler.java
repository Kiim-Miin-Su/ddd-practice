package jpabook.jpashop.member.domain.exception;

import jpabook.jpashop.common.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MemberExceptionHandler {

	@ExceptionHandler(DuplicatedUsername.class)
	public ResponseEntity<ApiResponse<Void>> handleDuplicatedUsername(DuplicatedUsername e) {
		return this.build(MemberErrorCode.DUPLICATED_USERNAME.getHttpStatus(), e.getMessage());
	}

	@ExceptionHandler(DuplicatedEmail.class)
	public ResponseEntity<ApiResponse<Void>> handleDuplicatedEmail(DuplicatedEmail e) {
		return this.build(MemberErrorCode.DUPLICATED_EMAIL.getHttpStatus(), e.getMessage());
	}

	private ResponseEntity<ApiResponse<Void>> build(HttpStatus status, String message) {
		return ResponseEntity.status(status).body(ApiResponse.fail(message));
	}
}
