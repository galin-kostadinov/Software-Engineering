function attachEventsListeners() {
    const days = document.querySelector('#days');
    const hours = document.querySelector('#hours');
    const minutes = document.querySelector('#minutes');
    const seconds = document.querySelector('#seconds');

    document.querySelector('#daysBtn').addEventListener('click', onClick);
    document.querySelector('#hoursBtn').addEventListener('click', onClick);
    document.querySelector('#minutesBtn').addEventListener('click', onClick);
    document.querySelector('#secondsBtn').addEventListener('click', onClick);

    const ratios = {
        days: 1,
        hours: 24,
        minutes: 1440,
        seconds: 86400
    }

    function convert(value, from) {
        const inDays = value / ratios[from];

        return {
            days: inDays * ratios.days,
            hours: inDays * ratios.hours,
            minutes: inDays * ratios.minutes,
            seconds: inDays * ratios.seconds
        }
    }

    function onClick(ev) {
        const input = ev.target.parentElement.querySelector('input[type="text"]');
        const value = Number(input.value);
        const convertedValues = convert(value, input.id);
        display(convertedValues);
    }

    function display(values) {
        days.value = values.days;
        hours.value = values.hours;
        minutes.value = values.minutes;
        seconds.value = values.seconds;
    }
}
