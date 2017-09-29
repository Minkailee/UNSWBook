<%@page contentType="text/html" import="myData.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"> 
	<title>Upload Image</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
</head>

<body>
	<form name="form1" action="uploadImg" enctype="multipart/form-data" method="post"> 
		<div>
	    <input type="file" id="file" name="image" accept="image/*" />
	    <button type="submit" class="btn btn-primary">Upload</button>
	    </div>
    </form>
    <div id="image" style="width:400px; height:300px; background:#CCCCCC; float:left;">
        <img src="" alt="No Image"/>
    </div>

	<form name="form1" action="getData" method="post"> 
		<div>
	    <button type="submit" class="btn btn-primary">GetData</button>
	    </div>
    </form>
	
	<script>
	document.getElementById('file').onchange = function() {
	    var imgFile = this.files[0];
	    var fr = new FileReader();
	    fr.onload = function() {
	        document.getElementById('image').getElementsByTagName('img')[0].src = fr.result;
	    };
	    fr.readAsDataURL(imgFile);
	    
	};
	</script>
</body>
</html>