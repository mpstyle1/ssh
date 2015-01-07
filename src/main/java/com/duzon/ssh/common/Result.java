package com.duzon.ssh.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 요청 결과값 return class
 *
 * @author ssh
 * @version 1.0
 * @since 2013.10.01 주석추가
 */
public class Result {
	
	private String resultCode = "";	// 결과코드
	private String errorCode = "";	// 에러 코드 - 에러시에만 넘김 , 성공시 ""	*에러코드 정의 해야함
	private String errorMsg = "";		// 에러 메세지
	private String errorPos = "";		// 에러 위치 - 필요시 사용
	
	private int reqCnt = 0;			// 요청 카운트 - 필요시 사용
	private int successCnt = 0;		// 성공 카운트 - 필요시 사용
	private int failCnt = 0;		// 실패 카운트 - 필요시 사용
	
	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	public String getErrorPos() {
		return errorPos;
	}

	public void setErrorPos(String errorPos) {
		this.errorPos = errorPos;
	}
	
	public int getReqCnt() {
		return reqCnt;
	}

	public void setReqCnt(int reqCnt) {
		this.reqCnt = reqCnt;
	}
	
	public int getSuccessCnt() {
		return successCnt;
	}

	public void setSuccessCnt(int successCnt) {
		this.successCnt = successCnt;
	}
	
	public int getFailCnt() {
		return failCnt;
	}

	public void setFailCnt(int failCnt) {
		this.failCnt = failCnt;
	}
	
	private Object returnData = null;
	
	public Object getReturnData() {
		return returnData;
	}

	public void setReturnData(Object returnData) {
		this.returnData = returnData;
	}
}
