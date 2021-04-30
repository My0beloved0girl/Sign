
    /*------------- 加载用户数据 --------------------------------*/
role=$(".role").val();
clas=$(".clas").val();
lognames=$(".loginName").val();
uid=$(".uid").val();
    	layui.use('table', function(){	
    		  var table = layui.table;
    var tableIns = table.render({
        elem: '#newsList',
        url : 'FJN?action=qdaogl&role='+role+'&clas='+clas+'&logname='+lognames+'',
        toolbar: '#toolbarDemo',
        page : true,
        height: 'full-145',
        limit : 10,
        limits : [10,15,20,25],
        cols : [[
        	{fixed:"left",type: "checkbox", width:50},
            {field: 'id', title: '编号',  align:'center',hide:true},
            {field: 'name', title: '姓名', minWidth:100, align:"center"},
            {field: 'logname', title: '登录名',  align:'center'},
            {field: 'signTime', title: '签到时间', align:'center'},
            {field: 'sex', title: '用户性别', align:'center',templet:function(d){
                return d.sex == "1" ? "男" : "女";
            }},
            {field: 'clas', title: '班级', align:'center'},
            {field: 'rname', title: '角色', align:'center'},
            {field: 'ip', title: 'ip', align:'center'}
        ]]
    });
    
    
    
    table.on('toolbar(newsList)', function(obj){
	    var checkStatus = table.checkStatus(obj.config.id);
	    var data = checkStatus.data;
	    var userid = '';
	    for(i=0;i<data.length;i++){
	    	userid = data[i].id;
	    }
	    switch(obj.event){
	      
	      case 'insqd':	//新增用户
	    	  addUser();
	      break;      
	     
	    };
	  });
  
   
    //签到
    function addUser(){
    	 var ip = window.returnCitySN.cip	
    	$.ajax({
    		url:"QDS?action=insqd",
    		data:{"uid":uid,"ip":ip},
    		type:"post",
    		success:function(data){
    			if(data == 1){
    				layer.msg("签到成功")
    				setTimeout(function(){
			            //刷新父页面
			            parent.location.reload();
		        	},1000);
    			}else if(data==0){
    				layer.msg("亲,您今天已经签到过了哦")
    			}else if(data==3){
    				layer.msg("亲,您不在班级,无法签到哦,快前往教室吧")
    			}
    		}
    	})
    }
    
    
   })
	


