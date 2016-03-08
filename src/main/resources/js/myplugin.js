// Standard sizes are 400, 600, 800 and 960 pixels wide
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
