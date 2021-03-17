function init() {
    let member_pic = document.getElementById("memberPic");
    let preview = document.getElementById("preview");

    member_pic.addEventListener('change', function(e) {
        let files = e.target.files;
        // console.log(files);

        if (files) {
            for (let i = 0; i < files.length; i++) {
                let file = files[i];
                if (file.type.indexOf('image') > -1) {
                    // console.log(file.name);
                    // console.log(file.size);
                    // console.log(file.type);

                    let reader = new FileReader();
                    reader.addEventListener('load', function(e) {
                    	let oldImg = document.querySelector("#preview img");
                    	if(oldImg){
                    		oldImg.remove();
                    	}
                    	
                        let result = e.target.result;
                        let img = document.createElement("img");
                        img.setAttribute('src', result);
                        img.setAttribute('style', "width:100px; height:100px");
                        preview.append(img);
                    });

                    reader.readAsDataURL(file);
                } else {
                    alert("請上傳圖片");
                }
            }
//            addPicJs();
//            showPic();
        }
    });

    

}

function showPic(){
	let preview = document.getElementById("preview");
	preview.classList.add('show');
	
}

function addPicJs(){
    // let jsSrc = `<link href="<%=request.getContextPath()%>/resources/css/sb-admin-2.min.css" rel="stylesheet">`;
    let jsSrc = document.createElement('link');
    jsSrc.setAttribute('href','/CEA102G311111/resources/css/register.css');
    jsSrc.setAttribute('rel','stylesheet');
    let title = document.getElementsByTagName("title");
    console.log("-------");
    console.log(jsSrc);
    title[0].before(jsSrc);
}

window.addEventListener('load', init);