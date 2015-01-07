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
public class DzResult {
	
	private String errCode = "";	// 에러 코드 - 에러시에만 넘김 , 성공시 ""	*에러코드 정의 해야함
	private String errMsg = "";		// 에러 메세지
	private String errPos = "";		// 에러 위치 - 필요시 사용
	
	private int reqCnt = 0;			// 요청 카운트 - 필요시 사용
	private int successCnt = 0;		// 성공 카운트 - 필요시 사용
	private int failedCnt = 0;		// 실패 카운트 - 필요시 사용
	
	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
	public String getErrPos() {
		return errPos;
	}

	public void setErrPos(String errPos) {
		this.errPos = errPos;
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
	
	public int getFailedCnt() {
		return failedCnt;
	}

	public void setFailedCnt(int failedCnt) {
		this.failedCnt = failedCnt;
	}
	
	private Object returnData = null;
	
	public Object getReturnData() {
		return returnData;
	}

	public void setReturnData(Object returnData) {
		this.returnData = returnData;
	}
}
