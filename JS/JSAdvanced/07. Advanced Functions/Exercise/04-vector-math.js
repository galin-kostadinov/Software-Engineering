"use strict";

(() => {
    return {
        add: (vec1, vec2) => [vec1[0] + vec2[0], vec1[1] + vec2[1]],
        multiply: (vec1, num) => [vec1[0] * num, vec1[1] * num],
        length: (vec) => Math.sqrt(vec[0] ** 2 + vec[1] ** 2),
        dot: (vec1, vec2) => vec1[0] * vec2[0] + vec1[1] * vec2[1],
        cross: (vec1, vec2) => vec1[0] * vec2[1] - vec1[1] * vec2[0]
    };
})();
