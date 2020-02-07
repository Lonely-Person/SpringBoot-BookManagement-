<#--
  Created by IntelliJ IDEA.
  User: Rongdi
  Date: 2020/2/5
  Time: 13:59
  To change this template use File | Settings | File Templates.
-->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1>Advanced Form</h1>
                </div>
                <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                        <li class="breadcrumb-item"><a href="#">Home</a></li>
                        <li class="breadcrumb-item active">Advanced Form</li>
                    </ol>
                </div>
            </div>
        </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">
        <div class="container-fluid">
            <div class="card card-default">
                <div class="card-header">
                    <h3 class="card-title">修改用户状态和角色</h3>

                    <div class="card-tools">
                        <button type="button" class="btn btn-tool" data-card-widget="collapse"><i class="fas fa-minus"></i></button>
                    </div>
                </div>
                <form action="/admin/doModUserRoleAndStatus" method="post">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label><span style="font-size: large">用户名</span></label>
                                    <input type="text" name="userName" class="btn btn-block btn-warning" value="${user.userName}"/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label><span style="font-size: large">用户已拥有的角色</span></label>
                                    <br>
                                    <#list user.roles as role>
                                        <button type="button" class="btn btn-info">${role.roleName}</button>
                                    </#list>
                                </div>
                            </div>
                        </div>

                        <hr style="height:1px;background-color: purple"/>

                        <div class="row">
                            <div class="col-12 col-sm-6">
                                <div class="form-group">
                                    <label><span style="font-size: large">移除角色</span></label>
                                    <select name="deleteRole" class="form-control select2 select2-danger" data-dropdown-css-class="select2-danger" style="width: 100%;">
                                        <#list user.roles as role>
                                            <option>${role.roleName}</option>
                                        </#list>
                                        <option value="" style="display: none">不移除</option>
                                    </select>
                                </div>
                                <!-- /.form-group -->
                            </div>
                            <!-- /.col -->
                            <div class="col-12 col-sm-6">
                                <div class="form-group">
                                    <label><span style="font-size: large">增加角色</span></label>
                                    <select name="addRole" class="form-control select2 select2-danger" data-dropdown-css-class="select2-dark" style="width: 100%;">
                                        <#list allRole as role>
                                            <option>${role.roleName}</option>
                                        </#list>
                                        <option value="" style="display: none">不增加</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label><span style="font-size: large">用户当前状态</span></label>
                                    <br>
                                    <#if user.userStatus == 1>
                                        <button type="button" class="btn btn-block btn-info">激活</button>
                                    <#else>
                                        <button type="button" class="btn btn-block btn-danger">锁定</button>
                                    </#if>
                                </div>
                            </div>
                            <div class="col-12 col-sm-6">
                                <div class="form-group">
                                    <label><span style="font-size: large">修改状态</span></label>
                                    <select name="userStatus" class="form-control select2 select2-danger" data-dropdown-css-class="select2-primary" style="width: 100%;">
                                        <option selected="selected">激活</option>
                                        <option>锁定</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <hr style="height:1px;background-color: orange"/>
                        <div class="row">
                            <div class="col-12 col-sm-6">
                                <div class="form-group">
                                    <label><span style="font-size: large"> </span></label>
                                    <input type="submit" class="btn btn-block btn-success">
                                </div>
                            </div>
                        </div>
                    </div>
                </form>

            </div>

                <div class="card-footer">
                    Visit <a href="https://select2.github.io/">Select2 documentation</a> for more examples and information about
                    the plugin.
                </div>
            </div>
    </section>
</div>


