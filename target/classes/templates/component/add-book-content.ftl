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
                    <h3 class="card-title">添加图书</h3>
                    <div class="card-tools">
                        <button type="button" class="btn btn-tool" data-card-widget="collapse"><i class="fas fa-minus"></i></button>
                        <button type="button" class="btn btn-tool" data-card-widget="remove"><i class="fas fa-remove"></i></button>
                    </div>
                </div>
                <form action="/book/doAddBook" method="post">
                    <div class="card-body">
                    <div class="row">
                            <div class="col-md-6">
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <button type="button" class="btn btn-danger">书名</button>
                                    </div>
                                    <input type="text" name="bookName" class="form-control">
                                </div>
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <button type="button" class="btn btn-warning">出版社</button>
                                    </div>
                                    <input type="text" name="bookPublisher" class="form-control">
                                </div>
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <button type="button" class="btn btn-success">发布日期</button>
                                    </div>
                                    <input type="date" name="bookPubDate" class="form-control">
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <button type="button"  class="btn btn-info">作者</button>
                                    </div>
                                    <input type="text" name="bookAuthor" class="form-control">
                                </div>
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <button type="button" class="btn btn-primary">数量</button>
                                    </div>
                                    <input type="number" name="bookNumbers" class="form-control">
                                </div>
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <button type="button"  class="btn btn-secondary">登记日期</button>
                                    </div>
                                    <input type="date" name="bookRecord" class="form-control">
                                </div>
                            </div>
                            <input type="submit" class="form-control" style="background-color: darkorange">

                    </div>
                </div>
                </form>
            </div>
        </div>
    </section>
</div>

