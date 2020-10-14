/*
 * @Author: Paco
 * @Date:   2017-02-07
 * +----------------------------------------------------------------------
 * | jqadmin [ jq酷打造的一款懒人后台模板 ]
 * | Copyright (c) 2017 http://jqadmin.jqcool.net All rights reserved.
 * | Licensed ( http://jqadmin.jqcool.net/licenses/ )
 * | Author: Paco <admin@jqcool.net>
 * +----------------------------------------------------------------------
 */

var oneList = {} ;

layui.define(['jquery', 'dtable', 'jqdate', 'ajax', 'jqform', 'upload', 'layer'], function(exports) {
    var $ = layui.jquery,
        list = layui.dtable,
        ajax = layui.ajax,
        laydate = layui.laydate,
        form = layui.jqform,
        layer = layui.layer;

        oneList = new list();
        oneList.init('list-tpl');
    /**
     * ajax回调
     */
    ajax.reloadTab = function(ret, options, that) {
    	 oneList.init('list-tpl');
    }
    
    //上传文件设置
//    layui.upload({
//        url: './php/upload.php',
//        before: function(input) {
//            box = $(input).parent('form').parent('div').parent('.layui-input-block');
//            if (box.next('div').length > 0) {
//                box.next('div').html('<div class="imgbox"><p>上传中...</p></div>');
//            } else {
//                box.after('<div class="layui-input-block"><div class="imgbox"><p>上传中...</p></div></div>');
//            }
//        },
//        success: function(res) {
//            if (res.status == 200) {
//                box.next('div').find('div.imgbox').html('<img src="' + res.url + '" alt="..." class="img-thumbnail">');
//                box.find('input[type=hidden]').val(res.url);
//                form.check(box.find('input[type=hidden]'));
//            } else {
//                box.next('div').find('p').html('上传失败...')
//            }
//        }
//    });
    function importSuccess() {
        layer.msg("导入成功", {icon:6, time:1000}, function(index){
//            layer.close(index);
//            window.location.href = '/';
        });
    }
    function importError(msg) {
        layer.msg(msg, {icon:5, time:2000}, function(index){
            //$("#J_validateCode").attr('src', '/servlet/validateCodeServlet?width=110&height=38&'+Math.random());
//            layer.close(index);
        });
    }
    layui.upload({
        url: '/product/importExcel',
        before: function(input) {
            box = $(input).parent('form').parent('div').parent('.layui-input-block');
            if (box.next('div').length > 0) {
                box.next('div').html('<div class="imgbox"><p>上传中...</p></div>');
            } else {
                box.after('<div class="layui-input-block"><div class="imgbox"><p>上传中...</p></div></div>');
            }
        },
        success: function(res) {
            if (res.status == 200) {
                importSuccess();
//                box.next('div').find('div.imgbox').html('<img src="' + res.url + '" alt="..." class="img-thumbnail">');
//                box.find('input[type=hidden]').val(res.url);
//                form.check(box.find('input[type=hidden]'));
            } else {
                importError(ret.msg);
            }
        }
    });



    exports('list', {});
});