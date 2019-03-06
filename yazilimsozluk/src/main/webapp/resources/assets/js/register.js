function addUser(){
	
	// girilen şeyleri param dizisine aktarıyor. bu bir javascript entitysi.
	var param={
			username:$("#username").val(),
			email:$("#email").val(),
			password:$("#password").val(),
			gender:$("#gender").val(),
			
		
	}

	var ser_data= JSON.stringify(param); //param dizisini gidiyp json datası haline getiriyo.
	
	$.ajax({
		
		type:"POST",
			contentType:"application/json; charset=UTF-8",
			url:"addUser",
			data: ser_data,
			success:function(data){
			 if(data=='OK')
					{
					alert("Başarıyla Üye Olundu.");
					}
				else if(data=='ERROR')
				{
					alert("Kullanıcı Adı Alınmış.");
				}
				
				},error:function(data){
				alert(data);
				}
		
	});
	
}

function clickErkek(){

	document.getElementById("gender").value = "Erkek";
	
}

function clickKadin(){
	
	document.getElementById("gender").value = "Kadin";
	
}





