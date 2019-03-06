function search(){	

	
	$.ajax({
		
		type:"POST",
			url:"ara",
			contentType:"text/plain",
			data:$("#haydiara").val()+"",
	
			
		success:function(data){
	
			
			if(data.entryId!=null){
			$(location).attr('href' ,'baslik/'+data.entryId+'/0');
			}else{
				$(location).attr('href' ,'anasayfa');
				
			}
			
			
			
				},error:function(data){
		
				}
		
	});
	

}

