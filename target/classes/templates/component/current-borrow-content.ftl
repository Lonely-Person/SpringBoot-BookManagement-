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
                    <h1>当前借阅(${userCurrentBorrowNum}/10)</h1>
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
                                <th>书名</th>
                                <th>作者</th>
                                <th>出版社</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list currentBorrow as book>
                                <tr>
                                    <td>${book.bookName}</td>
                                    <td>${book.bookAuthor}</td>
                                    <td>${book.bookPublisher}</td>
                                    <td>
                                        <a href="/user/return-book/${book.bookId}">
                                            <button type="button" class="btn btn-block bg-gradient-warning btn-sm">归还</button>
                                        </a>

                                    </td>
                                </tr>
                            </#list>
                            </tbody>
                            <tfoot>
                            <tr>
                                <th>Rendering engine</th>
                                <th>Browser</th>
                                <th>Platform(s)</th>
                                <th>Engine version</th>
                                <th>CSS grade</th>
                            </tr>
                            </tfoot>
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