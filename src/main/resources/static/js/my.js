var interval;

window.onload = function() {

	interval = window.setInterval("changeSecond()", 1000);

};

function changeSecond() {
	var second = document.getElementById("second");

	var svalue = second.innerHTML;

	svalue = svalue - 1;

	if (svalue == 0) {
		window.clearInterval(interval);

        location = "http://localhost:8080/";
		return;
	}

	second.innerHTML = svalue;
}
