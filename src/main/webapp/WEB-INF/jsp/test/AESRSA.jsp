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
    <input type="button" onclick="getData()" value="AES">
</body>

<!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
<script src="../../../js/aes.js"></script>
<script src="../../../js/rsa.js"></script>
<script>
    var key = getKey();
    var iv = getKey();
    console.log("一个随机16位key     ："+key);
    console.log("一个随机16位iv     ："+iv);
    var json = {};
    json.userid = "xiyang";
    json.moran = "moran";
    var context = AESEnc(key,JSON.stringify(json),iv);
    console.log("AES加密后    ："+context);
    var rsaKey = RSA(key);
    var rsaIV = RSA(iv);
    console.log("rsaKey     ："+rsaKey);
    console.log("rsaIV     ："+rsaIV);
    console.log(AESDec(key, context,iv));
    function getAes() {
        window.location.href ="http://localhost:8080/actionAes?rsaKey="+rsaKey+"&data="+context+"&rsaIV="+rsaIV;
    }
</script>
</html>
