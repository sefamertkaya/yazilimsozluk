$(document).ready(function(){
	entry();
	comment();
});

function entry(){	
	

	
	$.ajax({
		
		type:"POST",
			url:"./../getEntryUserId",
			contentType:"text/plain",
			data:$("#profilid").val(),

		
	
		success:function(data){
			var list="";
			$(data).each(function(i,val){
			list=list
			  +'<a href="./../basliks/'+val.entryId+'" class="baslikk"><h6><b>'+val.title+'</b> </h6> </a>'
		      +'<p>'+val.content+'</p>'
		      +'<p style="font-size: 11px; ">'+new Date(val.entryDate).toLocaleString()+'   |  <a href="#" data-toggle="tooltip" data-placement="top" title="bunu beğendim!" class="begenmek" >uçur</a> |  <a href="#" data-toggle="tooltip" data-placement="top" title="zerre kadar beğenmedim!" class="begenmek">devir</a> | <a href="./../sikayet/'+val.entryUserId+'" data-toggle="tooltip" data-placement="top" title="uygunsuz içerik şikayet etmek istiyorum!" class="begenmek">şikayet et</a> </p></p>';

			});
			
			$("#basliklar").html(list);	
				},error:function(data){
				alert(data);
				}
		
	});
	

}


function comment(){	
	

	
	$.ajax({
		
		type:"POST",
			url:"./../getCommentUserId",
			contentType:"text/plain",
			data:$("#profilid").val(),


		success:function(data){
			var list="";
			$(data).each(function(i,val){
			list=list
			  +'<a href="./../basliks/'+val.entryId+'" class="baslikk"><h6><b> entrye git...</b> </h6> </a>'
              +'<input type="text" hidden style="display: none;" value="'+val.entryId+'" id="ida'+val.entryId+'"/>'
		      +'<p>'+val.comment+'</p>'
		      +'<p style="font-size: 11px; ">'+new Date(val.commentDate).toLocaleString()+'   |  <a href="#" data-toggle="tooltip" data-placement="top" title="bunu beğendim!" class="begenmek" >uçur</a> |  <a href="#" data-toggle="tooltip" data-placement="top" title="zerre kadar beğenmedim!" class="begenmek">devir</a> | <a href="./../sikayet/'+val.entryUserId+'" data-toggle="tooltip" data-placement="top" title="uygunsuz içerik şikayet etmek istiyorum!" class="begenmek">şikayet et</a> </p></p>';

			});
			
			
			
			$("#yorumlar").html(list);
			
			$(data).each(function(i,val){
				commentTitle(val.entryId);
				});
			
				
				},error:function(data){
				alert(data);
				}
		
	});
	

}

function commentTitle(id){	

	$.ajax({
		
		type:"POST",
			url:"./../getentrytitleforid",
			contentType:"text/plain; charset=UTF-8",
			data:$("#ida"+id+"").val(),
			 
		success:function(data){
			
			
			document.getElementById("yakalan"+data.entryId+"").innerHTML = data.title;
			

				},error:function(data){
		
			
				}
		
	});
	

}

