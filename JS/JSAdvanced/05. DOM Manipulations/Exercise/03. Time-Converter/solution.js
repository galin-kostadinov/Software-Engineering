function attachEventsListeners() {
    let days = 0;
    let hours = 0;
    let minute = 0;
    let seconds = 0;

    const daysBtn = document.querySelector('#daysBtn');
    const daysInput = document.querySelector('#days');

    const hoursBtn = document.querySelector('#hoursBtn');
    const hoursInput = document.querySelector('#hours');

    const minutesBtn = document.querySelector('#minutesBtn');
    const minutesInput = document.querySelector('#minutes');

    const secondsBtn = document.querySelector('#secondsBtn');
    const secondsInput = document.querySelector('#seconds');

    daysBtn.addEventListener('click', calcFromDays);
    hoursBtn.addEventListener('click', calcFromHours);
    minutesBtn.addEventListener('click', calcFromMinutes);
    secondsBtn.addEventListener('click', calcFromSeconds);

    function calcFromDays(ev) {
        let days = Number(daysInput.value);

        if (days) {
            hours = 24 * days;
            minute = hours * 60;
            seconds = minute * 60;

            hoursInput.value = hours;
            minutesInput.value = minute;
            secondsInput.value = seconds;
        }
    }

    function calcFromHours(ev) {
        let hours = Number(hoursInput.value);

        if (hours) {
            days = hours / 24;
            minute = hours * 60;
            seconds = minute * 60;

            daysInput.value = days;
            minutesInput.value = minute;
            secondsInput.value = seconds;
        }
    }

    function calcFromMinutes(ev) {
        let minute = Number(minutesInput.value);

        if (minute) {
            days = minute / (24 * 60);
            hours = minute / 60;
            seconds = minute * 60;

            daysInput.value = days;
            hoursInput.value = hours;
            secondsInput.value = seconds;
        }
    }

    function calcFromSeconds(ev) {
        let seconds = Number(secondsInput.value);

        if (seconds) {
            days = seconds / (24 * 60 * 60);
            hours = seconds / (60 * 60);
            minute = seconds / 60;

            daysInput.value = days;
            hoursInput.value = hours;
            minutesInput.value = minute;
        }
    }
}