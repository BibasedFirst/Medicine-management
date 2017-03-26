<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户分布</title>
<script type="text/javascript" src="<%=path %>/js/bzt/jquery.js"></script>
<script type="text/javascript" src="<%=path %>/js/bzt/jsapi.js"></script>
<script type="text/javascript" src="<%=path %>/js/bzt/corechart.js"></script>
<script type="text/javascript" src="<%=path %>/js/bzt/jquery.gvChart-1.0.1.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/bzt/jquery.ba-resize.min.js"></script>
<script type="text/javascript">
	gvChartInit();
	$(document).ready(function() {
		$('#myTable5').gvChart({
			chartType : 'PieChart',
			gvSettings : {
				vAxis : {
					title : 'No of players'
				},
				hAxis : {
					title : 'Month'
				},
				width : 400,
				height : 350,
			}
		});
	});
</script>
<script type="text/javascript">
	gvChartInit();
	$(document).ready(function() {
		$('#myTable1').gvChart({
			chartType : 'PieChart',
			gvSettings : {
				vAxis : {
					title : 'No of players'
				},
				hAxis : {
					title : 'Month'
				},
				width : 400,
				height : 350,
			}
		});
	});
</script>
</head>
<body>
	<div style="width: 400px; margin: 0 auto;float: left">
		<table id='myTable5' style="display: none;" >
			<caption>用户分布</caption>
			<thead>
				<tr>
					<th></th>
					<th>管理员</th>
					<th>进货员</th>
					<th>会员</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>1200</th>
					<td>540</td>
					<td>300</td>
					<td>300</td>
				</tr>
			</tbody>
		</table>
		</div>
<div style="width: 400px; margin: 0 auto;float: right;">
		<table id='myTable1'>
			<caption>会员分布情况</caption>
			<thead>
				<tr>
					<th></th>
					<th>冻结</th>
					<th>正常</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>${sum }</th>
					<td>${dj }</td>
					<td>${fdj }</td>
				</tr>
			</tbody>
		</table>
	</div>
	<script src="<%=path %>/js/bzt/_gg_980_90.js" type="text/javascript"></script>
</body>
</html>
