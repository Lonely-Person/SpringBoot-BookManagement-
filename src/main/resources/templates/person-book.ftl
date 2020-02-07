<#--
  Created by IntelliJ IDEA.
  User: Rongdi
  Date: 2020/1/22
  Time: 23:25
  To change this template use File | Settings | File Templates.
-->
<!DOCTYPE html>
<html lang="en">
<head>
    <#include "component/head.ftl"/>
    <title>个人图书</title>
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">

    <!-- Navbar -->
    <#include "component/navbar.ftl"/>


    <!-- Main Sidebar Container -->
    <#include "component/sidebar.ftl"/>

    <!-- Content Wrapper. Contains page content -->
    <#include "component/book-list-content.ftl"/>


    <!-- Control Sidebar -->
    <#include "component/control-sidebar.ftl"/>

    <!-- Main Footer -->
    <#include "component/footer.ftl"/>
</div>
<!-- ./wrapper -->

<!-- REQUIRED SCRIPTS -->

<#--JS File-->
<#include "component/jsfile.ftl"/>
<script>
    $(function () {
        $("#example1").DataTable();
        $('#example2').DataTable({
            "paging": true,
            "lengthChange": false,
            "searching": false,
            "ordering": true,
            "info": true,
            "autoWidth": false,
        });
    });
</script>
</body>
</html>