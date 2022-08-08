$(document).ready(function () {
    $('.cpf').mask("000.000.000-00");
    $('.date').mask("00/00/0000");
    $('.fone').mask("(00)00000-0000");
    $('.cep').mask("00000-000");
    $('.money').mask('#.##0,00', { reverse: true });

    function confirmDialog(message) {
        Swal.fire({
            title: 'Tem certeza?',
            text: message,
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Sim!'
        })
    }

    $('#btn-emitir-venda').on('click',function(e){
        e.preventDefault();
        var form = $(this).parents('form');
        Swal.fire({
            title: "Tem certeza que deseja emitir esta venda?",
            icon: "warning",
            showCancelButton: true,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: '#d33',
            confirmButtonText: "SIM"
        }).then((result) => {
            if (result.value) {
                form.submit();
            }
        });
    });

    $('#btn-cancelar-venda').on('click',function(e){
        e.preventDefault();
        var form = $(this).parents('form');
        Swal.fire({
            title: "Tem certeza que deseja CANCELAR esta venda?",
            icon: "warning",
            showCancelButton: true,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: '#d33',
            confirmButtonText: "SIM"
        }).then((result) => {
            if (result.value) {
                form.submit();
            }
        });
    });

    
});