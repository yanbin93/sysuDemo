<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.net.InetAddress"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
InetAddress ia = null;
ia=ia.getLocalHost();
		              
		             String localname=ia.getHostName();
		             String localip=ia.getHostAddress();%>
		              <script src="js/jquery/QRcode_picture/src/qrcode.js"></script>
        <script src="js/jquery/QRcod_picture/dist/qart.min.js"></script>
	<script src="http://cdn.bootcss.com/jquery/1.11.0/jquery.min.js" type="text/javascript"></script>
	<script>window.jQuery || document.write('<script src="js/jquery-1.11.0.min.js"><\/script>')</script>
	<script type="text/javascript">
		$(document).ready(function() {
                var value = "<%=localip%>";
                var filter = 'threshold';
                var imagePath = 'lib/fangwei.png';

                var self = this;

                function makeQR() {
                    var qr = qrcode.QRCode(10, 'H');
                    qr.addData(value);
                    qr.make();
                    document.getElementById('qr').innerHTML = qr.createImgTag(3);
                }

                function makeQArt() {
                    new QArt({
                        value: value,
                        imagePath: imagePath,
                        filter: filter
                    }).make(document.getElementById('combine'));
                }

                function getBase64(file, callback) {
                    var reader = new FileReader();
                    reader.readAsDataURL(file);
                    reader.onload = function () {
                        callback(reader.result);
                    };
                }

                $('#value').keyup(function() {
                    value = $(this).val();
                    makeQR();
                    makeQArt();
                });

                $('#file').change(function() {
                    getBase64(this.files[0], function(base64Img) {
                        var regex = /data:(.*);base64,(.*)/gm;
                        var parts = regex.exec(base64Img);
                        imagePath = parts[0];
                        $('#image img').attr('src', imagePath);
                        makeQArt();
                    });
                });

                $('input[type=radio]').click(function() {
                    filter = $(this).val();
                    makeQArt();
                });

                makeQR();
                makeQArt();
            });
	</script>
</body>
</html>