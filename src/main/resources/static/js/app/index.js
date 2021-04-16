var main = {
    init: function(){
        var _this = this;
        $('#btn-save').on('click', function(){
            _this.save();
        });
    },
    save: function(){
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(){
            alert('글이 등록되었습니다.');
            window.location.herf = '/';
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    }
};
main.init();

// var main의 속성 내에 function을 추가한 이유가 있다!
// 만약 index.mustache에서 a.js가 추가되어 a.js도 init과 save function이 있다고 생각해보자.
// 브라우저의 scope는 공용 공간으로 쓰이기 때문에 나중에 로딩된 js의 init, save가 먼저 로딩된 fuction을 덮어쓴다.
// 특히 여러 사람이 참여하는 프로젝트에서 함수 이름이 중복되기 쉽기 때문에 index.js만의 유효범위를 만드는 것이 좋다.
// 그 방법은 위에서 확인했듯이 var index란 객페를 만들어 해당 객체에서 필요한 모든 function을 선언하는 것이다.
// 이렇게 하면 index 객체 안에서만 함수가 유효하기 때문에 다른 js랑 겹칠 위험이 사라진다.