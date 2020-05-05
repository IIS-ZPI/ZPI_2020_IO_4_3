$(document).ready(function () {
    $('#scrollableTable').DataTable({
        scrollY:        '50vh',
        scrollX:        true,
        scrollCollapse: true,
        paging:         false,
        info:           false,
        searching:      false,
    });
});
