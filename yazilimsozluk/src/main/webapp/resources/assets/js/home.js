$(document).ready(function(){
	
	getEntry();
	
	
});


function getEntry(){	
	
	$.ajax({
		
		type:"POST",
			url:"getEntry",
			success:function(data){
				
				var list="";
			
				$(data).each(function(i,val){
				
					if(i<10){
					
				list=list
				  +'<a href="baslik/'+val.entryId+'/0" class="baslikk"><h5><b>'+val.title+'</b></h5></a>'
			      +'<p>'+val.content+'</p>'
			      +'<a href="profil/'+val.entryUserId+'" > <p class="nickname"><b>'+val.kullanmayici+'</b></p></a>'
			      +'<p style="font-size: 11px; ">'+new Date(val.entryDate).toLocaleString()+'   |  <a href="ucur/'+val.entryUserId+'" data-toggle="tooltip" data-placement="top" title="bunu beğendim!" class="begenmek" >uçur</a> |  <a href="devir/'+val.entryUserId+'" data-toggle="tooltip" data-placement="top" title="zerre kadar beğenmedim!" class="begenmek">devir</a> |  <a href="sikayet/'+val.entryUserId+'" data-toggle="tooltip" data-placement="top" title="uygunsuz içerik,şikayet et!" class="begenmek">şikayet et!</a> </p>'  
			      +'<a href="baslik/'+val.entryId+'/0" style="color: gray"> <b>devamını oku..</b></a>'
			      +'<hr>';
					}

				});
			 		
				$("#yakalaentry").html(list);	
				
				
				},error:function(data){
				alert(data);
				}
		
	});
	

}
