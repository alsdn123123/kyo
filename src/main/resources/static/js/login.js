layui.use(['layer', 'form'], function() {
    var form = layui.form,layer = layui.layer;
    //自定义验证规则
    form.verify({
        loginCode: [/^.{5,20}$/, '登陆账号必须5到20位'],
        pass: [/^.{6,20}$/, '密码必须6到20位']
    });

    form.on('submit(login)', function(data){
        vm.login();
        return false;
    });

    var vm = new Vue({
        el:"#login",
        data:{
            loginCode:'',
            password:''
        },
        mounted: function () {
            this.$nextTick(function () {
            })
        },
        methods:{
            login:function () {
                var url = prefixUrl+"login/login";
                axios.get(url+"?loginCode="+vm.loginCode+"&password="+vm.password)
                    .then(function (response) {
                        console.log(response.data);
                        if(response.data.errcode=='0'){
                            layer.msg(response.data.errmsg, {icon: 1,time: 1000});
                            window.location.href=prefixUrl+"index";
                        }else{
                            layer.msg(response.data.errmsg, {icon: 5,time: 1000,anim: 6});
                        }
                 });

                // axios.post(url, {
                //         loginCode: vm.loginCode,
                //         password:vm.password
                // })
                // .then(function (response) {
                //     console.log(response.data);
                //     if(response.data.errcode=='0'){
                //         layer.msg(response.data.errmsg, {icon: 1,time: 1000});
                //         window.location.href=prefixUrl+"index/index";
                //     }else{
                //         layer.msg(response.data.errmsg, {icon: 5,time: 1000,anim: 6});
                //     }
                // })
                // .catch(function (error) {
                //     console.log(error.data);
                //     layer.msg('系统异常，请刷新后重试！', {icon: 5,time: 1000,anim: 6});
                // });
            }
        }
    });
});