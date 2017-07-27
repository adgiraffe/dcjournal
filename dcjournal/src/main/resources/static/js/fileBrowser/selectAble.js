function selectAble() {
    $('.uploadedList').children('li').click(function () {
        $(this).addClass('selected');
    });
}

function getImage() {
    console.log('hi');
    var classArray = [];
    var numList = [];
    var num = 0;
    classArray = document.getElementsByClassName('selected');

    console.log('시작 : ');
    for (var i = 0; i < classArray.length; i++) {
        num = classArray[i].firstChild.getAttribute('name');
        console.log(num);
        numList[i] = num;
    }
    console.log(numList);
    return numList;
}

function sendNumList() {
    var numList=[];
    numList=getImage();
    $.ajax({
        url:'/selectOneNum',
        data:numList,
        dataType:'int',
        processData:false,
        contentType:false,
        type:'POST',
        success:function (rliList) {
            
        }
    })
}