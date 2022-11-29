let date = new Date();

var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
var options = { //지도를 생성할 때 필요한 기본 옵션
	center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
	level: 3
	//지도의 레벨(확대, 축소 정도)
};

var map;
var markers = [];
selectedMarker = null; // 클릭한 마커를 담을 변수

window.onload = function() {

	map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴	

	// 브라우저가 열리면 시도정보 얻기.
	sendRequest("large", "");
};

// 대분류가 바뀌면 중분류 얻기.
document.querySelector("#large").addEventListener("change", function() {
	if (this[this.selectedIndex].value) {
		let industCode = this[this.selectedIndex].value;
		sendRequest("medium", industCode);
	} else {
		initOption("medium");
		initOption("small");
	}
});

// 중분류가 바뀌면 소분류 얻기.
document.querySelector("#medium").addEventListener("change", function() {
	if (this[this.selectedIndex].value) {
		let industCode = this[this.selectedIndex].value;
		sendRequest("small", industCode);
	} else {
		initOption("small");
	}
});

// 소분류 선택하면 상권정보 가져오기
document.querySelector("#small").addEventListener("change", function() {
	if (this[this.selectedIndex].value) {
		let industCode = this[this.selectedIndex].value;
		getStore(industCode);
	}
});

// 업종별 상권정보 가져오기
function getStore(industCode) {
	const url = "http://localhost:8080/WhereIsMyHome/area/store/list.do";

	let params = "industCode=" + industCode;

	fetch(`${url}?${params}`)
		.then((response) => response.json())
		.then((data) => moveMap(data));
}

function sendRequest(selid, industCode) {
	const url = "http://localhost:8080/WhereIsMyHome/indust/code.do";
	let params = "industCode=" + industCode;
	fetch(`${url}?${params}`)
		.then((response) => response.json())
		.then((data) => addOption(selid, data));
}

function addOption(selid, data) {
	let opt = ``;
	initOption(selid);

	switch (selid) {
		case "large":
			opt += `<option value="">대분류선택</option>`;
			break;
		case "medium":
			opt += `<option value="">중분류선택</option>`;
			break;
		case "small":
			opt += `<option value="">소분류선택</option>`;
	}

	data.forEach(function(indust) {
		opt += `
              <option value="${indust.code}">${indust.name}</option>
              `;
	});

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
function moveMap(data) {
	// 이동할 위도 경도 위치를 생성합니다 
	var moveLatLon = new kakao.maps.LatLng(37.6837277, 127.0318174); // 초기 설정 위치

	// 지도 중심을 부드럽게 이동시킵니다
	// 만약 이동할 거리가 지도 화면보다 크면 부드러운 효과 없이 이동합니다
	map.panTo(moveLatLon);

	makeStoreList(data)
}

// 상권정보 리스트 생성
function makeStoreList(data) {
	// 상권정보 뿌려주기!

	initStores();
	let hdiv = document.querySelector("#storeList");

	// 조회된 상권정보가 없는 경우
	if (data.length == 0) {
		var div = document.createElement('div');
		div.classList.add("border-top", "p-3", "apt");
		var msg = document.createElement('p');
		msg.appendChild(document.createTextNode("상권 정보가 없습니다."));
		div.appendChild(msg);
		hdiv.appendChild(div);
		return;
	}

	// 이동할 위도 경도 위치를 생성합니다 
	var moveLatLon = new kakao.maps.LatLng(data[0].lat, data[0].lng);
	// 지도 중심을 부드럽게 이동시킵니다
	// 만약 이동할 거리가 지도 화면보다 크면 부드러운 효과 없이 이동합니다
	map.panTo(moveLatLon);

	// 조회된 상권정보가 있는 경우
	data.forEach((store) => {
		console.log(store);
		var div = document.createElement('div');
		div.classList.add("border-top", "p-3", "apt");

		var a = document.createElement('a');
		a.classList.add("btn", "p-0");

		let h4 = document.createElement("h4");
		h4.appendChild(document.createTextNode(`${store.storeName} ${store.placeName}`));
		a.appendChild(h4);
		
		// 항목 클릭시 지도 이동
		a.addEventListener("click", function(){
			var moveLatLon = new kakao.maps.LatLng(store.lat, store.lng);
			map.panTo(moveLatLon);
		});
		
		div.appendChild(a);

		var pType = document.createElement('p');
		pType.appendChild(document.createTextNode(`${store.standardName}`));
		div.appendChild(pType);

		var pAddress = document.createElement('p');
		var i = document.createElement('i');
		i.innerHTML = `<i class="fa-solid fa-location-dot"></i>`;
		pAddress.appendChild(i);
		
		pAddress.appendChild(document.createTextNode(` ${store.address}`));
		div.appendChild(pAddress);

		var pPost = document.createElement('p');
		pPost.classList.add("text-muted");

		var i = document.createElement('i');
		i.innerHTML = `<i class="fa-solid fa-signs-post"></i>`;
		pPost.appendChild(i);

		pPost.appendChild(document.createTextNode(` 우편번호: ${store.postCode}`));
		div.appendChild(pPost);

		hdiv.appendChild(div);

		makeMarker(store);
	});

	showMarkers();
}


function initStores() {
	// 초기화
	hideMarkers();
	markers.length = 0;
	let hdiv = document.querySelector("#storeList");
	hdiv.innerHTML = "";
}

function makeMarker(store) {
	// 마커를 생성합니다
	var marker = new kakao.maps.Marker({
		map: map, // 마커를 표시할 지도
		position: new kakao.maps.LatLng(parseFloat(store.lat), parseFloat(store.lng)) // 마커의 위치
	});
	markers.push(marker);

	// 마커에 표시할 인포윈도우를 생성합니다 
	var infowindow = new kakao.maps.InfoWindow({
		content: `	<div style="padding:5px; height:auto;">	
						<b> ${store.storeName} </b>
						<div> ${store.standardName} </div>
					</div>`, // 인포윈도우에 표시할 내용

	});

	// 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
	// 이벤트 리스너로는 클로저를 만들어 등록합니다 
	// for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
	kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
	kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));

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