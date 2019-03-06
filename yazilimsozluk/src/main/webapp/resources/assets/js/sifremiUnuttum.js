function sifreYolla(){
	 document.getElementById("bekleme").style.display = "block";
	 document.getElementById("hata").style.display = "none";
	 document.getElementById("finito").style.display = "none";
	 
	 $.ajax({
		
		type:"POST",
			contentType:"text/plain",
			url:"sifremiunuttum",
			data:$("#userisim").val(),
			success:function(data){
			 if(data=='OK')
					{
				 document.getElementById("hata").style.display = "none";
				 document.getElementById("bekleme").style.display = "none";
				 document.getElementById("finito").style.display = "block";
				 
					}
			
			 else
				{
				 document.getElementById("bekleme").style.display = "none";
				 document.getElementById("finito").style.display = "none";
				 document.getElementById("hata").style.display = "block";
				}
				
				},error:function(data){
				alert(data);
				}
		
	});
	
}


function yenisifre(){

		
	
		var param={
				userId:$("#userId").val(),
				password:$("#sifre").val(),
		
		}

		var ser_data= JSON.stringify(param); //param dizisini gidiyp json datası haline getiriyo.
		
		$.ajax({
			
			type:"POST",
				contentType:"application/json; charset=UTF-8",
				url:"./../sifreDegis",
				data: ser_data,
				success:function(data){
			
						alert("Şifre değişti.");
						
				
					
					},error:function(data){
					alert(data);
					}
			
		});
		

}
