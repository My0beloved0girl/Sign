
    /*------------- 加载用户数据 --------------------------------*/
    	layui.extend({
    dtree: '{/}js/lay-module/layui_ext/dtree/dtree'   // {/}的意思即代表采用自有路径，即不跟随 base 路径
}).use(['form','layer','laydate','table','laytpl','dtree'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;
    	var dtree = layui.dtree, layer = layui.layer, $ = layui.jquery;
    var tableIns = table.render({
        elem: '#newsList',
        url : 'FJN?action=jsgl',
        toolbar: '#toolbarDemo',
        page : true,
        height: 'full-145',
        limit : 10,
        limits : [10,15,20,25],
        cols : [[
        	{fixed:"left",type: "checkbox", width:50},
            {field: 'id', title: '编号',  align:'center'},
            {field: 'rname', title: '角色', minWidth:100, align:"center"},
        ]]
    });
  //工具栏事件
	table.on('toolbar(newsList)', function(obj){
		var checkStatus = table.checkStatus(obj.config.id);
		var data = checkStatus.data;
		var roleid = '';
		for(i=0;i<data.length;i++){
			roleid = data[i].id;
		}
		switch(obj.event){
		  case 'deljs':	//删除角色
			  if(data.length != 1){
				  layer.msg("请选择一行数据进行操作")
				  return false;
			  }
			  layer.confirm('删除角色后用户对应的权限也会删除,确定删除吗?', {icon: 3, title:'提示'}, function(index){
				  delRole(roleid);
				  layer.close(index);
			  });
		  break;
		  
		  case 'upajs':	//修改角色
			  if(data.length != 1){
				  layer.msg("请选择一行数据进行操作")
				  return false;
			  }else{
				  upRole(roleid);
			  }
		  break;
		  case 'hairMenu':	//分配权限
				if(data.length == 0 || data.length > 1){
					layer.msg("请选择一行数据进行操作")
					return ;
				}else{
					hair(roleid);
				}
	      break;
		  case 'insjs':	//新增角色
			  addRole();
		  break;
		  
		  case 'upRoleMenu':	//修改角色权限
			  if(data.length == 0 || data.length > 1){
				  layer.msg("请选择一行数据进行操作")
				  return ;
			  }else{
				  upRoleMenu(roleid);
			  }
		  break;
	};
  });
	
	//分配权限
    function hair(roleid){
    	layui.layer.open({
    		title : "分配权限",
    		type : 1,
    		content : $("#divdiv"),
    		area:['300px','500px'],
    		
    		success:function(){
    			 //alert(userid);
    		    //给dtree树加载数据
    			dtree.render({
   				  elem: "#database",
   				  url: "/Sign/FPS?action=fpqx",
   				  dataStyle: "layuiStyle",  //使用layui风格的数据格式
   				  dataFormat: "list",  //配置data的风格为list
   				  response:{message:"msg",statusCode:0},  //修改response中返回数据的定义
   				  checkbar:true,
   				  line: true,  // 显示树线
   				  done: function(res, $ul, first){
   					  $.ajax({
   						  url:"/Sign/FPS?action=fphx",
   						  type:"post",
   						  data:{"userid":roleid},
   						  success:function(res){
   							  var cs = eval('(' + res + ')');
   							  $.each(cs,function(index,row){
   								dtree.chooseDataInit("database",[row.menuid]); // 初始化选中
   							  })
   						  }
   					  })
   		    	  }
    			});
    		},
    		btn:['分配权限'],
    		yes: function(index, layero){
    			//alert(index);
    			//alert(layero);
    			var params = dtree.getCheckbarNodesParam("database");
    			var infos = JSON.stringify(params);
    			var cs = eval('(' + infos + ')');
    			var menuidList = new Array();	//所有选中值的权限id
    			//alert(menuidList.length);
    			$.each(cs,function(index,row){
   					menuidList[index] = row.nodeId;
    			})
    			$.ajax({
    				url:"/Sign/FPS?action=fpqb",
    				data:{"array":menuidList,"userid":roleid},
    				type:"post",
    				traditional:true,
    				success:function(data){
    					if(data !=0){
    						layer.msg("分配成功");
    						layer.close(index)	//关闭
    					}else{
    						layer.msg("分配失败");
    					}
    				}
    			})
    		}
    	})
    }
	
	//删除角色
	function delRole(roleid){
		//alert(roleid);
		$.ajax({
			url:"JSS?action=deljs",
			type:"post",
			data:{"roleid":roleid},
			success:function(data){
				if(data == 1){
					layer.msg("删除成功");
					tableIns.reload("#newsList");
				}
			}
		})
	}
	
	
	//新增角色
	function addRole(){
		layui.layer.open({
    		title : "新增角色",
    		type : 2,
    		content : "jsjjsp/jueseadd.jsp",
    		area:['350px','200px'],
		});
	}
	
	//修改角色
	function upRole(roleid){
		layui.layer.open({
    		title : "修改角色",
    		type : 2,
    		content : "jsjjsp/jueseupa.jsp",
    		area:['350px','230px'],
    		success:function(layero, index){
    			$.ajax({
    				url:"JSS?action=idjs",
    				type:"post",
    				data:{"roleid":roleid},
    				success:function(data){
    					var info = eval("("+data+")")
    					var body = layui.layer.getChildFrame('body', index);
    					body.find("#roleid").val(info.data[0].id);
    					body.find("#rname2").val(info.data[0].rname);
    					body.find("#rname").val(info.data[0].rname);
    				}
    			})
/*        			//获取新窗口对象
                var iframeWindow = layero.find('iframe')[0].contentWindow;
                //重新渲染
                iframeWindow.layui.form.render();*/
    		}
		});
	}
	
	
	
	
	
   })
	


