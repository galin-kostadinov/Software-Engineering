function createArticle() {
	let title = document.getElementById('createTitle');
	let text = document.getElementById('createContent');

	if (title.value !== '' && text.value !== '') {
		let sectionArticle = document.getElementById('articles');

		let h = document.createElement('h3');
		h.textContent = title.value;

		let p = document.createElement('p');
		p.textContent = text.value;

		let article = document.createElement('article');
		article.appendChild(h);
		article.appendChild(p);
		sectionArticle.appendChild(article);

		title.value = '';
		text.value = '';
	}
}