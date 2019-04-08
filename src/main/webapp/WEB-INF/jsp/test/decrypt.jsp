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
        function getDecrypt(rsaKey,rsaIV,aesData) {
            var key = decrypt(rsaKey);
            var iv = decrypt(rsaIV);
            var data = AESDec(key,aesData,iv);
            document.getElementById("data").value = data;
        }
</script>
    <input type="button" onclick="getDecrypt(${rsaKey},${rsaIV},${aesData})" value="解密数据">
    <ul>
        <li>加密数据</li>
        <li>${aesData}</li>
        <li>解密数据</li>
        <li id="data">${data}</li>
    </ul>
</html>
