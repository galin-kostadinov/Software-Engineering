function attachEventsListeners() {
    const convertButton = document.querySelector('#convert');
    const selectedFromUnits = document.querySelector('#inputUnits');
    const selectedToDistance = document.querySelector('#outputUnits');
    const inputDistance = document.querySelector('#inputDistance');
    const outputDistance = document.querySelector('#outputDistance');

    convertButton.addEventListener('click', convert);

    function convert(ev) {
        const inputValue = Number(inputDistance.value);

        const from = selectedFromUnits.value;
        const to = selectedToDistance.value;

        let valueInMeters = convertToMeters(from, inputValue);
        let result = convertFromMeters(to, valueInMeters);

        outputDistance.value = result;

    }

    function convertToMeters(fromUnit, value) {
        units = {
            km: (x) => x * 1000,
            m: (x) => x,
            cm: (x) => x * 0.01,
            mm: (x) => x * 0.001,
            mi: (x) => x * 1609.34,
            yrd: (x) => x * 0.9144,
            ft: (x) => x * 0.3048,
            in: (x) => x * 0.0254
        };

        return units[fromUnit](value);
    }

    function convertFromMeters(toUnit, value) {
        units = {
            km: (x) => x / 1000,
            m: (x) => x,
            cm: (x) => x / 0.01,
            mm: (x) => x / 0.001,
            mi: (x) => x / 1609.34,
            yrd: (x) => x / 0.9144,
            ft: (x) => x / 0.3048,
            in: (x) => x / 0.0254
        };

        return units[toUnit](value);
    }
}