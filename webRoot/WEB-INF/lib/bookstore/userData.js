$(document).ready(function(){
    loaduserDatas();
});

function loaduserDatas() {
    $.getJSON("./userCenter").done(function(userDatas){
        updateUserDatasView(userDatas);
    }).fail(function(e){
        console.log(e);
    });
}

function updateUserDatasView(userDatas) {
    $("#UserDatasView").empty();
    for (var userData of userDatas) {
        var view = $(`
        <div class="col-md-3">
        <div class="form-group">
          <label>昵称</label>
          <input
            type="text"
            class="form-control"
            placeholder="Username"
            id="nickname"
          />
        </div>
      </div>   
`);
        // view.find("img").attr("src", "./image/upload/" + book.picture);
        view.find("input").append(userData.nickname);
        // view.find("p.price").append("作者：" + book.author + "， 价格：" + book.price);
        // view.find("p.content").append(book.content);
        $("#UserDatasView").append(view);
    }
}

// function updateBooksView2(books) {
//     var table = $("<table class='tb-book'></table>");
//     for (var book of books) {
//         var tr = $("<tr></tr>");
//         tr.append("<td>" + book.name + "</td>");
//         tr.append("<td>" + book.author + "</td>");
//         tr.append("<td>" + book.price + "</td>");
//         tr.append("<td>" + book.content + "</td>");
//         tr.append("<td><img src='./image/upload/" + book.picture + "'/></td>");
//         table.append(tr);
//     }
//     $("#booksView").empty().append(table);
// }