let ls = document.querySelectorAll('.nav-link');
console.log(ls)

let absc = document.querySelector('#about');
console.log(absc)
console.log(absc.getAttribute('id'))
if (absc.getAttribute('id') === "about") {
	ls.forEach(e => {
		e.parentNode.setAttribute('class', "nav-item");
		if (e.innerText == 'About') {
			e.parentNode.setAttribute('class', "nav-item active")
		}
	})
}