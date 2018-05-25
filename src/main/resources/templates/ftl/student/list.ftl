<!DOCTYPE html>
<html>
<head>
    <#include "../main/head.ftl" />
</head>
<body>
    <div style="padding: 15px;">
        <div class="demoTable">
            搜索ID：
            <div class="layui-inline">
                <input class="layui-input" name="id" id="demoReload" autocomplete="off">
            </div>
            <button class="layui-btn" data-type="reload">搜索</button>
        </div>

        <table class="layui-table" lay-skin="line">
            <colgroup>
                <col width="100">
                <col>
                <col>
                <col>
                <col width="200">
            </colgroup>
            <thead>
            <tr>
                <th>序号</th>
                <th>编号</th>
                <th>姓名</th>
                <th>年龄</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <#list studentList as stu>
            <tr>
                <td>${stu_index+1   }</td>
                <td>${stu.studentNumber}</td>
                <td>${stu.studentName}</td>
                <td>${stu.age}</td>
                <td>
                    <button class="layui-btn layui-btn-normal layui-btn-sm" onclick="toEdit('${stu.studentNumber}')"><i class="layui-icon"></i></button><#-- 修改 -->
                    <button class="layui-btn layui-btn-danger layui-btn-sm" onclick="del('${stu.studentNumber}')"><i class="layui-icon"></i></button><#-- 删除 -->
                </td>
            </tr>
            </#list>
            </tbody>
        </table>
        <button class="layui-btn layui-btn-normal" onclick="toEdit('')">新增</button>
    </div>
    <#include "../main/bottom.ftl" />
    <script type="text/javascript">
        // 编辑
        function toEdit(studentNumber) {
            layer.open({
                title: studentNumber == "" ? "新增" : "编辑",
                type: 2,
                area: ['500px' , '240px'],
                content: '/student/toEdit?studentNumber=' + studentNumber //如果你不想让iframe出现滚动条，content: ['http://sentsin.com', 'no']
            });
        }

        // 删除
        function del(studentNumber) {
            layer.confirm("确定要删除？", function() {
                $.ajax({
                    url: "/student/del.do",
                    type: 'GET',
                    data: {"studentNumber": studentNumber},
                    success: function (data) {
                        if (data != 'success') {
                            layer.alert("删除失败，请重试！");
                        } else {
                            window.location.reload();
                        }
                    },
                    error: function () {
                        layer.alert("删除失败，请重试！");
                    }
                });
            });

        }
    </script>
</body>
</html>