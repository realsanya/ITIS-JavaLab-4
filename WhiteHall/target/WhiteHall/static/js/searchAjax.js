$("#search_form").submit(function (event) {
    event.preventDefault();
    let json = {
        'input': $("#inputSearch").val(),
        // 'filter': $('input[name=filter]:checked').val()
    }
    $.ajax({
        url: "/search",
        type: "POST",
        contentType: "application/json;charset=UTF-8",
        data: JSON.stringify(json),
        dataType: "json",
        success: function (data) {
            $('#results').html('');
            data.forEach(function (member) {
                $('#results').append($(
                    '<div class="col-xs-6 col-sm-4 col-md-4">' +
                    '<div class="card border-white" style="height: 300px; margin-top: 10px; overflow-y: auto">' +
                    '<div class="card-body text-center">' +
                    '<div class="row" style="display: flex; align-items: center;">' +
                    '<div class="col-lg-7">'+
                    '<h5 class="text-left" style="color: #6F99E8; font-size: 32px;">' +  member['first_name'] + '</h5>'+
                    '</div>' +
                    '<div class="col">'+
                    '<span class="text-right" style="color: #484D50; font-size: 12px; font-weight: 700;">' +  member['role_id']['name'] + '</span>' +
                    '</div>'+
                    '</div>' +
                    '<div class="row">' +
                    '<div class="col text-justify">' +
                    '<small>' + member['text'] + '</small>' +
                    '</div>' +
                    '</div>' +
                    '</div>' +
                    '</div>' +
                    '</div>'))
            });
        }
    });
});