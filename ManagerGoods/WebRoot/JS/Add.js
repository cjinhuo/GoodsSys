function loadFile() {
    selectInit()
    initEXPDays()
}
//init number of stock
function selectInit() {
    var root = document.formContent.stock;
    for (var i = 0; i <= 100; i++) {
        var e = document.createElement('option');
        e.value = i
        e.text = i;
        root.add(e, null)
    }
}

function initEXPDays() {
    var root = document.formContent.EXP
    for (var i = 1; i <= 104; i++) {
        var e = document.createElement('option')
        e.value = i
        e.text = i + "周";
        root.add(e, null)
    }
}