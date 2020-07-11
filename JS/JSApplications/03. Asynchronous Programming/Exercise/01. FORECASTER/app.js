function attachEvents() {
    const baseURL = "https://judgetests.firebaseio.com/locations.json";
    let todayWeatherUrl = "https://judgetests.firebaseio.com/forecast/today/{code}.json";
    let upcomingWeatherUrl = "https://judgetests.firebaseio.com/forecast/upcoming/{code}.json";

    const elements = {
        locationId() { return document.querySelector('#location') },
        forecast() { return document.querySelector('#forecast') },
        current() { return document.querySelector('#current') },
        upcoming() { return document.querySelector('#upcoming') },
        getWeatherBtn() { return document.querySelector('#submit') },
        currentDayDiv() { return document.querySelector('#current-day') },
        upcomingDaysDiv() { return document.querySelector('#next-days') },
        errorDiv() { return document.querySelector('#error-div') }
    };

    const symbols = {
        'Sunny': '&#x2600;',
        'Partly sunny': '&#x26C5;',
        'Overcast': '&#x2601;',
        'Rain': '&#x2614;',
        'Degrees': '&#176;'
    };

    elements.getWeatherBtn().addEventListener('click', getWeather);

    function getWeather(ev) {
        ev.preventDefault();
        const location = elements.locationId().value;
        elements.locationId().value = '';
        fetch(baseURL)
            .then((response) => response.json())
            .then((res) => res.find(el => el.name === location))
            .then((obj) => {
                const code = obj.code;
                const urlToday = todayWeatherUrl.replace('{code}', code);
                const urlUpcoming = upcomingWeatherUrl.replace('{code}', code);

                fetch(urlToday)
                    .then((response) => response.json())
                    .then((forecastObj) => createTodayWeatherEl(forecastObj));

                fetch(urlUpcoming)
                    .then((response) => response.json())
                    .then((forecastObj) => createUpcomingWeatherBlock(forecastObj));
            })
            .catch((error) => {
                if (elements.currentDayDiv()) {
                    elements.current().removeChild(elements.currentDayDiv());
                }

                if (elements.upcomingDaysDiv()) {
                    elements.upcoming().removeChild(elements.upcomingDaysDiv());
                }

                alert(error);
            });
    }

    function createTodayWeatherEl(forecastObj) {
        if (elements.currentDayDiv()) {
            elements.current().removeChild(elements.currentDayDiv());
        }

        if (elements.errorDiv()) {
            elements.forecast().removeChild(elements.errorDiv());
        }

        const low = forecastObj.forecast.low;
        const high = forecastObj.forecast.high;
        const condition = forecastObj.forecast.condition;
        const location = forecastObj.name;

        let conditionSymbol = symbols[condition];

        let forecastDiv = document.createElement('div');
        forecastDiv.classList.add('forecast');
        forecastDiv.setAttribute('id', 'current-day')

        let conditionSymbolSpan = document.createElement('span');
        conditionSymbolSpan.classList.add('condition');
        conditionSymbolSpan.classList.add('symbol');
        conditionSymbolSpan.innerHTML = conditionSymbol;

        forecastDiv.appendChild(conditionSymbolSpan);

        let conditionBlockSpan = document.createElement('span');
        conditionBlockSpan.classList.add('condition');

        let locationSpan = document.createElement('span');
        locationSpan.classList.add('forecast-data');
        locationSpan.textContent = location;

        let degSpan = document.createElement('span');
        degSpan.classList.add('forecast-data');
        degSpan.innerHTML = `${low}${symbols.Degrees}/${high}${symbols.Degrees}`;

        let conditionSpan = document.createElement('span');
        conditionSpan.classList.add('forecast-data');
        conditionSpan.textContent = condition;

        conditionBlockSpan.appendChild(locationSpan);
        conditionBlockSpan.appendChild(degSpan);
        conditionBlockSpan.appendChild(conditionSpan);

        forecastDiv.appendChild(conditionBlockSpan);

        elements.current().appendChild(forecastDiv);
        elements.forecast().style.display = "block";
    }

    function createUpcomingWeatherBlock(forecastObj) {
        if (elements.upcomingDaysDiv()) {
            elements.upcoming().removeChild(elements.upcomingDaysDiv());
        }

        let forecastDiv = document.createElement('div');
        forecastDiv.classList.add('forecast-info');
        forecastDiv.setAttribute('id', 'next-days')

        const location = forecastObj.name;
        const forecastsArr = forecastObj.forecast;

        for (let day of forecastsArr) {
            const low = day.low;
            const high = day.high;
            const condition = day.condition;
            let conditionSymbol = symbols[condition];

            forecastDiv.appendChild(createUpcomingSpan(condition, conditionSymbol, low, high));
        }

        elements.upcoming().appendChild(forecastDiv);
    }

    function createUpcomingSpan(condition, conditionSymbol, low, high) {
        let conditionSymbolSpan = document.createElement('span');
        conditionSymbolSpan.classList.add('symbol');
        conditionSymbolSpan.innerHTML = conditionSymbol;

        let degSpan = document.createElement('span');
        degSpan.classList.add('forecast-data');
        degSpan.innerHTML = `${low}${symbols.Degrees}/${high}${symbols.Degrees}`;

        let conditionSpan = document.createElement('span');
        conditionSpan.classList.add('forecast-data');
        conditionSpan.textContent = condition;

        let conditionBlockSpan = document.createElement('span');
        conditionBlockSpan.classList.add('upcoming');

        conditionBlockSpan.appendChild(conditionSymbolSpan);
        conditionBlockSpan.appendChild(degSpan);
        conditionBlockSpan.appendChild(conditionSpan);

        return conditionBlockSpan;
    }
}

attachEvents();