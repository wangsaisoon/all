<!DOCTYPE html>
<html>
<head>
  <#include "head.ftl" />
</head>
<body>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <#include "top.ftl" />
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <#include "left.ftl" />
        </div>
    </div>

    <div class="layui-body">
        <#--<#include "tab.ftl" />-->
        <!-- 内容主体区域 -->
        <iframe src="//www.baidu.com" frameborder="0" name="mainIFrame" id="demoAdmin" style="width: 100%; height: 99%;"></iframe>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © wangsaisoon - SpringBoot MyBatis MySql FreeMarker Layer
    </div>
</div>
<script src="../plugins/layui/layui.js" charset="utf-8"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;
    });
</script>
</body>
</html>