function sikayet(){
	
	// girilen şeyleri param dizisine aktarıyor. bu bir javascript entitysi.
	var param={
			davaci:$("#userIdDavaci").val(),
			davali:$("#userIdDavali").val(),
			sikayet:$("#sikayet").val(),
	}

	var ser_data= JSON.stringify(param); //param dizisini gidiyp json datası haline getiriyo.
	
	$.ajax({
		
		type:"POST",
			contentType:"application/json; charset=UTF-8",
			url:"./../sikayetvar",
			data: ser_data,
			success:function(data){

				
				document.getElementById("gonderdik").style.display = "block";
				
			
				
				},error:function(data){
				alert(data);
				}
		
	});
	
}
