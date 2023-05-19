let lastClickedId = null;

function Alternar(id) {
	let ul = document.getElementById(id);
	if (lastClickedId !== id) {
		let lastClickedUl = document.getElementById(lastClickedId);
		if (lastClickedUl) {
			lastClickedUl.style.display = 'none';
		}
		ul.style.display = '';
		lastClickedId = id;
	} else {
		ul.style.display = ul.style.display === 'none' ? '' : 'none';
	}
}