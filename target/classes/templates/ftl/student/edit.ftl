<!DOCTYPE html>
<html>
<head>
    <#include "../main/head.ftl" />
</head>
<body>
    <div style="padding: 15px 0;">
        <form class="layui-form" action="/student/${url !}" method="post" lay-filter="example">
            <input type="hidden" name="studentNumber">
            <div class="layui-form-item">
                <label class="layui-form-label">姓名</label>
                <div class="layui-input-block">
                    <input type="text" name="studentName" required  lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">年龄</label>
                <div class="layui-input-block">
                    <input type="number" name="age" required  lay-verify="required" placeholder="请输入年龄" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="*">提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>
    </div>
    <#include "../main/bottom.ftl" />
    <script>
        <#if msg ??>
            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
            if ("${msg }" == "success") {
                parent.layer.close(index); //再执行关闭
                parent.location.reload();
            } else {
                layer.msg("保存失败，请重试！", {times: 1500}, function() {
                    parent.layer.close(index); //再执行关闭
                    parent.location.reload();
                });
            }
        </#if>

        layui.use(['form'], function(){
            var form = layui.form;

            //自定义验证规则
            form.verify({
                studentName: function(value){
                    if(value.length < 2) {
                        return '姓名至少得2个字符啊';
                    }
                    if (value.length > 5) {
                        return '姓名不能超过5个字符啊';
                    }
                }
                ,age: function(value){
                    if(value <= 0 || value >= 100) {
                        return '年龄介于0~100之间';
                    }
                }
            });

            <#if student ??>
                //表单初始赋值
                form.val('example', {
                    "studentNumber": "${student.studentNumber !}" // "name": "value"
                    ,"studentName": "${student.studentName !}"
                    ,"age": "${student.age !}"
                });
            </#if>
        });
    </script>
</body>
</html>