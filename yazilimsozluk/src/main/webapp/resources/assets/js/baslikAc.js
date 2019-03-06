function addEntry(){
	
	if(document.getElementById("titleEntry").value.length<=2 || document.getElementById("contentEntry").value.length==3)
	{
		document.getElementById("hatamesaj2").style.display = "block";
		document.getElementById("hatamesaj3").style.display = "none";
		document.getElementById("hatamesaj1").style.display = "none";
	}
else if(document.getElementById("contentEntry").value.length<=2 || document.getElementById("titleEntry").value.length==3)
	{
	document.getElementById("hatamesaj2").style.display = "none";
	document.getElementById("hatamesaj3").style.display = "block";
	document.getElementById("hatamesaj1").style.display = "none";
	}

else
	{
	
	
	var param={
			
			entryUserId:$("#userId").val(),
			title:$("#titleEntry").val(),
			content:$("#contentEntry").val(),
			kullanmayici:$("#zorluk").val(),
	}

	var ser_data= JSON.stringify(param); //param dizisini gidiyp json datası haline getiriyo.

	$.ajax({
		
		type:"POST",
			contentType:"application/json; charset=UTF-8",
			url:"addEntry",
			data: ser_data,
			success:function(data){
			 		if(data=='ok'){
			 			
			 			window.location.href="/yazilimsozluk/anasayfa";
			 			
			 		}else if(data=="baslikhata"){
			 			document.getElementById("hatamesaj1").style.display = "block";
			 			document.getElementById("hatamesaj2").style.display = "none";
			 			document.getElementById("hatamesaj3").style.display = "none";	
			 		}
			 		else{
			 			alert("Bir hata oluştu");
			 		}
			 		
				},error:function(data){
				alert(data);
				}
		
	});
	
}
}