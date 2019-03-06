$(document).ready(function(){
	profil();
	
});

function profil(){	
	

	
	$.ajax({
		
		type:"POST",
			url:"./../getUserData",
			contentType:"text/plain",
			data:$("#profilid").val(),


		success:function(data){
	 		
			document.getElementById("name").innerHTML =data.username;

				
				},error:function(data){
				alert(data);
				}
		
	});
	

}
