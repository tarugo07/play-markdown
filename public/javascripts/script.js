$(function () {
    $('#editor').keyup(function () {
        const html = marked($(this).val());
        $('#preview').html(html);
    });

    $('#a-html').click(function () {
        $.ajax({
            url: 'markdown',
            type: 'POST',
            data: {markdown: $('#editor').val()}
        }).done(function (data) {
            const dummy = $('<pre>').text(data);
            $('#html').html(dummy);
        });
    });
});
