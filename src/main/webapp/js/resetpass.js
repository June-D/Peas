function submit(){
		var inputU=document.getElementById("newpass").value;
		var inputM=document.getElementById("rnewpass").value;
		if(inputU.length<6){
			document.getElementById("Umessage").style.display="";
			document.getElementById("Mmessage").style.display="none";
		}else {

			if(inputU!=inputM){
				document.getElementById("Umessage").style.display="none";
				document.getElementById("Mmessage").style.display="";
			}
			else{
				document.getElementById("Mmessage").style.display="none";
				document.getElementById("Umessage").style.display="none";
				var myform = document.getElementById("chpForm");
				myform.submit();
			}
			
		}
	}