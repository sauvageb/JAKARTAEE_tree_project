const displayMap = () => {
    let mapProp = {
        center: new google.maps.LatLng(51.508742, -0.120850),
        zoom: 5,
    };
    return new google.maps.Map(document.getElementById("googleMap"), mapProp);
}

const fetchTreeById = (id) => {
    return fetch(`http://localhost:8080/api/tree/${id}`).then(r => r.json());
}

function displayMarker(map, tree) {
    let marker = new google.maps.Marker({
        position: new google.maps.LatLng(tree.latitude, tree.longitude),
        title: 'title',
        map
    });
    let infowindow = new google.maps.InfoWindow();
    infowindow.setContent("title");
    marker.addListener('mouseover', function () {
        infowindow.open(map, this);
    });
}

function initMap(callback) {
    let map = displayMap();

    let url = new URLSearchParams(window.location.search);
    let treeId = url.get('id');

    fetchTreeById(treeId).then(tree => {
        let coordinates = new google.maps.LatLng(tree.latitude, tree.longitude);
        displayMarker(map, tree);
        map.panTo(coordinates);
    });

}

