$(document).ready(function(){
	
	getEntryIc();
	getPage();
	getComment();

});

function getEntryIc(){	
	
	$.ajax({
		
		type:"POST",
			url:"./../../getEntryIn",
			contentType:"text/plain",
			data:$("#id").val(),


		success:function(data){
	 		
			document.getElementById("baslik").innerHTML =data.title;

				var list="";
				
				$(data).each(function(i,val){
				
				list=list
				+'<p>'+val.content+'</p>'
			     +'<a href="./../../profil/'+val.entryUserId+'" > <p class="nickname">'+val.kullanmayici+'</p></a>'
		        +'<p style="font-size: 11px; ">'+new Date(val.entryDate).toLocaleString()+'   |  <a href="./../../ucur/'+val.entryId+'/'+val.entryUserId+'" data-toggle="tooltip" data-placement="top" title="bunu beğendim!" class="begenmek" >uçur</a> |  <a href="./../../devir/'+val.entryId+'/'+val.entryUserId+'" data-toggle="tooltip" data-placement="top" title="zerre kadar beğenmedim!" class="begenmek">devir</a> |  <a href="./../../sikayet/'+val.entryUserId+'" data-toggle="tooltip" data-placement="top" title="uygunsuz içerik,şikayet edicem!" class="begenmek">şikayet et!</a> </p> </p>'
		        +'<hr>';

				});
			
				$("#ic").html(list);	
	
				
				},error:function(data){
				alert(data);
				}
		
	});
	

}


function getComment(){	
	
	$.ajax({
		
		type:"POST",
			url:"./../../getComment",
			contentType:"text/plain",
			data:$("#id").val(),
			
		success:function(data){

				var list="";
				
				$(data).each(function(i,val){
				
				list=list
				+'<p>'+val.comment+'</p>'
			    +'<a href="./../../profil/'+val.userId+'" > <p class="nickname">'+val.kullan+'</p></a>'
		        +'<p style="font-size: 11px; ">'+new Date(val.commentDate).toLocaleString()+'   |  <a href="#" data-toggle="tooltip" data-placement="top" title="bunu beğendim!" class="begenmek" >uçur</a> |  <a href="#" data-toggle="tooltip" data-placement="top" title="zerre kadar beğenmedim!" class="begenmek">devir</a> |  <a href="./../../sikayet/'+val.userId+'" data-toggle="tooltip" data-placement="top" title="uygunsuz içerik,şikayet edicem!" class="begenmek">şikayet et!</a> </p>'
		        +'<br>';

				});
			
				$("#dis").html(list);	
	
				
				},error:function(data){
				alert(data);
				}
		
	});
	

}

function getPage(){	
	
	$.ajax({
		
		type:"POST",
			url:"./../../getPage",
			contentType:"text/plain",
			data:$("#pageId").val(),
			
		success:function(data){

				
				},error:function(data){
		
				}
		
	});
	

}



