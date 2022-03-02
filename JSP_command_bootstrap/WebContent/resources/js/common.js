
//팝업창들 뛰우기
//새로운 Window창을 Open할 경우 사용되는 함수 ( arg : 주소 , 창타이틀 , 넓이 , 길이 )
function OpenWindow(UrlStr, WinTitle, WinWidth, WinHeight) {
	winleft = (screen.width - WinWidth) / 2;
	wintop = (screen.height - WinHeight) / 2;
	var win = window.open(UrlStr , WinTitle , "scrollbars=yes,width="+ WinWidth +", " 
							+"height="+ WinHeight +", top="+ wintop +", left=" 
							+ winleft +", resizable=yes, status=yes"  );
	win.focus() ; 
}

//팝업창 닫기
function CloseWindow(){
	
	window.opener.location.reload(true);
	window.close();
}


//사용자 사진 출력
function MemberPictureThumb(contextPath){
	 for(var target of document.querySelectorAll('.manPicture')){	
		 var id = target.getAttribute('data-id');
		 
		 target.style.backgroundImage="url('"+contextPath+"/member/getPicture.do?id="+id+"')";
		 target.style.backgroundPosition="center";
		 target.style.backgroundRepeat="no-repeat";
		 target.style.backgroundSize="cover";
	}
}



//사용자 사진 넣기
//function MemberPictureThumb1(targetObj, id, contextPath){ //(대상, 사용자 아이디)
//	if(!contextPath) contextPath="";
//	
//	targetObj.style.backgroundImage="url('"+contextPath+"/member/getPicture.do?id+"')";
//	targetObj.style.backgroundPosition="center";
//	targetObj.style.backgroundRepeat="no-repeat";
//	targetObj.style.backgroundSize="cover"; 			
//
//}
