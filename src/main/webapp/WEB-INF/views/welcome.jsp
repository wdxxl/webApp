<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<!-- Bootstrap Core CSS file -->
<link type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap.min.css'></c:url>" rel="stylesheet" />
<!-- Bootstrap Theme file (Optional) -->
<link type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap-theme.min.css'></c:url>" rel="stylesheet" />
<!-- jQuery file (make sure loaded before bootstrap.min.js ) -->
<script type="text/javascript" src="<c:url value='/resources/jQuery/jquery-1.10.2.js'></c:url>"></script>
<!-- Bootstrap Core JavaScript file -->
<script type="text/javascript" src="<c:url value='/resources/bootstrap/js/bootstrap.min.js'></c:url>"></script>

<script type="text/javascript">
	function assertAlertMsg(msg){
		var htmlTag = "<div id='alertMsg' class='alert offset2'><a class='close' data-dismiss='alert'>x</a>"+msg+"</div>";
		$("#alertMsgDiv").html(htmlTag);
		$("#alertMsg").delay(5000).fadeOut(500);
	}
	function assertSuccessMsg(msg){
		var htmlTag = "<div id='alertMsg' class='alert alert-success offset2'><a class='close' data-dismiss='alert'>x</a>"+msg+"</div>";
		$("#alertMsgDiv").html(htmlTag);
		$("#alertMsg").delay(5000).fadeOut(500);
	}
	function assertInfoMsg(msg){
		var htmlTag = "<div id='alertMsg' class='alert alert-info offset2'><a class='close' data-dismiss='alert'>x</a>"+msg+"</div>";
		$("#alertMsgDiv").html(htmlTag);
		$("#alertMsg").delay(5000).fadeOut(500);
	}
	function assertWarningMsg(msg){
		var htmlTag = "<div id='alertMsg' class='alert alert-warning offset2'><a class='close' data-dismiss='alert'>x</a>"+msg+"</div>";
		$("#alertMsgDiv").html(htmlTag);
		$("#alertMsg").delay(5000).fadeOut(500);
	}
	function assertDangerMsg(msg){
		var htmlTag = "<div id='alertMsg' class='alert alert-danger offset2'><a class='close' data-dismiss='alert'>x</a>"+msg+"</div>";
		$("#alertMsgDiv").html(htmlTag);
		$("#alertMsg").delay(5000).fadeOut(500);
	}
</script>

</head>
<body>
<div class="container">
	<div id="alertMsgDiv" class="span12"></div>
	<h6>Button Group and CSS alert (Alert/Success/Info/Warning/Danger)</h6>
	<div class="btn-group">
		<button type="button" class="btn btn-default" onclick="javascript:assertAlertMsg('Alert')">Alert</button>
		<button type="button" class="btn btn-default" onclick="javascript:assertSuccessMsg('Success')">Success</button>
		<button type="button" class="btn btn-default" onclick="javascript:assertInfoMsg('Info')">Info</button>
		<button type="button" class="btn btn-default" onclick="javascript:assertWarningMsg('Warning')">Warning</button>
		<button type="button" class="btn btn-default" onclick="javascript:assertDangerMsg('Danger')">Danger</button>
	</div>
	<h2>Hello World!</h2>
</div>
</body>
</html>
