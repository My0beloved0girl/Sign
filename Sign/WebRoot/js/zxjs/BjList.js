
    /*------------- 加载用户数据 --------------------------------*/
role=$(".role").val();
clas=$(".clas").val();
lognames=$(".loginName").val();
uid=$(".uid").val();
layui.config({
    base: 'js/module/',
}).extend({
    tableMerge: 'tableMerge',
    dtree: 'dtree'
}).use(['table','element','tableMerge','dtree'],function(){

var table = layui.table;
tableMerge = layui.tableMerge;
var element = layui.element;
var dtree = layui.dtree, layer = layui.layer, $ = layui.jquery;
    var tableIns = table.render({
        elem: '#newsList',
        url : 'BJS?action=bjxs&clas='+clas+'&role='+role+'',
        toolbar: '#toolbarDemo',
        page : true,
        height: 'full-145',
        limit : 10,
        limits : [10,15,20,25],
        cols : [[
        	{fixed:"left",type: "checkbox", width:50},
            {field: 'id', title: '编号',  align:'center',hide:true},
            {field: 'clas', title: '班级', minWidth:100, align:"center",merge:true},
            {field: 'userName', title: '姓名', minWidth:100, align:"center"},
            {field: 'loginName', title: '登录名',  align:'center'},
            {field: 'sex', title: '用户性别', align:'center',templet:function(d){
                return d.sex == "1" ? "男" : "女";
            }},
            {field: 'identityCode', title: '身份证', align:'center'},
            {field: 'email', title: '邮箱', align:'center'},
            {field: 'mobile', title: '电话', align:'center'},
            {field: 'rname', title: '角色', align:'center'}
        ]],done: function(){
            tableMerge.render(this)
        }
    });
    
  
    
    
   })
	


