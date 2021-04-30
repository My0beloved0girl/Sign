layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;

  //判断重复
  function checkUname(uname){
	  var is = false;
	  $.ajax({
		  url:"../ZHS?action=pdln",
		  data:{"uname":uname},
		  async:false,
		  type:"post",
		  success:function(data){
			  if(data == 0){
				  is = true;
			  }else{
				  is = false;
			  }
		  }
	  })
	  return is;
  }
  
  
  $("#uname").blur(function(){
	  var name = $("#uname").val();
	  var name2 = $("#uname2").val();
	  if(name !=null && name!=name2 ){
		  var check = checkUname(name);
		  if(check == false){
			  layer.alert("登录账号已存在! 请重新输入");
		  }
	  }
  })
  
  //验证和修改
  $("#xiugai").click(function(){
	  var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/; 
	  var uid = $("#uid").val();
	  var name = $("#uname").val();
	  var name2 = $("#uname2").val();
	  var pass = $("#password").val();
	  var realName = $("#realName").val();
	  var sex = $("input[name='st_Sex']:checked").val();
	  var sfz = $("#sfz").val();
	  var email = $("#email").val();
	  var phone = $("#phone").val();
	  var role = $("select[name='role1']").val();
	  var isStatus = $("input[name='isStatus']:checked").val();
	  var banji = $("#banji").val();
	  var data = {
			  "uid":uid,
			  "name":name,
			  "pass":pass,
			  "realName":realName,
			  "sex":sex,
			  "sfz":sfz,
			  "email":email,
			  "phone":phone,
			  "role":role,
			  "isStatus":isStatus,
			  "banji":banji
	  }
	  if(name.length<3){
		  layer.alert("登录名不能小于3位数")
		  return false;
	  }else if(pass.length < 5 || pass.length > 19){
		  layer.alert('密码必须6到12位，且不能出现空格');
		  return false;
	  }else if(!sfz.match(reg)){
		  layer.alert('身份证邮箱格式不正确！请重新输入');
		  return false;
	  }else if(banji.length == "" || banji.length == null){
		  layer.alert('班级不能为空');
		  return false;
	  }else if(realName.length == "" || realName.length == null){
		  layer.alert('用户名不能为空');
		  return false;
	  }else if(!email.match(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/)){
		  layer.alert("邮箱格式不正确！请重新输入");
		  return false;
	  }else if(phone.length != 11){
		  layer.alert("手机格式不正确! 请重新输入");
		  return false;
	  }else if(name !=null && name!=name2 ){
		  var check = checkUname(name);
		  if(check == false){
			  layer.alert("登录账号已存在! 请重新输入")
			  return false;
		  }
	  }
	 
	 
	  $.ajax({  
	  		url:"../ZHS?action=upzh",
			data:data,
			tyep:"post",
			success:function(data){
				//alert(data)
				if(data==1){
					layer.msg("用户信息修改成功");
					setTimeout(function(){
						layer.closeAll("iframe");
			            //刷新父页面
			            parent.location.reload();
		        	},1000);
				}else{
					layer.msg("系统异常");
				}
			}
	  })
	  return false;
  })
  
});
