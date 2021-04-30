var dd=0;
role=$(".role").val();
function demo(url,id,buttom){
		//alert(url)
		
		var uid=$(".uid").val();
 		var ise={
 			"id":id,//自身id
 			"uid":uid,//账号的id
 			"rid":role//角色id
 		};
 		 /*$("[src="+buttom+"]").remove();*/
 		if(dd!=-1){
 			 dd++;
 			 //alert(dd)
 			 /*$("[src='"+buttom+"']").remove();*/
 			 if(dd!=1){
 				dd--;
 	 			//alert(dd)
 	 			$("[src='"+buttom+"']").remove();
 			 }
 			$("#div").load(url+" #ssdiv>*",ise,function(){	
 	           var sc =  document.createElement("script");
 	           sc.src= buttom;  //是你数据表格的js  
 	           $("body").append(sc);
 	           $("#toolbarDemo").css('display','none');
 	          
 	        })  
 		}
} 
