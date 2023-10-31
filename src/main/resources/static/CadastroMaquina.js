$("#enviarCadastroMaquina").click(CM);

function CM(){
    let nome = $("#nome").val();
    let modelo = $("#modelo").val();
    let numeroserie = $("#numeroserie").val();
    let setor = $("#setor").val();

    $.ajax({
        type: "POST",
        url: "/cadastro",
        data: {
            nome: nome,
            modelo: modelo,
            numeroserie: numeroserie,
            setor: setor,
        },
        success: function (data){
            alert("Deu bom");
        },
        error: function (){
            alert("Deu n");
        }
    });
}