<%@ page contentType="text/html; charset=UTF-8"  %>
<!DOCTYPE html>
<html>
<head>
    <title>AES.html</title>

    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
</head>

<body>
    <input type="button" onclick="getAes()" value="AES测试">
</body>

<!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
<script src="../../../js/aes.js"></script>
<script>
    var key = getKey();
    var iv = getKey();
    console.log("一个随机16位key     ："+key);
    var json = {};
    json.userid = "xiyang";
    json.moran = "moran";
    var context = AESEnc(key,JSON.stringify(json),iv);
    console.log("AES加密后    ："+context);


    console.log(AESDec(key, context,iv));
    function getAes() {
        window.location.href ="http://localhost:8080/AES?key="+key+"&data="+context+"&iv="+iv;
    }
</script>
</html>
