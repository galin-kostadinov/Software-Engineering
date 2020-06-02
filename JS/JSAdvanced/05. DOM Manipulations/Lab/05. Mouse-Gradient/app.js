function attachGradientEvents() {
    const gradient = document.querySelector('#gradient');
    const result = document.querySelector('#result');

    gradient.addEventListener('mousemove', gradientMove);
    gradient.addEventListener('mouseleave', gradientOut);

    function gradientMove(ev) {
        let power = ev.offsetX / 3;
        power = Math.floor(power);
        result.textContent = power + "%";
    }

    function gradientOut(ev) {
        result.textContent = '';
    }
}