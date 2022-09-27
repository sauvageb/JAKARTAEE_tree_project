const displayMap = () => {
    let mapProp = {
        zoom: 13,
    };
    return new google.maps.Map(document.getElementById("googleMap"), mapProp);
}


function initMap(callback) {
    let map = displayMap();

    let marker = new google.maps.Marker({draggable: true, map});

    marker.addListener('position_changed', function () {
        document.getElementById("latitude").value = marker.position.lat();
        document.getElementById("longitude").value = marker.position.lng();
    });

    let coordinates = new google.maps.LatLng(48.862725, 2.287592);
    marker.setPosition(coordinates);
    map.panTo(coordinates);
}

