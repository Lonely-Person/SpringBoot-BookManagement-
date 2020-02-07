<#--
  Created by IntelliJ IDEA.
  User: Rongdi
  Date: 2020/1/14
  Time: 14:14
  To change this template use File | Settings | File Templates.
-->

<aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="/logout" class="brand-link">
        <img src="/dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
             style="opacity: .8">
        <span class="brand-text font-weight-light">退出登录</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
        <!-- Sidebar user panel (optional) -->
        <div class="user-panel mt-3 pb-3 mb-3 d-flex">
            <div class="image">
                <img src="/dist/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
            </div>
            <div class="info">
                <a href="#" class="d-block">${Session.userName}</a>
            </div>
        </div>

        <!-- Sidebar Menu -->
        <nav class="mt-2">
            <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                <!-- Add icons to the links using the .nav-icon class
                     with font-awesome or any other icon font library -->
                <li class="nav-item has-treeview menu-open">
                    <a href="#" class="nav-link active">
                        <i class="nav-icon fas fa-tachometer-alt"></i>
                        <p>
                            图书信息
                            <i class="right fas fa-angle-left"></i>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                        <li class="nav-item">
                            <a href="/book/book-list" class="nav-link active">
                                <i class="far fa-circle nav-icon"></i>
                                <p>所有图书</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="/book/addBook" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>添加图书</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="javascript:void(0)" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>待定功能</p>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item has-treeview menu-open">
                    <a href="#" class="nav-link active">
                        <i class="nav-icon fas fa-tachometer-alt"></i>
                        <p>
                            个人信息
                            <i class="right fas fa-angle-left"></i>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                        <li class="nav-item">
                            <a href="javascript:void(0)" class="nav-link active">
                                <i class="far fa-circle nav-icon"></i>
                                <p>个人主页</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="/user/current-borrow" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>当前借阅</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="javascript:void(0)" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>待定功能</p>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item has-treeview menu-open">
                    <a href="#" class="nav-link active">
                        <i class="nav-icon fas fa-tachometer-alt"></i>
                        <p>
                            用户管理
                            <i class="right fas fa-angle-left"></i>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                        <li class="nav-item">
                            <a href="/admin/allUser" class="nav-link active">
                                <i class="far fa-circle nav-icon"></i>
                                <p>查看用户</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="javascript:void(0)" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>添加用户</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="/admin/addRole" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>添加角色</p>
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </nav>
        <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
</aside>