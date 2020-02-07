<#--
  Created by IntelliJ IDEA.
  User: Rongdi
  Date: 2020/1/14
  Time: 14:15
  To change this template use File | Settings | File Templates.
-->

<!-- Index Content  -->
<#setting date_format="yyyy-MM-dd"/>
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1>所有图书</h1>
                </div>
                <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                        <li class="breadcrumb-item"><a href="#">主页</a></li>
                        <li class="breadcrumb-item active">图书列表</li>
                    </ol>
                </div>
            </div>
        </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">
        <div class="row">
            <div class="col-12">
                <div class="card">
                    <div class="card-header">
                        <h3 class="card-title">DataTable with default features</h3>
                    </div>
                    <!-- /.card-header -->
                    <div class="card-body">
                        <table id="example1" class="table table-bordered table-striped">
                            <thead>
                            <tr>
                                <th>用户名</th>
                                <th>用户状态</th>
                                <th>用户角色</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list allUser as user>
                                <tr>
                                    <td>${user.userName}</td>
                                    <td>
                                        <#if user.userStatus == 1>
                                            <span>激活</span>
                                        <#else>
                                            <span style="color:red">锁定</span>
                                        </#if>
                                    </td>
                                    <td>
                                        <#list user.roles as role>
                                            ${role.roleName}
                                        </#list>
                                    </td>
                                    <td>
                                        <a href="/admin/modUserRoleAndStatus/${user.userName}">
                                        <button type="button" class="btn btn-block bg-gradient-danger btn-sm">
                                            修改
                                        </button>
                                        </a>
                                    </td>
                                </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>
                    <!-- /.card-body -->
                </div>
                <!-- /.card -->
            </div>
            <!-- /.col -->
        </div>
        <!-- /.row -->
    </section>
    <!-- /.content -->
</div>