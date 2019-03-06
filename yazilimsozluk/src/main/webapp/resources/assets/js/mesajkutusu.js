$(document).ready(function(){
	
	messageBox();
	
});


function messageBox(){	

	
	$.ajax({
		
		type:"POST",
			url:"./../messagebox",
			contentType:"text/plain",
			data:$("#recipientId").val()+"",
	
			
		success:function(data){
			var list="";
			

			$(data).each(function(i){
		
					list=list
						+'<li class="list-group-item"><a href="./../mesaj/'+data[i][0]+'">'+data[i][1]+'</a></li>';

				
			
			});
			
			$("#mesajalani").html(list);	
			
				},error:function(data){
		alert("burda");
				}
		
	});
	

}

function messageBox2(id){	

	
	$.ajax({
		
		type:"POST",
			url:"./../getUserData",
			contentType:"text/plain",
			data:$("#id"+id+"").val()+"",
	
			
		success:function(data){
	
			var list="";
	
					list='<li class="list-group-item"><a href="./../mesaj/'+data.userId+'">'+data.username+'</a></li>';
				
			
			$("#mesajalani").html(list);	
			
				},error:function(data){
		
					alert("burda");
				}
		
	});
	

}
