$(function () {
    $('#editor').keyup(function () {
        const html = marked($(this).val());
        $('#preview').html(html);
    });
});
