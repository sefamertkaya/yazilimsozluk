<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html >
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>yazilimsozluk</title>
  <link rel="shortcut icon" href="/images/cp_ico.png">

  
  <!--stylesheets / link tags loaded here-->


<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
  <link rel="stylesheet" href="./../lib/css/bootstrap.min.css" />
  <link href="./../lib/css/font-awesome.min.css" rel="stylesheet" />
  <link rel="stylesheet" type="text/css" href="./../lib/css/style.css" >
</head>

<body>


<input style="display: none" hidden value="${user.userId}" id="userIdDavali" />
<input style="display: none" hidden value="${userSession}" id="userIdDavaci" />

<nav class="navbar navbar-expand-md navbar-dark fixed-top navbar-fixed-width">

   <div class="container-fluid">
       
                <button class="navbar-toggler navbar-toggler-left" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        		<span class="navbar-toggler-icon"></span>
    			</button>
    			    	 <a href="./../anasayfa" class="logo"> <h4 class="col-lg-3 col-md-3 d-none d-sm-none d-sm-block d-xs-block">yazılımsözlük.com</h4></a> 
    			
    				<input type="text" style="" class="form-control col-6 offset-lg-1 col-lg-5 col-md-3" placeholder="Aramak istediğiniz şeyi yazın" maxlength="1000" >
			         <br>
			         <br> 
                <input type="button" style="margin-left:10px;" class="btn btn-info col-md-1 col-2 " value="Ara">

    
    <div class="collapse navbar-collapse col-2 offset-lg-1 col-lg-2 col-md-1" id="navbarNavDropdown">
        <ul class="navbar-nav " style="">
            <li class="nav-item active">
           
            </li>
            <li class="nav-item"> 
             
            </li>
 <li class="nav-item"> 
            
            </li>
        </ul>
    </div>
</div>
</nav>	

		

	<div class="row" id="body-row">
    <div id="sidebar-container" class="sidebar-expanded d-none d-md-block col-3" >
        <ul class=" sticky-top sticky-offset sidebar-liste" style="">
             <h6 style="margin-top:5px" align=center>en popüler başlıklar</h6>
             <hr>
 	
<div id="popular" style="font-size: 14px;"></div>

           
        </ul>
        <!-- List Group END-->
    </div>

    <!-- sidebar-container END -->

    <!-- MAIN -->
    <div  class="col py-3">

 
 
 <h4>${user.username} kullanıcısını şikayet</h4>
            <hr>
            <p style="font-size: 16px">şikayet sebebinizi aşağıya yazınız</p>
            <p style="font-size: 14px;color: red">** incelendikten sonra size geri dönüş yapılacaktır.</p>
            <textarea rows="10" style="width: 70vh;resize: none" id="sikayet"></textarea>
            <br>
            <button type="button" class="btn btn-danger"  onclick="sikayet()"  style="margin-left: 57vh">gönder</button>
			<br>
			<br>
			<div class="alert alert-danger" style="width: 90%;font-size: 13px;display:none" id="gonderdik"> 
    <strong>Tamamdır!</strong> Şikayetiniz alınmıştır. En kısa sürede inceleyip sonucu size bildireceğiz.

  </div>

    </div>
<div id="sidebar-container" class="sidebar-expanded d-none d-md-block">
        <ul class="list-group sticky-top sticky-offset">
        	<li>
        
					       <a href="baslikac" class=" list-group-item-action list-style">        
                            <span class="menu-collapsed"><input type="button" class="btn btn-info" style="width: 100%" value="Başlık Aç" name=""> </span>      
                            </a>    
                            
        	</li>
        	<br>
           <li style="font-size: 14px;">

                        <h6 align=center>Günün Bilgisi</h6>
                        <hr>
                        <p><b style="color: crimson;font-size: 14px;">Önbellek nasıl çalışır?</b></p>
                        <p style="font-size: 14px;"> Ön bellek adeta işlemcinin “top 10” listesi gibi çalışır. Bellek kontrolörü işlemciden gelen istemleri önbelleğe kaydeder, işlemci her istemde bulunduğunda ön belleğe kaydedilir ve 
                        en fazla yapılan istem listenin en üstüne yerleşir buna “cache hit” adı verilir.
                        Önbellek dolduğunda ve işlemciden yeni istem geldiğinde; sistem, uzun süredir 
                        kullanılmayan (listenin en altındaki) kaydı siler ve yeni istemi kaydeder.</p>          
                         </li>

        </ul>
        <!-- List Group END-->
    </div>

</div>
<script src="./../lib/js/jquery.min.js"></script>
<script src="./../lib/js/bootstrap.min.js"></script>
<script src="./../assets/js/sikayet.js"></script>
<script src="./../assets/js/PopularEntryProfilSession.js"></script>
</body>
</html>