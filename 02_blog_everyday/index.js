(function () {
    var imageUpload = function () {
        var self = this;
        this.selector = {
            fileInput: document.getElementById('imageUploadInput'),
            fileInputBtn: document.getElementById('imageUploadInputBtn'),
            imagePreview: document.getElementById('imagePreview'),
            status: document.getElementById('uploadFileStatus'),
            sendBtn: document.getElementById('sendData'),
            infoName: document.getElementById('fileInfomation_name'),
            infoType: document.getElementById('fileInfomation_type'),
            infoSize: document.getElementById('fileInfomation_size')
        };
        this.imageData = "";
        this.fileTypes = ['image/png', 'image/jpeg'];
        this.maxSize = 30 * 1024 * 1024; // 30MB
        this.uploadUrl = 'http://localhost:8080/api/users/File';
        this.onChangeInput = function (e) {
            // Reset file data / image preview
            self.selector.status.innerHTML = '';
            self.selector.imagePreview.setAttribute('src', "img/default.jpg");
            self.imageData='';

            // Get the current file upload
            var file = e.target.files[0];
            this.selector.infoName.innerHTML = file.name;
            this.selector.infoType.innerHTML = file.type;
            this.selector.infoSize.innerHTML = file.size + " bytes"; // in bytes

            // Validate file type
            if (this.fileTypes.indexOf(file.type) == -1) {
                self.selector.status.innerHTML = "File không hợp lệ (chỉ file hình jpg và hình png được chấp nhận)";
                return;
            }

            // Validate file size
            if (file.size > this.maxSize) {
                self.selector.status.innerHTML = "Dung lượng file vượt quá giới hạn (tối đa 30MB được chấp nhận)";
                return;
            }

            var reader = new FileReader();
            reader.onload = function (e) {
                self.imageData = e.target.result;

                // Validate file content
                self.selector.imagePreview.onerror = function(){
                    self.imageData = "";
                    self.selector.imagePreview.setAttribute('src', "img/default.jpg");
                    self.selector.status.innerHTML = 'Nội dung hình không hợp lệ';
                };
                self.selector.imagePreview.setAttribute('src', self.imageData);
            };
            reader.readAsDataURL(file);
        };
        this.sendData = function () {
            // Validate when file content is empty
            if (this.imageData == ""){
                self.selector.status.innerHTML = 'Vui lòng chọn hình để tải lên';
                return;
            }

            // Prevent double click
            var data = {
                'imageData': this.imageData
            };
            this.imageData = "";

            var request = new XMLHttpRequest();
            request.open("POST", this.uploadUrl);
            request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
            console.log(data)
            request.onreadystatechange = function () {
                if (this.readyState === 4 && this.status === 200) {
                    self.selector.status.innerHTML = "Upload thành công";
                } else {
                    console.log(this.responseText);
                    self.selector.status.innerHTML = "Đã có lỗi xảy ra, không upload được hình";
                }
            };

            // Send request to server
            request.send(JSON.stringify(data));
        };

        /*
         * Event trigger
         */
        this.selector.fileInput.addEventListener('change', function (e) {
            self.onChangeInput(e);
        });
        this.selector.fileInputBtn.addEventListener('click', function () {
            self.selector.fileInput.click();
        });
        this.selector.sendBtn.addEventListener('click', function () {
            self.sendData();
        });
    };
    window.addEventListener("DOMContentLoaded", function () {
        console.log('DOM is loaded');
        new imageUpload();
    });
})();