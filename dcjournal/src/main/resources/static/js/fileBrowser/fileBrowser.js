/**
 * Created by joo on 2017. 7. 2..
 */
function loadImage() {

    // var file=document.getElementById('imageLoader1').files[0];
    // if (file){
    //     var reader=new FileReader();
    //     reader.readAsText(file);
    //     reader.onload=function (e) {
    //         alert(e.target.result);
    //     }
    // }
    var file=document.getElementById('imageLoader1');
    var fileName=file.files[0].name;
    var fileSize=file.files[0].size;
    var fileUrl=file.files[0].uri;
    alert(fileName);
    alert(fileSize);

    opener.tinymce.activeEditor.execCommand("mceInsertContent",'false',fileUrl);

}






