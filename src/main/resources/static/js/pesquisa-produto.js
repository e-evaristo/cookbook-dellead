$(function () {
    
    /* let itemsVenda = [];

    $(document).on('keydown', '.autocomplete-produtos', function () {

        const linha_id = this.id.split('_')[1];

        $('#' + this.id).autocomplete({
            source: function (request, response) {
                $.ajax({
                    url: "/vendas/produtos",
                    type: 'get',
                    dataType: "json",
                    data: {
                        nome: request.term
                    },
                    success: function (data) {
                        response(data);
                    }
                });
            },
            select: function (event, ui) {
                let ocorrencias = 0;
                const nome_produto = ui.item.label.split(' - ')[1];
                const produto_id = ui.item.value.split(' - ')[0];
                $(this).val(nome_produto);

                $('#space-items > tr').each(function(index, tr) { 
                    if ( $(tr).find('input[name="produto_nome[]"]').val() === nome_produto ) {
                        ocorrencias++;
                    }
                });

                if (ocorrencias > 1) {
                    alert('O produto '+ nome_produto +' já foi adicionado.');
                    ocorrencias = 0;
                    document.getElementById('id_' + linha_id).value = '';
                    document.getElementById('produto_' + linha_id).value = '';
                    document.getElementById('valor_' + linha_id).value = '0,00';
                    document.getElementById('total_' + linha_id).value = '0,00';
                    updateFields();
                    return false;
                }

                $.ajax({
                    url: "/vendas/produto_detail",
                    type: 'get',
                    dataType: "json",
                    data: {
                        id: produto_id
                    },
                    success: function (data) {

                        let id = data['id'];
                        let nome = data['nome'];
                        let preco = data['preco'];
                        let qtd = document.getElementById('quantidade_' + linha_id).value;
                        
                        document.getElementById('id_' + linha_id).value = id;
                        document.getElementById('produto_' + linha_id).value = nome;
                        document.getElementById('valor_' + linha_id).value = parseFloat(preco).toFixed(2);
                        document.getElementById('total_' + linha_id).value = (parseInt(qtd) * parseFloat(preco)).toFixed(2);
                        updateFields();
                        addItemsVenda(id, nome, parseInt(qtd), preco);

                        $('#quantidade_' + linha_id).bind('change', function () {
                            document.getElementById('total_' + linha_id).value = (this.value * preco).toFixed(2);
                            updateFields();
                        });
                        
                    }
                });

                return false;
            }
        });
    });

    const addItemsVenda = function (id, nome, quantidade) {
        itemsVenda.push({
            id: id,
            nome: nome,
            quantidade: quantidade
        });
    }

    const updateFields = () => {
        let total = 0;
        $('#space-items > tr').each(function(index, tr) {
            total += parseFloat($(tr).find('input[name="total[]"]').val());
        });

        $('#total_venda').text(total.toLocaleString('pt-br', {minimumFractionDigits: 2}));
    }

    $(document).on('click', '.remove_product', function (e) {
        e.preventDefault();
        let selected_row = $(this).parent().parent();
        selected_row.remove();
        updateFields();
    }); */

    /*$(document).on('click', '.btn-salvar-venda', function (e) {
        e.preventDefault();
        let token = $('meta[name=\'_csrf\']').attr('content');
        let data = JSON.stringify({
            id: 1,
            items: itemsVenda,
        });
        $.ajax({
            url: '/vendas/store',
            type: 'post',
            headers: {'X-CSRF-TOKEN': token},
            contentType: "application/json",
            data: data,
            success: function (data) {
                if (data.success) {
                    alert('Venda realizada com sucesso!');
                } else {
                    alert('Erro ao realizar venda!');
                }
            }
        });
    });*/



});