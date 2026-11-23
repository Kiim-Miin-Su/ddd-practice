package jpabook.jpashop.common.exception;

import jpabook.jpashop.common.response.ApiResponse;
import jpabook.jpashop.member.domain.exception.MemberErrorCode;
import jpabook.jpashop.member.domain.exception.MemberException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MemberException.class) // MEMBER_NOT_FOUND
	public ResponseEntity<ApiResponse<Void>> handleMemberException(MemberException memberException) {
		MemberErrorCode errorCode = memberException.getErrorCode();
		return this.build(errorCode.getHttpStatus(), errorCode.getMessage());
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ApiResponse<Void>> handleIllegalArgumentException(IllegalArgumentException e) {
		return this.build(ErrorCode.INVALID_INPUT.getHttpStatus(), e.getMessage());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponse<Void>> handleCommonException(Exception e) {
		return this.build(HttpStatus.INTERNAL_SERVER_ERROR, "알 수 없는 서버 오류입니다.");
	}

	private ResponseEntity<ApiResponse<Void>> build(HttpStatus status, String message) {
		return ResponseEntity.status(status).body(ApiResponse.fail(message)); // (success: false, data: null, message: message)
	}

}
