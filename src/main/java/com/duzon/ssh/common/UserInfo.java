package com.duzon.ssh.common;

/**
 * 유저 정보 클래스 - session에서 사용
 *
 * @author ssh
 * @version 1.0
 * @since 2013.10.01 주석추가
 */
public class UserInfo {
	
	public UserInfo() {
		
	}
	
	//기본정보
	public String NO_EMP;	//관리자번호
	public String CD_GRP;	//권한코드
	public String NM_GRP;	//권한명
	public String ID;		//아이디
	public String PW;		//패스워드
	public String NM;		//이름
	public String CD_DEPT;	//부서코드
	public String NM_DEPT;	//부서명
	
	public String getNO_EMP() {
		return NO_EMP;
	}

	public void setNO_EMP(String sNO_EMP) {
		NO_EMP = sNO_EMP;
	}

	public String getCD_GRP() {
		return CD_GRP;
	}

	public void setCD_GRP(String sCD_GRP) {
		CD_GRP = sCD_GRP;
	}
	
	public String getNM_GRP() {
		return NM_GRP;
	}

	public void setNM_GRP(String sNM_GRP) {
		NM_GRP = sNM_GRP;
	}
	
	public String getID() {
		return ID;
	}

	public void setID(String sID) {
		ID = sID;
	}
	
	public String getPW() {
		return PW;
	}

	public void setPW(String sPW) {
		PW = sPW;
	}

	public String getNM() {
		return NM;
	}

	public void setNM(String sNM) {
		NM = sNM;
	}
	
	public String getCD_DEPT() {
		return CD_DEPT;
	}

	public void setCD_DEPT(String sCD_DEPT) {
		CD_DEPT = sCD_DEPT;
	}
	
	public String getNM_DEPT() {
		return NM_DEPT;
	}

	public void setNM_DEPT(String sNM_DEPT) {
		NM_DEPT = sNM_DEPT;
	}
	
}
