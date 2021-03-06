
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html lang="en">
<head>
    <#include "component/head.ftl"/>
    <title>AdminLTE 3 | Starter</title>
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
<!-- page script -->
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
