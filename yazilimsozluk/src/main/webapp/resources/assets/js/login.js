function controlUser(){
	
	
	var param={
			email:$("#email").val(),
			password:$("#password").val(),

	}

	var ser_data= JSON.stringify(param); //param dizisini gidiyp json datası haline getiriyo.
	
	$.ajax({
		
		type:"POST",
			contentType:"application/json; charset=UTF-8",
			url:"loginControl",
			data: ser_data,
			success:function(data){
			 if(data=='OK')
					{
					$(location).attr('href' ,'indexoturum');
					}
				else if(data=='ERROR')
				{
					alert("E-Postanızı veya Parolanızı yanlış girdiniz.");
					
				}else if(data=='ERROR404'){
					
					alert("Bu E-Postaya ait bir kullanıcı bulunamadı.");
					
				}
				
				},error:function(data){
				alert(data);
				}
		
	});
	
}
