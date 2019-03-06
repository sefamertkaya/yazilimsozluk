function addComment(){	
	
	
	var param={
			
			entryId:$("#id").val(),
			comment:$("#comment").val(),
			userId:$("#userSession").val(),
			kullan:$("#nameSession").val(),

	}

	var ser_data= JSON.stringify(param); //param dizisini gidiyp json datası haline getiriyo.

	$.ajax({
		
		type:"POST",
		contentType:"application/json; charset=UTF-8",
		url:"./../../addComment",
		data:ser_data,
			
			success:function(data){
				
				if(data=="OK"){
				
					window.location.reload(false); 
					
				}
				
				
				},error:function(data){
				alert(data);
				}
		
	});
	

}