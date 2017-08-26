// Adding action listener
document.getElementById("text-search")
		.addEventListener("keyup", function(event) {
	event.preventDefault();
	if (event.keyCode == 13) {
		document.location.href = "model/get/" + document.getElementById("text-search").value;
	}
})