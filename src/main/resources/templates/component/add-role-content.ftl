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
                    <h1>图书管理</h1>
                </div>
                <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                        <li class="breadcrumb-item"><a href="#">Home</a></li>
                        <li class="breadcrumb-item active">添加图书</li>
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
                    <h3 class="card-title">已有角色</h3>
                    <div class="card-tools">
                        <button type="button" class="btn btn-tool" data-card-widget="collapse"><i class="fas fa-minus"></i></button>
                    </div>
                </div>
                <div class="card-body">
                    <div class="row">
                        <#list allRole as role>
                            <ul>
                                <li style="list-style: none"><button type="button" class="btn btn-info">${role.roleName}</button></li>
                            </ul>
                        </#list>
                    </div>
                </div>
            </div>
            <div class="card card-default">
                <div class="card-header">
                    <h3 class="card-title">添加角色</h3>
                    <div class="card-tools">
                        <button type="button" class="btn btn-tool" data-card-widget="collapse"><i class="fas fa-minus"></i></button>
                    </div>
                </div>
                <form action="/admin/doAddRole" method="post">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <button type="button" class="btn btn-danger">角色名</button>
                                    </div>
                                    <input type="text" name="roleName" class="form-control">
                                </div>
                            </div>
                            <div class="col-md-6">
                                <input type="submit"  class="btn btn-warning"/>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </section>
</div>

