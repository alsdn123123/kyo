var prefixUrl = "http://localhost:8080/hjy/";
//JavaScript代码区域
layui.use(['layer', 'element'], function(){
    var element = layui.element,layer = layui.layer;;

   // layer.msg('系统异常，请刷新后重试！', {icon: 5,time: 1000,anim: 6});
});

var vm = new Vue({
    el:"#index",
    data:{
        admin:{
        	id:'',
            name:''
        },
        menuList:null,
        contentUrl:"",
        contentName:"主页"
    },
    mounted: function () {
        this.$nextTick(function () {
           vm.getAdmin();
           vm.getMenuList();
           vm.openIframe();
        })
    },
    methods:{
        getAdmin:function () {
            var url = prefixUrl+"hjyAdmin/getFromSession";
            axios.post(url)
                .then(function (response) {
                	console.log("import");
                    console.log(response.data);
                    if(response.data.errcode=='0'){
                        vm.admin = response.data.data;
                    }else{
                        layer.msg(response.data.errmsg, {icon: 5,time: 1000,anim: 6});
                    }
                })
                .catch(function (error) {
                    console.log(error.data);
                    layer.msg('系统异常，请刷新后重试！', {icon: 5,time: 1000,anim: 6});
                });
        },

        getMenuList:function () {
            var url = prefixUrl+"menu/list";
            axios.post(url)
                .then(function (response) {
                    console.log(response.data);
                    if(response.data.errcode=='0'){
                        vm.menuList = response.data.data;
                    }else{
                        layer.msg(response.data.errmsg, {icon: 5,time: 1000,anim: 6});
                    }
                })
                .catch(function (error) {
                    console.log(error.data);
                    layer.msg('系统异常，请刷新后重试！', {icon: 5,time: 1000,anim: 6});
                });
        },

        loginOut:function () {
            var url = prefixUrl+"login/loginOut";
            axios.post(url)
                .then(function (response) {
                    console.log(response.data);
                    if(response.data.errcode=='0'){
                        layer.msg(response.data.errmsg, {icon: 1,time: 1000});
                        window.location.href=prefixUrl+"index/hjyback";
                    }else{
                        layer.msg(response.data.errmsg, {icon: 5,time: 1000,anim: 6});
                    }
                })
                .catch(function (error) {
                    console.log(error.data);
                    layer.msg('系统异常，请刷新后重试！', {icon: 5,time: 1000,anim: 6});
                });
        },

        openIframe:function (menu) {
            if(menu.url==undefined || menu.url==null || menu.url==''){
                layer.msg('该功能暂未开放！', {icon: 5,time: 1000,anim: 6});
                return;
            }
            vm.contentUrl=prefixUrl+menu.url;
            vm.contentName=menu.menuName;
        },
        
        openIframePw:function () {
        	console.log(vm.admin.id);
            vm.contentUrl=prefixUrl+'/hjyAdmin/updateOnePw?id='+vm.admin.id;
            vm.contentName='密码修改';
        }
    }
});