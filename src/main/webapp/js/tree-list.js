const displayMap = () => {
    let mapProp = {
        center: new google.maps.LatLng(51.508742, -0.120850),
        zoom: 3
    };
    return new google.maps.Map(document.getElementById("googleMap"), mapProp);
}

const fetchTreeList = () => {
    return fetch(`http://localhost:8080/api/tree`).then(r => r.json());
}

function displayMarker(map, tree) {
    let marker = new google.maps.Marker({
        position: new google.maps.LatLng(tree.latitude, tree.longitude),
        title: 'title',
        map
    });
    let infowindow = new google.maps.InfoWindow();
    infowindow.setContent(`<h4>${tree.name}</h4><p><a href="/tree/details?id=${tree.id}" className="btn btn-success btn mx-2">Details</a></p>`);
    marker.addListener('mouseover', function () {
        infowindow.open(map, this);
    });
}

function initMap(callback) {
    let map = displayMap();

    fetchTreeList().then(treeList => {
        treeList.forEach(tree => {
            displayMarker(map, tree);
        })
    });

}

