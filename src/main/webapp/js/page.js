/**
 * ============================================================================
 * 공통함수
 * 
 * @author		<A Href="mailto:ssh@duzon.com</A>
 * @version		1.0
 * @since		1.0
 * 
 * History
 * 1.0	2012. 3. 20.	신승현	Initial Version
 * ============================================================================
 */
// <![CDATA[

$(document).ready(function() {
	
	//ajax 요청시 완료후에도 마우스 wait 상태 강제변경
	$('body').mousemove(function (e) {
		$('body').css('cursor', 'default');
	});
	
});

$(document).ajaxComplete(function(e, xhr, settings){
	
	if(xhr.getResponseHeader('gotoLoginPage') != null ){
		alert("세션이 종료되었습니다.\n다시 로그인 하십시오.");
    	top.location.href = xhr.getResponseHeader('gotoLoginPage');
    }
});
	
//========================================================//
// validator
// 값 확인 관련 Function Object 
//========================================================//
var Validate = {
	isSimpleIP: function(ip) {
		//ipRegExp = /^(([0-2]*[0-9]+[0-9]+)\.([0-2]*[0-9]+[0-9]+)\.([0-2]*[0-9]+[0-9]+)\.([0-2]*[0-9]+[0-9]+))$/;
		var ipRegExp = /^(1|2)?\d?\d([.](1|2)?\d?\d){3}$/;
		return ipRegExp.test(ip);
	},
	isAlphaLatin : function(string){
	    alphaRegExp = /^[0-9a-z]+$/i;
	    return alphaRegExp.test(string);
	},
	isNotEmpty : function(string){
	    if (string == 'undefined' || typeof string == 'undefined' || typeof string == undefined) 
	        return false;
	    return /\S/.test(string);
	},
	isEmpty : function(string){
	    if (string == 'undefined' || typeof string == 'undefined' || typeof string == undefined) 
	        return true;
	    return !/\S/.test(string);
	},
	isIntegerInRange : function(n, Nmin, Nmax){
	    var num = Number(n);
	    if (isNaN(num)) {
	        return false;
	    }
	    if (num != Math.round(num)) {
	        return false;
	    }
	    return (num >= Nmin && num <= Nmax);
	},
	isNum : function(number){
	    numRegExp = /^[0-9]+$/;
	    return numRegExp.test(number);
	},
	isEMailAddr : function(string){

	    if (Validate.isEmpty(string)) {
	        return true;
	    }
	    emailRegExp = /^[_a-z0-9-]+(\.[_a-z0-9-]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.([a-z]){2,4})$/;
	    return emailRegExp.test(string);
	},
	isZipCode : function(zipcode){
	    //    zpcRegExp = /^[1-9][0-9]{3}\s?[a-zA-Z]{2}$/;
	    return true;
	},
	isDate : function(date, format){
	    return true;
	},
	isURL : function(string){
	    if (!string) 
	        return false;
	    string = string.toLowerCase();
	    urlRegExp = /^(((ht|f)tp(s?))\:\/\/)([0-9a-zA-Z\-]+\.)+[a-zA-Z]{2,6}(\:[0-9]+)?(\/\S*)?$/;
	    return urlRegExp.test(string);
	},
	isSSN : function(number){
	    if (!number) 
	        return false;
	    ssnRegExp = /^\d{6}-\d{7}$/;
	    return ssnRegExp.test(number);
	},
	isDecimal : function(number){
	    if (!number) 
	        return false;
	    decimalRegExp = /^-?(0|[1-9]{1}\d{0,})(\.(\d{1}\d{0,}))?$/;
	    return decimalRegExp.test(number);
	}
	
	
};

//========================================================//
// ajax
// ajax 호출 관련 Function Object 
//========================================================//
var Ajax = {
	/**
	 * ajax로 호출하여 데이터를 처리한다. 
	 * data형식 object(json형태)
	 * @param callurl : 서비스 호출 주소
	 * @param obj : 서비스 입력 json object
	 * @param callback : callback function
	 */
	ajax: function (callurl, obj, callback ) {
		var data;
		
		/*
		if ( callurl == "load.dox" || callurl == "action.dox" ) {
			var jsonobj = {};
			jsonobj['json'] = JSON.stringify(obj);
			data = jsonobj;
		} else {
			data = obj;
		}
	    */
		
		var jsonobj = {};
		jsonobj['json'] = JSON.stringify(obj);
		data = jsonobj;
		
		$.ajax({
			url : callurl,
			type : "POST",
			data : data,
			dataType : "json",
			async : true,
			success	: function(data, textStatus) {			
				$.unblockUI();
			},
			error : function(xhr, textStatus, errorThrown) {
				$.unblockUI();
				if (xhr.status == 12002){
					alert("TimeOut");
				} else {
					alert(errorThrown);
				}
				
	        },
			complete : function(xhr, textStatus) {
	        	$.unblockUI();
	        	//ajax 요청시 완료후에도 마우스 wait 상태 강제변경
	        	$('body').trigger("mousemove");
	        	callback(xhr, textStatus);
	        },
	        beforeSend : function(xhr) {
	        	
	        	var msg = "<div style='text-align: center;'>";
	        	msg += "<img alt='로딩중' src='images/ajaxLoading.gif' style='margin-top: 15px;'>";
	        	msg += "<p style='margin:8px;font-size:14px;font-family: dotum;font-weight: bold;color:#999999;'>처리중 입니다.</p></div>";
	    		
	            $.blockUI({ message: msg,
	            			overlayCSS:{ 
	    						backgroundColor: '#000000', 
	    						opacity: 0.01
	    					},
	    					css:{
	    						backgroundColor: "#EFEFEF",
	    						width: '180px',
	    						left: '42%', 
	    						border: '#629CD8 solid 2px',
	            			    '-webkit-border-radius': '10px', 
	            			    '-moz-border-radius':    '10px'
	    					},
	    					fadeIn:  0,
	    					fadeOut: 0
	            		});
	            
	        	//$.blockUI({ message: null, css: {width : '30%'}, overlayCSS: { backgroundColor : "#585858"} });
	        	
	        	/* 메세지랑 같이 보여줄때 
	        	var msg = "<table style=\"width:200px;height:50px;\"><tr>";
				msg += "<td style=\"width:50px;\"><img src=\"jquery/plugin/jquery.blockUI/images/loading5.gif\" /></td>";
				msg += "<td>처리중입니다.</br>잠시만 기다려주세요.</td></tr></table>";
	            $.blockUI({ message: msg, css: {width : '30%'}, overlayCSS: { backgroundColor : "#585858"} });
	            */
			},
	        timeout		: 180000
	        // 기타 ajax 옵션
			//async : false,
			//cache : false,	
			//contentType	: "application/x-www-form-urlencoded",
			//global		: true,
			//ifModified	: true,
			//processData : true,
			//timeout		: 3000
		});
	}

};


//========================================================//
// format
// format 관련 Function Object 
//========================================================//
var Format = {
	//날짜형 change
	//날짜포멧 정의 ( yyyy-MM-dd )
	date: function(date, fmt) {
		var format = "yyyy-MM-dd";
		if ( fmt != null ) format = fmt;
		
		var nDate = date.replace(/\/|\-/g, "");
		var nFormat = format.replace(/\/|\-/g, "");
		
		if (nDate.length != nFormat.length) return "";
		
		var yS = nFormat.indexOf("y");
		var mS = nFormat.indexOf("M");
		var dS = nFormat.indexOf("d");
		
		var year = nDate.substr(yS, 4);
		var month = nDate.substr(mS, 2);
		var day = nDate.substr(dS, 2);
		
		// 날짜가 넘어갈경우 마지막 날짜처리
		if (month > 12) month = 12;
		if (month == "01" || month == "03" || month == "05" || month == "07" || month == "08" || month == "10" || month == "12" )
		{
			if (day > 31) day = 31;
		} else {
			if (day > 30) day = 30;
		}
		
		format = format.replace("yyyy", year);
		format = format.replace("MM", month);
		format = format.replace("dd", day);
		
		return format;
	},
	//금액 change
	decimal: function(number, decimals, dec_point, thousands_sep) {
		if (null == number || "" == number) return "";
		//number = number.replace(",","");
		number = number.replace(/,/g,"");
		
		if (0 < number.indexOf(".")) {
			if (3 >= number.substr(0, number.indexOf(".")).length) return number.substr(0, number.indexOf(".")+1) + string.rPad(number.substr(number.indexOf(".")+1), "0", decimals, true);
		} else {
			if (3 >= number.length){ 
				if (decimals == 0){
					return string.rPad(number, "0", decimals);
				} else {
				}
			}
		}
		
		dec_point = ".";
		thousands_sep = ",";
	    var n = number, prec = decimals, dec = dec_point, sep = thousands_sep;
	    n = !isFinite(+n) ? 0 : +n;
	    prec = !isFinite(+prec) ? 0 : Math.abs(prec);
	    sep = sep == undefined ? ',' : sep;
	
	    var s = n.toFixed(prec),
	        abs = Math.abs(n).toFixed(prec),
	        _, i;
	
	    if (abs >= 1000) {
	        _ = abs.split(/\D/);
	        i = _[0].length % 3 || 3;
	
	        _[0] = s.slice(0,i + (n < 0)) +
	            _[0].slice(i).replace(/(\d{3})/g, sep+'$1');
	
	        s = _.join(dec || '.');
	    } else {
	        s = abs.replace('.', dec_point);
	    }
	    return s;
	},
	//숫자형 change
	number: function(number) {
		return Format.decimal(number);
	},
	//날짜 포멧 자동셋팅
	setDateType: function(date) {
		if (typeof(date) == "object")
		{
			date.datepicker();
			date.change(function() {
				$(this).val(Format.date($(this).val()));
			});
		}
		else if (typeof(date) == "string")
		{
			var sdate = "#" + date.replace(/#/g, "");

			$(sdate).datepicker();
			$(sdate).change(function() {
				$(this).val(Format.date($(this).val()));
			});
		}
	},
	//월 포멧 자동셋팅
	setMonthType: function(month) {
		if (typeof(month) == "object")
		{
			$.fn.dzMonthpicker({id:$(month).attr("id"),type:"mon",min:2010, max:2015,icon:"n"});
			
			month.change(function() {
				$(this).val(Format.date($(this).val(), "yyyy-MM"));
			});
		}
		else if (typeof(month) == "string")
		{
			var sdate = "#" + month.replace(/#/g, "");

			$.fn.dzMonthpicker({id:month,type:"mon",min:2010, max:2015,icon:"n"});
			
			$(sdate).change(function() {
				$(this).val(Format.date($(this).val(), "yyyy-MM"));
			});
		}
	},
	//금액 포멧 자동셋팅
	setDecimalType: function(amt, decimals) {
		if (typeof(amt) == "object")
		{
			amt.change(function () {
				$(this).val(Format.decimal($(this).val(), decimals));
			});
		}
		else if (typeof(amt) == "string")
		{
			var samt = "#" + amt.replace(/#/g, "");

			$(samt).change(function () {
				$(this).val(Format.decimal($(this).val(), decimals));
			});
		}
	},
	//숫자 포멧 자동셋팅
	setNumberType: function(amt) {
		if (typeof(amt) == "object")
		{
			amt.change(function () {
				$(this).val(Format.number($(this).val()));
			});
		}
		else if (typeof(amt) == "string")
		{
			var samt = "#" + amt.replace(/#/g, "");

			$(samt).change(function () {
				$(this).val(Format.number($(this).val()));
			});
		}
	}
	/*
	,
	//디비 포멧 자동셋팅
	setDBData: function(str) {
		if (typeof(str) == "object")
		{
			amt.change(function () {
				$(this).val(Format.number($(this).val()));
			});
		}
		else if (typeof(str) == "string")
		{
			var samt = "#" + amt.replace(/#/g, "");

			$(samt).change(function () {
				$(this).val(Format.number($(this).val()));
			});
		}
	}
	*/
};

//========================================================//
// string
// string 관련 Function Object 
//========================================================//
var StringUtil = {
	lPad: function(sOrgStr, sPaddingChar, iNum, fix) {
		if (sOrgStr == null || sPaddingChar == null || iNum == null) return "";
		
	 	var sReturn
	 	var sPaddingStr = "";
	 	
	 	for (var i=0; i < iNum; i++) {
	 		sPaddingStr += sPaddingChar;
	 	}
	 	
	 	if (fix) sReturn = (sPaddingStr + sOrgStr).substring((sPaddingStr + sOrgStr).length-iNum, (sPaddingStr + sOrgStr).length);
	 	else sReturn = (sPaddingStr + sOrgStr);
		
	 	return	sReturn;
	},
	rPad: function(sOrgStr, sPaddingChar, iNum, fix) {
		if (sOrgStr == null || sPaddingChar == null || iNum == null) return "";
		
	 	var sReturn
	 	var sPaddingStr = "";
	 	
	 	for (var i=0; i < iNum; i++) {
	 		sPaddingStr += sPaddingChar;
	 	}
	 	
	 	if (fix) sReturn = (sOrgStr + sPaddingStr).substring(0, iNum);
	 	else sReturn = (sOrgStr + sPaddingStr);
		
	 	return	sReturn;
	}
};

//========================================================//
// grid
// grid(jqgrid사용) 관련 Function Object 
//========================================================//
var Grid = {
	/**
	 * 테이블에 새로운 row 를 추가하고 그 row_id 를 리턴
	 * @param tblNm : 추가할 테이블
	 * @param pos : 추가할 위치
	 */
	addNewRow: function(gridNm, pos, newRow) {
		var totalCount = $('#' + gridNm).jqGrid('getDataIDs').length+1 ;
		
		if ( typeof(newRow) == "object"){
			newRow.id = totalCount;
			newRow.cmd = "N";
			$("#" + gridNm).jqGrid('addRowData', totalCount, newRow, pos, '');
		} else {
			$("#" + gridNm).jqGrid('addRowData', totalCount, {id: totalCount, cmd: "N"}, pos, '');
		}
		
		return totalCount;
	}
};

//========================================================//
// formatter
// 공통 formatter(jqgrid에서 사용) 관련 Function Object 
//========================================================//
var Formatter = {
	/**
	 * jqgrid 포멧 형식
	 */
	// 날짜 포멧
	dateFormatter : function(cellvalue, options, rowObject) {
		if(cellvalue==null){
			return "";
		}
		if(cellvalue.length == 8 || cellvalue.length == 14)
		{
			var yyyy = String(cellvalue).substring(0, 4);
			var mm = String(cellvalue).substring(4, 6);
			var dd = String(cellvalue).substring(6, 8);
			return yyyy + "-" + mm + "-" + dd;
		}
		else if(0 <= cellvalue.length && cellvalue.length <= 10)
			return cellvalue;
		else
			return null; //return '&nbsp;';
	},	
	dateUnFormatter : function(cellvalue, options) {
		if(cellvalue==null){
			return "";
		}
		if(cellvalue.length == 10)
			return cellvalue.replace(/-/g, "");
		else if(0 <= cellvalue.length && cellvalue.length <= 10)
			return cellvalue;
		else
			return null;
	},
	// 사업자번호 포멧
	bizFormatter : function(cellvalue, options, rowObject) {
		if(cellvalue == null || cellvalue == "null") return "";
		
		if(cellvalue.length == 10)
		{
			var biz1 = String(cellvalue).substring(0, 3);
			var biz2 = String(cellvalue).substring(3, 5);
			var biz3 = String(cellvalue).substring(5, 10);
			return biz1 + "-" + biz2 + "-" + biz3;
		}
		else if(0 <= cellvalue.length && cellvalue.length <= 12)
			return cellvalue;
		else
			return null; //return '&nbsp;';
	},
	bizUnFormatter : function (cellvalue, options, rowObject) {
		if(cellvalue.length == 12)
			return cellvalue.replace(/-/g, "");
		else if(0 <= cellvalue.length && cellvalue.length <= 12)
			return cellvalue;
		else
			return null;
	},
	// 주민번호 포멧
	personFormatter : function (cellvalue, options, rowObject) {
		if(cellvalue.length == 13)
		{
			var person1 = String(cellvalue).substring(0, 6);
			var person2 = String(cellvalue).substring(6, 13);
			return person1 + "-" + person2;
		}
		else if(0 <= cellvalue.length && cellvalue.length <= 14)
			return cellvalue;
		else
			return null; //return '&nbsp;';
	},
	personUnFormatter : function (cellvalue, options, rowObject) {
		if(cellvalue.length == 14)
			return cellvalue.replace(/-/g, "");
		else if(0 <= cellvalue.length && cellvalue.length <= 14)
			return cellvalue;
		else
			return null;
	},
	// 우편번호
	zipFormatter : function (cellvalue, options, rowObject) {
		if(cellvalue.length == 6)
		{
			var zip1 = String(cellvalue).substring(0, 3);
			var zip2 = String(cellvalue).substring(3, 6);
			return zip1 + "-" + zip2;
		}
		else if(0 <= cellvalue.length && cellvalue.length <= 7)
			return cellvalue;
		else
			return null;
	},
	zipUnFormatter : function (cellvalue, options, rowObject)
	{
		if(cellvalue.length == 7)
			return cellvalue.replace(/-/g, "");
		else if(0 <= cellvalue.length && cellvalue.length <= 7)
			return cellvalue;
		else
			return null;
	},
	getTextByCode : function(arr, code){
		var text = arr[code];
	
		if ( text == null || text == "undefined" )
			text = code;
		
		return text;
	},
	getCodeByText : function(arr, text){
		var code = "";
		
		$.each(arr, function(i, elem) {
			if (elem == text )
				code = i;
	    });
	    return code;
	},
	cdGrpFormatter : function(cellvalue, options, cellobject) {
		return Formatter.getTextByCode( CODE_CD_GRP, $.trim(cellvalue));
	},
	cdGrpUnFormat : function(cellvalue, options, cellobject) {
		return Formatter.getCodeByText( CODE_CD_GRP, $.trim(cellvalue));
	},
	cdDeptFormatter : function(cellvalue, options, cellobject) {
		return Formatter.getTextByCode( CODE_CD_DEPT, $.trim(cellvalue));
	},
	cdDeptUnFormat : function(cellvalue, options, cellobject) {
		return Formatter.getCodeByText( CODE_CD_DEPT, $.trim(cellvalue));
	},
	ynUseFormatter : function(cellvalue, options, cellobject) {
		return Formatter.getTextByCode( CODE_YN_USE, $.trim(cellvalue));
	},
	ynUseUnFormat : function(cellvalue, options, cellobject) {
		return Formatter.getCodeByText( CODE_YN_USE, $.trim(cellvalue));
	},
	fgPopFormatter : function(cellvalue, options, cellobject) {
		return Formatter.getTextByCode( CODE_FG_POP, $.trim(cellvalue));
	},
	fgPopUnFormat : function(cellvalue, options, cellobject) {
		return Formatter.getCodeByText( CODE_FG_POP, $.trim(cellvalue));
	},
	fgBbsFormatter : function(cellvalue, options, cellobject) {
		return Formatter.getTextByCode( CODE_FG_BBS, $.trim(cellvalue));
	},
	fgBbsUnFormat : function(cellvalue, options, cellobject) {
		return Formatter.getCodeByText( CODE_FG_BBS, $.trim(cellvalue));
	}
	,
	fgAcceptFormatter : function(cellvalue, options, cellobject) {
		return Formatter.getTextByCode( CODE_TP_COUNSE, $.trim(cellvalue));
	},
	fgAcceptUnFormat : function(cellvalue, options, cellobject) {
		return Formatter.getCodeByText( CODE_TP_COUNSE, $.trim(cellvalue));
	},
	fgResultFormatter : function(cellvalue, options, cellobject) {
		return Formatter.getTextByCode( CODE_TP_RESULT, $.trim(cellvalue));
	},
	fgResultUnFormat : function(cellvalue, options, cellobject) {
		return Formatter.getCodeByText( CODE_TP_RESULT, $.trim(cellvalue));
	},
	// 전화번호/핸드폰 포멧 
	phoneFormatter : function(cellvalue, options, rowObject) {
		if(cellvalue != null && cellvalue != "")
		{
			return cellvalue.replace(/(^02.{0}|^01.{1}|[0-9]{3})([0-9]+)([0-9]{4})/,"$1-$2-$3");
		}
		else
			return "";
	},
	phoneUnFormatter : function(cellvalue, options, rowObject) {
		if(cellvalue != null && cellvalue != "")
		{
			return cellvalue.replace(/-/g, "");
		}
		else
			return "";
	},
	//YYYY-MM-DD HH:MI:SS
	fullDateFormatter : function(cellvalue, options, rowObject) {
		
		if(cellvalue == null ) return ""; 
		
		if(cellvalue.length == 14)//일시분초
		{
			var yyyy = String(cellvalue).substring(0, 4);
			var mm = String(cellvalue).substring(4, 6);
			var dd = String(cellvalue).substring(6, 8);
			var hh = String(cellvalue).substring(8, 10);
			var mi = String(cellvalue).substring(10, 12);
			var ss = String(cellvalue).substring(12, 14);
			
			return yyyy + "-" + mm + "-" + dd + " " + hh + ":" + mi + ":" + ss;
		}else 
			return cellvalue;
	
	},
	fullDateUnFormatter : function(cellvalue, options, rowObject) {
		
		if(cellvalue != null && cellvalue != "")
		{
			//-, : , 공백 제거
			return cellvalue.replace(/-|:|\s|/g, "");
		}
		else
			return "";
		
	}
	
};

//========================================================//
// date
// 날짜 및 시간 관련 Function Object 
//========================================================//
var SysDate = {
	// 오늘날짜
	date: function() {
		var data;
		var jsonObj = { service : 'dateService', method : 'selectSysDate' };
		$.ajax({
			async: false,
			url: "action.dox",
			data: jsonObj,
			type: "POST",
			success: function(xml) {
				data = xml.string;
			},
			error: function(xhr, ajaxOptions, thrownError) {
				alert("System ajax call Failed!");
			}
		});
		return data;
	},
	// 오늘날짜시간
	dateTime: function() {
		var data;
		var jsonObj = { service : 'dateService', method : 'selectSysDateTime' };
		$.ajax({
			async: false,
			url: "action.dox",
			data: jsonObj,
			type: "POST",
			success: function(xml) {
				data = xml.string;
			},
			error: function(xhr, ajaxOptions, thrownError) {
				alert("System ajax call Failed!");
			}
		});
		return data;
	},
	// 현재월
	month: function() {
		var data;
		var jsonObj = { service : 'dateService', method : 'selectSysMonth' };
		$.ajax({
			async: false,
			url: "action.dox",
			data: jsonObj,
			type: "POST",
			success: function(xml) {
				data = xml.string;
			},
			error: function(xhr, ajaxOptions, thrownError) {
				alert("System ajax call Failed!");
			}
		});
		return data;
	},
	// 현재월 첫일
	firstDate: function() {
		var data;
		var jsonObj = { service : 'dateService', method : 'selectSysFirstDate' };
		$.ajax({
			async: false,
			url: "action.dox",
			data: jsonObj,
			type: "POST",
			success: function(xml) {
				data = xml.string;
			},
			error: function(xhr, ajaxOptions, thrownError) {
				alert("System ajax call Failed!");
			}
		});
		return data;
	},
	// 현재월 말일
	lastDate: function() {
		var data;
		var jsonObj = { service : 'dateService', method : 'selectSysLastDate' };
		$.ajax({
			async: false,
			url: "action.dox",
			data: jsonObj,
			type: "POST",
			success: function(xml) {
				data = xml.string;
			},
			error: function(xhr, ajaxOptions, thrownError) {
				alert("System ajax call Failed!");
			}
		});
		return data;
	},
	// 날짜 더하기
	addDate: function(addday) {
		var data;
		var jsonObj = { service : 'dateService', method : 'selectSysAddDate', addDay : addday };
		$.ajax({
			async: false,
			url: "action.dox",
			data: jsonObj,
			type: "POST",
			success: function(xml) {
				data = xml.string;
			},
			error: function(xhr, ajaxOptions, thrownError) {
				alert("System ajax call Failed!");
			}
		});
		return data;
	}
	
};

//========================================================//
//공통코드 관련 전역변수
//========================================================//
var CODE_CD_GRP;	//권한구분
var CODE_CD_DEPT;	//부서구분
var CODE_YN_USE;	//사용여부
var CODE_FG_POP;	//팝업구분
var CODE_FG_BBS;	//게시판구분
var CODE_TP_COUNSE; //접수구분
var CODE_TP_RESULT; //처리구분
//========================================================//
// code
// 공통코드 관련 Function Object 
//========================================================//
var Code = {
	combo: function(obj, type) {
		var data;
		var jsonObj = { service : 'commonService', method : 'selectCommonCodeCombo', CD_GRP : type };
		$.ajax({
			async: false,
			url: "action.dox",
			data: jsonObj,
			type: "POST",
			success: function(xml) {
				//data = xml.string;
				obj.html(xml.string);
			},
			error: function(xhr, ajaxOptions, thrownError) {
				alert("System ajax call Failed!");
			}
		});
		return data;
	},
	factory: function(type) {
		var data;
		var jsonObj = { service : 'commonService', method : 'selectCommonCode', CD_GRP : type };
		$.ajax({
			async: false,
			url: "action.dox",
			data: jsonObj,
			type: "POST",
			success: function(xml) {
				data = xml.linkedHashMap;
				
			},
			error: function(xhr, ajaxOptions, thrownError) {
				alert("System ajax call Failed!");
			}
		});
		return data;
	}

};

//========================================================//
// Toast Message 
// 
// *options*
// inEffectDuration:  600,   // in effect duration in miliseconds
// stayTime:         3000,   // time in miliseconds before the item has to disappear
// text:               '',   // content of the item
// sticky:          false,   // should the toast item sticky or not?
// type:         'notice',   // notice, warning, error, success
// position:  'top-right',   // top-left, top-center, top-right, middle-left, middle-center, middle-right
//                           // Position of the toast container holding different toast.
//                           // Position can be set only once at the very first call,
//                           // changing the position after the first call does nothing
// closeText:         '',    // text which will be shown as close button,
//                           // set to '' when you want to introduce an image via css
// close:            null    // callback function when the toastmessage is closed
//========================================================//
var Toast = {
	notice: function(text) {
		$().toastmessage('showToast', {
		    text     : "</br>" + text,
		    sticky   : false,
		    position : 'middle-center',
		    type     : 'notice',
		    stayTime : 1000
		});
	},
	success: function(text) {
		$().toastmessage('showToast', {
		    text     : "</br>" + text,
		    sticky   : false,
		    position : 'middle-center',
		    type     : 'success',
		    stayTime : 1000
		});
	},
	error: function(text) {
		$().toastmessage('showToast', {
		    text     : "</br>" + text,
		    sticky   : true,
		    position : 'middle-center',
		    type     : 'error',
		    stayTime : 1000
		});
	},
	warning: function(text) {
		$().toastmessage('showToast', {
		    text     : "</br>" + text,
		    sticky   : true,
		    position : 'middle-center',
		    type     : 'warning',
		    stayTime : 1000
		});
	}
};

	//========================================================//
	//금액 숫자  -> 한글 변환
	//예)1,234  ->천이백삼십사  
	//값 확인 관련 Function Object    박재형 ADD
	//========================================================//
	var num="";
	var won=new Array;
	var obj=""; 
	function numwon(val){ 
	    re=/[^0-9]+/g; 
	    num=val.toString(); 
	    if(!val) {alert("내용이 없습니다.");return false;} 
	    if(re.exec(num)) {alert("숫자만 입력 가능합니다.");return false;} 
	    if(num.substr(0,1)==0) {alert("0으로 시작할수 없습니다.");return false;} 
	    var price_unit0=new Array("","일","이","삼","사","오","육","칠","팔","구"); 
	    var price_unit1=new Array("","십","백","천"); 
	    var price_unit2=new Array("만","억","조","경","해"); 
	    for(var i=0;i<=num.length-1;i++){won[i]=price_unit0[num.substr(i,1)];} 
	    won=won.reverse(); 
	    for(var i=0;i<=num.length-1;i++){if(i>0 && won[i]!="") {won[i]+=price_unit1[i%4];}} 
	    for(var i=4;i<=won.length-1;i=i+4) {won[i]+=price_unit2[(i/4-1)];} 
	    for(var i=0;i<=num.length-1;i++){if(i%4 > 0) {won[i]=won[i].replace("일","");}} 
	    won=won.reverse();
	    return won.join(""); 
	} 
	
	//========================================================//
	//조회기간 제한 걸기 
	//예)180일 3개월 조회  
	//값 확인 관련 Function Object    박재형 ADD
	//========================================================//
	function calDateRangeChk(val1, val2)
    {
        var FORMAT = "-";

        // FORMAT을 포함한 길이 체크
        if (val1.length != 10 || val2.length != 10)
            return null;

        // FORMAT이 있는지 체크
        if (val1.indexOf(FORMAT) < 0 || val2.indexOf(FORMAT) < 0)
            return null;

        // 년도, 월, 일로 분리
        var start_dt = val1.split(FORMAT);
        var end_dt = val2.split(FORMAT);

        // 월 - 1(자바스크립트는 월이 0부터 시작하기 때문에...)
 
        start_dt[1] = (Number(start_dt[1]) - 1) + "";
        end_dt[1] = (Number(end_dt[1]) - 1) + "";

        var from_dt = new Date(start_dt[0], start_dt[1], start_dt[2]);
        var to_dt = new Date(end_dt[0], end_dt[1], end_dt[2]);

 

        return (to_dt.getTime() - from_dt.getTime()) / 1000 / 60 / 60 / 24;
    }

//]]>
