function getArticleGenerator(articles) {
    const contentDiv = document.querySelector('#content');

    let index = 0;

    return function () {
        if (index < articles.length) {
            let article = document.createElement('article');
            article.textContent = articles[index];
            contentDiv.appendChild(article);
            index++;
        }
    }
}