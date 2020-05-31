function growingWord() {
  const colors = ['blue', 'green', 'red'];
  const text = document.querySelector('#exercise p');

  let size = Number(text.style.fontSize.slice(0, -2));

  const color = text.style.color;

  size === 0 ? size = 2 : size = size * 2;

  const colorIndex = colors.indexOf(color);
  const nextColor = colorIndex + 1 < colors.length ? colors[colorIndex + 1] : colors[0];

  text.style.cssText = `color: ${nextColor}; font-size: ${size}px`;
}