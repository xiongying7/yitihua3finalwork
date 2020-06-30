(function() {
    $(document).ready(function() {
        $('.blue').on('click', function() {
            return $('#cube').removeClass().addClass('show-front');
        });
        $('.teal').on('click', function() {
            return $('#cube').removeClass().addClass('show-back');
        });
        $('.green').on('click', function() {
            return $('#cube').removeClass().addClass('show-left');
        });
        $('.yellow').on('click', function() {
            return $('#cube').removeClass().addClass('show-right');
        });
        $('.orange').on('click', function() {
            return $('#cube').removeClass().addClass('show-top');
        });
        return $('.pink').on('click', function() {
            return $('#cube').removeClass().addClass('show-bottom');
        });
    });

}).call(this);