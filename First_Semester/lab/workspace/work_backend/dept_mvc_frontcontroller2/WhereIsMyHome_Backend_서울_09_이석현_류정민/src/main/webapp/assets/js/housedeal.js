let date = new Date();

var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
var options = { //지도를 생성할 때 필요한 기본 옵션
	center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
	level: 5
	//지도의 레벨(확대, 축소 정도)
};

var map;
var markers = [];
selectedMarker = null; // 클릭한 마커를 담을 변수

window.onload = function() {

	map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴	

	// 브라우저가 열리면 시도정보 얻기.
	sendRequest("sido", "*00000000");
};

/*
document.querySelector("#year").addEventListener("change", function() {
	let month = date.getMonth() + 1;
	let monthEl = document.querySelector("#month");
	let monthOpt = `<option value="">매매월선택</option>`;
	let yearSel = document.querySelector("#year");
	// 현재 선택한 년도를 가ㅕ옴ㅁㅁㅁ
	let m = yearSel[yearSel.selectedIndex].value == date.getFullYear() ? month : 13;
	for (let i = 1; i < m; i++) {
		monthOpt += `<option value="${i < 10 ? "0" + i : i}">${i}월</option>`;
	}
	monthEl.innerHTML = monthOpt;
});
*/

// https://juso.dev/docs/reg-code-api/
// let url = "https://grpc-proxy-server-mkvo6j4wsq-du.a.run.app/v1/regcodes";
// let regcode = "*00000000";
// 전국 특별/광역시, 도
// https://grpc-proxy-server-mkvo6j4wsq-du.a.run.app/v1/regcodes?regcode_pattern=*00000000

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

document.querySelector("#dong").addEventListener("change", function() {
	if (this[this.selectedIndex].value) {
		let regcode = this[this.selectedIndex].value.substr(0, 8);
		getHouseDeal("dong", regcode + "00");
	}
});

// 동별 거래정보 가져오기
function getHouseDeal(selid, dongCode) {
	/*)var dongCode = null;
	switch (selid) {
		case "sido":
			dongCode = regcode.substr(0, 2) + "_".repeat(8);
			break;
		case "gugun":
			dongCode = regcode.substr(0, 5) + "_".repeat(5);
			break;
		case "dong":
			dongCode = regcode.substr(0, 8) + "_".repeat(2);			
	}*/
	console.log("동코드", dongCode);
	const url = "http://localhost:8080/WhereIsMyHome/apt/latlng.do";

	let params = "dongCode=" + dongCode;

	fetch(`${url}?${params}`)
		.then((response) => response.json())
		.then((data) => moveMap(dongCode, data));
}

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
			opt += `<option value="">시도선택</option>`;
			data.regcodes.forEach(function(regcode) {
				opt += `
              <option value="${regcode.code}">${regcode.name}</option>
              `;
			});
			break;
		case "gugun":
			opt += `<option value="">구군선택</option>`;
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
			opt += `<option value="">동선택</option>`;
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

// 지도 위치 변경
function moveMap(dongCode, data) {
	// 이동할 위도 경도 위치를 생성합니다 
	var moveLatLon = new kakao.maps.LatLng(data.lat, data.lng);

	// 지도 중심을 부드럽게 이동시킵니다
	// 만약 이동할 거리가 지도 화면보다 크면 부드러운 효과 없이 이동합니다
	map.panTo(moveLatLon);

	// 거래정보 가져오기
	const url = "http://localhost:8080/WhereIsMyHome/apt/dong/list.do";
	let params = "dongCode=" + dongCode;

	fetch(`${url}?${params}`)
		.then((response) => response.json())
		.then((data) => makeHousedealList(data));
}

// 거래정보 리스트 생성
function makeHousedealList(data) {
	console.log("데이터가져옴");
	console.log("housedealList", data.length);

	initHouseDeals();
	let hdiv = document.querySelector("#housedealList");

	// 조회된 거래정보가 없는 경우
	if (data.length == 0) {
		var div = document.createElement('div');
		div.classList.add("border-top", "p-3", "apt");
		var msg = document.createElement('p');
		msg.appendChild(document.createTextNode("거래 정보가 없습니다."));
		div.appendChild(msg);
		hdiv.appendChild(div);
		return;
	}

	// 이동할 위도 경도 위치를 생성합니다 
	var moveLatLon = new kakao.maps.LatLng(data[0].lat, data[0].lng);

	// 지도 중심을 부드럽게 이동시킵니다
	// 만약 이동할 거리가 지도 화면보다 크면 부드러운 효과 없이 이동합니다
	map.panTo(moveLatLon);

	// 조회된 거래정보가 있는 경우
	data.forEach((housedeal) => {
		console.log(housedeal);
		var div = document.createElement('div');
		div.classList.add("border-top", "p-3", "apt");

		var a = document.createElement('a');
		a.classList.add("btn", "p-0");

		let h4 = document.createElement("h4");
		h4.appendChild(document.createTextNode(housedeal.aptName));
		a.appendChild(h4);

		div.appendChild(a);

		var pPrice = document.createElement('p');
		pPrice.appendChild(document.createTextNode(`거래금액 : ${housedeal.dealAmount}`));
		div.appendChild(pPrice);

		var pArea = document.createElement('p');
		pArea.appendChild(document.createTextNode(`면적 : ${housedeal.area}`));
		div.appendChild(pArea);

		var pDate = document.createElement('p');
		pDate.classList.add("text-muted");

		var i = document.createElement('i');
		i.innerHTML = '<i class="fa fa-calendar-days" aria-hidden="true"></i>';
		pDate.appendChild(i);

		pDate.appendChild(document.createTextNode(` ${housedeal.dealYear}.${housedeal.dealMonth}.${housedeal.dealday}`));
		div.appendChild(pDate);

		hdiv.appendChild(div);

		makeMarker(housedeal);
	});
	showMarkers();
}

///////////////////////// 아파트 매매 정보 /////////////////////////
document.querySelector("#searchBtn").addEventListener("click", function() {
	console.log("검색");
	const url = "http://localhost:8080/WhereIsMyHome/apt/apt/list.do";
	let aptName = document.getElementById("aptName").value;

	console.log("아파트명", aptName);
	if (""== aptName) {
		alert("아파트명을 입력해주세요!");
		return;
	}

	let params = "aptName=" + aptName;
	console.log("아파트명--", params);

	fetch(`${url}?${params}`)
		.then((response) => response.json())
		.then((data) => makeHousedealList(data));
});


function initHouseDeals() {
	console.log("초기화");
	hideMarkers();
	markers.length = 0;
	console.log("markers", markers);
	let hdiv = document.querySelector("#housedealList");
	hdiv.innerHTML = "";
}

function makeMarker(housedeal) {
	console.log("마커 생성");

	// 마커를 생성합니다
	var marker = new kakao.maps.Marker({
		map: map, // 마커를 표시할 지도
		position: new kakao.maps.LatLng(parseFloat(housedeal.lat), parseFloat(housedeal.lng)) // 마커의 위치
	});
	markers.push(marker);

	// 마커에 표시할 인포윈도우를 생성합니다 
	var infowindow = new kakao.maps.InfoWindow({
		content: `	<div style="padding:5px; height:auto;">	
						<b> ${housedeal.aptName} </b>
						<div> 거래: ${housedeal.dealAmount}만원 </div>
					</div>` // 인포윈도우에 표시할 내용
	});

	// 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
	// 이벤트 리스너로는 클로저를 만들어 등록합니다 
	// for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
	kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
	kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
	
	/*
	// 마커에 click 이벤트를 등록합니다
    kakao.maps.event.addListener(marker, 'click', function() {

        // 클릭된 마커를 현재 클릭된 마커 객체로 설정합니다
        selectedMarker = marker;
    });*/
}

// 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
function makeOverListener(map, marker, infowindow) {
	return function() {
		infowindow.open(map, marker);
	};
}

// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
function makeOutListener(infowindow) {
	return function() {
		infowindow.close();
	};
}

// 배열에 추가된 마커들을 지도에 표시하거나 삭제하는 함수
function setMarkers(map) {
    for (var i = 0; i < markers.length; i++) {
        markers[i].setMap(map);
    }            
}

// 마커 보이기
function showMarkers() {
    setMarkers(map)    
}

// 마커 감추기
function hideMarkers() {
    setMarkers(null);    
}