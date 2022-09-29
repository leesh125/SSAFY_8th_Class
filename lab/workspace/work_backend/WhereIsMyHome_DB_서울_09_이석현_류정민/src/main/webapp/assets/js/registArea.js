window.onload = function() {
	// 브라우저가 열리면 시도정보 얻기.
	sendRequest("sido", "*00000000");
};

// 시도가 바뀌면 구군정보 얻기.
document.querySelector("#sido").addEventListener("change", function() {
	if (this[this.selectedIndex].value) {
		let regcode = this[this.selectedIndex].value.substr(0, 2) + "*00000";
		sendRequest("gugun", regcode);
	} else {
		initOption("gugun");
		initOption("dong");
	}
});

// 구군이 바뀌면 동정보 얻기.
document.querySelector("#gugun").addEventListener("change", function() {
	if (this[this.selectedIndex].value) {
		let regcode = this[this.selectedIndex].value.substr(0, 5) + "*";
		sendRequest("dong", regcode);
	} else {
		initOption("dong");
	}
});
let dongCode = '';
document.querySelector("#dong").addEventListener("change", function() {
	if (this[this.selectedIndex].value) {
		dongCode = this[this.selectedIndex].value.substr(0, 8) + "00";
		
	}
});


function sendRequest(selid, regcode) {
	const url = "https://grpc-proxy-server-mkvo6j4wsq-du.a.run.app/v1/regcodes";
	let params = "regcode_pattern=" + regcode + "&is_ignore_zero=true";
	fetch(`${url}?${params}`)
		.then((response) => response.json())
		.then((data) => addOption(selid, data));
}

function addOption(selid, data) {
	let opt = ``;
	initOption(selid);
	switch (selid) {
		case "sido":
			opt += `<option value="">시/도 선택</option>`;
			data.regcodes.forEach(function(regcode) {
				opt += `
              <option value="${regcode.code}">${regcode.name}</option>
              `;
			});
			break;
		case "gugun":
			opt += `<option value="">구/군 선택</option>`;
			for (let i = 0; i < data.regcodes.length; i++) {
				if (i != data.regcodes.length - 1) {
					if (
						data.regcodes[i].name.split(" ")[1] == data.regcodes[i + 1].name.split(" ")[1] &&
						data.regcodes[i].name.split(" ").length !=
						data.regcodes[i + 1].name.split(" ").length
					) {
						data.regcodes.splice(i, 1);
						i--;
					}
				}
			}
			let name = "";
			data.regcodes.forEach(function(regcode) {
				if (regcode.name.split(" ").length == 2) name = regcode.name.split(" ")[1];
				else name = regcode.name.split(" ")[1] + " " + regcode.name.split(" ")[2];
				opt += `
              <option value="${regcode.code}">${name}</option>
              `;
			});
			break;
		case "dong":
			opt += `<option value="">동 선택</option>`;
			let idx = 2;
			data.regcodes.forEach(function(regcode) {
				if (regcode.name.split(" ").length != 3) idx = 3;
				opt += `
              <option value="${regcode.code}">${regcode.name.split(" ")[idx]}</option>
              `;
			});
	}
	document.querySelector(`#${selid}`).innerHTML = opt;
}

function initOption(selid) {
	let options = document.querySelector(`#${selid}`);
	options.length = 0;
	// let len = options.length;
	// for (let i = len - 1; i >= 0; i--) {
	//   options.remove(i);
	// }
}