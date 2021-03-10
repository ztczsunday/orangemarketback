
$(() => {
    $("#B1").click(() => {
        $.ajax({
            method: "POST",
            url: 'http://localhost:8080/login',
            data: {
                "account": $("#I1").val(),
                "password": $("#I2").val()
            },
            success: (data) => {
                if (data === '') {
                    console.log('null');
                } else {
                    console.log("测试")
                    console.log(data);
                }
            }
        })
    });
})