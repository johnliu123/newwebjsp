<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>excel</title>
</head>

<style>
.text-with-hr {
    text-align: center;
    position: relative;
    z-index: 2;
}
/*
橫線
*/
.text-with-hr:before {
    position: absolute;
    content: '';
    
    left: 0px;
    width: 100%;
    border-bottom: 1px solid #d4d4d4;
    z-index: -1;
}
.text-with-hr span {
    display: inline-block;
    background: white;
    padding: 10px;
}

/*
表格置中
*/
.table th, .table td .table td{
text-align: center;
vertical-align: middle!important;
}


</style>

<body>
<div class="container">
<div class="text-with-hr"></div>
<div>
<p style="display:inline">客戶:</p>
<input type="textbox" class="form-control" id="user" name="user" style="display:inline;width:200px" readonly="readonly">
</div>
<div class="text-with-hr"></div>
<div>
<p style="display:inline">檔案:</p>
<input  type="file"  class="upload" style="display:inline;" id="selectFile"  value="選擇檔案">
</div>
<div class="text-with-hr"></div>
<div class="col-xs-7">
        <div class="text-right">
        	<button type="button" class="btn btn-success" id="upload" name="upload" style="width:100px" onclick="upload()" value="上傳">上傳</button>
            <button type="button" class="btn btn-info" id="cancle" name="cancle"  onclick="cancle()" value="取消">取消</button>
            <button type="button" class="btn btn-warning" id="download" name="download" onclick="download()" value="下載表格範本">下載表格範本</button>
        </div>
</div>

<form action="" method="post">
<table class="table table-bordered" id="table">
<thead>
	<tr>
		<th>功能</th>
		<th>檢核問題</th>
		<th>客戶名稱</th>
		<th>單號</th>
		<th>下單日</th>
		<th>總價</th>
		<th>狀態</th>
		<th>使用禮劵</th>
	</tr>	
</thead>
<tbody>
</tbody>
</table>
</form>

<script type="text/javascript">

document.getElementById("table").style.display="none";

</script>

<script type="text/javascript">
//回到首頁

function cancle() { 
	
	document.getElementById("table").style.display="block";

	//清空table
// 	var table = document.getElementById("table");
// 	var len = table.rows.length;

// 	if(len!=1){

// 		while(table.rows.length >1) {
			
// 	  		table.deleteRow(1);
// 		}
// 	 }


}

</script>


</div>
</body>
</html>