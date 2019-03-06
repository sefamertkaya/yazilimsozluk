$(document).ready(function(){
	
	getPopular();
	
	
});


function getPopular(){	
	
	$.ajax({
		
		type:"POST",
			url:"getPopular",
			success:function(data){
				
				var list="";
			
				$(data).each(function(i){
			    
				list=list
				+'<li>'
                +'<a href="basliks/'+(data[i][0])+'/0" class="list-group-item list-group-item-action list-style">'        
                +'<span class="menu-collapsed">'+(data[i][1])+'</span>'      
                +'</a>'
                +'</li>';
                
				});
			 		
				$("#popular").html(list);	
				
				
				},error:function(data){
				alert(data);
				}
		
	});
	

}