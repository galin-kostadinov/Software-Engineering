function encodeAndDecodeMessages() {
    const encodeBtn = document.querySelectorAll('button')[0];
    const decodeBtn = document.querySelectorAll('button')[1];
    const sendArea = encodeBtn.parentNode.querySelector('textarea');
    const receiveArea = decodeBtn.parentNode.querySelector('textarea');

    document.addEventListener('click', handler);

    function handler(ev) {
        const { content, mapChar } = ev.target.textContent.includes('Encode')
            ? { content: sendArea.value, mapChar: x => x.charCodeAt() + 1 }
            : { content: receiveArea.value, mapChar: x => x.charCodeAt() - 1 };

        receiveArea.value = content
            .split('')
            .map(char => mapChar(char))
            .map(ascii => String.fromCharCode(ascii))
            .join('');
        sendArea.value = '';
    }
}