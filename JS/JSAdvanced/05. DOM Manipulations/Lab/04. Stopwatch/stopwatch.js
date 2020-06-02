function stopwatch() {
    const startBtn = document.querySelector('#startBtn');
    const stopBtn = document.querySelector('#stopBtn');
    const timeDiv = document.querySelector('#time');

    startBtn.addEventListener('click', start);
    stopBtn.addEventListener('click', stop);
    let indervalID;
    function start() {
        startBtn.setAttribute('disabled', 'true');
        stopBtn.removeAttribute('disabled');
        timeDiv.textContent = '00:00';
        let currentTime = timeDiv.textContent.split(':').map(el => Number(el));

        indervalID = setInterval(
            function () {
                currentTime[1]++;

                if (currentTime[1] === 60) {
                    currentTime[1] = 0;
                    currentTime[0]++;
                }
              
                let time = `${currentTime[0].toString().padStart(2, "0")}:${currentTime[1].toString().padStart(2, "0")}`;
                timeDiv.textContent = time;
              
            }, 1000
        );
    }

    function stop() {
        clearInterval(indervalID);
        startBtn.removeAttribute('disabled');
        stopBtn.setAttribute('disabled', 'true');
    }
}