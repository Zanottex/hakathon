$("#enivarLogin").click(login);

function login(){
    let usuario = $("#usuario").val();
    let senha = $("#senha").val();

    $.ajax({
       type: "POST",
       url: "/login",
       data: {
           usuario: usuario,
           senha: senha,
       },
        success: function (data){
           alert("Deu bom");
        },
        error: function (){
           alert("Deu n");
        }
    });
}