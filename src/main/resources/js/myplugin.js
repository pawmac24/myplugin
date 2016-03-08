(function ($) {

    $(document).ready(function() {
        alert("This is myplugin javascript, path: " + AJS.contextPath());

        var dialog = new AJS.Dialog({
            width: 800,
            height: 500,
            id: "example-dialog",
            closeOnOutsideClick: true
        });

        dialog.addHeader("Dialog");

        dialog.addButton("Cancel", function (dialog) {
            dialog.hide();
        });

        dialog.show();
    });

})(AJS.$ || jQuery);