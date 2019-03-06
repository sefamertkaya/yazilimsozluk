$(document).ready(function(){
	
	message();
	
});


function message(){	

	
	$.ajax({
		
		type:"POST",
			url:"./../getMesaj",
			contentType:"text/plain",
			data:$("#recipientId").val()+"",
	
			
		success:function(data){
	
			var list="";
			var spam_id = document.getElementById("senderId").value;

			$(data).each(function(i,val){
		
				if(spam_id==val.recipientId){
			list=list
			+'<li class="list-group-item">'+val.messageContent+'</li>';
				}else{
					list=list
					+'<li class="list-group-item" style="text-align:right;background-color: #eeeeee">'+val.messageContent+'</li>';

					
				}
				
				
			});
			
			$("#mesajalani").html(list);	
				},error:function(data){
		
				}
		
	});
	

}


function gonder(){
	
	// girilen şeyleri param dizisine aktarıyor. bu bir javascript entitysi.
	var param={
			
			senderId:$("#senderId").val(),
			messageContent:$("#mesajic").val(),
			recipientId:$("#recipientId").val(),
		
	}

	var ser_data= JSON.stringify(param); //param dizisini gidiyp json datası haline getiriyo.
	alert(ser_data);
	$.ajax({
		
		type:"POST",
			contentType:"application/json; charset=UTF-8",
			url:"./../addMessage",
			data: ser_data,
			success:function(data){
			 if(data=='ok')
		
				 alert("mesaj gönderildi");
				},error:function(data){
					alert("burası");
				alert(data);
				}
		
	});
}
